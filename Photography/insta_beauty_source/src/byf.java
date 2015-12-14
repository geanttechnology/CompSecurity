// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class byf extends byh
{

    static double a = 3.1415926535897931D;
    private int A[] = {
        -1
    };
    private int B[] = {
        -1
    };
    private int C[] = {
        -1
    };
    private int D[] = {
        -1
    };
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    FloatBuffer b;
    FloatBuffer c;
    public float d;
    protected int e;
    protected int f;
    int g;
    private int w;
    private Bitmap x;
    private int y;
    private int z;

    public byf(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        x = null;
        y = -1;
        z = -1;
        E = -1;
        d = 0.66F;
        e = 0;
        f = 0;
        g = 0;
        x = bitmap;
        k();
    }

    static int a(byf byf1)
    {
        return byf1.z;
    }

    static int a(byf byf1, int i)
    {
        byf1.z = i;
        return i;
    }

    private void a(int i)
    {
        double d1 = Math.pow(i, 2D);
        int i1 = (int)Math.floor(Math.sqrt(Math.log(0.00390625D * Math.sqrt(a * 2D * Math.pow(i, 2D))) * (-2D * d1)));
        i1 += i1 % 2;
        j = OpenGlUtils.a(b(i1, i), c(i1, i));
        k = GLES20.glGetAttribLocation(j, "position");
        l = GLES20.glGetUniformLocation(j, "inputImageTexture");
        m = GLES20.glGetAttribLocation(j, "inputTextureCoordinate");
        E = OpenGlUtils.a(b(i1, i), d(i1, i));
        F = GLES20.glGetAttribLocation(E, "position");
        G = GLES20.glGetUniformLocation(E, "inputImageTexture");
        H = GLES20.glGetAttribLocation(E, "inputTextureCoordinate");
        w = GLES20.glGetUniformLocation(i(), "inputImageTexture2");
        y = OpenGlUtils.a("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        I = GLES20.glGetUniformLocation(y, "inputImageTexture");
        J = GLES20.glGetAttribLocation(y, "inputTextureCoordinate");
        K = GLES20.glGetAttribLocation(y, "position");
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
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void a(Bitmap bitmap)
    {
        x = bitmap;
        a(((Runnable) (new byg(this, bitmap))));
    }

    private static String b(int i, float f1)
    {
        if (OpenGlUtils.a() == jp.co.cyberagent.android.gpuimage.OpenGlUtils.GPURenderType.GPUImageRender_RGB)
        {
            return "  attribute vec4 position;\n  attribute vec4 inputTextureCoordinate;\n  \n  const lowp int GAUSSIAN_SAMPLES = 9;\n  \n  uniform highp float texelWidthOffset; \n  uniform highp float texelHeightOffset;\n  uniform highp float blurSize;\n  \n  varying highp vec2 textureCoordinate;\n  varying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n  \n void main() {\n  \tgl_Position = position;\n  \ttextureCoordinate = inputTextureCoordinate.xy;\n  \t\n  \t// Calculate the positions for the blur\n \tint multiplier = 0;\n \thighp vec2 blurStep;\n   highp vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset) * blurSize;\n      \n  \tfor (lowp int i = 0; i < GAUSSIAN_SAMPLES; i++) {\n  \t\tmultiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n       // Blur in x (horizontal)\n       blurStep = float(multiplier) * singleStepOffset;\n  \t\tblurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n  \t}\n  }";
        } else
        {
            return e(i, f1);
        }
    }

    private static String c(int i, float f1)
    {
        if (OpenGlUtils.a() == jp.co.cyberagent.android.gpuimage.OpenGlUtils.GPURenderType.GPUImageRender_RGB)
        {
            return "varying highp vec2 textureCoordinate;\n \n  const lowp int GAUSSIAN_SAMPLES = 9;\n varying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform lowp float brightness;\n \n void main()\n {\n     mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n mediump float sum = 0.0; \n  \n sum += texture2D(inputImageTexture, blurCoordinates[0]).a * 0.05; \n sum += texture2D(inputImageTexture, blurCoordinates[1]).a * 0.09; \n sum += texture2D(inputImageTexture, blurCoordinates[2]).a * 0.12; \n sum += texture2D(inputImageTexture, blurCoordinates[3]).a * 0.15; \n sum += texture2D(inputImageTexture, blurCoordinates[4]).a * 0.18; \n sum += texture2D(inputImageTexture, blurCoordinates[5]).a * 0.15; \n sum += texture2D(inputImageTexture, blurCoordinates[6]).a * 0.12; \n sum += texture2D(inputImageTexture, blurCoordinates[7]).a * 0.09; \n sum += texture2D(inputImageTexture, blurCoordinates[8]).a * 0.05; \n  \n mediump float avg = sum;\n mediump float ori = textureColor.r*0.2989 + textureColor.g*0.5870 + textureColor.b*0.1140;\n mediump vec2 maskcord = vec2(avg,ori);\n mediump vec4 maskcolor = texture2D(inputImageTexture2, maskcord);\n mediump vec2 rrrcord = vec2(ori,avg);\n mediump float rrr = texture2D(inputImageTexture2, vec2(maskcolor.r,textureColor.r)).g;\n mediump float ggg = texture2D(inputImageTexture2, vec2(maskcolor.r,textureColor.g)).g;\n mediump float bbb = texture2D(inputImageTexture2, vec2(maskcolor.r,textureColor.b)).g;\n gl_FragColor = vec4(rrr, ggg, bbb, 1.0); \n }";
        } else
        {
            return g(i, f1);
        }
    }

    private static String d(int i, float f1)
    {
        if (OpenGlUtils.a() == jp.co.cyberagent.android.gpuimage.OpenGlUtils.GPURenderType.GPUImageRender_RGB)
        {
            return "varying highp vec2 textureCoordinate;\n \n  const lowp int GAUSSIAN_SAMPLES = 9;\n varying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform lowp float brightness;\n \n void main()\n {\n     mediump vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n mediump vec4 sum = vec4(0.0); \n  \n sum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.05; \n sum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.09; \n sum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.12; \n sum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.15; \n sum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.18; \n sum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.15; \n sum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.12; \n sum += texture2D(inputImageTexture, blurCoordinates[7]) * 0.09; \n sum += texture2D(inputImageTexture, blurCoordinates[8]) * 0.05; \n  \n mediump float avg = sum.r*0.2989 + sum.g*0.5870 + sum.b*0.1140;\n gl_FragColor = vec4(textureColor.rgb, avg); \n }";
        } else
        {
            return f(i, f1);
        }
    }

    private static String e(int i, float f1)
    {
        if (i < 1)
        {
            return "attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
        }
        float af[] = new float[i + 1];
        float f2 = 0.0F;
        int i1 = 0;
        while (i1 < i + 1) 
        {
            af[i1] = (float)((1.0D / Math.sqrt(2D * a * Math.pow(f1, 2D))) * Math.exp(-Math.pow(i1, 2D) / (2D * Math.pow(f1, 2D))));
            if (i1 == 0)
            {
                f2 = af[i1] + f2;
            } else
            {
                f2 = (float)((double)f2 + 2D * (double)af[i1]);
            }
            i1++;
        }
        for (i1 = 0; i1 < i + 1; i1++)
        {
            af[i1] = af[i1] / f2;
        }

        i1 = Math.min(i / 2 + i % 2, j());
        float af1[] = new float[i1];
        for (i = 0; i < i1; i++)
        {
            f1 = af[i * 2 + 1];
            float f3 = af[i * 2 + 2];
            af1[i] = (f1 * (float)(i * 2 + 1) + f3 * (float)(i * 2 + 2)) / (f1 + f3);
        }

        String s = (new StringBuilder()).append("  attribute vec4 position;\n  attribute vec4 inputTextureCoordinate;\n  \n  \n  uniform highp float texelWidthOffset; \n  uniform highp float texelHeightOffset;\n  uniform highp float blurSize;\n  \n  varying highp vec2 textureCoordinate;\n").append(String.format(Locale.US, "  varying highp vec2 blurCoordinates[%d];\n", new Object[] {
            Integer.valueOf(i1 * 2 + 1)
        })).toString();
        s = (new StringBuilder()).append(s).append("  \n void main() {\n  \tgl_Position = position;\n  \ttextureCoordinate = inputTextureCoordinate.xy;\n  \t\n  \t// Calculate the positions for the blur\n   highp vec2 singleStepOffset = vec2( texelWidthOffset,texelHeightOffset ) ;\n      \n").toString();
        s = (new StringBuilder()).append(s).append("blurCoordinates[0] = inputTextureCoordinate.xy;\n").toString();
        for (i = 0; i < i1; i++)
        {
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " blurCoordinates[%d] = inputTextureCoordinate.xy + singleStepOffset * %f;\n", new Object[] {
                Integer.valueOf(i * 2 + 1), Float.valueOf(af1[i])
            })).toString();
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " blurCoordinates[%d] = inputTextureCoordinate.xy - singleStepOffset * %f;\n", new Object[] {
                Integer.valueOf(i * 2 + 2), Float.valueOf(af1[i])
            })).toString();
        }

        return (new StringBuilder()).append(s).append("  }").toString();
    }

    private static String f(int i, float f1)
    {
        if (i < 1)
        {
            return "attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
        }
        float af[] = new float[i + 1];
        float f2 = 0.0F;
        int i1 = 0;
        while (i1 < i + 1) 
        {
            af[i1] = (float)((1.0D / Math.sqrt(2D * a * Math.pow(f1, 2D))) * Math.exp(-Math.pow(i1, 2D) / (2D * Math.pow(f1, 2D))));
            if (i1 == 0)
            {
                f2 = af[i1] + f2;
            } else
            {
                f2 = (float)((double)f2 + 2D * (double)af[i1]);
            }
            i1++;
        }
        for (i1 = 0; i1 < i + 1; i1++)
        {
            af[i1] = af[i1] / f2;
        }

        i1 = Math.min(i / 2 + i % 2, j());
        int j1 = i / 2 + i % 2;
        String s = (new StringBuilder()).append("varying highp vec2 textureCoordinate;\n \n  uniform highp float texelWidthOffset; \n  uniform highp float texelHeightOffset;\n").append(String.format(Locale.US, " varying highp vec2 blurCoordinates[%d];\n", new Object[] {
            Integer.valueOf(i1 * 2 + 1)
        })).toString();
        s = (new StringBuilder()).append(s).append(" uniform sampler2D inputImageTexture;\n uniform lowp float brightness;\n \n void main()\n {\n     mediump vec4 yuv = texture2D(inputImageTexture, textureCoordinate);\n     \n mediump float sum = 0.0; \n  \n").toString();
        s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[0]).r * %f; \n", new Object[] {
            Float.valueOf(af[0])
        })).toString();
        for (i = 0; i < i1; i++)
        {
            f1 = af[i * 2 + 1] + af[i * 2 + 2];
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[%d]).r * %f; \n", new Object[] {
                Integer.valueOf(i * 2 + 1), Float.valueOf(f1)
            })).toString();
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[%d]).r * %f; \n", new Object[] {
                Integer.valueOf(i * 2 + 2), Float.valueOf(f1)
            })).toString();
        }

        String s1 = s;
        if (j1 > i1)
        {
            s = (new StringBuilder()).append(s).append("highp vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n").toString();
            i = i1;
            do
            {
                s1 = s;
                if (i >= j1)
                {
                    break;
                }
                float f3 = af[i * 2 + 1];
                float f4 = af[i * 2 + 2];
                f1 = f3 + f4;
                f3 = (f3 * (float)(i * 2 + 1) + f4 * (float)(i * 2 + 2)) / f1;
                s = (new StringBuilder()).append(s).append(String.format(Locale.US, "sum += texture2D(inputImageTexture, blurCoordinates[0] + singleStepOffset * %f).r * %f;\n", new Object[] {
                    Float.valueOf(f3), Float.valueOf(f1)
                })).toString();
                s = (new StringBuilder()).append(s).append(String.format(Locale.US, "sum += texture2D(inputImageTexture, blurCoordinates[0] - singleStepOffset * %f).r * %f;\n", new Object[] {
                    Float.valueOf(f3), Float.valueOf(f1)
                })).toString();
                i++;
            } while (true);
        }
        return (new StringBuilder()).append(s1).append("  \n gl_FragColor = vec4(yuv.rgb, sum); \n }").toString();
    }

    private static String g(int i, float f1)
    {
        if (i < 1)
        {
            return "attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
        }
        float af[] = new float[i + 1];
        float f2 = 0.0F;
        int i1 = 0;
        while (i1 < i + 1) 
        {
            af[i1] = (float)((1.0D / Math.sqrt(2D * a * Math.pow(f1, 2D))) * Math.exp(-Math.pow(i1, 2D) / (2D * Math.pow(f1, 2D))));
            if (i1 == 0)
            {
                f2 = af[i1] + f2;
            } else
            {
                f2 = (float)((double)f2 + 2D * (double)af[i1]);
            }
            i1++;
        }
        for (i1 = 0; i1 < i + 1; i1++)
        {
            af[i1] = af[i1] / f2;
        }

        i1 = Math.min(i / 2 + i % 2, j());
        int j1 = i / 2 + i % 2;
        String s = (new StringBuilder()).append("varying highp vec2 textureCoordinate;\n \n  uniform highp float texelWidthOffset; \n  uniform highp float texelHeightOffset;\n").append(String.format(Locale.US, " varying highp vec2 blurCoordinates[%d];\n", new Object[] {
            Integer.valueOf(i1 * 2 + 1)
        })).toString();
        s = (new StringBuilder()).append(s).append(" uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform lowp float alphaValue;\n \n void main()\n {\n     mediump vec4 yuv = texture2D(inputImageTexture, textureCoordinate);\n     \n mediump float sum = 0.0; \n  \n").toString();
        s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[0]).a * %f; \n", new Object[] {
            Float.valueOf(af[0])
        })).toString();
        for (i = 0; i < i1; i++)
        {
            f1 = af[i * 2 + 1] + af[i * 2 + 2];
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[%d]).a * %f; \n", new Object[] {
                Integer.valueOf(i * 2 + 1), Float.valueOf(f1)
            })).toString();
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[%d]).a * %f; \n", new Object[] {
                Integer.valueOf(i * 2 + 2), Float.valueOf(f1)
            })).toString();
        }

        String s1 = s;
        if (j1 > i1)
        {
            s = (new StringBuilder()).append(s).append("highp vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n").toString();
            i = i1;
            do
            {
                s1 = s;
                if (i >= j1)
                {
                    break;
                }
                float f3 = af[i * 2 + 1];
                float f4 = af[i * 2 + 2];
                f1 = f3 + f4;
                f3 = (f3 * (float)(i * 2 + 1) + f4 * (float)(i * 2 + 2)) / f1;
                s = (new StringBuilder()).append(s).append(String.format(Locale.US, "sum += texture2D(inputImageTexture, blurCoordinates[0] + singleStepOffset * %f).a * %f;\n", new Object[] {
                    Float.valueOf(f3), Float.valueOf(f1)
                })).toString();
                s = (new StringBuilder()).append(s).append(String.format(Locale.US, "sum += texture2D(inputImageTexture, blurCoordinates[0] - singleStepOffset * %f).a * %f;\n", new Object[] {
                    Float.valueOf(f3), Float.valueOf(f1)
                })).toString();
                i++;
            } while (true);
        }
        return (new StringBuilder()).append(s1).append(" mediump float avg = sum;\n mediump float ori = yuv.r;\n mediump vec2 maskcord = vec2(avg,ori);\n mediump vec4 maskcolor = texture2D(inputImageTexture2, maskcord);\n yuv.r =  texture2D(inputImageTexture2, vec2(maskcolor.r,ori)).g*alphaValue + (1.0 - alphaValue)*ori;\n mediump vec2 rrrcord = vec2(ori,avg);\n  mediump vec3 rgb; \n  mediump float y = 1.164*(yuv.r - 0.0625) ; \n  mediump float u = yuv.g - 0.5; \n  mediump float v = yuv.b - 0.5; \n  rgb.r = y + 1.596*v; \n  rgb.g = y - 0.813*v - 0.391*u ; \n  rgb.b = y                  + 2.018*u ; \n gl_FragColor = vec4(rgb, 1.0); \n }").toString();
    }

    private static int j()
    {
        int ai[] = new int[1];
        ai[0] = 4;
        GLES20.glGetIntegerv(36348, ai, 0);
        int i = (int)((double)ai[0] / 2D - 1.0D);
        if (i < 0)
        {
            return 0;
        } else
        {
            return i;
        }
    }

    private void k()
    {
        b = ByteBuffer.allocateDirect(byi.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        b.put(byi.a).position(0);
        c = ByteBuffer.allocateDirect(byq.d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        c.put(byq.d).position(0);
    }

    private boolean l()
    {
        return j != -1 && E != -1 && y != -1;
    }

    private void m()
    {
        if (j >= 0)
        {
            GLES20.glDeleteProgram(j);
            j = -1;
        }
        if (E >= 0)
        {
            GLES20.glDeleteProgram(E);
            E = -1;
        }
        if (y >= 0)
        {
            GLES20.glDeleteProgram(y);
            y = -1;
        }
    }

    private void n()
    {
        if (A[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, A, 0);
            A[0] = -1;
        }
        if (C[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, C, 0);
            C[0] = -1;
        }
        if (B[0] != -1)
        {
            GLES20.glDeleteTextures(1, B, 0);
            B[0] = -1;
        }
        if (D[0] != -1)
        {
            GLES20.glDeleteTextures(1, D, 0);
            D[0] = -1;
        }
    }

    public void a()
    {
        super.a();
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        break MISSING_BLOCK_LABEL_6;
_L2:
        do
        {
            return;
        } while (i == 0 || i1 == 0 || e == i && f == i1);
        e = i;
        f = i1;
        n();
        a(f, e, A, B);
        a(f, e, C, D);
        i = 2;
        if (f <= 360)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 3;
_L3:
        if (g != i || !l())
        {
            g = i;
            m();
            a(i);
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (f > 500)
        {
            i = 4;
        } else
        if (f > 640)
        {
            i = 5;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        int ai[] = new int[1];
        ai[0] = 0;
        GLES20.glGetIntegerv(36006, ai, 0);
        int ai1[] = new int[4];
        int[] _tmp = ai1;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        GLES20.glGetIntegerv(2978, ai1, 0);
        GLES20.glBindFramebuffer(36160, A[0]);
        GLES20.glViewport(0, 0, f, e);
        GLES20.glUseProgram(E);
        a(GLES20.glGetUniformLocation(E, "texelHeightOffset"), (float)(1.5D / (double)f));
        a(GLES20.glGetUniformLocation(E, "texelWidthOffset"), 0.0F);
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(F, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(F);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(H, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(H);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(G, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(F);
        GLES20.glDisableVertexAttribArray(H);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, C[0]);
        GLES20.glUseProgram(j);
        a(GLES20.glGetUniformLocation(j, "texelWidthOffset"), 0.0F);
        a(GLES20.glGetUniformLocation(j, "texelHeightOffset"), (float)(1.5D / (double)e));
        a(GLES20.glGetUniformLocation(j, "alphaValue"), d);
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(k, 2, 5126, false, 0, b);
        GLES20.glEnableVertexAttribArray(k);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(m, 2, 5126, false, 0, c);
        GLES20.glEnableVertexAttribArray(m);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, B[0]);
        GLES20.glUniform1i(l, 0);
        b();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(k);
        GLES20.glDisableVertexAttribArray(m);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, ai[0]);
        GLES20.glViewport(ai1[1], ai1[1], ai1[2], ai1[3]);
        GLES20.glUseProgram(y);
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(K, 2, 5126, false, 0, b);
        GLES20.glEnableVertexAttribArray(K);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(J, 2, 5126, false, 0, c);
        GLES20.glEnableVertexAttribArray(J);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, D[0]);
        GLES20.glUniform1i(I, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(K);
        GLES20.glDisableVertexAttribArray(J);
        GLES20.glBindTexture(3553, 0);
    }

    protected void b()
    {
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, z);
        GLES20.glUniform1i(w, 3);
    }

    public void b(int i, int i1)
    {
        while (n == i && o == i1 || i == 0 || i1 == 0) 
        {
            return;
        }
        n = i;
        o = i1;
        float af[] = byi.a;
        float f1 = byi.a[0];
        float f2 = byi.a[1];
        float f3 = byi.a[2];
        float f4 = byi.a[3];
        float f5 = byi.a[4];
        float f6 = byi.a[5];
        float f7 = byi.a[6];
        float f8 = byi.a[7];
        b.put(new float[] {
            f1 * 1.0F, f2, f3 * 1.0F, f4, f5 * 1.0F, f6, 1.0F * f7, f8
        }).position(0);
    }

    public void c()
    {
        if (x != null)
        {
            a(x);
        }
    }

    public void d()
    {
        super.d();
        GLES20.glDeleteTextures(1, new int[] {
            z
        }, 0);
        z = -1;
        n();
        m();
    }

}
