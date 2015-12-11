// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.wishabi.flipp.b.aq;
import com.wishabi.flipp.content.ai;
import com.wishabi.flipp.util.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.app:
//            SearchFragment

final class ea extends aq
{

    final LoaderManager a;
    final SearchFragment b;

    ea(SearchFragment searchfragment, Context context, ContentResolver contentresolver, String s, String s1, LoaderManager loadermanager)
    {
        b = searchfragment;
        a = loadermanager;
        super(context, contentresolver, s, s1);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (HashMap)obj;
        if (obj != null)
        {
            com.wishabi.flipp.app.SearchFragment.a(b, (ArrayList)((HashMap) (obj)).get("items"));
            obj = (ArrayList)((HashMap) (obj)).get("coupons");
            com.wishabi.flipp.app.SearchFragment.a(b);
            SearchFragment.k(b);
            if (obj != null)
            {
                Bundle bundle = new Bundle();
                bundle.putIntArray("coupon_ids", com.wishabi.flipp.util.a.a(((List) (obj))));
                if (SearchFragment.l(b))
                {
                    a.restartLoader(4, bundle, b);
                    a.restartLoader(6, bundle, b);
                }
                if (SearchFragment.m(b))
                {
                    a.restartLoader(5, bundle, b);
                }
            }
            if (SearchFragment.d(b) != null)
            {
                obj = new long[SearchFragment.d(b).size()];
                for (int i = 0; i < SearchFragment.d(b).size(); i++)
                {
                    obj[i] = ((ai)SearchFragment.d(b).get(i)).a;
                }

                Bundle bundle1 = new Bundle();
                bundle1.putLongArray("item_ids", ((long []) (obj)));
                a.restartLoader(3, bundle1, b);
                if (SearchFragment.n(b))
                {
                    a.restartLoader(2, bundle1, b);
                }
            }
        }
    }
}
