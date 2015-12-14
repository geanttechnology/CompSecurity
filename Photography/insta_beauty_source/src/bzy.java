// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class bzy extends byh
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

    public bzy(Bitmap bitmap)
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        c = null;
        d = -1;
        f = new ccu();
        a = 0;
        b = 0;
        c = bitmap;
    }

    static int a(bzy bzy1)
    {
        return bzy1.d;
    }

    static int a(bzy bzy1, int i)
    {
        bzy1.d = i;
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

    static Bitmap b(bzy bzy1)
    {
        return bzy1.c;
    }

    private void j()
    {
        if (c == null)
        {
            return;
        } else
        {
            k();
            a(new bzz(this));
            return;
        }
    }

    private void k()
    {
        if (d != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                d
            }, 0);
            d = -1;
        }
    }

    private void l()
    {
        e = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTextureColorleak;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n \n\t  highp vec2 newCoordinate = vec2(1.0-textureCoordinate.x, 1.0-textureCoordinate.y);\n     lowp vec4 leakColor = texture2D(inputImageTextureColorleak, newCoordinate);\n     rgbColor = vec3(1.0) - (vec3(1.0) - rgbColor.rgb)*(vec3(1.0) - leakColor.rgb);\n \n \n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), textureColor.a);\n}");
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
        while (i == 0 || i1 == 0 || a == i && b == i1) 
        {
            return;
        }
        a = i;
        b = i1;
        m();
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
            GLES20.glUniform1i(e.b("inputImageTextureColorleak"), 1);
        }
        GLES20.glUniform1f(e.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(e.a("position"));
        GLES20.glDisableVertexAttribArray(e.a("inputTextureCoordinate"));
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
        e.a(true);
        m();
    }

    public int f()
    {
        return w[0];
    }
}
