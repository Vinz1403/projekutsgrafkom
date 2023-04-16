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
//public class Main4 {
//    private Window window = new Window(800,800,"Hello World");
//    ArrayList<Sphere> objects = new ArrayList<>();
//    Camera camera = new Camera();
//    Projection projection = new Projection(window.getWidth(), window.getHeight());
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
//        camera.setPosition(-0.5f,0.0f, 0.5f);
//        camera.setRotation((float) Math.toRadians(0.0f),(float) Math.toRadians(30.0f));
//
////matahari
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
////                center
//                new Vector3f(0.0f, 0.0f, 0.0f),
////                rad
//                new Vector3f(0.1f, 0.1f, 0.0f)
//        ));
//
//        objects.get(0).translateObject(0.0f, 0.0f, 0.0f);
//        objects.get(0).scaleObject(0.27f,0.27f,0.27f);
//
////        merkurius
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(0.5f, 0.5f, 0.5f, 1.0f),
////                center
//                new Vector3f(0.0f, 0.0f, 0.0f),
////                rad
//                new Vector3f(0.1f, 0.1f, 0.0f)
//        ));
//
//        objects.get(1).translateObject(8.0f, 0.0f, 0.0f);
//        objects.get(1).scaleObject(0.02f,0.02f,0.02f);
//
//
//        //        venus
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(1.0f, 0.5f, 0.0f, 1.0f),
////                center
//                new Vector3f(0.0f, 0.0f, 0.0f),
////                rad
//                new Vector3f(0.1f, 0.1f, 0.0f)
//        ));
//
//        objects.get(2).translateObject(4.5f, 0.0f, 0.0f);
//        objects.get(2).scaleObject(0.05f,0.05f,0.05f);
//
//        //        mars
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
////                center
//                new Vector3f(0.0f, 0.0f, 0.0f),
////                rad
//                new Vector3f(0.1f, 0.1f, 0.0f)
//        ));
//
//        objects.get(3).translateObject(12.5f, 0.0f, 0.0f);
//        objects.get(3).scaleObject(0.03f,0.03f,0.03f);
//
//        //        bumi
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
////                center
//                new Vector3f(0.0f, 0.0f, 0.0f),
////                rad
//                new Vector3f(0.1f, 0.1f, 0.0f)
//        ));
//
//        objects.get(4).translateObject(8.8f, 0.0f, 0.0f);
//        objects.get(4).scaleObject(0.035f,0.035f,0.035f);
//
//        //        bulan
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of()
//        ),
////                color
//                new Vector4f(0.875f, 0.875f, 0.875f, 1.0f),
////                center
//                new Vector3f(0.0f, 0.0f, 0.0f),
////                rad
//                new Vector3f(0.1f, 0.1f, 0.0f)
//        ));
//
//        objects.get(5).translateObject(32.0f, 3.0f, 0.0f);
//        objects.get(5).scaleObject(0.01f,0.01f,0.01f);
//
//    }
//
//
//
//    public void input(){
////        if(window.isKeyPressed(GLFW_KEY_W)){
////            objects.get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,0.0f,1.0f);
//////            System.out.println("W");a
////        }
////        if(window.isKeyPressed(GLFW_KEY_A)){
////            objects.get(0).rotateObject((float)Math.toRadians(0.5f),-1.0f,0.0f,0.0f);
////        }
////        if(window.isKeyPressed(GLFW_KEY_S)){
////            objects.get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,-1.0f,0.0f);
////        }
////        if(window.isKeyPressed(GLFW_KEY_Q)){
////            objects.get(0).rotateObject((float)Math.toRadians(0.5f),0.0f,1.0f,0.0f);
////        }
////        if(window.isKeyPressed(GLFW_KEY_D)){
////            objects.get(0).rotateObject((float)Math.toRadians(0.5f),1.0f,0.0f,0.0f);
////        }
//
////        trans rotate scale, kode scalle rotate translate
//
//        if(window.isKeyPressed(GLFW_KEY_F)){
////            matahari
//            objects.get(0).rotateObject((float)Math.toRadians(1.27f),0.0f,0.0f,1.0f);
////            objects.get(1).translateObject(0.0f, -1.0f, 0.0f);
//
////            merkuri
//            objects.get(1).rotateObject((float)Math.toRadians(1.02f),0.0f,0.0f,1.0f);
////            ArrayList<Vector3f> tempVertices = new ArrayList<>();
////            tempVertices = (ArrayList<Vector3f>) objects.get(1).getCenter();
////            objects.get(1).translateObject(  8.0f, 0.0f, 0.0f);
////            venus
//            objects.get(2).rotateObject((float)Math.toRadians(1.05f),0.0f,0.0f,1.0f);
////            mars
//            objects.get(3).rotateObject((float)Math.toRadians(1.035f),0.0f,0.0f,1.0f);
////            bumi
//            objects.get(4).rotateObject((float)Math.toRadians(1.03f),0.0f,0.0f,1.0f);
////            bulan
//            objects.get(5).rotateObject((float)Math.toRadians(1.01f),0.0f,0.0f,1.0f);
//        }
//
//        if(window.isKeyPressed(GLFW_KEY_B)){
////            matahari
//            objects.get(0).rotateObject((float)Math.toRadians(1.27f),0.0f,1.0f,0.0f);
////            objects.get(1).translateObject(0.0f, -1.0f, 0.0f);
//
////            merkuri
//            objects.get(1).rotateObject((float)Math.toRadians(1.02f),0.0f,1.0f,0.0f);
////            ArrayList<Vector3f> tempVertices = new ArrayList<>();
////            tempVertices = (ArrayList<Vector3f>) objects.get(1).getCenter();
////            objects.get(1).translateObject(  8.0f, 0.0f, 0.0f);
////            venus
//                objects.get(2).rotateObject((float)Math.toRadians(1.05f),0.0f,1.0f,0.0f);
////            mars
//            objects.get(3).rotateObject((float)Math.toRadians(1.035f),0.0f,1.0f,0.0f);
////            bumi
//            objects.get(4).rotateObject((float)Math.toRadians(1.03f),0.0f,1.0f,0.0f);
////            bulan
//            objects.get(5).rotateObject((float)Math.toRadians(1.01f),0.0f,1.0f,0.0f);
//        }
//
//        if(window.isKeyPressed(GLFW_KEY_G)){
//            //            matahari
////            objects.get(0).translateObject(0.5f,0.0f,0.0f);
//            Vector3f matahari = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
//            objects.get(0).translateObject(-matahari.x,-matahari.y,0f);
//            objects.get(0).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
//            objects.get(0).translateObject(matahari.x,matahari.y,0f);
//
////            merkuri
//            Vector3f merkuri = new Vector3f(objects.get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
//            objects.get(1).translateObject(-merkuri.x,-merkuri.y,0f);
//            objects.get(1).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
//            objects.get(1).translateObject(merkuri.x,merkuri.y,0f);
//
////            venus
//            Vector3f venus = new Vector3f(objects.get(2).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
//            objects.get(2).translateObject(-venus.x,-venus.y,0f);
//            objects.get(2).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
//            objects.get(2).translateObject(venus.x,venus.y,0f);
////            mars
//            Vector3f mars = new Vector3f(objects.get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
//            objects.get(3).translateObject(-mars.x,-mars.y,0f);
//            objects.get(3).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
//            objects.get(3).translateObject(mars.x,mars.y,0f);
////            bumi
//            Vector3f bumi = new Vector3f(objects.get(4).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
//            objects.get(4).translateObject(-bumi.x,-bumi.y,0f);
//            objects.get(4).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
//            objects.get(4).translateObject(bumi.x,bumi.y,0f);
//            //            bulan
//
//            Vector3f bulan = new Vector3f(objects.get(5).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
//            objects.get(5).translateObject(-bulan.x,-bulan.y,0f);
//            objects.get(5).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
//            objects.get(5).translateObject(bulan.x,bulan.y,0f);
//
//        }
//
//        if(window.isKeyPressed(GLFW_KEY_H)){
////            bumi
////            objects.get(4).rotateObject((float)Math.toRadians(0.035f),1.0f,0.0f,0.0f);
////            bulan
////            objects.get(4).
////            objects.get(4).model();
//            Vector3f bulan = new Vector3f(objects.get(4).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
//            objects.get(5).translateObject(-bulan.x,-bulan.y,0f);
//            objects.get(5).rotateObject((float) Math.toRadians(1.0f),0f,0f,1f);
//            objects.get(5).translateObject(bulan.x,bulan.y,0f);
//        }
//
//
//        if(window.getMouseInput().isLeftButtonPressed()){
//            Vector2f pos = window.getMouseInput().getCurrentPos();
//
//            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
//            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);
//
//            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
//                System.out.println("x : "+pos.x+" y : "+pos.y);
////                objectsPoinControl.get(0).add_vertices(new Vector3f(pos.x,pos.y,0));
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
//                object.draw(camera, projection);
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
//        new Main4().run();
////        System.out.println("done");
//    }
//
//
//}
