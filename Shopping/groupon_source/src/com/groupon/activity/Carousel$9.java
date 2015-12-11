// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.net.Uri;
import com.groupon.db.models.InAppMessage;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.InAppMessageService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GrouponPointsUtil;
import com.groupon.view.InAppMessagesView;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Carousel

class this._cls0
    implements com.groupon.view.esView.OnMessageClickedListener
{

    final Carousel this$0;

    public void onMessageClicked(InAppMessage inappmessage, int i)
    {
        if (i != inAppMessages.getCurrentItem())
        {
            inAppMessages.setCurrentItem(i, true);
            return;
        }
        if (Strings.notEmpty(inappmessage.target))
        {
            Carousel.access$1000(Carousel.this);
            String s = Carousel.access$1100(Carousel.this).normalizeUrl(inappmessage.target, true);
            Carousel.access$500(Carousel.this).logDeepLinking("", s, Uri.parse(s).getQueryParameter("cid"), inappmessage.remoteId, "in_app_message", ((DeepLinkManager)Carousel.access$1200(Carousel.this).get()).constructDeepLinkNSTExtraString(s.toString(), getIntent()));
            try
            {
                DeepLinkData deeplinkdata = Carousel.access$1100(Carousel.this).getDeepLink(s);
                deeplinkdata.setAttributionId(inappmessage.remoteId);
                deeplinkdata.setAttributionType("in_app_message");
                if (Uri.parse(deeplinkdata.getParam("url")).getPath().startsWith("/points"))
                {
                    Carousel.access$1300(Carousel.this).appendQueryParams(deeplinkdata);
                    Carousel.access$1300(Carousel.this).logPointsNotificationClink(Carousel.access$1400(Carousel.this));
                    Carousel.access$1300(Carousel.this).logPointsDeepLinking(s, Uri.parse(s).getQueryParameter("cid"), inappmessage.remoteId);
                }
                ((DeepLinkManager)Carousel.access$1200(Carousel.this).get()).followDeepLink(Carousel.this, deeplinkdata);
            }
            catch (InvalidDeepLinkException invaliddeeplinkexception) { }
            s = "yes";
        } else
        {
            s = "no";
        }
        Carousel.access$600(Carousel.this).onStateChanged(inappmessage, com.groupon.service.eService.EventName.CLICKED);
        Carousel.access$600(Carousel.this).logInAppMessageClick(Carousel.access$1400(Carousel.this), inappmessage.remoteId, s);
    }

    LinkException()
    {
        this$0 = Carousel.this;
        super();
    }
}
