// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class gs
{

    private static float C = 0.03F;
    private int A;
    private final int B = 8;
    private int D;
    private int E;
    private int F;
    float a[] = {
        -1F, -1F, 1.0F, -1F, -1F, 1.0F, 1.0F, 1.0F
    };
    float b[] = {
        0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F
    };
    public int c;
    public int d;
    public int e;
    float f;
    float g;
    float h;
    float i;
    float j;
    float k;
    float l;
    float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    private final String v = "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;uniform float imageWidthFactor;uniform float imageHeightFactor;uniform float sharpness;varying vec2 leftTextureCoordinate;varying vec2 rightTextureCoordinate;varying vec2 topTextureCoordinate;varying vec2 bottomTextureCoordinate;varying float centerMultiplier;varying float edgeMultiplier;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);mediump vec2 heightStep = vec2(0.0, imageHeightFactor);leftTextureCoordinate = inputTextureCoordinate - widthStep;rightTextureCoordinate = inputTextureCoordinate + widthStep;topTextureCoordinate = inputTextureCoordinate + heightStep;bottomTextureCoordinate = inputTextureCoordinate - heightStep;centerMultiplier = 1.0 + 4.0 * sharpness;edgeMultiplier = sharpness;}";
    private final String w = "precision highp float;varying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform  float gamma;uniform  float contrast;uniform  float saturation;uniform  float whiteblance;uniform  float shadows;uniform  float highlights;uniform  float colortemperature;varying  vec2 leftTextureCoordinate;varying  vec2 rightTextureCoordinate;varying  vec2 topTextureCoordinate;varying  vec2 bottomTextureCoordinate;varying  float centerMultiplier;varying  float edgeMultiplier;const  vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);const  vec3 luminanceWeighting1 = vec3(0.3, 0.3, 0.3);const  float LUMINANCE_PRESERVATION = 0.75;const  float EPSILON = 1e-10; float limitValue1(float v,float min,float max){if(v > max){v = max;}else if(v < min){v = min;}return v;} vec3 limitValue3(vec3 v){v.r = limitValue1(v.r,0.0,1.0);v.g = limitValue1(v.g,0.0,1.0);v.b = limitValue1(v.b,0.0,1.0);return v;}vec3 screen(vec3 base,vec3 overlay){vec3 whiteColor = vec3(1.0);vec3 colo  =  whiteColor - ((whiteColor - base) * (whiteColor - overlay));return colo;}vec3 ColorTemperatureToRGB(float temperatureInKelvins)\n{\nvec3 retColor;temperatureInKelvins = limitValue1(temperatureInKelvins, 1000.0, 40000.0) / 100.0;if (temperatureInKelvins <= 66.0){    retColor.r = 1.0;    retColor.g = limitValue1(0.39008157876901960784 * log(temperatureInKelvins) - 0.63184144378862745098,0.0,1.0);}else{    float t = temperatureInKelvins - 60.0;    retColor.r = limitValue1(1.29293618606274509804 * pow(t, -0.1332047592),0.0,1.0);    retColor.g = limitValue1(1.12989086089529411765 * pow(t, -0.0755148492),0.0,1.0);}if (temperatureInKelvins >= 66.0)    retColor.b = 1.0;else if(temperatureInKelvins <= 19.0)    retColor.b = 0.0;else    retColor.b = limitValue1(0.54320678911019607843 * log(temperatureInKelvins - 10.0) - 1.19625408914,0.0,1.0);return retColor;}float Luminance(vec3 color){    float fmin = min(min(color.r, color.g), color.b);    float fmax = max(max(color.r, color.g), color.b);    return (fmax + fmin) / 2.0;}vec3 HUEtoRGB(float H){    float R = abs(H * 6.0 - 3.0) - 1.0;    float G = 2.0 - abs(H * 6.0 - 2.0);    float B = 2.0 - abs(H * 6.0 - 4.0);    return limitValue3(vec3(R,G,B));}vec3 HSLtoRGB(in vec3 HSL){    vec3 RGB = HUEtoRGB(HSL.x);    float C = (1.0 - abs(2.0 * HSL.z - 1.0)) * HSL.y;    return (RGB - 0.5) * C + vec3(HSL.z);}vec3 RGBtoHCV(vec3 RGB){    vec4 P = (RGB.g < RGB.b) ? vec4(RGB.bg, -1.0, 2.0/3.0) : vec4(RGB.gb, 0.0, -1.0/3.0);    vec4 Q = (RGB.r < P.x) ? vec4(P.xyw, RGB.r) : vec4(RGB.r, P.yzx);    float C = Q.x - min(Q.w, Q.y);    float H = abs((Q.w - Q.y) / (6.0 * C + EPSILON) + Q.z);    return vec3(H, C, Q.x);}vec3 RGBtoHSL(vec3 RGB){    vec3 HCV = RGBtoHCV(RGB);    float L = HCV.z - HCV.y * 0.5;    float S = HCV.y / (1.0 - abs(L * 2.0 - 1.0) + EPSILON);    return vec3(HCV.x, S, L);}void main() { vec2 maskCoordinate;maskCoordinate.x = textureCoordinate.x;maskCoordinate.y = 1.0 - textureCoordinate.y; vec3 ocrgb = texture2D(inputImageTexture, textureCoordinate).rgb; vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb; vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb; vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb; vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb; vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb; vec3 sh = vec3((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)));ocrgb = sh;ocrgb = limitValue3(ocrgb);ocrgb = pow(ocrgb, vec3(gamma));ocrgb = limitValue3(ocrgb);ocrgb = ((ocrgb - vec3(0.5)) * contrast + vec3(0.5));ocrgb = limitValue3(ocrgb);ocrgb = vec3(ocrgb.r,ocrgb.g, pow(ocrgb.b, whiteblance));ocrgb = limitValue3(ocrgb); float luminance = dot(ocrgb, luminanceWeighting); vec3 greyScaleColor = vec3(luminance);ocrgb = mix(greyScaleColor, ocrgb, saturation);ocrgb = limitValue3(ocrgb); float luminance1 = dot(ocrgb, luminanceWeighting1); float shadow = limitValue1((pow(luminance1, 1.0/(shadows+1.0)) + (-0.76)*pow(luminance1, 2.0/(shadows+1.0))) - luminance1,0.0,1.0); float highlight = limitValue1((1.0 - (pow(1.0-luminance1, 1.0/(2.0-shadows)) + (-0.8)*pow(1.0-luminance1, 2.0/(2.0-shadows)))) - luminance1, -1.0, 0.0);ocrgb = vec3(0.0, 0.0, 0.0) + ((luminance1 + shadow + highlight) - 0.0) * ((ocrgb - vec3(0.0, 0.0, 0.0))/(luminance1 - 0.0));ocrgb = limitValue3(ocrgb);vec3 scr = screen(ocrgb,ocrgb);ocrgb = mix(ocrgb,scr,highlights);ocrgb = limitValue3(ocrgb);vec3 colorTempRGB = ColorTemperatureToRGB(colortemperature);float originalLuminance = Luminance(ocrgb);vec3 blended = ocrgb * colorTempRGB;vec3 resultHSL = RGBtoHSL(blended);vec3 luminancePreservedRGB = HSLtoRGB(vec3(resultHSL.x, resultHSL.y, originalLuminance));ocrgb = mix(blended, luminancePreservedRGB, LUMINANCE_PRESERVATION);ocrgb = limitValue3(ocrgb);gl_FragColor = vec4(ocrgb,1.0);}";
    private FloatBuffer x;
    private FloatBuffer y;
    private int z;

    public gs()
    {
        n = 0.0F;
        o = 1.0F;
        p = 1.0F;
        q = 1.0F;
        r = 1.0F;
        s = 0.0F;
        t = 0.0F;
        u = 6600F;
        E = MosaicGLSurfaceView.loadShader(35633, "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;uniform float imageWidthFactor;uniform float imageHeightFactor;uniform float sharpness;varying vec2 leftTextureCoordinate;varying vec2 rightTextureCoordinate;varying vec2 topTextureCoordinate;varying vec2 bottomTextureCoordinate;varying float centerMultiplier;varying float edgeMultiplier;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);mediump vec2 heightStep = vec2(0.0, imageHeightFactor);leftTextureCoordinate = inputTextureCoordinate - widthStep;rightTextureCoordinate = inputTextureCoordinate + widthStep;topTextureCoordinate = inputTextureCoordinate + heightStep;bottomTextureCoordinate = inputTextureCoordinate - heightStep;centerMultiplier = 1.0 + 4.0 * sharpness;edgeMultiplier = sharpness;}");
        F = MosaicGLSurfaceView.loadShader(35632, "precision highp float;varying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform  float gamma;uniform  float contrast;uniform  float saturation;uniform  float whiteblance;uniform  float shadows;uniform  float highlights;uniform  float colortemperature;varying  vec2 leftTextureCoordinate;varying  vec2 rightTextureCoordinate;varying  vec2 topTextureCoordinate;varying  vec2 bottomTextureCoordinate;varying  float centerMultiplier;varying  float edgeMultiplier;const  vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);const  vec3 luminanceWeighting1 = vec3(0.3, 0.3, 0.3);const  float LUMINANCE_PRESERVATION = 0.75;const  float EPSILON = 1e-10; float limitValue1(float v,float min,float max){if(v > max){v = max;}else if(v < min){v = min;}return v;} vec3 limitValue3(vec3 v){v.r = limitValue1(v.r,0.0,1.0);v.g = limitValue1(v.g,0.0,1.0);v.b = limitValue1(v.b,0.0,1.0);return v;}vec3 screen(vec3 base,vec3 overlay){vec3 whiteColor = vec3(1.0);vec3 colo  =  whiteColor - ((whiteColor - base) * (whiteColor - overlay));return colo;}vec3 ColorTemperatureToRGB(float temperatureInKelvins)\n{\nvec3 retColor;temperatureInKelvins = limitValue1(temperatureInKelvins, 1000.0, 40000.0) / 100.0;if (temperatureInKelvins <= 66.0){    retColor.r = 1.0;    retColor.g = limitValue1(0.39008157876901960784 * log(temperatureInKelvins) - 0.63184144378862745098,0.0,1.0);}else{    float t = temperatureInKelvins - 60.0;    retColor.r = limitValue1(1.29293618606274509804 * pow(t, -0.1332047592),0.0,1.0);    retColor.g = limitValue1(1.12989086089529411765 * pow(t, -0.0755148492),0.0,1.0);}if (temperatureInKelvins >= 66.0)    retColor.b = 1.0;else if(temperatureInKelvins <= 19.0)    retColor.b = 0.0;else    retColor.b = limitValue1(0.54320678911019607843 * log(temperatureInKelvins - 10.0) - 1.19625408914,0.0,1.0);return retColor;}float Luminance(vec3 color){    float fmin = min(min(color.r, color.g), color.b);    float fmax = max(max(color.r, color.g), color.b);    return (fmax + fmin) / 2.0;}vec3 HUEtoRGB(float H){    float R = abs(H * 6.0 - 3.0) - 1.0;    float G = 2.0 - abs(H * 6.0 - 2.0);    float B = 2.0 - abs(H * 6.0 - 4.0);    return limitValue3(vec3(R,G,B));}vec3 HSLtoRGB(in vec3 HSL){    vec3 RGB = HUEtoRGB(HSL.x);    float C = (1.0 - abs(2.0 * HSL.z - 1.0)) * HSL.y;    return (RGB - 0.5) * C + vec3(HSL.z);}vec3 RGBtoHCV(vec3 RGB){    vec4 P = (RGB.g < RGB.b) ? vec4(RGB.bg, -1.0, 2.0/3.0) : vec4(RGB.gb, 0.0, -1.0/3.0);    vec4 Q = (RGB.r < P.x) ? vec4(P.xyw, RGB.r) : vec4(RGB.r, P.yzx);    float C = Q.x - min(Q.w, Q.y);    float H = abs((Q.w - Q.y) / (6.0 * C + EPSILON) + Q.z);    return vec3(H, C, Q.x);}vec3 RGBtoHSL(vec3 RGB){    vec3 HCV = RGBtoHCV(RGB);    float L = HCV.z - HCV.y * 0.5;    float S = HCV.y / (1.0 - abs(L * 2.0 - 1.0) + EPSILON);    return vec3(HCV.x, S, L);}void main() { vec2 maskCoordinate;maskCoordinate.x = textureCoordinate.x;maskCoordinate.y = 1.0 - textureCoordinate.y; vec3 ocrgb = texture2D(inputImageTexture, textureCoordinate).rgb; vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb; vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb; vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb; vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb; vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb; vec3 sh = vec3((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)));ocrgb = sh;ocrgb = limitValue3(ocrgb);ocrgb = pow(ocrgb, vec3(gamma));ocrgb = limitValue3(ocrgb);ocrgb = ((ocrgb - vec3(0.5)) * contrast + vec3(0.5));ocrgb = limitValue3(ocrgb);ocrgb = vec3(ocrgb.r,ocrgb.g, pow(ocrgb.b, whiteblance));ocrgb = limitValue3(ocrgb); float luminance = dot(ocrgb, luminanceWeighting); vec3 greyScaleColor = vec3(luminance);ocrgb = mix(greyScaleColor, ocrgb, saturation);ocrgb = limitValue3(ocrgb); float luminance1 = dot(ocrgb, luminanceWeighting1); float shadow = limitValue1((pow(luminance1, 1.0/(shadows+1.0)) + (-0.76)*pow(luminance1, 2.0/(shadows+1.0))) - luminance1,0.0,1.0); float highlight = limitValue1((1.0 - (pow(1.0-luminance1, 1.0/(2.0-shadows)) + (-0.8)*pow(1.0-luminance1, 2.0/(2.0-shadows)))) - luminance1, -1.0, 0.0);ocrgb = vec3(0.0, 0.0, 0.0) + ((luminance1 + shadow + highlight) - 0.0) * ((ocrgb - vec3(0.0, 0.0, 0.0))/(luminance1 - 0.0));ocrgb = limitValue3(ocrgb);vec3 scr = screen(ocrgb,ocrgb);ocrgb = mix(ocrgb,scr,highlights);ocrgb = limitValue3(ocrgb);vec3 colorTempRGB = ColorTemperatureToRGB(colortemperature);float originalLuminance = Luminance(ocrgb);vec3 blended = ocrgb * colorTempRGB;vec3 resultHSL = RGBtoHSL(blended);vec3 luminancePreservedRGB = HSLtoRGB(vec3(resultHSL.x, resultHSL.y, originalLuminance));ocrgb = mix(blended, luminancePreservedRGB, LUMINANCE_PRESERVATION);ocrgb = limitValue3(ocrgb);gl_FragColor = vec4(ocrgb,1.0);}");
        D = GLES20.glCreateProgram();
        GLES20.glAttachShader(D, E);
        GLES20.glAttachShader(D, F);
        GLES20.glLinkProgram(D);
    }

    public void a()
    {
        GLES20.glDeleteShader(E);
        GLES20.glDeleteShader(F);
        GLES20.glDeleteProgram(D);
    }

    public void a(float f1)
    {
        float f2 = Math.abs(i - f1);
        q = f1;
        if (f2 > C)
        {
            i = f1;
        }
    }

    public void b()
    {
        GLES20.glUseProgram(D);
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(a.length * 4);
        bytebuffer.order(ByteOrder.nativeOrder());
        x = bytebuffer.asFloatBuffer();
        x.put(a);
        x.position(0);
        bytebuffer = ByteBuffer.allocateDirect(b.length * 4);
        bytebuffer.order(ByteOrder.nativeOrder());
        y = bytebuffer.asFloatBuffer();
        y.put(b);
        y.position(0);
        z = GLES20.glGetAttribLocation(D, "vPosition");
        GLES20.glEnableVertexAttribArray(z);
        GLES20.glVertexAttribPointer(z, 2, 5126, false, 8, x);
        A = GLES20.glGetAttribLocation(D, "inputTextureCoordinate");
        GLES20.glEnableVertexAttribArray(A);
        GLES20.glVertexAttribPointer(A, 2, 5126, false, 8, y);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, c);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(D, "inputImageTexture"), 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "gamma"), p);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "contrast"), o);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "saturation"), q);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "whiteblance"), r);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "sharpness"), n);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "shadows"), s);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "highlights"), t);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "colortemperature"), u);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "imageWidthFactor"), 1.0F / (float)d);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(D, "imageHeightFactor"), 1.0F / (float)e);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(z);
        GLES20.glDisableVertexAttribArray(A);
    }

    public void b(float f1)
    {
        float f2 = Math.abs(f - p);
        p = f1;
        if (f2 > C)
        {
            f = p;
        }
    }

    public void c(float f1)
    {
        float f2 = Math.abs(f1 - g);
        n = f1;
        if (f2 > C)
        {
            g = n;
        }
    }

    public void d(float f1)
    {
        float f2 = Math.abs(f1 - h);
        o = f1;
        if (f2 > C)
        {
            h = o;
        }
    }

    public void e(float f1)
    {
        float f2 = Math.abs(f1 - j);
        r = f1;
        if (f2 > C)
        {
            j = r;
        }
    }

    public void f(float f1)
    {
        float f2 = Math.abs(f1 - j);
        s = f1;
        if (f2 > C)
        {
            k = s;
        }
    }

    public void g(float f1)
    {
        float f2 = Math.abs(f1 - l);
        t = f1;
        if (f2 > C)
        {
            l = t;
        }
    }

    public void h(float f1)
    {
        float f2 = Math.abs(f1 - m);
        u = f1;
        if (f2 > C)
        {
            m = u;
        }
    }

}
