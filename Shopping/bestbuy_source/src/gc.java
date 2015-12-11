// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import com.bestbuy.android.api.lib.models.dnm.DNMFacetFilter;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.dnm.DNMResponse;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class gc
{

    private static final String a = gc.getSimpleName();

    public gc()
    {
    }

    public static DNMResponse a(double d, double d1, int i, int j, int k, String s, 
            String s1, String s2, ArrayList arraylist, String s3, String s4)
    {
        s4 = a();
        s4 = (new StringBuilder()).append(((gp) (s4)).e).append("/site/svc/bestbuy/dnm/dnmsearch/SUBLIST").toString();
        HashMap hashmap = new HashMap();
        if (s2 != null && !s2.isEmpty())
        {
            hashmap.put("strId", (new StringBuilder()).append("").append(s2).toString());
        } else
        {
            hashmap.put("ld", (new StringBuilder()).append("").append(d).toString());
            hashmap.put("lg", (new StringBuilder()).append("").append(d1).toString());
            hashmap.put("rd", (new StringBuilder()).append("").append(i).toString());
        }
        hashmap.put("cp", (new StringBuilder()).append("").append(j).toString());
        hashmap.put("nrp", (new StringBuilder()).append("").append(k).toString());
        if (s.equals("OpenBox"))
        {
            s = "ob";
        } else
        {
            s = "cr";
        }
        hashmap.put("dt", s);
        hashmap.put("skuId", s1);
        if (s3 != null && !s3.isEmpty())
        {
            hashmap.put("sp", s3);
        } else
        {
            hashmap.put("sp", "rating");
        }
        if (arraylist != null && !arraylist.isEmpty())
        {
            s = "";
            i = 0;
            while (i < arraylist.size()) 
            {
                if (arraylist.size() == 1)
                {
                    s1 = (DNMFacetFilter)arraylist.get(i);
                    s = (new StringBuilder()).append(s).append(b(s1.getFilterQuery())).toString();
                } else
                {
                    s1 = (DNMFacetFilter)arraylist.get(i);
                    s = (new StringBuilder()).append(s).append(b(s1.getFilterQuery())).toString();
                    if (i == arraylist.size() - 1)
                    {
                        s = (new StringBuilder()).append(s).append("").toString();
                    } else
                    {
                        s = (new StringBuilder()).append(s).append("~@~").toString();
                    }
                }
                i++;
            }
            if (!s.isEmpty())
            {
                hashmap.put("fp", s);
            }
        } else
        {
            hashmap.put("fp", "");
        }
        hashmap.put("smff", "Store~@~Brand");
        try
        {
            s = a(gw.a(s4, null, hashmap));
            if (s.getProductSkus() != null && !s.getProductSkus().isEmpty())
            {
                s.setBbyProducts(gq.a(s.getProductSkus()));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.e(a, (new StringBuilder()).append("Could not get Special Offer Products: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        return s;
    }

    private static DNMResponse a(String s)
    {
        return DNMResponse.loadDNMData(new JSONObject(s));
    }

    public static DNMResponse a(String s, double d, double d1, int i, int j, int k, 
            String s1, ArrayList arraylist, String s2, String s3)
    {
        Object obj = a();
        obj = (new StringBuilder()).append(((gp) (obj)).e).append("/site/svc/bestbuy/dnm/dnmsearch/MAINLIST?").toString();
        if (s != null && !s.isEmpty())
        {
            s = (new StringBuilder()).append(((String) (obj))).append("strId=").append(s).toString();
        } else
        {
            s = (new StringBuilder()).append(((String) (obj))).append("ld=").append(d).toString();
            s = (new StringBuilder()).append(s).append("&lg=").append(d1).toString();
            s = (new StringBuilder()).append(s).append("&rd=").append(i).toString();
        }
        if (arraylist != null && !arraylist.isEmpty())
        {
            obj = "";
            for (i = 0; i < arraylist.size(); i++)
            {
                DNMFacetFilter dnmfacetfilter = (DNMFacetFilter)arraylist.get(i);
                obj = (new StringBuilder()).append(((String) (obj))).append(b(dnmfacetfilter.getFilterQuery())).toString();
                obj = (new StringBuilder()).append(((String) (obj))).append("~@~").toString();
            }

            arraylist = (new StringBuilder()).append(((String) (obj))).append(c(s1)).toString();
            s1 = s;
            if (!arraylist.isEmpty())
            {
                s1 = (new StringBuilder()).append(s).append("&fp=").append(arraylist).toString();
            }
        } else
        {
            s1 = (new StringBuilder()).append(s).append("&fp=").append(c(s1)).toString();
        }
        if (s2 != null && !s2.isEmpty())
        {
            s = (new StringBuilder()).append(s1).append("&sp=").append(s2).toString();
        } else
        {
            s = (new StringBuilder()).append(s1).append("&sp=").append("rating").toString();
        }
        if (s3 != null && !s3.isEmpty())
        {
            if (s3 != null && TextUtils.isDigitsOnly(s3))
            {
                s = (new StringBuilder()).append(s).append("&skuId=").append(s3).toString();
            } else
            {
                s = (new StringBuilder()).append(s).append("&st=").append(s3).toString();
            }
        } else
        {
            s = (new StringBuilder()).append(s).append("&cp=").append(j).toString();
            s = (new StringBuilder()).append(s).append("&nrp=").append(k).toString();
        }
        s = (new StringBuilder()).append(s).append("&smff=").append("Store~@~Brand").toString();
        s = a(gw.a(s, null, null));
        new ArrayList();
        if (s.getProductSkus() == null || s.getProductSkus().isEmpty())
        {
            break MISSING_BLOCK_LABEL_768;
        }
        arraylist = gq.a(s.getProductSkus());
        s.setBbyProducts(arraylist);
        s1 = new HashMap();
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); s1.put(s2.getSkuId(), s2))
        {
            s2 = (BBYProduct)arraylist.next();
        }

        try
        {
            arraylist = new ArrayList();
            s2 = s.getDnmProducts().iterator();
            do
            {
                if (!s2.hasNext())
                {
                    break;
                }
                s3 = (DNMProduct)s2.next();
                if (s1.containsKey(s3.getSkuId()))
                {
                    arraylist.add(s3);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.e(a, (new StringBuilder()).append("Could not get Special Offer Products: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        s.setDnmProducts(arraylist);
        return s;
    }

    public static gp a()
    {
        return go.a();
    }

    private static String b(String s)
    {
        return URLEncoder.encode(s, "UTF-8");
    }

    private static String c(String s)
    {
        if (s.equals("OpenBox"))
        {
            return "dnmType:Open Box";
        } else
        {
            return "dnmType:Clearance";
        }
    }

}
