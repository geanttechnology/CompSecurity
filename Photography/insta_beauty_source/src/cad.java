// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class cad extends byh
{

    protected int a;
    protected int b;
    private cdn c;
    private final float d = 10F;
    private float e;
    private int f[] = {
        -1
    };
    private int g[] = {
        -1
    };
    private int w[] = {
        -1
    };
    private int x[] = {
        -1
    };

    public cad()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        e = 0.0F;
        a = 0;
        b = 0;
        e = 1.0F;
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
        if (f[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, f, 0);
            f[0] = -1;
        }
        if (w[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, w, 0);
            w[0] = -1;
        }
        if (g[0] != -1)
        {
            GLES20.glDeleteTextures(1, g, 0);
            g[0] = -1;
        }
        if (x[0] != -1)
        {
            GLES20.glDeleteTextures(1, x, 0);
            x[0] = -1;
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
        a(b, a, f, g);
        a(b, a, w, x);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!p)
        {
            return;
        }
        c.a();
        GLES20.glBindFramebuffer(36160, f[0]);
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
        GLES20.glUniform2fv(c.b("textureOffset"), 1, FloatBuffer.wrap(new float[] {
            0.0F, e / (float)a
        }));
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(c.a("position"));
        GLES20.glDisableVertexAttribArray(c.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
        c.a();
        GLES20.glBindFramebuffer(36160, w[0]);
        GLES20.glViewport(0, 0, b, a);
        GLES20.glClearColor(0.0F, 1.0F, 1.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(c.a("position"));
        GLES20.glVertexAttribPointer(c.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(c.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(c.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (g[0] != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, g[0]);
            GLES20.glUniform1i(c.b("inputImageTexture"), 0);
        }
        GLES20.glUniform2fv(c.b("textureOffset"), 1, FloatBuffer.wrap(new float[] {
            e / (float)a, 0.0F
        }));
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(c.a("position"));
        GLES20.glDisableVertexAttribArray(c.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
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
        c = new cdn("attribute highp vec4 position; \nattribute highp vec4 inputTextureCoordinate; \nuniform highp vec2 textureOffset; \nvarying highp vec2 blurCoordinates[7]; \n \nvoid main() \n{ \n\tgl_Position = position; \n\tblurCoordinates[0] = inputTextureCoordinate.xy; \n\tblurCoordinates[1] = inputTextureCoordinate.xy + textureOffset * 1.407333; \n\tblurCoordinates[2] = inputTextureCoordinate.xy - textureOffset * 1.407333; \n\tblurCoordinates[3] = inputTextureCoordinate.xy + textureOffset * 3.294215; \n\tblurCoordinates[4] = inputTextureCoordinate.xy - textureOffset * 3.294215; \n\tblurCoordinates[5] = inputTextureCoordinate.xy + textureOffset * 5.201813; \n\tblurCoordinates[6] = inputTextureCoordinate.xy - textureOffset * 5.201813; \n}", "uniform sampler2D inputImageTexture; \nvarying highp vec2 blurCoordinates[7]; \n \nvoid main() \n{ \n\tlowp vec4 sum = vec4(0.0); \n\tsum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.199676; \n\tsum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.297323; \n\tsum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.297323; \n\tsum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.091848; \n\tsum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.091848; \n\tsum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.010991; \n\tsum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.010991; \n \n\tgl_FragColor = vec4(sum.xyz, 1.0); \n} \n");
    }

    public void d()
    {
        super.d();
        c.a(true);
        j();
    }

    public int f()
    {
        return x[0];
    }
}
