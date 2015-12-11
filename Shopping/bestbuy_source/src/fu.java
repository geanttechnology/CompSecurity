// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.bestbuy.android.api.lib.models.remix.Store;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class fu
{

    public static fv a;
    private static String b = fu.getSimpleName();

    public fu()
    {
    }

    public static fv a()
    {
        return a;
    }

    public static String a(String s)
    {
        s = (new StringBuilder()).append(a.c).append("/products(upc=").append(s).append("&active=*&marketplace=*)").toString();
        HashMap hashmap = new HashMap();
        hashmap.put("format", "json");
        hashmap.put("show", "all");
        hashmap.put("apiKey", a.d);
        try
        {
            s = gw.a(s, null, hashmap);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d(b, (new StringBuilder()).append("Could not get getProductDetailsUsingUPCCode: ").append(s.getLocalizedMessage()).toString());
            return "";
        }
        return s;
    }

    public static void a(ft ft1)
    {
        if (ft1 == ft.a)
        {
            a = fv.a;
            return;
        }
        if (ft1 == ft.l)
        {
            a = fv.b;
            return;
        } else
        {
            a = fv.a;
            return;
        }
    }

    public static void a(String s, String s1)
    {
        fv fv1 = fv.a("CUSTOM");
        fv1.d = s1;
        fv1.c = s;
    }

    public static Store b(String s)
    {
        fv fv1 = a();
        s = (new StringBuilder()).append(fv1.c).append("/stores(storeId=").append(s).append(")").toString();
        HashMap hashmap = new HashMap();
        hashmap.put("format", "json");
        hashmap.put("show", "all");
        hashmap.put("page", "1");
        hashmap.put("apiKey", fv1.d);
        try
        {
            s = gw.a(s, null, hashmap);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d(b, (new StringBuilder()).append("Could not get Full Product Detail by Sku: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        return c(s);
    }

    private static Store c(String s)
    {
        if (s != null)
        {
            if ((s = (new JSONObject(s)).getJSONArray("stores")).length() > 0)
            {
                return new Store(s.getJSONObject(0));
            }
        }
        return null;
    }

    static 
    {
        a = fv.a;
    }
}
