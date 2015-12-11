// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.PromotionSlug;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.weekly_ad.WeeklyAdFragment;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.util.deep_link:
//            f

class u
{

    public static final String TAG = com/target/ui/util/deep_link/u.getSimpleName();

    u()
    {
    }

    public static f a(Uri uri, Store store)
    {
        String s;
        byte byte0;
        s = uri.getPath();
        if (s == null)
        {
            q.a(TAG, "Weekly ad deep link missing path information");
            return new f(uri);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR tableswitch 46613902 46613902: default 52
    //                   46613902 109;
           goto _L1 _L2
_L1:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown weekly ad path : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
            return b(uri, store);
        }
_L2:
        if (s.equals("/home"))
        {
            byte0 = 0;
        }
          goto _L1
    }

    private static f b(Uri uri, Store store)
    {
        PromotionRequest promotionrequest = null;
        String s1 = uri.getQueryParameter("code");
        String s = uri.getQueryParameter("preview");
        if (store != null)
        {
            store = store.getStoreId();
        } else
        {
            store = null;
        }
        if (s1 != null)
        {
            promotionrequest = new PromotionRequest(new PromotionSlug(s1));
            promotionrequest.a(s);
        }
        return new f(uri, WeeklyAdFragment.a(store, promotionrequest));
    }

}
