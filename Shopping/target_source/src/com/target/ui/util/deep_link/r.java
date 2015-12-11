// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.google.a.a.e;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.product.search.SearchContainerFragment;
import com.target.ui.fragment.shop.CustomPageItemFragment;
import com.target.ui.util.ae;
import com.target.ui.util.g.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.target.ui.util.deep_link:
//            f, e, g

class r
{
    private static class a
    {

        EndecaId category;
        List facets;

        a(EndecaId endecaid, List list)
        {
            category = endecaid;
            facets = list;
        }
    }


    private static Pattern tcinPattern = Pattern.compile("(?<=A-)([0-9]{8})");

    private static e a(Uri uri)
    {
        Iterator iterator = uri.getPathSegments().iterator();
        uri = null;
        do
        {
            String as[];
label0:
            {
                if (iterator.hasNext())
                {
                    String s = (String)iterator.next();
                    if (!s.contains("N-"))
                    {
                        continue;
                    }
                    as = s.split("N-");
                    if (as.length >= 1)
                    {
                        break label0;
                    }
                }
                return com.google.a.a.e.c(uri);
            }
            Object obj = Arrays.asList(as[1].split("Z"));
            ArrayList arraylist = new ArrayList();
            Iterator iterator1 = ((List) (obj)).iterator();
            int i = 0;
            obj = null;
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator1.next();
                if (o.g(s1))
                {
                    if (i == 0)
                    {
                        obj = new EndecaId(s1);
                        i++;
                    } else
                    {
                        arraylist.add(new EndecaId(s1));
                        i++;
                    }
                }
            } while (true);
            if (obj != null && arraylist != null)
            {
                uri = new a(((EndecaId) (obj)), arraylist);
            }
        } while (true);
    }

    public static f a(Uri uri, Store store)
    {
        Object obj;
        obj = uri.getPathSegments();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return new f(uri);
        }
        obj = (String)((List) (obj)).get(0);
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 4: default 84
    //                   47: 163
    //                   99: 135
    //                   112: 121
    //                   115: 149;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte byte0 = -1;
_L7:
        switch (byte0)
        {
        default:
            return new f(uri);

        case 0: // '\0'
            return d(uri, store);

        case 1: // '\001'
            return e(uri, store);

        case 2: // '\002'
            return c(uri, store);
        }
_L4:
        if (!((String) (obj)).equals("p")) goto _L1; else goto _L6
_L6:
        byte0 = 0;
          goto _L7
_L3:
        if (!((String) (obj)).equals("c")) goto _L1; else goto _L8
_L8:
        byte0 = 1;
          goto _L7
_L5:
        if (!((String) (obj)).equals("s")) goto _L1; else goto _L9
_L9:
        byte0 = 2;
          goto _L7
_L2:
        if (!((String) (obj)).equals("/")) goto _L1; else goto _L10
_L10:
        byte0 = 3;
          goto _L7
    }

    private static Store b(Uri uri, Store store)
    {
        uri = uri.getQueryParameter("storeId");
        if (o.g(uri))
        {
            store = ae.a(uri);
        }
        return store;
    }

    private static f c(Uri uri, Store store)
    {
        String s = uri.getQueryParameter("searchTerm");
        if (s == null)
        {
            store = SearchContainerFragment.a();
        } else
        {
            store = ProductSummaryPageFragment.a(new ProductSummaryParam(store, null, null, s), com.target.ui.util.g.a.a(true));
        }
        return new f(uri, store);
    }

    private static f d(Uri uri, Store store)
    {
        Object obj = uri.getPath();
        obj = tcinPattern.matcher(((CharSequence) (obj)));
        if (!((Matcher) (obj)).find())
        {
            return new f(uri);
        } else
        {
            obj = new Tcin(((Matcher) (obj)).group());
            store = b(uri, store);
            com.target.ui.util.deep_link.e e1 = new com.target.ui.util.deep_link.e();
            e1.a(((com.target.mothership.common.product.ProductIdentifier) (obj)));
            return new f(uri, ProductDetailsPageFragment.a(((com.target.mothership.common.product.ProductIdentifier) (obj)), store), e1);
        }
    }

    private static f e(Uri uri, Store store)
    {
        Object obj = a(uri);
        if (!((e) (obj)).b())
        {
            return new f(uri);
        }
        obj = (a)((e) (obj)).c();
        if (!((a) (obj)).facets.isEmpty())
        {
            store = new ProductSummaryParam(store, null, ((a) (obj)).category, null);
            store.a(((a) (obj)).facets);
            return new f(uri, ProductSummaryPageFragment.a(store, true));
        } else
        {
            store = new PageItemParams();
            store.a(((a) (obj)).category);
            store.a(com.target.ui.util.deep_link.g.a(uri, new String[] {
                "id", "idType"
            }));
            return new f(uri, CustomPageItemFragment.a(store, com.target.ui.fragment.shop.CustomPageItemFragment.a.CHILD_CATEGORY_PAGE_IDENTIFIER));
        }
    }

}
