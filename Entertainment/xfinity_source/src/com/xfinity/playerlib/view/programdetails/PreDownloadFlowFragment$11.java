// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.xfinity.playerlib.authorization.SMILResource;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class ryingExecutionListener extends ryingExecutionListener
{

    final PreDownloadFlowFragment this$0;

    public void onPostExecute(SMILResource smilresource)
    {
        PreDownloadFlowFragment.access$1402(PreDownloadFlowFragment.this, smilresource.getSignedManifestUrl());
        PreDownloadFlowFragment.access$1500(PreDownloadFlowFragment.this, smilresource.getSignedManifestUrl());
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((SMILResource)obj);
    }

    ryingExecutionListener(TaskExecutor taskexecutor)
    {
        this$0 = PreDownloadFlowFragment.this;
        super(PreDownloadFlowFragment.this, taskexecutor);
    }
}
