// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.net.Uri;
import android.view.View;
import com.google.inject.Provider;
import com.groupon.Channel;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.models.LoggingNSTExtras;
import com.groupon.models.inappmessage.InAppMessage;
import com.groupon.service.DeepLinkManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GrouponPointsUtil;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            InAppToast, InAppToastRoot

class this._cls0
    implements android.view.istener
{

    final InAppToast this$0;

    public void onClick(View view)
    {
        try
        {
            InAppToast.access$100(InAppToast.this).logClick("", "in_app_message", "view", InAppToast.access$000(InAppToast.this).getId());
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Ln.e(view);
        }
        InAppToast.access$000(InAppToast.this).onClicked();
        if (InAppToast.access$200(InAppToast.this) != null)
        {
            view = new LoggingNSTExtras();
            view.referrer = "in_app";
            try
            {
                view = InAppToast.access$300(InAppToast.this).writeValueAsString(view);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view = "";
            }
            ((Logger)InAppToast.access$400(InAppToast.this).get()).logDeepLinking("", InAppToast.access$200(InAppToast.this).toString(), InAppToast.access$200(InAppToast.this).getAttributionCid(), InAppToast.access$200(InAppToast.this).getAttributionLinkId(), InAppToast.access$200(InAppToast.this).getUtmMediumAttribution(), view);
            if (Uri.parse(InAppToast.access$200(InAppToast.this).getParam("url")).getPath().startsWith("/points"))
            {
                InAppToast.access$500(InAppToast.this).appendQueryParams(InAppToast.access$200(InAppToast.this));
                InAppToast.access$500(InAppToast.this).logPointsNotificationClink(Channel.FEATURED.toString());
                InAppToast.access$500(InAppToast.this).logPointsDeepLinking(InAppToast.access$200(InAppToast.this).toString(), InAppToast.access$200(InAppToast.this).getAttributionCid(), InAppToast.access$200(InAppToast.this).getAttributionLinkId());
            }
            InAppToast.access$700(InAppToast.this).followDeepLink(InAppToast.access$600(InAppToast.this).getContext(), InAppToast.access$200(InAppToast.this));
        }
        InAppToast.access$800(InAppToast.this, 0);
    }

    nager()
    {
        this$0 = InAppToast.this;
        super();
    }
}
