// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class afr extends aeo
{

    FloatBuffer p;
    protected int q;
    protected int r;
    private Bitmap s;
    private int t;
    private agu u;
    private agk v;
    private int w[] = {
        -1
    };
    private int x[] = {
        -1
    };

    public afr(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        s = null;
        t = -1;
        p = null;
        v = new agk();
        q = 0;
        r = 0;
        s = bitmap;
        j();
    }

    static int a(afr afr1)
    {
        return afr1.t;
    }

    static int a(afr afr1, int i)
    {
        afr1.t = i;
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

    static Bitmap b(afr afr1)
    {
        return afr1.s;
    }

    private void j()
    {
        n();
        o();
        l();
    }

    private void k()
    {
        u = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec4 photoFilter;\nuniform lowp float filterLevel;\n \n lowp float RGBToL(lowp vec3 color) \n  { \n      lowp float fmin = min(min(color.r, color.g), color.b); \n      lowp float fmax = max(max(color.r, color.g), color.b); \n    \n      return (fmax + fmin) / 2.0; \n  } \n \n lowp vec3 RGBToHSL(lowp vec3 color) {\n lowp vec3 hsl;\n lowp float fmin = min(min(color.r, color.g), color.b);\n lowp float fmax = max(max(color.r, color.g), color.b);\n lowp float delta = fmax - fmin;\n \n hsl.z = (fmax + fmin) / 2.0;\n \n if (delta == 0.0)\n {\n \t\thsl.x = 0.0;\n \t\thsl.y = 0.0;\n } else {\n if (hsl.z < 0.5)\n     hsl.y = delta / (fmax + fmin);\n else\n     hsl.y = delta / (2.0 - fmax - fmin);\n \n lowp float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;\n lowp float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;\n lowp float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;\n \n if (color.r == fmax )\n      hsl.x = deltaB - deltaG;\n else if (color.g == fmax)\n     hsl.x = (1.0 / 3.0) + deltaR - deltaB;\n else if (color.b == fmax)\n     hsl.x = (2.0 / 3.0) + deltaG - deltaR;\n \n if (hsl.x < 0.0)\n      hsl.x += 1.0;\n else if (hsl.x > 1.0)\n     hsl.x -= 1.0;\n }\n return hsl;\n }\n \n \nlowp float HueToRGB(lowp float f1, lowp float f2, lowp float hue)\n{\n\tif (hue < 0.0)\n\t\thue += 1.0;\n\telse if (hue > 1.0)\n\t\thue -= 1.0;\n\tlowp float res;\n\tif ((6.0 * hue) < 1.0)\n\t\tres = f1 + (f2 - f1) * 6.0 * hue;\n\telse if ((2.0 * hue) < 1.0)\n\t\tres = f2;\n\telse if ((3.0 * hue) < 2.0)\n\t\tres = f1 + (f2 - f1) * ((2.0 / 3.0) - hue) * 6.0;\n\telse\n\t\tres = f1;\n\treturn res;\n}\n \n lowp vec3 HSLToRGB(lowp vec3 hsl) \n { \n     lowp vec3 rgb; \n  if (hsl.y == 0.0) \n     rgb = vec3(hsl.z); \n  else \n   { \n      lowp float f2; \n     if (hsl.z < 0.5) \n         f2 = hsl.z * (1.0 + hsl.y); \n     else \n         f2 = (hsl.z + hsl.y) - (hsl.y * hsl.z); \n     lowp float f1 = 2.0 * hsl.z - f2; \n     rgb.r = HueToRGB(f1, f2, hsl.x + (1.0/3.0)); \n     rgb.g = HueToRGB(f1, f2, hsl.x); \n     rgb.b= HueToRGB(f1, f2, hsl.x - (1.0/3.0)); \n  } \n  return rgb; \n } \n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     if (photoFilter.a > 0.01) { \n       lowp float originalLuminance = RGBToL(rgbColor); \n       lowp vec3 newColor = mix(rgbColor, photoFilter.rgb, photoFilter.a); \n       lowp vec3 hsl = RGBToHSL(newColor); \n       hsl = clamp(hsl, vec3(0.0), vec3(1.0)); \n       rgbColor = HSLToRGB(vec3(hsl.r, hsl.g, originalLuminance)); \n       rgbColor = clamp(rgbColor, vec3(0.0), vec3(1.0)); \n     } \n \n \n     rgbColor = rgbColor * maskColor.rgb;\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void l()
    {
        if (s == null)
        {
            return;
        } else
        {
            m();
            a(new Runnable() {

                final afr a;

                public void run()
                {
                    if (afr.a(a) == -1)
                    {
                        GLES20.glActiveTexture(33985);
                        afr.a(a, OpenGlUtils.a(afr.b(a), -1, true));
                    }
                }

            
            {
                a = afr.this;
                super();
            }
            });
            return;
        }
    }

    private void m()
    {
        if (t != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                t
            }, 0);
            t = -1;
        }
    }

    private void n()
    {
        p = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
    }

    private void o()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        PointF pointf1 = new PointF(1.0F, 1.0F);
        PointF pointf2 = new PointF(0.0F, 0.0F);
        PointF pointf3 = new PointF(1.0F, 1.0F);
        PointF pointf4 = new PointF(0.0F, 0.0F);
        PointF pointf5 = new PointF(1.0F, 1.0F);
        PointF pointf6 = new PointF(0.0F, 0.0F);
        PointF pointf7 = new PointF(1.0F, 1.0F);
        v.a(new PointF[] {
            pointf, pointf1
        });
        v.b(new PointF[] {
            pointf2, pointf3
        });
        v.c(new PointF[] {
            pointf4, pointf5
        });
        v.d(new PointF[] {
            pointf6, pointf7
        });
    }

    private void p()
    {
        if (w[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, w, 0);
            w[0] = -1;
        }
        if (x[0] != -1)
        {
            GLES20.glDeleteTextures(1, x, 0);
            x[0] = -1;
        }
    }

    public void a(float f1)
    {
        n = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || q == i && r == i1) 
        {
            return;
        }
        q = i;
        r = i1;
        p();
        a(r, q, w, x);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!this.i)
        {
            return;
        }
        u.a();
        GLES20.glBindFramebuffer(36160, w[0]);
        GLES20.glViewport(0, 0, r, q);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(u.a("position"));
        GLES20.glVertexAttribPointer(u.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(u.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(u.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(u.b("inputImageTexture"), 0);
        }
        if (t != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, t);
            GLES20.glUniform1i(u.b("inputImageTextureMask"), 1);
        }
        GLES20.glUniform4fv(u.b("photoFilter"), 1, p);
        v.a(33988);
        GLES20.glUniform1i(u.b("inputToneCurveTexture"), 4);
        GLES20.glUniform1f(u.b("filterLevel"), n);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(u.a("position"));
        GLES20.glDisableVertexAttribArray(u.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(float af[])
    {
        p = FloatBuffer.wrap(af);
    }

    public void a(PointF apointf[], PointF apointf1[], PointF apointf2[], PointF apointf3[])
    {
        v.a(apointf);
        v.b(apointf1);
        v.c(apointf2);
        v.d(apointf3);
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

    public void c()
    {
        super.c();
    }

    public int d()
    {
        return x[0];
    }

    public void f()
    {
        super.f();
        m();
        u.a(true);
        p();
    }
}
