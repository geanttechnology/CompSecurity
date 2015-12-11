// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android708compatlib.view.preference;

import android.content.Context;
import android.content.res.Resources;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

// Referenced classes of package com.comcast.cim.cmasl.android708compatlib.view.preference:
//            CCPreviewPreference

public class CCPreferenceDelegate
{

    private final Context context;
    private final PreferenceActivity prefActivity;
    private final PreferenceFragment prefFrag;

    public CCPreferenceDelegate(Context context1, PreferenceActivity preferenceactivity, PreferenceFragment preferencefragment)
    {
        context = context1;
        prefActivity = preferenceactivity;
        prefFrag = preferencefragment;
    }

    protected Preference findPreference(int i)
    {
        return findPreference(context.getResources().getString(i));
    }

    protected Preference findPreference(String s)
    {
        if (prefActivity != null)
        {
            return prefActivity.findPreference(s);
        } else
        {
            return prefFrag.findPreference(s);
        }
    }

    public void setupPreferences(final CCPreviewPreference.CCPreferenceStore ccPrefStore, PreferenceScreen preferencescreen)
    {
        final CCPreviewPreference preview = (CCPreviewPreference)findPreference(com.comcast.cim.cmasl.android708compatlib.R.string.settings_key_cc_preview);
        preview.setCcPrefStore(ccPrefStore);
        ListPreference listpreference = (ListPreference)findPreference(com.comcast.cim.cmasl.android708compatlib.R.string.settings_key_cc_text_size);
        if (listpreference != null)
        {
            listpreference.setValueIndex(ccPrefStore.getCCTextSize());
            listpreference.setSummary(listpreference.getEntry());
            listpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final CCPreferenceDelegate this$0;
                final CCPreviewPreference.CCPreferenceStore val$ccPrefStore;
                final CCPreviewPreference val$preview;

                public boolean onPreferenceChange(Preference preference, Object obj)
                {
                    int i = Integer.valueOf((String)obj).intValue();
                    ccPrefStore.setCCTextSize(i);
                    ((ListPreference)preference).setValueIndex(i);
                    preference.setSummary(((ListPreference)preference).getEntry());
                    preview.updatePreviewText();
                    return false;
                }

            
            {
                this$0 = CCPreferenceDelegate.this;
                ccPrefStore = ccpreferencestore;
                preview = ccpreviewpreference;
                super();
            }
            });
        }
        listpreference = (ListPreference)findPreference(com.comcast.cim.cmasl.android708compatlib.R.string.settings_key_cc_typeface);
        if (listpreference != null)
        {
            listpreference.setValue(String.valueOf(ccPrefStore.getCCFontFamily()));
            listpreference.setSummary(listpreference.getEntry());
            listpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final CCPreferenceDelegate this$0;
                final CCPreviewPreference.CCPreferenceStore val$ccPrefStore;
                final CCPreviewPreference val$preview;

                public boolean onPreferenceChange(Preference preference, Object obj)
                {
                    int i = Integer.valueOf((String)obj).intValue();
                    ccPrefStore.setCCFontFamily(i);
                    ((ListPreference)preference).setValue((String)obj);
                    preference.setSummary(((ListPreference)preference).getEntry());
                    preview.updatePreviewText();
                    return false;
                }

            
            {
                this$0 = CCPreferenceDelegate.this;
                ccPrefStore = ccpreferencestore;
                preview = ccpreviewpreference;
                super();
            }
            });
        }
        listpreference = (ListPreference)findPreference(com.comcast.cim.cmasl.android708compatlib.R.string.settings_key_cc_text_color);
        if (listpreference != null)
        {
            listpreference.setValueIndex(ccPrefStore.getCCTextColor());
            listpreference.setSummary(listpreference.getEntry());
            listpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final CCPreferenceDelegate this$0;
                final CCPreviewPreference.CCPreferenceStore val$ccPrefStore;
                final CCPreviewPreference val$preview;

                public boolean onPreferenceChange(Preference preference, Object obj)
                {
                    int i = Integer.valueOf((String)obj).intValue();
                    ccPrefStore.setCCTextColor(i);
                    ((ListPreference)preference).setValueIndex(i);
                    preference.setSummary(((ListPreference)preference).getEntry());
                    preview.updatePreviewText();
                    return false;
                }

            
            {
                this$0 = CCPreferenceDelegate.this;
                ccPrefStore = ccpreferencestore;
                preview = ccpreviewpreference;
                super();
            }
            });
        }
        listpreference = (ListPreference)findPreference(com.comcast.cim.cmasl.android708compatlib.R.string.settings_key_cc_edge_type);
        if (listpreference != null)
        {
            listpreference.setValue(String.valueOf(ccPrefStore.getCCEdgeType()));
            listpreference.setSummary(listpreference.getEntry());
            listpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final CCPreferenceDelegate this$0;
                final CCPreviewPreference.CCPreferenceStore val$ccPrefStore;
                final CCPreviewPreference val$preview;

                public boolean onPreferenceChange(Preference preference, Object obj)
                {
                    obj = (String)obj;
                    int i = Integer.valueOf(((String) (obj))).intValue();
                    ccPrefStore.setCCEdgeType(i);
                    ((ListPreference)preference).setValue(((String) (obj)));
                    preference.setSummary(((ListPreference)preference).getEntry());
                    preview.updatePreviewText();
                    return false;
                }

            
            {
                this$0 = CCPreferenceDelegate.this;
                ccPrefStore = ccpreferencestore;
                preview = ccpreviewpreference;
                super();
            }
            });
        }
        listpreference = (ListPreference)findPreference(com.comcast.cim.cmasl.android708compatlib.R.string.settings_key_cc_edge_color);
        if (listpreference != null)
        {
            listpreference.setValueIndex(ccPrefStore.getCCEdgeColor());
            listpreference.setSummary(listpreference.getEntry());
            listpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final CCPreferenceDelegate this$0;
                final CCPreviewPreference.CCPreferenceStore val$ccPrefStore;
                final CCPreviewPreference val$preview;

                public boolean onPreferenceChange(Preference preference, Object obj)
                {
                    int i = Integer.valueOf((String)obj).intValue();
                    ccPrefStore.setCCEdgeColor(i);
                    ((ListPreference)preference).setValueIndex(i);
                    preference.setSummary(((ListPreference)preference).getEntry());
                    preview.updatePreviewText();
                    return false;
                }

            
            {
                this$0 = CCPreferenceDelegate.this;
                ccPrefStore = ccpreferencestore;
                preview = ccpreviewpreference;
                super();
            }
            });
        }
        listpreference = (ListPreference)findPreference(com.comcast.cim.cmasl.android708compatlib.R.string.settings_key_cc_background_color);
        if (listpreference != null)
        {
            listpreference.setValueIndex(ccPrefStore.getCCBackgroundColor());
            listpreference.setSummary(listpreference.getEntry());
            listpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final CCPreferenceDelegate this$0;
                final CCPreviewPreference.CCPreferenceStore val$ccPrefStore;
                final CCPreviewPreference val$preview;

                public boolean onPreferenceChange(Preference preference, Object obj)
                {
                    int i = Integer.valueOf((String)obj).intValue();
                    ccPrefStore.setCCBackgroundColor(i);
                    ((ListPreference)preference).setValueIndex(i);
                    preference.setSummary(((ListPreference)preference).getEntry());
                    preview.updatePreviewText();
                    return false;
                }

            
            {
                this$0 = CCPreferenceDelegate.this;
                ccPrefStore = ccpreferencestore;
                preview = ccpreviewpreference;
                super();
            }
            });
        }
        listpreference = (ListPreference)findPreference(com.comcast.cim.cmasl.android708compatlib.R.string.settings_key_cc_background_opacity);
        if (listpreference != null)
        {
            listpreference.setValue(String.valueOf(ccPrefStore.getCCBackgroundOpacity()));
            listpreference.setSummary((new StringBuilder()).append(listpreference.getEntry()).append("%").toString());
            listpreference.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

                final CCPreferenceDelegate this$0;
                final CCPreviewPreference.CCPreferenceStore val$ccPrefStore;
                final CCPreviewPreference val$preview;

                public boolean onPreferenceChange(Preference preference, Object obj)
                {
                    obj = (String)obj;
                    int i = Integer.valueOf(((String) (obj))).intValue();
                    ccPrefStore.setCCBackgroundOpacity(i);
                    ((ListPreference)preference).setValue(((String) (obj)));
                    preference.setSummary((new StringBuilder()).append(((ListPreference)preference).getEntry()).append("%").toString());
                    preview.updatePreviewText();
                    return false;
                }

            
            {
                this$0 = CCPreferenceDelegate.this;
                ccPrefStore = ccpreferencestore;
                preview = ccpreviewpreference;
                super();
            }
            });
        }
        ccPrefStore = findPreference(com.comcast.cim.cmasl.android708compatlib.R.string.settings_key_cc_shortcut);
        if (ccPrefStore != null && android.os.Build.VERSION.SDK_INT < 19)
        {
            preferencescreen.removePreference(ccPrefStore);
        }
    }
}
