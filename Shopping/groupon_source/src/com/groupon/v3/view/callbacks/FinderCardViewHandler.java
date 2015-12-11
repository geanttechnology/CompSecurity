// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.crittercism.app.Crittercism;
import com.groupon.Channel;
import com.groupon.db.models.Finder;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.models.nst.FinderCard;
import com.groupon.models.nst.FinderCardExtraInfo;
import com.groupon.models.nst.FinderCardImpressionExtraInfo;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.DeepLinkManager;
import com.groupon.util.LoggingUtils;
import roboguice.inject.Lazy;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.v3.view.callbacks:
//            FinderCardCallback

public class FinderCardViewHandler
    implements FinderCardCallback
{

    public static final String FINDER_CARD_CLICK = "impression_click";
    public static final String FINDER_CARD_IMPRESSION = "finder_card";
    private final Context context;
    private final Lazy deepLinkManager;
    private final Lazy deepLinkUtil;
    private final Lazy loggingUtils;

    public FinderCardViewHandler(Context context1)
    {
        context = context1;
        deepLinkManager = new Lazy(context1) {

            final FinderCardViewHandler this$0;

            
            {
                this$0 = FinderCardViewHandler.this;
                super(context1);
            }
        };
        deepLinkUtil = new Lazy(context1) {

            final FinderCardViewHandler this$0;

            
            {
                this$0 = FinderCardViewHandler.this;
                super(context1);
            }
        };
        loggingUtils = new Lazy(context1) {

            final FinderCardViewHandler this$0;

            
            {
                this$0 = FinderCardViewHandler.this;
                super(context1);
            }
        };
    }

    public void onFinderCardBound(Finder finder)
    {
        ((LoggingUtils)loggingUtils.get()).logImpression("", "finder_card", finder.channel, String.valueOf(finder.derivedTrackingPosition), new FinderCardImpressionExtraInfo(finder.name));
    }

    public void onFinderCardClicked(View view, Finder finder)
    {
        ((LoggingUtils)loggingUtils.get()).logClick("", "impression_click", finder.channel, JsonEncodedNSTField.NULL_JSON_NST_FIELD, new FinderCardExtraInfo(new FinderCard(finder.type, finder.name, finder.derivedTrackingPosition)));
        try
        {
            view = finder.deepLink;
            view = ((DeepLinkUtil)deepLinkUtil.get()).getDeepLink(view);
            finder = new Bundle();
            finder.putParcelable("originating_channel", Channel.FEATURED);
            ((DeepLinkManager)deepLinkManager.get()).followDeepLink(context, view, finder, false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Crittercism.logHandledException(view);
        }
        Ln.e(view);
    }
}
