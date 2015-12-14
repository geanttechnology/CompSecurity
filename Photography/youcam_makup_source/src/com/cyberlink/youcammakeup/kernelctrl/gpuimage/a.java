// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.gpuimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.cyberlink.clgpuimage.Rotation;
import com.cyberlink.clgpuimage.af;
import com.cyberlink.clgpuimage.u;
import com.cyberlink.clgpuimage.z;
import com.cyberlink.youcammakeup.camera.o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.gpuimage:
//            b

public class a extends u
{

    private u a;
    private b b;
    private FloatBuffer c;
    private FloatBuffer d;
    private Rotation e;
    private boolean f;
    private boolean g;
    private int h;
    private int i;
    private IntBuffer j;
    private boolean k;
    private boolean l;

    static b a(a a1)
    {
        return a1.b;
    }

    static boolean a(a a1, boolean flag)
    {
        a1.k = flag;
        return flag;
    }

    private void f()
    {
        GLES20.glGetIntegerv(2978, j);
        int i2 = j.get(2);
        int i1 = j.get(3);
        if (i2 != 0 && i1 != 0)
        {
            int k1 = o.a(i2, i1);
            i2 /= k1;
            int j2 = i1 / k1;
            if (i2 != h || j2 != i)
            {
                h = i2;
                i = j2;
                float f1;
                float f2;
                int j1;
                int l1;
                if (e == Rotation.b || e == Rotation.d)
                {
                    l1 = b.c;
                    j1 = b.b;
                } else
                {
                    l1 = b.b;
                    j1 = b.c;
                }
                f1 = (float)i2 / (float)l1;
                f2 = (float)j2 / (float)j1;
                if (f1 < f2)
                {
                    f2 /= f1;
                    f1 = 1.0F;
                } else
                if (f1 > f2)
                {
                    f1 /= f2;
                    f2 = 1.0F;
                } else
                {
                    f1 = 1.0F;
                    f2 = 1.0F;
                }
                d.put(new float[] {
                    -1F * f2, 1.0F * f1, 1.0F * f2, 1.0F * f1, -1F * f2, -1F * f1, 1.0F * f2, f1 * -1F
                }).position(0);
                return;
            }
        }
    }

    private void m()
    {
        float af[] = com.cyberlink.clgpuimage.a.a.a(e, f, g);
        c.put(af).position(0);
    }

    public void a()
    {
        super.a();
        if (a != null)
        {
            a.g();
        }
        c = ByteBuffer.allocateDirect(com.cyberlink.clgpuimage.a.a.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        m();
        d = ByteBuffer.allocateDirect(z.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        d.put(z.a).position(0);
    }

    public void a(int i1, int j1)
    {
        super.a(i1, j1);
        if (a != null)
        {
            a.a(i1, j1);
        }
    }

    public void a(Bitmap bitmap, boolean flag)
    {
        a(new Runnable(bitmap, flag) {

            final Bitmap a;
            final boolean b;
            final a c;

            public void run()
            {
                if (a.a(c).a != -1)
                {
                    GLES20.glDeleteTextures(1, new int[] {
                        a.a(c).a
                    }, 0);
                }
                a.a(c).a = af.a(a, -1, b);
                a.a(c).b = a.getWidth();
                a.a(c).c = a.getHeight();
                a.a(c, true);
            }

            
            {
                c = a.this;
                a = bitmap;
                b = flag;
                super();
            }
        });
    }

    public void b(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        if (a != null)
        {
            a.b(i1, floatbuffer, floatbuffer1);
        }
        d_();
        if (!i() || b.a == -1)
        {
            return;
        } else
        {
            f();
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            super.b(b.a, d, c);
            GLES20.glDisable(3042);
            return;
        }
    }

    public void c()
    {
        if (a != null)
        {
            a.h();
        }
        h = -1;
        i = -1;
        if (b.a != -1 && l)
        {
            GLES20.glDeleteTextures(1, new int[] {
                b.a
            }, 0);
            b.a = -1;
            b.b = -1;
            b.c = -1;
            k = false;
        }
        l = true;
        super.c();
    }
}
