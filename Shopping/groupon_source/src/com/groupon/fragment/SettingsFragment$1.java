// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Intent;
import android.preference.Preference;
import com.groupon.models.country.Country;
import com.groupon.service.AttributionService;
import com.groupon.service.GCMNotificationService;
import com.groupon.service.PreferenceLogger;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.fragment:
//            SettingsFragment

class this._cls0
    implements android.preference.enceChangeListener
{

    final SettingsFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        if (((Boolean)obj).booleanValue())
        {
            SettingsFragment.access$000(SettingsFragment.this).logGeneralEvent("notifications_reg_user_enabled", "", "", 1, Logger.NULL_NST_FIELD);
            SettingsFragment.access$000(SettingsFragment.this).logSubscriptionSignUp("", "push_system_enabled", "", SettingsFragment.access$100(SettingsFragment.this).getAttributionCid(), SettingsFragment.access$100(SettingsFragment.this).getAttributionId(), SettingsFragment.access$100(SettingsFragment.this).getAttributionType(), SettingsFragment.access$100(SettingsFragment.this).getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), SettingsFragment.access$100(SettingsFragment.this).getAttributionDownloadId(), SettingsFragment.access$100(SettingsFragment.this).getAttributionDownloadCid(), Logger.NULL_NST_FIELD);
            if (SettingsFragment.access$200(SettingsFragment.this).getCurrentCountry().isUSACompatible())
            {
                preference = new Intent(getActivity(), com/groupon/service/GCMNotificationService);
                preference.setAction("com.groupon.REGISTER");
                Ln.d("GCM_Notification: User enabled push notification through my account page", new Object[0]);
                getActivity().startService(preference);
            }
        } else
        {
            SettingsFragment.access$000(SettingsFragment.this).logGeneralEvent("notifications_reg_user_disabled", "", "", 0, Logger.NULL_NST_FIELD);
            SettingsFragment.access$000(SettingsFragment.this).logSubscriptionUnsubscribe("", "push_system_disabled", "", SettingsFragment.access$100(SettingsFragment.this).getAttributionCid(), SettingsFragment.access$100(SettingsFragment.this).getAttributionId(), SettingsFragment.access$100(SettingsFragment.this).getAttributionType(), SettingsFragment.access$100(SettingsFragment.this).getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), SettingsFragment.access$100(SettingsFragment.this).getAttributionDownloadId(), SettingsFragment.access$100(SettingsFragment.this).getAttributionDownloadCid(), Logger.NULL_NST_FIELD);
            preference = new Intent(getActivity(), com/groupon/service/GCMNotificationService);
            preference.setAction("com.groupon.UNSUBSCRIBE_PUSH");
            Ln.d("GCM_Notification: User disabled push notification through my account page ", new Object[0]);
            getActivity().startService(preference);
        }
        SettingsFragment.access$300(SettingsFragment.this).logAppPrefs(false);
        return true;
    }

    ce()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
