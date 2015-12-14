// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.aw;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import myobfuscated.f.m;

public class d
{

    public int a;
    boolean b;
    private final LinkedList c;
    private final String d;
    private final String e;
    private int f;
    private int g;
    private int h;

    public d()
    {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public d(String s, String s1)
    {
        c = new LinkedList();
        d = s;
        e = s1;
    }

    private void a(Runnable runnable)
    {
        synchronized (c)
        {
            c.addLast(runnable);
        }
        return;
        runnable;
        linkedlist;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void a()
    {
        String s1;
        int ai[];
        boolean flag;
        int k;
        flag = false;
        String s = d;
        s1 = e;
        ai = new int[1];
        k = m.a(s, 35633);
        if (k != 0) goto _L2; else goto _L1
_L1:
        int i = ((flag) ? 1 : 0);
_L4:
        a = i;
        f = GLES20.glGetAttribLocation(a, "position");
        g = GLES20.glGetUniformLocation(a, "inputImageTexture");
        h = GLES20.glGetAttribLocation(a, "inputTextureCoordinate");
        b = true;
        return;
_L2:
        int l = m.a(s1, 35632);
        i = ((flag) ? 1 : 0);
        if (l != 0)
        {
            int j = GLES20.glCreateProgram();
            GLES20.glAttachShader(j, k);
            GLES20.glAttachShader(j, l);
            GLES20.glLinkProgram(j);
            GLES20.glGetProgramiv(j, 35714, ai, 0);
            i = ((flag) ? 1 : 0);
            if (ai[0] > 0)
            {
                GLES20.glDeleteShader(k);
                GLES20.glDeleteShader(l);
                i = j;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void a(int i, float f1)
    {
        a(new Runnable(i, f1) {

            private int a;
            private float b;

            public final void run()
            {
                GLES20.glUniform1f(a, b);
            }

            
            {
                a = i;
                b = f1;
                super();
            }
        });
    }

    public void a(int i, int j)
    {
    }

    public void a(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glUseProgram(a);
        f();
        if (!b)
        {
            return;
        }
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(f, 2, 5126, false, 0, floatbuffer);
        GLES20.glEnableVertexAttribArray(f);
        floatbuffer1.position(0);
        GLES20.glVertexAttribPointer(h, 2, 5126, false, 0, floatbuffer1);
        GLES20.glEnableVertexAttribArray(h);
        if (i != -1)
        {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(g, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(f);
        GLES20.glDisableVertexAttribArray(h);
        GLES20.glBindTexture(3553, 0);
    }

    protected final void a(int i, float af[])
    {
        a(new Runnable(i, af) {

            private int a;
            private float b[];

            public final void run()
            {
                GLES20.glUniform2fv(a, 1, FloatBuffer.wrap(b));
            }

            
            {
                a = i;
                b = af;
                super();
            }
        });
    }

    public void b()
    {
    }

    public final void c()
    {
        a();
        b = true;
        b();
    }

    public final void d()
    {
        b = false;
        GLES20.glDeleteProgram(a);
        e();
    }

    public void e()
    {
    }

    protected final void f()
    {
        LinkedList linkedlist = c;
        linkedlist;
        JVM INSTR monitorenter ;
        for (; !c.isEmpty(); ((Runnable)c.removeFirst()).run()) { }
        break MISSING_BLOCK_LABEL_40;
        Exception exception;
        exception;
        linkedlist;
        JVM INSTR monitorexit ;
        throw exception;
        linkedlist;
        JVM INSTR monitorexit ;
    }
}
