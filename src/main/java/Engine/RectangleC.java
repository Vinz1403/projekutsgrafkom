package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class RectangleC extends Object {
    Vector3f center, radius;

    public RectangleC(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius) {
        super(shaderModuleDataList, vertices, color);
        this.center = center;
        this.radius = radius;
        createRect();
        setupVAOVBO();
    }


    public void update(Vector3f center) {
        this.center = center;
        createRect();
        setupVAOVBO();
    }

    public void createRect() {
        //vertices -> clear
        vertices.clear();
        for (float angle = 0; angle < 360; angle += 90) {
            float x = (float) (radius.x * Math.cos(Math.toRadians(angle+45f)) + center.x);
            float y = (float) (radius.y * Math.sin(Math.toRadians(angle+45f)) + center.y);
            vertices.add(new Vector3f(x, y, 0.0f));

        }


    }

    public void draw(Camera camera, Projection projection) {
        drawSetup(camera, projection);
        // draw the vertices
        glLineWidth(1);
        glPointSize(1);
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());
    }
}