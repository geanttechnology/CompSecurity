// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.search;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.AdvSearchSuggestionsResponse;

// Referenced classes of package com.amazon.mShop.control.search:
//            AdvSearchSuggestionsController, AdvSearchSuggestionsSubscriber

class ponse
    implements Runnable
{

    final AdvSearchSuggestionsController this$0;
    final ServiceCall val$sc;
    final AdvSearchSuggestionsResponse val$value;

    public void run()
    {
        if (AdvSearchSuggestionsController.access$000(AdvSearchSuggestionsController.this, val$sc))
        {
            AdvSearchSuggestionsController.access$100(AdvSearchSuggestionsController.this);
            AdvSearchSuggestionsController.access$200(AdvSearchSuggestionsController.this).onSearchSuggestionsReceived(val$value.getSuggestions());
        }
    }

    ponse()
    {
        this$0 = final_advsearchsuggestionscontroller;
        val$sc = servicecall;
        val$value = AdvSearchSuggestionsResponse.this;
        super();
    }
}
