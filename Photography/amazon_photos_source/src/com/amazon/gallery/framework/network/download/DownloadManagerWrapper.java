// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.content.Context;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            DeduplicateDownloadManager, DownloadStatusNotifier

public class DownloadManagerWrapper extends DeduplicateDownloadManager
{

    public DownloadManagerWrapper(Context context, RestClient restclient, NetworkConnectivity networkconnectivity, MediaStoreSyncProvider mediastoresyncprovider, MediaItemDao mediaitemdao, DownloadStatusNotifier downloadstatusnotifier)
    {
        super(context, restclient, networkconnectivity, mediastoresyncprovider, mediaitemdao, downloadstatusnotifier);
    }
}
