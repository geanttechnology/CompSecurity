// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            MarketRateThanks, IntentFactory

class this._cls0
    implements android.view.r
{

    final MarketRateThanks this$0;

    public void onClick(View view)
    {
        startActivity(MarketRateThanks.access$000(MarketRateThanks.this).newMyGrouponIntent(Channel.GETAWAYS));
        finish();
    }

    ()
    {
        this$0 = MarketRateThanks.this;
        super();
    }
}
