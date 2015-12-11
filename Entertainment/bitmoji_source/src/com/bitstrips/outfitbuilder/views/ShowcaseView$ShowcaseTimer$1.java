// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.views;

import android.support.v4.view.ViewPager;

// Referenced classes of package com.bitstrips.outfitbuilder.views:
//            ShowcaseView

class this._cls1
    implements Runnable
{

    final ayAdapter.getCount this$1;

    public void run()
    {
        if (adapter.getCount() == 0)
        {
            return;
        } else
        {
            ViewPager viewpager = viewPager;
            ShowcaseView showcaseview = _fld0;
            int i = showcaseview.pageCounter;
            showcaseview.pageCounter = i + 1;
            viewpager.setCurrentItem(i % adapter.getCount());
            return;
        }
    }

    ayAdapter()
    {
        this$1 = this._cls1.this;
        super();
    }
}
