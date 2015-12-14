// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class afs extends aeo
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

    public afs(Bitmap bitmap)
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

    static int a(afs afs1)
    {
        return afs1.t;
    }

    static int a(afs afs1, int i)
    {
        afs1.t = i;
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

    static Bitmap b(afs afs1)
    {
        return afs1.s;
    }

    private void j()
    {
        n();
        o();
        l();
    }

    private void k()
    {
        u = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec3 bceShift;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     //brightness\n     rgbColor = clamp(pow(rgbColor, vec3(bceShift.r)), vec3(0.0), vec3(1.0));\n     //contrast\n     rgbColor = clamp((rgbColor - vec3(0.5)) * (1.0 + bceShift.g) + vec3(0.5), vec3(0.0), vec3(1.0));\n     //exposure\n     //rgbColor = clamp(rgbColor * pow(2.0, bceShift.b), vec3(0.0), vec3(1.0));\n \n     rgbColor = rgbColor * maskColor.rgb;\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
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

                final afs a;

                public void run()
                {
                    if (afs.a(a) == -1)
                    {
                        GLES20.glActiveTexture(33985);
                        afs.a(a, OpenGlUtils.a(afs.b(a), -1, true));
                    }
                }

            
            {
                a = afs.this;
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
            0.0F, 0.0F, 0.0F
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
        GLES20.glUniform3fv(u.b("bceShift"), 1, p);
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
