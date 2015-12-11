// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.HashMap;

// Referenced classes of package com.apprupt.sdk:
//            CvValueExchange

class val.adSpaceId
    implements Runnable
{

    final CvValueExchange this$0;
    final String val$adSpaceId;

    public void run()
    {
        ppings ppings = (ppings)CvValueExchange.access$400(CvValueExchange.this).get(val$adSpaceId);
        if (ppings != null)
        {
            CvValueExchange.access$600()._mth600(new Object[] {
                "Grant rewardAmount ", ppings.access._mth500(ppings).currency, Integer.valueOf(ppings.access._mth500(ppings).reward), Integer.valueOf(ppings.access._mth200(ppings))
            });
            wardConfig wardconfig = ppings.access._mth500(ppings);
            if (wardconfig != null && CvValueExchange.access$700(CvValueExchange.this) != null)
            {
                CvValueExchange.access$700(CvValueExchange.this).onReward(new ward(CvValueExchange.this, Integer.valueOf(val$adSpaceId).intValue(), wardconfig.currency, wardconfig.reward, null));
                ppings.access._mth900(ppings);
            }
            return;
        } else
        {
            CvValueExchange.access$600()._mth600(new Object[] {
                "Grant rewardAmount - unknown space", val$adSpaceId
            });
            return;
        }
    }

    stener()
    {
        this$0 = final_cvvalueexchange;
        val$adSpaceId = String.this;
        super();
    }
}
