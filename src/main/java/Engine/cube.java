package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class cube extends Circle{

    List<Integer> index;
    int ibo;

    public cube(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f center, Vector3f radius) {
        super(shaderModuleDataList, vertices, color, center, radius);
        this.vertices = vertices;
        this.center = center;
        this.radius = radius;
        createBox();
//            createSphere();
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

}