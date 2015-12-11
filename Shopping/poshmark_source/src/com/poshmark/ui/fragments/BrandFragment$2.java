// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.Brand;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandFragment

class this._cls0
    implements PMApiResponseHandler
{

    final BrandFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            if (!pmapiresponse.hasError())
            {
                BrandFragment.access$102(BrandFragment.this, (Brand)pmapiresponse.data);
                BrandFragment.access$202(BrandFragment.this, BrandFragment.access$100(BrandFragment.this).canonical_name);
                brandUnknown = false;
                BrandFragment.access$300(BrandFragment.this);
            } else
            {
                brandUnknown = true;
            }
            setupActionBar();
            BrandFragment.access$400(BrandFragment.this);
        }
    }

    ()
    {
        this$0 = BrandFragment.this;
        super();
    }
}
