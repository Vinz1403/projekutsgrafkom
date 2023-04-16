//import Engine.*;
//import Engine.Object;
//import org.joml.Vector2f;
//import org.joml.Vector3f;
//import org.joml.Vector4f;
//import org.lwjgl.opengl.GL;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.lwjgl.glfw.GLFW.*;
//import static org.lwjgl.opengl.GL11.glClearColor;
//import static org.lwjgl.opengl.GL30.*;
//
//public class Main {
//    private Window window = new Window(800,800,"Hello World");
//    ArrayList<Object> objects = new ArrayList<>();
//    ArrayList<Object> objectRectangle = new ArrayList<>();
//    ArrayList<Object> objectCircle = new ArrayList<>();
//    ArrayList<Object> objectStar = new ArrayList<>();
//    ArrayList<Object> objectbyCircle = new ArrayList<>();
//    ArrayList<Object> objectsPoinControl = new ArrayList<>();
//
//    public void run(){
//
//        init();
//        loop();
//
//        glfwSetErrorCallback(null).free();
//    }
//
//
//    public void init(){
//        window.init();
//        GL.createCapabilities();
//
////        add object segitiga
////        objects.add(new Object2d(
////                Arrays.asList(new ShaderProgram.ShaderModuleData(
////                                "resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData(
////                                "resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
////
////                ),
////                new ArrayList<>(
////                        List.of(
////                                new Vector3f(0.0f,0.5f,0.0f),
////                                new Vector3f(0.5f,-0.5f,0.0f),
////                                new Vector3f(-0.5f,-0.5f,0.0f)
////                        )
////                ),
//////                buat ganti warna di segitiganya
//////                new Vector4f(0.0f,1.0f,1.0f,1.0f)
////                new ArrayList<>(
////                        List.of(
////                                new Vector3f(1.0f,0.0f,0.0f),
////                                new Vector3f(0.0f,1.0f,0.0f),
////                                new Vector3f(0.0f,0.0f,1.0f)
////                        )
////                )
////        ));
////rectangle object uniform
////        SKY
//        objectRectangle.add(new Rectangle(
//                Arrays.asList(new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-1.0f,1.0f,0.0f),
//                                new Vector3f(1.0f,1.0f,0.0f),
//                                new Vector3f(-1.0f,-0.3f,0.0f),
//                                new Vector3f(1.0f,-0.3f,0.0f)
//                        )
//                ),
////                buat ganti warna vectored
//                new Vector4f(0.0f,0.0f,1.0f,1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//
//        ));
//
////FIELD
//        objectRectangle.add(new Rectangle(
//                Arrays.asList(new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-1.0f,-0.3f,0.0f),
//                                new Vector3f(1.0f,-0.3f,0.0f),
//                                new Vector3f(-1.0f,-1.0f,0.0f),
//                                new Vector3f(1.0f,-1.0f,0.0f)
//                        )
//                ),
////                buat ganti warna vectored
//                new Vector4f(0.0f,0.6f,0.3F,1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//
//        ));
//
//        //        atap2
//        objectRectangle.add(new Rectangle(
//                Arrays.asList(new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.6f,0.2f,0.0f),
//                                new Vector3f(0.6f,0.2f,0.0f),
//                                new Vector3f(-0.4f,0.5f,0.0f),
//                                new Vector3f(0.4f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(1.0f,0.5f,0.0f,1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//
//        ));
//
//
////        TEMBOK
//        objectRectangle.add(new Rectangle(
//                Arrays.asList(new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.3f,0.0f),
//                                new Vector3f(0.5f,0.3f,0.0f),
//                                new Vector3f(-0.5f,-0.4f,0.0f),
//                                new Vector3f(0.5f,-0.4f,0.0f)
//                        )
//                ),
////                buat ganti warna vectored
//                new Vector4f(1.0f,0.8f,0.1f,1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//
//        ));
//        //        tembok2
//        objectRectangle.add(new Rectangle(
//                Arrays.asList(new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.3f,0.0f),
//                                new Vector3f(0.3f,0.3f,0.0f),
//                                new Vector3f(-0.41f,0.45f,0.0f),
//                                new Vector3f(0.4f,0.45f,0.0f)
//                        )
//                ),
//                new Vector4f(1.0f,0.8f,0.1f,1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//
//        ));
//        //        atap1
//        objectRectangle.add(new Rectangle(
//                Arrays.asList(new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.2f,0.2f,0.0f),
//                                new Vector3f(0.6f,0.2f,0.0f),
//                                new Vector3f(-0.4f,0.5f,0.0f),
//                                new Vector3f(0.4f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(1.0f,0.5f,0.0f,1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//
//        ));
//
////        cerobong1
//        objectRectangle.add(new Rectangle(
//                Arrays.asList(new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.3f,0.6f,0.0f),
//                                new Vector3f(0.2f,0.6f,0.0f),
//                                new Vector3f(0.3f,0.4f,0.0f),
//                                new Vector3f(0.2f,0.4f,0.0f)
//                        )
//                ),
////                buat ganti warna vectored
//                new Vector4f(1.0f,0.8f,0.1f,1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//
//        ));
//        //        cerobong2
//        objectRectangle.add(new Rectangle(
//                Arrays.asList(new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.32f,0.55f,0.0f),
//                                new Vector3f(0.18f,0.55f,0.0f),
//                                new Vector3f(0.32f,0.6f,0.0f),
//                                new Vector3f(0.18f,0.6f,0.0f)
//                        )
//                ),
////                buat ganti warna vectored
//                new Vector4f(1.0f,0.5f,0.0f,1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//
//        ));
////asap1
//        objectCircle.add(new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
//                new Vector4f(0.5f, 0.5f, 0.5f, 1.0f),
//                new Vector3f(0.25f, 0.67f, 0.0f),
//                new Vector3f(0.08f, 0.05f, 0.0f)
//        ));
//        //asap2
//        objectCircle.add(new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
//                new Vector4f(0.5f, 0.5f, 0.5f, 1.0f),
//                new Vector3f(0.3f, 0.71f, 0.0f),
//                new Vector3f(0.08f, 0.04f, 0.0f)
//        ));
//        //asap3
//        objectCircle.add(new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
//                new Vector4f(0.5f, 0.5f, 0.5f, 1.0f),
//                new Vector3f(0.36f, 0.74f, 0.0f),
//                new Vector3f(0.1f, 0.03f, 0.0f)
//        ));
//        //bulan1
//        objectCircle.add(new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
//                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//                new Vector3f(-0.8f, 0.8f, 0.0f),
//                new Vector3f(0.06f, 0.07f, 0.0f)
//        ));
////        bulan2
//        objectCircle.add(new Circle(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
//                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
//                new Vector3f(-0.76f, 0.8f, 0.0f),
//                new Vector3f(0.06f, 0.06f, 0.0f)
//        ));
//////        bintang1
////        objects.add(new Object2d(
////                Arrays.asList(new ShaderProgram.ShaderModuleData(
////                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData(
////                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
////
////                ),
////                new ArrayList<>(
////                        List.of(
//////                                order kiri bwh atas kanan bwh kiri atas kanan atas kiri bwh
////                                new Vector3f(-0.25f,0.7f,0.0f), //kiri bwh
////                                new Vector3f(-0.2f,0.85f,0.0f), //atas
////                                new Vector3f(-0.1f,0.7f,0.0f), //kanan bwh
////                                new Vector3f(-0.28f,0.8f,0.0f), //kiri ats
////                                new Vector3f(-0.1f,0.8f,0.0f), //kanan ats
////                                new Vector3f(-0.25f,0.7f,0.0f) //kiri bwh
////                        )
////                ),
//////                buat ganti warna, rgb
////                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f)
////        ));
////        bintang lingkaran
//        objectStar.add(new Star(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
////                center
//                new Vector3f(-0.4f, 0.8f, 0.0f),
////                rad
//                new Vector3f(0.05f, 0.05f, 0.0f),
//                0.3f
//        ));
//        //        bintang lingkaran2
//        objectStar.add(new Star(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
////                center
//                new Vector3f(-0.2f, 0.6f, 0.0f),
////                rad
//                new Vector3f(0.03f, 0.03f, 0.0f),
//                0.3f
//        ));
//        //        bintang lingkaran2
//        objectStar.add(new Star(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
////                center
//                new Vector3f(0.6f, 0.7f, 0.0f),
////                rad
//                new Vector3f(0.06f, 0.06f, 0.0f),
//                0.3f
//        ));
//
////        rectangle dari circle
//        objectbyCircle.add(new RectangleC(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
////                center
//                new Vector3f(0.5f, 0.0f, 0.0f),
////                rad
//                new Vector3f(0.5f, 0.5f, 0.0f)
//        ));
//
//        //        triangle dari circle
//        objectbyCircle.add(new TriangleC(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
////                center
//                new Vector3f(-0.5f, 0.0f, 0.0f),
////                rad
//                new Vector3f(0.5f, 0.5f, 0.0f),
//                90.0f
//        ));
////point control object
//                objectsPoinControl.add(new Object(
//                Arrays.asList(new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
//
//    }
//
//
//
//    public void input(){
//        if(window.isKeyPressed(GLFW_KEY_W)){
//            System.out.println("W");
//        }
//        if(window.getMouseInput().isLeftButtonPressed()){
//            Vector2f pos = window.getMouseInput().getCurrentPos();
//
//            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
//            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);
//
//            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
//                System.out.println("x : "+pos.x+" y : "+pos.y);
//                objectsPoinControl.get(0).add_vertices(new Vector3f(pos.x,pos.y,0));
//            }
//        }
//        //button release index plus?
//    }
//
//
//
//    public void loop(){
//        while (window.isOpen()){
//            window.update();
//            glClearColor(0.0f,0.0f,0.0f,1.0f);
//            GL.createCapabilities();
//            input();
////            write your code here
////            .....
////            System.out.println("halooo");
//
////
//////            drawww reccc
//            for (Object object:objectRectangle){
//                object.draw();
//            }
//
////            test circle
//              for (Object object:objectCircle){
//               object.draw();
//            }
////              object2d for stars
////            for (Object2d object:objects){
////                object.draw();
////            }
//
////            star
//            for (Object object:objectStar){
//                object.draw();
//            }
//
////            by circle
////            for (Object2d object:objectbyCircle){
////                object.draw();
////            }
//
////            ,point control
//            for (Object object:objectsPoinControl){
//                object.drawLine();
//            }
//
//
////            restore state
//            glDisableVertexAttribArray(0);
//            glfwPollEvents();
//
//        }
//    }
//
//    public static void main(String[] args) {
//        new Main().run();
////        System.out.println("done");
//    }
//
//
//}
