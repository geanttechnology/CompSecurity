// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.list.ListDetailFragment;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.util.deep_link:
//            f

class k
{

    public static final String TAG = com/target/ui/util/deep_link/k.getSimpleName();

    k()
    {
    }

    public static f a(Uri uri, Store store)
    {
        String s;
        byte byte0;
        s = uri.getPath();
        if (s == null)
        {
            q.a(TAG, "List deep link missing path information");
            return new f(uri);
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR tableswitch 47024980 47024980: default 52
    //                   47024980 109;
           goto _L1 _L2
_L1:
        switch (byte0)
        {
        default:
            q.a(TAG, (new StringBuilder()).append("Unknown list path : ").append(uri.toString()).toString());
            return new f(uri);

        case 0: // '\0'
            return b(uri, store);
        }
_L2:
        if (s.equals("/view"))
        {
            byte0 = 0;
        }
          goto _L1
    }

    public static f b(Uri uri, Store store)
    {
        uri.getQueryParameter("id");
        return new f(uri, ListDetailFragment.a());
    }

}
