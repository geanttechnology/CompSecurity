// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class agf extends aeo
{

    boolean p;
    protected int q;
    protected int r;
    private Bitmap s;
    private int t;
    private int u;
    private int v;
    private agu w;
    private int x[] = {
        -1
    };
    private int y[] = {
        -1
    };

    public agf()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        s = null;
        t = 0;
        u = -1;
        v = -1;
        p = false;
        q = 0;
        r = 0;
    }

    public agf(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        s = null;
        t = 0;
        u = -1;
        v = -1;
        p = false;
        q = 0;
        r = 0;
        s = bitmap;
        if (s != null)
        {
            t = s.getHeight();
        }
    }

    static int a(agf agf1)
    {
        return agf1.v;
    }

    static int a(agf agf1, int i)
    {
        agf1.v = i;
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
        GLES20.glCheckFramebufferStatus(36160);
        GLES20.glBindFramebuffer(36160, 0);
    }

    static Bitmap b(agf agf1)
    {
        return agf1.s;
    }

    private void j()
    {
        if (s == null)
        {
            return;
        } else
        {
            a(new Runnable() {

                final agf a;

                public void run()
                {
                    if (agf.a(a) != -1)
                    {
                        GLES20.glDeleteTextures(1, new int[] {
                            agf.a(a)
                        }, 0);
                        agf.a(a, -1);
                    }
                    GLES20.glActiveTexture(33985);
                    agf.a(a, OpenGlUtils.a(agf.b(a), -1, true));
                }

            
            {
                a = agf.this;
                super();
            }
            });
            return;
        }
    }

    private void k()
    {
        if (v != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                v
            }, 0);
            v = -1;
        }
    }

    private void l()
    {
        w = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureLUT;\nuniform lowp float filterLevel;\nuniform lowp int adjustLUT;\nuniform lowp float yCoord;\nuniform lowp float yContrastCoord;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 originalColor = vec4(textureColor.rgb, 1.0);\n\n     lowp vec4 rgbColor = vec4(textureColor.rgb, 1.0);\n\n \n     if (adjustLUT != 0) {\n         lowp float newr = texture2D(inputImageTextureLUT, vec2(rgbColor.r, yContrastCoord)).r;\n         lowp float newg = texture2D(inputImageTextureLUT, vec2(rgbColor.g, yContrastCoord)).g;\n         lowp float newb = texture2D(inputImageTextureLUT, vec2(rgbColor.b, yContrastCoord)).b;\n         newr = texture2D(inputImageTextureLUT, vec2(rgbColor.r, yCoord)).r;\n         newg = texture2D(inputImageTextureLUT, vec2(rgbColor.g, yCoord)).g;\n         newb = texture2D(inputImageTextureLUT, vec2(rgbColor.b, yCoord)).b;\n         rgbColor = vec4(newr, newg, newb, 1.0);\n     }\n \n     gl_FragColor = mix(originalColor, rgbColor, filterLevel);\n     //gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n}");
    }

    private void m()
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

    public void a(int i)
    {
        u = i;
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
        m();
        a(r, q, x, y);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!this.i)
        {
            return;
        }
        w.a();
        GLES20.glBindFramebuffer(36160, x[0]);
        GLES20.glViewport(0, 0, r, q);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(w.a("position"));
        GLES20.glVertexAttribPointer(w.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(w.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(w.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(w.b("inputImageTexture"), 0);
        }
        if (p)
        {
            j();
            p = false;
        }
        if (v != -1 && u > 0 && u < t)
        {
            GLES20.glUniform1i(w.b("adjustLUT"), 1);
            GLES20.glUniform1f(w.b("yContrastCoord"), (float)((double)t - 0.5D) / (float)t);
            GLES20.glUniform1f(w.b("yCoord"), (float)((double)u - 0.5D) / (float)t);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, v);
            GLES20.glUniform1i(w.b("inputImageTextureLUT"), 1);
        } else
        {
            GLES20.glUniform1i(w.b("adjustLUT"), 0);
        }
        GLES20.glUniform1f(w.b("filterLevel"), n);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(w.a("position"));
        GLES20.glDisableVertexAttribArray(w.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    public void b()
    {
        super.b();
        l();
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
        w.a(true);
        m();
    }
}
