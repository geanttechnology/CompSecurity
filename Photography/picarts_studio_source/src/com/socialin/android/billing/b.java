// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.billing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.GetShopItemsListController;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.GetShopItemsListParams;
import com.socialin.android.d;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import myobfuscated.bp.a;
import myobfuscated.bp.c;

// Referenced classes of package com.socialin.android.billing:
//            d, e, i, f

public class b
    implements com.socialin.android.billing.d
{

    private static final String a = com/socialin/android/billing/b.getSimpleName();
    private static b b = null;
    private static List l = null;
    private com.socialin.android.billing.e c;
    private boolean d;
    private ArrayList e;
    private boolean f;
    private ArrayList g;
    private long h;
    private long i;
    private long j;
    private ArrayList k;
    private HashMap m;

    private b(Context context, String s)
    {
        c = null;
        d = false;
        e = new ArrayList();
        f = false;
        g = new ArrayList();
        h = 0L;
        i = 0L;
        j = 0x124f80L;
        k = new ArrayList();
        m = new HashMap();
        c = com.socialin.android.billing.e.a(context, s);
        if (!c.a)
        {
            c.a(new _cls1());
            return;
        } else
        {
            d = true;
            f = true;
            return;
        }
    }

    static long a(b b1, long l1)
    {
        b1.h = l1;
        return l1;
    }

    public static b a(Context context, String s)
    {
        if (b == null)
        {
            b = new b(context, s);
        }
        return b;
    }

    static String a()
    {
        return a;
    }

    private static String a(String s, String s1)
    {
        if (s == null)
        {
            return s1;
        }
        if (s1 == null)
        {
            return s;
        } else
        {
            return (new StringBuilder()).append(s).append(s1).toString();
        }
    }

    static ArrayList a(b b1, ArrayList arraylist)
    {
        b1.g = arraylist;
        return arraylist;
    }

    static List a(List list)
    {
        l = list;
        return list;
    }

    static boolean a(b b1)
    {
        b1.f = true;
        return true;
    }

    static boolean a(b b1, boolean flag)
    {
        b1.d = flag;
        return flag;
    }

    static long b(b b1, long l1)
    {
        b1.i = l1;
        return l1;
    }

    static ArrayList b(b b1)
    {
        return b1.e;
    }

    static ArrayList b(b b1, ArrayList arraylist)
    {
        if (b1.d)
        {
            Object obj = new ArrayList();
            Iterator iterator = arraylist.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem1 = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator.next();
                if (shopitem1.data.price > 0)
                {
                    ((ArrayList) (obj)).add(shopitem1.data.shopItemUid);
                }
            } while (true);
            obj = b1.c.a(((ArrayList) (obj))).iterator();
            do
            {
                b1 = arraylist;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                b1 = (i)((Iterator) (obj)).next();
                Iterator iterator1 = arraylist.iterator();
                while (iterator1.hasNext()) 
                {
                    com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem2 = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)iterator1.next();
                    if (((i) (b1)).a.equals(shopitem2.data.shopItemUid))
                    {
                        shopitem2.data.priceString = ((i) (b1)).b;
                    }
                }
            } while (true);
        } else
        {
            b1 = new ArrayList();
            arraylist = arraylist.iterator();
            do
            {
                if (!arraylist.hasNext())
                {
                    break;
                }
                com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem shopitem = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)arraylist.next();
                if (shopitem.data.price <= 0)
                {
                    b1.add(shopitem);
                }
            } while (true);
        }
        return b1;
    }

    static List b()
    {
        return l;
    }

    static ArrayList c(b b1)
    {
        return b1.g;
    }

    static com.socialin.android.billing.e d(b b1)
    {
        return b1.c;
    }

    static ArrayList e(b b1)
    {
        return b1.k;
    }

    static boolean f(b b1)
    {
        return b1.f;
    }

    public void getPurchasedItems(myobfuscated.bp.b b1)
    {
        if (l != null)
        {
            b1.a(l);
            return;
        }
        b1 = new _cls5(b1);
        if (f)
        {
            b1.execute(new Void[0]);
            return;
        } else
        {
            e.add(b1);
            return;
        }
    }

    public void getShopItemPrice(Activity activity, Object obj, a a1)
    {
        (new _cls2(obj, a1)).execute(new Void[0]);
    }

    public boolean handleActivityResult(int i1, int j1, Intent intent)
    {
        return c.a(i1, j1, intent);
    }

    public boolean isBillingSupported()
    {
        return d && c.a;
    }

    public void requestPurchase(Activity activity, String s, String s1, String s2, double d1, myobfuscated.bp.d d2)
    {
        s = new f(this, d2, s1);
        if (c.a)
        {
            try
            {
                c.a(activity, s1, s2, s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.a(activity, 0x7f080438);
            }
            return;
        }
        try
        {
            c.a(new _cls4(activity, s1, s2, s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.a(activity, 0x7f080438);
        }
    }

    public void requestShopItems(boolean flag, c c1)
    {
        if (g != null && g.size() > 0 && System.currentTimeMillis() - h < j && SocialinV3.getInstance().getUser().id == i)
        {
            if (c1 != null)
            {
                c1.a(g);
            }
            return;
        } else
        {
            GetShopItemsListController getshopitemslistcontroller = new GetShopItemsListController();
            getshopitemslistcontroller.setRequestCompleteListener(new _cls3(c1));
            getshopitemslistcontroller.doRequest("allShopItems", new GetShopItemsListParams());
            return;
        }
    }

    public void requestShopItemsForTypeAndTag(boolean flag, String s, String s1, c c1, int i1)
    {
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        String s2 = URLEncoder.encode(s1, e.a.name());
        s1 = s2;
        s2 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        s2 = URLEncoder.encode(s, e.a.name());
        s = s2;
_L2:
        GetShopItemsListController getshopitemslistcontroller1 = (GetShopItemsListController)m.get(a(s1, s));
        GetShopItemsListController getshopitemslistcontroller = getshopitemslistcontroller1;
        if (getshopitemslistcontroller1 == null)
        {
            getshopitemslistcontroller = new GetShopItemsListController();
            m.put(a(s1, s), getshopitemslistcontroller);
        }
        getshopitemslistcontroller.setRequestCompleteListener(new _cls6(c1));
        c1 = new GetShopItemsListParams();
        c1.price = s1;
        c1.tag = s;
        c1.limit = 20;
        c1.offset = i1 * 20;
        getshopitemslistcontroller.doRequest(s1, c1);
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
_L3:
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(unsupportedencodingexception.getMessage()).toString()
        });
        if (true) goto _L2; else goto _L1
_L1:
        unsupportedencodingexception;
          goto _L3
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls6 {}

}
