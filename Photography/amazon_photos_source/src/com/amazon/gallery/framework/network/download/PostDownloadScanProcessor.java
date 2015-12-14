// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.media.ExifInterface;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.foundation.utils.file.ExifUtils;
import com.amazon.gallery.foundation.utils.file.MimeTypeUtil;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import java.io.File;
import java.io.IOException;

public class PostDownloadScanProcessor
    implements com.amazon.gallery.framework.data.dao.sqlite.mediastore.AbstractMediaStoreSyncProvider.OneOffScanListener
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent DownloadPhoto;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/network/download/PostDownloadScanProcessor$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            DownloadPhoto = new MetricsEvent("DownloadPhoto", 0);
            $VALUES = (new MetricsEvent[] {
                DownloadPhoto
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/network/download/PostDownloadScanProcessor.getName();
    private final MediaItem cloudMediaItem;
    private boolean doUnify;
    private final MediaItemDao mediaItemDao;
    private final File newFile;
    private ComponentProfiler profiler;

    public PostDownloadScanProcessor(MediaItem mediaitem, File file, MediaItemDao mediaitemdao)
    {
        cloudMediaItem = mediaitem;
        newFile = file;
        mediaItemDao = mediaitemdao;
    }

    private static boolean restoreExif(File file, MediaItem mediaitem)
    {
        boolean flag = false;
        if (MimeTypeUtil.getMimeTypeFromPath(file.getPath()).contentEquals("image/jpeg"))
        {
            try
            {
                file = new ExifInterface(file.getAbsolutePath());
                if (file.getAttribute("DateTime") == null)
                {
                    file.setAttribute("DateTime", DateUtils.getDateFormat(mediaitem.getDateCreatedUTCMs()));
                    ExifUtils.pushMd5ToExif(file, mediaitem.getFullMd5());
                    file.saveAttributes();
                }
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                GLogger.d(TAG, "exif restore failed", new Object[0]);
                return false;
            }
            flag = true;
        }
        return flag;
    }

    public void onScanCompleted(MediaItem mediaitem)
    {
        boolean flag;
        if (!restoreExif(newFile, cloudMediaItem))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            mediaitem.setDateCreatedMs(cloudMediaItem.getDateCreatedMs());
            mediaitem.setDateCreatedUTCMs(cloudMediaItem.getDateCreatedUTCMs());
        }
        if (doUnify)
        {
            mediaItemDao.mergeToCloud(mediaitem, cloudMediaItem.getObjectId(), false);
        } else
        {
            mediaItemDao.saveMergedFields(mediaitem, false);
        }
        if (profiler != null)
        {
            profiler.trackEvent(MetricsEvent.DownloadPhoto, CustomerMetricsHelper.getExtraEventTag(mediaitem.getType().name()));
        }
    }

    public void setProfiler(ComponentProfiler componentprofiler)
    {
        profiler = componentprofiler;
    }

    public void setUnifyEnabled(boolean flag)
    {
        doUnify = flag;
    }

}
