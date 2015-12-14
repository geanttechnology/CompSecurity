// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.store.Asset;
import com.amazon.gallery.framework.data.store.DiskEvictor;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            FileDownloadCallback, GalleryDownloadManager, CustomDownloadId, GalleryDownloadListener, 
//            AbstractDownloadManager

private class groupCustomId
    implements FileDownloadCallback
{

    private final AtomicInteger count = new AtomicInteger();
    private final CustomDownloadId groupCustomId;
    final GalleryDownloadManager this$0;

    private boolean isInCacheDir(File file)
    {
        return file.getAbsolutePath().startsWith(GalleryDownloadManager.access$000(GalleryDownloadManager.this).getAbsolutePath());
    }

    private void onProgress(CustomDownloadId customdownloadid)
    {
        int i = count.incrementAndGet();
        if (customdownloadid != null && GalleryDownloadManager.access$200(GalleryDownloadManager.this).containsKey(customdownloadid.getTag()))
        {
            ((GalleryDownloadListener)GalleryDownloadManager.access$200(GalleryDownloadManager.this).get(customdownloadid.getTag())).onProgress(customdownloadid.getTag(), customdownloadid.getMediaItemObjectId(), i, groupCustomId.getTotal());
        }
        if (i == groupCustomId.getTotal())
        {
            GalleryDownloadManager.access$300(GalleryDownloadManager.this).finishDownload(groupCustomId);
        }
    }

    private void reportCacheUsage(File file)
    {
        Asset asset = Asset.createFromFilePath(file);
        if (asset != null && file.exists())
        {
            GalleryDownloadManager.access$100(GalleryDownloadManager.this).onStoreAsset(asset, false);
            return;
        } else
        {
            GLogger.w(GalleryDownloadManager.TAG, "FileDownloadManager reported a success, but there is no asset stored.", new Object[0]);
            return;
        }
    }

    public void initListener(GalleryDownloadListener gallerydownloadlistener)
    {
        gallerydownloadlistener.onProgress(groupCustomId.getTag(), groupCustomId.getMediaItemObjectId(), count.get(), groupCustomId.getTotal());
    }

    public void onDownloadCompleted(CustomDownloadId customdownloadid, File file)
    {
        onProgress(customdownloadid);
        GLogger.v(GalleryDownloadManager.TAG, "MediaItem Downloaded customDownloadId=%s, file=%s", new Object[] {
            customdownloadid, file
        });
        if (isInCacheDir(file))
        {
            reportCacheUsage(file);
        }
    }

    public void onDownloadFail(CustomDownloadId customdownloadid, String s)
    {
        onProgress(customdownloadid);
        GLogger.w(GalleryDownloadManager.TAG, "Can't download customId=%s, message=%s", new Object[] {
            customdownloadid, s
        });
    }

    public (CustomDownloadId customdownloadid)
    {
        this$0 = GalleryDownloadManager.this;
        super();
        groupCustomId = customdownloadid;
    }
}
