// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.wishabi.flipp.widget:
//            FlyerViewGroup, bt, bp, bi, 
//            bn, bj

final class br extends android.view.GestureDetector.SimpleOnGestureListener
{

    final FlyerViewGroup a;

    br(FlyerViewGroup flyerviewgroup)
    {
        a = flyerviewgroup;
        super();
    }

    public final boolean onDoubleTap(MotionEvent motionevent)
    {
        float f = FlyerViewGroup.a(a);
        int j = (int)Math.max(0.0F, (float)a.getWidth() - (float)FlyerViewGroup.c(a) * FlyerViewGroup.a(a)) / 2;
        int i = a.getScrollX();
        j = (int)((motionevent.getX() - (float)j) / f);
        int k = a.getScrollY();
        int l = (int)(motionevent.getY() / f);
        if (FlyerViewGroup.e(a) != null)
        {
            FlyerViewGroup.e(a).a(a, j + i, l + k);
        }
        return true;
    }

    public final boolean onDown(MotionEvent motionevent)
    {
        FlyerViewGroup.f(a).a();
        FlyerViewGroup.g(a).forceFinished(true);
        return true;
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        FlyerViewGroup.f(a).a();
        FlyerViewGroup.a(a, (int)(-f), (int)(-f1));
        return true;
    }

    public final void onLongPress(MotionEvent motionevent)
    {
        int i;
        int j;
        float f = FlyerViewGroup.a(a);
        i = (int)Math.max(0.0F, (float)a.getWidth() - (float)FlyerViewGroup.c(a) * FlyerViewGroup.a(a)) / 2;
        float f1 = a.getScrollX();
        i = (int)((motionevent.getX() - (float)i) / f + f1);
        f1 = a.getScrollY();
        j = (int)(motionevent.getY() / f + f1);
        motionevent = FlyerViewGroup.i(a).iterator();
_L4:
        if (!motionevent.hasNext()) goto _L2; else goto _L1
_L1:
        bi bi1 = (bi)motionevent.next();
        if (!bi1.a(i, j)) goto _L4; else goto _L3
_L3:
        if (FlyerViewGroup.e(a) != null)
        {
            FlyerViewGroup.e(a).a(a, bi1);
        }
_L6:
        return;
_L2:
        if (FlyerViewGroup.e(a) != null)
        {
            FlyerViewGroup.e(a).a(a, null);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        float f2 = FlyerViewGroup.a(a);
        int i = (int)((float)a.getScrollX() + f / f2);
        float f4 = a.getScrollY();
        int j = (int)(f1 / f2 + f4);
        if (i < 0)
        {
            motionevent = FlyerViewGroup.f(a);
            float f3 = f / (float)a.getWidth();
            ((bp) (motionevent)).a.onPull(f3);
            motionevent.e = true;
            motionevent.invalidate();
        }
        if ((float)i > (float)FlyerViewGroup.c(a) - (float)a.getWidth() / FlyerViewGroup.a(a))
        {
            motionevent = FlyerViewGroup.f(a);
            f /= a.getWidth();
            ((bp) (motionevent)).b.onPull(f);
            motionevent.f = true;
            motionevent.invalidate();
        }
        if (j < 0 && FlyerViewGroup.a(a) > FlyerViewGroup.j(a))
        {
            motionevent = FlyerViewGroup.f(a);
            f = f1 / (float)a.getHeight();
            ((bp) (motionevent)).c.onPull(f);
            motionevent.g = true;
            motionevent.invalidate();
        }
        if ((float)j > (float)FlyerViewGroup.d(a) - (float)a.getHeight() / FlyerViewGroup.a(a) && FlyerViewGroup.a(a) > FlyerViewGroup.j(a))
        {
            motionevent = FlyerViewGroup.f(a);
            f = f1 / (float)a.getHeight();
            ((bp) (motionevent)).d.onPull(f);
            motionevent.h = true;
            motionevent.invalidate();
        }
        a.scrollTo((int)Math.max(0.0F, Math.min(i, (float)FlyerViewGroup.c(a) - (float)a.getWidth() / FlyerViewGroup.a(a))), (int)Math.max(0.0F, Math.min(j, (float)FlyerViewGroup.d(a) - (float)a.getHeight() / FlyerViewGroup.a(a))));
        if (FlyerViewGroup.e(a) != null)
        {
            FlyerViewGroup.e(a).a(a);
        }
        FlyerViewGroup.k(a);
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        float f;
        float f1;
        int i;
        int j;
        f = FlyerViewGroup.a(a);
        i = (int)Math.max(0.0F, (float)a.getWidth() - (float)FlyerViewGroup.c(a) * FlyerViewGroup.a(a)) / 2;
        i = a.getScrollX() + (int)((motionevent.getX() - (float)i) / f);
        j = a.getScrollY() + (int)(motionevent.getY() / f);
        motionevent = FlyerViewGroup.h(a);
        f = i;
        f1 = j;
        motionevent = ((bn) (motionevent)).e.entrySet().iterator();
_L4:
        if (!motionevent.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (java.util.Map.Entry)motionevent.next();
        if (!((bj)((java.util.Map.Entry) (obj)).getValue()).h.contains(f, f1)) goto _L4; else goto _L3
_L3:
        long l = ((Long)((java.util.Map.Entry) (obj)).getKey()).longValue();
_L11:
        if (l < 0L) goto _L6; else goto _L5
_L5:
        if (FlyerViewGroup.e(a) != null)
        {
            FlyerViewGroup.e(a).a(a, l);
        }
_L8:
        return true;
_L2:
        l = -1L;
        continue; /* Loop/switch isn't completed */
_L6:
        motionevent = FlyerViewGroup.i(a).iterator();
        do
        {
            if (!motionevent.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (bi)motionevent.next();
        } while (!((bi) (obj)).a(i, j));
        if (FlyerViewGroup.e(a) == null) goto _L8; else goto _L7
_L7:
        FlyerViewGroup.e(a).b(a, ((bi) (obj)));
        return true;
        if (FlyerViewGroup.e(a) == null) goto _L8; else goto _L9
_L9:
        FlyerViewGroup.e(a).b(a, null);
        return true;
        if (true) goto _L11; else goto _L10
_L10:
    }
}
