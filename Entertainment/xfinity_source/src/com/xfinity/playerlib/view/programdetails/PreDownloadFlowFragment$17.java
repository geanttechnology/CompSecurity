// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.hls.HlsSimplePlaylist;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class ryingExecutionListener extends ryingExecutionListener
{

    final PreDownloadFlowFragment this$0;

    public void onPostExecute(HlsSimplePlaylist hlssimpleplaylist)
    {
        PreDownloadFlowFragment.access$2702(PreDownloadFlowFragment.this, hlssimpleplaylist);
        PreDownloadFlowFragment.access$2600(PreDownloadFlowFragment.this);
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((HlsSimplePlaylist)obj);
    }

    ryingExecutionListener(TaskExecutor taskexecutor)
    {
        this$0 = PreDownloadFlowFragment.this;
        super(PreDownloadFlowFragment.this, taskexecutor);
    }
}
