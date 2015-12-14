// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class byh
{

    static final boolean v;
    private final LinkedList a;
    protected final String h;
    protected final String i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected int o;
    protected boolean p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    protected float u;

    public byh()
    {
        this("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", j());
    }

    public byh(String s1, String s2)
    {
        j = -1;
        q = -1;
        u = 1.0F;
        a = new LinkedList();
        h = s1;
        i = s2;
    }

    private static String j()
    {
        if (OpenGlUtils.a() == jp.co.cyberagent.android.gpuimage.OpenGlUtils.GPURenderType.GPUImageRender_RGB)
        {
            return "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
        } else
        {
            return "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n  mediump vec3 yuv =  texture2D(inputImageTexture, textureCoordinate).rgb; \n  mediump vec3 rgb; \n  mediump float y = 1.164*(yuv.r - 0.0625) ; \n  mediump float u = yuv.g - 0.5; \n  mediump float v = yuv.b - 0.5; \n  rgb.r = y + 1.596*v; \n  rgb.g = y - 0.813*v - 0.391*u ; \n  rgb.b = y                  + 2.018*u ; \n  gl_FragColor = vec4(rgb, 1);\n}";
        }
    }

    public void a()
    {
    }

    public void a(float f1)
    {
        if (!v)
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    protected void a(int i1, float f1)
    {
        GLES20.glUniform1f(i1, f1);
    }

    public void a(int i1, int j1)
    {
    }

    public void a(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glUseProgram(j);
        h();
        if (!p)
        {
            return;
        }
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(k, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(k);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(m, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(m);
        if (i1 != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i1);
            GLES20.glUniform1i(l, 0);
        }
        b();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(k);
        GLES20.glDisableVertexAttribArray(m);
        GLES20.glBindTexture(3553, 0);
    }

    protected void a(Runnable runnable)
    {
        synchronized (a)
        {
            a.addLast(runnable);
        }
        return;
        runnable;
        linkedlist;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void a(boolean flag)
    {
    }

    protected void b()
    {
    }

    public void b(int i1, int j1)
    {
        n = i1;
        o = j1;
    }

    public void b(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        a(i1, floatbuffer, floatbuffer1);
        i1 = f();
        if (i1 == -1)
        {
            return;
        } else
        {
            GLES20.glUseProgram(q);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, n, o);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16384);
            floatbuffer.position(0);
            GLES20.glVertexAttribPointer(r, 2, 5126, false, 0, floatbuffer);
            GLES20.glEnableVertexAttribArray(r);
            floatbuffer1.position(0);
            GLES20.glVertexAttribPointer(t, 2, 5126, false, 0, floatbuffer1);
            GLES20.glEnableVertexAttribArray(t);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i1);
            GLES20.glUniform1i(s, 0);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(r);
            GLES20.glDisableVertexAttribArray(t);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
            return;
        }
    }

    public void c()
    {
        j = OpenGlUtils.a(h, i);
        k = GLES20.glGetAttribLocation(j, "position");
        l = GLES20.glGetUniformLocation(j, "inputImageTexture");
        m = GLES20.glGetAttribLocation(j, "inputTextureCoordinate");
        q = OpenGlUtils.a("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        r = GLES20.glGetAttribLocation(q, "position");
        s = GLES20.glGetUniformLocation(q, "inputImageTexture");
        t = GLES20.glGetAttribLocation(q, "inputTextureCoordinate");
    }

    public void d()
    {
    }

    public final void e()
    {
        c();
        p = true;
        a();
    }

    public int f()
    {
        if (!v)
        {
            throw new AssertionError();
        } else
        {
            return -1;
        }
    }

    public final void g()
    {
        p = false;
        if (j >= 0)
        {
            GLES20.glDeleteProgram(j);
            j = -1;
        }
        if (q >= 0)
        {
            GLES20.glDeleteProgram(q);
            q = -1;
        }
        d();
    }

    protected void h()
    {
        for (; !a.isEmpty(); ((Runnable)a.removeFirst()).run()) { }
    }

    public int i()
    {
        return j;
    }

    static 
    {
        boolean flag;
        if (!byh.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        v = flag;
    }
}
