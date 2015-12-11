// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.support.v7.vu;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.personalized.d;

// Referenced classes of package com.google.android.gms.location.places:
//            h, b, e

public class x extends com.google.android.gms.location.places.internal.g.a
{
    public static abstract class a extends b
    {

        protected com.google.android.gms.location.places.b a(Status status)
        {
            return new com.google.android.gms.location.places.b(DataHolder.b(status.g()));
        }

        protected g b(Status status)
        {
            return a(status);
        }

        public a(com.google.android.gms.common.api.a.d d1, com.google.android.gms.common.api.c c1)
        {
            super(d1, c1);
        }
    }

    public static abstract class b extends com.google.android.gms.common.api.k.a
    {

        public b(com.google.android.gms.common.api.a.d d1, com.google.android.gms.common.api.c c1)
        {
            super(d1, c1);
        }
    }

    public static abstract class c extends b
    {

        protected com.google.android.gms.location.places.e a(Status status)
        {
            return new com.google.android.gms.location.places.e(DataHolder.b(status.g()), null);
        }

        protected g b(Status status)
        {
            return a(status);
        }
    }

    public static abstract class d extends b
    {

        protected h a(Status status)
        {
            return new h(DataHolder.b(status.g()), 100, null);
        }

        protected g b(Status status)
        {
            return a(status);
        }
    }

    public static abstract class e extends b
    {
    }

    public static abstract class f extends b
    {

        protected Status a(Status status)
        {
            return status;
        }

        protected g b(Status status)
        {
            return a(status);
        }
    }


    private static final String a = com/google/android/gms/location/places/x.getSimpleName();
    private final d b = null;
    private final a c;
    private final e d = null;
    private final f e = null;
    private final c f = null;
    private final Context g = null;

    public x(a a1)
    {
        c = a1;
    }

    public void a(Status status)
        throws RemoteException
    {
        e.a(status);
    }

    public void a(DataHolder dataholder)
        throws RemoteException
    {
        boolean flag;
        if (b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.x.a(flag, "placeEstimator cannot be null");
        if (dataholder == null)
        {
            if (Log.isLoggable(a, 6))
            {
                Log.e(a, (new StringBuilder()).append("onPlaceEstimated received null DataHolder: ").append(vu.a()).toString());
            }
            b.d(Status.c);
            return;
        } else
        {
            dataholder = new h(dataholder, 100, g);
            b.a(dataholder);
            return;
        }
    }

    public void b(DataHolder dataholder)
        throws RemoteException
    {
        if (dataholder == null)
        {
            if (Log.isLoggable(a, 6))
            {
                Log.e(a, (new StringBuilder()).append("onAutocompletePrediction received null DataHolder: ").append(vu.a()).toString());
            }
            c.d(Status.c);
            return;
        } else
        {
            c.a(new com.google.android.gms.location.places.b(dataholder));
            return;
        }
    }

    public void c(DataHolder dataholder)
        throws RemoteException
    {
        if (dataholder == null)
        {
            if (Log.isLoggable(a, 6))
            {
                Log.e(a, (new StringBuilder()).append("onPlaceUserDataFetched received null DataHolder: ").append(vu.a()).toString());
            }
            d.d(Status.c);
            return;
        } else
        {
            d.a(new com.google.android.gms.location.places.personalized.d(dataholder));
            return;
        }
    }

    public void d(DataHolder dataholder)
        throws RemoteException
    {
        dataholder = new com.google.android.gms.location.places.e(dataholder, g);
        f.a(dataholder);
    }

}
