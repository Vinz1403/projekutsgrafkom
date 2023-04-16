package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LINE_STRIP;

public class Bezier extends Object{


    public Bezier(List<ShaderProgram.ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
        this.vertices = vertices;
        this.setColor(color);

        setupVAOVBO();
    }

    public void draw(Camera camera, Projection projection){
        drawSetup(camera, projection);
        //draw the vertices
        glLineWidth(5);
        glPointSize(1);
        glDrawArrays(GL_LINE_STRIP,0,vertices.size());
    }

}
