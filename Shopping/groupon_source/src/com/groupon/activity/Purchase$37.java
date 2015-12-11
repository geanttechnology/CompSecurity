// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.service.GoogleWalletService;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            Purchase

class this._cls0
    implements android.view.Listener
{

    final Purchase this$0;

    public void onClick(View view)
    {
        Purchase.access$3600(Purchase.this, true);
        googleWalletService.triggerChangeMaskedWalletRequest(Purchase.this);
        Purchase.access$500(Purchase.this).logGoogleWalletCardClick(channel, com/groupon/activity/Purchase.getSimpleName());
    }

    ervice()
    {
        this$0 = Purchase.this;
        super();
    }
}
