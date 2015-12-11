// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.xfinity.playerlib.downloads.RegistrationListClient;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.settings:
//            PlayNowPreferenceDelegate

class  extends NonCachingBaseTask
{

    final PlayNowPreferenceDelegate this$0;

    public volatile Object execute()
    {
        return execute();
    }

    public List execute()
    {
        return (List)CommonUtils.uncheckedCast(PlayNowPreferenceDelegate.access$1000(PlayNowPreferenceDelegate.this).getDeviceRegistrationList(((PlayNowUser)PlayNowPreferenceDelegate.access$900(PlayNowPreferenceDelegate.this).getUser()).getAuthKeys()));
    }

    ()
    {
        this$0 = PlayNowPreferenceDelegate.this;
        super();
    }
}
