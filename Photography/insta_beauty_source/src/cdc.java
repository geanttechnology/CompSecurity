// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class cdc extends byh
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

    public cdc(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        d = null;
        e = -1;
        a = null;
        g = new ccu();
        b = 0;
        c = 0;
        d = bitmap;
    }

    static int a(cdc cdc1)
    {
        return cdc1.e;
    }

    static int a(cdc cdc1, int i)
    {
        cdc1.e = i;
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

    static Bitmap b(cdc cdc1)
    {
        return cdc1.d;
    }

    private void j()
    {
        if (d == null)
        {
            return;
        } else
        {
            k();
            a(new cdd(this));
            return;
        }
    }

    private void k()
    {
        if (e != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                e
            }, 0);
            e = -1;
        }
    }

    private void l()
    {
        f = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec4 colorFill;\n//uniform lowp vec3 hsbShift;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n \n     if (colorFill.r > 0.01 || colorFill.g > 0.01 || colorFill.b > 0.01 || colorFill.a > 0.01) { \n         rgbColor = mix(rgbColor, colorFill.rgb, colorFill.a); \n     }\n     //lowp vec3 hsl = RGBToHSL(rgbColor);\n     //rgbColor = HSLToRGB(vec3(clamp(hsl.r*(1.0+hsbShift.r), 0.0, 1.0), clamp(hsl.g*(1.0+hsbShift.g), 0.0, 1.0), clamp(hsl.b*(1.0+hsbShift.b), 0.0, 1.0)));\n \n     rgbColor = rgbColor*maskColor.rgb;\n \n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n     //gl_FragColor = vec4(maskColor.rgb, textureColor.a);\n}");
    }

    private void m()
    {
        a = FloatBuffer.wrap(new float[] {
            0.003921569F, 0.01176471F, 0.07058824F, 0.25F
        });
    }

    private void n()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        PointF pointf1 = new PointF(0.4117647F, 0.6235294F);
        PointF pointf2 = new PointF(0.6392157F, 0.8392157F);
        PointF pointf3 = new PointF(1.0F, 1.0F);
        PointF pointf4 = new PointF(0.0F, 0.0F);
        PointF pointf5 = new PointF(0.172549F, 0.1372549F);
        PointF pointf6 = new PointF(0.7607843F, 0.7764706F);
        PointF pointf7 = new PointF(1.0F, 1.0F);
        PointF pointf8 = new PointF(0.0F, 0.0F);
        PointF pointf9 = new PointF(0.2470588F, 0.2039216F);
        PointF pointf10 = new PointF(0.5137255F, 0.4470588F);
        PointF pointf11 = new PointF(0.7372549F, 0.7411765F);
        PointF pointf12 = new PointF(1.0F, 1.0F);
        PointF pointf13 = new PointF(0.0F, 0.0F);
        PointF pointf14 = new PointF(0.2196078F, 0.3254902F);
        PointF pointf15 = new PointF(0.6862745F, 0.627451F);
        PointF pointf16 = new PointF(1.0F, 1.0F);
        g.a(new PointF[] {
            pointf, pointf1, pointf2, pointf3
        });
        g.b(new PointF[] {
            pointf4, pointf5, pointf6, pointf7
        });
        g.c(new PointF[] {
            pointf8, pointf9, pointf10, pointf11, pointf12
        });
        g.d(new PointF[] {
            pointf13, pointf14, pointf15, pointf16
        });
    }

    private void o()
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
        o();
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
        GLES20.glUniform4fv(f.b("colorFill"), 1, a);
        g.a(33989);
        GLES20.glUniform1i(f.b("inputToneCurveTexture"), 5);
        GLES20.glUniform1f(f.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(f.a("position"));
        GLES20.glDisableVertexAttribArray(f.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
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
        m();
        n();
        j();
    }

    public void d()
    {
        super.d();
        k();
        f.a(true);
        o();
    }

    public int f()
    {
        return x[0];
    }
}
