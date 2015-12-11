// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.player.PlayerPlatformAPI;
import com.xfinity.playerlib.downloads.MediaLicenseClient;
import com.xfinity.playerlib.model.videoplay.adobeplayer.CimAssetFactory;
import java.util.Date;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class  extends NonCachingBaseTask
{

    final PreDownloadFlowFragment this$0;
    final PlayerPlatformAPI val$playerPlatformAPI;

    public volatile Object execute()
    {
        return execute();
    }

    public Date execute()
    {
        com.comcast.playerplatform.primetime.android.asset.Asset asset = PreDownloadFlowFragment.access$4200(PreDownloadFlowFragment.this).create(PreDownloadFlowFragment.access$1400(PreDownloadFlowFragment.this), PreDownloadFlowFragment.access$3800(PreDownloadFlowFragment.this), PreDownloadFlowFragment.access$3300(PreDownloadFlowFragment.this), DrmWorkflow.STREAMING);
        return PreDownloadFlowFragment.access$4300(PreDownloadFlowFragment.this).getOrRefreshMediaLicense(val$playerPlatformAPI, asset);
    }

    ()
    {
        this$0 = final_predownloadflowfragment;
        val$playerPlatformAPI = PlayerPlatformAPI.this;
        super();
    }
}
