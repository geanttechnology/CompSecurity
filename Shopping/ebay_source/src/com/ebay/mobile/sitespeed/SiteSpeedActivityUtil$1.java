// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sitespeed;

import com.ebay.nautilus.domain.data.SiteSpeedData;

// Referenced classes of package com.ebay.mobile.sitespeed:
//            SiteSpeedActivityUtil

class val.speedData
    implements Runnable
{

    final SiteSpeedActivityUtil this$0;
    final SiteSpeedData val$speedData;

    public void run()
    {
        SiteSpeedActivityUtil.access$000(SiteSpeedActivityUtil.this, val$speedData);
    }

    ()
    {
        this$0 = final_sitespeedactivityutil;
        val$speedData = SiteSpeedData.this;
        super();
    }
}
