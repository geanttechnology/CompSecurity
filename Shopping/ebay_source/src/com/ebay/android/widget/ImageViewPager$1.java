// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

// Referenced classes of package com.ebay.android.widget:
//            ImageViewPager

class this._cls0
    implements android.view.ner
{

    final ImageViewPager this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag = false;
        boolean flag1;
        if (motionevent.getHistorySize() > 0)
        {
            if (Math.abs(motionevent.getHistoricalX(0) - motionevent.getX()) > 5F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        flag1 = imagePager.onTouchEvent(motionevent);
        if (flag1 && flag)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return flag1;
    }

    ()
    {
        this$0 = ImageViewPager.this;
        super();
    }
}
