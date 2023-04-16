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
//public class Main3 {
//    private Window window = new Window(800,800,"Hello World");
//    ArrayList<Sphere> objects = new ArrayList<>();
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
//
////        rectangle dari circle
////        objectbyCircle.add(new RectangleC(
////                Arrays.asList(
////                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
////                ), new ArrayList<>(
////                List.of()
////        ),
//////                color
////                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
//////                center
////                new Vector3f(0.5f, 0.0f, 0.0f),
//////                rad
////                new Vector3f(0.5f, 0.5f, 0.0f)
////        ));
////
////                objects.add(new Object(
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
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
//                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//                new Vector3f(0.0f, 0.0f, 0.0f),
//                new Vector3f(0.5f, 0.5f, 0.0f)
//        ));
//
//
//
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
//
////            by circle
//            for (Object object:objects){
//                object.draw();
//            }
//
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
//        new Main3().run();
////        System.out.println("done");
//    }
//
//
//}
