// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.common.page_item.PageIdentifier;
import com.target.mothership.common.page_item.d;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.shop.CustomPageItemFragment;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.util.deep_link:
//            f, g

class j
{

    public static final String TAG = com/target/ui/util/deep_link/j.getSimpleName();

    j()
    {
    }

    public static f a(Uri uri, Store store)
    {
        String s;
        byte byte0;
        s = uri.getPath();
        if (s == null)
        {
            q.a(TAG, "Landing deep link missing path information");
            return new f(uri);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR tableswitch 1708878944 1708878944: default 52
    //                   1708878944 109;
           goto _L1 _L2
_L1:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown landing path : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
            return b(uri, store);
        }
_L2:
        if (s.equals("/custom"))
        {
            byte0 = 0;
        }
          goto _L1
    }

    private static f b(Uri uri, Store store)
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
        store = uri.getQueryParameter("page");
        if (!o.g(store))
        {
            q.a(TAG, "Landing deep link missing page information");
            return new f(uri);
        } else
        {
            store = new PageIdentifier(store);
            pageitemparams.a(g.a(uri, new String[0]));
            return new f(uri, CustomPageItemFragment.a(pageitemparams, store));
        }
    }

}
