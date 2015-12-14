// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.ftue.AbstractNoContentOverlay;
import com.amazon.gallery.framework.kindle.ftue.LoadingContentViewFragment;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorViewActivity

class kConnectivity extends AbstractNoContentOverlay
{

    final ThorViewActivity this$0;

    public int getNoContentViewId()
    {
        return 0x7f0c0185;
    }

    protected void setNoContentFragment()
    {
        fragment = new LoadingContentViewFragment();
    }

    anager(Profiler profiler, SyncManager syncmanager, MediaStoreSyncProvider mediastoresyncprovider, NetworkConnectivity networkconnectivity, AuthenticationManager authenticationmanager)
    {
        this$0 = ThorViewActivity.this;
        super(profiler, syncmanager, mediastoresyncprovider, networkconnectivity, authenticationmanager);
    }
}
