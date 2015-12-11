// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.xfinity.playerlib.downloads.DeviceRegistration;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class ryingExecutionListener extends ryingExecutionListener
{

    final PreDownloadFlowFragment this$0;

    public void onPostExecute(DeviceRegistration deviceregistration)
    {
        ((PlayerUserSettings)PreDownloadFlowFragment.access$900(PreDownloadFlowFragment.this).getUserSettings()).setDeviceRegistration(deviceregistration);
        if (isResumed())
        {
            PreDownloadFlowFragment.access$3000(PreDownloadFlowFragment.this);
            return;
        } else
        {
            abortFlow();
            return;
        }
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((DeviceRegistration)obj);
    }

    ryingExecutionListener(TaskExecutor taskexecutor)
    {
        this$0 = PreDownloadFlowFragment.this;
        super(PreDownloadFlowFragment.this, taskexecutor);
    }
}
