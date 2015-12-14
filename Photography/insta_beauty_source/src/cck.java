// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class cck extends byh
{

    FloatBuffer a;
    protected int b;
    protected int c;
    private cdn d;
    private int e[] = {
        -1
    };
    private int f[] = {
        -1
    };

    public cck()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        a = null;
        b = 0;
        c = 0;
        a = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.0F
        });
    }

    static void a(int i, int k, int ai[], int ai1[])
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
        GLES20.glTexImage2D(3553, 0, 6408, i, k, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, ai1[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void j()
    {
        if (e[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, e, 0);
            e[0] = -1;
        }
        if (f[0] != -1)
        {
            GLES20.glDeleteTextures(1, f, 0);
            f[0] = -1;
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

    public void a(int i, int k)
    {
        super.a(i, k);
        while (i == 0 || k == 0 || b == i && c == k) 
        {
            return;
        }
        b = i;
        c = k;
        j();
        a(c, b, e, f);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        d.a();
        GLES20.glBindFramebuffer(36160, e[0]);
        GLES20.glViewport(0, 0, c, b);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(d.a("position"));
        GLES20.glVertexAttribPointer(d.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(d.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(d.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(d.b("inputImageTexture"), 0);
        }
        GLES20.glUniform4fv(d.b("photofilter"), 1, a);
        GLES20.glUniform1f(d.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(d.a("position"));
        GLES20.glDisableVertexAttribArray(d.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(float af[])
    {
        a = FloatBuffer.wrap(af);
    }

    public void b(int i, int k)
    {
        while (n == i && o == k || i == 0 || k == 0) 
        {
            return;
        }
        n = i;
        o = k;
    }

    public void c()
    {
        super.c();
        d = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}\n", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \n lowp vec3 RGBToHSL(lowp vec3 color) {\n lowp vec3 hsl;\n lowp float fmin = min(min(color.r, color.g), color.b);\n lowp float fmax = max(max(color.r, color.g), color.b);\n lowp float delta = fmax - fmin;\n \n hsl.z = (fmax + fmin) / 2.0;\n \n if (delta == 0.0)\n {\n \t\thsl.x = 0.0;\n \t\thsl.y = 0.0;\n } else {\n if (hsl.z < 0.5)\n     hsl.y = delta / (fmax + fmin);\n else\n     hsl.y = delta / (2.0 - fmax - fmin);\n \n lowp float deltaR = (((fmax - color.r) / 6.0) + (delta / 2.0)) / delta;\n lowp float deltaG = (((fmax - color.g) / 6.0) + (delta / 2.0)) / delta;\n lowp float deltaB = (((fmax - color.b) / 6.0) + (delta / 2.0)) / delta;\n \n if (color.r == fmax )\n      hsl.x = deltaB - deltaG;\n else if (color.g == fmax)\n     hsl.x = (1.0 / 3.0) + deltaR - deltaB;\n else if (color.b == fmax)\n     hsl.x = (2.0 / 3.0) + deltaG - deltaR;\n \n if (hsl.x < 0.0)\n      hsl.x += 1.0;\n else if (hsl.x > 1.0)\n     hsl.x -= 1.0;\n }\n return hsl;\n }\n \n lowp float RGBToL(lowp vec3 color) \n  { \n      lowp float fmin = min(min(color.r, color.g), color.b); \n      lowp float fmax = max(max(color.r, color.g), color.b); \n    \n      return (fmax + fmin) / 2.0; \n  } \n \n \nlowp float HueToRGB(lowp float f1, lowp float f2, lowp float hue)\n{\n\tif (hue < 0.0)\n\t\thue += 1.0;\n\telse if (hue > 1.0)\n\t\thue -= 1.0;\n\tlowp float res;\n\tif ((6.0 * hue) < 1.0)\n\t\tres = f1 + (f2 - f1) * 6.0 * hue;\n\telse if ((2.0 * hue) < 1.0)\n\t\tres = f2;\n\telse if ((3.0 * hue) < 2.0)\n\t\tres = f1 + (f2 - f1) * ((2.0 / 3.0) - hue) * 6.0;\n\telse\n\t\tres = f1;\n\treturn res;\n}\n \n lowp vec3 HSLToRGB(lowp vec3 hsl) \n { \n     lowp vec3 rgb; \n  if (hsl.y == 0.0) \n     rgb = vec3(hsl.z); \n  else \n   { \n      lowp float f2; \n     if (hsl.z < 0.5) \n         f2 = hsl.z * (1.0 + hsl.y); \n     else \n         f2 = (hsl.z + hsl.y) - (hsl.y * hsl.z); \n     lowp float f1 = 2.0 * hsl.z - f2; \n     rgb.r = HueToRGB(f1, f2, hsl.x + (1.0/3.0)); \n     rgb.g = HueToRGB(f1, f2, hsl.x); \n     rgb.b= HueToRGB(f1, f2, hsl.x - (1.0/3.0)); \n  } \n  return rgb; \n } \nuniform lowp float filterLevel;\nuniform lowp vec4 photofilter;\n  \n  \n  \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n     \n     if (photofilter.a > 0.01) {\n         lowp float originalLuminance = RGBToL(rgbColor);\n     \n         lowp vec3 newColor = mix(rgbColor, photofilter.rgb, photofilter.a);\n         lowp vec3 hsl = RGBToHSL(newColor);\n         hsl = clamp(hsl, vec3(0.0), vec3(1.0));\n         \n         rgbColor = HSLToRGB(vec3(hsl.r, hsl.g, originalLuminance));\n         rgbColor = clamp(rgbColor, vec3(0.0), vec3(1.0));\n     }\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), 1.0);\n}");
    }

    public void d()
    {
        super.d();
        d.a(true);
        j();
    }

    public int f()
    {
        return f[0];
    }
}
