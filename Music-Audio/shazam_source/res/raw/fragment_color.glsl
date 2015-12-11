precision mediump float;       	// Set the default precision to medium.
varying vec4 v_Color;          	// This is the color from the vertex shader interpolated across the triangle 

void main()                    		
{               
	gl_FragColor = v_Color;
}                                                                     	

