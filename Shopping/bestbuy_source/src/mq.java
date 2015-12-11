// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.api.lib.models.product.Product;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.message.BasicNameValuePair;

public class mq
{

    private ArrayList a;
    private ArrayList b;
    private ArrayList c;
    private ArrayList d;
    private ArrayList e;
    private ArrayList f;
    private String g;

    public mq()
    {
        g = "MobileApp-Android";
    }

    public ArrayList a()
    {
        return c;
    }

    public List a(String s, BBYProduct bbyproduct)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", "product"));
        arraylist.add(new BasicNameValuePair("action", "uiClick"));
        if (s.equals("customeralsobought"))
        {
            arraylist.add(new BasicNameValuePair("actionLabel", "alsoBought"));
        } else
        {
            arraylist.add(new BasicNameValuePair("actionLabel", "alsoViewed"));
        }
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", bbyproduct.getSkuId()));
        arraylist.add(new BasicNameValuePair("pageTitle", PDPFragment.c().getTitle()));
        arraylist.add(new BasicNameValuePair("pageName", "product"));
        arraylist.add(new BasicNameValuePair("track", "recClick"));
        arraylist.add(new BasicNameValuePair("ep1", bbyproduct.getEp()));
        return arraylist;
    }

    public List a(String s, String s1)
    {
        s = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", "GHP"));
        arraylist.add(new BasicNameValuePair("action", "recLoad"));
        arraylist.add(new BasicNameValuePair("actionLabel", "trendingNow"));
        arraylist.add(new BasicNameValuePair("clientTime", s.getTime().toString()));
        arraylist.add(new BasicNameValuePair("pageTitle", "HomePage"));
        arraylist.add(new BasicNameValuePair("pageName", "HomePage"));
        arraylist.add(new BasicNameValuePair("tpvSku", f()));
        arraylist.add(new BasicNameValuePair("track", "recLoad"));
        arraylist.add(new BasicNameValuePair("ep1", s1));
        return arraylist;
    }

    public List a(String s, String s1, BBYProduct bbyproduct)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", s));
        arraylist.add(new BasicNameValuePair("action", "recLoad"));
        arraylist.add(new BasicNameValuePair("actionLabel", "recentlyViewed"));
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", bbyproduct.getSkuId()));
        if (s.equals("LE") || s.equals("WR"))
        {
            arraylist.add(new BasicNameValuePair("pageTitle", "Registry"));
            arraylist.add(new BasicNameValuePair("pageName", "Registry"));
        } else
        {
            arraylist.add(new BasicNameValuePair("pageTitle", "HomePage"));
            arraylist.add(new BasicNameValuePair("pageName", "HomePage"));
        }
        arraylist.add(new BasicNameValuePair("rvSku", s1));
        arraylist.add(new BasicNameValuePair("track", "recLoad"));
        arraylist.add(new BasicNameValuePair("ep1", bbyproduct.getEp()));
        return arraylist;
    }

    public List a(String s, String s1, String s2)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", "product"));
        arraylist.add(new BasicNameValuePair("action", "addToCart"));
        if (s2.equals("customeralsobought"))
        {
            arraylist.add(new BasicNameValuePair("actionLabel", "alsoBought"));
        } else
        {
            arraylist.add(new BasicNameValuePair("actionLabel", "alsoViewed"));
        }
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", s));
        arraylist.add(new BasicNameValuePair("pageTitle", "product"));
        arraylist.add(new BasicNameValuePair("track", "recLoad"));
        arraylist.add(new BasicNameValuePair("pageName", "product"));
        arraylist.add(new BasicNameValuePair("ep1", s1));
        return arraylist;
    }

    public void a(ArrayList arraylist)
    {
        a = new ArrayList();
        b = new ArrayList();
        for (int i = 0; i < arraylist.size(); i++)
        {
            BBYProduct bbyproduct = (BBYProduct)arraylist.get(i);
            if (bbyproduct != null)
            {
                a.add(bbyproduct.getSkuId());
                b.add(bbyproduct.getEp());
            }
        }

    }

    public ArrayList b()
    {
        return a;
    }

    public List b(String s, BBYProduct bbyproduct)
    {
        s = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", "GHP"));
        arraylist.add(new BasicNameValuePair("action", "uiClick"));
        arraylist.add(new BasicNameValuePair("actionLabel", "trendingNow"));
        arraylist.add(new BasicNameValuePair("clientTime", s.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", bbyproduct.getSkuId()));
        arraylist.add(new BasicNameValuePair("pageTitle", "HomePage"));
        arraylist.add(new BasicNameValuePair("pageName", "HomePage"));
        arraylist.add(new BasicNameValuePair("track", "recClick"));
        arraylist.add(new BasicNameValuePair("ep1", bbyproduct.getEp()));
        return arraylist;
    }

    public List b(String s, String s1)
    {
        Calendar calendar;
        ArrayList arraylist;
        calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        if (!s.equals("product")) goto _L2; else goto _L1
_L1:
        arraylist.add(new BasicNameValuePair("itemType", "products"));
_L4:
        arraylist.add(new BasicNameValuePair("action", "recLoad"));
        arraylist.add(new BasicNameValuePair("actionLabel", "mostPopular"));
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("mvSku", e()));
        arraylist.add(new BasicNameValuePair("track", "recLoad"));
        arraylist.add(new BasicNameValuePair("ep1", s1));
        return arraylist;
_L2:
        if (s.equals("cart"))
        {
            arraylist.add(new BasicNameValuePair("itemType", "CRT"));
        } else
        if (s.equals("store"))
        {
            arraylist.add(new BasicNameValuePair("itemType", "stores"));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List b(String s, String s1, BBYProduct bbyproduct)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", s));
        arraylist.add(new BasicNameValuePair("action", "recLoad"));
        arraylist.add(new BasicNameValuePair("actionLabel", "alsoViewed"));
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", bbyproduct.getSkuId()));
        arraylist.add(new BasicNameValuePair("pageTitle", "HomePage"));
        arraylist.add(new BasicNameValuePair("pageName", "HomePage"));
        arraylist.add(new BasicNameValuePair("avSku", s1));
        arraylist.add(new BasicNameValuePair("track", "recLoad"));
        arraylist.add(new BasicNameValuePair("ep1", bbyproduct.getEp()));
        return arraylist;
    }

    public void b(ArrayList arraylist)
    {
        c = new ArrayList();
        d = new ArrayList();
        for (int i = 0; i < arraylist.size(); i++)
        {
            BBYProduct bbyproduct = (BBYProduct)arraylist.get(i);
            if (bbyproduct != null)
            {
                c.add(bbyproduct.getSkuId());
                d.add(bbyproduct.getEp());
            }
        }

    }

    public String c()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < c.size(); i++)
        {
            stringbuilder.append((String)c.get(i));
            if (i != c.size() - 1)
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder.toString();
    }

    public List c(String s, BBYProduct bbyproduct)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        if (s.equals("product"))
        {
            arraylist.add(new BasicNameValuePair("itemType", "products"));
        } else
        if (s.equals("cart"))
        {
            arraylist.add(new BasicNameValuePair("itemType", "CRT"));
        } else
        if (s.equals("stores"))
        {
            arraylist.add(new BasicNameValuePair("itemType", "stores"));
        }
        arraylist.add(new BasicNameValuePair("action", "uiClick"));
        arraylist.add(new BasicNameValuePair("actionLabel", "mostPopular"));
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", bbyproduct.getSkuId()));
        if (s.equals("product"))
        {
            arraylist.add(new BasicNameValuePair("pageTitle", "products"));
            arraylist.add(new BasicNameValuePair("pageName", "products"));
        } else
        if (s.equals("cart"))
        {
            arraylist.add(new BasicNameValuePair("pageTitle", "CRT"));
            arraylist.add(new BasicNameValuePair("pageName", "CRT"));
        } else
        if (s.equals("stores"))
        {
            arraylist.add(new BasicNameValuePair("pageTitle", "stores"));
            arraylist.add(new BasicNameValuePair("pageName", "stores"));
        }
        arraylist.add(new BasicNameValuePair("track", "recClick"));
        arraylist.add(new BasicNameValuePair("ep1", bbyproduct.getEp()));
        return arraylist;
    }

    public void c(ArrayList arraylist)
    {
        e = new ArrayList();
        for (int i = 0; i < arraylist.size(); i++)
        {
            e.add(((BBYProduct)arraylist.get(i)).getSkuId());
        }

    }

    public String d()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < a.size(); i++)
        {
            stringbuilder.append((String)a.get(i));
            if (i != a.size() - 1)
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder.toString();
    }

    public List d(String s, BBYProduct bbyproduct)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", s));
        arraylist.add(new BasicNameValuePair("action", "uiClick"));
        arraylist.add(new BasicNameValuePair("actionLabel", "recentlyViewed"));
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", bbyproduct.getSkuId()));
        if (s.equals("LE") || s.equals("WR"))
        {
            arraylist.add(new BasicNameValuePair("pageTitle", "Registry"));
            arraylist.add(new BasicNameValuePair("pageName", "Registry"));
        } else
        {
            arraylist.add(new BasicNameValuePair("pageTitle", "HomePage"));
            arraylist.add(new BasicNameValuePair("pageName", "HomePage"));
        }
        arraylist.add(new BasicNameValuePair("track", "recClick"));
        arraylist.add(new BasicNameValuePair("ep1", bbyproduct.getEp()));
        return arraylist;
    }

    public void d(ArrayList arraylist)
    {
        f = new ArrayList();
        for (int i = 0; i < arraylist.size(); i++)
        {
            f.add(((BBYProduct)arraylist.get(i)).getSkuId());
        }

    }

    public String e()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < e.size(); i++)
        {
            stringbuilder.append((String)e.get(i));
            if (i != e.size() - 1)
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder.toString();
    }

    public List e(String s, BBYProduct bbyproduct)
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", s));
        arraylist.add(new BasicNameValuePair("action", "uiClick"));
        arraylist.add(new BasicNameValuePair("actionLabel", "alsoViewed"));
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", bbyproduct.getSkuId()));
        arraylist.add(new BasicNameValuePair("pageTitle", "HomePage"));
        arraylist.add(new BasicNameValuePair("pageName", "HomePage"));
        arraylist.add(new BasicNameValuePair("track", "recClick"));
        arraylist.add(new BasicNameValuePair("ep1", bbyproduct.getEp()));
        return arraylist;
    }

    public String f()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < f.size(); i++)
        {
            stringbuilder.append((String)f.get(i));
            if (i != f.size() - 1)
            {
                stringbuilder.append(',');
            }
        }

        return stringbuilder.toString();
    }

    public List g()
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", "product"));
        arraylist.add(new BasicNameValuePair("action", "recLoad"));
        arraylist.add(new BasicNameValuePair("actionLabel", "alsoBought"));
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", PDPFragment.b()));
        arraylist.add(new BasicNameValuePair("pageTitle", PDPFragment.c().getTitle()));
        arraylist.add(new BasicNameValuePair("track", "recLoad"));
        arraylist.add(new BasicNameValuePair("pageName", "product"));
        arraylist.add(new BasicNameValuePair("abSku", d()));
        arraylist.add(new BasicNameValuePair("ep1", (String)b.get(0)));
        return arraylist;
    }

    public List h()
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US);
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("src", g));
        arraylist.add(new BasicNameValuePair("itemType", "product"));
        arraylist.add(new BasicNameValuePair("action", "recLoad"));
        arraylist.add(new BasicNameValuePair("actionLabel", "alsoViewed"));
        arraylist.add(new BasicNameValuePair("clientTime", calendar.getTime().toString()));
        arraylist.add(new BasicNameValuePair("itemId", PDPFragment.b()));
        arraylist.add(new BasicNameValuePair("pageTitle", PDPFragment.c().getTitle()));
        arraylist.add(new BasicNameValuePair("track", "recLoad"));
        arraylist.add(new BasicNameValuePair("pageName", "product"));
        arraylist.add(new BasicNameValuePair("avSku", c()));
        arraylist.add(new BasicNameValuePair("ep1", (String)d.get(0)));
        return arraylist;
    }
}
