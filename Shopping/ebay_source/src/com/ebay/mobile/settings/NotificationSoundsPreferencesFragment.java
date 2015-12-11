// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

public class NotificationSoundsPreferencesFragment extends PreferenceFragment
    implements android.preference.Preference.OnPreferenceClickListener
{

    private static final String PREFERENCE_NOTIFICATION_BUYING_TONE = "buy_uri";
    private static final String PREFERENCE_NOTIFICATION_GENERAL_TONE = "generaltone_uri";
    private static final String PREFERENCE_NOTIFICATION_ITEM_SOLD_TONE = "itemsold_uri";
    private static final String PREFERENCE_NOTIFICATION_SAVED_SEARCH_TONE = "savedsearch_uri";
    private static final int REQUEST_BUYING_TONE = 4;
    private static final int REQUEST_GENERAL_TONE = 1;
    private static final int REQUEST_ITEM_SOLD_TONE = 2;
    private static final int REQUEST_SAVED_SEARCH_TONE = 3;
    private static String buyingDefault;
    private static String custom;
    private static String generalDefault;
    private static String savedSearchDefault;
    private static String sellerDefault;
    private Preferences prefs;
    private Preference toneBuying;
    private Preference toneGeneral;
    private Preference toneSavedSearch;
    private Preference toneSeller;

    public NotificationSoundsPreferencesFragment()
    {
    }

    private String getToneName(Uri uri, Preference preference)
    {
        if (uri == null)
        {
            uri = "";
        } else
        {
            if (uri.toString().equals(prefs.getNotificationsGeneralDefaultTone()) && preference == toneGeneral)
            {
                return generalDefault;
            }
            if (uri.toString().equals(prefs.getNotificationsSellingDefaultTone()) || uri.toString().equals("android.resource://com.ebay.mobile/2131099651"))
            {
                return sellerDefault;
            }
            if (uri.toString().equals(prefs.getNotificationsSavedSearchDefaultTone()) || uri.toString().equals("android.resource://com.ebay.mobile/2131099652"))
            {
                return savedSearchDefault;
            }
            if (uri.toString().equals(prefs.getNotificationsBuyingDefaultTone()))
            {
                return buyingDefault;
            }
            if (uri.toString().equals("android.resource://com.ebay.mobile/2131099650"))
            {
                if (preference == toneBuying)
                {
                    return buyingDefault;
                }
                if (preference == toneGeneral)
                {
                    return generalDefault;
                }
            }
            preference = getActivity();
            uri = RingtoneManager.getRingtone(preference, uri);
            String s = custom;
            if (uri != null)
            {
                preference = uri.getTitle(preference);
                uri = preference;
                if (preference == null)
                {
                    return custom;
                }
            } else
            {
                return custom;
            }
        }
        return uri;
    }

    private void hideTones()
    {
        PreferenceScreen preferencescreen = getPreferenceScreen();
        preferencescreen.removePreference(toneGeneral);
        preferencescreen.removePreference(toneSeller);
        preferencescreen.removePreference(toneSavedSearch);
        preferencescreen.removePreference(toneBuying);
    }

    private void setToneSummaries()
    {
        toneGeneral.setSummary(getToneName(Uri.parse(prefs.getNotificationsGeneralTone()), toneGeneral));
        toneSeller.setSummary(getToneName(Uri.parse(prefs.getNotificationsSellingTone()), toneSeller));
        toneSavedSearch.setSummary(getToneName(Uri.parse(prefs.getNotificationsSavedSearchTone()), toneSavedSearch));
        toneBuying.setSummary(getToneName(Uri.parse(prefs.getNotificationsBuyingTone()), toneBuying));
    }

    private void showTones()
    {
        PreferenceScreen preferencescreen = getPreferenceScreen();
        preferencescreen.addPreference(toneGeneral);
        preferencescreen.addPreference(toneSeller);
        preferencescreen.addPreference(toneSavedSearch);
        preferencescreen.addPreference(toneBuying);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j != -1) goto _L2; else goto _L1
_L1:
        intent = (Uri)intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
        i;
        JVM INSTR tableswitch 1 4: default 48
    //                   1 49
    //                   2 78
    //                   3 107
    //                   4 136;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        return;
_L3:
        String s = getToneName(intent, toneGeneral);
        prefs.setNotificationsGeneralTone(intent);
        toneGeneral.setSummary(s);
        return;
_L4:
        String s1 = getToneName(intent, toneSeller);
        prefs.setNotificationsSellingTone(intent);
        toneSeller.setSummary(s1);
        return;
_L5:
        String s2 = getToneName(intent, toneSavedSearch);
        prefs.setNotificationsSavedSearchTone(intent);
        toneSavedSearch.setSummary(s2);
        return;
_L6:
        String s3 = getToneName(intent, toneBuying);
        prefs.setNotificationsBuyingTone(intent);
        toneBuying.setSummary(s3);
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f050007);
        toneGeneral = findPreference("generaltone_uri");
        toneSeller = findPreference("itemsold_uri");
        toneSavedSearch = findPreference("savedsearch_uri");
        toneBuying = findPreference("buy_uri");
        if (DeviceConfiguration.getAsync().get(DcsBoolean.NotificationsToneMutable))
        {
            toneGeneral.setOnPreferenceClickListener(this);
            toneSeller.setOnPreferenceClickListener(this);
            toneSavedSearch.setOnPreferenceClickListener(this);
            toneBuying.setOnPreferenceClickListener(this);
            custom = getString(0x7f07027a);
            generalDefault = getString(0x7f070b77);
            sellerDefault = generalDefault;
            savedSearchDefault = generalDefault;
            buyingDefault = generalDefault;
        } else
        {
            bundle = getPreferenceScreen();
            bundle.removePreference(toneGeneral);
            bundle.removePreference(toneSeller);
            bundle.removePreference(toneSavedSearch);
            bundle.removePreference(toneBuying);
        }
        prefs = MyApp.getPrefs();
    }

    public boolean onPreferenceClick(Preference preference)
    {
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.NotificationsToneMutable)) goto _L2; else goto _L1
_L1:
        Intent intent;
        int i;
        intent = new Intent("android.intent.action.RINGTONE_PICKER");
        intent.putExtra("android.intent.extra.ringtone.TYPE", 2);
        intent.putExtra("android.intent.extra.ringtone.TITLE", getString(0x7f07099e));
        i = 1;
        if (!"generaltone_uri".equals(preference.getKey())) goto _L4; else goto _L3
