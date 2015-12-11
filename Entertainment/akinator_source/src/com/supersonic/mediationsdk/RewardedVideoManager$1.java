// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk;

import android.app.Activity;
import com.supersonic.mediationsdk.config.ConfigValidationResult;
import com.supersonic.mediationsdk.sdk.SupersonicFactory;
import com.supersonic.mediationsdk.utils.ErrorBuilder;
import com.supersonic.mediationsdk.utils.ServerResponseWrapper;
import com.supersonic.mediationsdk.utils.SupersonicUtils;

// Referenced classes of package com.supersonic.mediationsdk:
//            RewardedVideoManager, SupersonicObject

class val.userId
    implements Runnable
{

    final RewardedVideoManager this$0;
    final Activity val$activity;
    final String val$userId;

    public void run()
    {
        SupersonicObject supersonicobject = (SupersonicObject)SupersonicFactory.getInstance();
        SupersonicUtils.setSupersonicUserId(val$activity, val$userId);
        ConfigValidationResult configvalidationresult = supersonicobject.runSupersonicConfigValidation(RewardedVideoManager.access$000(RewardedVideoManager.this));
        if (!configvalidationresult.isValid())
        {
            RewardedVideoManager.access$100(RewardedVideoManager.this, configvalidationresult.getSupersonicError());
        } else
        {
            if (!SupersonicUtils.isNetworkConnected(val$activity))
            {
                RewardedVideoManager.access$100(RewardedVideoManager.this, ErrorBuilder.buildGenericError("No Internet Connection"));
                return;
            }
            RewardedVideoManager.access$202(RewardedVideoManager.this, supersonicobject.getServerResponse(RewardedVideoManager.access$000(RewardedVideoManager.this), val$userId));
            if (RewardedVideoManager.access$200(RewardedVideoManager.this) != null)
            {
                if (RewardedVideoManager.access$200(RewardedVideoManager.this).isValidResponse())
                {
                    int j = RewardedVideoManager.access$200(RewardedVideoManager.this).getAdaptersSmartLoadAmount();
                    int i = 0;
                    while (i < j && RewardedVideoManager.access$300(RewardedVideoManager.this) != null) 
                    {
                        i++;
                    }
                } else
                {
                    com.supersonic.mediationsdk.logger.SupersonicError supersonicerror2 = RewardedVideoManager.access$200(RewardedVideoManager.this).getReponseError();
                    com.supersonic.mediationsdk.logger.SupersonicError supersonicerror = supersonicerror2;
                    if (supersonicerror2 == null)
                    {
                        supersonicerror = ErrorBuilder.buildNoConfigurationAvailableError();
                    }
                    RewardedVideoManager.access$100(RewardedVideoManager.this, supersonicerror);
                    return;
                }
            } else
            {
                com.supersonic.mediationsdk.logger.SupersonicError supersonicerror1 = ErrorBuilder.buildNoConfigurationAvailableError();
                RewardedVideoManager.access$100(RewardedVideoManager.this, supersonicerror1);
                return;
            }
        }
    }

    pper()
    {
        this$0 = final_rewardedvideomanager;
        val$activity = activity1;
        val$userId = String.this;
        super();
    }
}
