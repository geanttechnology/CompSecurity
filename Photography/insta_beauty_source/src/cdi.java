// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class cdi extends byh
{

    FloatBuffer a;
    protected int b;
    protected int c;
    private cdn d;
    private ccu e;
    private int f[] = {
        -1
    };
    private int g[] = {
        -1
    };

    public cdi()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        a = null;
        e = new ccu();
        b = 0;
        c = 0;
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

    private void j()
    {
        d = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec4 colorFill;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n     if (colorFill.r > 0.01 || colorFill.g > 0.01 || colorFill.b > 0.01 || colorFill.a > 0.01) { \n         rgbColor = mix(rgbColor, colorFill.rgb, colorFill.a); \n     }\n\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void k()
    {
        a = FloatBuffer.wrap(new float[] {
            0.3764706F, 0.2666667F, 0.4823529F, 0.45F
        });
    }

    private void l()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        PointF pointf1 = new PointF(0.2901961F, 0.2862745F);
        PointF pointf2 = new PointF(0.654902F, 0.7254902F);
        PointF pointf3 = new PointF(1.0F, 1.0F);
        PointF pointf4 = new PointF(0.0F, 0.0F);
        PointF pointf5 = new PointF(0.2156863F, 0.345098F);
        PointF pointf6 = new PointF(0.6745098F, 0.6F);
        PointF pointf7 = new PointF(1.0F, 1.0F);
        PointF pointf8 = new PointF(0.0F, 0.0F);
        PointF pointf9 = new PointF(0.254902F, 0.1490196F);
        PointF pointf10 = new PointF(0.6745098F, 0.6705883F);
        PointF pointf11 = new PointF(1.0F, 1.0F);
        PointF pointf12 = new PointF(0.0F, 0.0F);
        PointF pointf13 = new PointF(0.2F, 0.3686275F);
        PointF pointf14 = new PointF(0.2784314F, 0.3607843F);
        PointF pointf15 = new PointF(0.7490196F, 0.6901961F);
        PointF pointf16 = new PointF(1.0F, 1.0F);
        e.a(new PointF[] {
            pointf, pointf1, pointf2, pointf3
        });
        e.b(new PointF[] {
            pointf4, pointf5, pointf6, pointf7
        });
        e.c(new PointF[] {
            pointf8, pointf9, pointf10, pointf11
        });
        e.d(new PointF[] {
            pointf12, pointf13, pointf14, pointf15, pointf16
        });
    }

    private void m()
    {
        if (f[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, f, 0);
            f[0] = -1;
        }
        if (g[0] != -1)
        {
            GLES20.glDeleteTextures(1, g, 0);
            g[0] = -1;
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
        m();
        a(c, b, f, g);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        d.a();
        GLES20.glBindFramebuffer(36160, f[0]);
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
        GLES20.glUniform4fv(d.b("colorFill"), 1, a);
        e.a(33989);
        GLES20.glUniform1i(d.b("inputToneCurveTexture"), 5);
        GLES20.glUniform1f(d.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(d.a("position"));
        GLES20.glDisableVertexAttribArray(d.a("inputTextureCoordinate"));
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
        j();
        k();
        l();
    }

    public void d()
    {
        super.d();
        d.a(true);
        m();
    }

    public int f()
    {
        return g[0];
    }
}
