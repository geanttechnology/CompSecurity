// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.aw;

import android.opengl.GLES20;
import android.util.Log;
import com.photo.gpu.Rotation;
import com.photo.gpu.j;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package myobfuscated.aw:
//            d

public class e extends d
{

    List c;
    public ByteBuffer d;
    public ByteBuffer e;
    public ByteBuffer f;
    private List g;
    private int h[];
    private int i[];
    private final FloatBuffer j;
    private final FloatBuffer k;
    private final FloatBuffer l;

    public e()
    {
        this((byte)0);
    }

    private e(byte byte0)
    {
        c = null;
        float af[];
        if (c == null)
        {
            c = new ArrayList();
        } else
        {
            h();
        }
        af = com.photo.gpu.e.a;
        d = ImageOpCommon.allocNativeBuffer(32L);
        j = d.order(ByteOrder.nativeOrder()).asFloatBuffer();
        j.put(com.photo.gpu.e.a).position(0);
        af = j.a;
        e = ImageOpCommon.allocNativeBuffer(32L);
        k = e.order(ByteOrder.nativeOrder()).asFloatBuffer();
        k.put(j.a).position(0);
        af = com.photo.gpu.j.a(Rotation.NORMAL, false, true);
        f = ImageOpCommon.allocNativeBuffer(af.length * 4);
        l = f.order(ByteOrder.nativeOrder()).asFloatBuffer();
        l.put(af).position(0);
    }

    private void g()
    {
        if (i != null)
        {
            GLES20.glDeleteTextures(i.length, i, 0);
            i = null;
        }
        if (h != null)
        {
            GLES20.glDeleteFramebuffers(h.length, h, 0);
            h = null;
        }
    }

    private void h()
    {
        if (c != null)
        {
            Iterator iterator;
            if (g == null)
            {
                g = new ArrayList();
            } else
            {
                g.clear();
            }
            iterator = c.iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (d)iterator.next();
                if (obj instanceof e)
                {
                    ((e)obj).h();
                    obj = ((e)obj).g;
                    if (obj != null && !((List) (obj)).isEmpty())
                    {
                        g.addAll(((java.util.Collection) (obj)));
                    }
                } else
                {
                    g.add(obj);
                }
            }
        }
    }

    public final void a()
    {
        long l1 = System.currentTimeMillis();
        super.a();
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((d)iterator.next()).c()) { }
        long l2 = System.currentTimeMillis();
        Log.e("ex1", "*************************");
        Log.e("ex1", (new StringBuilder("shader compile time = ")).append(l2 - l1).toString());
        Log.e("ex1", "*************************");
    }

    public final void a(int i1, int j1)
    {
        super.a(i1, j1);
        if (h != null)
        {
            g();
        }
        int i2 = c.size();
        for (int k1 = 0; k1 < i2; k1++)
        {
            ((d)c.get(k1)).a(i1, j1);
        }

        if (g != null && g.size() > 0)
        {
            int j2 = g.size();
            h = new int[j2 - 1];
            i = new int[j2 - 1];
            for (int l1 = 0; l1 < j2 - 1; l1++)
            {
                GLES20.glGenFramebuffers(1, h, l1);
                GLES20.glGenTextures(1, i, l1);
                GLES20.glBindTexture(3553, i[l1]);
                GLES20.glTexImage2D(3553, 0, 6408, i1, j1, 0, 6408, 5121, null);
                GLES20.glTexParameterf(3553, 10240, 9729F);
                GLES20.glTexParameterf(3553, 10241, 9729F);
                GLES20.glTexParameterf(3553, 10242, 33071F);
                GLES20.glTexParameterf(3553, 10243, 33071F);
                GLES20.glBindFramebuffer(36160, h[l1]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, i[l1], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }

        }
    }

    public final void a(int i1, FloatBuffer floatbuffer, FloatBuffer floatbuffer1)
    {
        f();
        break MISSING_BLOCK_LABEL_4;
        if (super.b && h != null && i != null && g != null)
        {
            int k1 = g.size();
            int j1 = 0;
            while (j1 < k1) 
            {
                d d1 = (d)g.get(j1);
                boolean flag;
                if (j1 < k1 - 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    GLES20.glBindFramebuffer(36160, h[j1]);
                    GLES20.glClear(16640);
                    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                }
                if (j1 == 0)
                {
                    d1.a(i1, floatbuffer, floatbuffer1);
                } else
                if (j1 == k1 - 1)
                {
                    FloatBuffer floatbuffer3 = j;
                    FloatBuffer floatbuffer2;
                    if (k1 % 2 == 0)
                    {
                        floatbuffer2 = l;
                    } else
                    {
                        floatbuffer2 = k;
                    }
                    d1.a(i1, floatbuffer3, floatbuffer2);
                } else
                {
                    d1.a(i1, j, k);
                }
                if (flag)
                {
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glClear(16640);
                    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                    i1 = i[j1];
                }
                j1++;
            }
        }
        return;
    }

    public final void a(d d1)
    {
        c.add(d1);
        h();
    }

    public final void e()
    {
        g();
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((d)iterator.next()).d()) { }
        super.e();
    }
}
