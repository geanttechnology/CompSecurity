// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.PreferencesActivity;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.notifications.NotificationPreferenceManager;

public abstract class NotificationPreferencesFragmentBase extends PreferenceFragment
{

    protected NotificationPreferenceManager notificationPrefs;
    protected String userId;

    public NotificationPreferencesFragmentBase()
    {
    }

    private void resumeUi()
    {
        PreferencesActivity preferencesactivity = (PreferencesActivity)getActivity();
        userId = MyApp.getPrefs().getCurrentUser();
        if (TextUtils.isEmpty(userId))
        {
            preferencesactivity.finish();
        } else
        {
            notificationPrefs = new NotificationPreferenceManager(MyApp.getApp().getApplicationContext());
            if (EbayUtil.isPushActive(preferencesactivity, userId, "AEAPP"))
            {
                com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
                int l = aeventtype.length;
                for (int i = 0; i < l; i++)
                {
                    com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = aeventtype[i];
                    setPreference(notificationPrefs, eventtype.name(), eventtype.supported, false);
                }

            } else
            {
                com.ebay.common.model.mdns.NotificationPreference.AlertType aalerttype[] = com.ebay.common.model.mdns.NotificationPreference.AlertType.values();
                int i1 = aalerttype.length;
                for (int j = 0; j < i1; j++)
                {
                    com.ebay.common.model.mdns.NotificationPreference.AlertType alerttype = aalerttype[j];
                    setPreference(notificationPrefs, NotificationPreference.clientAlertNameToEventName(alerttype.name()), alerttype.supported, false);
                }

                android.preference.Preference preference = findPreference(com.ebay.common.model.mdns.NotificationPreference.EventType.MSGEBAYMSGHDR.name());
                android.preference.Preference preference1 = findPreference(com.ebay.common.model.mdns.NotificationPreference.EventType.MSGM2MMSGHDR.name());
                PreferenceScreen preferencescreen = getPreferenceScreen();
                if (preference != null)
                {
                    preferencescreen.removePreference(preference);
                }
                if (preference1 != null)
                {
                    preferencescreen.removePreference(preference1);
                }
            }
            com.ebay.mobile.notifications.NotificationPreferenceManager.CombinedEvent acombinedevent[] = com.ebay.mobile.notifications.NotificationPreferenceManager.CombinedEvent.values();
            int j1 = acombinedevent.length;
            int k = 0;
            while (k < j1) 
            {
                com.ebay.mobile.notifications.NotificationPreferenceManager.CombinedEvent combinedevent = acombinedevent[k];
                setPreference(notificationPrefs, combinedevent.name(), combinedevent.isSupported(), false);
                k++;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        userId = MyApp.getPrefs().getCurrentUser();
    }

    public void onResume()
    {
        super.onResume();
        resumeUi();
    }

    protected void setPreference(NotificationPreferenceManager notificationpreferencemanager, String s, boolean flag, boolean flag1)
    {
        ((PreferencesActivity)getActivity()).setPreference(notificationpreferencemanager, getPreferenceScreen(), s, flag, flag1);
    }
}
