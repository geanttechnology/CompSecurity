// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumOperation

class val.activity
    implements Runnable
{

    final AlbumOperation this$0;
    final Activity val$activity;

    public void run()
    {
        AlbumOperation.access$100(AlbumOperation.this).promptIfOffline(val$activity);
    }

    y.NetworkConnectivity()
    {
        this$0 = final_albumoperation;
        val$activity = Activity.this;
        super();
    }
}
