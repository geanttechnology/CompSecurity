// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.content.ai;
import com.wishabi.flipp.util.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.app:
//            dn, SearchFragment, dr

final class eg extends dn
{

    final SearchFragment a;

    eg(SearchFragment searchfragment)
    {
        a = searchfragment;
        super();
    }

    public final void a(int i)
    {
        ai ai1;
        if (SearchFragment.d(a) != null && !SearchFragment.d(a).isEmpty())
        {
            if ((ai1 = (ai)SearchFragment.d(a).get(i)) != null)
            {
                com.wishabi.flipp.content.Flyer.Model model = com.wishabi.flipp.app.SearchFragment.a(a, ai1.b, ai1.e, Boolean.valueOf(ai1.h));
                a a1 = a.a;
                long l = ai1.a;
                String s1 = SearchFragment.f(a);
                if (model != null)
                {
                    String as[] = s1.split(" ", 2);
                    String s;
                    HashMap hashmap;
                    if (as.length > 1 && q.b(as[0]))
                    {
                        s = as[1];
                    } else
                    {
                        s = s1;
                    }
                    hashmap = new HashMap();
                    hashmap.put("flyer_id", String.valueOf(model.a));
                    hashmap.put("analytics_payload", model.o);
                    hashmap.put("flyer_run_id", String.valueOf(model.b));
                    hashmap.put("flyer_type_id", String.valueOf(model.c));
                    hashmap.put("merchant_id", String.valueOf(model.d));
                    hashmap.put("flyer_item_id", Long.toString(l));
                    hashmap.put("q", s);
                    hashmap.put("q_raw", s1);
                    hashmap.put("postal_code", a1.k);
                    hashmap.put("rank", String.valueOf(i));
                    a1.a("search_hit", hashmap, false);
                    a1.a("search hit", String.format("search hit | %s", new Object[] {
                        s
                    }), String.format("search hit | %s | MER %s | MID %d | FID %d", new Object[] {
                        s, model.g, Integer.valueOf(model.d), Integer.valueOf(model.a)
                    }), Long.valueOf(i));
                    return;
                }
            }
        }
    }

    public final void b(int i)
    {
        Object obj;
        if (SearchFragment.d(a) != null && !SearchFragment.d(a).isEmpty() && SearchFragment.e(a) != null && !SearchFragment.e(a).isEmpty())
        {
            if ((obj = (ai)SearchFragment.d(a).get(i)) != null && ((obj = (ArrayList)SearchFragment.e(a).get(Long.valueOf(((ai) (obj)).a))) != null && !((ArrayList) (obj)).isEmpty()))
            {
                int ai1[] = com.wishabi.flipp.content.a.a(((ArrayList) (obj)));
                com.wishabi.flipp.app.dr.a(a.getActivity(), ai1, false, p.g);
                return;
            }
        }
    }
}
