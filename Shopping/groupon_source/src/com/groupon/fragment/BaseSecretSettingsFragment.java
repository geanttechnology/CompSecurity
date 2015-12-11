// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import java.util.HashMap;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

public abstract class BaseSecretSettingsFragment extends PreferenceFragment
{
    private class EditTextPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final EditTextPreference pref;
        private final String preferenceKey;
        private final String summaryWhenEmpty;
        final BaseSecretSettingsFragment this$0;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            if (Strings.isEmpty(obj))
            {
                pref.setSummary(summaryWhenEmpty);
                ((SharedPreferences)prefs.get()).edit().remove(preferenceKey).apply();
            } else
            {
                pref.setSummary(Strings.toString(obj));
                ((SharedPreferences)prefs.get()).edit().putString(preferenceKey, Strings.toString(obj)).apply();
            }
            return true;
        }

        public EditTextPreferenceChangeListener(EditTextPreference edittextpreference, String s, String s1)
        {
            this$0 = BaseSecretSettingsFragment.this;
            super();
            pref = edittextpreference;
            summaryWhenEmpty = s;
            preferenceKey = s1;
        }
    }

    private class ListPreferenceChangeListener
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        private final ListPreference pref;
        private final String preferenceKey;
        final BaseSecretSettingsFragment this$0;
        private final HashMap valuesToNames;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            ((SharedPreferences)prefs.get()).edit().putString(preferenceKey, Strings.toString(obj)).apply();
            pref.setSummary((CharSequence)valuesToNames.get(obj));
            return true;
        }

        public ListPreferenceChangeListener(String s, ListPreference listpreference, HashMap hashmap)
        {
            this$0 = BaseSecretSettingsFragment.this;
            super();
            preferenceKey = s;
            pref = listpreference;
            valuesToNames = hashmap;
        }
    }


    public static final String ENABLE_DEBUGGABLE_WEBVIEWS = "enableDebuggableWebViews";
    private static final String PREFERENCE_NAME = "default";
    protected Lazy grouponOkHttpClient;
    protected Lazy loginService;
    protected Lazy prefs;

    public BaseSecretSettingsFragment()
    {
    }

    protected EditTextPreference generateEditTextPreference(String s, String s1, String s2)
    {
        return generateEditTextPreference(s, s1, s2, "");
    }

    protected EditTextPreference generateEditTextPreference(String s, String s1, String s2, String s3)
    {
        EditTextPreference edittextpreference = new EditTextPreference(getActivity());
        edittextpreference.setTitle(s1);
        s1 = ((SharedPreferences)prefs.get()).getString(s, s3);
        if (!Strings.notEmpty(s1))
        {
            s1 = s2;
        }
        edittextpreference.setSummary(s1);
        edittextpreference.setOnPreferenceChangeListener(new EditTextPreferenceChangeListener(edittextpreference, s2, s));
        return edittextpreference;
    }

    protected ListPreference generateListPreference(String s, String s1, String as[], String as1[])
    {
        HashMap hashmap = new HashMap();
        for (int i = 0; i < as.length; i++)
        {
            hashmap.put(as1[i], as[i]);
        }

        ListPreference listpreference = new ListPreference(getActivity());
        listpreference.setTitle(s);
        listpreference.setSummary((CharSequence)hashmap.get(((SharedPreferences)prefs.get()).getString(s1, as1[0])));
        listpreference.setEntries(as);
        listpreference.setEntryValues(as1);
        listpreference.setOnPreferenceChangeListener(new ListPreferenceChangeListener(s1, listpreference, hashmap));
        return listpreference;
    }

    public void init()
    {
        prefs = new Lazy(getActivity()) {

            final BaseSecretSettingsFragment this$0;

            
            {
                this$0 = BaseSecretSettingsFragment.this;
                super(context);
            }
        };
        loginService = new Lazy(getActivity()) {

            final BaseSecretSettingsFragment this$0;

            
            {
                this$0 = BaseSecretSettingsFragment.this;
                super(context);
            }
        };
        grouponOkHttpClient = new Lazy(getActivity()) {

            final BaseSecretSettingsFragment this$0;

            
            {
                this$0 = BaseSecretSettingsFragment.this;
                super(context);
            }
        };
    }

    protected CheckBoxPreference newCheckBox(String s, String s1, Object obj)
    {
        CheckBoxPreference checkboxpreference = new CheckBoxPreference(getActivity());
        checkboxpreference.setKey(s);
        checkboxpreference.setTitle(s1);
        checkboxpreference.setDefaultValue(obj);
        return checkboxpreference;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getPreferenceManager().setSharedPreferencesName("default");
        addPreferencesFromResource(0x7f060003);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
    }
}
