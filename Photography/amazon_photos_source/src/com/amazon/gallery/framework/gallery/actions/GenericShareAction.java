// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            AbstractShareAction

public abstract class GenericShareAction extends AbstractShareAction
{

    public GenericShareAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, int i, ShareStore sharestore, RestClient restclient, Profiler profiler)
    {
        super(activity, networkconnectivity, photosdemomanager, i, sharestore, restclient, profiler);
    }
}
