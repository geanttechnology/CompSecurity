// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

// Referenced classes of package com.amazon.device.ads:
//            ba, co, cn

class t
{
    private static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/amazon/device/ads/t$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("LOCATION_AWARENESS_NORMAL", 0);
            b = new a("LOCATION_AWARENESS_TRUNCATED", 1);
            c = new a("LOCATION_AWARENESS_DISABLED", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String a = com/amazon/device/ads/t.getSimpleName();
    private final cn b;
    private final ba c;
    private final Context d;

    public t(Context context)
    {
        this(context, ba.a());
    }

    private t(Context context, ba ba1)
    {
        new co();
        b = co.a(a);
        d = context;
        c = ba1;
    }

    private static double a(double d1)
    {
        return (double)Math.round(d1 * 60D) / 60D;
    }

    public final Location a()
    {
        float f1 = 3.402823E+38F;
        a a1;
        if (c.b(ba.a.g))
        {
            a1 = a.b;
        } else
        {
            a1 = a.a;
        }
        if (!a.c.equals(a1))
        {
            Object obj = (LocationManager)d.getSystemService("location");
            Object obj1;
            try
            {
                obj1 = ((LocationManager) (obj)).getLastKnownLocation("gps");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                b.b("Failed to retrieve GPS location: No permissions to access GPS", null);
                obj1 = null;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                b.b("Failed to retrieve GPS location: No GPS found", null);
                obj1 = null;
            }
            try
            {
                obj = ((LocationManager) (obj)).getLastKnownLocation("network");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                b.b("Failed to retrieve network location: No permissions to access network location", null);
                obj = null;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                b.b("Failed to retrieve network location: No network provider found", null);
                obj = null;
            }
            if (obj1 != null || obj != null)
            {
                if (obj1 != null && obj != null)
                {
                    if (((Location) (obj1)).distanceTo(((Location) (obj))) / 1000F <= 3F)
                    {
                        float f;
                        if (((Location) (obj1)).hasAccuracy())
                        {
                            f = ((Location) (obj1)).getAccuracy();
                        } else
                        {
                            f = 3.402823E+38F;
                        }
                        if (((Location) (obj)).hasAccuracy())
                        {
                            f1 = ((Location) (obj)).getAccuracy();
                        }
                        if (f < f1)
                        {
                            b.b("Setting lat/long using GPS determined by distance", null);
                        } else
                        {
                            b.b("Setting lat/long using network determined by distance", null);
                            obj1 = obj;
                        }
                    } else
                    if (((Location) (obj1)).getTime() > ((Location) (obj)).getTime())
                    {
                        b.b("Setting lat/long using GPS", null);
                    } else
                    {
                        b.b("Setting lat/long using network", null);
                        obj1 = obj;
                    }
                } else
                if (obj1 != null)
                {
                    b.b("Setting lat/long using GPS, not network", null);
                } else
                {
                    b.b("Setting lat/long using network location, not GPS", null);
                    obj1 = obj;
                }
                if (a.b.equals(a1))
                {
                    ((Location) (obj1)).setLatitude((double)Math.round(a(((Location) (obj1)).getLatitude()) * Math.pow(10D, 6D)) / Math.pow(10D, 6D));
                    ((Location) (obj1)).setLongitude((double)Math.round(a(((Location) (obj1)).getLongitude()) * Math.pow(10D, 6D)) / Math.pow(10D, 6D));
                }
                return ((Location) (obj1));
            }
        }
        return null;
    }

}
