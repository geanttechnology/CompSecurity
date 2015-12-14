// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.av;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.socialin.android.util.Utils;

// Referenced classes of package myobfuscated.av:
//            d

public final class c
{

    public int a;
    public int b;
    public float c;
    public d d;
    public long e;
    public long f;
    public Handler g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public PointF l;
    public PointF m;
    public boolean n;
    public PointF o;

    public c(Context context, d d1)
    {
        c = 10F;
        g = new Handler(Looper.getMainLooper());
        l = new PointF();
        m = new PointF();
        o = new PointF();
        d = d1;
        e = 300L;
        f = 20L;
        c = Utils.a(10F, context);
    }

    public static PointF a(MotionEvent motionevent, int i1)
    {
        i1 = motionevent.findPointerIndex(i1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        motionevent = new PointF(motionevent.getX(i1), motionevent.getY(i1));
        return motionevent;
        motionevent;
        return null;
    }

    public static boolean a(MotionEvent motionevent, int i1, PointF pointf)
    {
        i1 = motionevent.findPointerIndex(i1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        pointf.set(motionevent.getX(i1), motionevent.getY(i1));
        return true;
        motionevent;
        return false;
    }

    public final void a(MotionEvent motionevent, int i1, int j1)
    {
        int k1;
        int l1;
        byte byte0;
        k1 = 0;
        if (motionevent.getPointerCount() < 2)
        {
            a = motionevent.getPointerId(0);
            return;
        }
        byte0 = -1;
        l1 = -1;
_L2:
        int i2;
        int j2;
        if (k1 >= i1)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        i2 = byte0;
        j2 = l1;
        if (k1 != j1)
        {
            if (l1 != -1)
            {
                break; /* Loop/switch isn't completed */
            }
            j2 = k1;
            i2 = byte0;
        }
_L3:
        k1++;
        byte0 = i2;
        l1 = j2;
        if (true) goto _L2; else goto _L1
_L1:
        if (byte0 != -1)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        i2 = k1;
        j2 = l1;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        a = motionevent.getPointerId(l1);
        b = motionevent.getPointerId(byte0);
        return;
    }

    // Unreferenced inner class myobfuscated/av/c$1

/* anonymous class */
    public final class _cls1
        implements Runnable
    {

        private float a;
        private float b;
        private c c;

        public final void run()
        {
            if (c.i)
            {
                new PointF(a, b);
            }
        }

            public 
            {
                c = c.this;
                a = f1;
                b = f2;
                super();
            }
    }

}
