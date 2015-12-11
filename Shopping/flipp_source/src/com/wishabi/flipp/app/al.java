// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.database.Cursor;
import android.util.SparseArray;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.content.FlyerActivityIntent;
import com.wishabi.flipp.content.h;
import com.wishabi.flipp.widget.CollectionView;
import com.wishabi.flipp.widget.ba;
import com.wishabi.flipp.widget.bc;
import com.wishabi.flipp.widget.bw;
import com.wishabi.flipp.widget.ca;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.app:
//            FavoritesFragment

final class al
    implements bc
{

    final FavoritesFragment a;

    al(FavoritesFragment favoritesfragment)
    {
        a = favoritesfragment;
        super();
    }

    public final void a(ba ba1)
    {
        h h1;
        h1 = ba1.getFeaturedItem();
        break MISSING_BLOCK_LABEL_5;
        if (h1 != null && FavoritesFragment.c(a) != null)
        {
            SparseArray sparsearray = com.wishabi.flipp.app.FavoritesFragment.a(a).getActiveViews();
            int l = sparsearray.size();
            int j = 0;
            int i = -1;
            for (; j < l; j++)
            {
                int k = sparsearray.keyAt(j);
                if (FavoritesFragment.c(a).e(k) == ca.b && (ba)sparsearray.get(k) == ba1)
                {
                    i = k;
                }
            }

            if (i != -1)
            {
                ba1 = (Cursor)FavoritesFragment.c(a).getItem(i);
                if (ba1 != null)
                {
                    Activity activity = a.getActivity();
                    if (activity != null)
                    {
                        com.wishabi.flipp.content.Flyer.Model model = new com.wishabi.flipp.content.Flyer.Model(ba1);
                        a.a.b(model, "Favorites".toLowerCase(Locale.US), h1);
                        activity.startActivityForResult(new FlyerActivityIntent(activity, ba1, h1.a()), 0);
                        activity.overridePendingTransition(0x7f040001, 0x7f040002);
                        return;
                    }
                }
            }
        }
        return;
    }
}
