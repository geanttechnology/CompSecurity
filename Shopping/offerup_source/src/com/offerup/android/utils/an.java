// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.location.LocationManager;
import com.b.a.a.g;
import com.b.a.a.j;
import java.util.Calendar;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

// Referenced classes of package com.offerup.android.utils:
//            OfferUpLocation, ao, as

public final class an
{

    private static String a = "LocationService";
    private static Location b;
    private static Location c;
    private static Address d;
    private static Address e;
    private static LocationManager f;

    public static OfferUpLocation a(int i)
    {
        g.a(a, "getLocationFromPrefs");
        OfferUpLocation offeruplocation = new OfferUpLocation();
        j j1 = j.a();
        switch (ao.a[i - 1])
        {
        default:
            return offeruplocation;

        case 1: // '\001'
            offeruplocation.b(NumberUtils.toDouble(j1.G()));
            offeruplocation.a(NumberUtils.toDouble(j1.F()));
            offeruplocation.a(j1.E());
            offeruplocation.c(j1.I());
            offeruplocation.d(j1.J());
            offeruplocation.a(j1.H());
            return offeruplocation;

        case 2: // '\002'
            offeruplocation.b(NumberUtils.toDouble(j1.M()));
            break;
        }
        offeruplocation.a(NumberUtils.toDouble(j1.L()));
        offeruplocation.a(j1.K());
        offeruplocation.c(j1.N());
        offeruplocation.d(j1.O());
        offeruplocation.a(j1.P());
        return offeruplocation;
    }

    public static OfferUpLocation a(Context context, int i, String s, boolean flag, boolean flag1, boolean flag2)
    {
        Object obj1;
        g.a(a, (new StringBuilder("lookupLocation with zip=")).append(s).toString());
        obj1 = c(i);
        ao.a[i - 1];
        JVM INSTR tableswitch 1 2: default 56
    //                   1 286
    //                   2 294;
           goto _L1 _L2 _L3
_L1:
        Object obj = null;
_L4:
        if (StringUtils.isNotEmpty(s))
        {
            g.a(a, "getAddress with zip");
            context = as.a(context, s);
            a(i, ((Address) (context)));
            obj = obj1;
        } else
        {
            if (obj1 == null)
            {
                flag2 = false;
                flag = false;
                obj1 = c(i);
                if (f == null)
                {
                    f = (LocationManager)context.getSystemService("location");
                }
                if (obj1 == null || ((Location) (obj1)).getLatitude() == 47.609999899999998D && ((Location) (obj1)).getLongitude() == -122.33399999D)
                {
                    obj1 = f.getLastKnownLocation("passive");
                    if (obj1 == null)
                    {
                        obj1 = new Location("passive");
                        ((Location) (obj1)).setLatitude(47.609999899999998D);
                        ((Location) (obj1)).setLongitude(-122.33399999D);
                    } else
                    {
                        flag = true;
                    }
                    a(i, ((Location) (obj1)));
                } else
                {
                    flag = flag2;
                }
                g.a(a, (new StringBuilder("getBareBonesLocation newLocation = ")).append(flag).toString());
                a(i, ((Location) (obj1)));
            }
            if (obj == null || StringUtils.isEmpty(((Address) (obj)).getLocality()))
            {
                g.a(a, "getAddress with location");
                context = as.a(context, ((Location) (obj1)).getLatitude(), ((Location) (obj1)).getLongitude());
                a(i, ((Address) (context)));
                obj = obj1;
            } else
            {
                context = ((Context) (obj));
                obj = obj1;
            }
        }
        obj1 = context;
        if (context == null)
        {
            obj1 = new Address(Locale.getDefault());
            if (StringUtils.isNotEmpty(s))
            {
                ((Address) (obj1)).setPostalCode(s);
            } else
            if (obj != null)
            {
                ((Address) (obj1)).setLatitude(((Location) (obj)).getLatitude());
                ((Address) (obj1)).setLongitude(((Location) (obj)).getLongitude());
            } else
            {
                ((Address) (obj1)).setLongitude(-122.33399999D);
                ((Address) (obj1)).setLatitude(47.609999899999998D);
            }
            a(i, ((Address) (obj1)));
        }
        context = new OfferUpLocation();
        if (((Address) (obj1)).hasLongitude() && ((Address) (obj1)).hasLatitude())
        {
            context.b(((Address) (obj1)).getLatitude());
            context.a(((Address) (obj1)).getLongitude());
        }
        if ((StringUtils.isNotEmpty(((Address) (obj1)).getLocality()) || StringUtils.isNotEmpty(((Address) (obj1)).getSubLocality())) && StringUtils.isNotEmpty(((Address) (obj1)).getAdminArea()))
        {
            if (StringUtils.isNotEmpty(((Address) (obj1)).getLocality()))
            {
                context.c(((Address) (obj1)).getLocality());
            } else
            {
                context.c(((Address) (obj1)).getSubLocality());
            }
            context.d(((Address) (obj1)).getAdminArea());
            context.b(((Address) (obj1)).getPostalCode());
        }
        context.a(flag1);
        context.a(s);
        obj = j.a();
        switch (ao.a[i - 1])
        {
        default:
            return context;

        case 1: // '\001'
            ((j) (obj)).m(flag1);
            ((j) (obj)).s(context.f());
            ((j) (obj)).t(context.h());
            ((j) (obj)).q(String.valueOf(context.c()));
            ((j) (obj)).r(String.valueOf(context.d()));
            if (StringUtils.isNotEmpty(s))
            {
                ((j) (obj)).p(s);
                return context;
            } else
            {
                ((j) (obj)).p(null);
                return context;
            }

        case 2: // '\002'
            ((j) (obj)).q(flag1);
            ((j) (obj)).D(context.f());
            ((j) (obj)).E(context.h());
            ((j) (obj)).C(String.valueOf(context.d()));
            ((j) (obj)).B(String.valueOf(context.c()));
            break;
        }
        break MISSING_BLOCK_LABEL_680;
_L2:
        obj = d;
          goto _L4
_L3:
        obj = e;
          goto _L4
        if (StringUtils.isNotEmpty(s))
        {
            ((j) (obj)).A(s);
            return context;
        }
        ((j) (obj)).A(null);
        return context;
          goto _L4
    }

