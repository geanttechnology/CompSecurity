// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.common.rtm.RtmHelper;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity

class val.result
    implements Runnable
{

    final val.result this$1;
    final RtmHelper val$result;

    public void run()
    {
        ItemViewActivity.access$1500(_fld0, val$result.getAds());
    }

    ()
    {
        this$1 = final_;
        val$result = RtmHelper.this;
        super();
    }
}
