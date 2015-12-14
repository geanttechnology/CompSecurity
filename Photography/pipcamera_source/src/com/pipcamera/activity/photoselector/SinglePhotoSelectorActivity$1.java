// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.photoselector;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.fotoable.photoselector.MediaStoreScannerService;
import mv;

// Referenced classes of package com.pipcamera.activity.photoselector:
//            SinglePhotoSelectorActivity

class a
    implements ServiceConnection
{

    final SinglePhotoSelectorActivity a;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        SinglePhotoSelectorActivity.a(a, ((mv)ibinder).a());
        SinglePhotoSelectorActivity.a(a);
        SinglePhotoSelectorActivity.b(a).a(a);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        SinglePhotoSelectorActivity.a(a, null);
    }

    (SinglePhotoSelectorActivity singlephotoselectoractivity)
    {
        a = singlephotoselectoractivity;
        super();
    }
}
