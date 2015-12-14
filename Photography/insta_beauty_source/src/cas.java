// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class cas extends byh
{

    protected int a;
    protected int b;
    private Bitmap c;
    private int d;
    private cdn e;
    private ccu f;
    private int g[] = {
        -1
    };
    private int w[] = {
        -1
    };

    public cas(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        c = null;
        d = -1;
        f = new ccu();
        a = 0;
        b = 0;
        c = bitmap;
        j();
    }

    static int a(cas cas1)
    {
        return cas1.d;
    }

    static int a(cas cas1, int i)
    {
        cas1.d = i;
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

    static Bitmap b(cas cas1)
    {
        return cas1.c;
    }

    private void j()
    {
        n();
        l();
    }

    private void k()
    {
        e = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp float filterLevel;\n \n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n \n     rgbColor = rgbColor * maskColor.rgb;\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void l()
    {
        if (c == null)
        {
            return;
        } else
        {
            m();
            a(new cat(this));
            return;
        }
    }

    private void m()
    {
        if (d != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                d
            }, 0);
            d = -1;
        }
    }

    private void n()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        PointF pointf1 = new PointF(1.0F, 1.0F);
        PointF pointf2 = new PointF(0.0F, 0.0F);
        PointF pointf3 = new PointF(1.0F, 1.0F);
        PointF pointf4 = new PointF(0.0F, 0.0F);
        PointF pointf5 = new PointF(1.0F, 1.0F);
        PointF pointf6 = new PointF(0.0F, 0.0F);
        PointF pointf7 = new PointF(1.0F, 1.0F);
        f.a(new PointF[] {
            pointf, pointf1
        });
        f.b(new PointF[] {
            pointf2, pointf3
        });
        f.c(new PointF[] {
            pointf4, pointf5
        });
        f.d(new PointF[] {
            pointf6, pointf7
        });
    }

    private void o()
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
        while (i == 0 || i1 == 0 || a == i && b == i1) 
        {
            return;
        }
        a = i;
        b = i1;
        o();
        a(b, a, g, w);
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
        GLES20.glViewport(0, 0, b, a);
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
        if (d != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, d);
            GLES20.glUniform1i(e.b("inputImageTextureMask"), 1);
        }
        f.a(33988);
        GLES20.glUniform1i(e.b("inputToneCurveTexture"), 4);
        GLES20.glUniform1f(e.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(e.a("position"));
        GLES20.glDisableVertexAttribArray(e.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(PointF apointf[], PointF apointf1[], PointF apointf2[], PointF apointf3[])
    {
        f.a(apointf);
        f.b(apointf1);
        f.c(apointf2);
        f.d(apointf3);
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
        e.a(true);
        o();
    }

    public int f()
    {
        return w[0];
    }
}
