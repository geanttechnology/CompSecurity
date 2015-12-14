varying highp vec2 textureCoordinate;
precision mediump float;
 
uniform vec2 rubyInputSize; 
uniform vec2 rubyOutputSize; 
uniform vec2 textureCoordinateSize; 

uniform float width;
uniform float height;
uniform sampler2D videoFrame;
 
// Abbreviations        
#define TEX2D(c) texture2D(videoFrame, (c))
#define PI 3.141592653589

// Controls the intensity of the barrel distortion used to emulate the
// curvature of a CRT. 0.0 is perfectly flat, 1.0 is annoyingly
// distorted, higher values are increasingly ridiculous.
#define distortion 0.0

// Apply radial distortion to the given coordinate.
vec2 radialDistortion(vec2 coord) {
	coord *= textureCoordinateSize / rubyInputSize;
	vec2 cc = coord - 0.5;
	float dist = dot(cc, cc) * distortion;				
	return (coord + cc * (1.0 + dist) * dist) * rubyInputSize / textureCoordinateSize;
}

// Calculate the influence of a scanline on the current pixel.
//
// 'distance' is the distance in texture coordinates from the current
// pixel to the scanline in question.
// 'color' is the colour of the scanline at the horizontal location of
// the current pixel.
vec4 scanlineWeights(float distance, vec4 color)
{								
	// The "width" of the scanline beam is set as 2*(1 + x^4) for
	// each RGB channel.
	vec4 wid = 2.0 + 2.0 * pow(color, vec4(4.0));
	
	// The "weights" lines basically specify the formula that gives
	// you the profile of the beam, i.e. the intensity as
	// a function of distance from the vertical center of the
	// scanline. In this case, it is gaussian if width=2, and
	// becomes nongaussian for larger widths. Ideally this should
	// be normalized so that the integral across the beam is
	// independent of its width. That is, for a narrower beam
	// "weights" should have a higher peak at the center of the
	// scanline than for a wider beam.
	vec4 weights = vec4(distance * 3.333333);                
	return 0.51 * exp(-pow(weights * sqrt(2.0 / wid), wid)) / (0.18 + 0.06 * wid);				
}

void main()
{
	// Here's a helpful diagram to keep in mind while trying to
	// understand the code:
	//
	//  |      |      |      |      |
	// -------------------------------
	//  |      |      |      |      |
	//  |  01  |  11  |  21  |  31  | <-- current scanline
	//  |      | @    |      |      |
	// -------------------------------
	//  |      |      |      |      |
	//  |  02  |  12  |  22  |  32  | <-- next scanline
	//  |      |      |      |      |
	// -------------------------------
	//  |      |      |      |      |
	//
	// Each character-cell represents a pixel on the output
	// surface, "@" represents the current pixel (always somewhere
	// in the bottom half of the current scan-line, or the top-half
	// of the next scanline). The grid of lines represents the
	// edges of the texels of the underlying texture.
	
	// The size of one texel, in texture-coordinates.
	vec2 one = 1.0 / textureCoordinateSize;
	
	// Texture coordinates of the texel containing the active pixel				
	vec2 xy = radialDistortion(textureCoordinate);								                
	
	// Of all the pixels that are mapped onto the texel we are
	// currently rendering, which pixel are we currently rendering?
	vec2 uv_ratio = fract(xy * textureCoordinateSize) - vec2(0.5);
	
	// Snap to the center of the underlying texel.                
	xy.y = (floor(xy.y * textureCoordinateSize.y) + 0.5) / textureCoordinateSize.y;
	
	// Calculate the effective colour of the current and next
	// scanlines at the horizontal location of the current pixel,
	// using the Lanczos coefficients above.								                
	vec4 col  = TEX2D(xy);
	vec4 col2 = TEX2D(xy + vec2(0.0, one.y));
	
	// Calculate the influence of the current and next scanlines on
	// the current pixel.
	vec4 weights  = scanlineWeights(abs(uv_ratio.y) , col);
	vec4 weights2 = scanlineWeights(1.0 - uv_ratio.y, col2);
	vec3 mul_res  = (col * weights + col2 * weights2).xyz;
	
	// mod_factor is the x-coordinate of the current output pixel.
	float mod_factor = textureCoordinate.x * rubyOutputSize.x * textureCoordinateSize.x / rubyInputSize.x;
	
	// dot-mask emulation:
	// Output pixels are alternately tinted green and magenta.
	vec3 dotMaskWeights = mix(
							  vec3(1.0, 0.8, 1.0),
							  vec3(0.8, 1.0, 0.8),
							  floor(mod(mod_factor, 2.0))
							  );
	
	mul_res *= dotMaskWeights;
	
	gl_FragColor = vec4(mul_res, 1.0); 
} 