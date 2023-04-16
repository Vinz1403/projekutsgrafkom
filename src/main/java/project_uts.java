import Engine.*;
import Engine.Object;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
//import static glfwGetTime;

public class project_uts {
    private Window window = new Window(800,800,"Hello World");
    ArrayList<Object> objects = new ArrayList<>();
    ArrayList<Object> dummy = new ArrayList<>();

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void run(){

        init();
        loop();

        glfwSetErrorCallback(null).free();
    }

//cek garis
    public boolean LeftButtonPressed = false;
    public boolean change = false;
    public int check;

    public void babayaga(){
        //boo       #0
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));


        objects.get(0).scaleObject(0.5f,0.5f,0.5f);
//        child
//        matakiri #0#0
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        objects.get(0).getChildObject().get(0).scaleObject(0.04f,0.08f,0.03f);
        objects.get(0).getChildObject().get(0).translateObject(0.08f, 0.05f, 0.23f);
        Vector3f mataKiri = new Vector3f(objects.get(0).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(0).translateObject(-mataKiri.x, -mataKiri.y, -mataKiri.z);
        objects.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(30f),-0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(0).translateObject(mataKiri.x,mataKiri.y, mataKiri.z);
//        end matakiri
//        mata kanan #0#1
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        objects.get(0).getChildObject().get(1).scaleObject(0.04f,0.08f,0.03f);
        objects.get(0).getChildObject().get(1).translateObject(-0.08f, 0.05f, 0.23f);
        Vector3f mataKanan = new Vector3f(objects.get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(1).translateObject(-mataKanan.x, -mataKanan.y, -mataKanan.z);
        objects.get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(30f),-0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(1).translateObject(mataKanan.x,mataKanan.y, mataKanan.z);
//end mata kanan


//        alis mata kanan #0#1#01
        objects.get(0).getChildObject().get(0).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));
        objects.get(0).getChildObject().get(0).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));


        objects.get(0).getChildObject().get(0).getChildObject().get(0).add_vertices(new Vector3f(-0.12f, 0.12f, 0.185f));
        objects.get(0).getChildObject().get(0).getChildObject().get(0).add_vertices(new Vector3f(-0.08f, 0.09f, 0.22f));
        objects.get(0).getChildObject().get(0).getChildObject().get(0).add_vertices(new Vector3f(-0.05f, 0.12f, 0.218f));

        curveLine(objects.get(0).getChildObject().get(0).getChildObject().get(0), objects.get(0).getChildObject().get(0).getChildObject().get(1));
        objects.get(0).getChildObject().get(0).getChildObject().get(0).get_vertices().clear();
//        objects.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f, -0.012f, 0.218f);
        Vector3f aliskanan = new Vector3f(objects.get(0).getChildObject().get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-aliskanan.x, -aliskanan.y, -aliskanan.z);
        objects.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(16f),-0.0f, -1.0f, 0.0f);
        objects.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(aliskanan.x,aliskanan.y, aliskanan.z);
        objects.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f, -0.017f, 0.245f);
//        end alis mata kanan
//        -----
//        alis mata kiri #0#0#23
        objects.get(0).getChildObject().get(1).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));
        objects.get(0).getChildObject().get(1).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));


        objects.get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.05f, 0.12f, 0.218f));
        objects.get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.08f, 0.09f, 0.22f));
        objects.get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.12f, 0.12f, 0.185f));

        curveLine(objects.get(0).getChildObject().get(1).getChildObject().get(0), objects.get(0).getChildObject().get(1).getChildObject().get(1));
        objects.get(0).getChildObject().get(1).getChildObject().get(0).get_vertices().clear();
        Vector3f aliskiri = new Vector3f(objects.get(0).getChildObject().get(1).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(-aliskiri.x, -aliskiri.y, -aliskiri.z);
        objects.get(0).getChildObject().get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(16f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(aliskiri.x,aliskiri.y, aliskiri.z);
        objects.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.0f, -0.017f, 0.245f);

//        end alis mata kiri

        //mulut #0#2
        objects.get(0).getChildObject().add(new QuarterSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(0.898f, 0.223f, 0.207f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.03f, 0.05f)
        ));
        objects.get(0).getChildObject().get(2).scaleObject(0.38f, 0.16f, 0.3f);
        objects.get(0).getChildObject().get(2).translateObject(0.0f, 0.0f, 0.18f);
        Vector3f mulut = new Vector3f(objects.get(0).getChildObject().get(2).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).translateObject(-mulut.x, -mulut.y, -mulut.z);
        objects.get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(90f),-0.0f, -1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(100f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).translateObject(mulut.x,mulut.y, mulut.z);

