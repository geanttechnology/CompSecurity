// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.piprender.renderengine.filters.BlendMode;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;

public class we extends vw
{

    protected vx c;
    protected wf d;
    private final int e = 612;
    private xj f;
    private xj g;
    private xj h;
    private float i;
    private volatile boolean j;
    private Handler k;
    private volatile boolean l;
    private int m;
    private int n;

    public we(Context context)
    {
        super(context);
        c = new vx(this);
        i = 1.0F;
        l = false;
    }

    public Bitmap a(int i1, int j1, int k1, int l1)
    {
        if (PIPCameraApplication.b)
        {
            return c(0, 0, k1, l1);
        } else
        {
            return b(0, 0, k1, l1);
        }
    }

    public void a()
    {
        d.a();
        xo.a().b();
        if (f != null)
        {
            f.a();
            h.a();
        }
        if (g != null)
        {
            g.a();
        }
    }

    public void a(Handler handler, int i1, int j1)
    {
        l = true;
        m = i1;
        n = j1;
        k = handler;
    }

    public Bitmap b(int i1, int j1, int k1, int l1)
    {
        int ai[] = new int[(j1 + l1) * k1];
        int ai1[] = new int[k1 * l1];
        IntBuffer intbuffer = IntBuffer.wrap(ai);
        intbuffer.position(0);
        GLES20.glReadPixels(i1, 0, k1, j1 + l1, 6408, 5121, intbuffer);
        i1 = 0;
        for (j1 = 0; j1 < l1;)
        {
            for (int i2 = 0; i2 < k1; i2++)
            {
                int j2 = ai[j1 * k1 + i2];
                ai1[(l1 - i1 - 1) * k1 + i2] = j2 & 0xff00ff00 | j2 << 16 & 0xff0000 | j2 >> 16 & 0xff;
            }

            j1++;
            i1++;
        }

        return Bitmap.createBitmap(ai1, k1, l1, android.graphics.Bitmap.Config.ARGB_8888);
    }

    public vx b()
    {
        return c;
    }

    public void b(float f1)
    {
        i = f1;
        if (h != null)
        {
            ((wz)h).a(i);
        }
    }

    public void b(int i1, int j1)
    {
        c.a = i1;
        c.b = j1;
        d = new wf();
        d.a(i1, j1);
        xo.a().b();
        HashMap hashmap = new HashMap();
        hashmap.put("blendMode", Integer.valueOf(BlendMode.NORMAL.ordinal()));
        hashmap.put("blendSrcLocation", Integer.valueOf(0));
        hashmap.put("opacity", Float.valueOf(i));
        h = (wz)ImageFilterFactory.a(b, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND, hashmap);
        h.a(c.a, c.b);
        h.a(d);
    }

    public void b(xj xj1)
    {
        f = xj1;
        if (f != null)
        {
            f.a(c.a, c.b);
            f.a(d);
        }
    }

    public Bitmap c(int i1, int j1, int k1, int l1)
    {
        i1 = 0;
        j1 = k1 * l1;
        Object obj = ByteBuffer.allocateDirect(j1 * 4);
        ((ByteBuffer) (obj)).order(ByteOrder.nativeOrder());
        GLES20.glReadPixels(0, 0, k1, l1, 6408, 5121, ((java.nio.Buffer) (obj)));
        int ai[] = new int[j1];
        ((ByteBuffer) (obj)).asIntBuffer().get(ai);
        obj = Bitmap.createBitmap(k1, l1, android.graphics.Bitmap.Config.RGB_565);
        ((Bitmap) (obj)).setPixels(ai, j1 - k1, -k1, 0, 0, k1, l1);
        ai = new short[j1];
        ShortBuffer shortbuffer = ShortBuffer.wrap(ai);
        ((Bitmap) (obj)).copyPixelsToBuffer(shortbuffer);
        for (; i1 < j1; i1++)
        {
            k1 = ai[i1];
            ai[i1] = (short)((k1 & 0xf800) >> 11 | ((k1 & 0x1f) << 11 | k1 & 0x7e0));
        }

        shortbuffer.rewind();
        ((Bitmap) (obj)).copyPixelsFromBuffer(shortbuffer);
        return ((Bitmap) (obj));
    }

    public wf c()
    {
        return d;
    }

    public void c(int i1)
    {
        int k1 = 612;
        GLES20.glViewport(0, 0, c.a, c.b);
        Log.v("RenderingEngine", (new StringBuilder()).append("RenderingEngine  m_size.width:").append(c.a).append(" m_size.height").append(c.b).toString());
        GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
        GLES20.glClear(16384);
        if (g == null)
        {
            if (f != null)
            {
                Log.v("RenderingEngine", (new StringBuilder()).append("render the frame id:").append(i1).toString());
                Object obj;
                if (i == 1.0F)
                {
                    f.b(i1);
                } else
                {
                    j1 = f.c(i1);
                    h.d(i1);
                    h.b(j1);
                }
            }
        } else
        if (f != null)
        {
            j1 = f.c(i1);
            if (i == 1.0F)
            {
                g.b(j1);
            } else
            {
                j1 = g.c(j1);
                h.d(i1);
                h.b(j1);
            }
        }
        if (j || l)
        {
            int j1;
            if (j)
            {
                j1 = 612;
            } else
            {
                k1 = 0;
                j1 = 0;
            }
            if (l)
            {
                j1 = m;
                k1 = n;
            }
            d.a(j1, k1);
            GLES20.glViewport(0, 0, j1, k1);
            if (g == null)
            {
                if (f != null)
                {
                    f.a(j1, k1);
                    h.a(j1, k1);
                    if (i == 1.0F)
                    {
                        f.c(i1);
                    } else
                    {
                        int l1 = f.c(i1);
                        h.d(i1);
                        h.c(l1);
                    }
                }
            } else
            if (f != null)
            {
                f.a(j1, k1);
                g.a(j1, k1);
                int i2 = f.c(i1);
                if (i == 1.0F)
                {
                    g.c(i2);
                } else
                {
                    i2 = g.c(i2);
                    h.d(i1);
                    h.c(i2);
                }
            }
            GLES20.glFlush();
            obj = a(0, 0, j1, k1);
            if (obj == null);
            obj = Message.obtain(k, 0, obj);
            k.sendMessage(((Message) (obj)));
            if (f != null)
            {
                f.a(c.a, c.b);
                h.a(c.a, c.b);
            }
            if (g != null)
            {
                g.a(c.a, c.b);
            }
            d.a(c.a, c.b);
            GLES20.glViewport(0, 0, c.a, c.b);
            j = false;
            l = false;
        }
    }

    public void c(xj xj1)
    {
        if (g != null)
        {
            g.a();
        }
        g = xj1;
        if (g != null)
        {
            g.a(c.a, c.b);
            g.a(d);
        }
    }
}
