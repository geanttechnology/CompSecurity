// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.model.shop.ShopOverrides;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.util.deep_link:
//            h, f, g

class d
{

    public static final String TAG = com/target/ui/util/deep_link/h.getSimpleName();

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
        JVM INSTR lookupswitch 2: default 48
    //                   0: 123
    //                   47: 109;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_123;
_L4:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown deals path : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
        case 1: // '\001'
            return b(uri, store);
        }
_L3:
        if (s.equals("/"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals(""))
        {
            byte0 = 1;
        }
          goto _L4
    }

    private static f b(Uri uri, Store store)
    {
        com.target.ui.fragment.shop.ShopHomeFragment.b b1 = com.target.ui.fragment.shop.ShopHomeFragment.b.DEALS;
        store = null;
        Object obj = uri.getQueryParameter("weekly_ad_preview");
        if (o.g(((String) (obj))))
        {
            store = new PromotionRequest(((String) (obj)));
        }
        obj = new PageItemParams();
        ((PageItemParams) (obj)).a(g.a(uri, new String[] {
            "weekly_ad_preview"
        }));
        if (store != null)
        {
            store = ShopHomeFragment.a(new ShopOverrides(((PageItemParams) (obj)), b1), store);
        } else
        {
            store = ShopHomeFragment.a(new ShopOverrides(((PageItemParams) (obj)), b1));
        }
        return new f(uri, store);
    }

}
