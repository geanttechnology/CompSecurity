// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.preference.Preference;
import com.ebay.common.Preferences;
import com.ebay.mobile.activities.ShowFileWebViewActivity;
import com.ebay.nautilus.shell.app.BasePreferenceActivity;

// Referenced classes of package com.ebay.mobile.settings:
//            AboutPreferencesFragment

class val.prefs
    implements android.preference.kListener
{

    final AboutPreferencesFragment this$0;
    final BasePreferenceActivity val$activity;
    final Preferences val$prefs;

    public boolean onPreferenceClick(Preference preference)
    {
        ShowFileWebViewActivity.startActivity(val$activity, val$prefs.getLicenseUrl(), Integer.valueOf(0x7f070116), "LegalInfo", Boolean.valueOf(false));
        return true;
    }

    ner()
    {
        this$0 = final_aboutpreferencesfragment;
        val$activity = basepreferenceactivity;
        val$prefs = Preferences.this;
        super();
    }
}
