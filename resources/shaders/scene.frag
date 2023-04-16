#version 330
//vec4 itu buat awarna
uniform vec4 uni_color;
out vec4 frag_color;
void main() {
//    frag_color = vec4 (1.0,0.0,0.0,1.0);
//  warna buat segitiga bisa sama kyk di main
    frag_color = uni_color;
}