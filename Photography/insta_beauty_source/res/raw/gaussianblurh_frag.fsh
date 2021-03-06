

varying highp vec2 textureCoordinate;
precision mediump float;

uniform float width;
uniform float height;
uniform float blurSize;

uniform sampler2D videoFrame;


void main()
{
	int KERNEL_SIZE = 9;
	highp float step_w = (1.0/width)*blurSize;
	highp float step_h = (1.0/height)*blurSize;
	
//	float cmatrix[9];
	
//	cmatrix[0] = 0.0394232;
//	cmatrix[1] = 0.0779794;
//	cmatrix[2] = 0.126999;
//	cmatrix[3] = 0.170303;
//	cmatrix[4] = 0.170591;
//	cmatrix[5] = 0.170303;
//	cmatrix[6] = 0.126999;
//	cmatrix[7] = 0.0779794;
//	cmatrix[8] = 0.0394232;	
	
	int halfValue = 4;
	
//	int i = 0;
//	 vec3 sum = vec3(0.0);
//	for( i=0; i<3; i++ )
//	{
//		vec3 tmp = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue - i)*step_w, 0.0)).xyz;
//		sum += tmp * cmatrix[i];
//	}
	
	lowp vec4 sum1 = vec4(0.0);
	lowp vec4 t1 = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue)*step_w, 0.0));
	lowp vec4 t2 = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue - 1)*step_w, 0.0));
	lowp vec4 t3 = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue - 2)*step_w, 0.0));
	lowp vec4 t4 = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue - 3)*step_w, 0.0));
	lowp vec4 t5 = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue - 4)*step_w, 0.0));
	lowp vec4 t6 = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue - 5)*step_w, 0.0));
	lowp vec4 t7 = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue - 6)*step_w, 0.0));
	lowp vec4 t8 = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue - 7)*step_w, 0.0));
	lowp vec4 t9 = texture2D(videoFrame, textureCoordinate + vec2(float(halfValue - 8)*step_w, 0.0));
	
	sum1 += t1*0.0394232;
	sum1 += t2*0.0779794;
	sum1 += t3*0.126999;
	sum1 += t4*0.170303;
	sum1 += t5*0.170591;
	sum1 += t6*0.170303;
	sum1 += t7*0.126999;
	sum1 += t8*0.0779794;
	sum1 += t9*0.0394232;
	
	gl_FragColor = sum1;
}
