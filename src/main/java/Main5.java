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
//public class Main5 {
//    private Window window = new Window(800,800,"Hello World");
//    ArrayList<Sphere> objects = new ArrayList<>();
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
////matahari
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of(
//                )
//        ),
////                color
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
////                center
//                new Vector3f(0.0f, 0.0f, 0.0f),
////                rad
//                new Vector3f(0.1f, 0.1f, 0.1f)
//        ));
//
//
//        objects.get(0).scaleObject(0.5f,0.5f,0.5f);
//////        child
////        objects.get(0).getChildObject().add(new Sphere(
////                Arrays.asList(
////                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
////                ), new ArrayList<>(
////                List.of()
////        ),
//////                color
////                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//////                center
////                new Vector3f(0.0f, 0.0f, 0.0f),
//////                rad
////                new Vector3f(0.1f, 0.1f, 0.1f)
////        ));
////
////        objects.get(0).getChildObject().get(0).scaleObject(1.5f,1.5f,1.5f);
////        objects.get(0).getChildObject().get(0).translateObject(0.25f, 0.0f, 0.0f);
////
////        objects.get(0).getChildObject().add(new Sphere(
////                Arrays.asList(
////                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
////                ), new ArrayList<>(
////                List.of()
////        ),
//////                color
////                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//////                center
////                new Vector3f(0.0f, 0.0f, 0.0f),
//////                rad
////                new Vector3f(0.1f, 0.1f, 0.1f)
////        ));
////
////        objects.get(0).getChildObject().get(1).scaleObject(1.0f,1.0f,1.0f);
////        objects.get(0).getChildObject().get(1).translateObject(0.5f, 0.0f, 0.0f);
////
////        objects.get(0).getChildObject().get(1).getChildObject().add(new Sphere(
////                Arrays.asList(
////                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
////                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
////                ), new ArrayList<>(
////                List.of()
////        ),
//////                color
////                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//////                center
////                new Vector3f(0.0f, 0.0f, 0.0f),
//////                rad
////                new Vector3f(0.1f, 0.1f, 0.1f)
////        ));
////
////        objects.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.5f,0.5f,0.5f);
////        objects.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.5f, -0.1f, 0.0f);
//
//
//    }
//
//
//
//    public void input(){
//
//        if(window.isKeyPressed(GLFW_KEY_R)){
//            objects.get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//
//            for(Object child: objects.get(0).getChildObject()){
//                Vector3f tempCenterPoint = child.updateCenterPoint();
//
//                child.translateObject(tempCenterPoint.x *-1,
//                                    tempCenterPoint.y*-1,
//                                    tempCenterPoint.z*-1);
//
//                child.rotateObject((float)Math.toRadians(0.5f), 0.0f,0.0f, 1.0f);
//
//                child.translateObject(tempCenterPoint.x *1,
//                        tempCenterPoint.y*1,
//                        tempCenterPoint.z*1);
//            }
//            for(Object child: objects.get(0).getChildObject().get(1).getChildObject()){
//                Vector3f tempCenterPoint = objects.get(0).getChildObject().get(1).updateCenterPoint();
//
//                child.translateObject(tempCenterPoint.x *-1,
//                        tempCenterPoint.y*-1,
//                        tempCenterPoint.z*-1);
//
//                child.rotateObject((float)Math.toRadians(0.5f), 0.0f,0.0f, 1.0f);
//
//                child.translateObject(tempCenterPoint.x *1,
//                        tempCenterPoint.y*1,
//                        tempCenterPoint.z*1);
//            }
//
//        }
//
//        if(window.isKeyPressed(GLFW_KEY_D)){
////            Y_RIGHT
//            objects.get(0).rotateObject((float)Math.toRadians(1.27f),0.0f,1.0f,0.0f);}
//        if(window.isKeyPressed(GLFW_KEY_A)){
////            Y_LEFT
//            objects.get(0).rotateObject((float)Math.toRadians(1.27f),0.0f,-1.0f,0.0f);}
//        if(window.isKeyPressed(GLFW_KEY_W)){
////            X_UP
//            objects.get(0).rotateObject((float)Math.toRadians(1.27f),1.0f,0.0f,0.0f);}
//        if(window.isKeyPressed(GLFW_KEY_S)){
////            X_DOWN
//            objects.get(0).rotateObject((float)Math.toRadians(1.27f),-1.0f,0.0f,0.0f);}
//        if(window.isKeyPressed(GLFW_KEY_Z)){
////            Z_POS
//            objects.get(0).rotateObject((float)Math.toRadians(1.27f),0.0f,0.0f,1.0f);}
//        if(window.isKeyPressed(GLFW_KEY_X)){
////            Z_NEG
//            objects.get(0).rotateObject((float)Math.toRadians(1.27f),0.0f,0.0f,-1.0f);}
//
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
//                object.drawIndices();
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
//        new Main5().run();
////        System.out.println("done");
//    }
//
//
//}