//        gigi1 #0#2#0
        objects.get(0).getChildObject().get(2).getChildObject().add(new TriangleC(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f),
                30.0f
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.8f, 1.0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.1f, -0.05f, 0.23f);
        Vector3f gigi1 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-gigi1.x, -gigi1.y, -gigi1.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(28f),-0.0f, -1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(15f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(gigi1.x,gigi1.y, gigi1.z);
//        end gigi1
        //        gigi2 #0#2#1
        objects.get(0).getChildObject().get(2).getChildObject().add(new TriangleC(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f),
                30.0f
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(1).scaleObject(0.8f, 1.0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(-0.035f, -0.055f, 0.25f);
        Vector3f gigi2 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(-gigi2.x, -gigi2.y, -gigi2.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(10f),-0.0f, -1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(10f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(gigi2.x,gigi2.y, gigi2.z);
//        end gigi2
        //        gigi3 #0#2#2
        objects.get(0).getChildObject().get(2).getChildObject().add(new TriangleC(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f),
                30.0f
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).scaleObject(0.8f, 1.0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(0.035f, -0.055f, 0.25f);
        Vector3f gigi3 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(2).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(-gigi3.x, -gigi3.y, -gigi3.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject((float)Math.toRadians(10f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject((float)Math.toRadians(10f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(gigi3.x,gigi3.y, gigi3.z);
//        end gigi3
        //        gigi4 #0#2#3
        objects.get(0).getChildObject().get(2).getChildObject().add(new TriangleC(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f),
                30.0f
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(3).scaleObject(0.8f, 1.0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(3).translateObject(0.1f, -0.05f, 0.23f);
        Vector3f gigi4 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(3).translateObject(-gigi4.x, -gigi4.y, -gigi4.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(3).rotateObject((float)Math.toRadians(28f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(3).rotateObject((float)Math.toRadians(15f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(3).translateObject(gigi4.x,gigi4.y, gigi4.z);
//        end gigi4

        //        lidah main  #0#2#4
        objects.get(0).getChildObject().get(2).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 0.1f, 0.1f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f)
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(4).scaleObject(1.0f, 0.5f, 1.8f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).translateObject(0.0f, -0.1f, 0.2f);
        Vector3f lidah0 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(4).translateObject(-lidah0.x, -lidah0.y, -lidah0.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).rotateObject((float)Math.toRadians(65f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).translateObject(lidah0.x,lidah0.y, lidah0.z);
//        end lidah 0
        //        lidah c1  #0#2#4#0
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().add(new completeEP(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f)
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).scaleObject(0.8f, 0.3f, 1.8f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).translateObject(0.0f, -0.14f, 0.225f);
        Vector3f lidah1 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).translateObject(-lidah1.x, -lidah1.y, -lidah1.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(80f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).translateObject(lidah1.x,lidah1.y, lidah1.z);
//        end lidah 0

//        end mulut

//        main tail #0#3
        objects.get(0).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(3).scaleObject(1.8f,0.8f,1.5f);
        objects.get(0).getChildObject().get(3).translateObject(0.0f, -0.15f, -0.115f);
        Vector3f tail0 = new Vector3f(objects.get(0).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(3).translateObject(-tail0.x, -tail0.y, -tail0.z);
        objects.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(180f),-0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(30f),0.3f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(3).translateObject(tail0.x,tail0.y, tail0.z);
//        child tail 1 #0#3#0
        objects.get(0).getChildObject().get(3).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(1.8f,0.8f,1.5f);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(0.0f, -0.136f, -0.18f);
        Vector3f tail2 = new Vector3f(objects.get(0).getChildObject().get(3).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-tail2.x, -tail2.y, -tail2.z);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(180f),-0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(50f),0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(tail2.x,tail2.y, tail2.z);
//        child tail 1 #0#3#1
        objects.get(0).getChildObject().get(3).getChildObject().add(new completeEP(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(3).getChildObject().get(1).scaleObject(1.5f,0.6f,1.5f);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(0.0f, -0.115f, -0.23f);
        Vector3f tail3 = new Vector3f(objects.get(0).getChildObject().get(3).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(-tail3.x, -tail3.y, -tail3.z);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).rotateObject((float)Math.toRadians(180f),-0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).rotateObject((float)Math.toRadians(60f),0.5f, 0.0f, 0.3f);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(tail3.x,tail3.y, tail3.z);
//        end tail

        //        main right hand #0#4
        objects.get(0).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(4).scaleObject(0.4f,0.4f,0.6f);
        objects.get(0).getChildObject().get(4).translateObject(-0.2f, -0.0f, 0.1f);
        Vector3f rh0 = new Vector3f(objects.get(0).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(4).translateObject(-rh0.x, -rh0.y, -rh0.z);
        objects.get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(65f),0.f, -1.0f, 0.0f);
        objects.get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(15f),0.0f, 0.0f, -1.0f);
        objects.get(0).getChildObject().get(4).translateObject(rh0.x,rh0.y, rh0.z);
////        child right hand 1 #0#4#0
        objects.get(0).getChildObject().get(4).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.32f,0.32f,0.6f);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-0.223f, 0.005f, 0.109f);
        Vector3f rh1 = new Vector3f(objects.get(0).getChildObject().get(4).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-rh1.x, -rh1.y, -rh1.z);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(65f),0.f, -1.0f, 0.0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(25f),0.0f, 0.0f, -1.0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(rh1.x,rh1.y, rh1.z);
//        child right hand 1 #0#4#1
        objects.get(0).getChildObject().get(4).getChildObject().add(new completeEP(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(4).getChildObject().get(1).scaleObject(0.28f,0.28f,0.8f);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(-0.233f, 0.01f, 0.109f);
        Vector3f rh2 = new Vector3f(objects.get(0).getChildObject().get(4).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(-rh2.x, -rh2.y, -rh2.z);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float)Math.toRadians(65f),0.f, -1.0f, 0.0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float)Math.toRadians(30f),0.0f, 0.0f, -1.0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(rh2.x,rh2.y, rh2.z);
//        end right hand

        //        main left hand #0#5
        objects.get(0).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(5).scaleObject(0.4f,0.4f,0.6f);
        objects.get(0).getChildObject().get(5).translateObject(0.2f, -0.0f, 0.1f);
        Vector3f lh0 = new Vector3f(objects.get(0).getChildObject().get(5).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(5).translateObject(-lh0.x, -lh0.y, -lh0.z);
        objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(65f),0.f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(15f),0.0f, 0.0f, 1.0f);
        objects.get(0).getChildObject().get(5).translateObject(lh0.x,lh0.y, lh0.z);
//        child left hand 1 #0#5#0
        objects.get(0).getChildObject().get(5).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(5).getChildObject().get(0).scaleObject(0.32f,0.32f,0.6f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(0.223f, 0.005f, 0.109f);
        Vector3f lh1 = new Vector3f(objects.get(0).getChildObject().get(5).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(-lh1.x, -lh1.y, -lh1.z);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float)Math.toRadians(65f),0.f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float)Math.toRadians(25f),0.0f, 0.0f, 1.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(lh1.x,lh1.y, lh1.z);
//        child left hand 1 #0#5#1
        objects.get(0).getChildObject().get(5).getChildObject().add(new completeEP(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(5).getChildObject().get(1).scaleObject(0.28f,0.28f,0.8f);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(0.233f, 0.01f, 0.109f);
        Vector3f lh2 = new Vector3f(objects.get(0).getChildObject().get(5).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(-lh2.x, -lh2.y, -lh2.z);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float)Math.toRadians(65f),0.f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float)Math.toRadians(30f),0.0f, 0.0f, 1.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(lh2.x,lh2.y, lh2.z);
//        end left hand

    }

    public void init(){
        window.init();
        GL.createCapabilities();
//        kamera
        camera.setPosition(-0.5f,0.0f, 5.0f);
        camera.setRotation((float) Math.toRadians(0.0f),(float) Math.toRadians(30.0f));
        babayaga();

    }

//masukin class bezier
//  func to curve
    public void curveLine(Object object2d, Object newObjects){
        float x,y;
        newObjects.get_vertices().clear();
        int n = object2d.getVerticesSize() -1;
        for (float t = 0; t <= 1; t += 0.01){
            x = 0;
            y = 0;
            int count = object2d.getVerticesSize() - 1;

            for (int i = 0; i < object2d.getVerticesSize(); i++){
                Vector3f pos = object2d.getPos(i);
                float incr = (float) (Math.pow((1 - t), count) * Math.pow(t, i)) * C(n,i);
                x += (incr * pos.x);
                y += (incr * pos.y);
                count--;
            }
            newObjects.add_vertices(new Vector3f(x,y, 0.0f));
        }
    }
//    endcurveline

    public int C(int n, int r){
        return fak(n) / (fak(n-r)*fak(r));
    }

    public int fak( int angka){
        if (angka == 0 || angka == 1){
            return 1;
        }else {
            return angka * fak(angka-1);
        }
    }
//    end func to curve
//    end masukin class bezier

    public void input(){

//        ROTATING OBJECT
        if(window.isKeyPressed(GLFW_KEY_D)){
//            Y_RIGHT
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,1.0f,0.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);

        }
        if(window.isKeyPressed(GLFW_KEY_A)){
//            Y_LEFT
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,-1.0f,0.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }
        if(window.isKeyPressed(GLFW_KEY_S)){
//            X_UP
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),1.0f,0.0f,0.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }
        if(window.isKeyPressed(GLFW_KEY_W)){
//            X_DOWN
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),-1.0f,0.0f,0.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }
        if(window.isKeyPressed(GLFW_KEY_Z)){
//            Z_POS
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f,1.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }
        if(window.isKeyPressed(GLFW_KEY_X)){
//            Z_NEG
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f,-1.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }
//      END ROTATING OBJECT

//        ANIMATION
//        LAUGH
//        FADE
        if(window.isKeyPressed(GLFW_KEY_P)){if(objects.size()>0) objects.remove(0);}
//        REAPPEAR
        if(window.isKeyPressed(GLFW_KEY_O)){babayaga();}
//        SHY
//        if(window.isKeyPressed(GLFW_KEY_8)){objects.get(0).translateObject(0.0f,0.00f,0.01f);}
//        END ANIMATION


//        TRANSLATING OBJECT
//        FORWARD
        if(window.isKeyPressed(GLFW_KEY_RIGHT)){
            Vector3f objectDir = new Vector3f(0.0f, 0.0f, 1.0f);
            objects.get(0).model.transformDirection(objectDir, objectDir);
            Vector3f translation = new Vector3f(objectDir).mul(0.1f);
            objects.get(0).translateObject(translation.x/10, translation.y/10, translation.z/10);
        }
////        BACKWARD
        if(window.isKeyPressed(GLFW_KEY_LEFT)){
            Vector3f objectDir = new Vector3f(0.0f, 0.0f, -1.0f);
            objects.get(0).model.transformDirection(objectDir, objectDir);
            Vector3f translation = new Vector3f(objectDir).mul(0.1f);
            objects.get(0).translateObject(translation.x/10, translation.y/10, translation.z/10);

        }
//        ASCEND
        if(window.isKeyPressed(GLFW_KEY_UP)){objects.get(0).translateObject(0.0f,0.01f,0.0f);}
//        DESCEND
        if(window.isKeyPressed(GLFW_KEY_DOWN)){objects.get(0).translateObject(0.0f,-0.01f,0.0f);}
//        END TRANSLATING OBJECT

//        SCALING OBJECT
//        MAGNIFY
        if(window.isKeyPressed(GLFW_KEY_M)){objects.get(0).scaleObject(1.1f,1.1f,1.1f);}
//        REVERSE MAGNIFY
        if(window.isKeyPressed(GLFW_KEY_N)){objects.get(0).scaleObject(0.8f,0.8f,0.8f);}
//        END SCALING

    }
//end tulul


    public void loop(){
        while (window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,0.0f,1.0f);
            GL.createCapabilities();
            input();
//            write your code here
//            .....
//            System.out.println("halooo");


//            by circle
            for (Object object:objects){
//                if(object instanceof Bezier) {
////                System.out.println(child instanceof Bezier);
//                    object.drawLine(camera, projection);
//                }else {
//                    object.draw(camera, projection);
//                    object.drawIndices(camera, projection);
//                }
                object.draw(camera, projection);
                object.drawIndices(camera, projection);
            }

            //  curve
//            objectsPoinControl.get(1).drawLine(camera, projection);
//            objectsPoinControl.get(3).drawLine(camera, projection);
//            for (Object object:objectsPoinControl){
//                object.drawLine(camera, projection);
//            }
//            for (Object object:objectbyCircle){
//                object.draw(camera, projection);
//            }


//            restore state
            glDisableVertexAttribArray(0);
            glfwPollEvents();

        }
    }

    public static void main(String[] args) {
        new project_uts().run();
//        System.out.println("done");
    }


}
