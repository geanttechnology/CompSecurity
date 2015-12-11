// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.ll;
import android.support.v7.yn;
import android.support.v7.yq;
import android.support.v7.yw;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.maps.model.e;

// Referenced classes of package com.google.android.gms.maps:
//            MapView, e, c

static class .x.a
    implements yw
{

    private final ViewGroup a;
    private final yq b;
    private View c;

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
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
        throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }

    public void a(Bundle bundle)
    {
        try
        {
            b.a(bundle);
            c = (View)ll.a(b.f());
            a.removeAllViews();
            a.addView(c);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new e(bundle);
        }
    }

    public void a(com.google.android.gms.maps.e e1)
    {
        try
        {
            b.a(new android.support.v7.zi.a(e1) {

                final com.google.android.gms.maps.e a;
                final MapView.a b;

                public void a(yn yn)
                    throws RemoteException
                {
                    a.a(new c(yn));
                }

            
            {
                b = MapView.a.this;
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
        throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }

    public void d()
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

    public void e()
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

    public yq f()
    {
        return b;
    }

    public _cls1.a(ViewGroup viewgroup, yq yq1)
    {
        b = (yq)x.a(yq1);
        a = (ViewGroup)x.a(viewgroup);
    }
}
