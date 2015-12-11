// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import com.groupon.GrouponApplication;
import com.groupon.google_api.GeofenceSetter;
import com.groupon.models.country.Country;
import com.groupon.service.AttributionService;
import com.groupon.service.GCMNotificationService;
import com.groupon.service.PreferenceLogger;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.TimePickerPreference;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class SettingsFragment extends PreferenceFragment
{

    private AbTestService abTestService;
    private PreferenceCategory advancedPreferenceCategory;
    private AttributionService attributionService;
    private CurrentCountryManager currentCountryManager;
    private CheckBoxPreference dealNotification;
    private PreferenceCategory generalPreferenceCategory;
    private GeofenceSetter geofenceSetter;
    private Logger logger;
    private PreferenceLogger preferenceLogger;
    private PreferenceScreen preferenceScreen;
    private SharedPreferences prefs;
    private CheckBoxPreference proximityBasedNotifications;
    private CheckBoxPreference reportABugPreference;
    private CheckBoxPreference silentNotification;
    private TimePickerPreference timePickerPreference;

    public SettingsFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        getPreferenceManager().setSharedPreferencesName("default");
        addPreferencesFromResource(0x7f060004);
        preferenceScreen = (PreferenceScreen)findPreference("pref_screen_root");
        generalPreferenceCategory = (PreferenceCategory)findPreference("pref_key_general");
        advancedPreferenceCategory = (PreferenceCategory)findPreference("pref_key_advanced");
        dealNotification = (CheckBoxPreference)findPreference("dealNotification");
        silentNotification = (CheckBoxPreference)findPreference("silentNotifications");
        timePickerPreference = (TimePickerPreference)findPreference("notificationTime");
        proximityBasedNotifications = (CheckBoxPreference)findPreference("proximityNotificationEnabled");
        reportABugPreference = (CheckBoxPreference)findPreference("pref_key_report_a_bug");
        dealNotification.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

            final SettingsFragment this$0;

            public boolean onPreferenceChange(Preference preference, Object obj)
            {
                if (((Boolean)obj).booleanValue())
                {
                    logger.logGeneralEvent("notifications_reg_user_enabled", "", "", 1, Logger.NULL_NST_FIELD);
                    logger.logSubscriptionSignUp("", "push_system_enabled", "", attributionService.getAttributionCid(), attributionService.getAttributionId(), attributionService.getAttributionType(), attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), Logger.NULL_NST_FIELD);
                    if (currentCountryManager.getCurrentCountry().isUSACompatible())
                    {
                        preference = new Intent(getActivity(), com/groupon/service/GCMNotificationService);
                        preference.setAction("com.groupon.REGISTER");
                        Ln.d("GCM_Notification: User enabled push notification through my account page", new Object[0]);
                        getActivity().startService(preference);
                    }
                } else
                {
                    logger.logGeneralEvent("notifications_reg_user_disabled", "", "", 0, Logger.NULL_NST_FIELD);
                    logger.logSubscriptionUnsubscribe("", "push_system_disabled", "", attributionService.getAttributionCid(), attributionService.getAttributionId(), attributionService.getAttributionType(), attributionService.getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), Logger.NULL_NST_FIELD);
                    preference = new Intent(getActivity(), com/groupon/service/GCMNotificationService);
                    preference.setAction("com.groupon.UNSUBSCRIBE_PUSH");
                    Ln.d("GCM_Notification: User disabled push notification through my account page ", new Object[0]);
                    getActivity().startService(preference);
                }
                preferenceLogger.logAppPrefs(false);
                return true;
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        silentNotification.setDefaultValue(Boolean.valueOf(true));
        silentNotification.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

            final SettingsFragment this$0;

            public boolean onPreferenceChange(Preference preference, Object obj)
            {
                preferenceLogger.logAppPrefs(false);
                return true;
            }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
        });
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            generalPreferenceCategory.removePreference(timePickerPreference);
        } else
        {
            timePickerPreference.setDefaultValue(prefs.getString("notificationTime", getString(0x7f0804d8)));
            timePickerPreference.setSummary(timePickerPreference.getFormattedTime());
            timePickerPreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final SettingsFragment this$0;

                public boolean onPreferenceChange(Preference preference, Object obj)
                {
                    timePickerPreference.setSummary(Strings.toString(obj));
                    GrouponApplication.refreshLocalNotificationSetup(getActivity());
                    return true;
                }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
            });
        }
        if (Strings.equalsIgnoreCase(abTestService.getVariant("proximityNotifications1409USCA"), "on") && currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            proximityBasedNotifications.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final SettingsFragment this$0;

                public boolean onPreferenceChange(Preference preference, Object obj)
                {
                    boolean flag = ((Boolean)obj).booleanValue();
                    obj = logger;
                    if (flag)
                    {
                        preference = "user_enabled";
                    } else
                    {
                        preference = "user_disabled";
                    }
                    ((Logger) (obj)).logGeneralEvent("proximity_notification", "user_pref", preference, 0, Logger.NULL_NST_FIELD);
                    if (!flag)
                    {
                        geofenceSetter.clearGeofences();
                    }
                    return true;
                }

            
            {
                this$0 = SettingsFragment.this;
                super();
            }
            });
        } else
        {
            generalPreferenceCategory.removePreference(proximityBasedNotifications);
        }
        silentNotification.setDependency("dealNotification");
        if (!currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            timePickerPreference.setDependency("dealNotification");
        }
        if (!abTestService.isVariantEnabledAndUSCA("reportABug1409USCA", "on"))
        {
            advancedPreferenceCategory.removePreference(reportABugPreference);
            if (advancedPreferenceCategory.getPreferenceCount() == 0)
            {
                preferenceScreen.removePreference(advancedPreferenceCategory);
            }
        }
    }

    public void onStart()
    {
        int i = 1;
        super.onStart();
        boolean flag = prefs.getBoolean("dealNotification", true);
        Logger logger1 = logger;
        if (!flag)
        {
            i = 0;
        }
        logger1.logGeneralEvent("notifications_local_prefs_onStart", "", "", i, Logger.NULL_NST_FIELD);
    }






}
