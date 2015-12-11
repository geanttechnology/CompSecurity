// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.orders;

import android.app.Activity;
import com.amazon.now.map.MapWebActivity;

// Referenced classes of package com.amazon.now.orders:
//            OrderStatusActivity

class val.url
    implements com.amazon.now.account.al.url
{

    final OrderStatusActivity this$0;
    final String val$url;

    public void failure()
    {
        finish();
    }

    public void success(Activity activity)
    {
        MapWebActivity.startActivity(OrderStatusActivity.this, val$url, false, true);
        finish();
    }

    ()
    {
        this$0 = final_orderstatusactivity;
        val$url = String.this;
        super();
    }
}
