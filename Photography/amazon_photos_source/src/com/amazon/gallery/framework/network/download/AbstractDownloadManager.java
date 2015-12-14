// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            FileDownloadManager, FileDownloadCallback, CustomDownloadId, DownloadTransaction

public abstract class AbstractDownloadManager
    implements FileDownloadManager
{

    protected Map listeners;

    public AbstractDownloadManager()
    {
        listeners = new ConcurrentHashMap();
    }

    public void cancelDownload(CustomDownloadId customdownloadid)
    {
    }

    public void clearDownloadQueue()
    {
    }

    public void finishDownload(CustomDownloadId customdownloadid)
    {
        listeners.remove(getKey(customdownloadid));
        GLogger.v("com.amazon.gallery.framework.network.download.FileDownloadManager", "Mark Tag Download as finished customId=%s", new Object[] {
            customdownloadid
        });
    }

    protected FileDownloadCallback getCallback(CustomDownloadId customdownloadid)
    {
        return (FileDownloadCallback)listeners.get(getKey(customdownloadid));
    }

    public FileDownloadCallback getCallbackByKey(ObjectID objectid)
    {
        return (FileDownloadCallback)listeners.get(objectid);
    }

    protected Object getKey(CustomDownloadId customdownloadid)
    {
        if (customdownloadid == null)
        {
            return null;
        }
        if (customdownloadid.getTag().equals(ObjectID.getRoot()))
        {
            return customdownloadid.getMediaItemObjectId();
        } else
        {
            return customdownloadid.getTag();
        }
    }

    public boolean hasCallback(ObjectID objectid)
    {
        return listeners.containsKey(objectid);
    }

    public void init()
    {
    }

    public DownloadTransaction startDownload(CustomDownloadId customdownloadid, FileDownloadCallback filedownloadcallback, String s, Uri uri)
    {
        GLogger.v("com.amazon.gallery.framework.network.download.FileDownloadManager", "Tag download is scheduled: %s", new Object[] {
            customdownloadid
        });
        listeners.put(customdownloadid.getTag(), filedownloadcallback);
        return null;
    }
}
