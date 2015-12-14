// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.cyberlink.clgpuimage:
//            af

public class u
{

    private final Queue a;
    protected int aA;
    protected GPUImage.ScaleType aB;
    protected int aC;
    protected int aD;
    protected int av;
    protected int aw;
    protected int ax;
    protected int ay;
    protected int az;
    private String b;
    private String c;
    private boolean d;

    public u()
    {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public u(String s, String s1)
    {
        aB = GPUImage.ScaleType.b;
        aC = 0;
        aD = 0;
        a = new ConcurrentLinkedQueue();
        b = s;
        c = s1;
    }

    public void a()
    {
        av = af.a(b, c);
        aw = GLES20.glGetAttribLocation(av, "position");
        ax = GLES20.glGetUniformLocation(av, "inputImageTexture");
        ay = GLES20.glGetAttribLocation(av, "inputTextureCoordinate");
        d = true;
    }

    protected void a(int i1, float f)
    {
        a(new Runnable(i1, f) {

            final int a;
            final float b;
            final u c;

            public void run()
            {
                GLES20.glUniform1f(a, b);
            }

            
            {
                c = u.this;
                a = i1;
                b = f;
                super();
            }
        });
    }

    public void a(int i1, int j1)
    {
        az = i1;
        aA = j1;
    }

    protected void a(int i1, PointF pointf)
    {
        a(new Runnable(pointf, i1) {

            final PointF a;
            final int b;
            final u c;

            public void run()
            {
                float f = a.x;
                float f1 = a.y;
                GLES20.glUniform2fv(b, 1, new float[] {
                    f, f1
                }, 0);
            }

            
            {
                c = u.this;
                a = pointf;
                b = i1;
                super();
            }
        });
    }

    protected void a(int i1, float af1[])
    {
        a(new Runnable(i1, af1) {

            final int a;
            final float b[];
            final u c;

            public void run()
            {
                GLES20.glUniform2fv(a, 1, FloatBuffer.wrap(b));
            }

            
            {
                c = u.this;
                a = i1;
                b = af1;
                super();
            }
        });
    }

    public void a(GPUImage.ScaleType scaletype)
    {
        aB = scaletype;
    }

    protected void a(Runnable runnable)
    {
        a.add(runnable);
    }

    public void a(String s, String s1)
    {
        b = s;
        c = s1;
    }

    public void b()
    {
    }

    public void b(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glUseProgram(av);
        d_();
        if (!d)
        {
            return;
        }
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(aw, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(aw);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(ay, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(ay);
        if (i1 != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i1);
            GLES20.glUniform1i(ax, 0);
        }
        e();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(aw);
        GLES20.glDisableVertexAttribArray(ay);
        GLES20.glBindTexture(3553, 0);
    }

    protected void b(int i1, float af1[])
    {
        a(new Runnable(i1, af1) {

            final int a;
            final float b[];
            final u c;

            public void run()
            {
                GLES20.glUniformMatrix4fv(a, 1, false, b, 0);
            }

            
            {
                c = u.this;
                a = i1;
                b = af1;
                super();
            }
        });
    }

    public void c()
    {
    }

    public void c(int i1, int j1)
    {
        aC = i1;
        aD = j1;
    }

    protected void d(int i1, int j1)
    {
        a(new Runnable(i1, j1) {

            final int a;
            final int b;
            final u c;

            public void run()
            {
                GLES20.glUniform1i(a, b);
            }

            
            {
                c = u.this;
                a = i1;
                b = j1;
                super();
            }
        });
    }

    protected void d_()
    {
        Queue queue = a;
        queue;
        JVM INSTR monitorenter ;
        for (; !a.isEmpty(); ((Runnable)a.poll()).run()) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        queue;
        JVM INSTR monitorexit ;
        throw exception;
        queue;
        JVM INSTR monitorexit ;
    }

    protected void e()
    {
    }

    public final void g()
    {
        a();
        d = true;
        b();
    }

    public final void h()
    {
        d = false;
        GLES20.glDeleteProgram(av);
        c();
    }

    public boolean i()
    {
        return d;
    }

    public int j()
    {
        return az;
    }

    public int k()
    {
        return aA;
    }

    public int l()
    {
        return av;
    }
}
