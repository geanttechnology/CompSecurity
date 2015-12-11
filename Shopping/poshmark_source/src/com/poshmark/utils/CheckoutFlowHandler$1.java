// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.fragments.PMFragment;

// Referenced classes of package com.poshmark.utils:
//            CheckoutFlowHandler

class this._cls0
    implements PMApiResponseHandler
{

    final CheckoutFlowHandler this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (callingFragment.isAdded())
        {
            CheckoutFlowHandler.access$000(CheckoutFlowHandler.this, pmapiresponse);
        }
    }

    r()
    {
        this$0 = CheckoutFlowHandler.this;
        super();
    }
}
