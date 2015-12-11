// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.hls.HlsDownloadClient;
import com.comcast.cim.cmasl.hls.HlsSimplePlaylist;
import com.comcast.cim.cmasl.hls.HlsSimplePlaylistParser;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylist;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class val.mediaProfile extends NonCachingBaseTask
{

    final PreDownloadFlowFragment this$0;
    final com.comcast.cim.cmasl.hls.file val$mediaProfile;

    public HlsSimplePlaylist execute()
    {
        return (HlsSimplePlaylist)PreDownloadFlowFragment.access$1600(PreDownloadFlowFragment.this).downloadHlsFile((new StringBuilder()).append(PreDownloadFlowFragment.access$2200(PreDownloadFlowFragment.this).getUrlPathPrefix()).append(val$mediaProfile.getRelativePath()).toString(), new HlsSimplePlaylistParser());
    }

    public volatile Object execute()
    {
        return execute();
    }

    ()
    {
        this$0 = final_predownloadflowfragment;
        val$mediaProfile = com.comcast.cim.cmasl.hls.file.this;
        super();
    }
}
