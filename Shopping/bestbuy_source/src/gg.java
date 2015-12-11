// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.bestbuy.android.api.lib.models.solr.SolrResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class gg
{

    private static gh a;

    public static SolrResponse a(String s, Context context, String s1, String s2, String s3, int i, int j, boolean flag)
    {
        return a(s, context, null, s1, s2, s3, i, j, flag);
    }

    public static SolrResponse a(String s, Context context, ArrayList arraylist, String s1, String s2, String s3, int i, int j, 
            boolean flag)
    {
        String s4;
        SolrResponse solrresponse;
        ArrayList arraylist1;
        gh gh1;
        solrresponse = new SolrResponse();
        gh1 = a();
        s4 = "";
        arraylist1 = new ArrayList();
        if (!s.equals("RecentlyRemoved") && !s.equals("BundleItems") && !s.equals("PLP") && !s.equals("Best-Match")) goto _L2; else goto _L1
_L1:
        solrresponse.setTotalCount(arraylist.size());
        if (arraylist.size() > j)
        {
            int k = (i - 1) * j;
            j = k + j;
            i = j;
            if (j > arraylist.size())
            {
                i = arraylist.size();
            }
            arraylist1.addAll(arraylist.subList(k, i));
        } else
        {
            arraylist1.addAll(arraylist);
        }
_L8:
        solrresponse.setBbyProducts(gq.a(arraylist1));
        return solrresponse;
_L2:
        if (!s.equals("BestSelling")) goto _L4; else goto _L3
_L3:
label0:
        {
            if (s3 != null)
            {
                s = s3;
                if (!s3.isEmpty())
                {
                    break label0;
                }
            }
            s = "all";
        }
        context = (new StringBuilder()).append("/api/category/").append(s1).append("/store/").append(s).append("/items/purchased").toString();
_L6:
        s = (new StringBuilder()).append(gh1.f).append(context).toString();
        context = new HashMap();
        context.put("format", "json");
        context.put("show", "all");
        context.put("apiKey", gh1.g);
        context.put("itemsPerPage", (new StringBuilder()).append("").append(j).toString());
        context.put("page", (new StringBuilder()).append("").append(i).toString());
        try
        {
            s = gw.a(s, null, context);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d("EPManager", (new StringBuilder()).append("Could not get Most Popular Products Data: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        if (s != null)
        {
            solrresponse.setTotalCount((new JSONObject(s)).optJSONObject("_opensearch").optInt("totalResults", 0));
        }
        s = (new JSONObject(s)).getJSONArray("_entries");
        for (i = 0; i < s.length(); i++)
        {
            context = s.getJSONObject(i);
            if (context != null)
            {
                arraylist1.add(context.optString("id"));
            }
        }

        break; /* Loop/switch isn't completed */
_L4:
        if (s.equals("Trending"))
        {
            context = "/api/trending/items/viewed.json";
        } else
        if (s.equals("RecenltyViewed"))
        {
            if (!gf.a(context))
            {
                s = b();
                gf.a(context, s);
            } else
            {
                s = gf.b(context);
            }
            context = (new StringBuilder()).append("/api/context/").append(s).append("/items/viewed.json").toString();
        } else
        if (s.equals("Recommended"))
        {
            s = gf.b(context);
            context = (new StringBuilder()).append("/api/context/").append(s).append("/items/recommended.json").toString();
        } else
        if (s.equals("CustomerAlsoBought"))
        {
            context = (new StringBuilder()).append("/api/item/").append(s2).append("/alsobought").toString();
        } else
        if (s.equals("CustomerAlsoViewed"))
        {
            context = (new StringBuilder()).append("/api/item/").append(s2).append("/alsoviewed").toString();
        } else
        if (s.equals("MostPopular"))
        {
            context = (new StringBuilder()).append("/api/category/").append(s1).append("/items/popular").toString();
        } else
        {
            context = s4;
            if (s.equals("Similar"))
            {
                context = (new StringBuilder()).append("/api/item/").append(s2).append("/similarproducts.json").toString();
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        solrresponse.setSkuList(arraylist1);
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static gh a()
    {
        return a;
    }

    public static String a(String s, String s1)
    {
        gh gh1 = a();
        String s2 = (new StringBuilder()).append(gh1.f).append("/_.gif").toString();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("action", "pageView"));
        arraylist.add(new BasicNameValuePair("src", "MobileApp-Android"));
        arraylist.add(new BasicNameValuePair("itemId", s1));
        arraylist.add(new BasicNameValuePair("itemType", "product"));
        arraylist.add(new BasicNameValuePair("apiKey", gh1.g));
        s1 = new ArrayList();
        s1.add(new BasicNameValuePair("cookie", (new StringBuilder()).append("context_id=").append(s).toString()));
        try
        {
            s = gw.a(s2, arraylist, s1, null, true);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d("EPManager", (new StringBuilder()).append("Could not parse Recommended Products Data: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        return s;
    }

    public static void a(ft ft1)
    {
        if (ft1 == ft.a)
        {
            a = gh.a;
            return;
        }
        if (ft1 == ft.b)
        {
            a = gh.b;
            return;
        }
        if (ft1 == ft.e || ft1 == ft.g || ft1 == ft.h)
        {
            a = gh.c;
            return;
        }
        if (ft1 == ft.j)
        {
            a = gh.d;
            return;
        }
        if (ft1 == ft.l)
        {
            a = gh.e;
            return;
        } else
        {
            a = gh.a;
            return;
        }
    }

    public static void a(String s, String s1, Boolean boolean1)
    {
        gh gh1 = gh.a("CUSTOM");
        gh1.g = s1;
        gh1.f = s;
        gh1.j = boolean1.booleanValue();
    }

    public static void a(List list)
    {
        Object obj = a();
        obj = (new StringBuilder()).append(((gh) (obj)).f).append("/_.gif").toString();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        try
        {
            gw.c(((String) (obj)), list, arraylist, null, "application/json");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            gs.d("EPManager", (new StringBuilder()).append("Could not parse Recommended Products Data: ").append(list.getLocalizedMessage()).toString());
        }
        throw list;
    }

    public static String b()
    {
        Object obj = a();
        obj = (new StringBuilder()).append(((gh) (obj)).f).append("/_.gif").toString();
        HashMap hashmap = new HashMap();
        hashmap.put("format", "json");
        try
        {
            obj = (String)gw.b(((String) (obj)), "", "", null, hashmap).get("X-Context-ID");
            gs.c("EPManager", (new StringBuilder()).append("Got EP Context ID: ").append(((String) (obj))).toString());
        }
        catch (Exception exception)
        {
            gs.d("EPManager", (new StringBuilder()).append("Counld not get EP Context Id: ").append(exception.getLocalizedMessage()).toString());
            throw exception;
        }
        return ((String) (obj));
    }
}
