package Engine;
import static org.lwjgl.opengl.GL30.*;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;


public class Object extends ShaderProgram{

    List<Vector3f> vertices;

    int vao;
    int vbo;

    public Matrix4f model;

    private Vector4f color;
    UniformsMap uniformsMap;
//v with color
    List<Vector3f> verticesColor;
    int vboColor;

    List<Object> childObject;

//    perbaiki rotasi pada diri sendiri


//    unicolor
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.setColor(color);
        uniformsMap = new UniformsMap(getProgramId());
//        sesuaian banyak variabel di scene.frag
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        //        meet 9 - projection n camera
        uniformsMap.createUniform("view");
        uniformsMap.createUniform("projection");
//        default gpp
        model = new Matrix4f();
        childObject = new ArrayList<>();
    }

    //g pake uniform map, vec 4 tapi pake listcolor/layout location
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOwithVerticesColor();

    }
//    public Bezier curveLine(Object object2d){return (Bezier) object2d;}

//    public Object(List<ShaderModuleData> shaderModuleDataList) {
//        super(shaderModuleDataList);
//    }

    public Vector3f updateCenterPoint(){
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f,centerTemp);
        return centerTemp;
    }

    public List<Object> getChildObject() {
        return childObject;
    }

    public int getVerticesSize() {
        return vertices.size();
    }

    public Vector3f getPos(int index) {
        return vertices.get(index);
    }

    public List<Vector3f> getVertices() {
        return vertices;
    }


    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);

        //mengirim vertices ke sender
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }

    public void setupVAOVBOwithVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        //set vbo1
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
//        set vbo2, krn layout tujuannya ada 2 ????
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vboColor);

        //mengirim vertices ke sender
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }


    public void drawSetup(Camera camera, Projection projection){
        bind();
        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3,GL_FLOAT, false,0,0);
//        set var krn diambel dari dsfl, nama uniform dan var vec4
        uniformsMap.setUniform("uni_color", getColor());
        uniformsMap.setUniform("model", model);
//        meet -9
        uniformsMap.setUniform("view", camera.getViewMatrix());
        uniformsMap.setUniform("projection", projection.getProjMatrix());

    }

    public void drawSetupWithVerticesColor(){
        bind();
        //bind vbo
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3,GL_FLOAT, false,0,0);

        //bind vbo2
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);

        glVertexAttribPointer(1,3,GL_FLOAT, false,0,0);
    }


    public void draw(Camera camera, Projection projection){
        drawSetup(camera, projection);
        //draw the vertices
        glLineWidth(5);
        glPointSize(1);
//        GL_ line loop, line strip,  lines, points, triagle fan
        glDrawArrays(GL_TRIANGLE_FAN,0,vertices.size());
//        glDrawArrays(GL_TRIANGLES,0,vertices.size());
//        glDrawArrays(GL_LINE_STRIP,0,vertices.size());

        for (Object child:childObject){
//            if(child instanceof Bezier) {
////                System.out.println(child instanceof Bezier);
//                child.drawLine(camera, projection);
//            }else {
                child.draw(camera, projection);
                child.drawIndices(camera, projection);
//            }
        }
//        glDrawArrays(GL_POLYGON,0,vertices.size());
//            glDrawArrays(GL_LINE_LOOP,0,vertices.size());
    }

    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        //draw the vertices
        glLineWidth(1);
        glPointSize(1);
//        GL_ line loop, line strip,  lines, points, triagle fan
//        glDrawArrays(GL_TRIANGLE_FAN,0,vertices.size());
        glDrawArrays(GL_LINE_LOOP,0,vertices.size());
//        glDrawArrays(GL_POINT,0,vertices.size());
    }

    public void drawIndices(Camera camera, Projection projection){}


    public void drawLine(Camera camera, Projection projection){
        drawSetup(camera, projection);
        //draw the vertices
        glLineWidth(5);
        glPointSize(1);
        glDrawArrays(GL_LINE_STRIP,0,vertices.size());
    }

    public void add_vertices(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();
    }

    public List<Vector3f> get_vertices(){
        return vertices;
    }
    public void update (int index, Vector3f pos){
        vertices.set(index, pos);
        setupVAOVBO();
    }

    public void translateObject(Float offsetX, Float offsetY, Float offsetZ){
//        urutan kalinya di balik
        model =  new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for (Object child: childObject){
            child.translateObject(offsetX, offsetY, offsetZ);
        }
    }

//    yg di main jaddin radian, cari yg generic internal
    public void rotateObject(Float degree, Float offsetX, Float offsetY, Float offsetZ){
        model =  new Matrix4f().rotate(degree, offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for (Object child: childObject){
            child.rotateObject(degree,offsetX, offsetY, offsetZ);
        }
    }

//    scaling object
    public void scaleObject(Float offsetX, Float offsetY, Float offsetZ){
        model =  new Matrix4f().scale(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for (Object child: childObject){
            child.scaleObject(offsetX, offsetY, offsetZ);
        }
    }

    public void fade(Float opacity){
//        model.transform()
//        Vector4f color = model.getColor();
//        model.setColor(new Vector4f(color.x, color.y, color.z, opacity));
        for (Object child : childObject) {
//            Vector4f color = child.getColor();
            child.setColor(new Vector4f(getColor().x, getColor().y, getColor().z, opacity));
        }

        }

    public Vector4f getColor() {
        return color;
    }

    public void setColor(Vector4f color) {
        this.color = color;
    }
}




//    public void update_pos(Vector3f vector3f) {
//        vertices.set(vector3f);
//        setupVAOVBO();
//    }

