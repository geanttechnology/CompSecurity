// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.c;
import com.google.android.gms.location.places.k;
import com.google.android.gms.location.places.x;
import com.google.android.gms.maps.model.LatLngBounds;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            c

public class b
    implements c
{

    public b()
    {
    }

    public e a(com.google.android.gms.common.api.c c1, String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter)
    {
        return c1.a(new com.google.android.gms.location.places.x.a(k.a, c1, s, latlngbounds, autocompletefilter) {

            final String b;
            final LatLngBounds c;
            final AutocompleteFilter d;
            final b e;

            protected volatile void a(com.google.android.gms.common.api.a.c c2)
                throws RemoteException
            {
                a((com.google.android.gms.location.places.internal.c)c2);
            }

            protected void a(com.google.android.gms.location.places.internal.c c2)
                throws RemoteException
            {
                c2.a(new x(this), b, c, d);
            }

            
            {
                e = b.this;
                b = s;
                c = latlngbounds;
                d = autocompletefilter;
                super(d1, c1);
            }
        });
    }
}
