// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.database.Cursor;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.content.o;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.app:
//            dn, SearchFragment, dr

final class ei extends dn
{

    final SearchFragment a;

    ei(SearchFragment searchfragment)
    {
        a = searchfragment;
        super();
    }

    public final void a(int i)
    {
        if (SearchFragment.i(a) != null && SearchFragment.i(a).getCount() != 0 && SearchFragment.h(a) != null && !SearchFragment.h(a).isEmpty() && SearchFragment.i(a).moveToPosition(i))
        {
            i = SearchFragment.i(a).getInt(SearchFragment.i(a).getColumnIndexOrThrow("_id"));
            Object obj = (ArrayList)SearchFragment.h(a).get(Integer.valueOf(i));
            if (obj != null && !((ArrayList) (obj)).isEmpty())
            {
                obj = (o)((ArrayList) (obj)).get(0);
                SearchFragment.a(a, ((o) (obj)).b, ((o) (obj)).a(), null);
                return;
            }
        }
    }

    public final void b(int i)
    {
        while (SearchFragment.i(a) == null || SearchFragment.i(a).getCount() == 0 || !SearchFragment.i(a).moveToPosition(i)) 
        {
            return;
        }
        i = SearchFragment.i(a).getInt(SearchFragment.g(a).getColumnIndexOrThrow("_id"));
        android.app.Activity activity = a.getActivity();
        p p1 = p.c;
        dr.a(activity, new int[] {
            i
        }, true, p1);
    }
}
