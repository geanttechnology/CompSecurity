// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.gpuimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import com.cyberlink.clgpuimage.GPUImageMaskAlphaBlendFilter;
import com.cyberlink.clgpuimage.af;
import com.cyberlink.clgpuimage.u;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.gpuimage:
//            b, a

public class GPUImagePanZoomFilter extends u
{

    private int A;
    protected int a;
    private a b;
    private List c;
    private GPUImageMaskAlphaBlendFilter d;
    private boolean e;
    private boolean f;
    private int g[];
    private int h[];
    private int i[];
    private int j[];
    private b k;
    private FloatBuffer l;
    private FloatBuffer m;
    private FloatBuffer n;
    private FloatBuffer o;
    private Matrix p;
    private float q[];
    private Bitmap r;
    private boolean s;
    private Alignment t;
    private float u;
    private float v;
    private float w;
    private float x;
    private FloatBuffer y;
    private FloatBuffer z;

    private void a(int i1)
    {
        if (c != null && !e)
        {
            int l1 = c.size();
            int k1 = 0;
            int j1 = i1;
            while (k1 < l1) 
            {
                u u1 = (u)c.get(k1);
                boolean flag;
                if (k1 < l1 - 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    GLES20.glBindFramebuffer(36160, g[k1]);
                } else
                {
                    GLES20.glBindFramebuffer(36160, i[0]);
                }
                GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                GLES20.glClear(16384);
                u1.b(j1, n, l);
                GLES20.glBindFramebuffer(36160, 0);
                if (flag)
                {
                    j1 = h[k1];
                }
                k1++;
            }
            e = true;
            f = false;
        }
        if (d != null && !f)
        {
            GLES20.glBindFramebuffer(36160, i[1]);
            d.l = i1;
            d.b(j[0], n, l);
            d.l = -1;
            GLES20.glBindFramebuffer(36160, 0);
            f = true;
        }
    }

