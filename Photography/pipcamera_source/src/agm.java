// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class agm extends aeo
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

    public agm(Bitmap bitmap)
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
    }

    static int a(agm agm1)
    {
        return agm1.u;
    }

    static int a(agm agm1, int i)
    {
        agm1.u = i;
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

    static Bitmap b(agm agm1)
    {
        return agm1.t;
    }

    private void j()
    {
        if (t == null)
        {
            return;
        } else
        {
            k();
            a(new Runnable() {

                final agm a;

                public void run()
                {
                    if (agm.a(a) == -1)
                    {
                        GLES20.glActiveTexture(33985);
                        agm.a(a, OpenGlUtils.a(agm.b(a), -1, true));
                    }
                }

            
            {
                a = agm.this;
                super();
            }
            });
            return;
        }
    }

    private void k()
    {
        if (u != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                u
            }, 0);
            u = -1;
        }
    }

    private void l()
    {
        v = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureMask;\nuniform sampler2D inputToneCurveTexture;\nuniform lowp vec4 colorFill;\nuniform lowp vec4 colorFill_base;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n     lowp vec4 maskColor = texture2D(inputImageTextureMask, textureCoordinate);\n \n     if (colorFill.r > 0.01 || colorFill.g > 0.01 || colorFill.b > 0.01 || colorFill.a > 0.01) { \n         rgbColor = mix(rgbColor, colorFill.rgb, colorFill.a); \n     }\n\n \n     lowp float redCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(inputToneCurveTexture, vec2(rgbColor.b, 0.0)).b;\n     rgbColor = vec3(redCurveValue, greenCurveValue, blueCurveValue);\n\n \n     rgbColor = mix(rgbColor, colorFill_base.rgb, maskColor.r*colorFill_base.a);\n \n \n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n     //gl_FragColor = vec4(maskColor.rgb, textureColor.a);\n}");
    }

    private void m()
    {
        p = FloatBuffer.wrap(new float[] {
            0.4901961F, 0.8431373F, 0.7568628F, 0.35F
        });
        q = FloatBuffer.wrap(new float[] {
            1.0F, 0.7764706F, 0.0F, 0.4F
        });
    }

    private void n()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        PointF pointf1 = new PointF(0.3333333F, 0.4627451F);
        PointF pointf2 = new PointF(0.6235294F, 0.7686275F);
        PointF pointf3 = new PointF(1.0F, 1.0F);
        PointF pointf4 = new PointF(0.0F, 0.0F);
        PointF pointf5 = new PointF(0.3607843F, 0.3176471F);
        PointF pointf6 = new PointF(0.6352941F, 0.6509804F);
        PointF pointf7 = new PointF(1.0F, 1.0F);
        PointF pointf8 = new PointF(0.0F, 0.0F);
        PointF pointf9 = new PointF(0.1333333F, 0.1411765F);
        PointF pointf10 = new PointF(0.3921569F, 0.3568628F);
        PointF pointf11 = new PointF(0.6666667F, 0.6901961F);
        PointF pointf12 = new PointF(0.8392157F, 0.8392157F);
        PointF pointf13 = new PointF(1.0F, 1.0F);
        PointF pointf14 = new PointF(0.0F, 0.0F);
        PointF pointf15 = new PointF(0.1058824F, 0.1568628F);
        PointF pointf16 = new PointF(0.5882353F, 0.7333333F);
        PointF pointf17 = new PointF(1.0F, 1.0F);
        w.a(new PointF[] {
            pointf, pointf1, pointf2, pointf3
        });
        w.b(new PointF[] {
            pointf4, pointf5, pointf6, pointf7
        });
        w.c(new PointF[] {
            pointf8, pointf9, pointf10, pointf11, pointf12, pointf13
        });
        w.d(new PointF[] {
            pointf14, pointf15, pointf16, pointf17
        });
    }

    private void o()
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
        o();
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
        GLES20.glUniform4fv(v.b("colorFill"), 1, p);
        GLES20.glUniform4fv(v.b("colorFill_base"), 1, q);
        w.a(33989);
        GLES20.glUniform1i(v.b("inputToneCurveTexture"), 5);
        GLES20.glUniform1f(v.b("filterLevel"), n);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(v.a("position"));
        GLES20.glDisableVertexAttribArray(v.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    public void b()
    {
        super.b();
        l();
        m();
        n();
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
        k();
        v.a(true);
        o();
    }
}
