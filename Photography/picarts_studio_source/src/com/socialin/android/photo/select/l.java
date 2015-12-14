// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.socialin.android.util.Utils;
import myobfuscated.av.d;

public final class l
{

    int a;
    int b;
    float c;
    d d;
    long e;
    long f;
    Handler g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    PointF l;
    PointF m;
    boolean n;
    PointF o;

    public l(Context context, d d1)
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

    static PointF a(MotionEvent motionevent, int i1)
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

    static boolean a(MotionEvent motionevent, int i1, PointF pointf)
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

    final void a(MotionEvent motionevent, int i1, int j1)
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

    // Unreferenced inner class com/socialin/android/photo/select/l$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        private float a;
        private float b;
        private l c;

        public final void run()
        {
            if (c.i)
            {
                new PointF(a, b);
            }
        }

            
            {
                c = l.this;
                a = f1;
                b = f2;
                super();
            }
    }

}
