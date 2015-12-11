// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Switch;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.PreferencesActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.preference.LongSummaryPreference;
import com.ebay.mobile.preference.TimePreference;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.settings:
//            NotificationPreferencesFragmentBase

public class NotificationPreferencesFragment extends NotificationPreferencesFragmentBase
    implements com.ebay.mobile.util.ContentSyncManager.ContentSync
{

    private static final String KEY_QUIET_END = "QUIET_END";
    private static final String KEY_QUIET_START = "QUIET_START";
    public static final String KEY_QUIET_TIMES = "QuietTimes";
    public static final String KEY_QUIET_TIMES_SUMMARY = "QuietTimesSummary";
    private static final String PREFERENCE_GROUP_BUYING = "notifications_group_buying";
    private static final String PREFERENCE_GROUP_GENERAL = "notifications_group_general";
    private static final String PREFERENCE_GROUP_SELLING = "notifications_group_selling";
    private static final String PREFERENCE_GROUP_SOUNDS = "notifications_group_customize_sounds";
    public static final String SYNC_HIDE_ALL_NOTIFICATIONS = "NotificationPreferences.HideAllNotifications";
    public static final String SYNC_QUIET_END = "QUIET_END";
    public static final String SYNC_QUIET_START = "QUIET_START";
    public static final String SYNC_QUIET_TIMES_DISABLED = "NotificationPreferences.QuietTimesDisabled";
    public static final String SYNC_QUIET_TIMES_ENABLED = "NotificationPreferences.QuietTimesEnabled";
    public static final String SYNC_SHOW_ALL_NOTIFICATIONS = "NotificationPreferences.ShowAllNotifications";
    private Preference buyingNotificationsPreference;
    private Preference customizeSoundsPreference;
    private Preference generalNotificationsPreference;
    private com.ebay.mobile.activities.PreferencesActivity.NotificationSwitchController notificationSwitchController;
    private SwitchPreference quietTimes;
    private TimePreference quietTimesEndPreference;
    private TimePreference quietTimesStartPreference;
    private LongSummaryPreference quietTimesSummary;
    private Preference sellingNotificationsPreference;

    public NotificationPreferencesFragment()
    {
    }

    private String convertMilitaryTimeToDisplay(String s)
    {
        Object obj;
        try
        {
            obj = Calendar.getInstance();
            ((Calendar) (obj)).set(11, Integer.parseInt(s.substring(0, 2)));
            ((Calendar) (obj)).set(12, Integer.parseInt(s.substring(2)));
            obj = (new SimpleDateFormat("h:mm a", Locale.getDefault())).format(((Calendar) (obj)).getTime());
        }
        catch (Exception exception)
        {
            Log.e(getActivity().getLocalClassName(), "convertMilitaryTimeToDisplay exception", exception);
            return s;
        }
        return ((String) (obj));
    }

    private String convertMilitaryTimeToMilitaryDisplay(String s)
    {
        if (s == null || s.length() != 4)
        {
            return "";
        } else
        {
            return (new StringBuilder()).append(s.substring(0, 2)).append(":").append(s.substring(2)).toString();
        }
    }

    private boolean getDisplayTimeMilitary()
    {
        return "24".equals(android.provider.Settings.System.getString(getActivity().getContentResolver(), "time_12_24"));
    }

    private void resumeUi()
    {
        userId = MyApp.getPrefs().getCurrentUser();
        if (TextUtils.isEmpty(userId))
        {
            getActivity().finish();
        } else
        {
            PreferencesActivity preferencesactivity = (PreferencesActivity)getActivity();
            if (!preferencesactivity.isDualPane())
            {
                ActionBar actionbar = preferencesactivity.getSupportActionBar();
                Switch switch1 = new Switch(preferencesactivity);
                notificationSwitchController = preferencesactivity.newNotificationSwitchController(switch1);
                actionbar.setDisplayOptions(16, 16);
                android.support.v7.app.ActionBar.LayoutParams layoutparams = new android.support.v7.app.ActionBar.LayoutParams(-2, -2, 21);
                TypedArray typedarray = getActivity().obtainStyledAttributes(new int[] {
                    0x1010063
                });
                layoutparams.rightMargin = typedarray.getDimensionPixelSize(0, 0);
                typedarray.recycle();
                actionbar.setCustomView(switch1, layoutparams);
            }
            boolean flag = preferencesactivity.getNotificationsEnabled();
            toggleAllItems(flag);
            if (DeviceConfiguration.getAsync().get(DcsBoolean.NotificationQuietTimes))
            {
                PreferenceScreen preferencescreen = getPreferenceScreen();
                setQuietTimesSummary(notificationPrefs);
                if (notificationPrefs.isUserQuietTimeEnabled(userId) && flag)
                {
                    if (findPreference("QuietTimes") == null)
                    {
                        preferencescreen.addPreference(quietTimes);
                        preferencescreen.addPreference(quietTimesSummary);
                    }
                    onEnableQuietTimesPreference();
                    quietTimes.setChecked(true);
                    return;
                } else
                {
                    preferencescreen.removePreference(quietTimesStartPreference);
                    preferencescreen.removePreference(quietTimesEndPreference);
                    quietTimes.setChecked(false);
                    return;
                }
            }
        }
    }

    private void setQuietTimesSummary(NotificationPreferenceManager notificationpreferencemanager)
    {
        if (!notificationpreferencemanager.isUserQuietTimeEnabled(userId))
        {
            quietTimesSummary.setSummary(0x7f0708cb);
            return;
        }
        boolean flag = getDisplayTimeMilitary();
        String s1 = notificationpreferencemanager.getQuietStartTimeLocal(userId);
        String s = s1;
        if (s1 == null)
        {
            s = "2200";
            notificationpreferencemanager.setUserQuietTimeStart(userId, "2200");
        }
        String s2;
        if (flag)
        {
            s = convertMilitaryTimeToMilitaryDisplay(s);
        } else
        {
            s = convertMilitaryTimeToDisplay(s);
        }
        s2 = notificationpreferencemanager.getQuietEndTimeLocal(userId);
        s1 = s2;
        if (s2 == null)
        {
            s1 = "0800";
            notificationpreferencemanager.setUserQuietTimeEnd(userId, "0800");
        }
        if (flag)
        {
            notificationpreferencemanager = convertMilitaryTimeToMilitaryDisplay(s1);
        } else
        {
            notificationpreferencemanager = convertMilitaryTimeToDisplay(s1);
        }
        quietTimesSummary.setSummary(getResources().getString(0x7f0708ca, new Object[] {
            s, notificationpreferencemanager
        }));
        quietTimesStartPreference.setSummary(s);
        quietTimesEndPreference.setSummary(notificationpreferencemanager);
    }

    private void toggleAllItems(boolean flag)
    {
        buyingNotificationsPreference.setEnabled(flag);
        sellingNotificationsPreference.setEnabled(flag);
        if (generalNotificationsPreference != null)
        {
            generalNotificationsPreference.setEnabled(flag);
        }
        if (customizeSoundsPreference != null)
        {
            customizeSoundsPreference.setEnabled(flag);
        }
        quietTimes.setEnabled(flag);
        quietTimesSummary.setEnabled(flag);
        quietTimesStartPreference.setEnabled(flag);
        quietTimesEndPreference.setEnabled(flag);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        ContentSyncManager.register(this, new String[] {
            "NotificationPreferences.ShowAllNotifications", "NotificationPreferences.HideAllNotifications", "NotificationPreferences.QuietTimesEnabled", "NotificationPreferences.QuietTimesDisabled"
        });
        if (DeviceConfiguration.getAsync().get(DcsBoolean.NotificationQuietTimes))
        {
            ContentSyncManager.register(this, new String[] {
                "QUIET_START", "QUIET_END"
            });
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f050006);
        buyingNotificationsPreference = findPreference("notifications_group_buying");
        sellingNotificationsPreference = findPreference("notifications_group_selling");
        generalNotificationsPreference = findPreference("notifications_group_general");
        customizeSoundsPreference = findPreference("notifications_group_customize_sounds");
        bundle = getPreferenceScreen();
        if (!EbayUtil.isPushActive(getActivity(), userId, "AEAPP"))
        {
            bundle.removePreference(generalNotificationsPreference);
            generalNotificationsPreference = null;
        }
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (!deviceconfiguration.get(DcsBoolean.NotificationsToneMutable))
        {
            bundle.removePreference(customizeSoundsPreference);
            customizeSoundsPreference = null;
        }
        quietTimes = (SwitchPreference)findPreference("QuietTimes");
        quietTimesSummary = (LongSummaryPreference)findPreference("QuietTimesSummary");
        quietTimesStartPreference = (TimePreference)findPreference("QUIET_START");
        quietTimesEndPreference = (TimePreference)findPreference("QUIET_END");
        if (!deviceconfiguration.get(DcsBoolean.NotificationQuietTimes))
        {
            bundle = getPreferenceScreen();
            bundle.removePreference(quietTimes);
            bundle.removePreference(quietTimesSummary);
            bundle.removePreference(quietTimesStartPreference);
            bundle.removePreference(quietTimesEndPreference);
            return;
        } else
        {
            quietTimes.setOnPreferenceChangeListener((PreferencesActivity)getActivity());
            quietTimesStartPreference.setStartTime(true);
            quietTimesEndPreference.setStartTime(false);
            return;
        }
    }

    public void onDestroyView()
    {
        notificationSwitchController = null;
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        ContentSyncManager.unregister(this, new String[] {
            "NotificationPreferences.ShowAllNotifications", "NotificationPreferences.HideAllNotifications", "NotificationPreferences.QuietTimesEnabled", "NotificationPreferences.QuietTimesDisabled"
        });
        if (DeviceConfiguration.getAsync().get(DcsBoolean.NotificationQuietTimes))
        {
            ContentSyncManager.unregister(this, new String[] {
                "QUIET_START", "QUIET_END"
            });
        }
    }

    protected void onDisableQuietTimesPreference()
    {
        PreferenceScreen preferencescreen = getPreferenceScreen();
        preferencescreen.removePreference(quietTimesStartPreference);
        preferencescreen.removePreference(quietTimesEndPreference);
        setQuietTimesSummary(notificationPrefs);
    }

    protected void onEnableQuietTimesPreference()
    {
        PreferenceScreen preferencescreen = getPreferenceScreen();
        if (findPreference("QUIET_START") == null)
        {
            preferencescreen.addPreference(quietTimesStartPreference);
        }
        if (findPreference("QUIET_END") == null)
        {
            preferencescreen.addPreference(quietTimesEndPreference);
        }
        setQuietTimesSummary(notificationPrefs);
    }

    public void onResume()
    {
        super.onResume();
        resumeUi();
        TrackingData trackingdata = new TrackingData("SettingsNotifications", TrackingType.PAGE_IMPRESSION);
        trackingdata.addKeyValuePair("apn", notificationPrefs.getNotificationEnabledStringForTracking(userId));
        trackingdata.send(getActivity());
    }

    public void updateContent(String s, Object obj)
    {
        if ("NotificationPreferences.ShowAllNotifications".equals(s))
        {
            toggleAllItems(true);
        } else
        {
            if ("NotificationPreferences.HideAllNotifications".equals(s))
            {
                toggleAllItems(false);
                return;
            }
            if ("NotificationPreferences.QuietTimesEnabled".equals(s))
            {
                onEnableQuietTimesPreference();
                return;
            }
            if ("NotificationPreferences.QuietTimesDisabled".equals(s))
            {
                onDisableQuietTimesPreference();
                return;
            }
            if ("QUIET_START".equals(s))
            {
                setQuietTimesSummary(new NotificationPreferenceManager(getActivity()));
                return;
            }
            if ("QUIET_END".equals(s))
            {
                setQuietTimesSummary(new NotificationPreferenceManager(getActivity()));
                return;
            }
        }
    }
}
