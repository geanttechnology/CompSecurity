// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class ccr extends byh
{

    protected int a;
    protected int b;
    private cdn c;
    private int d[] = {
        -1
    };
    private int e[] = {
        -1
    };

    public ccr()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        a = 0;
        b = 0;
    }

    static void a(int i, int k, int ai[], int ai1[])
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
        GLES20.glTexImage2D(3553, 0, 6408, i, k, 0, 6408, 5121, null);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, ai1[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void j()
    {
        if (d[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, d, 0);
            d[0] = -1;
        }
        if (e[0] != -1)
        {
            GLES20.glDeleteTextures(1, e, 0);
            e[0] = -1;
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

    public void a(int i, int k)
    {
        super.a(i, k);
        while (i == 0 || k == 0 || a == i && b == k) 
        {
            return;
        }
        a = i;
        b = k;
        j();
        a(b, a, d, e);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        c.a();
        GLES20.glBindFramebuffer(36160, d[0]);
        GLES20.glViewport(0, 0, b, a);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(c.a("position"));
        GLES20.glVertexAttribPointer(c.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(c.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(c.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(c.b("inputImageTexture"), 0);
        }
        GLES20.glUniform1f(c.b("filterLevel"), u);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(c.a("position"));
        GLES20.glDisableVertexAttribArray(c.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
    }

    public void b(int i, int k)
    {
        while (n == i && o == k || i == 0 || k == 0) 
        {
            return;
        }
        n = i;
        o = k;
    }

    public void c()
    {
        super.c();
        c = new cdn("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform lowp float filterLevel;\n \nvoid main()\n{\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec3 originalColor = textureColor.rgb;\n\n     lowp vec3 rgbColor = textureColor.rgb;\n\n     gl_FragColor = vec4(mix(originalColor, rgbColor, filterLevel), 1.0);\n}");
    }

    public void d()
    {
        super.d();
        c.a(true);
        j();
    }

    public int f()
    {
        return e[0];
    }
}
