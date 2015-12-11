// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.model.user.XipUser;
import com.xfinity.playerlib.downloads.DeviceRegistration;
import com.xfinity.playerlib.downloads.RegisterDeviceClient;
import com.xfinity.playerlib.model.user.PlayNowUserManager;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls0 extends NonCachingBaseTask
{

    final PreDownloadFlowFragment this$0;

    public DeviceRegistration execute()
    {
        return PreDownloadFlowFragment.access$2900(PreDownloadFlowFragment.this).registerDevice((XipUser)PreDownloadFlowFragment.access$900(PreDownloadFlowFragment.this).getUser());
    }

    public volatile Object execute()
    {
        return execute();
    }

    ()
    {
        this$0 = PreDownloadFlowFragment.this;
        super();
    }
}
