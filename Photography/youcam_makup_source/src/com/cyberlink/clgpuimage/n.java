// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;
import com.cyberlink.clgpuimage.a.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.clgpuimage:
//            u, z, o

public class n extends u
{

    private ArrayList a;
    private int b;
    private int c;
    private float d;
    private float e;
    private int f[];
    private int g[];
    private final FloatBuffer h;
    private final FloatBuffer i;
    private final FloatBuffer j;
    private int k;
    private int l;
    private int m;

    public n()
    {
        b = 90;
        c = 90;
        d = 0.0F;
        e = 1.0F;
        f = new int[1];
        g = new int[1];
        h = ByteBuffer.allocateDirect(com.cyberlink.clgpuimage.z.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        h.put(com.cyberlink.clgpuimage.z.a).position(0);
        i = ByteBuffer.allocateDirect(a.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        i.put(a.a).position(0);
        j = ByteBuffer.allocateDirect(a.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        j.put(a.a).position(0);
        a = new ArrayList();
    }

    private void m()
    {
        f = new int[2];
        g = new int[2];
        GLES20.glGenFramebuffers(2, f, 0);
        GLES20.glGenTextures(2, g, 0);
        GLES20.glBindTexture(3553, g[0]);
        GLES20.glTexImage2D(3553, 0, 6408, az, aA, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glBindFramebuffer(36160, f[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, g[0], 0);
        GLES20.glBindTexture(3553, g[1]);
        GLES20.glTexImage2D(3553, 0, 6408, aA, az, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glBindFramebuffer(36160, f[1]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, g[1], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void n()
    {
        if (g != null)
        {
            GLES20.glDeleteTextures(g.length, g, 0);
            g = null;
        }
        if (f != null)
        {
            GLES20.glDeleteFramebuffers(f.length, f, 0);
            f = null;
        }
    }

    public void a(float f1, float f2)
    {
        d = f1;
        e = f2;
    }

    public void a(int i1)
    {
        b = i1;
    }

    public void a(int i1, int j1)
    {
        super.a(i1, j1);
        n();
        m();
    }

    public void a(ArrayList arraylist)
    {
        a = new ArrayList(arraylist);
    }

    protected float[] a(float af[])
    {
        return (new float[] {
            af[4], af[5], af[6], af[7], af[0], af[1], af[2], af[3]
        });
    }

    protected float[] a(float af[], int i1)
    {
        if (i1 == (c + 90) % 360)
        {
            return (new float[] {
                af[4], af[5], af[0], af[1], af[6], af[7], af[2], af[3]
            });
        }
        if (i1 == (c + 180) % 360)
        {
            return (new float[] {
                af[6], af[7], af[4], af[5], af[2], af[3], af[0], af[1]
            });
        }
        if (i1 == (c + 270) % 360)
        {
            return (new float[] {
                af[2], af[3], af[6], af[7], af[0], af[1], af[4], af[5]
            });
        } else
        {
            return (new float[] {
                af[0], af[1], af[2], af[3], af[4], af[5], af[6], af[7]
            });
        }
    }

    public void b(int i1)
    {
        c = i1;
    }

    public void b(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        GLES20.glUseProgram(av);
        d_();
        if (!i())
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
        if (b == 90 || b == 270)
        {
            k = az;
            l = aA;
            m = f[0];
        } else
        {
            k = aA;
            l = az;
            m = f[1];
        }
        floatbuffer.position(0);
        GLES20.glVertexAttribPointer(aw, 2, 5126, false, 0, h);
        GLES20.glEnableVertexAttribArray(aw);
        j.clear();
        j.put(a(a(a.a, b)));
        j.position(0);
        GLES20.glVertexAttribPointer(ay, 2, 5126, false, 0, j);
        GLES20.glEnableVertexAttribArray(ay);
        floatbuffer = IntBuffer.allocate(1);
        GLES20.glGetIntegerv(36006, floatbuffer);
        floatbuffer1 = IntBuffer.allocate(4);
        GLES20.glGetIntegerv(2978, floatbuffer1);
        GLES20.glBindFramebuffer(36160, m);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GLES20.glViewport(0, 0, k, l);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(aw);
        GLES20.glDisableVertexAttribArray(ay);
        GLES20.glBindFramebuffer(36160, floatbuffer.get(0));
        GLES20.glViewport(floatbuffer1.get(0), floatbuffer1.get(1), floatbuffer1.get(2), floatbuffer1.get(3));
        GLES20.glBindTexture(3553, 0);
    }

    public void c()
    {
        super.c();
        n();
    }

    public void e()
    {
    }

    public o f()
    {
        int i1 = 0;
        o o1 = new o();
        o1.a = k;
        o1.b = l;
        o1.d = new ArrayList(a);
        o1.e = d;
        o1.f = e;
        o1.c = new int[k * l];
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(k * l * 4);
        bytebuffer.order(ByteOrder.nativeOrder());
        bytebuffer.position(0);
        GLES20.glBindFramebuffer(36160, m);
        GLES20.glReadPixels(0, 0, k, l, 6408, 5121, bytebuffer);
        bytebuffer.asIntBuffer().get(o1.c);
        for (; i1 < k * l; i1++)
        {
            o1.c[i1] = o1.c[i1] & 0xff00ff00 | (o1.c[i1] & 0xff) << 16 | (o1.c[i1] & 0xff0000) >> 16;
        }

        return o1;
    }
}
