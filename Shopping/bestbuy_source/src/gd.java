// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.bestbuy.android.api.lib.models.deals.StoreDeals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class gd
{

    public static ge a;
    private static final String b = gd.getSimpleName();

    public gd()
    {
    }

    public static StoreDeals a(String s)
    {
        ge ge1 = a();
        s = (new StringBuilder()).append(ge1.d).append("/stats/top_deals/").append(s).toString();
        HashMap hashmap = new HashMap();
        hashmap.put("api_key", ge1.e);
        try
        {
            s = b(gw.a(s, null, hashmap));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d(b, (new StringBuilder()).append("Error making GET request: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        return s;
    }

    public static ge a()
    {
        return a;
    }

    public static void a(ft ft1)
    {
        if (ft1 == ft.a)
        {
            a = ge.a;
            return;
        }
        if (ft1 == ft.b)
        {
            a = ge.b;
            return;
        }
        if (ft1 == ft.l)
        {
            a = ge.c;
            return;
        } else
        {
            a = ge.a;
            return;
        }
    }

    public static void a(String s, String s1)
    {
        ge ge1 = ge.a("CUSTOM");
        ge1.e = s1;
        ge1.d = s;
    }

    private static StoreDeals b(String s)
    {
        StoreDeals storedeals = new StoreDeals();
        s = new JSONObject(s);
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        if (s != null)
        {
            JSONArray jsonarray = s.names();
            if (jsonarray != null)
            {
                for (int i = 0; i < jsonarray.length(); i++)
                {
                    if (jsonarray.isNull(i))
                    {
                        continue;
                    }
                    String s1 = jsonarray.getString(i);
                    if (s1.equals("categories"))
                    {
                        continue;
                    }
                    JSONArray jsonarray1 = s.optJSONArray(s1);
                    if (jsonarray1 != null)
                    {
                        ArrayList arraylist1 = new ArrayList();
                        for (int j = 0; j < jsonarray1.length(); j++)
                        {
                            arraylist1.add(jsonarray1.optJSONObject(j).optString("sku"));
                        }

                        hashmap.put(s1, arraylist1);
                    }
                    arraylist.add(s1);
                }

                storedeals.setDeals(hashmap);
                storedeals.setCategories(arraylist);
            }
        }
        return storedeals;
    }

}
