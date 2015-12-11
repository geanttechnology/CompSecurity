// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.models.inappmessage.InAppMessage;
import com.groupon.service.DeepLinkManager;
import com.groupon.util.Function1;
import com.groupon.view.InAppToast;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            Featured

class this._cls0
    implements Function1
{

    final Featured this$0;

    public void execute(InAppMessage inappmessage)
    {
        if (inappmessage == null || !inappmessage.isEnabled())
        {
            break MISSING_BLOCK_LABEL_160;
        }
        try
        {
            if (Strings.isEmpty(inappmessage.getMessage()))
            {
                Featured.access$000(Featured.this, inappmessage, "message");
                return;
            }
        }
        catch (Exception exception)
        {
            Ln.e(exception);
            Featured.access$000(Featured.this, inappmessage, null);
            return;
        }
        if (!Strings.equalsIgnoreCase(inappmessage.getContext(), Channel.FEATURED))
        {
            Featured.access$000(Featured.this, inappmessage, "context");
            return;
        }
        DeepLinkData deeplinkdata;
        deeplinkdata = Featured.access$100(Featured.this).getDeepLink(Featured.access$100(Featured.this).normalizeUrl(inappmessage.getTarget(), true));
        deeplinkdata.setAttributionId(inappmessage.getId());
        deeplinkdata.setAttributionType("in_app_message");
        if (!deepLinkManager.isDirectlyFollowable(deeplinkdata))
        {
            Featured.access$000(Featured.this, inappmessage, "target");
            return;
        }
        Featured.access$200(Featured.this).setDeepLink(deeplinkdata);
        Featured.access$200(Featured.this).updateModel(inappmessage);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((InAppMessage)obj);
    }

    InAppMessage()
    {
        this$0 = Featured.this;
        super();
    }
}
