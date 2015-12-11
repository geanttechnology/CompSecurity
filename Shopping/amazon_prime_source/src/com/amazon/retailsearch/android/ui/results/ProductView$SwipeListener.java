// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.amazon.retailsearch.android.ui.results.views.image.ImageWrapper;
import com.amazon.retailsearch.android.ui.results.views.image.ThumbSwitcher;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductView, SwipeDetector

private class <init>
    implements <init>
{

    final ProductView this$0;

    private boolean eventInView(MotionEvent motionevent, View view, int i)
    {
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        float f = (float)view.getWidth() / 2.0F;
        float f1 = (float)view.getHeight() / 2.0F;
        float f2 = (float)i * getResources().getDisplayMetrics().density;
        float f3 = Math.abs(((float)ai[0] + f) - motionevent.getRawX());
        float f4 = Math.abs(((float)ai[1] + f1) - motionevent.getRawY());
        return f3 <= Math.max(f2, f) && f4 <= Math.max(f2, f1);
    }

    public boolean onDown(MotionEvent motionevent)
    {
        boolean flag1 = false;
        if (!swipeDetector.isSwiping())
        {
            swiped = false;
        }
        boolean flag = flag1;
        if (imageWrapper.getChildCount() > 0)
        {
            flag = flag1;
            if (eventInView(motionevent, imageWrapper, 0))
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean onMove(float f, float f1, MotionEvent motionevent, float f2, float f3)
    {
        if (!swiped)
        {
            swiped = true;
            motionevent = imageWrapper.getThumbSwitcher();
            int j = motionevent.getPosition();
            int i;
            if (f2 < 0.0F)
            {
                i = 1;
            } else
            {
                i = -1;
            }
            motionevent.setPosition(motionevent.normalizePosition(i + j));
        }
        return true;
    }

    public boolean onSwipe(float f, float f1, MotionEvent motionevent, float f2, float f3)
    {
        return true;
    }

    private ()
    {
        this$0 = ProductView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