    public static void a(int i, Address address)
    {
        switch (ao.a[i - 1])
        {
        default:
            return;

        case 1: // '\001'
            d = address;
            Calendar.getInstance();
            return;

        case 2: // '\002'
            e = address;
            break;
        }
        Calendar.getInstance();
    }

    public static void a(int i, Location location)
    {
        switch (ao.a[i - 1])
        {
        default:
            return;

        case 1: // '\001'
            b = location;
            Calendar.getInstance();
            d = null;
            return;

        case 2: // '\002'
            c = location;
            break;
        }
        Calendar.getInstance();
        e = null;
    }

    public static void a(int i, OfferUpLocation offeruplocation)
    {
        g.a(a, "storeLocation");
        j j1 = j.a();
        switch (ao.a[i - 1])
        {
        default:
            return;

        case 1: // '\001'
            j1.m(offeruplocation.e());
            j1.s(offeruplocation.f());
            j1.t(offeruplocation.h());
            j1.q(String.valueOf(offeruplocation.c()));
            j1.r(String.valueOf(offeruplocation.d()));
            j1.p(offeruplocation.a());
            return;

        case 2: // '\002'
            j1.q(offeruplocation.e());
            break;
        }
        j1.D(offeruplocation.f());
        j1.E(offeruplocation.h());
        j1.C(String.valueOf(offeruplocation.d()));
        j1.B(String.valueOf(offeruplocation.c()));
        j1.A(offeruplocation.a());
    }

    public static boolean b(int i)
    {
        j j1;
        boolean flag;
        j1 = j.a();
        flag = false;
        ao.a[i - 1];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 61
    //                   2 69;
           goto _L1 _L2 _L3
_L1:
        g.a(a, (new StringBuilder("isLocationUserStored = ")).append(flag).toString());
        return flag;
_L2:
        flag = j1.H();
        continue; /* Loop/switch isn't completed */
_L3:
        flag = j1.P();
        if (true) goto _L1; else goto _L4
_L4:
    }

    private static Location c(int i)
    {
        switch (ao.a[i - 1])
        {
        default:
            return null;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;
        }
    }

}
