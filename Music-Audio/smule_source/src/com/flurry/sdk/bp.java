// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import java.util.Collections;

// Referenced classes of package com.flurry.sdk:
//            gd, r

public class bp extends AdNetworkView
    implements AdListener
{

    private static final String a = com/flurry/sdk/bp.getSimpleName();
    private final String b;
    private final String c;
    private final boolean d;
    private AdView e;

    public bp(Context context, r r, AdCreative adcreative, Bundle bundle)
    {
        super(context, r, adcreative);
        b = bundle.getString("com.flurry.fan.MY_APP_ID");
        c = bundle.getString("com.flurry.fan.MYTEST_AD_DEVICE_ID");
        d = bundle.getBoolean("com.flurry.fan.test");
        setFocusable(true);
    }

    public void initLayout()
    {
        gd.a(4, a, "FAN banner initLayout.");
        e = new AdView(getContext(), b, AdSize.BANNER_320_50);
        e.setAdListener(this);
        addView(e);
        if (d)
        {
            AdSettings.addTestDevice(c);
        }
        e.loadAd();
    }

    public void onActivityDestroy()
    {
        gd.a(4, a, "FAN banner onDestroy.");
        if (e != null)
        {
            e.destroy();
            e = null;
        }
        super.onActivityDestroy();
    }

    public void onAdClicked(Ad ad)
    {
        gd.a(4, a, "FAN banner onAdClicked.");
        onAdClicked(Collections.emptyMap());
    }

    public void onAdLoaded(Ad ad)
    {
        onAdShown(Collections.emptyMap());
        gd.a(4, a, "FAN banner onAdLoaded.");
    }

    public void onError(Ad ad, AdError aderror)
    {
        onRenderFailed(Collections.emptyMap());
        if (e != null)
        {
            e.destroy();
            e = null;
        }
        gd.a(6, a, "FAN banner onError.");
    }

}
