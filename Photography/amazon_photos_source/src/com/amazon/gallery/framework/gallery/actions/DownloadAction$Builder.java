// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DownloadAction

public static final class y
{

    private Activity context;
    private GalleryDownloadManager downloadManager;
    private MediaItemDao mediaItemDao;
    private NetworkConnectivity networkConnectivity;
    private PhotosDemoManager photosDemoManager;
    private RemovableStorageManager removableStorageManager;
    private RestClient restClient;

    public DownloadAction build()
    {
        return new DownloadAction(context, networkConnectivity, photosDemoManager, mediaItemDao, restClient, downloadManager, removableStorageManager);
    }

    public removableStorageManager withContext(Activity activity)
    {
        context = activity;
        return this;
    }

    public  withGalleryDownloadManager(GalleryDownloadManager gallerydownloadmanager)
    {
        downloadManager = gallerydownloadmanager;
        return this;
    }

    public downloadManager withMediaItemDao(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
        return this;
    }

    public y withNetworkConnectivity(NetworkConnectivity networkconnectivity)
    {
        networkConnectivity = networkconnectivity;
        return this;
    }

    public networkConnectivity withPhotosDemoManager(PhotosDemoManager photosdemomanager)
    {
        photosDemoManager = photosdemomanager;
        return this;
    }

    public photosDemoManager withRemovableStorageManager(RemovableStorageManager removablestoragemanager)
    {
        removableStorageManager = removablestoragemanager;
        return this;
    }

    public removableStorageManager withRestClient(RestClient restclient)
    {
        restClient = restclient;
        return this;
    }

    public y()
    {
    }
}
