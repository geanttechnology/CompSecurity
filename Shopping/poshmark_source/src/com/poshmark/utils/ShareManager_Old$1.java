// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.BrandShareMessageContainer;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.utils:
//            ShareManager_Old

class this._cls0
    implements PMApiResponseHandler
{

    final ShareManager_Old this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (!pmapiresponse.hasError())
        {
            ShareManager_Old.access$102(ShareManager_Old.this, ((BrandShareMessageContainer)pmapiresponse.data).getBrandShareMessages());
        }
    }

    areMessageContainer()
    {
        this$0 = ShareManager_Old.this;
        super();
    }
}
