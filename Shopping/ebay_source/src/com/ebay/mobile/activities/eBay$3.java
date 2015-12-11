// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.ebay.mobile.activities:
//            eBay

class val.ii
    implements android.view.ClickListener
{

    final eBay this$0;
    final int val$ii;

    public void onClick(View view)
    {
        viewPager.setCurrentItem(val$ii, false);
        eBay.access$200(eBay.this);
    }

    ()
    {
        this$0 = final_ebay;
        val$ii = I.this;
        super();
    }
}
