// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.ftue.AbstractNoContentOverlay;
import com.amazon.gallery.framework.kindle.ftue.CameraContentLoadingFragment;
import com.amazon.gallery.framework.kindle.ftue.FTUEAddPhotosFragment;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.framework.network.util.EndpointLoadedEvent;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            ThorFTUEActivity

public class ThorNoContentOverlay extends AbstractNoContentOverlay
{

    private static final String TAG = com/amazon/gallery/thor/ftue/ThorNoContentOverlay.getName();

    public ThorNoContentOverlay(Profiler profiler, SyncManager syncmanager, MediaStoreSyncProvider mediastoresyncprovider, NetworkConnectivity networkconnectivity, AuthenticationManager authenticationmanager)
    {
        super(profiler, syncmanager, mediastoresyncprovider, networkconnectivity, authenticationmanager);
    }

    protected FTUEAddPhotosFragment createAddPhotosFragment()
    {
        return new FTUEAddPhotosFragment(com/amazon/gallery/thor/ftue/ThorFTUEActivity);
    }

    public int getNoContentViewId()
    {
        return !(fragment instanceof CameraContentLoadingFragment) ? 0x7f0c0120 : 0x7f0c01e3;
    }

    public void onEndpointLoaded(EndpointLoadedEvent endpointloadedevent)
    {
        endpoint = endpointloadedevent.endpoint;
    }

}
