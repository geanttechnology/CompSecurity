// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.Finder;
import com.groupon.models.nst.FinderCard;
import com.groupon.models.nst.FinderCardExtraInfo;
import com.groupon.models.nst.FinderCardImpressionExtraInfo;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.util.GtgDefaultPromoDeepLinkHandler;
import com.groupon.util.LoggingUtils;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.v3.view.callbacks:
//            FinderCardCallback

public class GtgJumpOffCardHandler
    implements FinderCardCallback
{

    public static final String CARD_NAME = "gtg_jumpoff";
    public static final String TAG = com/groupon/v3/view/callbacks/GtgJumpOffCardHandler.getSimpleName();
    private Lazy deepLinkHandler;
    private Lazy loggingUtils;

    public GtgJumpOffCardHandler(Context context)
    {
        deepLinkHandler = new Lazy(context) {

            final GtgJumpOffCardHandler this$0;

            
            {
                this$0 = GtgJumpOffCardHandler.this;
                super(context);
            }
        };
        loggingUtils = new Lazy(context) {

            final GtgJumpOffCardHandler this$0;

            
            {
                this$0 = GtgJumpOffCardHandler.this;
                super(context);
            }
        };
    }

    public void onFinderCardBound(Finder finder)
    {
        ((LoggingUtils)loggingUtils.get()).logImpression("", "finder_card", finder.channel, String.valueOf(finder.derivedTrackingPosition), new FinderCardImpressionExtraInfo("gtg_jumpoff"));
    }

    public void onFinderCardClicked(View view, Finder finder)
    {
        ((LoggingUtils)loggingUtils.get()).logClick("", "impression_click", finder.channel, JsonEncodedNSTField.NULL_JSON_NST_FIELD, new FinderCardExtraInfo(new FinderCard("", finder.name, finder.derivedTrackingPosition)));
        ((GtgDefaultPromoDeepLinkHandler)deepLinkHandler.get()).handle(finder.deepLink);
    }

}
