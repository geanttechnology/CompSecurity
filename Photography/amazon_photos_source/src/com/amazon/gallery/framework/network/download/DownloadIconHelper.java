// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.content.Context;
import android.net.Uri;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;

public class DownloadIconHelper
{

    private Uri defaultUri;
    private final DiskStore diskStore;
    private final MediaItemDao mediaItemDao;

    public DownloadIconHelper(MediaItemDao mediaitemdao, DiskStore diskstore)
    {
        mediaItemDao = mediaitemdao;
        diskStore = diskstore;
    }

    public Uri getIconForDownload(MediaItem mediaitem)
    {
        return defaultUri;
    }

    public Uri getIconForDownload(Tag tag)
    {
        return defaultUri;
    }

    public void setDefaultIcon(Context context, int i)
    {
        defaultUri = Uri.parse((new StringBuilder()).append("android.resource://").append(context.getPackageName()).append("/").append(i).toString());
    }
}
