// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.google.a.a.e;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.Barcode;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.p;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.product.clp.CollectionsListPageFragment;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.scan.SearchScanUpcFragment;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.util.ae;
import com.target.ui.util.af;
import com.target.ui.util.g.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.util.deep_link:
//            f, e

class q
{

    public static final String TAG = com/target/ui/util/deep_link/q.getSimpleName();

    q()
    {
    }

    public static f a(Uri uri, Store store)
    {
        String s;
        byte byte0;
        s = uri.getPath();
        if (s == null)
        {
            com.target.ui.util.q.a(TAG, "Product deep link missing path information");
            return new f(uri);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 84
    //                   -2143336809: 213
    //                   -298680307: 157
    //                   46929708: 199
    //                   489682805: 185
    //                   1722743104: 171;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_213;
_L7:
        switch (byte0)
        {
        default:
            com.target.ui.util.q.a(TAG, (new StringBuilder()).append("Unknown product path : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
            return b(uri, store);

        case 1: // '\001'
            return c(uri, store);

        case 2: // '\002'
            return d(uri, store);

        case 3: // '\003'
            return e(uri, store);

        case 4: // '\004'
            return f(uri, store);
        }
_L3:
        if (s.equals("/collection"))
        {
            byte0 = 0;
        }
          goto _L7
_L6:
        if (s.equals("/detail"))
        {
            byte0 = 1;
        }
          goto _L7
_L5:
        if (s.equals("/listing"))
        {
            byte0 = 2;
        }
          goto _L7
_L4:
        if (s.equals("/scan"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s.equals("/search"))
        {
            byte0 = 4;
        }
          goto _L7
    }

    private static Integer a(String s, Uri uri, String s1)
    {
        if (s1 == null)
        {
            s1 = "?";
        }
        try
        {
            s = Integer.valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.target.ui.util.q.a(TAG, String.format("Could not parse %s from : %s ", new Object[] {
                s1, uri.toString()
            }));
            return null;
        }
        return s;
    }

    public static boolean a(Uri uri)
    {
        uri = uri.getPath();
        return uri != null && uri.equals("/listing");
    }

    private static ProductIdentifier b(Uri uri)
    {
        Object obj;
        Object obj1;
        String s;
        String s1;
        obj = null;
        obj1 = null;
        s = uri.getQueryParameter("id");
        s1 = uri.getQueryParameter("idType");
        if (s != null && s1 != null) goto _L2; else goto _L1
_L1:
        com.target.ui.util.q.a(TAG, (new StringBuilder()).append("Product deep link missing ID information : ").append(uri.toString()).toString());
_L11:
        return ((ProductIdentifier) (obj1));
_L2:
        byte byte0;
        obj1 = s1.toUpperCase();
        byte0 = -1;
        ((String) (obj1)).hashCode();
        JVM INSTR lookupswitch 3: default 104
    //                   2104818: 183
    //                   2569172: 198
    //                   384398432: 168;
           goto _L3 _L4 _L5 _L6
_L3:
        byte0;
        JVM INSTR tableswitch 0 2: default 132
    //                   0 213
    //                   1 225
    //                   2 237;
           goto _L7 _L8 _L9 _L10
_L7:
        obj1 = obj;
        if (obj == null)
        {
            com.target.ui.util.q.a(TAG, (new StringBuilder()).append("Product deep link contains ID of unknown type : ").append(uri.toString()).toString());
            return ((ProductIdentifier) (obj));
        }
          goto _L11
_L6:
        if (((String) (obj1)).equals("BARCODE"))
        {
            byte0 = 0;
        }
          goto _L3
_L4:
        if (((String) (obj1)).equals("DPCI"))
        {
            byte0 = 1;
        }
          goto _L3
_L5:
        if (((String) (obj1)).equals("TCIN"))
        {
            byte0 = 2;
        }
          goto _L3
_L8:
        obj = new Barcode(s);
          goto _L7
_L9:
        obj = new Dpci(s);
          goto _L7
_L10:
        obj = new Tcin(s);
          goto _L7
    }

    private static f b(Uri uri, Store store)
    {
        ProductIdentifier productidentifier;
        String s;
        byte byte0;
        byte byte1;
        byte1 = 2;
        productidentifier = b(uri);
        if (productidentifier == null)
        {
            return new f(uri);
        }
        store = h(uri, store);
        s = uri.getQueryParameter("view");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        s = s.toUpperCase();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 76
    //                   2169487: 130
    //                   785535328: 115;
           goto _L1 _L2 _L3
_L1:
        switch (byte0)
        {
        default:
            byte1 = 1;
            break;

        case 0: // '\0'
            break;
        }
_L4:
        return new f(uri, CollectionsListPageFragment.a(productidentifier, byte1, store));
_L3:
        if (s.equals("CAROUSEL"))
        {
            byte0 = 0;
        }
          goto _L1
_L2:
        if (s.equals("FULL"))
        {
            byte0 = 2;
        }
          goto _L1
        byte1 = 1;
          goto _L4
    }

    private static f c(Uri uri, Store store)
    {
        ProductIdentifier productidentifier = b(uri);
        if (productidentifier == null)
        {
            return new f(uri);
        } else
        {
            store = h(uri, store);
            com.target.ui.util.deep_link.e e1 = new com.target.ui.util.deep_link.e();
            e1.a(productidentifier);
            return new f(uri, ProductDetailsPageFragment.a(productidentifier, store), e1);
        }
    }

    private static f d(Uri uri, Store store)
    {
        Object obj = uri.getQueryParameter("id");
        String s = uri.getQueryParameter("idType");
        String s1 = uri.getQueryParameter("title");
        String s2 = uri.getQueryParameter("bannerUrl");
        if (obj == null)
        {
            com.target.ui.util.q.a(TAG, (new StringBuilder()).append("PLP deep link missing ID information : ").append(uri.toString()).toString());
            return new f(uri);
        }
        boolean flag = com.target.ui.util.g.a.a(true);
        obj = af.b(((String) (obj)));
        ArrayList arraylist;
        Iterator iterator;
        String s3;
        byte byte0;
        if (((List) (obj)).size() > 1)
        {
            if (!o.g(s))
            {
                com.target.ui.util.q.a(TAG, (new StringBuilder()).append("PLP deep link contains ID list with no (or invalid) type : ").append(uri.toString()).toString());
                return new f(uri);
            }
            arraylist = new ArrayList();
            iterator = ((List) (obj)).iterator();
        } else
        {
            return new f(uri, ProductSummaryPageFragment.a(g(uri, store), flag, s1, s2));
        }
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        obj = (String)iterator.next();
        s3 = s.toUpperCase();
        byte0 = -1;
        s3.hashCode();
        JVM INSTR lookupswitch 3: default 224
    //                   2104818: 284
    //                   2569172: 300
    //                   384398432: 268;
           goto _L3 _L4 _L5 _L6
_L3:
        byte0;
        JVM INSTR tableswitch 0 2: default 252
    //                   0 316
    //                   1 328
    //                   2 340;
           goto _L7 _L8 _L9 _L10
_L7:
        obj = null;
_L11:
        if (obj != null)
        {
            arraylist.add(obj);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s3.equals("BARCODE"))
        {
            byte0 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s3.equals("DPCI"))
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (s3.equals("TCIN"))
        {
            byte0 = 2;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        obj = new Barcode(((String) (obj)));
        continue; /* Loop/switch isn't completed */
_L9:
        obj = new Dpci(((String) (obj)));
        continue; /* Loop/switch isn't completed */
_L10:
        obj = new Tcin(((String) (obj)));
        if (true) goto _L11; else goto _L2
_L2:
        if (arraylist.isEmpty())
        {
            com.target.ui.util.q.a(TAG, (new StringBuilder()).append("PLP deep link contains invalid ID list : ").append(uri.toString()).toString());
            return new f(uri);
        }
        return new f(uri, ProductSummaryPageFragment.a(arraylist, flag, store, s1, s2));
        if (true) goto _L13; else goto _L12
_L13:
        break MISSING_BLOCK_LABEL_153;
_L12:
        if (true) goto _L3; else goto _L14
_L14:
    }

    private static f e(Uri uri, Store store)
    {
        return new f(uri, SearchScanUpcFragment.a(store));
    }

    private static f f(Uri uri, Store store)
    {
        store = g(uri, store);
        if (store.e().b())
        {
            store = ProductSummaryPageFragment.a(store, com.target.ui.util.g.a.a(true));
        } else
        {
            store = ShopHomeFragment.a();
            store.a(true);
        }
        return new f(uri, store);
    }

    private static ProductSummaryParam g(Uri uri, Store store)
    {
        Object obj;
        Object obj1;
        Integer integer;
        boolean flag;
        flag = false;
        integer = null;
        obj = uri.getQueryParameter("id");
        obj1 = uri.getQueryParameter("idType");
        if (!o.g(((String) (obj))) || !o.g(((String) (obj1)))) goto _L2; else goto _L1
_L1:
        int i;
        obj1 = ((String) (obj1)).toUpperCase();
        i = -1;
        ((String) (obj1)).hashCode();
        JVM INSTR lookupswitch 5: default 96
    //                   2104818: 280
    //                   2569172: 295
    //                   384398432: 265
    //                   833137918: 233
    //                   2049540296: 249;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        i;
        JVM INSTR tableswitch 0 4: default 132
    //                   0 310
    //                   1 327
    //                   2 344
    //                   3 361
    //                   4 378;
           goto _L2 _L9 _L10 _L11 _L12 _L13
_L2:
        Object obj2;
        obj2 = null;
        obj = null;
        obj1 = null;
        break; /* Loop/switch isn't completed */
_L7:
        if (((String) (obj1)).equals("CATEGORY"))
        {
            i = 0;
        }
          goto _L3
_L8:
        if (((String) (obj1)).equals("ENDECA"))
        {
            i = 1;
        }
          goto _L3
_L6:
        if (((String) (obj1)).equals("BARCODE"))
        {
            i = 2;
        }
          goto _L3
_L4:
        if (((String) (obj1)).equals("DPCI"))
        {
            i = 3;
        }
          goto _L3
_L5:
        if (((String) (obj1)).equals("TCIN"))
        {
            i = 4;
        }
          goto _L3
_L9:
        obj1 = new CategoryId(((String) (obj)));
        obj = null;
        obj2 = null;
          goto _L14
_L10:
        obj = new EndecaId(((String) (obj)));
        obj1 = null;
        obj2 = null;
          goto _L14
_L11:
        obj2 = new Barcode(((String) (obj)));
        obj = null;
        obj1 = null;
          goto _L14
_L12:
        obj2 = new Dpci(((String) (obj)));
        obj = null;
        obj1 = null;
          goto _L14
_L13:
        obj2 = new Tcin(((String) (obj)));
        obj = null;
        obj1 = null;
_L14:
        String s = uri.getQueryParameter("searchTerm");
        Object obj3;
        p ap[];
        Object obj4;
        Object obj5;
        ArrayList arraylist;
        String s1;
        int j;
        if (s == null)
        {
            s = null;
        }
        if (obj2 != null)
        {
            s = ((ProductIdentifier) (obj2)).b();
        }
        obj2 = af.b(uri.getQueryParameter("facets"));
        arraylist = new ArrayList();
        for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); arraylist.add(new EndecaId((String)((Iterator) (obj2)).next()))) { }
        obj3 = uri.getQueryParameter("sortBy");
        if (obj3 == null) goto _L16; else goto _L15
_L15:
        ap = p.values();
        j = ap.length;
        i = ((flag) ? 1 : 0);
_L20:
        if (i >= j) goto _L16; else goto _L17
_L17:
        obj2 = ap[i];
        if (!((String) (obj3)).equalsIgnoreCase(((p) (obj2)).toString())) goto _L19; else goto _L18
_L18:
        obj3 = uri.getQueryParameter("minPrice");
        obj4 = uri.getQueryParameter("maxPrice");
        if (obj3 != null)
        {
            obj3 = a(((String) (obj3)), uri, "minPrice");
        } else
        {
            obj3 = null;
        }
        if (obj4 != null)
        {
            obj4 = a(((String) (obj4)), uri, "maxPrice");
        } else
        {
            obj4 = null;
        }
        obj5 = uri.getQueryParameter("pageSize");
        s1 = uri.getQueryParameter("pageNumber");
        if (obj5 != null)
        {
            obj5 = a(((String) (obj5)), uri, "pageSize");
        } else
        {
            obj5 = null;
        }
        if (s1 != null)
        {
            integer = a(s1, uri, "pageNumber");
        }
        uri = new ProductSummaryParam(store, ((CategoryId) (obj1)), ((EndecaId) (obj)), s);
        uri.a(arraylist);
        uri.d(((Integer) (obj5)));
        uri.a(((Integer) (obj4)));
        uri.b(((Integer) (obj3)));
        uri.c(integer);
        uri.a(((p) (obj2)));
        return uri;
_L19:
        i++;
          goto _L20
_L16:
        obj2 = null;
          goto _L18
    }

    private static Store h(Uri uri, Store store)
    {
        uri = uri.getQueryParameter("storeId");
        if (o.g(uri))
        {
            store = ae.a(uri);
        }
        return store;
    }

}
