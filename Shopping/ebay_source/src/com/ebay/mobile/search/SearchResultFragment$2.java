// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.os.Parcelable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.ebay.common.net.api.search.SearchResultState;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragment, SearchViewManager

class val.gridState
    implements android.view.animation.ener
{

    final SearchResultFragment this$0;
    final Parcelable val$gridState;

    public void onAnimationEnd(Animation animation)
    {
        animation = SearchResultFragment.access$400(SearchResultFragment.this).getResult();
        SearchResultFragment.access$600(SearchResultFragment.this, animation, SearchResultFragment.access$500(SearchResultFragment.this));
        animation = SearchResultFragment.access$400(SearchResultFragment.this).getSearchAds();
        if (animation != null)
        {
            SearchResultFragment.access$200(SearchResultFragment.this).adsLoaded(animation, SearchResultFragment.access$700(SearchResultFragment.this));
        }
        SearchResultFragment.access$200(SearchResultFragment.this).postGridViewRunnable(new Runnable() {

            final SearchResultFragment._cls2 this$1;

            public void run()
            {
                SearchResultFragment.access$200(this$0).startGridViewAnimation(AnimationUtils.loadAnimation(getActivity(), 0x7f04000e));
                SearchResultFragment.access$200(this$0).restoreGridState(gridState);
            }

            
            {
                this$1 = SearchResultFragment._cls2.this;
                super();
            }
        });
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = final_searchresultfragment;
        val$gridState = Parcelable.this;
        super();
    }
}
