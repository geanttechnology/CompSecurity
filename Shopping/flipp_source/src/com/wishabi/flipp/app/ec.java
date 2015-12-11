// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.database.Cursor;
import com.wishabi.flipp.widget.CollectionView;
import com.wishabi.flipp.widget.ci;
import com.wishabi.flipp.widget.r;

// Referenced classes of package com.wishabi.flipp.app:
//            SearchFragment

final class ec
    implements r
{

    final SearchFragment a;

    ec(SearchFragment searchfragment)
    {
        a = searchfragment;
        super();
    }

    public final void a(CollectionView collectionview, int i)
    {
        if (SearchFragment.p(a).getAdapter() != SearchFragment.q(a)) goto _L2; else goto _L1
_L1:
        collectionview = ((CollectionView) (SearchFragment.q(a).getItem(i)));
        if (collectionview == null) goto _L2; else goto _L3
_L3:
        SearchFragment.q(a).getItemViewType(i);
        JVM INSTR tableswitch 1 1: default 64
    //                   1 65;
           goto _L2 _L4
_L2:
        return;
_L4:
        collectionview = (Cursor)collectionview;
        i = collectionview.getInt(collectionview.getColumnIndexOrThrow("flyer_id"));
        SearchFragment.a(a, i, null, null);
        return;
    }
}
