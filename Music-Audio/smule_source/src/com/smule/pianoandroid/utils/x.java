// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.view.MotionEvent;
import com.smule.android.c.aa;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.utils:
//            SwipeView

class x extends android.view.GestureDetector.SimpleOnGestureListener
{

    final SwipeView a;

    x(SwipeView swipeview)
    {
        a = swipeview;
        super();
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        int i;
        if (motionevent.getX() - motionevent1.getX() <= 5F || Math.abs(f) <= 100F)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        motionevent = a;
        if (SwipeView.e(a) >= SwipeView.b(a).size() - 1)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        i = SwipeView.e(a) + 1;
_L1:
        SwipeView.b(motionevent, i);
        SwipeView.a(a, SwipeView.e(a) * SwipeView.a(a), 0);
        return true;
        i = SwipeView.b(a).size() - 1;
          goto _L1
        if (motionevent1.getX() - motionevent.getX() <= 5F || Math.abs(f) <= 100F) goto _L3; else goto _L2
_L2:
        motionevent = a;
        if (SwipeView.e(a) <= 0)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        i = SwipeView.e(a) - 1;
_L4:
        SwipeView.b(motionevent, i);
        SwipeView.a(a, SwipeView.e(a) * SwipeView.a(a), 0);
        return true;
        motionevent;
        aa.b(SwipeView.a(), (new StringBuilder()).append("There was an error processing the Fling event:").append(motionevent.getMessage()).toString(), motionevent);
_L3:
        return false;
        i = 0;
          goto _L4
    }
}
