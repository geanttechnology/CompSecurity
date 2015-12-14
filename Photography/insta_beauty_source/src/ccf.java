// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyBlendMode;

public class ccf extends byh
{

    private int A[] = {
        -1
    };
    private int B[] = {
        -1
    };
    protected int a;
    protected int b;
    private Bitmap c;
    private GPUImageBeautyBlendMode d;
    private float e;
    private int f;
    private boolean g;
    private boolean w;
    private float x;
    private cdn y;
    private boolean z;

    public ccf()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        c = null;
        e = 1.0F;
        f = -1;
        g = false;
        w = false;
        x = 0.0F;
        z = false;
        a = 0;
        b = 0;
    }

    static int a(ccf ccf1)
    {
        return ccf1.f;
    }

    static int a(ccf ccf1, int i)
    {
        ccf1.f = i;
        return i;
    }

    static void a(int i, int i1, int ai[], int ai1[])
    {
        if (ai1[0] != -1)
        {
            GLES20.glDeleteTextures(1, ai1, 0);
            ai1[0] = -1;
        }
        if (ai[0] != -1)
        {
            GLES20.glDeleteFramebuffers(1, ai, 0);
            ai[0] = -1;
        }
        GLES20.glGenFramebuffers(1, ai, 0);
        GLES20.glBindFramebuffer(36160, ai[0]);
        GLES20.glGenTextures(1, ai1, 0);
        GLES20.glBindTexture(3553, ai1[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i1, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, ai1[0], 0);
        GLES20.glCheckFramebufferStatus(36160);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private int b(GPUImageBeautyBlendMode gpuimagebeautyblendmode)
    {
        switch (cch.a[gpuimagebeautyblendmode.ordinal()])
        {
        default:
            return -1;

        case 1: // '\001'
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 3;

        case 5: // '\005'
            return 4;

        case 6: // '\006'
            return 5;

        case 7: // '\007'
            return 6;

        case 8: // '\b'
            return 7;

        case 9: // '\t'
            return 8;

        case 10: // '\n'
            return 9;

        case 11: // '\013'
            return 10;

        case 12: // '\f'
            return 11;

        case 13: // '\r'
            return 12;

        case 14: // '\016'
            return 13;

        case 15: // '\017'
            return 14;

        case 16: // '\020'
            return 15;

        case 17: // '\021'
            return 16;

        case 18: // '\022'
            return 17;

        case 19: // '\023'
            return 18;

        case 20: // '\024'
            return 19;

        case 21: // '\025'
            return 20;

        case 22: // '\026'
            return 21;

        case 23: // '\027'
            return 22;

        case 24: // '\030'
            return 23;

        case 25: // '\031'
            return 24;

        case 26: // '\032'
            return 25;

        case 27: // '\033'
            return 26;
        }
    }

    static boolean b(ccf ccf1)
    {
        return ccf1.z;
    }

    static Bitmap c(ccf ccf1)
    {
        return ccf1.c;
    }

    private void j()
    {
        if (c == null)
        {
            return;
        } else
        {
            k();
            a(new ccg(this));
            return;
        }
    }

    private void k()
    {
        if (f != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                f
            }, 0);
            f = -1;
        }
    }

    private void l()
    {
        y = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\nattribute highp vec4 inputBlendTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blendTextureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    blendTextureCoordinate = inputBlendTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\nvarying highp vec2 blendTextureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureLUT;\nuniform sampler2D inputBlendImageTexture;\nuniform lowp int blendMode;\nuniform lowp float blendAlpha;\nuniform lowp float filterLevel;\n \n \n lowp vec4 blend(highp vec4 srcColor, highp vec4 blendColor, lowp int blendMode, lowp float blendAlpha){ \n   if (blendMode == 0) { //BlendModeNormal \n\t\treturn blendColor; \n\t} \n   else if (blendMode == 2) { //BlendModeDarken \n\t\tlowp vec4 newColor = vec4(min(srcColor.r, blendColor.r), min(srcColor.g, blendColor.g), min(srcColor.b, blendColor.b), 1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 3) { //BlendModeMultiply \n\t\tlowp vec4 newColor = srcColor * blendColor; \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 4) { //BlendModeColorBurn \n\t\tlowp vec4 newColor = vec4(1.0) - (vec4(1.0) - srcColor) / blendColor; \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 5) { //BlendModeLinearBurn \n\t\tlowp vec4 newColor = srcColor + blendColor - vec4(1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 7) { //BlendModeLighten \n\t\tlowp vec4 newColor = vec4(max(srcColor.r, blendColor.r), max(srcColor.g, blendColor.g), max(srcColor.b, blendColor.b), 1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 8) { //BlendModeScreen \n\t\tlowp vec4 newColor = vec4(1.0) - (vec4(1.0) - srcColor) * (vec4(1.0) - blendColor); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 9) { //BlendModeColorDodge \n\t\tlowp vec4 newColor = srcColor / (vec4(1.0) - blendColor); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 10) { //BlendModeLinearDodge \n\t\tlowp vec4 newColor = srcColor + blendColor; \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 12) { //BlendModeOverlay \n\t\tlowp float newr; \n\t\tlowp float newg; \n\t\tlowp float newb; \n\t\tif (srcColor.r > 0.5) { \n\t\t    newr = 1.0 - (1.0 - 2.0*(srcColor.r - 0.5))*(1.0 - blendColor.r); \n\t\t} else { \n\t\t    newr = 2.0 * srcColor.r * blendColor.r; \n\t\t} \n\t\tif (srcColor.g > 0.5) { \n\t\t    newg = 1.0 - (1.0 - 2.0*(srcColor.g - 0.5))*(1.0 - blendColor.g); \n\t\t} else { \n\t\t    newg = 2.0 * srcColor.g * blendColor.g; \n\t\t} \n\t\tif (srcColor.b > 0.5) { \n\t\t    newb = 1.0 - (1.0 - 2.0*(srcColor.b - 0.5))*(1.0 - blendColor.b); \n\t\t} else { \n\t\t    newb = 2.0 * srcColor.b * blendColor.b; \n\t\t} \n\t\tlowp vec4 newColor = vec4(newr, newg, newb, 1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 13) { //BlendModeSoftLight \n\t\tlowp vec4 newColor = (vec4(1.0) - srcColor)*blendColor*srcColor + srcColor*(vec4(1.0) - (vec4(1.0) - blendColor)*(vec4(1.0) - srcColor)); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 14) { //BlendModeHardLight \n\t\tlowp vec4 newColor; \n\t\tif (srcColor.r < 0.5 && srcColor.g < 0.5 && srcColor.b < 0.5) { \n\t\t\tnewColor = vec4(2.0) * srcColor * blendColor; \n\t\t} \n\t\telse { \n\t\t\tnewColor = vec4(1.0) - vec4(2.0) * (vec4(1.0) - srcColor) * (vec4(1.0) - blendColor); \n\t\t} \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 15) { //BlendModeVividLight \n\t\tlowp vec4 newColor; \n\t\tif (blendColor.r < 0.5 && blendColor.g < 0.5 && blendColor.b < 0.5) { \n\t\t\tnewColor = vec4(1.0) - (vec4(1.0) - srcColor) / vec4(2.0) * blendColor; \n\t\t} \n\t\telse { \n\t\t\tnewColor = srcColor / (vec4(1.0) - vec4(2.0) * (blendColor - vec4(0.5))); \n\t\t} \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 19) { //BlendModeDifference \n\t\tlowp vec4 newColor = vec4(abs(srcColor.r - blendColor.r), abs(srcColor.g - blendColor.g), abs(srcColor.b - blendColor.b), 1.0); \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else if (blendMode == 20) { //BlendModeExclusion \n\t\tlowp vec4 newColor = blendColor + srcColor - vec4(2.0)*srcColor*blendColor; \n\t    newColor = mix(srcColor, newColor, blendAlpha); \n\t    newColor = clamp(newColor, vec4(0.0), vec4(1.0)); \n\t\treturn newColor; \n\t} \n   else { \n\t\treturn srcColor; \n\t} \n  } \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 originalColor = vec4(textureColor.rgb, 1.0);\n\n     lowp vec4 rgbColor = vec4(textureColor.rgb, 1.0);\n\n     lowp float luminance = dot(rgbColor.rgb, vec3(0.2125, 0.7154, 0.0721));\n     rgbColor = vec4(vec3(luminance), rgbColor.a);\n     lowp vec4 blendColor = texture2D(inputBlendImageTexture, blendTextureCoordinate);\n \n     rgbColor = blend(rgbColor, blendColor, blendMode, blendAlpha);\n \n     gl_FragColor = mix(originalColor, rgbColor, filterLevel);\n     //gl_FragColor = blendColor;\n}");
    }

    private void m()
    {
        if (A[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, A, 0);
            A[0] = -1;
        }
        if (B[0] != -1)
        {
            GLES20.glDeleteTextures(1, B, 0);
            B[0] = -1;
        }
    }

    public void a()
    {
        super.a();
    }

    public void a(float f1)
    {
        u = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || a == i && b == i1) 
        {
            return;
        }
        a = i;
        b = i1;
        m();
        a(b, a, A, B);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        y.a();
        GLES20.glBindFramebuffer(36160, A[0]);
        GLES20.glViewport(0, 0, b, a);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(y.a("position"));
        GLES20.glVertexAttribPointer(y.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(y.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(y.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (!g)
        {
            floatbuffer = new float[8];
            floatbuffer1.get(floatbuffer);
            if (w)
            {
                floatbuffer[0] = x;
                floatbuffer[2] = 1.0F - x;
                floatbuffer[4] = x;
                floatbuffer[6] = 1.0F - x;
            } else
            {
                floatbuffer[1] = Math.abs(floatbuffer[1] - x);
                floatbuffer[3] = Math.abs(floatbuffer[3] - x);
                floatbuffer[5] = Math.abs(floatbuffer[5] - x);
                floatbuffer[7] = Math.abs(floatbuffer[7] - x);
            }
            floatbuffer1 = ByteBuffer.allocateDirect(floatbuffer.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            floatbuffer1.put(floatbuffer).position(0);
            GLES20.glEnableVertexAttribArray(y.a("inputBlendTextureCoordinate"));
            GLES20.glVertexAttribPointer(y.a("inputBlendTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        } else
        {
            floatbuffer1.position(0);
            GLES20.glEnableVertexAttribArray(y.a("inputBlendTextureCoordinate"));
            GLES20.glVertexAttribPointer(y.a("inputBlendTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        }
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(y.b("inputImageTexture"), 0);
        }
        if (f != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, f);
            GLES20.glUniform1i(y.b("inputBlendImageTexture"), 1);
        }
        GLES20.glUniform1i(y.b("blendMode"), b(d));
        GLES20.glUniform1f(y.b("blendAlpha"), e);
        GLES20.glUniform1f(y.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(y.a("position"));
        GLES20.glDisableVertexAttribArray(y.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    public void a(Bitmap bitmap)
    {
        c = bitmap;
        j();
    }

    public void a(GPUImageBeautyBlendMode gpuimagebeautyblendmode)
    {
        d = gpuimagebeautyblendmode;
    }

    public void a(boolean flag)
    {
        z = flag;
    }

    public void a(boolean flag, Bitmap bitmap, Bitmap bitmap1)
    {
        int i;
        int i1;
label0:
        {
            g = flag;
            if (!g)
            {
                i1 = 3;
                i = 4;
                if (bitmap != null)
                {
                    i1 = bitmap.getWidth();
                    i = bitmap.getHeight();
                }
                int j1 = bitmap1.getWidth();
                int k1 = bitmap1.getHeight();
                float f1 = (float)i1 / (float)i;
                if ((float)j1 / (float)k1 <= f1)
                {
                    break label0;
                }
                w = true;
                x = (1.0F - (float)i1 / (float)i) * 0.5F;
            }
            return;
        }
        w = false;
        x = (1.0F - (float)i / (float)i1) * 0.5F;
    }

    public void b(float f1)
    {
        e = f1;
    }

    public void b(int i, int i1)
    {
        while (n == i && o == i1 || i == 0 || i1 == 0) 
        {
            return;
        }
        n = i;
        o = i1;
    }

    public void c()
    {
        super.c();
        l();
    }

    public void d()
    {
        super.d();
        k();
        y.a(true);
        m();
    }

    public int f()
    {
        return B[0];
    }
}
