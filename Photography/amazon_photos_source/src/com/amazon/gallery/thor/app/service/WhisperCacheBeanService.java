// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.store.DiskEvictorConfig;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.framework.network.watchdog.WhisperCache;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

public class WhisperCacheBeanService extends WhisperCache
{

    public WhisperCacheBeanService()
    {
        super(256, 2048, ((DiskEvictorConfig)ThorGalleryApplication.getBean(Keys.DISK_EVICTOR_CONFIG)).getFetchThumbLimit(), ((DiskEvictorConfig)ThorGalleryApplication.getBean(Keys.DISK_EVICTOR_CONFIG)).getFetchFullLimit());
        NetworkExecutor networkexecutor = NetworkExecutor.getInstance();
        MediaItemDao mediaitemdao = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
        init(networkexecutor, (NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY), (DiskStore)ThorGalleryApplication.getBean(Keys.DISK_STORE), (NetworkStore)ThorGalleryApplication.getBean(Keys.NETWORK_STORE), mediaitemdao, (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER), (GalleryDownloadManager)ThorGalleryApplication.getBean(Keys.GALLERY_DOWNLOAD_MANAGER));
    }
}
