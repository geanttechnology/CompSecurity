// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.models.division.Division;
import com.groupon.models.emailsubscription.EmailSubscriptionContainer;
import com.groupon.service.AttributionService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.view:
//            EmailSubscriptionItemView

class val.internalCallback
    implements Function1
{

    final EmailSubscriptionItemView this$0;
    final Function1 val$internalCallback;

    public void execute(EmailSubscriptionContainer emailsubscriptioncontainer)
    {
        emailsubscriptioncontainer = emailsubscriptioncontainer.emailSubscription;
        setSubscription(emailsubscriptioncontainer);
        val$internalCallback.execute(emailsubscriptioncontainer);
        EmailSubscriptionItemView.access$200(EmailSubscriptionItemView.this).logSubscriptionSignUp("", "email", getDivision().id, EmailSubscriptionItemView.access$100(EmailSubscriptionItemView.this).getAttributionCid(), EmailSubscriptionItemView.access$100(EmailSubscriptionItemView.this).getAttributionId(), EmailSubscriptionItemView.access$100(EmailSubscriptionItemView.this).getAttributionType(), EmailSubscriptionItemView.access$100(EmailSubscriptionItemView.this).getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), EmailSubscriptionItemView.access$100(EmailSubscriptionItemView.this).getAttributionDownloadId(), EmailSubscriptionItemView.access$100(EmailSubscriptionItemView.this).getAttributionDownloadCid(), Logger.NULL_NST_FIELD);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((EmailSubscriptionContainer)obj);
    }

    scriptionContainer()
    {
        this$0 = final_emailsubscriptionitemview;
        val$internalCallback = Function1.this;
        super();
    }
}
