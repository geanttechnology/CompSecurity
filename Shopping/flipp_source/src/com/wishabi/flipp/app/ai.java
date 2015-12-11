// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.database.Cursor;
import com.wishabi.flipp.content.FlyerActivityIntent;
import com.wishabi.flipp.widget.CollectionView;
import com.wishabi.flipp.widget.bw;
import com.wishabi.flipp.widget.r;

// Referenced classes of package com.wishabi.flipp.app:
//            FavoritesFragment

final class ai
    implements r
{

    final FavoritesFragment a;

    ai(FavoritesFragment favoritesfragment)
    {
        a = favoritesfragment;
        super();
    }

    public final void a(CollectionView collectionview, int i)
    {
        collectionview = (bw)collectionview.getAdapter();
        Activity activity;
        if (collectionview != null)
        {
            if ((collectionview = (Cursor)collectionview.getItem(i)) != null && (activity = a.getActivity()) != null)
            {
                collectionview.moveToPosition(i);
                activity.startActivityForResult(new FlyerActivityIntent(activity, collectionview), 0);
                activity.overridePendingTransition(0x7f040001, 0x7f040002);
                return;
            }
        }
    }
}
