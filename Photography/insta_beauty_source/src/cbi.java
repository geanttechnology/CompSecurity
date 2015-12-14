// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class cbi extends byh
{

    FloatBuffer a;
    protected int b;
    protected int c;
    private Bitmap d;
    private int e;
    private cdn f;
    private ccu g;
    private int w[] = {
        -1
    };
    private int x[] = {
        -1
    };

    public cbi(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        d = null;
        e = -1;
        a = null;
        g = new ccu();
        b = 0;
        c = 0;
        d = bitmap;
        j();
    }

    static int a(cbi cbi1)
    {
        return cbi1.e;
    }

    static int a(cbi cbi1, int i)
    {
        cbi1.e = i;
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

    static Bitmap b(cbi cbi1)
    {
        return cbi1.d;
    }

    private void j()
    {
        n();
        o();
        l();
    }

    private void k()
    {
        f = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec4 photoFilter;\nuniform lowp float filterLevel;\n \n lowp float RGBToL(lowp vec3 color) \n  { \n      lowp float fmin = min(min(color.r, color.g), color.b); \n      lowp float fmax = max(max(color.r, color.g), color.b); \n    \n      return (fmax + fmin) / 2.0; \n  } \n \n lowp vec3 RGBToHSL(lowp vec3 color) {\n lowp vec3 hsl;\n lowp float fmin = min(min(color.r, color.g), color.b);\n lowp float fmax = max(max(color.r, color.g), color.b);\n lowp float delta = fmax - fmin;\n \n hsl.z = (fmax + fmin) / 2.0;\n \n if (delta == 0.0)\n {\n \t\thsl.x = 0.0;\n \t\thsl.y = 0.0;\n } else {\n if (hsl.z < 0.5)\n     hsl.y = delta / (fmax + fmin);\n else\n     hsl.y = delta / (2.0 - fmax - fmin);\n \n lowp float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;\n lowp float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;\n lowp float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;\n \n if (color.r == fmax )\n      hsl.x = deltaB - deltaG;\n else if (color.g == fmax)\n     hsl.x = (1.0 / 3.0) + deltaR - deltaB;\n else if (color.b == fmax)\n     hsl.x = (2.0 / 3.0) + deltaG - deltaR;\n \n if (hsl.x < 0.0)\n      hsl.x += 1.0;\n else if (hsl.x > 1.0)\n     hsl.x -= 1.0;\n }\n return hsl;\n }\n \n \nlowp float HueToRGB(lowp float f1, lowp float f2, lowp float hue)\n{\n\tif (hue < 0.0)\n\t\thue += 1.0;\n\telse if (hue > 1.0)\n\t\thue -= 1.0;\n\tlowp float res;\n\tif ((6.0 * hue) < 1.0)\n\t\tres = f1 + (f2 - f1) * 6.0 * hue;\n\telse if ((2.0 * hue) < 1.0)\n\t\tres = f2;\n\telse if ((3.0 * hue) < 2.0)\n\t\tres = f1 + (f2 - f1) * ((2.0 / 3.0) - hue) * 6.0;\n\telse\n\t\tres = f1;\n\treturn res;\n}\n \n lowp vec3 HSLToRGB(lowp vec3 hsl) \n { \n     lowp vec3 rgb; \n  if (hsl.y == 0.0) \n     rgb = vec3(hsl.z); \n  else \n   { \n      lowp float f2; \n     if (hsl.z < 0.5) \n         f2 = hsl.z * (1.0 + hsl.y); \n     else \n         f2 = (hsl.z + hsl.y) - (hsl.y * hsl.z); \n     lowp float f1 = 2.0 * hsl.z - f2; \n     rgb.r = HueToRGB(f1, f2, hsl.x + (1.0/3.0)); \n     rgb.g = HueToRGB(f1, f2, hsl.x); \n     rgb.b= HueToRGB(f1, f2, hsl.x - (1.0/3.0)); \n  } \n  return rgb; \n } \n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     if (photoFilter.a > 0.01) { \n       lowp float originalLuminance = RGBToL(rgbColor); \n       lowp vec3 newColor = mix(rgbColor, photoFilter.rgb, photoFilter.a); \n       lowp vec3 hsl = RGBToHSL(newColor); \n       hsl = clamp(hsl, vec3(0.0), vec3(1.0)); \n       rgbColor = HSLToRGB(vec3(hsl.r, hsl.g, originalLuminance)); \n       rgbColor = clamp(rgbColor, vec3(0.0), vec3(1.0)); \n     } \n \n \n     rgbColor = rgbColor * maskColor.rgb;\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void l()
    {
        if (d == null)
        {
            return;
        } else
        {
            m();
            a(new cbj(this));
            return;
        }
    }

    private void m()
    {
        if (e != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                e
            }, 0);
            e = -1;
        }
    }

    private void n()
    {
        a = FloatBuffer.wrap(new float[] {
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
        g.a(new PointF[] {
            pointf, pointf1
        });
        g.b(new PointF[] {
            pointf2, pointf3
        });
        g.c(new PointF[] {
            pointf4, pointf5
        });
        g.d(new PointF[] {
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
        while (i == 0 || i1 == 0 || b == i && c == i1) 
        {
            return;
        }
        b = i;
        c = i1;
        p();
        a(c, b, w, x);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        f.a();
        GLES20.glBindFramebuffer(36160, w[0]);
        GLES20.glViewport(0, 0, c, b);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(f.a("position"));
        GLES20.glVertexAttribPointer(f.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(f.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(f.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(f.b("inputImageTexture"), 0);
        }
        if (e != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, e);
            GLES20.glUniform1i(f.b("inputImageTextureMask"), 1);
        }
        GLES20.glUniform4fv(f.b("photoFilter"), 1, a);
        g.a(33988);
        GLES20.glUniform1i(f.b("inputToneCurveTexture"), 4);
        GLES20.glUniform1f(f.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(f.a("position"));
        GLES20.glDisableVertexAttribArray(f.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(float af[])
    {
        a = FloatBuffer.wrap(af);
    }

    public void a(PointF apointf[], PointF apointf1[], PointF apointf2[], PointF apointf3[])
    {
        g.a(apointf);
        g.b(apointf1);
        g.c(apointf2);
        g.d(apointf3);
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
        k();
    }

    public void d()
    {
        super.d();
        m();
        f.a(true);
        p();
    }

    public int f()
    {
        return x[0];
    }
}
