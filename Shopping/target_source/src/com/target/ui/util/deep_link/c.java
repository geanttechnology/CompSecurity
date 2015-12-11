// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import android.support.v4.app.Fragment;
import com.google.a.a.e;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.mcoupons.CouponListFragment;
import com.target.ui.fragment.mcoupons.CouponsEntryFragment;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.util.deep_link:
//            f

class c
{

    public static final String TAG = com/target/ui/util/deep_link/c.getSimpleName();

    c()
    {
    }

    private static Fragment a(String s)
    {
        com.target.mothership.model.coupons.c c1 = new com.target.mothership.model.coupons.c();
        if (c1.a().b())
        {
            if (s == null)
            {
                return CouponListFragment.a((CompletedSignUp)c1.a().c());
            } else
            {
                return CouponListFragment.a((CompletedSignUp)c1.a().c(), s);
            }
        }
        if (s == null)
        {
            return CouponsEntryFragment.c();
        } else
        {
            return CouponsEntryFragment.a(s);
        }
    }

    public static f a(Uri uri, Store store)
    {
        String s;
        byte byte0;
        s = uri.getPath();
        if (s == null)
        {
            q.a(TAG, "Coupons deep link missing path information");
            return new f(uri);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 76
    //                   0: 159
    //                   47: 145
    //                   489682805: 173
    //                   1451220877: 187;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_187;
_L6:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown coupons path : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            return b(uri, store);

        case 3: // '\003'
            return c(uri, store);
        }
_L3:
        if (s.equals("/"))
        {
            byte0 = 0;
        }
          goto _L6
_L2:
        if (s.equals(""))
        {
            byte0 = 1;
        }
          goto _L6
_L4:
        if (s.equals("/listing"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("/offer"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public static f b(Uri uri, Store store)
    {
        return new f(uri, a(null));
    }

    public static f c(Uri uri, Store store)
    {
        store = uri.getQueryParameter("keyword");
        if (store == null)
        {
            q.a(TAG, "Coupons offer deep link missing keyword information.");
        }
        return new f(uri, a(store));
    }

}
