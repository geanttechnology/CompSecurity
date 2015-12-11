// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.xfinity.playerlib.config.PlayerConfiguration;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate

class this._cls0
    implements android.preference.eListener
{

    final PlayNowPreferenceDelegate this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = (Boolean)obj;
        ((CheckBoxPreference)preference).setChecked(((Boolean) (obj)).booleanValue());
        PlayNowPreferenceDelegate.access$600(PlayNowPreferenceDelegate.this).setDarkStreamsEnabled(((Boolean) (obj)));
        PlayNowPreferenceDelegate.access$800(PlayNowPreferenceDelegate.this).clearCachedResult();
        return false;
    }

    ()
    {
        this$0 = PlayNowPreferenceDelegate.this;
        super();
    }
}
