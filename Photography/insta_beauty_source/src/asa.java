// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.fotoable.photoselector.MediaStoreScannerService;
import com.fotoable.photoselector.activity.PhotoSelectorActivity;

public class asa
    implements ServiceConnection
{

    final PhotoSelectorActivity a;

    public asa(PhotoSelectorActivity photoselectoractivity)
    {
        a = photoselectoractivity;
        super();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        PhotoSelectorActivity.a(a, ((arf)ibinder).a());
        PhotoSelectorActivity.a(a);
        PhotoSelectorActivity.b(a).a(a);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        PhotoSelectorActivity.a(a, null);
    }
}
