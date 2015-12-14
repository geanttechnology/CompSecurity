// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

public class aeo
{

    static final boolean o;
    protected final String a;
    protected final String b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected int h;
    protected boolean i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected float n;
    private final LinkedList p;

    public aeo()
    {
        this("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", j());
    }

    public aeo(String s, String s1)
    {
        c = -1;
        j = -1;
        n = 1.0F;
        p = new LinkedList();
        a = s;
        b = s1;
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

    public final void a()
    {
        b();
        i = true;
        c();
    }

    public void a(float f1)
    {
        if (!o)
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
        GLES20.glUseProgram(c);
        h();
        if (!i)
        {
            return;
        }
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(d, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(d);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(f, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(f);
        if (i1 != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i1);
            GLES20.glUniform1i(e, 0);
        }
        g();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(d);
        GLES20.glDisableVertexAttribArray(f);
        GLES20.glBindTexture(3553, 0);
    }

    protected void a(Runnable runnable)
    {
        synchronized (p)
        {
            p.addLast(runnable);
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

    public void b()
    {
        c = OpenGlUtils.a(a, b);
        d = GLES20.glGetAttribLocation(c, "position");
        e = GLES20.glGetUniformLocation(c, "inputImageTexture");
        f = GLES20.glGetAttribLocation(c, "inputTextureCoordinate");
        j = OpenGlUtils.a("attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n \nvarying highp vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        k = GLES20.glGetAttribLocation(j, "position");
        l = GLES20.glGetUniformLocation(j, "inputImageTexture");
        m = GLES20.glGetAttribLocation(j, "inputTextureCoordinate");
    }

    public void b(int i1, int j1)
    {
        g = i1;
        h = j1;
    }

    public void b(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        a(i1, floatbuffer, floatbuffer1);
        i1 = d();
        if (i1 == -1)
        {
            return;
        } else
        {
            GLES20.glUseProgram(j);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, g, h);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16384);
            floatbuffer.position(0);
            GLES20.glVertexAttribPointer(k, 2, 5126, false, 0, floatbuffer);
            GLES20.glEnableVertexAttribArray(k);
            floatbuffer1.position(0);
            GLES20.glVertexAttribPointer(m, 2, 5126, false, 0, floatbuffer1);
            GLES20.glEnableVertexAttribArray(m);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i1);
            GLES20.glUniform1i(l, 0);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(k);
            GLES20.glDisableVertexAttribArray(m);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
            return;
        }
    }

    public void c()
    {
    }

    public int d()
    {
        if (!o)
        {
            throw new AssertionError();
        } else
        {
            return -1;
        }
    }

    public final void e()
    {
        i = false;
        if (c >= 0)
        {
            GLES20.glDeleteProgram(c);
            c = -1;
        }
        if (j >= 0)
        {
            GLES20.glDeleteProgram(j);
            j = -1;
        }
        f();
    }

    public void f()
    {
    }

    protected void g()
    {
    }

    protected void h()
    {
        for (; !p.isEmpty(); ((Runnable)p.removeFirst()).run()) { }
    }

    public int i()
    {
        return c;
    }

    static 
    {
        boolean flag;
        if (!aeo.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        o = flag;
    }
}
