// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.view.View;
import java.util.HashMap;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPFragment

class c
    implements android.view.stener
{

    final String a;
    final HashMap b;
    final String c;
    final PLPFragment d;

    public void onClick(View view)
    {
        String s = a;
        view = s;
        if (b != null)
        {
            view = s;
            if (!b.isEmpty())
            {
                view = s;
                if (b.containsKey(a))
                {
                    view = (String)b.get(a);
                }
            }
        }
        PLPFragment.a(d, c, a, view);
    }

    (PLPFragment plpfragment, String s, HashMap hashmap, String s1)
    {
        d = plpfragment;
        a = s;
        b = hashmap;
        c = s1;
        super();
    }
}
