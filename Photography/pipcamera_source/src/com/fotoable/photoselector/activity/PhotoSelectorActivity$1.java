// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.fotoable.photoselector.MediaStoreScannerService;
import mv;

// Referenced classes of package com.fotoable.photoselector.activity:
//            PhotoSelectorActivity

class a
    implements ServiceConnection
{

    final PhotoSelectorActivity a;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        PhotoSelectorActivity.a(a, ((mv)ibinder).a());
        PhotoSelectorActivity.a(a);
        PhotoSelectorActivity.b(a).a(a);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        PhotoSelectorActivity.a(a, null);
    }

    A(PhotoSelectorActivity photoselectoractivity)
    {
        a = photoselectoractivity;
        super();
    }
}
