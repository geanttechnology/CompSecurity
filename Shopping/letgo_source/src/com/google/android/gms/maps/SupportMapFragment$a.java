// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v7.ll;
import android.support.v7.yn;
import android.support.v7.yp;
import android.support.v7.yw;
import android.support.v7.zu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.maps.model.e;

// Referenced classes of package com.google.android.gms.maps:
//            SupportMapFragment, GoogleMapOptions, e, c

static class a
    implements yw
{

    private final Fragment a;
    private final yp b;

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        try
        {
            layoutinflater = b.a(ll.a(layoutinflater), ll.a(viewgroup), bundle);
        }
        // Misplaced declaration of an exception variable
        catch (LayoutInflater layoutinflater)
        {
            throw new e(layoutinflater);
        }
        return (View)ll.a(layoutinflater);
    }

    public void a()
    {
        try
        {
            b.b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public void a(Activity activity, Bundle bundle, Bundle bundle1)
    {
        bundle = (GoogleMapOptions)bundle.getParcelable("MapOptions");
        try
        {
            b.a(ll.a(activity), bundle, bundle1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new e(activity);
        }
    }

    public void a(Bundle bundle)
    {
        Bundle bundle1;
        bundle1 = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        bundle1 = new Bundle();
        bundle = a.i();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (bundle.containsKey("MapOptions"))
        {
            zu.a(bundle1, "MapOptions", bundle.getParcelable("MapOptions"));
        }
        b.a(bundle1);
        return;
        bundle;
        throw new e(bundle);
    }

    public void a(com.google.android.gms.maps.e e1)
    {
        try
        {
            b.a(new android.support.v7.zi.a(e1) {

                final com.google.android.gms.maps.e a;
                final SupportMapFragment.a b;

                public void a(yn yn)
                    throws RemoteException
                {
                    a.a(new c(yn));
                }

            
            {
                b = SupportMapFragment.a.this;
                a = e1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.maps.e e1)
        {
            throw new e(e1);
        }
    }

    public void b()
    {
        try
        {
            b.c();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public void b(Bundle bundle)
    {
        try
        {
            b.b(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new e(bundle);
        }
    }

    public void c()
    {
        try
        {
            b.d();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public void d()
    {
        try
        {
            b.e();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public void e()
    {
        try
        {
            b.f();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public yp f()
    {
        return b;
    }

    public _cls1.a(Fragment fragment, yp yp1)
    {
        b = (yp)x.a(yp1);
        a = (Fragment)x.a(fragment);
    }
}
