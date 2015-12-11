// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import com.xfinity.playerlib.config.PlayerConfiguration;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate

class val.darkStreams
    implements android.preference.eListener
{

    final PlayNowPreferenceDelegate this$0;
    final CheckBoxPreference val$darkStreams;
    final ListPreference val$devConfiguration;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = (Boolean)obj;
        ((CheckBoxPreference)preference).setChecked(((Boolean) (obj)).booleanValue());
        PlayNowPreferenceDelegate.access$600(PlayNowPreferenceDelegate.this).setDeveloperModeEnabled(((Boolean) (obj)).booleanValue());
        val$devConfiguration.setEnabled(PlayNowPreferenceDelegate.access$600(PlayNowPreferenceDelegate.this).isDeveloperModeEnabled());
        val$darkStreams.setEnabled(PlayNowPreferenceDelegate.access$600(PlayNowPreferenceDelegate.this).isDeveloperModeEnabled());
        return false;
    }

    ()
    {
        this$0 = final_playnowpreferencedelegate;
        val$devConfiguration = listpreference;
        val$darkStreams = CheckBoxPreference.this;
        super();
    }
}
