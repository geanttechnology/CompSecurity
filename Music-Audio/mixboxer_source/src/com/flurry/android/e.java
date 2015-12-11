// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.jumptap.adtag.JtAdView;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.JtAdWidgetSettingsFactory;
import com.jumptap.adtag.utils.JtException;

// Referenced classes of package com.flurry.android:
//            AdNetworkView, aw, cy, u, 
//            FlurryAds, cw, AdCreative

class e extends AdNetworkView
{

    private static final String p = com/flurry/android/e.getSimpleName();
    private final String q;
    private final String r;
    private final String s;

    e(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative, Bundle bundle)
    {
        super(context, flurryads, cw, adcreative);
        q = bundle.getString("com.flurry.jumptap.PUBLISHER_ID");
        r = bundle.getString("com.flurry.jumptap.SPOT_ID");
        s = bundle.getString("com.flurry.jumptap.SITE_ID");
        setFocusable(true);
    }

    static String d()
    {
        return p;
    }

    public void initLayout(Context context)
    {
        JtAdWidgetSettings jtadwidgetsettings;
        jtadwidgetsettings = JtAdWidgetSettingsFactory.createWidgetSettings();
        jtadwidgetsettings.setPublisherId(q);
        if (!TextUtils.isEmpty(r))
        {
            jtadwidgetsettings.setSpotId(r);
        }
        if (!TextUtils.isEmpty(s))
        {
            jtadwidgetsettings.setSiteId(s);
        }
        jtadwidgetsettings.setApplicationId(aw.j(getContext()));
        jtadwidgetsettings.setApplicationVersion(aw.k(getContext()));
        jtadwidgetsettings.setRefreshPeriod(0);
        jtadwidgetsettings.setShouldSendLocation(false);
        setGravity(17);
        context = new JtAdView((Activity)context, jtadwidgetsettings);
        float f = getResources().getDisplayMetrics().density;
        cy.c(p, (new StringBuilder()).append("scale is ").append(f).toString());
        context.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)(320F * f + 0.5F), (int)(f * 50F + 0.5F)));
_L2:
        context.setAdViewListener(new u(this));
        addView(context);
        return;
        context;
        context = null;
_L3:
        Log.d(p, "Jumptap JtException when creating ad object.");
        if (true) goto _L2; else goto _L1
_L1:
        JtException jtexception;
        jtexception;
          goto _L3
    }

}
