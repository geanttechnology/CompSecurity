// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.fotoable.photoselector.MediaStoreScannerService;
import mv;
import mz;

public abstract class BasicMediaStorePhotoFragment extends Fragment
    implements mz
{

    MediaStoreScannerService a;
    private ProgressDialog b;
    private boolean c;
    private ServiceConnection d;

    public BasicMediaStorePhotoFragment()
    {
        a = null;
        d = new ServiceConnection() {

            final BasicMediaStorePhotoFragment a;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                a.a = ((mv)ibinder).a();
                BasicMediaStorePhotoFragment.a(a, ProgressDialog.show(a.getActivity(), "", "Loading..."));
                BasicMediaStorePhotoFragment.a(a).setCancelable(true);
                a.a.a(a);
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                a.a = null;
            }

            
            {
                a = BasicMediaStorePhotoFragment.this;
                super();
            }
        };
    }

    static ProgressDialog a(BasicMediaStorePhotoFragment basicmediastorephotofragment)
    {
        return basicmediastorephotofragment.b;
    }

    static ProgressDialog a(BasicMediaStorePhotoFragment basicmediastorephotofragment, ProgressDialog progressdialog)
    {
        basicmediastorephotofragment.b = progressdialog;
        return progressdialog;
    }

    private void a()
    {
        Intent intent = new Intent(getActivity(), com/fotoable/photoselector/MediaStoreScannerService);
        getActivity().bindService(intent, d, 1);
        c = true;
    }

    private void b()
    {
        if (c)
        {
            getActivity().unbindService(d);
            c = false;
        }
    }

    public abstract void a(boolean flag);

    public void a_(boolean flag)
    {
        if (isAdded() && getActivity() != null && !getActivity().isFinishing() && b != null && b.isShowing())
        {
            b.dismiss();
            b = null;
        }
        a(flag);
    }

    public void onStart()
    {
        super.onStart();
        a();
    }

    public void onStop()
    {
        super.onStop();
        b();
    }
}
