// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            PlacesParams, e

public class c extends l
{
    public static class a extends com.google.android.gms.common.api.a.b
    {

        private final String a;
        private final String b;

        public volatile com.google.android.gms.common.api.a.c a(Context context, Looper looper, h h1, Object obj, com.google.android.gms.common.api.b b1, com.google.android.gms.common.api.c c1)
        {
            return a(context, looper, h1, (com.google.android.gms.location.places.l)obj, b1, c1);
        }

        public c a(Context context, Looper looper, h h1, com.google.android.gms.location.places.l l1, com.google.android.gms.common.api.b b1, com.google.android.gms.common.api.c c1)
        {
            String s;
            String s1;
            if (a != null)
            {
                s = a;
            } else
            {
                s = context.getPackageName();
            }
            if (b != null)
            {
                s1 = b;
            } else
            {
                s1 = context.getPackageName();
            }
            if (l1 == null)
            {
                l1 = (new com.google.android.gms.location.places.l.a()).a();
            }
            return new c(context, looper, h1, b1, c1, s, s1, l1);
        }

        public a(String s, String s1)
        {
            a = s;
            b = s1;
        }
    }


    private final PlacesParams a;
    private final Locale b = Locale.getDefault();

    public c(Context context, Looper looper, h h1, com.google.android.gms.common.api.b b1, com.google.android.gms.common.api.c c1, String s, String s1, 
            com.google.android.gms.location.places.l l1)
    {
        super(context, looper, 65, h1, b1, c1);
        context = null;
        if (h1.b() != null)
        {
            context = h1.b().name;
        }
        a = new PlacesParams(s, b, context, l1.a, s1);
    }

    protected e a(IBinder ibinder)
    {
        return e.a.a(ibinder);
    }

    public void a(com.google.android.gms.location.places.x x1, String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter)
        throws RemoteException
    {
        x.a(s, "query == null");
        x.a(latlngbounds, "bounds == null");
        x.a(x1, "callback == null");
        if (autocompletefilter == null)
        {
            autocompletefilter = AutocompleteFilter.a(null);
        }
        ((e)zzoA()).a(s, latlngbounds, autocompletefilter, a, x1);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return a(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }
}
