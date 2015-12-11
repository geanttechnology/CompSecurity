// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.bestbuy.android.api.lib.models.cart.CartRequest;
import com.bestbuy.android.api.lib.models.cart.CartResponse;
import com.bestbuy.android.api.lib.models.cart.GiftItem;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class ga
{

    public static gb a;
    private static String b = fu.getSimpleName();

    private static CartResponse a(String s, String s1)
    {
        String s2 = a().g;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        CartRequest cartrequest = new CartRequest();
        cartrequest.setSkuId(s);
        cartrequest.setQuantity(1);
        cartrequest.setStoreId(s1);
        s = c(EntityUtils.toString(gw.a(s2, null, arraylist, (new gy()).a(cartrequest), "application/json").getEntity()));
        gt.a();
        return s;
    }

    private static CartResponse a(String s, String s1, String s2)
    {
        String s3 = a().g;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        CartRequest cartrequest = new CartRequest();
        cartrequest.setSkuId(s);
        cartrequest.setQuantity(1);
        cartrequest.setSellerId(s1);
        cartrequest.setListingId(s2);
        s = c(EntityUtils.toString(gw.a(s3, null, arraylist, (new gy()).a(cartrequest), "application/json").getEntity()));
        gt.a();
        return s;
    }

    private static CartResponse a(String s, String s1, String s2, String s3)
    {
        String s4 = a().g;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        CartRequest cartrequest = new CartRequest();
        cartrequest.setSkuId(s);
        cartrequest.setQuantity(1);
        cartrequest.setSellerId(s1);
        cartrequest.setListingId(s2);
        cartrequest.setStoreId(s3);
        s = c(EntityUtils.toString(gw.a(s4, null, arraylist, (new gy()).a(cartrequest), "application/json").getEntity()));
        gt.a();
        return s;
    }

    public static CartResponse a(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7)
    {
        if (s != null && !s.isEmpty() && s1 != null && !s1.isEmpty() && s2 != null && !s2.isEmpty())
        {
            return a(s, s1, s2);
        }
        if (s != null && !s.isEmpty() && s1 != null && !s1.isEmpty() && s2 != null && !s2.isEmpty() && s3 != null && !s3.isEmpty())
        {
            return a(s, s1, s2, s3);
        }
        if (s != null && !s.isEmpty() && s4 != null && !s4.isEmpty() && s3 != null && !s3.isEmpty())
        {
            return b(s, s4, s3);
        }
        if (s != null && !s.isEmpty() && s5 != null && !s5.isEmpty() && s6 != null && !s6.isEmpty() && s7 != null && !s7.isEmpty())
        {
            return b(s, s5, s6, s7);
        }
        if (s != null && !s.isEmpty() && s3 != null && !s3.isEmpty())
        {
            return a(s, s3);
        }
        if (s != null && !s.isEmpty())
        {
            return b(s);
        } else
        {
            return null;
        }
    }

    public static gb a()
    {
        return a;
    }

    public static void a(ft ft1)
    {
        if (ft1 == ft.a)
        {
            a = gb.a;
            return;
        }
        if (ft1 == ft.f)
        {
            a = gb.b;
            return;
        }
        if (ft1 == ft.h)
        {
            a = gb.c;
            return;
        }
        if (ft1 == ft.d)
        {
            a = gb.d;
            return;
        }
        if (ft1 == ft.i)
        {
            a = gb.e;
            return;
        }
        if (ft1 == ft.l)
        {
            a = gb.f;
            return;
        } else
        {
            a = gb.a;
            return;
        }
    }

    public static void a(String s)
    {
        gb.a("CUSTOM").g = s;
    }

    private static CartResponse b(String s)
    {
        String s1 = a().g;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        CartRequest cartrequest = new CartRequest();
        cartrequest.setSkuId(s);
        cartrequest.setQuantity(1);
        s = c(EntityUtils.toString(gw.a(s1, null, arraylist, (new gy()).a(cartrequest), "application/json").getEntity()));
        gt.a();
        return s;
    }

    private static CartResponse b(String s, String s1, String s2)
    {
        String s3 = a().g;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        CartRequest cartrequest = new CartRequest();
        cartrequest.setSkuId(s);
        cartrequest.setQuantity(1);
        cartrequest.setLpnId(s1);
        cartrequest.setStoreId(s2);
        s = c(EntityUtils.toString(gw.a(s3, null, arraylist, (new gy()).a(cartrequest), "application/json").getEntity()));
        gt.a();
        return s;
    }

    private static CartResponse b(String s, String s1, String s2, String s3)
    {
        String s4 = a().g;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("Content-type", "application/json"));
        arraylist.add(new BasicNameValuePair("Accept", "application/json"));
        CartRequest cartrequest = new CartRequest();
        cartrequest.setSkuId(s);
        cartrequest.setQuantity(1);
        s = new GiftItem();
        s.setGiftListId(s1);
        s.setGiftListType(s3);
        s.setGiftListItemId(s2);
        cartrequest.setGiftItem(s);
        s = c(EntityUtils.toString(gw.a(s4, null, arraylist, (new gy()).a(cartrequest), "application/json").getEntity()));
        gt.a();
        return s;
    }

    private static CartResponse c(String s)
    {
        CartResponse cartresponse = new CartResponse();
        return (CartResponse)(new gy()).a(s, cartresponse);
    }

    static 
    {
        a = gb.a;
    }
}
