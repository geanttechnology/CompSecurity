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

class this._cls0 extends NonCachingBaseTask
{

    final PreDownloadFlowFragment this$0;

    public HlsSimplePlaylist execute()
    {
        return (HlsSimplePlaylist)PreDownloadFlowFragment.access$1600(PreDownloadFlowFragment.this).downloadHlsFile((new StringBuilder()).append(PreDownloadFlowFragment.access$2200(PreDownloadFlowFragment.this).getUrlPathPrefix()).append(PreDownloadFlowFragment.access$2100(PreDownloadFlowFragment.this).getUriString().replace("\"", "")).toString(), new HlsSimplePlaylistParser());
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
