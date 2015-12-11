// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.shop.CustomPageItemFragment;
import com.target.ui.util.af;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.util.deep_link:
//            f, g

class b
{

    public static final String TAG = com/target/ui/util/deep_link/b.getSimpleName();

    b()
    {
    }

    public static f a(Uri uri, Store store)
    {
        String s;
        byte byte0;
        s = uri.getPath();
        if (s == null)
        {
            q.a(TAG, "Categories deep link missing path information");
            return new f(uri);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR tableswitch 489682805 489682805: default 52
    //                   489682805 109;
           goto _L1 _L2
_L1:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown categories path : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
            return b(uri, store);
        }
_L2:
        if (s.equals("/listing"))
        {
            byte0 = 0;
        }
          goto _L1
    }

    public static f b(Uri uri, Store store)
    {
        if (!uri.getQueryParameter("idType").equals("ENDECA"))
        {
            return new f(uri);
        }
        Object obj = uri.getQueryParameter("id");
        if (!o.g(((String) (obj))))
        {
            return new f(uri);
        }
        Object obj1 = new EndecaId(((String) (obj)));
        obj = af.b(uri.getQueryParameter("facets"));
        if (!((List) (obj)).isEmpty())
        {
            store = new ProductSummaryParam(store, null, ((EndecaId) (obj1)), null);
            obj1 = new ArrayList();
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                if (o.g(s))
                {
                    ((List) (obj1)).add(new EndecaId(s));
                }
            } while (true);
            store.a(((List) (obj1)));
            return new f(uri, ProductSummaryPageFragment.a(store, true, null, null));
        }
        store = new PageItemParams();
        store.a(((EndecaId) (obj1)));
        obj = uri.getQueryParameter("storeId");
        if (o.g(((String) (obj))))
        {
            store.a(new StoreIdentifier(((String) (obj))));
        }
        store.a(g.a(uri, new String[] {
            "id", "idType"
        }));
        return new f(uri, CustomPageItemFragment.a(store, com.target.ui.fragment.shop.CustomPageItemFragment.a.CHILD_CATEGORY_PAGE_IDENTIFIER));
    }

}
