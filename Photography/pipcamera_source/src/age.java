// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class age extends aeo
{

    FloatBuffer p;
    FloatBuffer q;
    FloatBuffer r;
    FloatBuffer s;
    protected int t;
    protected int u;
    private agu v;
    private agk w;
    private agk x;
    private int y[] = {
        -1
    };
    private int z[] = {
        -1
    };

    public age()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        p = null;
        q = null;
        r = null;
        s = null;
        w = new agk();
        x = new agk();
        t = 0;
        u = 0;
        k();
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
        v = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputToneCurveTexture;\nuniform sampler2D inputToneCurveTexture2;\nuniform lowp vec4 colorFill_lighten;\nuniform lowp vec4 colorFill_multiply;\nuniform lowp vec4 colorFill_screen;\nuniform lowp vec3 bceShift;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     //brightness\n     rgbColor = clamp(rgbColor * vec3(1.0 + bceShift.r), vec3(0.0), vec3(1.0));\n     //contrast\n     rgbColor = clamp((rgbColor - vec3(0.5)) * (1.0 + bceShift.g) + vec3(0.5), vec3(0.0), vec3(1.0));\n     //exposure\n     rgbColor = clamp(rgbColor * pow(2.0, bceShift.b), vec3(0.0), vec3(1.0));\n \n     redCurveValue = texture2D(inputToneCurveTexture2, vec2(rgbColor.r, 0.0)).r;\n     greenCurveValue = texture2D(inputToneCurveTexture2, vec2(rgbColor.g, 0.0)).g;\n     blueCurveValue = texture2D(inputToneCurveTexture2, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     if (colorFill_lighten.r > 0.01 || colorFill_lighten.g > 0.01 || colorFill_lighten.b > 0.01 || colorFill_lighten.a > 0.01) { \n         rgbColor = vec3(max(colorFill_lighten.r, rgbColor.r), max(colorFill_lighten.g, rgbColor.g), max(colorFill_lighten.b, rgbColor.b)); \n     }\n\n \n \n     if (colorFill_multiply.r > 0.01 || colorFill_multiply.g > 0.01 || colorFill_multiply.b > 0.01 || colorFill_multiply.a > 0.01) { \n         rgbColor = rgbColor * colorFill_multiply.rgb; \n     }\n\n \n \n     if (colorFill_screen.r > 0.01 || colorFill_screen.g > 0.01 || colorFill_screen.b > 0.01 || colorFill_screen.a > 0.01) { \n         rgbColor = vec3(1.0) - (vec3(1.0) - rgbColor.rgb)*(vec3(1.0) - colorFill_screen.rgb); \n     }\n\n \n \n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void k()
    {
        l();
        m();
        n();
    }

    private void l()
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

    private void m()
    {
        s = FloatBuffer.wrap(new float[] {
            0.0F, 0.0F, 0.0F
        });
    }

    private void n()
    {
        PointF apointf[] = new PointF[2];
        apointf[0] = new PointF(0.0F, 0.0F);
        apointf[1] = new PointF(1.0F, 1.0F);
        PointF apointf1[] = new PointF[2];
        apointf1[0] = new PointF(0.0F, 0.0F);
        apointf1[1] = new PointF(1.0F, 1.0F);
        PointF apointf2[] = new PointF[2];
        apointf2[0] = new PointF(0.0F, 0.0F);
        apointf2[1] = new PointF(1.0F, 1.0F);
        PointF apointf3[] = new PointF[2];
        apointf3[0] = new PointF(0.0F, 0.0F);
        apointf3[1] = new PointF(1.0F, 1.0F);
        w.a(apointf);
        w.b(apointf1);
        w.c(apointf2);
        w.d(apointf3);
        new PointF(0.0F, 0.0F);
        new PointF(1.0F, 1.0F);
        new PointF(0.0F, 0.0F);
        new PointF(1.0F, 1.0F);
        new PointF(0.0F, 0.0F);
        new PointF(1.0F, 1.0F);
        new PointF(0.0F, 0.0F);
        new PointF(1.0F, 1.0F);
        x.a(apointf);
        x.b(apointf1);
        x.c(apointf2);
        x.d(apointf3);
    }

    private void o()
    {
        if (y[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, y, 0);
            y[0] = -1;
        }
        if (z[0] != -1)
        {
            GLES20.glDeleteTextures(1, z, 0);
            z[0] = -1;
        }
    }

    public void a(float f1)
    {
        n = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || t == i && u == i1) 
        {
            return;
        }
        t = i;
        u = i1;
        o();
        a(u, t, y, z);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!this.i)
        {
            return;
        }
        v.a();
        GLES20.glBindFramebuffer(36160, y[0]);
        GLES20.glViewport(0, 0, u, t);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(v.a("position"));
        GLES20.glVertexAttribPointer(v.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(v.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(v.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(v.b("inputImageTexture"), 0);
        }
        GLES20.glUniform4fv(v.b("colorFill_lighten"), 1, p);
        GLES20.glUniform4fv(v.b("colorFill_multiply"), 1, q);
        GLES20.glUniform4fv(v.b("colorFill_screen"), 1, r);
        GLES20.glUniform3fv(v.b("bceShift"), 1, s);
        w.a(33988);
        GLES20.glUniform1i(v.b("inputToneCurveTexture"), 4);
        x.a(33989);
        GLES20.glUniform1i(v.b("inputToneCurveTexture2"), 5);
        GLES20.glUniform1f(v.b("filterLevel"), n);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(v.a("position"));
        GLES20.glDisableVertexAttribArray(v.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(float af[], float af1[], float af2[])
    {
        p = FloatBuffer.wrap(af);
        q = FloatBuffer.wrap(af1);
        r = FloatBuffer.wrap(af2);
    }

    public void a(PointF apointf[], PointF apointf1[], PointF apointf2[], PointF apointf3[])
    {
        w.a(apointf);
        w.b(apointf1);
        w.c(apointf2);
        w.d(apointf3);
    }

    public void b()
    {
        super.b();
        j();
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

    public void b(PointF apointf[], PointF apointf1[], PointF apointf2[], PointF apointf3[])
    {
        x.a(apointf);
        x.b(apointf1);
        x.c(apointf2);
        x.d(apointf3);
    }

    public void c()
    {
        super.c();
    }

    public int d()
    {
        return z[0];
    }

    public void f()
    {
        super.f();
        v.a(true);
        o();
    }
}
