// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.view.ViewGroup;
import android.view.animation.Animation;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity

class val.show
    implements android.view.animation.val.show
{

    final SearchResultFragmentActivity this$0;
    final ViewGroup val$refinementLayout;
    final boolean val$show;

    public void onAnimationEnd(Animation animation)
    {
        animation = val$refinementLayout;
        int i;
        if (val$show)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        animation.setVisibility(i);
        SearchResultFragmentActivity.access$002(SearchResultFragmentActivity.this, false);
        if (SearchResultFragmentActivity.access$100(SearchResultFragmentActivity.this) != null)
        {
            SearchResultFragmentActivity.access$200(SearchResultFragmentActivity.this, SearchResultFragmentActivity.access$100(SearchResultFragmentActivity.this).booleanValue());
            SearchResultFragmentActivity.access$102(SearchResultFragmentActivity.this, null);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ()
    {
        this$0 = final_searchresultfragmentactivity;
        val$refinementLayout = viewgroup;
        val$show = Z.this;
        super();
    }
}
