#version 330
//yg buat colornya

layout (location = 0) in vec3 position;
layout (location = 1) in vec3 color;
//nulis warnanya buat dikirim ke frag
out vec4 out_color;
void main(){
    gl_Position = vec4(position, 1.0);
    out_color = vec4(color, 1.0);
}

