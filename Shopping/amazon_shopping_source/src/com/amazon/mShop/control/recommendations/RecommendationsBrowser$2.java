// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.recommendations;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.recommendations:
//            RecommendationsBrowser

class val.serviceCall
    implements Runnable
{

    final RecommendationsBrowser this$0;
    final byte val$image[];
    final int val$intraPageIndex;
    final ServiceCall val$serviceCall;

    public void run()
    {
        int i = RecommendationsBrowser.access$500(RecommendationsBrowser.this) * RecommendationsBrowser.access$600(RecommendationsBrowser.this) + val$intraPageIndex;
        if (!hasDeletedAt(i))
        {
            i = amountHasDelted(i);
            int j = val$intraPageIndex;
            RecommendationsBrowser.access$800(RecommendationsBrowser.this, RecommendationsBrowser.access$700(RecommendationsBrowser.this), val$image, j - i, val$serviceCall);
        }
    }

    ()
    {
        this$0 = final_recommendationsbrowser;
        val$intraPageIndex = i;
        val$image = abyte0;
        val$serviceCall = ServiceCall.this;
        super();
    }
}
