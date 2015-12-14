// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.fotoable.photoselector.MediaStoreScannerService;
import com.wantu.activity.photoselector.SinglePhotoSelectorActivity;

public class bjs
    implements ServiceConnection
{

    final SinglePhotoSelectorActivity a;

    public bjs(SinglePhotoSelectorActivity singlephotoselectoractivity)
    {
        a = singlephotoselectoractivity;
        super();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        SinglePhotoSelectorActivity.a(a, ((arf)ibinder).a());
        SinglePhotoSelectorActivity.a(a);
        SinglePhotoSelectorActivity.b(a).a(a);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        SinglePhotoSelectorActivity.a(a, null);
    }
}
