// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;

// Referenced classes of package com.poshmark.utils:
//            BundleFlowHandler

class this._cls0
    implements PMApiResponseHandler
{

    final BundleFlowHandler this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (callingFragment.isAdded())
        {
            BundleFlowHandler.access$000(BundleFlowHandler.this, pmapiresponse);
        }
    }

    ler()
    {
        this$0 = BundleFlowHandler.this;
        super();
    }
}
