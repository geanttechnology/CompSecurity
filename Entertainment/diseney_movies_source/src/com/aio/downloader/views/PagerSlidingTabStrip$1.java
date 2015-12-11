// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

// Referenced classes of package com.aio.downloader.views:
//            PagerSlidingTabStrip

class this._cls0
    implements android.view.alLayoutListener
{

    final PagerSlidingTabStrip this$0;

    private void removeGlobalLayoutListenerJB()
    {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    private void removeGlobalLayoutListenerPreJB()
    {
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    public void onGlobalLayout()
    {
        Object obj = PagerSlidingTabStrip.access$0(PagerSlidingTabStrip.this).getChildAt(0);
        if (android.os.ldAt < 16)
        {
            removeGlobalLayoutListenerPreJB();
        } else
        {
            removeGlobalLayoutListenerJB();
        }
        if (PagerSlidingTabStrip.access$1(PagerSlidingTabStrip.this))
        {
            int i = ((View) (obj)).getWidth() / 2;
            obj = PagerSlidingTabStrip.this;
            PagerSlidingTabStrip pagerslidingtabstrip = PagerSlidingTabStrip.this;
            i = getWidth() / 2 - i;
            PagerSlidingTabStrip.access$2(pagerslidingtabstrip, i);
            PagerSlidingTabStrip.access$3(((PagerSlidingTabStrip) (obj)), i);
        }
        setPadding(PagerSlidingTabStrip.access$4(PagerSlidingTabStrip.this), getPaddingTop(), PagerSlidingTabStrip.access$5(PagerSlidingTabStrip.this), getPaddingBottom());
        if (PagerSlidingTabStrip.access$6(PagerSlidingTabStrip.this) == 0)
        {
            PagerSlidingTabStrip.access$7(PagerSlidingTabStrip.this, getWidth() / 2 - PagerSlidingTabStrip.access$4(PagerSlidingTabStrip.this));
        }
        PagerSlidingTabStrip.access$9(PagerSlidingTabStrip.this, PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getCurrentItem());
        PagerSlidingTabStrip.access$10(PagerSlidingTabStrip.this, 0.0F);
        PagerSlidingTabStrip.access$12(PagerSlidingTabStrip.this, PagerSlidingTabStrip.access$11(PagerSlidingTabStrip.this), 0);
        PagerSlidingTabStrip.access$13(PagerSlidingTabStrip.this, PagerSlidingTabStrip.access$11(PagerSlidingTabStrip.this));
    }

    ener()
    {
        this$0 = PagerSlidingTabStrip.this;
        super();
    }
}
