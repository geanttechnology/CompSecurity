// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class afg extends aeo
{

    FloatBuffer p;
    FloatBuffer q;
    protected int r;
    protected int s;
    private Bitmap t;
    private int u;
    private agu v;
    private agk w;
    private int x[] = {
        -1
    };
    private int y[] = {
        -1
    };

    public afg(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        t = null;
        u = -1;
        p = null;
        q = null;
        w = new agk();
        r = 0;
        s = 0;
        t = bitmap;
        j();
    }

    static int a(afg afg1)
    {
        return afg1.u;
    }

    static int a(afg afg1, int i)
    {
        afg1.u = i;
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

    static Bitmap b(afg afg1)
    {
        return afg1.t;
    }

    private void j()
    {
        n();
        o();
        l();
    }

    private void k()
    {
        v = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec4 colorFill_multiply;\nuniform lowp vec4 colorFill_exclusion;\nuniform lowp vec3 bceShift;\nuniform lowp vec3 hsbShift;\nuniform lowp float filterLevel;\n \n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     // multiply \n     lowp vec3 newcolor = colorFill_multiply.rgb * rgbColor.rgb; \n     rgbColor = mix(rgbColor, newcolor, colorFill_multiply.a); \n     rgbColor = clamp(rgbColor, vec3(0.0), vec3(1.0)); \n \n \n     // exclusion \n     newcolor = (colorFill_exclusion.rgb + rgbColor.rgb - 2.0*colorFill_exclusion.rgb*rgbColor.rgb); \n     rgbColor = mix(rgbColor, newcolor, colorFill_exclusion.a); \n     rgbColor = clamp(rgbColor, vec3(0.0), vec3(1.0)); \n \n \n     rgbColor = rgbColor * maskColor.rgb;\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void l()
    {
        if (t == null)
        {
            return;
        } else
        {
            m();
            a(new Runnable() {

                final afg a;

                public void run()
                {
                    if (afg.a(a) == -1)
                    {
                        GLES20.glActiveTexture(33985);
                        afg.a(a, OpenGlUtils.a(afg.b(a), -1, true));
                    }
                }

            
            {
                a = afg.this;
                super();
            }
            });
            return;
        }
    }

    private void m()
    {
        if (u != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                u
            }, 0);
            u = -1;
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
        w.a(new PointF[] {
            pointf, pointf1
        });
        w.b(new PointF[] {
            pointf2, pointf3
        });
        w.c(new PointF[] {
            pointf4, pointf5
        });
        w.d(new PointF[] {
            pointf6, pointf7
        });
    }

    private void p()
    {
        if (x[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, x, 0);
            x[0] = -1;
        }
        if (y[0] != -1)
        {
            GLES20.glDeleteTextures(1, y, 0);
            y[0] = -1;
        }
    }

    public void a(float f1)
    {
        n = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || r == i && s == i1) 
        {
            return;
        }
        r = i;
        s = i1;
        p();
        a(s, r, x, y);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!this.i)
        {
            return;
        }
        v.a();
        GLES20.glBindFramebuffer(36160, x[0]);
        GLES20.glViewport(0, 0, s, r);
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
        if (u != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, u);
            GLES20.glUniform1i(v.b("inputImageTextureMask"), 1);
        }
        GLES20.glUniform4fv(v.b("colorFill_multiply"), 1, p);
        GLES20.glUniform4fv(v.b("colorFill_exclusion"), 1, q);
        w.a(33988);
        GLES20.glUniform1i(v.b("inputToneCurveTexture"), 4);
        GLES20.glUniform1f(v.b("filterLevel"), n);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(v.a("position"));
        GLES20.glDisableVertexAttribArray(v.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void a(float af[], float af1[])
    {
        p = FloatBuffer.wrap(af);
        q = FloatBuffer.wrap(af1);
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
        return y[0];
    }

    public void f()
    {
        super.f();
        m();
        v.a(true);
        p();
    }
}
