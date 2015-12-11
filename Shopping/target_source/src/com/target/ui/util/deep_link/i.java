// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.registry.RegistryDetailPageFragment;
import com.target.ui.fragment.registry.RegistryLandingPageFragment;
import com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.util.deep_link:
//            f

class i
{

    public static final String TAG = com/target/ui/util/deep_link/i.getSimpleName();

    i()
    {
    }

    public static f a(Uri uri, Store store)
    {
        String s;
        byte byte0;
        s = uri.getPath();
        if (s == null)
        {
            q.a(TAG, "Registry deep link missing path information");
            return new f(uri);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 68
    //                   -2143336809: 147
    //                   46613902: 133
    //                   47024980: 161;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_161;
_L5:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown registry path : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
            return b(uri, store);

        case 1: // '\001'
            return c(uri, store);

        case 2: // '\002'
            return d(uri, store);
        }
_L3:
        if (s.equals("/home"))
        {
            byte0 = 0;
        }
          goto _L5
_L2:
        if (s.equals("/search"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("/view"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    private static f b(Uri uri, Store store)
    {
        return new f(uri, RegistryLandingPageFragment.a(store));
    }

    private static f c(Uri uri, Store store)
    {
        String s = uri.getQueryParameter("first_name");
        String s1 = uri.getQueryParameter("last_name");
        if (!o.g(s) || !o.g(s1))
        {
            q.a(TAG, (new StringBuilder()).append("Registry search deep link missing name parameters : ").append(uri.toString()).toString());
            return new f(uri);
        } else
        {
            return new f(uri, RegistrySearchSummaryPageFragment.a(new RegistrySearchParam(s, s1), store));
        }
    }

    private static f d(Uri uri, Store store)
    {
        String s = uri.getQueryParameter("id");
        if (!o.g(s))
        {
            q.a(TAG, (new StringBuilder()).append("Registry view deep link missing ID : ").append(uri.toString()).toString());
            return new f(uri);
        } else
        {
            return new f(uri, RegistryDetailPageFragment.a(new RegistryId(s), store));
        }
    }

}
