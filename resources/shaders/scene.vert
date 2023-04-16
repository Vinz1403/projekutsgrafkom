#version 330
layout (location = 0) in vec3 position;

uniform mat4 model;
//pert 9 - projection n camera
uniform mat4 view;
uniform mat4 projection;

//kalo nemu rumus di internet dibalik?

void main(){
    gl_Position = projection * view * model * vec4(position, 1.0);
}

