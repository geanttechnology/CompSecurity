// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.clgpuimage:
//            GPUImageMaskAlphaBlendFilter, u

public class v extends GPUImageMaskAlphaBlendFilter
{

    protected final FloatBuffer a;
    protected final FloatBuffer b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    private List m;
    private List n;
    private int o[];
    private int p[];
    private int q[];
    private int r[];

    private void b(int i, int j)
    {
        q = new int[1];
        r = new int[1];
        GLES20.glGenFramebuffers(1, q, 0);
        GLES20.glGenTextures(1, r, 0);
        GLES20.glBindTexture(3553, r[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729F);
        GLES20.glTexParameterf(3553, 10241, 9729F);
        GLES20.glTexParameterf(3553, 10242, 33071F);
        GLES20.glTexParameterf(3553, 10243, 33071F);
        GLES20.glBindFramebuffer(36160, q[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r[0], 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void e(int i, int j)
    {
        int i1 = m.size();
        for (int k = 0; k < i1; k++)
        {
            ((u)m.get(k)).a(i, j);
        }

        if (n != null)
        {
            int l;
            int j1;
            if (d)
            {
                l = Math.min(n.size() - 1, 2);
            } else
            {
                l = n.size() - 1;
            }
            o = new int[l];
            p = new int[l];
            j1 = 0;
            while (j1 < l) 
            {
                GLES20.glGenFramebuffers(1, o, j1);
                GLES20.glGenTextures(1, p, j1);
                GLES20.glBindTexture(3553, p[j1]);
                GLES20.glTexImage2D(3553, 0, 6408, i, j, 0, 6408, 5121, null);
                float f;
                if (e)
                {
                    f = 9728F;
                } else
                {
                    f = 9729F;
                }
                GLES20.glTexParameterf(3553, 10240, f);
                if (e)
                {
                    f = 9728F;
                } else
                {
                    f = 9729F;
                }
                GLES20.glTexParameterf(3553, 10241, f);
                GLES20.glTexParameterf(3553, 10242, 33071F);
                GLES20.glTexParameterf(3553, 10243, 33071F);
                GLES20.glBindFramebuffer(36160, o[j1]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, p[j1], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                j1++;
            }
        }
    }

    private void m()
    {
        if (r != null)
        {
            GLES20.glDeleteTextures(r.length, r, 0);
            r = null;
        }
        if (q != null)
        {
            GLES20.glDeleteFramebuffers(q.length, q, 0);
            q = null;
        }
    }

    private void n()
    {
        if (p != null)
        {
            GLES20.glDeleteTextures(p.length, p, 0);
            p = null;
        }
        if (o != null)
        {
            GLES20.glDeleteFramebuffers(o.length, o, 0);
            o = null;
        }
    }

    public void a()
    {
        c = false;
        super.a();
        for (Iterator iterator = m.iterator(); iterator.hasNext(); ((u)iterator.next()).g()) { }
    }

    public void a(int i, int j)
    {
        super.a(i, j);
        c = false;
        if (o != null)
        {
            n();
        }
        if (q != null)
        {
            m();
        }
        b(i, j);
        e(i, j);
    }

    public void a(Bitmap bitmap)
    {
        throw new RuntimeException("GPUImageFilterGroupEx doesn't support setBitmap().");
    }

    public void b(int i, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        d_();
        if (!i() || o == null || p == null || q == null || r == null)
        {
            return;
        }
        if (this.l == -1)
        {
            this.l = i;
        }
        if (n != null && !c)
        {
            int l = n.size();
            boolean flag = false;
            int j = i;
            i = ((flag) ? 1 : 0);
            while (i < l) 
            {
                u u1 = (u)n.get(i);
                boolean flag1;
                if (i < l - 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    int ai1[] = o;
                    int ai[];
                    int k;
                    if (d)
                    {
                        k = i % 2;
                    } else
                    {
                        k = i;
                    }
                    GLES20.glBindFramebuffer(36160, ai1[k]);
                } else
                {
                    GLES20.glBindFramebuffer(36160, q[0]);
                }
                GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                GLES20.glClear(16384);
                u1.b(j, a, b);
                if (flag1)
                {
                    GLES20.glBindFramebuffer(36160, 0);
                    ai = p;
                    if (d)
                    {
                        j = i % 2;
                    } else
                    {
                        j = i;
                    }
                    j = ai[j];
                } else
                {
                    GLES20.glBindFramebuffer(36160, 0);
                }
                i++;
            }
            c = true;
        }
        super.b(r[0], floatbuffer, floatbuffer1);
        this.l = -1;
    }

    public void c()
    {
        c = false;
        n();
        m();
        for (Iterator iterator = m.iterator(); iterator.hasNext(); ((u)iterator.next()).h()) { }
        super.c();
    }
}
