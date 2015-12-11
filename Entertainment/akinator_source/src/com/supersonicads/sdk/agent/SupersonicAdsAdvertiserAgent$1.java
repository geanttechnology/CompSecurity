// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.agent;

import android.content.Context;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.supersonicads.sdk.agent:
//            SupersonicAdsAdvertiserAgent

class val.context
    implements Runnable
{

    final SupersonicAdsAdvertiserAgent this$0;
    final Context val$context;

    public void run()
    {
        Object obj = SupersonicAdsAdvertiserAgent.access$000(SupersonicAdsAdvertiserAgent.this, val$context);
        obj = (new StringBuilder()).append("/campaigns/onLoad?").append(((String) (obj))).toString();
        try
        {
            obj = new URL(SupersonicAdsAdvertiserAgent.access$100(), SupersonicAdsAdvertiserAgent.access$200(), SupersonicAdsAdvertiserAgent.access$300(), ((String) (obj)));
            if (performRequest(((URL) (obj)), val$context).getResponseCode() == 200)
            {
                SupersonicSharedPrefHelper.getSupersonicPrefHelper(val$context).setReportAppStarted(true);
            }
            return;
        }
        catch (MalformedURLException malformedurlexception)
        {
            return;
        }
    }

    sult()
    {
        this$0 = final_supersonicadsadvertiseragent;
        val$context = Context.this;
        super();
    }
}
