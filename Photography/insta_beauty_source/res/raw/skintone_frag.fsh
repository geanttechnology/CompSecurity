varying mediump vec2 textureCoordinate;
precision mediump float;

uniform float width;
uniform float height;
uniform sampler2D videoFrame;
uniform sampler2D curveTex;
uniform float yCoord;
uniform float yContrastCoord;


void main()
{
	lowp vec4 inputColor = texture2D(videoFrame, textureCoordinate);
	lowp vec4 colorOut = vec4(1.0);
	float newr = texture2D(curveTex, vec2(inputColor.r, yContrastCoord)).r;
	float newg = texture2D(curveTex, vec2(inputColor.g, yContrastCoord)).g;
	float newb = texture2D(curveTex, vec2(inputColor.b, yContrastCoord)).b;
	newr = texture2D(curveTex, vec2(inputColor.r, yCoord)).r;
    newg = texture2D(curveTex, vec2(inputColor.g, yCoord)).g;
    newb = texture2D(curveTex, vec2(inputColor.b, yCoord)).b;

    colorOut = vec4(newr, newg, newb, inputColor.a);
	gl_FragColor = colorOut;
}
