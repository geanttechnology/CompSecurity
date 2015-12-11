// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mdot;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.bestbuy.android.utils.CustomSwipeToRefresh;
import kj;

// Referenced classes of package com.bestbuy.android.activities.mdot:
//            MdotWebFragment

class a
    implements kj
{

    final MdotWebFragment a;

    public void a(int i, int j)
    {
        if (j < 200 && MdotWebFragment.d(a))
        {
            MdotWebFragment.a(a, false);
            if (MdotWebFragment.e(a).contains(".bestbuy.com/cart"))
            {
                return;
            }
            if (MdotWebFragment.a(a).getVisibility() == 8)
            {
                MdotWebFragment.a(a).setVisibility(0);
            }
            MdotWebFragment.f(a).setPullDownEvent(true);
            MotionEvent motionevent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100L, 0, 0.0F, 0.0F, 0);
            MdotWebFragment.f(a).dispatchTouchEvent(motionevent);
            return;
        } else
        {
            MdotWebFragment.a(a).setVisibility(8);
            return;
        }
    }

    (MdotWebFragment mdotwebfragment)
    {
        a = mdotwebfragment;
        super();
    }
}
