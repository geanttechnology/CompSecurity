// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.as;
import com.wishabi.flipp.content.ShoppingList;
import com.wishabi.flipp.content.SimpleSearchResult;
import com.wishabi.flipp.util.q;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment

final class ew extends as
{

    final long a;
    final String b;
    final ShoppingListFragment c;

    ew(ShoppingListFragment shoppinglistfragment, String s, String s1, Context context, long l, String s2)
    {
        c = shoppinglistfragment;
        a = l;
        b = s2;
        super(s, s1, context);
    }

    protected final void a(SimpleSearchResult simplesearchresult)
    {
        ShoppingListFragment.j(c).remove(Long.valueOf(a));
        if (c.getActivity() == null || simplesearchresult == null || ShoppingListFragment.b(c) == null)
        {
            return;
        }
        simplesearchresult.c = System.currentTimeMillis() + 0x36ee80L;
        if (!simplesearchresult.a.isEmpty()) goto _L2; else goto _L1
_L1:
        String s1;
        a a1;
        a1 = a.a;
        s1 = b;
        if (s1 == null) goto _L4; else goto _L3
_L3:
        String as1[] = s1.split(" ", 2);
        if (as1.length <= 1 || !q.b(as1[0])) goto _L4; else goto _L5
_L5:
        String s = as1[1];
_L7:
        HashMap hashmap = new HashMap();
        hashmap.put("q_raw", s1);
        hashmap.put("q", s);
        hashmap.put("hits", "0");
        a1.a("count", hashmap, false);
        a1.a("count", (new StringBuilder("count | ")).append(s).toString(), null, Long.valueOf(0L));
_L2:
        if (ShoppingListFragment.c(c) != null && simplesearchresult.b != null && simplesearchresult.b.size() == 4)
        {
            simplesearchresult.b.remove(3);
        }
        ShoppingListFragment.b(c).a(a, simplesearchresult);
        return;
_L4:
        s = s1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected final void onCancelled()
    {
        ShoppingListFragment.j(c).remove(Long.valueOf(a));
        if (!super.d)
        {
            return;
        } else
        {
            SimpleSearchResult simplesearchresult = SimpleSearchResult.a();
            simplesearchresult.c = System.currentTimeMillis() + 60000L;
            ShoppingListFragment.b(c).a(a, simplesearchresult);
            return;
        }
    }

    protected final void onPostExecute(Object obj)
    {
        a((SimpleSearchResult)obj);
    }
}
