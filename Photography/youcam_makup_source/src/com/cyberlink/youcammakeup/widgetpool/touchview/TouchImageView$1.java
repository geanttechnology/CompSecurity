// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.touchview;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.util.Timer;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.touchview:
//            TouchImageView, e, c

class a
    implements android.view.ner
{

    final TouchImageView a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        PointF pointf;
        if (TouchImageView.a(a) != null)
        {
            TouchImageView.a(a).onTouch(view, motionevent);
        }
        TouchImageView.a(a, true);
        view = e.a(motionevent);
        if (TouchImageView.b(a) != null)
        {
            ((ScaleGestureDetector)TouchImageView.b(a)).onTouchEvent(motionevent);
        }
        TouchImageView.c(a);
        pointf = new PointF(view.b(), view.c());
        view.a() & 0xff;
        JVM INSTR tableswitch 0 6: default 140
    //                   0 156
    //                   1 298
    //                   2 718
    //                   3 140
    //                   4 140
    //                   5 227
    //                   6 667;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        a.setImageMatrix(a.a);
        return false;
_L2:
        a.B = false;
        a.b.set(a.a);
        a.n.set(view.b(), view.c());
        a.p.set(a.n);
        a.c = 1;
        continue; /* Loop/switch isn't completed */
_L5:
        a.w = TouchImageView.a(a, view);
        if (a.w > 10F)
        {
            a.b.set(a.a);
            TouchImageView.a(a, a.o, view);
            a.c = 2;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        a.B = true;
        a.c = 0;
        int i = (int)Math.abs(view.b() - a.p.x);
        int j = (int)Math.abs(view.c() - a.p.y);
        if (i < 10 && j < 10)
        {
            long l = System.currentTimeMillis();
            if (l - a.z <= 600L)
            {
                if (TouchImageView.d(a) != null)
                {
                    TouchImageView.d(a).cancel();
                }
                if (a.t == 1.0F)
                {
                    float f = a.v / a.t;
                    a.a.postScale(f, f, a.p.x, a.p.y);
                    a.t = a.v;
                } else
                {
                    a.a.postScale(a.u / a.t, a.u / a.t, a.l / 2.0F, a.m / 2.0F);
                    a.t = a.u;
                }
                TouchImageView.e(a);
                TouchImageView.a(a, 0.0F, 0.0F);
                a.z = 0L;
            } else
            {
                a.z = l;
                TouchImageView.a(a, new Timer());
                TouchImageView.d(a).schedule(new c(a, null), 300L);
            }
            if (a.t == a.u)
            {
                TouchImageView.f(a);
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        a.c = 0;
        a.y = 0.0F;
        a.b.set(a.a);
        a.w = TouchImageView.a(a, view);
        continue; /* Loop/switch isn't completed */
_L4:
        float f2;
        a.B = false;
        if (a.c == 1)
        {
            float f1 = pointf.x - a.n.x;
            float f3 = pointf.y - a.n.y;
            long l1 = System.currentTimeMillis();
            a.y = ((float)TouchImageView.a(a, pointf, a.n) / (float)(l1 - a.A)) * 0.9F;
            a.A = l1;
            TouchImageView.a(a, f1, f3);
            a.x.set(f1, f3);
            a.n.set(pointf.x, pointf.y);
            continue; /* Loop/switch isn't completed */
        }
        if (TouchImageView.b(a) != null || a.c != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        float f4 = TouchImageView.a(a, view);
        if (motionevent.getPointerCount() < 2 || 10F > Math.abs(a.w - f4) || Math.abs(a.w - f4) > 50F)
        {
            continue; /* Loop/switch isn't completed */
        }
        f2 = f4 / a.w;
        a.w = f4;
        f4 = a.t;
        motionevent = a;
        motionevent.t = ((TouchImageView) (motionevent)).t * f2;
        if (a.t > a.v)
        {
            a.t = a.v;
            f2 = a.v / f4;
        } else
        if (a.t < a.u)
        {
            a.t = a.u;
            f2 = a.u / f4;
        }
        TouchImageView.e(a);
        if (a.h * a.t > a.l && a.i * a.t > a.m)
        {
            break; /* Loop/switch isn't completed */
        }
        a.a.postScale(f2, f2, a.l / 2.0F, a.m / 2.0F);
        if (f2 < 1.0F)
        {
            TouchImageView.c(a);
            if (f2 < 1.0F)
            {
                TouchImageView.f(a);
            }
        }
_L8:
        TouchImageView.g(a);
        if (true) goto _L1; else goto _L7
_L7:
        view = TouchImageView.b(a, view);
        a.a.postScale(f2, f2, ((PointF) (view)).x, ((PointF) (view)).y);
        TouchImageView.c(a);
        if (f2 < 1.0F)
        {
            if (a.r < -a.f)
            {
                a.a.postTranslate(-(a.r + a.f), 0.0F);
            } else
            if (a.r > 0.0F)
            {
                a.a.postTranslate(-a.r, 0.0F);
            }
            if (a.s < -a.g)
            {
                a.a.postTranslate(0.0F, -(a.s + a.g));
            } else
            if (a.s > 0.0F)
            {
                a.a.postTranslate(0.0F, -a.s);
            }
        }
          goto _L8
        if (true) goto _L1; else goto _L9
_L9:
    }

    (TouchImageView touchimageview)
    {
        a = touchimageview;
        super();
    }
}
