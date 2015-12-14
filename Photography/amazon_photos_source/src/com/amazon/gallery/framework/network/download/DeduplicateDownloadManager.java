// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.content.Context;
import android.net.Uri;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.data.dao.deduplicate.FilenameIdEmbedUtils;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.AbstractMediaStoreSyncProvider;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            SimpleDownloadManager, PostDownloadScanProcessor, CustomDownloadId, DownloadStatusNotifier, 
//            DownloadTransaction

public class DeduplicateDownloadManager extends SimpleDownloadManager
{

    private final MediaItemDao mediaItemDao;
    private final ComponentProfiler postScanProfiler;

    public DeduplicateDownloadManager(Context context, RestClient restclient, NetworkConnectivity networkconnectivity, MediaStoreSyncProvider mediastoresyncprovider, MediaItemDao mediaitemdao, DownloadStatusNotifier downloadstatusnotifier)
    {
        super(context, restclient, networkconnectivity, mediastoresyncprovider, downloadstatusnotifier);
        mediaItemDao = mediaitemdao;
        postScanProfiler = new ComponentProfiler((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER), com/amazon/gallery/framework/network/download/PostDownloadScanProcessor);
    }

    private void addDownloadRequestInternal(CustomDownloadId customdownloadid, String s, String s1, DownloadTransaction downloadtransaction)
    {
        if (customdownloadid.getCategory() != 2)
        {
            File file = new File(s1);
            if (customdownloadid.getMediaItemObjectId() != null)
            {
                Object obj = mediaItemDao.getItemById(customdownloadid.getMediaItemObjectId());
                if (obj != null)
                {
                    obj = new PostDownloadScanProcessor(((com.amazon.gallery.framework.model.media.MediaItem) (obj)), file, mediaItemDao);
                    ((PostDownloadScanProcessor) (obj)).setUnifyEnabled(true);
                    ((PostDownloadScanProcessor) (obj)).setProfiler(postScanProfiler);
                    mediaStoreSyncProvider.attachOneOffScanListener(file.getAbsolutePath(), ((com.amazon.gallery.framework.data.dao.sqlite.mediastore.AbstractMediaStoreSyncProvider.OneOffScanListener) (obj)));
                }
            }
        }
        super.addDownloadRequest(customdownloadid, s, s1, downloadtransaction);
    }

    private String getFinalPath(String s, CustomDownloadId customdownloadid)
    {
        File file = new File(s);
        s = file;
        if (customdownloadid.getCategory() != 2)
        {
            s = file;
            if (customdownloadid.getMediaItemObjectId() != null)
            {
                customdownloadid = mediaItemDao.getItemById(customdownloadid.getMediaItemObjectId());
                s = file;
                if (customdownloadid != null)
                {
                    s = FilenameIdEmbedUtils.getFinalFile(file, customdownloadid);
                }
            }
        }
        return s.getAbsolutePath();
    }

    public void addDownloadRequest(CustomDownloadId customdownloadid, String s, String s1, DownloadTransaction downloadtransaction)
    {
        addDownloadRequestInternal(customdownloadid, s, getFinalPath(s1, customdownloadid), downloadtransaction);
    }

    public void addSingleItemDownloadRequest(CustomDownloadId customdownloadid, String s, String s1, String s2, Uri uri)
    {
        addDownloadRequestInternal(customdownloadid, s, getFinalPath(s1, customdownloadid), null);
    }
}
