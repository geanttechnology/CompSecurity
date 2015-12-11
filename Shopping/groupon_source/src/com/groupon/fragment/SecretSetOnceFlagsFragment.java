// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.groupon.provider.LocalizedSharedPreferencesProvider;
import com.groupon.service.ShippingService;
import com.groupon.util.ArraySharedPreferences;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            BaseSecretSettingsFragment

public class SecretSetOnceFlagsFragment extends BaseSecretSettingsFragment
{
    private class ClearMessagesPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SecretSetOnceFlagsFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            if (!((Boolean)obj).booleanValue())
            {
                ((LocalizedSharedPreferencesProvider)locationPreferenceManager.get()).get().edit().remove("inAppMessageHistory").apply();
            }
            preference.setEnabled(((LocalizedSharedPreferencesProvider)locationPreferenceManager.get()).get().contains("inAppMessageHistory"));
            return true;
        }

        private ClearMessagesPreferenceChangeListener()
        {
            this$0 = SecretSetOnceFlagsFragment.this;
            super();
        }

    }

    private class ClearShippingPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final SecretSetOnceFlagsFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            if (!((Boolean)obj).booleanValue())
            {
                ((ShippingService)shippingService.get()).clearStore();
            }
            preference.setEnabled(((ShippingService)shippingService.get()).isStored());
            return true;
        }

        private ClearShippingPreferenceChangeListener()
        {
            this$0 = SecretSetOnceFlagsFragment.this;
            super();
        }

    }


    public static final String TAG = com/groupon/fragment/SecretSetOnceFlagsFragment.getName();
    private Lazy locationPreferenceManager;
    private Lazy shippingService;

    public SecretSetOnceFlagsFragment()
    {
    }

    public void init()
    {
        super.init();
        shippingService = new Lazy(getActivity()) {

            final SecretSetOnceFlagsFragment this$0;

            
            {
                this$0 = SecretSetOnceFlagsFragment.this;
                super(context);
            }
        };
        locationPreferenceManager = new Lazy(getActivity()) {

            final SecretSetOnceFlagsFragment this$0;

            
            {
                this$0 = SecretSetOnceFlagsFragment.this;
                super(context);
            }
        };
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getPreferenceScreen().addPreference(newCheckBox("hasSeenWidgetDialog", "Widget Up Sell Prompt", Boolean.valueOf(false)));
        getPreferenceScreen().addPreference(newCheckBox("widgetHasBeenInstalled", "Widget Installed", Boolean.valueOf(false)));
        getPreferenceScreen().addPreference(newCheckBox("optInViaWidget", "Opt In Via Widget", Boolean.valueOf(false)));
        bundle = new CheckBoxPreference(getActivity());
        boolean flag = ((ShippingService)shippingService.get()).isStored();
        ((SharedPreferences)prefs.get()).edit().putBoolean("fakeShippingAddress", flag);
        bundle.setKey("fakeShippingAddress");
        bundle.setTitle("Shipping Address");
        bundle.setDefaultValue(Boolean.valueOf(flag));
        bundle.setChecked(flag);
        bundle.setEnabled(flag);
        bundle.setOnPreferenceChangeListener(new ClearShippingPreferenceChangeListener());
        getPreferenceScreen().addPreference(bundle);
        bundle = new CheckBoxPreference(getActivity());
        flag = ((LocalizedSharedPreferencesProvider)locationPreferenceManager.get()).get().contains("inAppMessageHistory");
        ((SharedPreferences)prefs.get()).edit().putBoolean("fakeMessages", flag);
        bundle.setKey("fakeShippingAddress");
        bundle.setTitle("Messages History");
        bundle.setSummary("Must restart after clearing");
        bundle.setDefaultValue(Boolean.valueOf(flag));
        bundle.setChecked(flag);
        bundle.setEnabled(flag);
        bundle.setOnPreferenceChangeListener(new ClearMessagesPreferenceChangeListener());
        getPreferenceScreen().addPreference(bundle);
    }



}
