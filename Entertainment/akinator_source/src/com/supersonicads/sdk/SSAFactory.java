// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk;

import android.app.Activity;
import com.supersonicads.sdk.agent.SupersonicAdsAdvertiserAgent;
import com.supersonicads.sdk.agent.SupersonicAdsPublisherAgent;

// Referenced classes of package com.supersonicads.sdk:
//            SSAAdvertiser, SSAAdvertiserTest, SSAPublisher

public class SSAFactory
{

    public SSAFactory()
    {
    }

    public static SSAAdvertiser getAdvertiserInstance()
    {
        return SupersonicAdsAdvertiserAgent.getInstance();
    }

    public static SSAAdvertiserTest getAdvertiserTestInstance()
    {
        return SupersonicAdsAdvertiserAgent.getInstance();
    }

    public static SSAPublisher getPublisherInstance(Activity activity)
    {
        return SupersonicAdsPublisherAgent.getInstance(activity);
    }

    public static SSAPublisher getPublisherTestInstance(Activity activity)
    {
        return SupersonicAdsPublisherAgent.getInstance(activity, com.supersonicads.sdk.data.SSAEnums.DebugMode.MODE_2.getValue());
    }

    public static SSAPublisher getPublisherTestInstance(Activity activity, int i)
    {
        return SupersonicAdsPublisherAgent.getInstance(activity, i);
    }
}
