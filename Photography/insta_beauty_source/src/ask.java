// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.fotoable.photoselector.MediaStoreScannerService;
import com.fotoable.photoselector.ui.BasicMediaStorePhotoFragment;

public class ask
    implements ServiceConnection
{

    final BasicMediaStorePhotoFragment a;

    public ask(BasicMediaStorePhotoFragment basicmediastorephotofragment)
    {
        a = basicmediastorephotofragment;
        super();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        a.a = ((arf)ibinder).a();
        BasicMediaStorePhotoFragment.a(a, ProgressDialog.show(a.getActivity(), "", "Loading..."));
        BasicMediaStorePhotoFragment.a(a).setCancelable(true);
        a.a.a(a);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        a.a = null;
    }
}
