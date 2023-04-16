package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class TriangleC extends Object {
    Vector3f center, radius;

    public TriangleC(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius, float rotate) {
        super(shaderModuleDataList, vertices, color);
        this.center = center;
        this.radius = radius;
        createRect(rotate);
        setupVAOVBO();
    }


    public void createRect(float rotate) {
        //vertices -> clear
        vertices.clear();
        for (float angle = 0; angle < 360; angle += 120) {
            float x = (float) (radius.x * Math.cos(Math.toRadians(angle+rotate)) + center.x);
            float y = (float) (radius.y * Math.sin(Math.toRadians(angle+rotate)) + center.y);
            vertices.add(new Vector3f(x, y, 0.0f));

        }


    }

    public void draw(Camera camera, Projection projection) {
        drawSetup(camera, projection);
        // draw the vertices
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
    }
}