// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.hls.HlsDownloadClient;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylist;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylistParser;
import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class val.hlsVariantPlaylistUrl extends NonCachingBaseTask
{

    final PreDownloadFlowFragment this$0;
    final String val$hlsVariantPlaylistUrl;

    public HlsVariantPlaylist execute()
    {
        return (HlsVariantPlaylist)PreDownloadFlowFragment.access$1600(PreDownloadFlowFragment.this).downloadHlsFile(val$hlsVariantPlaylistUrl, new HlsVariantPlaylistParser());
    }

    public volatile Object execute()
    {
        return execute();
    }

    ()
    {
        this$0 = final_predownloadflowfragment;
        val$hlsVariantPlaylistUrl = String.this;
        super();
    }
}
