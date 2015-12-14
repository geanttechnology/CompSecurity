// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import java.lang.ref.WeakReference;

public abstract class AlbumHelper
{

    private final WeakReference activityRef;
    protected final CloudDriveServiceClientManager cloudDriveServiceClientManager;
    private final NetworkConnectivity networkConnectivity;

    public AlbumHelper(Activity activity)
    {
        activityRef = new WeakReference(activity);
        cloudDriveServiceClientManager = (CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
        networkConnectivity = (NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY);
    }

    protected Activity getActivity()
    {
        return (Activity)activityRef.get();
    }

    protected boolean promptIfOffline()
    {
        Activity activity = getActivity();
        return activity == null || networkConnectivity.promptIfOffline(activity);
    }
}
