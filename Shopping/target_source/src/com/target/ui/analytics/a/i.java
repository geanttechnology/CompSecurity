// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.google.a.a.e;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.target.mothership.common.a.b;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.common.a.j;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.mothership.model.product.interfaces.ProductOnlineInfo;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.i.c.c;
import com.target.ui.service.k;
import com.target.ui.util.af;
import com.target.ui.util.q;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{

    private static final String COMMA = ",";
    private static final int ERROR_MAX_LENGTH = 100;
    private static final String EXPERIMENT_KEY_PREFIX = "Android";
    private static final String PDP_BROWSE_LEVEL = "product details";
    private static final String TAG = com/target/ui/analytics/a/i.getSimpleName();

    public i()
    {
    }

    private static String a(b b1)
    {
        if (b1 == null)
        {
            return "";
        } else
        {
            return b1.name();
        }
    }

    private static String a(com.target.mothership.common.product.i j)
    {
        if (j == null)
        {
            return "out of stock";
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$InventoryStatus = new int[com.target.mothership.common.product.i.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[com.target.mothership.common.product.i.InStock.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[com.target.mothership.common.product.i.LimitedStock.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[com.target.mothership.common.product.i.CurrentlyNotOnSale.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[com.target.mothership.common.product.i.OnBackorder.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[com.target.mothership.common.product.i.NotAvailable.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[com.target.mothership.common.product.i.OutOfStock.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[com.target.mothership.common.product.i.PreOrder.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[com.target.mothership.common.product.i.NotSoldInThisStore.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[com.target.mothership.common.product.i.UNKNOWN.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.product.InventoryStatus[j.ordinal()])
        {
        default:
            return "out of stock";

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return "in stock";
        }
    }

    private static String a(CartProduct cartproduct)
    {
        if (cartproduct == null)
        {
            return "";
        } else
        {
            boolean flag = cartproduct.s();
            boolean flag1 = cartproduct.r();
            boolean flag2 = cartproduct.s();
            cartproduct = cartproduct.g_();
            return a(flag1, ((com.target.mothership.common.product.i) (cartproduct)), flag, ((com.target.mothership.common.product.i) (cartproduct)), flag2);
        }
    }

    public static String a(CartProduct cartproduct, int j)
    {
        if (cartproduct == null)
        {
            return "";
        }
        JSONArray jsonarray = new JSONArray();
        cartproduct = a(cartproduct, Integer.valueOf(j));
        if (cartproduct != null)
        {
            jsonarray.put(cartproduct);
        }
        if (!(jsonarray instanceof JSONArray))
        {
            return jsonarray.toString();
        } else
        {
            return JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
    }

    public static String a(ProductDetails productdetails)
    {
        if (productdetails == null)
        {
            return "";
        }
        JSONArray jsonarray = new JSONArray();
        productdetails = a(productdetails, ((Integer) (null)), ((Integer) (null)));
        if (productdetails != null)
        {
            jsonarray.put(productdetails);
        }
        if (!(jsonarray instanceof JSONArray))
        {
            return jsonarray.toString();
        } else
        {
            return JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
    }

    public static String a(ProductDetails productdetails, int j)
    {
        if (productdetails == null)
        {
            return "";
        }
        JSONArray jsonarray = new JSONArray();
        productdetails = a(productdetails, Integer.valueOf(j), ((Integer) (null)));
        if (productdetails != null)
        {
            jsonarray.put(productdetails);
        }
        if (!(jsonarray instanceof JSONArray))
        {
            return jsonarray.toString();
        } else
        {
            return JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
    }

    private static String a(x x1)
    {
        if (x1 == null)
        {
            return "TargetNetworkError was null";
        } else
        {
            return af.a(x1.a(), 100);
        }
    }

    public static String a(x x1, j j)
    {
        String s = a(x1);
        if (j == null)
        {
            x1 = "";
        } else
        {
            x1 = j.toString();
        }
        j = new StringBuilder();
        j.append(x1);
        j.append(s);
        return j.toString();
    }

    public static String a(List list)
    {
        if (list == null || list.isEmpty())
        {
            return "";
        }
        JSONArray jsonarray = new JSONArray();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            JSONObject jsonobject = a((CartProduct)list.next(), ((Integer) (null)));
            if (jsonobject != null)
            {
                jsonarray.put(jsonobject);
            }
        } while (true);
        if (!(jsonarray instanceof JSONArray))
        {
            return jsonarray.toString();
        } else
        {
            return JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
    }

    public static String a(List list, Integer integer)
    {
        if (list == null || list.isEmpty())
        {
            return "";
        }
        int j = integer.intValue();
        integer = new JSONArray();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            JSONObject jsonobject = a((Product)list.next(), Integer.valueOf(j));
            if (jsonobject != null)
            {
                j++;
                integer.put(jsonobject);
            }
        } while (true);
        if (!(integer instanceof JSONArray))
        {
            return integer.toString();
        } else
        {
            return JSONArrayInstrumentation.toString((JSONArray)integer);
        }
    }

    public static String a(Map map)
    {
        if (map == null || map.isEmpty())
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        map = map.entrySet().iterator();
        int l;
        for (int j = 0; map.hasNext(); j = l)
        {
            Object obj = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
            l = j;
            if (!o.g(s))
            {
                continue;
            }
            l = j;
            if (!s.startsWith("Android"))
            {
                continue;
            }
            l = j + 1;
            if (l > 1)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append((new StringBuilder()).append(s).append("-").append(((String) (obj))).toString());
        }

        return stringbuilder.toString();
    }

    private static String a(boolean flag, com.target.mothership.common.product.i j, boolean flag1, com.target.mothership.common.product.i l, boolean flag2)
    {
        if (!flag1 && !flag)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("online");
        stringbuilder.append(":");
        if (flag)
        {
            stringbuilder.append("sold");
            stringbuilder.append(":");
            stringbuilder.append(a(j));
        } else
        {
            stringbuilder.append("not sold");
        }
        stringbuilder.append(",");
        stringbuilder.append("store");
        stringbuilder.append(":");
        if (flag1)
        {
            stringbuilder.append("sold");
            stringbuilder.append(":");
            stringbuilder.append(a(l));
        } else
        {
            stringbuilder.append("not sold");
        }
        if (flag1 && !flag2)
        {
            stringbuilder.append(":");
            stringbuilder.append("not pickup eligible");
        }
        return stringbuilder.toString();
    }

    public static List a(PageItemHierarchy pageitemhierarchy)
    {
        pageitemhierarchy = b(pageitemhierarchy);
        pageitemhierarchy.add("product details");
        return pageitemhierarchy;
    }

    private static JSONObject a(CartProduct cartproduct, Integer integer)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            a(jsonobject, "productID", cartproduct.k_().b());
        }
        // Misplaced declaration of an exception variable
        catch (CartProduct cartproduct)
        {
            return null;
        }
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        jsonobject.put("quantity", String.valueOf(integer));
_L1:
        a(jsonobject, "price", cartproduct.i_().toPlainString());
        a(jsonobject, "itemDiscountedPrice", cartproduct.h_().toPlainString());
        a(jsonobject, "shippingMethod", a(cartproduct.c()));
        a(jsonobject, "stockAvailability", a(cartproduct));
        return jsonobject;
        a(jsonobject, "quantity", String.valueOf(cartproduct.j_()));
          goto _L1
    }

    private static JSONObject a(Product product, Integer integer)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            a(jsonobject, "productID", product.k_().b());
        }
        // Misplaced declaration of an exception variable
        catch (Product product)
        {
            q.a(TAG, "failed to convert product to JSON object");
            return null;
        }
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        jsonobject.put("listIndex", String.valueOf(integer));
        return jsonobject;
    }

    private static JSONObject a(ProductDetails productdetails, Integer integer, Integer integer1)
    {
        JSONObject jsonobject = new JSONObject();
        String s = productdetails.k_().b();
        if (!productdetails.e().b()) goto _L2; else goto _L1
_L1:
        Object obj = ((Dpci)productdetails.e().c()).b();
_L11:
        a(jsonobject, "productID", s);
        a(jsonobject, "dpciDisplayed", ((String) (obj)));
        obj = k.a().c();
        boolean flag;
        if (((e) (obj)).b() && ((RelevantStoreSummary)((e) (obj)).c()).a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = com.target.ui.i.c.c.a(productdetails, flag, com.target.ui.i.c.c.a.REGULAR, null);
        s = ((com.target.ui.common.b) (obj)).e();
        if (!o.f(((com.target.ui.common.b) (obj)).f())) goto _L4; else goto _L3
_L3:
        obj = ((com.target.ui.common.b) (obj)).f();
_L12:
        a(jsonobject, "itemDiscountedPrice", s);
        a(jsonobject, "price", ((String) (obj)));
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        jsonobject.put("quantity", String.valueOf(integer));
        if (integer1 == null)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        jsonobject.put("listIndex", String.valueOf(integer1));
        jsonobject.put("stockAvailability", c(productdetails));
        if (!productdetails.h().b()) goto _L6; else goto _L5
_L5:
        integer = ((Tcin)productdetails.h().c()).b();
_L13:
        a(jsonobject, "productParentNumber", ((String) (integer)));
        if (!productdetails.j().b()) goto _L8; else goto _L7
_L7:
        integer = String.valueOf(((ProductGuestReview)productdetails.j().c()).b());
_L14:
        if (!productdetails.j().b()) goto _L10; else goto _L9
_L9:
        productdetails = ((ProductGuestReview)productdetails.j().c()).a().toPlainString();
_L15:
        a(jsonobject, "numberOfReviews", ((String) (integer)));
        jsonobject.put("averageProductRating", productdetails);
        return jsonobject;
_L2:
        obj = null;
          goto _L11
_L4:
        obj = s;
          goto _L12
_L6:
        integer = null;
          goto _L13
_L8:
        integer = null;
          goto _L14
_L10:
        productdetails = null;
          goto _L15
        productdetails;
        q.a(TAG, "failed to convert product to JSON object");
        return null;
          goto _L11
    }

    public static void a(Map map, String s, String s1)
    {
        if (o.f(s1))
        {
            map.put(s, s1);
        }
    }

    public static void a(JSONObject jsonobject, String s, String s1)
        throws JSONException
    {
        if (o.f(s1))
        {
            jsonobject.put(s, s1);
        }
    }

    public static String b(ProductDetails productdetails)
    {
        boolean flag1 = false;
        if (productdetails == null)
        {
            return String.valueOf(false);
        }
        boolean flag = flag1;
        if (productdetails.c().a())
        {
            flag = flag1;
            if (productdetails.c().d().b())
            {
                flag = true;
            }
        }
        return String.valueOf(flag);
    }

    public static List b(PageItemHierarchy pageitemhierarchy)
    {
        ArrayList arraylist = new ArrayList();
        if (pageitemhierarchy == null)
        {
            return arraylist;
        }
        Iterator iterator = pageitemhierarchy.b().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PageItem pageitem = (PageItem)iterator.next();
            if (pageitem.g().b())
            {
                arraylist.add(pageitem.g().c());
            }
        } while (true);
        if (pageitemhierarchy.a().g().b())
        {
            arraylist.add(pageitemhierarchy.a().g().c());
        }
        return arraylist;
    }

    private static String c(ProductDetails productdetails)
    {
        boolean flag2 = true;
        if (productdetails == null)
        {
            return "";
        }
        com.target.mothership.common.product.c c1 = productdetails.i();
        boolean flag;
        boolean flag1;
        if (c1 == com.target.mothership.common.product.c.ONLINE_ONLY || c1 == com.target.mothership.common.product.c.ONLINE_STORES)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (c1 == com.target.mothership.common.product.c.STORE_ONLY || c1 == com.target.mothership.common.product.c.ONLINE_STORES)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (c1 == com.target.mothership.common.product.c.ONLINE_ONLY)
        {
            flag2 = false;
        }
        return a(flag1, productdetails.c().c(), flag, productdetails.u().c(), flag2);
    }

}
