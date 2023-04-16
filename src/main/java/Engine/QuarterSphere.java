package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class QuarterSphere extends Circle {

    List<Integer> index;
    int ibo;

    public QuarterSphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius) {
        super(shaderModuleDataList, vertices, color, center, radius);
        this.vertices = vertices;
        this.center = center;
        this.radius = radius;
        createSphere();
        setupVAOVBO();

    }

    public void createSphere() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

//        int stackCount = 36, sectorCount = 108;
        int stackCount = 12, sectorCount = 36;

        float x, y, z, xy, nx, ny, nz;
        float sectorStep = (float) (0.5 * Math.PI) / sectorCount; //sector count
        float stackStep = (float) Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for (int i = 0; i <= stackCount; i++) {
            stackAngle = (float) Math.PI / 2 - i * stackStep;
            xy = 0.5f * (float) Math.cos(stackAngle);
            z = 0.5f * (float) Math.sin(stackAngle);
            for (int j = 0; j < sectorCount; j++) {
                sectorAngle = j * sectorStep;
                x = xy * (float) Math.cos(sectorAngle);
                y = xy * (float) Math.sin(sectorAngle);
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for (int i = 0; i < stackCount; i++) {
            k1 = i * (sectorCount + 0);
            k2 = k1 + sectorCount + 0;

            for (int j = 0; j < sectorCount; ++j, ++k1, ++k2) {
                if (i != 0) {
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1 + 1);
                }
                if (i != (36 / 2) || i != (12 / 2)) {
                    temp_indices.add(k1 + 1);
                    temp_indices.add(k2);
                    temp_indices.add(k2 + 1);
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
//        element buffer object gausa gl array
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
//        glDrawElements(GL_LINE_LOOP, index.size(), GL_UNSIGNED_INT, 0);
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT,0);
    }
//    public void draw(){
////        System.out.println("sphere");
//        drawSetup();
//        //draw the vertices
//        glLineWidth(1);
//        glPointSize(10);
////        GL_ line loop, line strip,  lines, points, triagle fan
//        glDrawArrays(GL_LINE_STRIP,0,vertices.size());
//    }
}