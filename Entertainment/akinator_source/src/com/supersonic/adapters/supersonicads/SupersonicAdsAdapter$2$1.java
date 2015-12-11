// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.adapters.supersonicads;

import android.app.Activity;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import com.supersonic.mediationsdk.sdk.RewardedVideoManagerListener;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import com.supersonicads.sdk.SSAFactory;
import com.supersonicads.sdk.SSAPublisher;
import com.supersonicads.sdk.data.AdUnitsReady;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;

// Referenced classes of package com.supersonic.adapters.supersonicads:
//            SupersonicAdsAdapter, SupersonicConfig

class this._cls1
    implements OnRewardedVideoListener
{

    final is._cls0 this$1;

    public void onRVAdClosed()
    {
        if (SupersonicAdsAdapter.access$600(_fld0) != null)
        {
            SupersonicAdsAdapter.access$600(_fld0).onRewardedVideoAdClosed(_fld0);
        }
    }

    public void onRVAdCredited(int i)
    {
        if (SupersonicAdsAdapter.access$600(_fld0) != null)
        {
            SupersonicAdsAdapter.access$600(_fld0).onRewardedVideoAdRewarded(i, _fld0);
        }
    }

    public void onRVGeneric(String s, String s1)
    {
    }

    public void onRVInitFail(String s)
    {
        SupersonicAdsAdapter.access$1200(_fld0, false);
        SupersonicAdsAdapter.access$1300(_fld0);
        if (SupersonicAdsAdapter.access$600(_fld0) != null)
        {
            s = ErrorBuilder.buildAdapterInitFailedError(s);
            SupersonicAdsAdapter.access$600(_fld0).onRewardedVideoInitFail(s, _fld0);
        }
    }

    public void onRVInitSuccess(AdUnitsReady adunitsready)
    {
        SupersonicAdsAdapter.access$700(_fld0);
        SupersonicAdsAdapter.access$800(_fld0, true);
        SupersonicAdsAdapter supersonicadsadapter = _fld0;
        int i;
        int j;
        boolean flag;
        if (SupersonicAdsAdapter.access$900(_fld0) < SupersonicAdsAdapter.access$1000(_fld0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        supersonicadsadapter.setAdAvailable(flag);
        if (SupersonicAdsAdapter.access$600(_fld0) == null) goto _L2; else goto _L1
_L1:
        SupersonicAdsAdapter.access$600(_fld0).onRewardedVideoInitSuccess(_fld0);
        i = 0;
        j = Integer.parseInt(adunitsready.getNumOfAdUnits());
        i = j;
_L4:
        if (i <= 0 || !SupersonicAdsAdapter.access$1100(_fld0))
        {
            break; /* Loop/switch isn't completed */
        }
        SupersonicAdsAdapter.access$600(_fld0).onVideoAvailabilityChanged(true, _fld0);
_L2:
        return;
        adunitsready;
        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.icTag.NATIVE, "onRVInitSuccess:parseInt()", adunitsready);
        if (true) goto _L4; else goto _L3
_L3:
        SupersonicAdsAdapter.access$600(_fld0).onVideoAvailabilityChanged(false, _fld0);
        return;
    }

    public void onRVNoMoreOffers()
    {
        SupersonicAdsAdapter.access$500(_fld0);
        setAdAvailable(false);
        if (SupersonicAdsAdapter.access$600(_fld0) != null)
        {
            SupersonicAdsAdapter.access$600(_fld0).onRewardedVideoInitSuccess(_fld0);
            SupersonicAdsAdapter.access$600(_fld0).onVideoAvailabilityChanged(false, _fld0);
        }
    }

    l.userId()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/supersonic/adapters/supersonicads/SupersonicAdsAdapter$2

/* anonymous class */
    class SupersonicAdsAdapter._cls2
        implements Runnable
    {

        final SupersonicAdsAdapter this$0;
        final Activity val$activity;
        final String val$userId;

        public void run()
        {
            SupersonicAdsAdapter.access$002(SupersonicAdsAdapter.this, SSAFactory.getPublisherInstance(SupersonicAdsAdapter.access$100(SupersonicAdsAdapter.this)));
            java.util.HashMap hashmap = SupersonicAdsAdapter.access$300(SupersonicAdsAdapter.this, activity);
            String s = SupersonicConfig.getConfigObj(activity).getApplicationKey();
            SupersonicAdsAdapter.access$400(SupersonicAdsAdapter.this, com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":initRewardedVideo(appKey:").append(s).append(", userId:").append(userId).append(", extraParams:").append(hashmap).append(")").toString(), 1);
            SupersonicAdsAdapter.access$000(SupersonicAdsAdapter.this).initRewardedVideo(s, userId, hashmap, new SupersonicAdsAdapter._cls2._cls1());
        }

            
            {
                this$0 = final_supersonicadsadapter;
                activity = activity1;
                userId = String.this;
                super();
            }
    }

}
