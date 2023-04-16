package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.util.zstd.ZSTDOutBuffer;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class completeEP extends Circle {

    //    List<Vector3f> vertices;
    List<Integer> index;
    int ibo;

    public completeEP(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius) {
        super(shaderModuleDataList, vertices, color, center, radius);
        this.vertices = vertices;
        this.center = center;
        this.radius = radius;
        createEllipticParaboloid();
        setupVAOVBO();
    }
    // coba 1 kebentuk tapi terlalo bulet
    public void createEllipticParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        int stackCount = 12, sectorCount = 36;

        float x, y, z, xy, nx, ny, nz;
        float sectorStep = (float) ( 2*Math.PI) / sectorCount; // sector count
        float stackStep = (float) (  0.999*radius.y) / stackCount; // stack count
        float sectorAngle, stackHeight;

        for (int i = 0; i <= stackCount; i++) {
            stackHeight = i * stackStep ;
            xy = (float) Math.sqrt(1 - Math.pow(stackHeight / radius.y, 2)) * radius.x;
            for (int j = 0; j < sectorCount; j++) {
                sectorAngle = j * sectorStep - radius.y;
                x = xy * (float) Math.cos(sectorAngle);
                y = xy * (float) Math.sin(sectorAngle);
                z = stackHeight;
                temp.add(new Vector3f(x, y, z).add(center));
            }
        }

        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for (int i = 0; i < stackCount; i++) {
            k1 = i * (sectorCount + 0);
            k2 = k1 + sectorCount + 0;

            for (int j = 0; j < sectorCount; ++j, ++k1, ++k2) {
                if (i != stackCount) {
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1 + 1);
                }
                if (i != 0) {
                    temp_indices.add(k2 + 1);
                    temp_indices.add(k2);
                    temp_indices.add(k1 + 1);
                }
            }
        }

        this.index = temp_indices;

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void drawIndices(Camera camera, Projection projection) {
        drawSetup(camera, projection);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLE_FAN, index.size(), GL_UNSIGNED_INT, 0);
    }
}
