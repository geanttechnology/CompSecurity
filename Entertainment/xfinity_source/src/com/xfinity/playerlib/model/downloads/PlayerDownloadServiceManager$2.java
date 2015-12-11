// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads;

import com.comcast.cim.cmasl.hls.HlsSimplePlaylist;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylist;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.downloads.DownloadServiceException;
import com.google.common.util.concurrent.FutureCallback;
import java.util.UUID;

// Referenced classes of package com.xfinity.playerlib.model.downloads:
//            PlayerDownloadServiceManager, PersistentEntityCache, PlayerDownloadMetaData

class val.resultCallback
    implements Runnable
{

    final PlayerDownloadServiceManager this$0;
    final HlsSimplePlaylist val$alternateAudioPlaylist;
    final Either val$backingEntity;
    final Runnable val$extraTask;
    final PlayerDownloadMetaData val$metaData;
    final FutureCallback val$resultCallback;
    final HlsSimplePlaylist val$simplePlaylist;
    final UUID val$uuid;
    final HlsVariantPlaylist val$variantPlaylist;
    final long val$videoId;

    public void run()
    {
        PlayerDownloadServiceManager.access$100(PlayerDownloadServiceManager.this).store(val$uuid, val$backingEntity);
        try
        {
            PlayerDownloadServiceManager.access$200(PlayerDownloadServiceManager.this, (new StringBuilder()).append("").append(val$videoId).toString(), val$simplePlaylist, val$variantPlaylist, val$alternateAudioPlaylist, val$metaData, val$extraTask, val$resultCallback);
            return;
        }
        catch (DownloadServiceException downloadserviceexception)
        {
            val$resultCallback.onFailure(downloadserviceexception);
        }
    }

    ()
    {
        this$0 = final_playerdownloadservicemanager;
        val$uuid = uuid1;
        val$backingEntity = either;
        val$videoId = l;
        val$simplePlaylist = hlssimpleplaylist;
        val$variantPlaylist = hlsvariantplaylist;
        val$alternateAudioPlaylist = hlssimpleplaylist1;
        val$metaData = playerdownloadmetadata;
        val$extraTask = runnable;
        val$resultCallback = FutureCallback.this;
        super();
    }
}
