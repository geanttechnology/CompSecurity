// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.recommendations;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.control.recommendations:
//            RecommendationsBrowser

class val.serviceCall
    implements Runnable
{

    final RecommendationsBrowser this$0;
    final int val$intraPageIndex;
    final SearchResult val$o;
    final ServiceCall val$serviceCall;

    public void run()
    {
        int i = RecommendationsBrowser.access$000(RecommendationsBrowser.this);
        int j = RecommendationsBrowser.access$100(RecommendationsBrowser.this);
        int k = val$intraPageIndex;
        int l = val$intraPageIndex;
        int i1 = getRatingPendingIndexSet().size();
        RecommendationsBrowser.access$200(RecommendationsBrowser.this).add(new Integer(i * j + k));
        RecommendationsBrowser.access$400(RecommendationsBrowser.this, RecommendationsBrowser.access$300(RecommendationsBrowser.this), val$o, l - i1, val$serviceCall);
    }

    ()
    {
        this$0 = final_recommendationsbrowser;
        val$intraPageIndex = i;
        val$o = searchresult;
        val$serviceCall = ServiceCall.this;
        super();
    }
}
