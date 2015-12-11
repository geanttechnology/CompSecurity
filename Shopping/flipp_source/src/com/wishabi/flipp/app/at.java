// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.LoaderManager;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.widget.cb;
import com.wishabi.flipp.widget.ec;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.app:
//            FeaturedFragment

final class at
    implements ec
{

    final FeaturedFragment a;

    at(FeaturedFragment featuredfragment)
    {
        a = featuredfragment;
        super();
    }

    public final boolean a(int i, int j)
    {
        if (i == j)
        {
            return false;
        }
        j;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 38
    //                   1 136
    //                   2 149;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        com.wishabi.flipp.app.FeaturedFragment.a(a, cb.a);
_L6:
        a.getLoaderManager().restartLoader(0, null, a);
        a a1 = a.a;
        String s = com.wishabi.flipp.app.FeaturedFragment.a(FeaturedFragment.c(a));
        HashMap hashmap = new HashMap();
        hashmap.put("sort", s);
        a1.a("change_sort", hashmap, false);
        a1.a("Home", "Home | Sort Changed", (new StringBuilder("Home | Sort Changed | SORT ")).append(s).toString());
        return true;
_L3:
        com.wishabi.flipp.app.FeaturedFragment.a(a, cb.b);
        continue; /* Loop/switch isn't completed */
_L4:
        com.wishabi.flipp.app.FeaturedFragment.a(a, cb.c);
        if (true) goto _L6; else goto _L5
_L5:
    }
}
