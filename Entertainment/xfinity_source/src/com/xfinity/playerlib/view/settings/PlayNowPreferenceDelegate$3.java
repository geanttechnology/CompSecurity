// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.preference.Preference;
import com.comcast.cim.downloads.DownloadServiceException;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
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
        preference = Boolean.valueOf(obj.toString());
        obj = PlayNowPreferenceDelegate.access$400(PlayNowPreferenceDelegate.this);
        double d;
        if (preference.booleanValue())
        {
            d = -1D;
        } else
        {
            d = 0.0D;
        }
        try
        {
            ((PlayerDownloadServiceManager) (obj)).setCellularDataThreshold(d);
        }
        // Misplaced declaration of an exception variable
        catch (Preference preference)
        {
            PlayNowPreferenceDelegate.access$400(PlayNowPreferenceDelegate.this).showCrashDialog(PlayNowPreferenceDelegate.access$200(PlayNowPreferenceDelegate.this), preference);
            return true;
        }
        val$settings.setUseCellularWhenAvailable(preference.booleanValue());
        return true;
    }

    er()
    {
        this$0 = final_playnowpreferencedelegate;
        val$settings = PlayerUserSettings.this;
        super();
    }
}
