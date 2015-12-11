// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.mobile.ads.GoogleTextAdLoader;
import com.google.android.gms.ads.AdListener;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragment, SearchViewManager

class val.textAdLoader extends AdListener
{

    final SearchResultFragment this$0;
    final GoogleTextAdLoader val$textAdLoader;

    public void onAdLoaded()
    {
        super.onAdLoaded();
        if (val$textAdLoader.textAdView != null && SearchResultFragment.access$200(SearchResultFragment.this) != null)
        {
            SearchResultFragment.access$200(SearchResultFragment.this).googleTextAdLoaded(val$textAdLoader.textAdView);
        }
    }

    ()
    {
        this$0 = final_searchresultfragment;
        val$textAdLoader = GoogleTextAdLoader.this;
        super();
    }
}
