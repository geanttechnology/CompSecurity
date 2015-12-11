// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class tryingExecutionListener extends tryingExecutionListener
{

    final PreDownloadFlowFragment this$0;

    public void onPostExecute(VideoEntitlement videoentitlement)
    {
        PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).debug("Entitlement fetched");
        PreDownloadFlowFragment.access$202(PreDownloadFlowFragment.this, videoentitlement);
        PreDownloadFlowFragment.access$300(PreDownloadFlowFragment.this);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((VideoEntitlement)obj);
    }

    tryingExecutionListener(TaskExecutor taskexecutor)
    {
        this$0 = PreDownloadFlowFragment.this;
        super(PreDownloadFlowFragment.this, taskexecutor);
    }
}
