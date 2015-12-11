// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.Channel;
import com.groupon.util.ShareHelper;

// Referenced classes of package com.groupon.activity:
//            MarketRateThanks

class this._cls0
    implements android.view.r
{

    final MarketRateThanks this$0;

    public void onClick(View view)
    {
        (new ShareHelper(MarketRateThanks.this, hotelName, String.format("https://www.groupon.com/dispatch/%s/channel/%s", new Object[] {
            "US".toLowerCase(), Channel.GETAWAYS.toString()
        }))).shareDeal();
    }

    ()
    {
        this$0 = MarketRateThanks.this;
        super();
    }
}
