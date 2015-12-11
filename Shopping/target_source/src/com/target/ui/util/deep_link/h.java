// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.common.page_item.d;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.model.shop.ShopOverrides;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.util.deep_link:
//            f, g

class h
{

    public static final String TAG = com/target/ui/util/deep_link/h.getSimpleName();

    h()
    {
    }

    public static f a(Uri uri, Store store)
    {
        String s;
        byte byte0;
        s = uri.getPath();
        if (s == null)
        {
            return b(uri, store);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 56
    //                   -10477383: 149
    //                   0: 135
    //                   47: 121;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_149;
_L5:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown featured path : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
        case 1: // '\001'
            return b(uri, store);

        case 2: // '\002'
            return c(uri, store);
        }
_L4:
        if (s.equals("/"))
        {
            byte0 = 0;
        }
          goto _L5
_L3:
        if (s.equals(""))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("/preview"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    private static f b(Uri uri, Store store)
    {
        store = new PageItemParams();
        store.a(g.a(uri, new String[0]));
        return new f(uri, ShopHomeFragment.a(new ShopOverrides(store, com.target.ui.fragment.shop.ShopHomeFragment.b.FEATURED)));
    }

    private static f c(Uri uri, Store store)
    {
        PageItemParams pageitemparams = new PageItemParams();
        store = uri.getQueryParameter("inStore");
        if (o.g(store))
        {
            if (Boolean.parseBoolean(store))
            {
                store = d.INSIDE;
            } else
            {
                store = d.OUTSIDE;
            }
            pageitemparams.a(store);
        }
        store = uri.getQueryParameter("storeId");
        if (o.g(store))
        {
            pageitemparams.a(new StoreIdentifier(store));
        }
        pageitemparams.a(g.a(uri, new String[0]));
        return new f(uri, ShopHomeFragment.a(new ShopOverrides(pageitemparams, com.target.ui.fragment.shop.ShopHomeFragment.b.FEATURED)));
    }

}
