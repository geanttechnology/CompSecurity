// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.support.v7.widget.Toolbar;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.activity:
//            Carousel

class this._cls0
    implements android.view.erver.OnGlobalLayoutListener
{

    final Carousel this$0;

    public void onGlobalLayout()
    {
        tabs.setY(getToolbar().getY() + (float)getToolbar().getHeight());
        getWindow().setBackgroundDrawable(getResources().getDrawable(0x7f0e00e2));
        pager.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    r()
    {
        this$0 = Carousel.this;
        super();
    }
}
