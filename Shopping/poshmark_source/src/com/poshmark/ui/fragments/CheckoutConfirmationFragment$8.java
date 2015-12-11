// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.PMOrder;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment

class val.map
    implements PMApiResponseHandler
{

    final CheckoutConfirmationFragment this$0;
    final Map val$map;
    final PMOrder val$order;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            CheckoutConfirmationFragment.access$300(CheckoutConfirmationFragment.this, pmapiresponse, val$order, val$map);
        }
    }

    ()
    {
        this$0 = final_checkoutconfirmationfragment;
        val$order = pmorder;
        val$map = Map.this;
        super();
    }
}
