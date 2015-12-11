// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.ucibanner;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.ebay.common.Preferences;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.connection.ucibanner:
//            HomescreenBanner

public class UciBanner
    implements HomescreenBanner
{

    private static final int MINIMUM_DAYS = 1;
    private static final String PREF_DISMISSED_UCI_BANNER = "uciBannerClicked";
    private static final String PREF_UCI_BANNER_DISMISSAL_TIME = "uciBannerDismissedAt";

    public UciBanner()
    {
    }

    public SpannableString getText(Resources resources)
    {
        CharSequence charsequence = resources.getText(0x7f070b87);
        CharSequence charsequence1 = resources.getText(0x7f070b86);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(charsequence);
        spannablestringbuilder.append("\n");
        spannablestringbuilder.append(charsequence1);
        int i = charsequence.length();
        int j = spannablestringbuilder.length();
        spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0d001d)), i, j, 33);
        spannablestringbuilder.setSpan(new StyleSpan(1), i, j, 33);
        return new SpannableString(spannablestringbuilder);
    }

    public void onBannerClick(Activity activity)
    {
        MyApp.getPrefs().setUserPref(true, "uciBannerClicked");
        activity.startActivity(ActivityStarter.getUciWebViewIntent(activity, "HEADER_APP"));
    }

    public void onBannerDismiss(Activity activity)
    {
        MyApp.getPrefs().setUserPref(System.currentTimeMillis(), "uciBannerDismissedAt");
    }

    public boolean shouldShowBanner()
    {
        boolean flag = true;
        Preferences preferences = MyApp.getPrefs();
        DeviceConfiguration deviceconfiguration;
        for (deviceconfiguration = DeviceConfiguration.getAsync(); !deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Connect.B.uciBanner) || !preferences.isSignedIn() || preferences.getUserPref("uciBannerClicked", false);)
        {
            return false;
        }

        long l = preferences.getUserPref("uciBannerDismissedAt", 0L);
        if (l == 0L)
        {
            return true;
        }
        int i = (int)((System.currentTimeMillis() - l) / 0x5265c00L);
        if (Math.max(1, deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Connect.I.uciBannerDelay)) > i)
        {
            flag = false;
        }
        return flag;
    }
}