_L3:
        intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Uri.parse(prefs.getNotificationsGeneralDefaultTone()));
        intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(prefs.getNotificationsGeneralTone()));
_L5:
        startActivityForResult(intent, i);
        return true;
_L4:
        if ("itemsold_uri".equals(preference.getKey()))
        {
            intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Uri.parse(prefs.getNotificationsSellingDefaultTone()));
            intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(prefs.getNotificationsSellingTone()));
            i = 2;
        } else
        if ("savedsearch_uri".equals(preference.getKey()))
        {
            intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Uri.parse(prefs.getNotificationsSavedSearchDefaultTone()));
            intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(prefs.getNotificationsSavedSearchTone()));
            i = 3;
        } else
        if ("buy_uri".equals(preference.getKey()))
        {
            intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Uri.parse(prefs.getNotificationsBuyingDefaultTone()));
            intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(prefs.getNotificationsBuyingTone()));
            i = 4;
        }
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    public void onResume()
    {
        super.onResume();
        resumeUi();
    }

    public void resumeUi()
    {
label0:
        {
            if (DeviceConfiguration.getAsync().get(DcsBoolean.NotificationsToneMutable))
            {
                if (!prefs.isNotificationSoundEnabled())
                {
                    break label0;
                }
                showTones();
                setToneSummaries();
            }
            return;
        }
        hideTones();
    }
}
