// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class ccs extends byh
{

    FloatBuffer a;
    FloatBuffer b;
    protected int c;
    protected int d;
    private cdn e;
    private ccu f;
    private int g[] = {
        -1
    };
    private int w[] = {
        -1
    };

    public ccs()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        a = null;
        b = null;
        f = new ccu();
        c = 0;
        d = 0;
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
        e = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec4 colorFill;\nuniform lowp vec4 colorFill_base;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     if (colorFill.r > 0.01 || colorFill.g > 0.01 || colorFill.b > 0.01 || colorFill.a > 0.01) { \n         rgbColor = mix(rgbColor, colorFill.rgb, colorFill.a); \n     }\n\n \n \n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void k()
    {
        a = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F, 0.35F
        });
        b = FloatBuffer.wrap(new float[] {
            0.8117647F, 0.8117647F, 0.4470588F, 1.0F
        });
    }

    private void l()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        PointF pointf1 = new PointF(0.2627451F, 0.1058824F);
        PointF pointf2 = new PointF(0.4980392F, 0.3254902F);
        PointF pointf3 = new PointF(0.7019608F, 0.7411765F);
        PointF pointf4 = new PointF(1.0F, 1.0F);
        PointF pointf5 = new PointF(0.0F, 0.0F);
        PointF pointf6 = new PointF(0.2431373F, 0.3176471F);
        PointF pointf7 = new PointF(0.7215686F, 0.6901961F);
        PointF pointf8 = new PointF(1.0F, 1.0F);
        PointF pointf9 = new PointF(0.0F, 0.0F);
        PointF pointf10 = new PointF(0.5F, 0.5F);
        PointF pointf11 = new PointF(0.6588235F, 0.6666667F);
        PointF pointf12 = new PointF(1.0F, 1.0F);
        PointF pointf13 = new PointF(0.0F, 0.0F);
        PointF pointf14 = new PointF(0.1764706F, 0.2784314F);
        PointF pointf15 = new PointF(0.682353F, 0.7058824F);
        PointF pointf16 = new PointF(1.0F, 1.0F);
        f.a(new PointF[] {
            pointf, pointf1, pointf2, pointf3, pointf4
        });
        f.b(new PointF[] {
            pointf5, pointf6, pointf7, pointf8
        });
        f.c(new PointF[] {
            pointf9, pointf10, pointf11, pointf12
        });
        f.d(new PointF[] {
            pointf13, pointf14, pointf15, pointf16
        });
    }

    private void m()
    {
        if (g[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, g, 0);
            g[0] = -1;
        }
        if (w[0] != -1)
        {
            GLES20.glDeleteTextures(1, w, 0);
            w[0] = -1;
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
        while (i == 0 || i1 == 0 || c == i && d == i1) 
        {
            return;
        }
        c = i;
        d = i1;
        m();
        a(d, c, g, w);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        e.a();
        GLES20.glBindFramebuffer(36160, g[0]);
        GLES20.glViewport(0, 0, d, c);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(e.a("position"));
        GLES20.glVertexAttribPointer(e.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(e.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(e.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(e.b("inputImageTexture"), 0);
        }
        GLES20.glUniform4fv(e.b("colorFill"), 1, a);
        GLES20.glUniform4fv(e.b("colorFill_base"), 1, b);
        f.a(33989);
        GLES20.glUniform1i(e.b("inputToneCurveTexture"), 5);
        GLES20.glUniform1f(e.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(e.a("position"));
        GLES20.glDisableVertexAttribArray(e.a("inputTextureCoordinate"));
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
        e.a(true);
        m();
    }

    public int f()
    {
        return w[0];
    }
}
