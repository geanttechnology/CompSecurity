// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.database.Cursor;
import android.graphics.RectF;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.content.a;
import com.wishabi.flipp.content.ad;
import com.wishabi.flipp.content.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.app:
//            dn, SearchFragment, dr

final class ef extends dn
{

    final SearchFragment a;

    ef(SearchFragment searchfragment)
    {
        a = searchfragment;
        super();
    }

    public final void a(int i)
    {
        if (SearchFragment.b(a) == null || SearchFragment.b(a).getCount() == 0)
        {
            return;
        } else
        {
            ad ad1 = new ad(SearchFragment.b(a), SearchFragment.c(a), i);
            SearchFragment searchfragment = a;
            ad1.a.moveToPosition(ad1.c);
            com.wishabi.flipp.app.SearchFragment.a(searchfragment, ad1.a.getInt(ad1.b.k), new RectF(ad1.c(), ad1.a(), ad1.d(), ad1.b()), null);
            return;
        }
    }

    public final void b(int i)
    {
        if (SearchFragment.d(a) != null && !SearchFragment.d(a).isEmpty() && SearchFragment.e(a) != null && !SearchFragment.e(a).isEmpty())
        {
            Object obj = new ad(SearchFragment.b(a), SearchFragment.c(a), i);
            obj = (ArrayList)SearchFragment.e(a).get(Long.valueOf(((ad) (obj)).e()));
            if (obj != null && !((ArrayList) (obj)).isEmpty())
            {
                int ai[] = com.wishabi.flipp.content.a.a(((ArrayList) (obj)));
                com.wishabi.flipp.app.dr.a(a.getActivity(), ai, false, p.g);
                return;
            }
        }
    }
}
