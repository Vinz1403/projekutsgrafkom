package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Cone extends Circle{

    List<Integer> index;
    int ibo;

    public Cone(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius) {
        super(shaderModuleDataList, vertices, color, center, radius);
        this.vertices = vertices;
        this.center = center;
        this.radius = radius;
//        createBox();
//        createSphere();
//ellipsoid();
//hyperboloid1();
//        hyperboloid2();
//        createHyperboloid2();
//        elipticCone();
        elipticParaboloid();
//        hyperboloidParaboloid();
        setupVAOVBO();

    }


    public void drawIndices(Camera camera, Projection projection){
        drawSetup(camera, projection);
//        element buffer object gausa gl array
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glDrawElements(GL_LINE_LOOP, index.size(), GL_UNSIGNED_INT,0);
//        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT,0);
    }
//    public void draw(Camera camera, Projection projection){
////        System.out.println("sphere");
//        drawSetup(camera, projection);
//        //draw the vertices
//        glLineWidth(1);
//        glPointSize(10);
////        GL_ line loop, line strip,  lines, points, triagle fan
//        glDrawArrays(GL_LINE_STRIP,0,vertices.size());
//    }


    public void ellipsoid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/36){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/36){
                float x = radius.x * (float)(Math.cos(v) * Math.cos(u));
                float y = radius.y * (float)(Math.cos(v) * Math.sin(u));
                float z = radius.z * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void hyperboloid1(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/36){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/36){
//                System.out.println(Math.acos(v) +" acos vs 1/cos "+(1/Math.cos(v)));
                float z = 0.5f * (float)((1/Math.cos(v)) * Math.cos(u));
                float y = 0.5f * (float)((1/Math.cos(v)) * Math.sin(u));
                float x = 0.5f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void hyperboloid2(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/120){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/120){
                float y = 0.5f * (float)(Math.tan(v) * Math.cos(u));
                float z = 0.5f * (float)(Math.tan(v) * Math.sin(u));
                float x = 0.5f * (float)((1/Math.cos(v)));
                temp.add(new Vector3f(x,y,z));
            }
            for(double u2 = Math.PI/2; u2<= 3*Math.PI/2; u2+=Math.PI/120){
                float y = 0.5f * (float)(Math.tan(v) * Math.cos(u2));
                float z = 0.5f * (float)(Math.tan(v) * Math.sin(u2));
                float x = -0.5f * (float)((1/Math.cos(v)));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void elipticCone(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI/2; v <= Math.PI/2; v+= Math.PI/100) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI/60) {
                float x = 0.5f * (float)((v) * Math.cos(u));
                float z = 0.5f * (float)((v) * Math.sin(u));
                float y = 0.5f * (float)(v);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void elipticParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = Math.PI; v >= 0; v-= Math.PI/60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI/60) {
                float x = radius.x * (float) (v * Math.cos(u));
                float y = radius.y * (float) (v * Math.sin(u));
                float z = (float) (v * v);
                temp.add(new Vector3f(x, z, y));
            }
        }

        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void hyperboloidParaboloid() {
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = Math.PI; v >= 0; v-= Math.PI/60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI/60) {
                float x = radius.x * (float) (v * Math.tan(u));
                float y = radius.y * (float) (v * (1 / Math.cos(u)));
                float z = (float) (v * v);
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

    public void createHyperboloid2(){

        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * Math.tan(v) * Math.cos(u));
                float z = (float) (0.5f * Math.tan(v) * Math.sin(u));
                float y = (float) (0.5f * 1/Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }

            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (-0.5f * Math.tan(v) * Math.cos(u));
                float z = (float) (-0.5f * Math.tan(v) * Math.sin(u));
                float y = (float) (-0.5f * 1/Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices.clear();
        vertices.addAll(temp);
        setupVAOVBO();
    }

}
