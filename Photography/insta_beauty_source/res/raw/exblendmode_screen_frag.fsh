varying highp vec2 textureCoordinate;
precision mediump float;

uniform float width;
uniform float height;
uniform sampler2D videoFrame;
uniform sampler2D blendTex;
uniform vec4 bdColor;
uniform int blendMode;
uniform float opacity;


float BlendScreenf(float base, float blend)
{
	return (1.0 - ((1.0 - base) * (1.0 - blend)));
}

vec3 BlendScreen(vec3 base, vec3 blend, float opacity)
{
	float r = BlendScreenf(base.r, blend.r);
	float g = BlendScreenf(base.g, blend.g);
	float b = BlendScreenf(base.b, blend.b);
	vec3 c = vec3(r, g, b);
	return c * opacity + base * (1.0 - opacity);
}

void main()
{
	lowp vec3 baseColor = texture2D(videoFrame, textureCoordinate).xyz;
	lowp vec3 blendColor = vec3(1.0);
    float alpha = opacity;
	if(bdColor.a != 0.0) {
		blendColor = bdColor.rgb;
        alpha = bdColor.a;
	} else {
		blendColor = texture2D(blendTex, textureCoordinate).xyz;
	}
	
	lowp vec3 color = BlendScreen(baseColor, blendColor,alpha);
  	gl_FragColor = vec4(color, 1.0);
    
}