// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.widget.ImageView;
import it.sephiroth.android.library.widget.AbsHListView;
import it.sephiroth.android.library.widget.HListView;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkCollectionsFragment

class val.collectionShadowRight
    implements it.sephiroth.android.library.widget.
{

    final NetworkCollectionsFragment this$0;
    final ImageView val$collectionShadowLeft;
    final ImageView val$collectionShadowRight;
    final HListView val$gallery;

    public void onScroll(AbsHListView abshlistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsHListView abshlistview, int i)
    {
        NetworkCollectionsFragment.access$000(NetworkCollectionsFragment.this, val$gallery, val$collectionShadowLeft, val$collectionShadowRight);
        boolean flag = isFlinging();
        NetworkCollectionsFragment.access$102(NetworkCollectionsFragment.this, i);
        if (flag && !isFlinging())
        {
            NetworkCollectionsFragment.access$200().debug("notifyDataSetChanged because we are no longer flinging");
            ((ogramAdapter)val$gallery.getAdapter()).notifyDataSetChanged();
        }
    }

    ogramAdapter()
    {
        this$0 = final_networkcollectionsfragment;
        val$gallery = hlistview;
        val$collectionShadowLeft = imageview;
        val$collectionShadowRight = ImageView.this;
        super();
    }
}
