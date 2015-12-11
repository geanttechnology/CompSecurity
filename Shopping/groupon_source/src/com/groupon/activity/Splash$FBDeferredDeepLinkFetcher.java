// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.net.Uri;
import com.facebook.applinks.AppLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            Splash, FacebookAppUtils

private class <init>
    implements com.facebook.applinks.init>
{

    final Splash this$0;

    public void fetchDeepLinkIntoIntentAndStartNextActivity()
    {
        AppLinkData.fetchDeferredAppLinkData(Splash.this, Splash.access$1100(Splash.this).getFacebookAppId(), this);
    }

    public void onDeferredAppLinkDataFetched(AppLinkData applinkdata)
    {
        if (applinkdata != null && applinkdata.getTargetUri() != null)
        {
            Uri uri = applinkdata.getTargetUri();
            if (Splash.access$1200(Splash.this).isDeepLink(uri.toString()))
            {
                getIntent().setData(uri);
                String s;
                if (uri.getQueryParameter("cid") == null)
                {
                    applinkdata = "";
                } else
                {
                    applinkdata = uri.getQueryParameter("cid");
                }
                if (uri.getQueryParameter("grpn_l") == null)
                {
                    s = "";
                } else
                {
                    s = uri.getQueryParameter("grpn_l");
                }
                Splash.access$1300(Splash.this).logDeepLinking("", uri.toString(), applinkdata, s, "FB_Deferred_Deep_Link", "");
            }
        }
        Splash.access$1400(Splash.this);
    }

    private ()
    {
        this$0 = Splash.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
