// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.support.v4.view.ViewPager;
import android.widget.SeekBar;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            ConsolidatedAdjustToolsPanel

class this._cls0 extends android.support.v4.view.tener
{

    final ConsolidatedAdjustToolsPanel this$0;

    public void onPageSelected(int i)
    {
        mLogger.ogger("onPageSelected: %d", new Object[] {
            Integer.valueOf(i)
        });
        mCurrentSeekBar = (SeekBar)mViewPager.findViewWithTag(Integer.valueOf(i));
        ConsolidatedAdjustToolsPanel.access$000(ConsolidatedAdjustToolsPanel.this, i);
    }

    ()
    {
        this$0 = ConsolidatedAdjustToolsPanel.this;
        super();
    }
}
