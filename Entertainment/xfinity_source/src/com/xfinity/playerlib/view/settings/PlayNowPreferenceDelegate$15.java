// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.content.DialogInterface;
import android.preference.PreferenceScreen;
import com.xfinity.playerlib.downloads.RegisteredDevice;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate

class this._cls0
    implements android.content.ner
{

    final PlayNowPreferenceDelegate this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        if (PlayNowPreferenceDelegate.access$1100(PlayNowPreferenceDelegate.this) != null)
        {
            dialoginterface = PlayNowPreferenceDelegate.access$1100(PlayNowPreferenceDelegate.this).iterator();
            do
            {
                if (!dialoginterface.hasNext())
                {
                    break;
                }
                Object obj = (RegisteredDevice)dialoginterface.next();
                PreferenceScreen preferencescreen = PlayNowPreferenceDelegate.access$1300(PlayNowPreferenceDelegate.this);
                obj = preferencescreen.findPreference(((RegisteredDevice) (obj)).getDeviceId());
                if (obj != null)
                {
                    preferencescreen.removePreference(((android.preference.Preference) (obj)));
                }
            } while (true);
        }
        PlayNowPreferenceDelegate.access$2200(PlayNowPreferenceDelegate.this);
    }

    ()
    {
        this$0 = PlayNowPreferenceDelegate.this;
        super();
    }
}
