// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.app.Activity;
import android.content.Intent;
import android.preference.Preference;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import com.xfinity.playerlib.model.downloads.NotificationQueueManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.common.AdultContentSettingChangeActivity;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate

class val.settings
    implements android.preference.eListener
{

    final PlayNowPreferenceDelegate this$0;
    final PlayerUserSettings val$settings;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        preference = (ParentalControlsSettings)PlayNowPreferenceDelegate.access$000(PlayNowPreferenceDelegate.this).getCachedResultIfAvailable();
        obj = Boolean.valueOf(obj.toString());
        if (!((Boolean) (obj)).booleanValue() || preference != null && preference.getParentalPin() == null)
        {
            PlayNowPreferenceDelegate.access$100(PlayNowPreferenceDelegate.this).cancelAdultDownloadNotifications();
            val$settings.setWantsAdultContent(((Boolean) (obj)).booleanValue());
            return true;
        } else
        {
            preference = new Intent(PlayNowPreferenceDelegate.access$200(PlayNowPreferenceDelegate.this), com/xfinity/playerlib/view/common/AdultContentSettingChangeActivity);
            preference.addFlags(0x40000000);
            PlayNowPreferenceDelegate.access$200(PlayNowPreferenceDelegate.this).startActivity(preference);
            return false;
        }
    }

    ity()
    {
        this$0 = final_playnowpreferencedelegate;
        val$settings = PlayerUserSettings.this;
        super();
    }
}
