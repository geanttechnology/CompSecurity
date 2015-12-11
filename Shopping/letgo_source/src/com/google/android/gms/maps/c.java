// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import android.support.v7.aab;
import android.support.v7.lk;
import android.support.v7.ll;
import android.support.v7.yn;
import android.view.View;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.d;
import com.google.android.gms.maps.model.e;

// Referenced classes of package com.google.android.gms.maps:
//            a, g, f

public final class com.google.android.gms.maps.c
{
    public static interface a
    {

        public abstract View a(com.google.android.gms.maps.model.d d1);

        public abstract View b(com.google.android.gms.maps.model.d d1);
    }

    public static interface b
    {

        public abstract void a(LatLng latlng);
    }

    public static interface c
    {

        public abstract void a();
    }

    public static interface d
    {

        public abstract boolean a(com.google.android.gms.maps.model.d d1);
    }


    private final yn a;
    private g b;

    protected com.google.android.gms.maps.c(yn yn1)
    {
        a = (yn)x.a(yn1);
    }

    yn a()
    {
        return a;
    }

    public final com.google.android.gms.maps.model.c a(CircleOptions circleoptions)
    {
        try
        {
            circleoptions = new com.google.android.gms.maps.model.c(a.a(circleoptions));
        }
        // Misplaced declaration of an exception variable
        catch (CircleOptions circleoptions)
        {
            throw new e(circleoptions);
        }
        return circleoptions;
    }

    public final com.google.android.gms.maps.model.d a(MarkerOptions markeroptions)
    {
        try
        {
            markeroptions = a.a(markeroptions);
        }
        // Misplaced declaration of an exception variable
        catch (MarkerOptions markeroptions)
        {
            throw new e(markeroptions);
        }
        if (markeroptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        markeroptions = new com.google.android.gms.maps.model.d(markeroptions);
        return markeroptions;
        return null;
    }

    public final void a(com.google.android.gms.maps.a a1)
    {
        try
        {
            a.a(a1.a());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.maps.a a1)
        {
            throw new e(a1);
        }
    }

    public final void a(a a1)
    {
        if (a1 == null)
        {
            try
            {
                a.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (a a1)
            {
                throw new e(a1);
            }
        }
        a.a(new android.support.v7.za.a(a1) {

            final a a;
            final com.google.android.gms.maps.c b;

            public lk a(aab aab)
            {
                return ll.a(a.a(new com.google.android.gms.maps.model.d(aab)));
            }

            public lk b(aab aab)
            {
                return ll.a(a.b(new com.google.android.gms.maps.model.d(aab)));
            }

            
            {
                b = com.google.android.gms.maps.c.this;
                a = a1;
                super();
            }
        });
        return;
    }

    public final void a(b b1)
    {
        if (b1 == null)
        {
            try
            {
                a.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (b b1)
            {
                throw new e(b1);
            }
        }
        a.a(new android.support.v7.zf.a(b1) {

            final b a;
            final com.google.android.gms.maps.c b;

            public void a(LatLng latlng)
            {
                a.a(latlng);
            }

            
            {
                b = com.google.android.gms.maps.c.this;
                a = b1;
                super();
            }
        });
        return;
    }

    public void a(c c1)
    {
        if (c1 == null)
        {
            try
            {
                a.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (c c1)
            {
                throw new e(c1);
            }
        }
        a.a(new android.support.v7.zg.a(c1) {

            final c a;
            final com.google.android.gms.maps.c b;

            public void a()
                throws RemoteException
            {
                a.a();
            }

            
            {
                b = com.google.android.gms.maps.c.this;
                a = c2;
                super();
            }
        });
        return;
    }

    public final void a(d d1)
    {
        if (d1 == null)
        {
            try
            {
                a.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (d d1)
            {
                throw new e(d1);
            }
        }
        a.a(new android.support.v7.zj.a(d1) {

            final d a;
            final com.google.android.gms.maps.c b;

            public boolean a(aab aab)
            {
                return a.a(new com.google.android.gms.maps.model.d(aab));
            }

            
            {
                b = com.google.android.gms.maps.c.this;
                a = d1;
                super();
            }
        });
        return;
    }

    public final void a(boolean flag)
    {
        try
        {
            a.c(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public final g b()
    {
        g g1;
        try
        {
            if (b == null)
            {
                b = new g(a.k());
            }
            g1 = b;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
        return g1;
    }

    public final f c()
    {
        f f1;
        try
        {
            f1 = new f(a.l());
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
        return f1;
    }
}
