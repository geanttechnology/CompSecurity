// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.content.Context;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Business;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.util.LoggingUtils;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.view.callbacks:
//            BusinessCardCallback

public class BusinessCardViewHandler
    implements BusinessCardCallback
{

    private IntentFactory intentFactory;
    private LoggingUtils loggingUtils;

    public BusinessCardViewHandler(Context context)
    {
        RoboGuice.getInjector(context).injectMembers(this);
    }

    public void onBusinessCardBound(Business business)
    {
        loggingUtils.logImpression("", "merchant", business.remoteId, "0", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
    }

    public void onBusinessCardClicked(View view, Business business)
    {
        view = view.getContext();
        loggingUtils.logClick("", "merchant_impression_click", Channel.MERCHANT_PAGE.toString(), loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(business.remoteId)));
        view.startActivity(intentFactory.newMerchantPageIntent(business.remoteId));
    }
}
