// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.smule.android.c.aa;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.utils:
//            SwipeView, y

class a
    implements android.view.Listener
{

    final SwipeView a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!SwipeView.b(a).isEmpty())
        {
            if (SwipeView.c(a) == 0 && motionevent.getAction() == 2 && SwipeView.d(a) != null)
            {
                SwipeView.d(a).b(a, Integer.valueOf(SwipeView.e(a)), SwipeView.f(a));
            }
            SwipeView.c(a, motionevent.getAction());
            if (SwipeView.g(a).onTouchEvent(motionevent))
            {
                aa.a(SwipeView.a(), "GestureDetector.onTouchEvent");
                return true;
            }
            if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
            {
                int i = a.getScrollX();
                SwipeView.b(a, (i + SwipeView.a(a) / 2) / SwipeView.a(a));
                i = SwipeView.e(a);
                int j = SwipeView.a(a);
                SwipeView.a(a, i * j, 0);
                return true;
            }
        }
        return false;
    }

    (SwipeView swipeview)
    {
        a = swipeview;
        super();
    }
}
