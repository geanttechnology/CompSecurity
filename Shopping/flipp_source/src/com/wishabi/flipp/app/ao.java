// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.database.Cursor;
import android.widget.ListAdapter;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.content.FlyerActivityIntent;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.CollectionView;
import com.wishabi.flipp.widget.bw;
import com.wishabi.flipp.widget.by;
import com.wishabi.flipp.widget.cb;
import com.wishabi.flipp.widget.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.wishabi.flipp.app:
//            FeaturedFragment, av

final class ao
    implements r
{

    final FeaturedFragment a;

    ao(FeaturedFragment featuredfragment)
    {
        a = featuredfragment;
        super();
    }

    public final void a(CollectionView collectionview, int i)
    {
        Object obj;
        int j;
        int k;
        k = com.wishabi.flipp.app.FeaturedFragment.a(a).e(i);
        obj = com.wishabi.flipp.app.FeaturedFragment.a(a).c.iterator();
        j = 0;
_L15:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        Object obj1 = (by)((Iterator) (obj)).next();
        if (((by) (obj1)).a != k) goto _L4; else goto _L3
_L3:
        if (k == 0 || j < 0) goto _L6; else goto _L5
_L5:
        com.wishabi.flipp.app.av.a[k - 1];
        JVM INSTR tableswitch 1 2: default 100
    //                   1 281
    //                   2 287;
           goto _L7 _L8 _L9
_L7:
        obj = "Unknown";
_L12:
        obj1 = a.a;
        String s = FeaturedFragment.b(a);
        String s1 = q.a(FeaturedFragment.c(a).toString());
        j = i - j;
        HashMap hashmap = new HashMap();
        hashmap.put("Category", s);
        hashmap.put("Sort", s1);
        hashmap.put("Placement", obj);
        hashmap.put("Position", Integer.toString(j));
        ((a) (obj1)).a("flyer_click", hashmap, false);
        ((a) (obj1)).a("Flyer Clicked", (new StringBuilder("Flyer Clicked | ")).append(s).toString(), String.format("Flyer Clicked | %s | SORT %s | PLACE %s", new Object[] {
            s, s1, obj
        }), Long.valueOf(j));
_L6:
        collectionview = collectionview.getAdapter();
        if (collectionview != null) goto _L11; else goto _L10
_L10:
        return;
_L4:
        j = ((by) (obj1)).b + j;
        continue; /* Loop/switch isn't completed */
_L2:
        j = -1;
          goto _L3
_L8:
        obj = "Promoted";
          goto _L12
_L9:
        obj = "Organic";
          goto _L12
_L11:
        if ((collectionview = (Cursor)collectionview.getItem(i)) == null || (obj = a.getActivity()) == null) goto _L10; else goto _L13
_L13:
        ((Activity) (obj)).startActivityForResult(new FlyerActivityIntent(((android.content.Context) (obj)), collectionview), 0);
        ((Activity) (obj)).overridePendingTransition(0x7f040001, 0x7f040002);
        return;
        if (true) goto _L15; else goto _L14
_L14:
    }
}
