// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.MySize;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            MySizeFragment

class this._cls0
    implements PMApiResponseHandler
{

    final MySizeFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            if (isAdded())
            {
                hideProgressDialog();
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                sizeData = (MySize)pmapiresponse.data;
                MySizeFragment.access$000(MySizeFragment.this);
                setupViews();
                MySizeFragment.access$100(MySizeFragment.this);
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.t.ActionContext.LOAD_MY_SIZES, getString(0x7f0600e9)));
    }

    tionContext()
    {
        this$0 = MySizeFragment.this;
        super();
    }
}
