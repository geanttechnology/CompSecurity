// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CMSAsyncTaskRunner
{

    private static final String TAG = com/amazon/gallery/framework/kindle/cms/CMSAsyncTaskRunner.getName();
    private AuthenticationManager authenticationManager;
    private Context context;
    private DiskStore diskStore;
    private final ExecutorService executor;
    private MediaItemDao mediaItemDao;
    private NetworkStore networkStore;
    private Resources resources;
    private final Map taskTracker = new ConcurrentHashMap();

    public CMSAsyncTaskRunner(boolean flag)
    {
        if (flag)
        {
            executor = Executors.newSingleThreadExecutor();
            return;
        } else
        {
            executor = null;
            return;
        }
    }

    protected void finalize()
    {
        taskTracker.clear();
        if (executor != null)
        {
            executor.shutdownNow();
        }
    }

    public void initWithContext(Context context1)
    {
        resources = context1.getResources();
        context = context1;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationmanager)
    {
        authenticationManager = authenticationmanager;
    }

    public void setDiskStore(DiskStore diskstore)
    {
        diskStore = diskstore;
    }

    public void setMediaItemDao(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
    }

    public void setNetworkStore(NetworkStore networkstore)
    {
        networkStore = networkstore;
    }

}
