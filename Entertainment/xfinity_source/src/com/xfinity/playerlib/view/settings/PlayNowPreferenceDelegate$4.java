// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate

class val.settings
    implements android.preference.eListener
{

    final PlayNowPreferenceDelegate this$0;
    final PlayerUserSettings val$settings;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = (Boolean)obj;
        ((CheckBoxPreference)preference).setChecked(((Boolean) (obj)).booleanValue());
        val$settings.setWantsVolumeControl(((Boolean) (obj)).booleanValue());
        return false;
    }

    ()
    {
        this$0 = final_playnowpreferencedelegate;
        val$settings = PlayerUserSettings.this;
        super();
    }
}
