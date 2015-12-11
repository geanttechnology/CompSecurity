// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.os.Bundle;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapAccountInformationProvider

class CallbackItem extends CallbackItem
{

    final CallbackItem.onFinished this$1;
    final AmazonMapAccountInformationProvider val$this$0;

    protected void onFinished(Bundle bundle, boolean flag)
    {
        r = bundle.getString("value_key", null);
        super.onFinished(bundle, flag);
    }

    CallbackItem()
    {
        this$1 = final_callbackitem;
        val$this$0 = AmazonMapAccountInformationProvider.this;
        super(final_callbackitem);
    }
}
