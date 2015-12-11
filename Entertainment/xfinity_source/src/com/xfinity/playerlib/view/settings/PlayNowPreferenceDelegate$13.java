// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.xfinity.playerlib.downloads.DeviceRegistration;
import com.xfinity.playerlib.downloads.UnregisterDeviceClient;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate

class  extends NonCachingBaseTask
{

    final PlayNowPreferenceDelegate this$0;
    final PlayerUserSettings val$settings;

    public volatile Object execute()
    {
        return execute();
    }

    public Void execute()
    {
        PlayNowPreferenceDelegate.access$1900(PlayNowPreferenceDelegate.this).unregisterDevice(((PlayNowUser)PlayNowPreferenceDelegate.access$900(PlayNowPreferenceDelegate.this).getUser()).getAuthKeys(), val$settings.getDeviceRegistration().getDeviceId());
        return null;
    }

    ()
    {
        this$0 = final_playnowpreferencedelegate;
        val$settings = PlayerUserSettings.this;
        super();
    }
}
