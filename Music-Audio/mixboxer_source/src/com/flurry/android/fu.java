// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.jumptap.adtag.JtAdInterstitial;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.JtAdWidgetSettingsFactory;
import com.jumptap.adtag.utils.JtException;

// Referenced classes of package com.flurry.android:
//            do, aw, z, FlurryAds, 
//            cw, AdUnit

final class fu extends do
{

    private static final String p = com/flurry/android/fu.getSimpleName();
    private final String q;
    private final String r;
    private final String s;

    public fu(Context context, FlurryAds flurryads, cw cw, AdUnit adunit, Bundle bundle)
    {
        super(context, flurryads, cw, adunit);
        q = bundle.getString("com.flurry.jumptap.PUBLISHER_ID");
        r = bundle.getString("com.flurry.jumptap.INT_SPOT_ID");
        s = bundle.getString("com.flurry.jumptap.INT_SITE_ID");
    }

    static String d()
    {
        return p;
    }

    public final void M()
    {
        Object obj = JtAdWidgetSettingsFactory.createWidgetSettings();
        ((JtAdWidgetSettings) (obj)).setPublisherId(q);
        if (!TextUtils.isEmpty(r))
        {
            ((JtAdWidgetSettings) (obj)).setSpotId(r);
        }
        if (!TextUtils.isEmpty(s))
        {
            ((JtAdWidgetSettings) (obj)).setSiteId(s);
        }
        ((JtAdWidgetSettings) (obj)).setApplicationId(aw.j(getContext()));
        ((JtAdWidgetSettings) (obj)).setApplicationVersion(aw.k(getContext()));
        ((JtAdWidgetSettings) (obj)).setRefreshPeriod(0);
        ((JtAdWidgetSettings) (obj)).setShouldSendLocation(false);
        try
        {
            obj = new JtAdInterstitial((Activity)getContext(), ((JtAdWidgetSettings) (obj)));
        }
        catch (JtException jtexception)
        {
            Log.d(p, "Jumptap JtException when creating ad object.");
            jtexception = null;
        }
        ((JtAdInterstitial) (obj)).setAdViewListener(new z(this));
        ((JtAdInterstitial) (obj)).showAsPopup();
    }

}
