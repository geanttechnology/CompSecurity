// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ShareImageDialogFragment

class val.viewPager
    implements com.bitstrips.imoji.manager.ck
{

    final ShareImageDialogFragment this$0;
    final ViewPager val$viewPager;

    public void success()
    {
        val$viewPager.getAdapter().notifyDataSetChanged();
    }

    allback()
    {
        this$0 = final_shareimagedialogfragment;
        val$viewPager = ViewPager.this;
        super();
    }
}
