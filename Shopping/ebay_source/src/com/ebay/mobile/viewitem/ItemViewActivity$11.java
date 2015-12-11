// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.ebay.mobile.activities.AdsWebViewActivity;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewActivity

class this._cls0
    implements android.view.
{

    final ItemViewActivity this$0;

    public void onClick(View view)
    {
        Object obj = (com.ebay.common.rtm.ean)view.getTag();
        if (DeviceConfiguration.getAsync().get(DcsBoolean.SearchAdsShowWebView))
        {
            AdsWebViewActivity.start((Activity)view.getContext(), ((com.ebay.common.rtm.ivity.start) (obj)).alLink.toString(), null, null);
            return;
        } else
        {
            obj = ((com.ebay.common.rtm.alLink) (obj)).alLink;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(((URL) (obj)).toExternalForm()));
            view.getContext().startActivity(intent);
            return;
        }
    }

    ()
    {
        this$0 = ItemViewActivity.this;
        super();
    }
}
