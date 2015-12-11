// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.social;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.primeupsell.PrimeUpsellHelper;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import java.util.Date;

// Referenced classes of package com.amazon.mShop.social:
//            SocialConnectDebugSettingsActivity, SocialConnectDatabaseHelper

public class SocialConnectHelper
{

    private static int MAX_RETRIES = 1;
    private static int MAX_TIMES_TO_SHOW = 1;

    public SocialConnectHelper()
    {
    }

    public static boolean isFacebookSDKLoaded()
    {
        try
        {
            Class.forName("com.facebook.Session");
            Class.forName("com.facebook.SessionState");
            Class.forName("com.facebook.Settings");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.e("SocialConnectHelper", (new StringBuilder()).append("Facebook SDK failed to launch: ").append(classnotfoundexception.getMessage()).toString());
            return false;
        }
        return true;
    }

    public static boolean launchSocialConnect(Activity activity, String s, String s1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (activity != null)
        {
            flag = flag1;
            if (s1 != null)
            {
                ActivityUtils.startSocialConnectActivity(activity, s1);
                flag = true;
                RefMarkerObserver.logRefMarker(s);
            }
        }
        return flag;
    }

    public static boolean passesPreLaunchCheck()
    {
        if (isFacebookSDKLoaded() && User.getUser() != null && NetInfo.hasNetworkConnection())
        {
            if (SocialConnectDebugSettingsActivity.shouldAlwaysDisplay() || SocialConnectDebugSettingsActivity.shouldDisplayOnce() && socialConnectHasNotDisplayed())
            {
                return true;
            }
            if (!SocialConnectDebugSettingsActivity.shouldNeverDisplay() && ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_social_connect_support) && !PrimeUpsellHelper.isPrimeUpsellLaunched() && Features.getInstance().isFeatureActivated("Android_SocialConnectOOBE"))
            {
                return true;
            }
        }
        return false;
    }

    static void socialConnectFinished(boolean flag)
    {
        String s = SSOUtil.getCurrentAccount((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext());
        long l = (new Date()).getTime();
        SocialConnectDatabaseHelper.getInstance().recordInteraction(s, l, flag);
    }

    public static boolean socialConnectHasNotDisplayed()
    {
        String s = SSOUtil.getCurrentAccount((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext());
        return SocialConnectDatabaseHelper.getInstance().getNumberTimesShown(s) == 0;
    }

}
