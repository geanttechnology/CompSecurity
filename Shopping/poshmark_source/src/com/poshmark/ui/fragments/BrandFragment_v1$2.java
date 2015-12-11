// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.Brand;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

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
            if (!pmapiresponse.hasError())
            {
                BrandFragment_v1.access$102(BrandFragment_v1.this, (Brand)pmapiresponse.data);
                BrandFragment_v1.access$202(BrandFragment_v1.this, BrandFragment_v1.access$100(BrandFragment_v1.this).canonical_name);
                brandUnknown = false;
                BrandFragment_v1.access$300(BrandFragment_v1.this);
            } else
            {
                brandUnknown = true;
            }
            BrandFragment_v1.access$400(BrandFragment_v1.this);
        }
    }

    ()
    {
        this$0 = BrandFragment_v1.this;
        super();
    }
}
