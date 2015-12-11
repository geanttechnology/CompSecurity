// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.view.View;
import com.ebay.mobile.sell.widget.CustomScrollView;

// Referenced classes of package com.ebay.mobile.sell:
//            FormatPriceSpokeFragment

class this._cls0
    implements Runnable
{

    final FormatPriceSpokeFragment this$0;

    public void run()
    {
        parent.scrollTo(0, scheduleButtonsLayout.getBottom() + scheduleButtonsLayout.getHeight());
    }

    ()
    {
        this$0 = FormatPriceSpokeFragment.this;
        super();
    }
}
