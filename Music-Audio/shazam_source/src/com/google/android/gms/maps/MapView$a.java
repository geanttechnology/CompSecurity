// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.maps.a.b;
import com.google.android.gms.maps.a.e;
import com.google.android.gms.maps.a.k;
import com.google.android.gms.maps.model.d;

// Referenced classes of package com.google.android.gms.maps:
//            MapView, c, e

static final class .w.a
    implements k
{

    final e a;
    private final ViewGroup b;
    private View c;

    public final void a()
    {
        try
        {
            a.b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
    }

    public final void a(Bundle bundle)
    {
        try
        {
            a.a(bundle);
            c = (View)com.google.android.gms.b.d.a(a.f());
            b.removeAllViews();
            b.addView(c);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new d(bundle);
        }
    }

    public final void b()
    {
        try
        {
            a.c();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
    }

    public final void b(Bundle bundle)
    {
        try
        {
            a.b(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new d(bundle);
        }
    }

    public final void c()
    {
        try
        {
            a.d();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
    }

    public final void d()
    {
        try
        {
            a.e();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
    }

    public t>(ViewGroup viewgroup, e e1)
    {
        a = (e)w.a(e1);
        b = (ViewGroup)w.a(viewgroup);
    }

    // Unreferenced inner class com/google/android/gms/maps/MapView$a$1

/* anonymous class */
    final class _cls1 extends com.google.android.gms.maps.a.w.a
    {

        final com.google.android.gms.maps.e a;
        final MapView.a b;

        public final void a(b b1)
        {
            new c(b1);
        }

            
            {
                b = MapView.a.this;
                a = e1;
                super();
            }
    }

}
