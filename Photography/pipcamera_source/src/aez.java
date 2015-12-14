// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class aez extends aeo
{

    protected int p;
    protected int q;
    private Bitmap r;
    private int s;
    private agu t;
    private agk u;
    private int v[] = {
        -1
    };
    private int w[] = {
        -1
    };

    public aez(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        r = null;
        s = -1;
        u = new agk();
        p = 0;
        q = 0;
        r = bitmap;
    }

    static int a(aez aez1)
    {
        return aez1.s;
    }

    static int a(aez aez1, int i)
    {
        aez1.s = i;
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

    static Bitmap b(aez aez1)
    {
        return aez1.r;
    }

    private void j()
    {
        if (r == null)
        {
            return;
        } else
        {
            k();
            a(new Runnable() {

                final aez a;

                public void run()
                {
                    if (aez.a(a) == -1)
                    {
                        GLES20.glActiveTexture(33985);
                        aez.a(a, OpenGlUtils.a(aez.b(a), -1, true));
                    }
                }

            
            {
                a = aez.this;
                super();
            }
            });
            return;
        }
    }

    private void k()
    {
        if (s != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                s
            }, 0);
            s = -1;
        }
    }

    private void l()
    {
        t = new agu("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureColorleak;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n\t  highp vec2 newCoordinate = vec2(1.0-textureCoordinate.x, 1.0-textureCoordinate.y);\n     lowp vec4 leakColor = texture2D(inputImageTextureColorleak, newCoordinate);\n     rgbColor = vec3(1.0) - (vec3(1.0) - rgbColor.rgb)*(vec3(1.0) - leakColor.rgb);\n \n \n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
    }

    private void m()
    {
        if (v[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, v, 0);
            v[0] = -1;
        }
        if (w[0] != -1)
        {
            GLES20.glDeleteTextures(1, w, 0);
            w[0] = -1;
        }
    }

    public void a(float f1)
    {
        n = f1;
    }

    public void a(int i, int i1)
    {
        super.a(i, i1);
        while (i == 0 || i1 == 0 || p == i && q == i1) 
        {
            return;
        }
        p = i;
        q = i1;
        m();
        a(q, p, v, w);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!this.i)
        {
            return;
        }
        t.a();
        GLES20.glBindFramebuffer(36160, v[0]);
        GLES20.glViewport(0, 0, q, p);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(t.a("position"));
        GLES20.glVertexAttribPointer(t.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(t.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(t.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(t.b("inputImageTexture"), 0);
        }
        if (s != -1)
        {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, s);
            GLES20.glUniform1i(t.b("inputImageTextureColorleak"), 1);
        }
        GLES20.glUniform1f(t.b("filterLevel"), n);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(t.a("position"));
        GLES20.glDisableVertexAttribArray(t.a("inputTextureCoordinate"));
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
        return w[0];
    }

    public void f()
    {
        super.f();
        k();
        t.a(true);
        m();
    }
}