    private void b(int i1)
    {
        if (A == 0)
        {
            A = af.a("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nvoid main()\n{\n\tif ( textureCoordinate.x > 1.0 || textureCoordinate.x < 0.0 || textureCoordinate.y > 1.0 || textureCoordinate.y < 0.0 )\n\t\tdiscard;\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        }
        GLES20.glUseProgram(A);
        int j1 = GLES20.glGetAttribLocation(A, "position");
        int k1 = GLES20.glGetAttribLocation(A, "inputTextureCoordinate");
        int l1 = GLES20.glGetUniformLocation(A, "inputImageTexture");
        y.position(0);
        GLES20.glVertexAttribPointer(j1, 2, 5126, false, 0, y);
        GLES20.glEnableVertexAttribArray(j1);
        z.position(0);
        GLES20.glVertexAttribPointer(k1, 2, 5126, false, 0, z);
        GLES20.glEnableVertexAttribArray(k1);
        GLES20.glViewport(0, 0, az, aA);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i1);
        GLES20.glUniform1i(l1, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(j1);
        GLES20.glDisableVertexAttribArray(k1);
        GLES20.glBindTexture(3553, 0);
    }

    private void b(int i1, int j1)
    {
        float f1 = (float)k.b / (float)i1;
        float f2 = (float)k.c / (float)j1;
        o.put(new float[] {
            -1F * f1, 1.0F * f2, 1.0F * f1, 1.0F * f2, -1F * f1, -1F * f2, f1 * 1.0F, f2 * -1F
        }).position(0);
    }

    private void e(int i1, int j1)
    {
        float f1;
        float f2;
        float f3;
        float f4;
        if (t == Alignment.a)
        {
            f1 = -1F + (u / (float)i1) * 2.0F;
        } else
        {
            f1 = 1.0F - ((u + w) / (float)i1) * 2.0F;
        }
        f2 = 1.0F - (v / (float)j1) * 2.0F;
        f3 = (w / (float)i1) * 2.0F + f1;
        f4 = f2 - (x / (float)j1) * 2.0F;
        y.put(new float[] {
            f1, f2, f3, f2, f1, f4, f3, f4
        }).position(0);
    }

    private void f()
    {
        float af1[] = new float[9];
        p.getValues(af1);
        float f1 = (float)Math.sqrt(af1[0] * af1[0] + af1[1] * af1[1]);
        q[0] = f1;
        q[5] = f1;
        float f2 = k.b;
        float f3 = k.c;
        float f4 = af1[2];
        float f5 = af1[5];
        float f6 = 2.0F / (float)az;
        float f7 = 2.0F / (float)aA;
        q[12] = f6 * ((f2 * f1) / 2.0F + f4 * f1);
        q[13] = -(f5 * f1 + (f3 * f1) / 2.0F) * f7;
        b(a, q);
    }

    private void f(int i1, int j1)
    {
        int k1;
        if (d == null)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        i = new int[k1];
        j = new int[k1];
        GLES20.glGenFramebuffers(k1, i, 0);
        GLES20.glGenTextures(k1, j, 0);
        for (int l1 = 0; l1 < k1; l1++)
        {
            GLES20.glBindTexture(3553, j[l1]);
            GLES20.glTexImage2D(3553, 0, 6408, i1, j1, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729F);
            GLES20.glTexParameterf(3553, 10241, 9729F);
            GLES20.glTexParameterf(3553, 10242, 33071F);
            GLES20.glTexParameterf(3553, 10243, 33071F);
            GLES20.glBindFramebuffer(36160, i[l1]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, j[l1], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }

    }

    private void g(int i1, int j1)
    {
        c.size();
        if (c != null && c.size() > 0)
        {
            int l1 = c.size();
            g = new int[l1 - 1];
            h = new int[l1 - 1];
            for (int k1 = 0; k1 < l1 - 1; k1++)
            {
                GLES20.glGenFramebuffers(1, g, k1);
                GLES20.glGenTextures(1, h, k1);
                GLES20.glBindTexture(3553, h[k1]);
                GLES20.glTexImage2D(3553, 0, 6408, i1, j1, 0, 6408, 5121, null);
                GLES20.glTexParameterf(3553, 10240, 9729F);
                GLES20.glTexParameterf(3553, 10241, 9729F);
                GLES20.glTexParameterf(3553, 10242, 33071F);
                GLES20.glTexParameterf(3553, 10243, 33071F);
                GLES20.glBindFramebuffer(36160, g[k1]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, h[k1], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }

        }
    }

    private void m()
    {
        if (j != null)
        {
            GLES20.glDeleteTextures(j.length, j, 0);
            j = null;
        }
        if (i != null)
        {
            GLES20.glDeleteFramebuffers(i.length, i, 0);
            i = null;
        }
    }

    private void n()
    {
        if (h != null)
        {
            GLES20.glDeleteTextures(h.length, h, 0);
            h = null;
        }
        if (g != null)
        {
            GLES20.glDeleteFramebuffers(g.length, g, 0);
            g = null;
        }
    }

    public void a()
    {
        super.a();
        e = false;
        f = false;
        b.g();
        if (r != null)
        {
            b.a(r, false);
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((u)iterator.next()).g()) { }
        if (d != null)
        {
            d.g();
        }
        a = GLES20.glGetUniformLocation(av, "transformMatrix");
        q = (new float[] {
            1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 
            1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F
        });
    }

    public void a(int i1, int j1)
    {
        super.a(i1, j1);
        e = false;
        f = false;
        if (g != null)
        {
            n();
        }
        if (i != null)
        {
            m();
        }
        b.a(i1, j1);
        int k1 = k.b;
        int l1 = k.c;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((u)iterator.next()).a(k1, l1)) { }
        if (d != null)
        {
            d.a(k1, l1);
        }
        f(k1, l1);
        g(k1, l1);
        b(i1, j1);
        e(i1, j1);
    }

    public void b(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        d_();
        if (i() && g != null && h != null && i != null && j != null)
        {
            GLES20.glViewport(0, 0, az, aA);
            b.b(i1, floatbuffer, floatbuffer1);
            GLES20.glViewport(0, 0, k.b, k.c);
            a(i1);
            GLES20.glViewport(0, 0, az, aA);
            f();
            if (d == null)
            {
                i1 = j[0];
            } else
            {
                i1 = j[1];
            }
            super.b(i1, o, m);
            if (s)
            {
                b(i1);
                return;
            }
        }
    }

    public void c()
    {
        e = false;
        f = false;
        n();
        m();
        b.h();
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((u)iterator.next()).h()) { }
        if (d != null)
        {
            d.h();
        }
        if (A != 0)
        {
            GLES20.glDeleteProgram(A);
            A = 0;
        }
        super.c();
    }

    private class Alignment extends Enum
    {

        public static final Alignment a;
        public static final Alignment b;
        private static final Alignment c[];

        public static Alignment valueOf(String s1)
        {
            return (Alignment)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/gpuimage/GPUImagePanZoomFilter$Alignment, s1);
        }

        public static Alignment[] values()
        {
            return (Alignment[])c.clone();
        }

        static 
        {
            a = new Alignment("LEFT", 0);
            b = new Alignment("RIGHT", 1);
            c = (new Alignment[] {
                a, b
            });
        }

        private Alignment(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
