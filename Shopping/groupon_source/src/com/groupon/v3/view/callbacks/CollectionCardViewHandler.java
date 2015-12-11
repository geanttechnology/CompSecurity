// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.DealCollection;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.models.nst.CollectionCard;
import com.groupon.models.nst.CollectionCardExtraInfo;
import com.groupon.models.nst.CollectionCardImpressionExtraInfo;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.DeepLinkManager;
import com.groupon.util.LoggingUtils;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.v3.view.callbacks:
//            CollectionCardCallback

public class CollectionCardViewHandler
    implements CollectionCardCallback
{

    private static final String COLLECTION_CARD = "collection_card";
    private static final String COLLECTION_CARD_CLICK_TYPE = "impression_click";
    private final Context context;
    private final Lazy deepLinkManager;
    private final Lazy deepLinkUtil;
    private final Lazy intentFactory;
    private final Lazy loggingUtils;

    public CollectionCardViewHandler(Context context1)
    {
        context = context1;
        intentFactory = new Lazy(context1) {

            final CollectionCardViewHandler this$0;

            
            {
                this$0 = CollectionCardViewHandler.this;
                super(context1);
            }
        };
        deepLinkManager = new Lazy(context1) {

            final CollectionCardViewHandler this$0;

            
            {
                this$0 = CollectionCardViewHandler.this;
                super(context1);
            }
        };
        deepLinkUtil = new Lazy(context1) {

            final CollectionCardViewHandler this$0;

            
            {
                this$0 = CollectionCardViewHandler.this;
                super(context1);
            }
        };
        loggingUtils = new Lazy(context1) {

            final CollectionCardViewHandler this$0;

            
            {
                this$0 = CollectionCardViewHandler.this;
                super(context1);
            }
        };
    }

    public void onCollectionCardBound(DealCollection dealcollection)
    {
        ((LoggingUtils)loggingUtils.get()).logImpression("", "collection_card", dealcollection.channel, String.valueOf(dealcollection.derivedTrackingPosition), new CollectionCardImpressionExtraInfo(dealcollection.uuid, dealcollection.templateId));
    }

    public void onCollectionCardClicked(View view, DealCollection dealcollection)
    {
        view = new CollectionCard("collection_card", dealcollection.uuid, dealcollection.templateId, dealcollection.derivedTrackingPosition);
        ((LoggingUtils)loggingUtils.get()).logClick("", "impression_click", dealcollection.channel, JsonEncodedNSTField.NULL_JSON_NST_FIELD, new CollectionCardExtraInfo(view));
        try
        {
            dealcollection = dealcollection.getValue("deepLink", null);
            dealcollection = ((DeepLinkUtil)deepLinkUtil.get()).getDeepLink(dealcollection);
            Bundle bundle = new Bundle();
            bundle.putParcelable("originating_channel", Channel.FEATURED);
            bundle.putParcelable("collectionCardDetails", view);
            ((DeepLinkManager)deepLinkManager.get()).followDeepLink(context, dealcollection, bundle, false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DealCollection dealcollection)
        {
            context.startActivity(((IntentFactory)intentFactory.get()).newCarouselIntent().putExtra("collectionCardDetails", view));
        }
    }
}
