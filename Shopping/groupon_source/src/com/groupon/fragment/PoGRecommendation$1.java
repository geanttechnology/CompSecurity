// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.support.v7.widget.RecyclerView;
import com.groupon.activity.PoGSearch;

// Referenced classes of package com.groupon.fragment:
//            PoGRecommendation

class ScrollListener extends android.support.v7.widget.lListener
{

    final PoGRecommendation this$0;

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        super.onScrollStateChanged(recyclerview, i);
    }

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        super.onScrolled(recyclerview, i, j);
        if (activity instanceof PoGSearch)
        {
            ((PoGSearch)activity).dismissKeyboard();
        }
    }

    ScrollListener()
    {
        this$0 = PoGRecommendation.this;
        super();
    }
}
