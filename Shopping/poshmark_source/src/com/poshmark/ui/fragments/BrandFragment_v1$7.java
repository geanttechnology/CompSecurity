// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.customviews.ListingsFilterWidget;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandFragment_v1

class this._cls0
    implements PMApiResponseHandler
{

    final BrandFragment_v1 this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            BrandFragment_v1.access$600(BrandFragment_v1.this, pmapiresponse, false);
            hideFilterButtonsForSingleFacet();
            filterWidget.setVisibility(0);
        }
    }

    get()
    {
        this$0 = BrandFragment_v1.this;
        super();
    }
}
