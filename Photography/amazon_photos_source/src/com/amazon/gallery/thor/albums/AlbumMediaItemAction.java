// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

public abstract class AlbumMediaItemAction extends MediaItemAction
{

    public AlbumMediaItemAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, int i)
    {
        super(activity, networkconnectivity, photosdemomanager, i);
    }

    public void setProfiler(Profiler profiler)
    {
        this.profiler = new ComponentProfiler(profiler, "AlbumsMetrics");
    }
}
