// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Locale;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class cco extends byh
{

    static double a = 3.1415926535897931D;
    private Bitmap A;
    private int B;
    private float C;
    private float D;
    private boolean E;
    private int F[] = {
        -1
    };
    private int G[] = {
        -1
    };
    private int H[] = {
        -1
    };
    private int I[] = {
        -1
    };
    private int J[] = {
        -1
    };
    private int K[] = {
        -1
    };
    private int L;
    private int M;
    private int N;
    private int O;
    private float P[];
    private String Q;
    FloatBuffer b;
    FloatBuffer c;
    public float d;
    protected int e;
    protected int f;
    int g;
    private int w;
    private Bitmap x;
    private int y;
    private boolean z;

    public cco()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        x = null;
        y = -1;
        z = false;
        A = null;
        B = -1;
        C = 0.66F;
        D = 0.7F;
        E = false;
        L = -1;
        d = 0.66F;
        P = cdo.a;
        e = 0;
        f = 0;
        g = 0;
        Q = "";
        m();
    }

    public cco(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        x = null;
        y = -1;
        z = false;
        A = null;
        B = -1;
        C = 0.66F;
        D = 0.7F;
        E = false;
        L = -1;
        d = 0.66F;
        P = cdo.a;
        e = 0;
        f = 0;
        g = 0;
        Q = "";
        A = bitmap;
        m();
    }

    static int a(cco cco1)
    {
        return cco1.B;
    }

    static int a(cco cco1, int i)
    {
        cco1.B = i;
        return i;
    }

    private static String a(int i, float f1, boolean flag)
    {
        return b(i, f1, flag);
    }

    private void a(int i)
    {
        double d1 = Math.pow(i, 2D);
        int i1 = (int)Math.floor(Math.sqrt(Math.log(0.00390625D * Math.sqrt(a * 2D * Math.pow(i, 2D))) * (-2D * d1)));
        i1 -= i1 % 2;
        j = OpenGlUtils.a(b(i1, i), c(i1, i), Q);
        k = GLES20.glGetAttribLocation(j, "position");
        l = GLES20.glGetUniformLocation(j, "inputImageTexture");
        m = GLES20.glGetAttribLocation(j, "inputTextureCoordinate");
        L = OpenGlUtils.a(b(i1, i), a(i1, i, E), Q);
        M = GLES20.glGetAttribLocation(L, "position");
        N = GLES20.glGetUniformLocation(L, "inputImageTexture");
        O = GLES20.glGetAttribLocation(L, "inputTextureCoordinate");
        w = GLES20.glGetUniformLocation(i(), "inputImageTexture2");
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
        a(((Runnable) (new ccq(this, bitmap))));
    }

    static int b(cco cco1, int i)
    {
        cco1.y = i;
        return i;
    }

    static Bitmap b(cco cco1)
    {
        return cco1.A;
    }

    private static String b(int i, float f1)
    {
        return d(i, f1);
    }

    private static String b(int i, float f1, boolean flag)
    {
        int i1 = i;
        if (i < 1)
        {
            i1 = 1;
        }
        float af[] = new float[i1 + 1];
        float f2 = 0.0F;
        i = 0;
        while (i < i1 + 1) 
        {
            af[i] = (float)((1.0D / Math.sqrt(2D * a * Math.pow(f1, 2D))) * Math.exp(-Math.pow(i, 2D) / (2D * Math.pow(f1, 2D))));
            if (i == 0)
            {
                f2 = af[i] + f2;
            } else
            {
                f2 = (float)((double)f2 + 2D * (double)af[i]);
            }
            i++;
        }
        for (i = 0; i < i1 + 1; i++)
        {
            af[i] = af[i] / f2;
        }

        int j1 = Math.min(i1 / 2 + i1 % 2, l());
        i1 = i1 / 2 + i1 % 2;
        String s;
        String s1;
        if (flag)
        {
            s1 = "#extension GL_OES_EGL_image_external : require \n";
            s = " uniform samplerExternalOES inputImageTexture;\n";
        } else
        {
            s1 = " \n";
            s = " uniform sampler2D inputImageTexture;\n";
        }
        s1 = (new StringBuilder()).append(s1).append("  varying highp vec2 textureCoordinate;\n").append(" \n").append("  uniform highp float texelWidthOffset; \n").append("  uniform highp float texelHeightOffset;\n").toString();
        s1 = (new StringBuilder()).append(s1).append(String.format(Locale.US, " varying highp vec2 blurCoordinates[%d];\n", new Object[] {
            Integer.valueOf(j1 * 2 + 1)
        })).toString();
        s = (new StringBuilder()).append(s1).append(s).append(" uniform lowp float brightness;\n").append(" void main()\n").append(" {\n").append("     mediump vec4 yuv = texture2D(inputImageTexture, textureCoordinate);\n").append("     \n").append(" mediump float sum = 0.0; \n").append("  \n").toString();
        s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[0]).g * %f; \n", new Object[] {
            Float.valueOf(af[0])
        })).toString();
        for (i = 0; i < j1; i++)
        {
            f1 = af[i * 2 + 1] + af[i * 2 + 2];
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[%d]).g * %f; \n", new Object[] {
                Integer.valueOf(i * 2 + 1), Float.valueOf(f1)
            })).toString();
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[%d]).g * %f; \n", new Object[] {
                Integer.valueOf(i * 2 + 2), Float.valueOf(f1)
            })).toString();
        }

        s1 = s;
        if (i1 > j1)
        {
            s = (new StringBuilder()).append(s).append("highp vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n").toString();
            i = j1;
            do
            {
                s1 = s;
                if (i >= i1)
                {
                    break;
                }
                float f3 = af[i * 2 + 1];
                float f4 = af[i * 2 + 2];
                f1 = f3 + f4;
                f3 = (f3 * (float)(i * 2 + 1) + f4 * (float)(i * 2 + 2)) / f1;
                s = (new StringBuilder()).append(s).append(String.format(Locale.US, "sum += texture2D(inputImageTexture, blurCoordinates[0] + singleStepOffset * %f).g * %f;\n", new Object[] {
                    Float.valueOf(f3), Float.valueOf(f1)
                })).toString();
                s = (new StringBuilder()).append(s).append(String.format(Locale.US, "sum += texture2D(inputImageTexture, blurCoordinates[0] - singleStepOffset * %f).g * %f;\n", new Object[] {
                    Float.valueOf(f3), Float.valueOf(f1)
                })).toString();
                i++;
            } while (true);
        }
        return (new StringBuilder()).append(s1).append("  \n gl_FragColor = vec4(yuv.rgb,sum); \n }").toString();
    }

    static int c(cco cco1)
    {
        return cco1.y;
    }

    private static String c(int i, float f1)
    {
        return e(i, f1);
    }

    private static String d(int i, float f1)
    {
        int i1 = i;
        if (i < 1)
        {
            i1 = 1;
        }
        float af[] = new float[i1 + 1];
        float f2 = 0.0F;
        i = 0;
        while (i < i1 + 1) 
        {
            af[i] = (float)((1.0D / Math.sqrt(2D * a * Math.pow(f1, 2D))) * Math.exp(-Math.pow(i, 2D) / (2D * Math.pow(f1, 2D))));
            if (i == 0)
            {
                f2 = af[i] + f2;
            } else
            {
                f2 = (float)((double)f2 + 2D * (double)af[i]);
            }
            i++;
        }
        for (i = 0; i < i1 + 1; i++)
        {
            af[i] = af[i] / f2;
        }

        i1 = Math.min(i1 / 2 + i1 % 2, l());
        float af1[] = new float[i1];
        for (i = 0; i < i1; i++)
        {
            f1 = af[i * 2 + 1];
            float f3 = af[i * 2 + 2];
            af1[i] = (f1 * (float)(i * 2 + 1) + f3 * (float)(i * 2 + 2)) / (f1 + f3);
        }

        String s = (new StringBuilder()).append("uniform highp mat4 uTexMatrix; \n  attribute vec4 position;\n  attribute highp vec4 inputTextureCoordinate;\n  uniform highp float texelWidthOffset; \n  uniform highp float texelHeightOffset;\n  uniform highp float blurSize;\n  \n  varying highp vec2 textureCoordinate;\n").append(String.format(Locale.US, "  varying highp vec2 blurCoordinates[%d];\n", new Object[] {
            Integer.valueOf(i1 * 2 + 1)
        })).toString();
        s = (new StringBuilder()).append(s).append(" void main() {\n  \tgl_Position = position;\n  \ttextureCoordinate =  (uTexMatrix * inputTextureCoordinate).xy;\n   highp vec2 singleStepOffset = vec2( texelWidthOffset,texelHeightOffset ) ;\n").toString();
        s = (new StringBuilder()).append(s).append("blurCoordinates[0] = textureCoordinate;\n").toString();
        for (i = 0; i < i1; i++)
        {
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " blurCoordinates[%d] = textureCoordinate + singleStepOffset * %f;\n", new Object[] {
                Integer.valueOf(i * 2 + 1), Float.valueOf(af1[i])
            })).toString();
            s = (new StringBuilder()).append(s).append(String.format(Locale.US, " blurCoordinates[%d] = textureCoordinate - singleStepOffset * %f;\n", new Object[] {
                Integer.valueOf(i * 2 + 2), Float.valueOf(af1[i])
            })).toString();
        }

        return (new StringBuilder()).append(s).append("}  ").toString();
    }

    private static String e(int i, float f1)
    {
        int i1 = i;
        if (i < 1)
        {
            i1 = 1;
        }
        float af[] = new float[i1 + 1];
        float f2 = 0.0F;
        i = 0;
        while (i < i1 + 1) 
        {
            af[i] = (float)((1.0D / Math.sqrt(2D * a * Math.pow(f1, 2D))) * Math.exp(-Math.pow(i, 2D) / (2D * Math.pow(f1, 2D))));
            if (i == 0)
            {
                f2 = af[i] + f2;
            } else
            {
                f2 = (float)((double)f2 + 2D * (double)af[i]);
            }
            i++;
        }
        for (i = 0; i < i1 + 1; i++)
        {
            af[i] = af[i] / f2;
        }

        int j1 = Math.min(i1 / 2 + i1 % 2, l());
        i1 = i1 / 2 + i1 % 2;
        String s = (new StringBuilder()).append("varying highp vec2 textureCoordinate;\n \n  uniform highp float texelWidthOffset; \n  uniform highp float texelHeightOffset;\n").append(String.format(Locale.US, " varying highp vec2 blurCoordinates[%d];\n", new Object[] {
            Integer.valueOf(j1 * 2 + 1)
        })).toString();
        s = (new StringBuilder()).append(s).append("uniform int enableVirtual;\n").toString();
        s = (new StringBuilder()).append(s).append("uniform sampler2D inputImageTextureVirtual;\n").toString();
        s = (new StringBuilder()).append(s).append(" uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform lowp float alphaValue;\n uniform lowp float softenLevel;\n \n void main()\n {\n     mediump vec4 yuv = texture2D(inputImageTexture, textureCoordinate);\n     \n mediump float sum = 0.0; \n  \n").toString();
        s = (new StringBuilder()).append(s).append(String.format(Locale.US, " sum += texture2D(inputImageTexture, blurCoordinates[0]).a * %f; \n", new Object[] {
            Float.valueOf(af[0])
        })).toString();
        for (i = 0; i < j1; i++)
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
        if (i1 > j1)
        {
            s = (new StringBuilder()).append(s).append("highp vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n").toString();
            i = j1;
            do
            {
                s1 = s;
                if (i >= i1)
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
        s = (new StringBuilder()).append(s1).append(" mediump float delta = yuv.g - sum;\n mediump float alpha = 0.0;   \n if (delta < 0.0){ \n   alpha = 8.0 * pow((delta + 0.5), 4.0); \n } else {   \n   alpha = 1.0 - 8.0 * pow((0.5 - delta), 4.0); \n } \n  lowp float lightr = texture2D(inputImageTexture2, vec2(yuv.r, 0.5)).r;    \n lowp float lightg = texture2D(inputImageTexture2, vec2(yuv.g, 0.5)).g;    \n lowp float lightb = texture2D(inputImageTexture2, vec2(yuv.b, 0.5)).b;    \n lowp float rrr = mix(lightr, yuv.r, alpha);    \n lowp float ggg = mix(lightg, yuv.g, alpha);    \n lowp float bbb = mix(lightb, yuv.b, alpha);    \n    \n mediump vec4 tc = vec4(rrr, ggg, bbb, 1.0); tc = mix(yuv, tc, softenLevel);\n").toString();
        s = (new StringBuilder()).append(s).append(" mediump vec4 virtual_yuv = texture2D(inputImageTextureVirtual, textureCoordinate);\n").toString();
        s = (new StringBuilder()).append(s).append(" if (enableVirtual == 1) {\n\ttc = vec4(tc.rgb*virtual_yuv.rgb, 0.0);\n }\n").toString();
        return (new StringBuilder()).append(s).append(" gl_FragColor = vec4(tc.rgb, 1.0); \n }").toString();
    }

    private void j()
    {
        if (A == null)
        {
            return;
        } else
        {
            a(new ccp(this));
            return;
        }
    }

    private void k()
    {
        if (B != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                B
            }, 0);
            B = -1;
        }
    }

    private static int l()
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

    private void m()
    {
        b = ByteBuffer.allocateDirect(byi.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        b.put(byi.a).position(0);
        c = ByteBuffer.allocateDirect(byq.d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        c.put(byq.d).position(0);
    }

    private Bitmap n()
    {
        Bitmap bitmap = Bitmap.createBitmap(256, 1, android.graphics.Bitmap.Config.ARGB_8888);
        int ai[] = new int[256];
        for (int i = 0; i < 256; i++)
        {
            int i1 = ((255 - ((255 - i) * (255 - i)) / 255) + i) / 2;
            ai[i] = i1 << 16 | (i1 << 8 | i1) | 0xff000000;
        }

        bitmap.copyPixelsFromBuffer(IntBuffer.wrap(ai));
        return bitmap;
    }

    private boolean o()
    {
        return j != -1 && L != -1;
    }

    private void p()
    {
        if (j >= 0)
        {
            GLES20.glDeleteProgram(j);
            j = -1;
        }
        if (L >= 0)
        {
            GLES20.glDeleteProgram(L);
            L = -1;
        }
    }

    private void q()
    {
        if (F[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, F, 0);
            F[0] = -1;
        }
        if (H[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, H, 0);
            H[0] = -1;
        }
        if (G[0] != -1)
        {
            GLES20.glDeleteTextures(1, G, 0);
            G[0] = -1;
        }
        if (I[0] != -1)
        {
            GLES20.glDeleteTextures(1, I, 0);
            I[0] = -1;
        }
        if (K[0] != -1)
        {
            GLES20.glDeleteTextures(1, K, 0);
            K[0] = -1;
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
        if (g == 3 && o()) goto _L2; else goto _L1
_L1:
        g = 3;
        p();
        a(3);
        return;
_L2:
        do
        {
            return;
        } while (i == 0 || i1 == 0 || e == i && f == i1);
        if (E)
        {
            e = i1;
            f = i;
        } else
        {
            e = i;
            f = i1;
        }
        q();
        a(e, f, F, G);
        a(e, f, H, I);
        a(e, f, J, K);
        if (f > 360 || f > 500 || f <= 640);
        continue; /* Loop/switch isn't completed */
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        GLES20.glBindFramebuffer(36160, F[0]);
        GLES20.glViewport(0, 0, e, f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(L);
        float f1 = (float)Math.sqrt(((double)f * (double)e) / 480000D);
        if (E)
        {
            a(GLES20.glGetUniformLocation(L, "texelHeightOffset"), 0.003333333F);
            a(GLES20.glGetUniformLocation(L, "texelWidthOffset"), 0.0F);
        } else
        {
            a(GLES20.glGetUniformLocation(L, "texelWidthOffset"), 0.003333333F);
            a(GLES20.glGetUniformLocation(L, "texelHeightOffset"), 0.0F);
        }
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(L, "uTexMatrix"), 1, false, P, 0);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(M);
        GLES20.glVertexAttribPointer(M, 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(O);
        GLES20.glVertexAttribPointer(O, 2, 5126, false, 8, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33986);
            if (E)
            {
                GLES20.glBindTexture(36197, i);
            } else
            {
                GLES20.glBindTexture(3553, i);
            }
            GLES20.glUniform1i(GLES20.glGetUniformLocation(j, "inputImageTexture"), 2);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(M);
        GLES20.glDisableVertexAttribArray(O);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
        GLES20.glBindFramebuffer(36160, H[0]);
        GLES20.glViewport(0, 0, e, f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(j);
        a(GLES20.glGetUniformLocation(j, "softenLevel"), C);
        if (E)
        {
            a(GLES20.glGetUniformLocation(j, "texelWidthOffset"), 0.0F);
            a(GLES20.glGetUniformLocation(j, "texelHeightOffset"), ((float)e * 0.003333333F) / (float)f);
        } else
        {
            a(GLES20.glGetUniformLocation(j, "texelWidthOffset"), 0.0F);
            a(GLES20.glGetUniformLocation(j, "texelHeightOffset"), ((float)e * 0.003333333F) / (float)f);
        }
        a(GLES20.glGetUniformLocation(j, "alphaValue"), d);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(k);
        GLES20.glVertexAttribPointer(k, 2, 5126, false, 0, b);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(m);
        GLES20.glVertexAttribPointer(m, 2, 5126, false, 0, c);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(j, "uTexMatrix"), 1, false, cdo.a, 0);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, G[0]);
        GLES20.glUniform1i(l, 4);
        b();
        if (B != -1)
        {
            GLES20.glActiveTexture(33990);
            GLES20.glBindTexture(3553, B);
            if (z)
            {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(j, "enableVirtual"), 1);
            } else
            {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(j, "enableVirtual"), 0);
            }
            GLES20.glUniform1i(GLES20.glGetUniformLocation(j, "inputImageTextureVirtual"), 6);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(k);
        GLES20.glDisableVertexAttribArray(m);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    public void a(String s)
    {
        Q = s;
    }

    public void a(float af[])
    {
        P = af;
    }

    protected void b()
    {
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, y);
        GLES20.glUniform1i(w, 3);
    }

    public void b(float f1)
    {
        C = f1;
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

    public void b(boolean flag)
    {
        z = flag;
    }

    public void c()
    {
        super.c();
        if (x == null)
        {
            x = n();
        }
        if (x != null)
        {
            a(x);
        }
        j();
    }

    public void c(boolean flag)
    {
        E = flag;
    }

    public void d()
    {
        super.d();
        GLES20.glDeleteTextures(1, new int[] {
            y
        }, 0);
        y = -1;
        k();
        q();
        p();
    }

    public int f()
    {
        return I[0];
    }

}
