package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Sphere extends Circle{

    List<Integer> index;
    int ibo;

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius) {
        super(shaderModuleDataList, vertices, color, center, radius);
        this.vertices = vertices;
        this.center = center;
        this.radius = radius;
//        createBox();
        createSphere();
//ellipsoid();
//hyperboloid1();
//        hyperboloid2();
//        createHyperboloid2();
//        elipticCone();
//        elipticParaboloid();
//        hyperboloidParaboloid();
        setupVAOVBO();

    }

    public void createBox(){
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
//        titik 1 kiri atas belakang
        temp.x = center.x - radius.x / 2 ;
        temp.y = center.y +  radius.y / 2 ;
        temp.z = center.z - radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 2 kiri bawah belakang
        temp.x = center.x - radius.x / 2 ;
        temp.y = center.y -  radius.y / 2 ;
        temp.z = center.z - radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 3 kanan bawah belakang
        temp.x = center.x + radius.x / 2 ;
        temp.y = center.y -  radius.y / 2 ;
        temp.z = center.z - radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 4 kanan atas belakang
        temp.x = center.x + radius.x / 2 ;
        temp.y = center.y +  radius.y / 2 ;
        temp.z = center.z - radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();


        //        titik 5 kiri atas depan
        temp.x = center.x - radius.x / 2 ;
        temp.y = center.y +  radius.y / 2 ;
        temp.z = center.z + radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();


        //        titik 6 kiri bawah depan
        temp.x = center.x - radius.x / 2 ;
        temp.y = center.y -  radius.y / 2 ;
        temp.z = center.z + radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 7 kanan bawah depan
        temp.x = center.x + radius.x / 2 ;
        temp.y = center.y -  radius.y / 2 ;
        temp.z = center.z + radius.z / 2 ;
        tempVertices.add(temp);
        temp = new Vector3f();

        //        titik 8 kanan atas depan
        temp.x = center.x + radius.x / 2 ;
        temp.y = center.y +  radius.y / 2 ;
        temp.z = center.z + radius.z / 2 ;
        tempVertices.add(temp);
//        clc v3
        temp = new Vector3f();


//    kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        //    kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));

        //    kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));

        //    kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        //    kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));

        //    kotak samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(0));
    }
//    end box

    public void createSphere(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

//        int stackCount = 36, sectorCount = 108;
        int stackCount = 12, sectorCount = 36;

        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = 0.5f * (float)Math.cos(stackAngle);
            z = 0.5f * (float)Math.sin(stackAngle);
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = xy * (float)Math.cos(sectorAngle);
                y = xy * (float)Math.sin(sectorAngle);
                temp.add(new Vector3f(x,y,z));
            }
        }
//        temp = ellipsoid();
//        temp = hyperboloid1();
//        temp = hyperboloid2();
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount );
            k2 = k1 + sectorCount ;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(36/2) || i!=(12/2)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }

        this.index = temp_indices;

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }

    public void drawIndices(Camera camera, Projection projection){
        drawSetup(camera, projection);
//        element buffer object gausa gl array
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glDrawElements(GL_LINE_LOOP, index.size(), GL_UNSIGNED_INT,0);
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT,0);
    }
//    ini tadi g dipake
//    public void draw(Camera camera, Projection projection){
////        System.out.println("sphere");
//        drawSetup(camera, projection);
//        //draw the vertices
//        glLineWidth(1);
//        glPointSize(1);
////        GL_ line loop, line strip,  lines, points, triagle fan
////        glDrawArrays(GL_TRIANGLE_FAN,0,vertices.size());
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
            for (double u = 0; u <= Math.PI; u += Math.PI/60) {
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
