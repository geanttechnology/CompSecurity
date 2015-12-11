// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.bestbuy.android.api.lib.models.offers.Offer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class gm
{

    public static gn a;
    private static final String b = gm.getSimpleName();

    public gm()
    {
    }

    public static gn a()
    {
        return a;
    }

    private static ArrayList a(String s)
    {
        return Offer.loadOffersData(s);
    }

    public static void a(ft ft1)
    {
        if (ft1 == ft.a)
        {
            a = gn.a;
            return;
        }
        if (ft1 == ft.e || ft1 == ft.g || ft1 == ft.h)
        {
            a = gn.b;
            return;
        }
        if (ft1 == ft.l)
        {
            a = gn.c;
            return;
        } else
        {
            a = gn.a;
            return;
        }
    }

    public static void a(String s, String s1)
    {
        gn gn1 = gn.a("CUSTOM");
        gn1.e = s1;
        gn1.d = s;
    }

    public static ArrayList b()
    {
        Object obj = a();
        String s = (new StringBuilder()).append(((gn) (obj)).d).append("/api/v1/offer").toString();
        HashMap hashmap = new HashMap();
        hashmap.put("api_key", ((gn) (obj)).e);
        hashmap.put("channel_key", "bby-mobile-app-promo-banner");
        try
        {
            obj = a(gw.a(s, null, hashmap));
        }
        catch (Exception exception)
        {
            gs.e(b, (new StringBuilder()).append("Could not get SKU Based Offers: ").append(exception.getLocalizedMessage()).toString());
            throw exception;
        }
        return ((ArrayList) (obj));
    }

    private static ArrayList b(String s)
    {
        return Offer.loadOffersData(s);
    }

    public static ArrayList c()
    {
        Object obj = a();
        String s = (new StringBuilder()).append(((gn) (obj)).d).append("/api/v1/offer").toString();
        HashMap hashmap = new HashMap();
        hashmap.put("api_key", ((gn) (obj)).e);
        hashmap.put("channel_key", "life-events");
        hashmap.put("priority=", "true");
        try
        {
            obj = b(gw.a(s, null, hashmap));
        }
        catch (Exception exception)
        {
            gs.e(b, (new StringBuilder()).append("Could not get SKU Based Offers: ").append(exception.getLocalizedMessage()).toString());
            throw exception;
        }
        return ((ArrayList) (obj));
    }

}
