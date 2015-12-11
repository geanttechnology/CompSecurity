// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.app.Activity;
import android.content.res.Resources;
import android.preference.ListPreference;
import android.preference.Preference;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.config.PlayerConfiguration;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate

class this._cls0
    implements android.preference.eListener
{

    final PlayNowPreferenceDelegate this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        obj = (String)obj;
        ((ListPreference)preference).setValue(((String) (obj)));
        preference.setTitle(PlayNowPreferenceDelegate.access$200(PlayNowPreferenceDelegate.this).getResources().getString(com.xfinity.playerlib.loper_configuration, new Object[] {
            obj
        }));
        if (!((String) (obj)).equals(PlayNowPreferenceDelegate.access$500(PlayNowPreferenceDelegate.this).getString(com.xfinity.playerlib.configuration_default))) goto _L2; else goto _L1
_L1:
        PlayNowPreferenceDelegate.access$600(PlayNowPreferenceDelegate.this).setDeveloperConfiguration(null);
_L4:
        return false;
_L2:
        PlayerConfiguration playerconfiguration;
        preference = PlayNowPreferenceDelegate.access$700(PlayNowPreferenceDelegate.this).iterator();
        do
        {
            if (!preference.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            playerconfiguration = (PlayerConfiguration)preference.next();
        } while (!playerconfiguration.getClass().getSimpleName().equals(obj));
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        PlayNowPreferenceDelegate.access$600(PlayNowPreferenceDelegate.this).setDeveloperConfiguration(playerconfiguration);
        return false;
    }

    ()
    {
        this$0 = PlayNowPreferenceDelegate.this;
        super();
    }
}
