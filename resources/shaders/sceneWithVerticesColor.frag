#version 330
//yg nampilin warna ke main
//vec4 itu buat awarna
//uniform vec4 uni_color;
out vec4 frag_color;
//kasitau ada varable dari vert, nama hrs sama
in vec4 out_color;
void main() {
    //    frag_color = vec4 (1.0,0.0,0.0,1.0);
    //  warna buat segitiga bisa sama kyk di main
    frag_color = out_color;
}