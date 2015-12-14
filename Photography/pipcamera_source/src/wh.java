// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;

public class wh extends vw
{

    protected vx c;
    protected wf d;
    private final int e = 612;
    private xj f;
    private xj g;
    private xj h;
    private xj i;
    private volatile boolean j;
    private Handler k;
    private float l;

    public wh(Context context)
    {
        super(context);
        c = new vx(this);
        l = 0.0F;
    }

    public Bitmap a(int i1, int j1, int k1, int l1)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)b).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        Bitmap bitmap = b(0, 0, k1, l1);
        Log.v("RenderingEngine", (new StringBuilder()).append("Density : ").append(displaymetrics.densityDpi).toString());
        return bitmap;
    }

    public vx a()
    {
        return c;
    }

    public void a(float f1)
    {
        if (f1 == 0.0F)
        {
            g = null;
        }
        if (f1 != l && f1 != 0.0F)
        {
            String s = (new StringBuilder()).append("gaussian_").append((int)Math.floor(f1)).toString();
            g = va.a(b, s);
            g.a(a().a, a().b);
            g.a(d);
        }
        l = f1;
    }

    public void a(int i1, int j1)
    {
        c.a = i1;
        c.b = j1;
        d = new wf();
        d.a(i1, j1);
        xo.a().b();
        f = ImageFilterFactory.a(b, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE, null);
        f.a(i1, j1);
        f.a(d);
        if (l != 0.0F)
        {
            String s = (new StringBuilder()).append("gaussian_").append((int)Math.floor(l)).toString();
            g = va.a(b, s);
            g.a(a().a, a().b);
            g.a(d);
        }
        GLES20.glBlendFunc(770, 771);
    }

    public void a(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            i = null;
            return;
        } else
        {
            Log.v("PipFreeStyleRender", (new StringBuilder()).append("Width:").append(bitmap.getWidth()).append("Height:").append(bitmap.getHeight()).toString());
            HashMap hashmap = new HashMap();
            hashmap.put("maskTextureId", Integer.valueOf(vu.a(bitmap, true)));
            i = ImageFilterFactory.a(b, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.ALPHAMASK, hashmap);
            i.a(a().a, a().b);
            i.a(d);
            return;
        }
    }

    public void a(Handler handler)
    {
        k = handler;
        j = true;
    }

    public void a(xj xj1)
    {
        if (h != null)
        {
            h.a();
        }
        h = xj1;
        if (h != null)
        {
            h.a(c.a, c.b);
            h.a(d);
        }
    }

    public Bitmap b(int i1, int j1, int k1, int l1)
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

    public void b(int i1)
    {
        GLES20.glViewport(0, 0, c.a, c.b);
        GLES20.glClearColor(0.5F, 0.5F, 0.5F, 1.0F);
        GLES20.glClear(16384);
        if (f != null)
        {
            if (g != null)
            {
                g.b(i1);
            } else
            {
                f.b(i1);
            }
        }
        if (h != null && i != null)
        {
            i1 = h.c(i1);
            i1 = i.c(i1);
            GLES20.glEnable(3042);
            f.b(i1);
            GLES20.glDisable(3042);
        }
        if (j)
        {
            GLES20.glFlush();
            Object obj = a(0, 0, c.a, c.b);
            if (obj == null);
            obj = Message.obtain(k, 0, obj);
            k.sendMessage(((Message) (obj)));
            j = false;
        }
    }
}
