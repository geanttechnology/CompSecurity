// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class afb extends aeo
{

    protected int p;
    protected int q;
    private agu r;
    private final float s = 10F;
    private float t;
    private int u[] = {
        -1
    };
    private int v[] = {
        -1
    };
    private int w[] = {
        -1
    };
    private int x[] = {
        -1
    };

    public afb()
    {
        super("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        t = 0.0F;
        p = 0;
        q = 0;
        t = 1.0F;
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
        if (u[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, u, 0);
            u[0] = -1;
        }
        if (w[0] >= 0)
        {
            GLES20.glDeleteFramebuffers(1, w, 0);
            w[0] = -1;
        }
        if (v[0] != -1)
        {
            GLES20.glDeleteTextures(1, v, 0);
            v[0] = -1;
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

    public void a(int i, int k)
    {
        super.a(i, k);
        while (i == 0 || k == 0 || p == i && q == k) 
        {
            return;
        }
        p = i;
        q = k;
        j();
        a(q, p, u, v);
        a(q, p, w, x);
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        h();
        if (!this.i)
        {
            return;
        }
        r.a();
        GLES20.glBindFramebuffer(36160, u[0]);
        GLES20.glViewport(0, 0, q, p);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(r.a("position"));
        GLES20.glVertexAttribPointer(r.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(r.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(r.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(r.b("inputImageTexture"), 0);
        }
        GLES20.glUniform2fv(r.b("textureOffset"), 1, FloatBuffer.wrap(new float[] {
            0.0F, t / (float)p
        }));
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(r.a("position"));
        GLES20.glDisableVertexAttribArray(r.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
        r.a();
        GLES20.glBindFramebuffer(36160, w[0]);
        GLES20.glViewport(0, 0, q, p);
        GLES20.glClearColor(0.0F, 1.0F, 1.0F, 1.0F);
        GLES20.glClear(16384);
        floatbuffer.position(0);
        GLES20.glEnableVertexAttribArray(r.a("position"));
        GLES20.glVertexAttribPointer(r.a("position"), 2, 5126, false, 0, floatbuffer);
        floatbuffer1.position(0);
        GLES20.glEnableVertexAttribArray(r.a("inputTextureCoordinate"));
        GLES20.glVertexAttribPointer(r.a("inputTextureCoordinate"), 2, 5126, false, 0, floatbuffer1);
        if (v[0] != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, v[0]);
            GLES20.glUniform1i(r.b("inputImageTexture"), 0);
        }
        GLES20.glUniform2fv(r.b("textureOffset"), 1, FloatBuffer.wrap(new float[] {
            t / (float)p, 0.0F
        }));
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(r.a("position"));
        GLES20.glDisableVertexAttribArray(r.a("inputTextureCoordinate"));
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    public void b()
    {
        super.b();
        r = new agu("attribute highp vec4 position; \nattribute highp vec4 inputTextureCoordinate; \nuniform highp vec2 textureOffset; \nvarying highp vec2 blurCoordinates[7]; \n \nvoid main() \n{ \n\tgl_Position = position; \n\tblurCoordinates[0] = inputTextureCoordinate.xy; \n\tblurCoordinates[1] = inputTextureCoordinate.xy + textureOffset * 1.407333; \n\tblurCoordinates[2] = inputTextureCoordinate.xy - textureOffset * 1.407333; \n\tblurCoordinates[3] = inputTextureCoordinate.xy + textureOffset * 3.294215; \n\tblurCoordinates[4] = inputTextureCoordinate.xy - textureOffset * 3.294215; \n\tblurCoordinates[5] = inputTextureCoordinate.xy + textureOffset * 5.201813; \n\tblurCoordinates[6] = inputTextureCoordinate.xy - textureOffset * 5.201813; \n}", "uniform sampler2D inputImageTexture; \nvarying highp vec2 blurCoordinates[7]; \n \nvoid main() \n{ \n\tlowp vec4 sum = vec4(0.0); \n\tsum += texture2D(inputImageTexture, blurCoordinates[0]) * 0.199676; \n\tsum += texture2D(inputImageTexture, blurCoordinates[1]) * 0.297323; \n\tsum += texture2D(inputImageTexture, blurCoordinates[2]) * 0.297323; \n\tsum += texture2D(inputImageTexture, blurCoordinates[3]) * 0.091848; \n\tsum += texture2D(inputImageTexture, blurCoordinates[4]) * 0.091848; \n\tsum += texture2D(inputImageTexture, blurCoordinates[5]) * 0.010991; \n\tsum += texture2D(inputImageTexture, blurCoordinates[6]) * 0.010991; \n \n\tgl_FragColor = vec4(sum.xyz, 1.0); \n} \n");
    }

    public void b(int i, int k)
    {
        while (g == i && h == k || i == 0 || k == 0) 
        {
            return;
        }
        g = i;
        h = k;
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
        r.a(true);
        j();
    }
}
