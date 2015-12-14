// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class aff extends aeo
{

    private int A[] = {
        -1
    };
    private int B[] = {
        -1
    };
    FloatBuffer p;
    FloatBuffer q;
    FloatBuffer r;
    FloatBuffer s;
    FloatBuffer t;
    protected int u;
    protected int v;
    private Bitmap w;
    private int x;
    private agu y;
    private agk z;

    public aff(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        w = null;
        x = -1;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        z = new agk();
        u = 0;
        v = 0;
        w = bitmap;
        j();
    }

    static int a(aff aff1)
    {
        return aff1.x;
    }

    static int a(aff aff1, int i)
    {
        aff1.x = i;
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
        GLES20.glBindFramebuffer(36160, 0);
    }

    static Bitmap b(aff aff1)
    {
        return aff1.w;
    }

    private void j()
    {
        n();
        o();
        p();
        q();
        l();
    }

    private void k()
    {
        y = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec4 colorFill_mix;\nuniform lowp vec4 colorFill_multiply;\nuniform lowp vec4 colorFill_exclusion;\nuniform lowp vec3 bceShift;\nuniform lowp vec3 hsbShift;\nuniform lowp float filterLevel;\n \n \n // Values for Satuation \n  // Values from \"Graphics Shaders: Theory and Practice\" by Bailey and Cunningham \n  // Adjusting satuation \n  const lowp vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721); \n  // Values for HUE \n  const lowp vec3 kRGBToYPrime = vec3 (0.299, 0.587, 0.114); \n  const lowp vec3 kRGBToI = vec3 (0.595716, -0.274453, -0.321263); \n  const lowp vec3 kRGBToQ = vec3 (0.211456, -0.522591, 0.31135); \n  const lowp vec3 kYIQToR = vec3 (1.0, 0.9563, 0.6210); \n  const lowp vec3 kYIQToG = vec3 (1.0, -0.2721, -0.6474); \n  const lowp vec3 kYIQToB = vec3 (1.0, -1.1070, 1.7046); \n  lowp vec3 HueSatuationAdjusting(lowp vec3 rgbColor, lowp float hueAdjust, lowp float satuationAdjust) \n  { \n      lowp vec3 retColor = rgbColor; \n      if ((hueAdjust > -3.01 && hueAdjust < -0.01) || (hueAdjust > 0.01 && hueAdjust < 3.01)) \n      { \n          // Adjusting hue \n          lowp float YPrime = dot(rgbColor, kRGBToYPrime); \n          lowp float I = dot(rgbColor, kRGBToI); \n          lowp float Q = dot(rgbColor, kRGBToQ); \n          lowp float hue = atan(Q, I); \n          lowp float chroma = sqrt(I * I + Q * Q); \n          hue += (-hueAdjust); \n          Q = chroma * sin(hue); \n          I = chroma * cos(hue); \n          lowp vec3 yIQ = vec3(YPrime, I, Q); \n          retColor = vec3(dot(yIQ, kYIQToR), dot(yIQ, kYIQToG), dot(yIQ, kYIQToB)); \n      } \n      if (satuationAdjust > 1.01 || satuationAdjust < 0.99) \n      { \n          // Adjusting satuation \n          lowp float luminance = dot(retColor.rgb, luminanceWeighting); \n          lowp vec3 greyScaleColor = vec3(luminance); \n          retColor = mix(greyScaleColor, retColor, satuationAdjust); \n      } \n      return retColor; \n  } \n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n     //hue saturation\n     rgbColor = HueSatuationAdjusting(rgbColor, hsbShift.r, 1.0 + hsbShift.g);\n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     //brightness\n     rgbColor = clamp(pow(rgbColor, vec3(bceShift.r)), vec3(0.0), vec3(1.0));\n     //contrast\n     rgbColor = clamp((rgbColor - vec3(0.5)) * (1.0 + bceShift.g) + vec3(0.5), vec3(0.0), vec3(1.0));\n     //exposure\n     //rgbColor = clamp(rgbColor * pow(2.0, bceShift.b), vec3(0.0), vec3(1.0));\n \n     rgbColor = rgbColor * maskColor.rgb;\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void l()
    {
        if (w == null)
        {
            return;
        } else
        {
            m();
            a(new Runnable() {

                final aff a;

                public void run()
                {
                    if (aff.a(a) == -1)
                    {
                        GLES20.glActiveTexture(33985);
                        aff.a(a, OpenGlUtils.a(aff.b(a), -1, true));
                    }
                }

            
            {
                a = aff.this;
                super();
            }
            });
            return;
        }
    }

    private void m()
    {
        if (x != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                x
            }, 0);
            x = -1;
        }
    }

    private void n()
    {
        p = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
        q = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
        r = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
    }

    private void o()
    {
        s = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F
        });
    }

    private void p()
    {
        t = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F
        });
    }

    private void q()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        PointF pointf1 = new PointF(1.0F, 1.0F);
        PointF pointf2 = new PointF(0.0F, 0.0F);
        PointF pointf3 = new PointF(1.0F, 1.0F);
        PointF pointf4 = new PointF(0.0F, 0.0F);
        PointF pointf5 = new PointF(1.0F, 1.0F);
        PointF pointf6 = new PointF(0.0F, 0.0F);
        PointF pointf7 = new PointF(1.0F, 1.0F);
        z.a(new PointF[] {
            pointf, pointf1
        });
        z.b(new PointF[] {
            pointf2, pointf3
        });
        z.c(new PointF[] {
            pointf4, pointf5
        });
        z.d(new PointF[] {
            pointf6, pointf7
        });
    }

    private void r()
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

    public void a(float f1)
    {
        n = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || u == i && v == i1) 
        {
            return;
        }
        u = i;
        v = i1;
        r();
        a(v, u, A, B);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!this.i)
        {
            return;
        }
        y.a();
        GLES20.glBindFramebuffer(36160, A[0]);
        GLES20.glViewport(0, 0, v, u);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(y.a("position"));
        GLES20.glVertexAttribPointer(y.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(y.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(y.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(y.b("inputImageTexture"), 0);
        }
        if (x != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, x);
            GLES20.glUniform1i(y.b("inputImageTextureMask"), 1);
        }
        GLES20.glUniform4fv(y.b("colorFill_mix"), 1, p);
        GLES20.glUniform4fv(y.b("colorFill_multiply"), 1, q);
        GLES20.glUniform4fv(y.b("colorFill_exclusion"), 1, r);
        GLES20.glUniform3fv(y.b("bceShift"), 1, s);
        GLES20.glUniform3fv(y.b("hsbShift"), 1, t);
        z.a(33988);
        GLES20.glUniform1i(y.b("inputToneCurveTexture"), 4);
        GLES20.glUniform1f(y.b("filterLevel"), n);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(y.a("position"));
        GLES20.glDisableVertexAttribArray(y.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(float af[])
    {
        s = FloatBuffer.wrap(af);
    }

    public void a(PointF apointf[], PointF apointf1[], PointF apointf2[], PointF apointf3[])
    {
        z.a(apointf);
        z.b(apointf1);
        z.c(apointf2);
        z.d(apointf3);
    }

    public void b()
    {
        super.b();
        k();
    }

    public void b(int i, int i1)
    {
        while (g == i && h == i1 || i == 0 || i1 == 0) 
        {
            return;
        }
        g = i;
        h = i1;
    }

    public void b(float af[])
    {
        t = FloatBuffer.wrap(af);
    }

    public void c()
    {
        super.c();
    }

    public int d()
    {
        return B[0];
    }

    public void f()
    {
        super.f();
        m();
        y.a(true);
        r();
    }
}
