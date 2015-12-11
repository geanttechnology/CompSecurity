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

class val.userId
    implements Runnable
{

    final SupersonicAdsAdapter this$0;
    final Activity val$activity;
    final String val$userId;

    public void run()
    {
        SupersonicAdsAdapter.access$002(SupersonicAdsAdapter.this, SSAFactory.getPublisherInstance(SupersonicAdsAdapter.access$100(SupersonicAdsAdapter.this)));
        java.util.HashMap hashmap = SupersonicAdsAdapter.access$300(SupersonicAdsAdapter.this, val$activity);
        String s = SupersonicConfig.getConfigObj(val$activity).getApplicationKey();
        SupersonicAdsAdapter.access$400(SupersonicAdsAdapter.this, com.supersonic.mediationsdk.logger.onicTag.ADAPTER_API, (new StringBuilder()).append(getProviderName()).append(":initRewardedVideo(appKey:").append(s).append(", userId:").append(val$userId).append(", extraParams:").append(hashmap).append(")").toString(), 1);
        SupersonicAdsAdapter.access$000(SupersonicAdsAdapter.this).initRewardedVideo(s, val$userId, hashmap, new OnRewardedVideoListener() {

            final SupersonicAdsAdapter._cls2 this$1;

            public void onRVAdClosed()
            {
                if (SupersonicAdsAdapter.access$600(this$0) != null)
                {
                    SupersonicAdsAdapter.access$600(this$0).onRewardedVideoAdClosed(this$0);
                }
            }

            public void onRVAdCredited(int i)
            {
                if (SupersonicAdsAdapter.access$600(this$0) != null)
                {
                    SupersonicAdsAdapter.access$600(this$0).onRewardedVideoAdRewarded(i, this$0);
                }
            }

            public void onRVGeneric(String s1, String s2)
            {
            }

            public void onRVInitFail(String s1)
            {
                SupersonicAdsAdapter.access$1200(this$0, false);
                SupersonicAdsAdapter.access$1300(this$0);
                if (SupersonicAdsAdapter.access$600(this$0) != null)
                {
                    s1 = ErrorBuilder.buildAdapterInitFailedError(s1);
                    SupersonicAdsAdapter.access$600(this$0).onRewardedVideoInitFail(s1, this$0);
                }
            }

            public void onRVInitSuccess(AdUnitsReady adunitsready)
            {
                SupersonicAdsAdapter.access$700(this$0);
                SupersonicAdsAdapter.access$800(this$0, true);
                SupersonicAdsAdapter supersonicadsadapter = this$0;
                int i;
                int j;
                boolean flag;
                if (SupersonicAdsAdapter.access$900(this$0) < SupersonicAdsAdapter.access$1000(this$0))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                supersonicadsadapter.setAdAvailable(flag);
                if (SupersonicAdsAdapter.access$600(this$0) == null) goto _L2; else goto _L1
_L1:
                SupersonicAdsAdapter.access$600(this$0).onRewardedVideoInitSuccess(this$0);
                i = 0;
                j = Integer.parseInt(adunitsready.getNumOfAdUnits());
                i = j;
_L4:
                if (i <= 0 || !SupersonicAdsAdapter.access$1100(this$0))
                {
                    break; /* Loop/switch isn't completed */
                }
                SupersonicAdsAdapter.access$600(this$0).onVideoAvailabilityChanged(true, this$0);
_L2:
                return;
                adunitsready;
                SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "onRVInitSuccess:parseInt()", adunitsready);
                if (true) goto _L4; else goto _L3
_L3:
                SupersonicAdsAdapter.access$600(this$0).onVideoAvailabilityChanged(false, this$0);
                return;
            }

            public void onRVNoMoreOffers()
            {
                SupersonicAdsAdapter.access$500(this$0);
                setAdAvailable(false);
                if (SupersonicAdsAdapter.access$600(this$0) != null)
                {
                    SupersonicAdsAdapter.access$600(this$0).onRewardedVideoInitSuccess(this$0);
                    SupersonicAdsAdapter.access$600(this$0).onVideoAvailabilityChanged(false, this$0);
                }
            }

            
            {
                this$1 = SupersonicAdsAdapter._cls2.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_supersonicadsadapter;
        val$activity = activity1;
        val$userId = String.this;
        super();
    }
}
