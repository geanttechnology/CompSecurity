// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import com.amazon.gallery.thor.removablestorage.StorageLocationPreference;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            SDCardSettingsHelper

public class AndroidSDCardSettingsHelper
    implements SDCardSettingsHelper
{

    private final Context context;

    public AndroidSDCardSettingsHelper(Context context1)
    {
        context = context1;
    }

    public String getRootElementKey()
    {
        return "download_preference_switch_key";
    }

    public void setupSDCardSettings(PreferenceScreen preferencescreen, PreferenceGroup preferencegroup, RemovableStorageManager removablestoragemanager)
    {
        preferencegroup.setTitle(0x7f0e01e4);
        preferencegroup.setSummary(0x7f0e01e1);
        preferencegroup.setLayoutResource(0x7f0300c6);
        Preference preference = preferencescreen.findPreference(getRootElementKey());
        preferencescreen.removePreference(preference);
        preferencegroup.addPreference(preference);
        preferencescreen = (SwitchPreference)preferencegroup.findPreference(getRootElementKey());
        preferencescreen.setDefaultValue(Boolean.valueOf(removablestoragemanager.getStorageLocationPreference().equals(StorageLocationPreference.USE_REMOVABLE)));
        preferencescreen.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

            final AndroidSDCardSettingsHelper this$0;

            public boolean onPreferenceChange(Preference preference1, Object obj)
            {
                if (((Boolean)obj).booleanValue())
                {
                    preference1 = StorageLocationPreference.USE_REMOVABLE;
                } else
                {
                    preference1 = StorageLocationPreference.USE_INTERNAL;
                }
                context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putString("removable_storage_manager_storage_preference_key", preference1.toString()).apply();
                return true;
            }

            
            {
                this$0 = AndroidSDCardSettingsHelper.this;
                super();
            }
        });
    }

}
