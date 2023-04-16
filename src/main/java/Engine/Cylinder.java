package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Cylinder extends Object {
    Vector3f center, radius;
    float height, putaran = 360;
    float lineWidth = 0.005f;


    public Cylinder(List<ShaderModuleData> shaderModuleDataList, Vector4f color, Vector3f center, Vector3f radius, float height) {
        super(shaderModuleDataList, new ArrayList<>(), color);
        this.center = center;
        this.radius = radius;
        this.height = height;
        createCylinder();
        setupVAOVBO();
//        printVertices();
    }

    public Cylinder(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius, float height) {
        super(shaderModuleDataList, vertices, color);
        this.center = center;
        this.radius = radius;
        this.height = height;
        createCylinder();
        setupVAOVBO();


    }

    public void createCylinder() {


        for (float angle = 0; angle < putaran; angle += 0.1){

            float x1 = (float) (radius.x * Math.cos(Math. toRadians (angle)) + center.x);
            float y1 = (float) (radius.y * Math.sin (Math. toRadians (angle)) + center.y) ;

            float x2 = (float) ((radius.x - lineWidth) * Math. cos (Math.toRadians(angle)) + center.x);
            float y2 = (float) ((radius.y -lineWidth) * Math.sin(Math.toRadians(angle)) + center.y);

            vertices.add (new Vector3f(x1, y1,  center.z - height));
            vertices.add(new Vector3f(x1, y1, center.z + height)) ;

            vertices.add (new Vector3f (x2, y2,center.z - height));
            vertices.add (new Vector3f(x2,y2, center.z + height));
        }
    }




//    public void draw() {
//        drawSetup();
//        // draw the vertices
//        glLineWidth(1);
//        glPointSize(0);
//        glDrawArrays(GL_TRIANGLE_STRIP, 0, vertices.size());
//    }

    public void printVertices() {
        System.out.println(vertices);
    }
}
