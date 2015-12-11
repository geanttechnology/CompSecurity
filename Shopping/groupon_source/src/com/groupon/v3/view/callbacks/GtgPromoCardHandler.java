// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.Finder;
import com.groupon.models.nst.GtgMockDealExtraInfo;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GtgDefaultPromoDeepLinkHandler;
import com.groupon.util.LoggingUtils;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.v3.view.callbacks:
//            FinderCardCallback

public class GtgPromoCardHandler
    implements FinderCardCallback
{

    public static final String TAG = com/groupon/v3/view/callbacks/GtgPromoCardHandler.getSimpleName();
    private Lazy deepLinkHandler;
    private Lazy loggingUtils;

    public GtgPromoCardHandler(Context context)
    {
        deepLinkHandler = new Lazy(context) {

            final GtgPromoCardHandler this$0;

            
            {
                this$0 = GtgPromoCardHandler.this;
                super(context);
            }
        };
        loggingUtils = new Lazy(context) {

            final GtgPromoCardHandler this$0;

            
            {
                this$0 = GtgPromoCardHandler.this;
                super(context);
            }
        };
    }

    public void onFinderCardBound(Finder finder)
    {
        ((LoggingUtils)loggingUtils.get()).logImpression("", "gtg_on_featured_imp", finder.channel, String.valueOf(finder.derivedTrackingPosition), JsonEncodedNSTField.NULL_JSON_NST_FIELD);
    }

    public void onFinderCardClicked(View view, Finder finder)
    {
        ((LoggingUtils)loggingUtils.get()).logClick("", "gtg_on_featured_click", finder.channel, Logger.NULL_NST_FIELD, new GtgMockDealExtraInfo(String.valueOf(finder.derivedTrackingPosition)));
        ((GtgDefaultPromoDeepLinkHandler)deepLinkHandler.get()).handle(finder.deepLink);
    }

}
