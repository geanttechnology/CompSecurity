// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class ccm extends byh
{

    boolean a;
    protected int b;
    protected int c;
    private Bitmap d;
    private int e;
    private int f;
    private int g;
    private cdn w;
    private int x[] = {
        -1
    };
    private int y[] = {
        -1
    };

    public ccm()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        d = null;
        e = 0;
        f = -1;
        g = -1;
        a = false;
        b = 0;
        c = 0;
    }

    public ccm(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        d = null;
        e = 0;
        f = -1;
        g = -1;
        a = false;
        b = 0;
        c = 0;
        d = bitmap;
        if (d != null)
        {
            e = d.getHeight();
        }
    }

    static int a(ccm ccm1)
    {
        return ccm1.g;
    }

    static int a(ccm ccm1, int i)
    {
        ccm1.g = i;
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

    static Bitmap b(ccm ccm1)
    {
        return ccm1.d;
    }

    private void j()
    {
        if (d == null)
        {
            return;
        } else
        {
            a(new ccn(this));
            return;
        }
    }

    private void k()
    {
        if (g != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                g
            }, 0);
            g = -1;
        }
    }

    private void l()
    {
        w = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureLUT;\nuniform lowp float filterLevel;\nuniform lowp int adjustLUT;\nuniform lowp float yCoord;\nuniform lowp float yContrastCoord;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 originalColor = vec4(textureColor.rgb, 1.0);\n\n     lowp vec4 rgbColor = vec4(textureColor.rgb, 1.0);\n\n \n     if (adjustLUT != 0) {\n         lowp float newr = texture2D(inputImageTextureLUT, vec2(rgbColor.r, yContrastCoord)).r;\n         lowp float newg = texture2D(inputImageTextureLUT, vec2(rgbColor.g, yContrastCoord)).g;\n         lowp float newb = texture2D(inputImageTextureLUT, vec2(rgbColor.b, yContrastCoord)).b;\n         newr = texture2D(inputImageTextureLUT, vec2(rgbColor.r, yCoord)).r;\n         newg = texture2D(inputImageTextureLUT, vec2(rgbColor.g, yCoord)).g;\n         newb = texture2D(inputImageTextureLUT, vec2(rgbColor.b, yCoord)).b;\n         rgbColor = vec4(newr, newg, newb, 1.0);\n     }\n \n     gl_FragColor = mix(originalColor, rgbColor, filterLevel);\n     //gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n}");
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

    public void a()
    {
        super.a();
    }

    public void a(float f1)
    {
        u = f1;
    }

    public void a(int i)
    {
        f = i;
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
        a(c, b, x, y);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        w.a();
        GLES20.glBindFramebuffer(36160, x[0]);
        GLES20.glViewport(0, 0, c, b);
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
        if (a)
        {
            j();
            a = false;
        }
        if (g != -1 && f > 0 && f < e)
        {
            GLES20.glUniform1i(w.b("adjustLUT"), 1);
            GLES20.glUniform1f(w.b("yContrastCoord"), (float)((double)e - 0.5D) / (float)e);
            GLES20.glUniform1f(w.b("yCoord"), (float)((double)f - 0.5D) / (float)e);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, g);
            GLES20.glUniform1i(w.b("inputImageTextureLUT"), 1);
        } else
        {
            GLES20.glUniform1i(w.b("adjustLUT"), 0);
        }
        GLES20.glUniform1f(w.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(w.a("position"));
        GLES20.glDisableVertexAttribArray(w.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
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
        j();
    }

    public void d()
    {
        super.d();
        k();
        w.a(true);
        m();
    }

    public int f()
    {
        return y[0];
    }
}
