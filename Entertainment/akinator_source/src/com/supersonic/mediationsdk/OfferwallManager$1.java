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
import java.util.ArrayList;

// Referenced classes of package com.supersonic.mediationsdk:
//            OfferwallManager, SupersonicObject

class val.userId
    implements Runnable
{

    final OfferwallManager this$0;
    final Activity val$activity;
    final String val$userId;

    public void run()
    {
        Object obj = (SupersonicObject)SupersonicFactory.getInstance();
        SupersonicUtils.setSupersonicUserId(val$activity, val$userId);
        Object obj1 = ((SupersonicObject) (obj)).runSupersonicConfigValidation(val$activity);
        if (!((ConfigValidationResult) (obj1)).isValid())
        {
            OfferwallManager.access$000(OfferwallManager.this, ((ConfigValidationResult) (obj1)).getSupersonicError());
            return;
        }
        if (!SupersonicUtils.isNetworkConnected(val$activity))
        {
            OfferwallManager.access$000(OfferwallManager.this, ErrorBuilder.buildGenericError("No Internet Connection"));
            return;
        }
        obj1 = ((SupersonicObject) (obj)).getServerResponse(val$activity, val$userId);
        if (obj1 != null)
        {
            if (((ServerResponseWrapper) (obj1)).isValidResponse())
            {
                obj1 = OfferwallManager.access$100(OfferwallManager.this, val$activity, val$userId, ((ServerResponseWrapper) (obj1)));
                if (obj1 == null || ((ArrayList) (obj1)).isEmpty())
                {
                    obj = ErrorBuilder.buildAdapterInitFailedError("Please check configurations for Offerwall adapters");
                    OfferwallManager.access$000(OfferwallManager.this, ((com.supersonic.mediationsdk.logger.SupersonicError) (obj)));
                    return;
                } else
                {
                    ((SupersonicObject) (obj)).addAll(((ArrayList) (obj1)));
                    return;
                }
            }
            obj1 = ((ServerResponseWrapper) (obj1)).getReponseError();
            obj = obj1;
            if (obj1 == null)
            {
                obj = ErrorBuilder.buildNoConfigurationAvailableError();
            }
            OfferwallManager.access$000(OfferwallManager.this, ((com.supersonic.mediationsdk.logger.SupersonicError) (obj)));
            return;
        } else
        {
            com.supersonic.mediationsdk.logger.SupersonicError supersonicerror = ErrorBuilder.buildNoConfigurationAvailableError();
            OfferwallManager.access$000(OfferwallManager.this, supersonicerror);
            return;
        }
    }

    eWrapper()
    {
        this$0 = final_offerwallmanager;
        val$activity = activity1;
        val$userId = String.this;
        super();
    }
}
