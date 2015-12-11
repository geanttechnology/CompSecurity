// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.base.BaseFragmentContainer;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RecommendationsFragment

class a
    implements android.widget.tener
{

    final RecommendationsFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        RecommendationsFragment.a(a, (String)RecommendationsFragment.a(a).get(i));
        adapterview = new PLPFragment(true, RecommendationsFragment.b(a), (String)RecommendationsFragment.c(a).get(i), 50);
        ((BaseFragmentContainer)a.getParentFragment()).a(adapterview, true);
    }

    (RecommendationsFragment recommendationsfragment)
    {
        a = recommendationsfragment;
        super();
    }
}
