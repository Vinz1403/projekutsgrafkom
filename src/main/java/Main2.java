import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL20.*;

//BEZIER CURVE

public class Main2 {
    private Window window = new Window(800,800,"Hello World");
    int index =0;
    ArrayList<Object> objectsPoinControl = new ArrayList<>();
    ArrayList<RectangleC> objectbyCircle = new ArrayList<>();

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void run(){

        init();
        loop();

        glfwSetErrorCallback(null).free();
    }

    public boolean LeftButtonPressed = false;
    public boolean change = false;
    public int check;


    public void init(){
        window.init();
        GL.createCapabilities();
//      camera init pos
        camera.setPosition(-0.5f,0.0f, 1.0f);
        camera.setRotation((float) Math.toRadians(0.0f),(float) Math.toRadians(30.0f));

//point control object
        objectsPoinControl.add(new Object(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,1.0f)
        ));
        objectsPoinControl.add(new Object(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(1.0f,1.0f,0.0f,1.0f)
        ));


    }




    public void input(){
        if(window.isKeyPressed(GLFW_KEY_W)){
            System.out.println("W");
        }
        if(window.getMouseInput().isLeftButtonPressed()){
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);

            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1)) && !LeftButtonPressed){
                System.out.println("x : "+pos.x+" y : "+pos.y);
//                get indexnya atur

                if (!change){
                    check = isCollide(objectsPoinControl.get(0),pos);
                    if (check == -1){
                        LeftButtonPressed = true;
//                        set garis
                        objectsPoinControl.get(0).add_vertices(new Vector3f(pos.x, pos.y, 0));
//                        set persegi
                        objectbyCircle.add(new RectangleC(
                                Arrays.asList(
                                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                                ), new ArrayList<>(
                                List.of()
                        ),
//                color
                                new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
//                center
                                new Vector3f(pos.x, pos.y, 0.0f),
//                rad
                                new Vector3f(0.1f, 0.1f, 0.0f)
                        ));

                        curveLine(objectsPoinControl.get(0), objectsPoinControl.get(1));
                        System.out.println(objectsPoinControl.get(0).getVerticesSize());
                        System.out.println(objectsPoinControl.get(1).getVerticesSize());
                    } else change = true;
                }else {
                    if (isCollide(objectsPoinControl.get(0), pos) == -1){
                        objectbyCircle.get(check).update(new Vector3f(pos.x, pos.y, 0.0f));
                        objectsPoinControl.get(0).update(check, new Vector3f(pos.x, pos.y, 0.0f));
                        curveLine(objectsPoinControl.get(0),objectsPoinControl.get(1));
                    }
                }
            }
        }

        //button release index plus?
        if (window.getMouseInput().isLeftButtonRelease()) {
            LeftButtonPressed = false;
            change = false;
            check = -1;
        }
    }

    public int isCollide (Object object2d, Vector2f newPos){
        for (int i = 0; i < object2d.getVerticesSize();i++){
            Vector3f pos = object2d.getPos(i);
            float jarak = (float) Math.sqrt((Math.pow(newPos.x - pos.x, 2) + (Math.pow(newPos.y - pos.y, 2))));

            if(jarak < 0.2) return i;
        }
        return -1;
    }

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



    public void loop(){
        while (window.isOpen()){
            window.update();
            glClearColor(0.0f,0.0f,0.0f,1.0f);
            GL.createCapabilities();
            input();

//            by circle
            for (Object object:objectbyCircle){
                object.draw(camera, projection);
            }

//            ,point control
            for (Object object:objectsPoinControl){
                object.drawLine(camera, projection);
            }


//            restore state
            glDisableVertexAttribArray(0);
            glfwPollEvents();

        }
    }

    public static void main(String[] args) {
        new Main2().run();
    }


}
