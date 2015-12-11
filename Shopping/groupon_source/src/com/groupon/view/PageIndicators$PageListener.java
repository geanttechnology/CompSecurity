// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.groupon.view:
//            PageIndicators

private static class pageIndicators
    implements android.support.v4.view.er
{

    private PageIndicators pageIndicators;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
        PageIndicators.access$100(pageIndicators, i, (int)((float)PageIndicators.access$000(pageIndicators).getChildAt(i).getWidth() * f));
        pageIndicators.invalidate();
    }

    public void onPageSelected(int i)
    {
        pageIndicators.setActiveIndicator(i);
    }

    public eListener(PageIndicators pageindicators)
    {
        pageIndicators = pageindicators;
    }
}
