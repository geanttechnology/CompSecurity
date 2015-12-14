// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import arj;
import ask;
import com.fotoable.photoselector.MediaStoreScannerService;

public abstract class BasicMediaStorePhotoFragment extends Fragment
    implements arj
{

    public MediaStoreScannerService a;
    private ProgressDialog b;
    private boolean c;
    private ServiceConnection d;

    public BasicMediaStorePhotoFragment()
    {
        a = null;
        d = new ask(this);
    }

    public static ProgressDialog a(BasicMediaStorePhotoFragment basicmediastorephotofragment)
    {
        return basicmediastorephotofragment.b;
    }

    public static ProgressDialog a(BasicMediaStorePhotoFragment basicmediastorephotofragment, ProgressDialog progressdialog)
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

    public void a(boolean flag)
    {
        if (isAdded() && getActivity() != null && !getActivity().isFinishing() && b != null && b.isShowing())
        {
            b.dismiss();
            b = null;
        }
        b(flag);
    }

    public abstract void b(boolean flag);

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
