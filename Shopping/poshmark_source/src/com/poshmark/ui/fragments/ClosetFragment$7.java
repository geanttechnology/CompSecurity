// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import com.poshmark.application.PMApplication;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            ClosetFragment

class this._cls0
    implements PMApiResponseHandler
{

    final ClosetFragment this$0;

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
                showAutoHideSuccessMessage(getString(0x7f060228));
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.t.ActionContext.REPORT_USER, PMApplication.getContext().getString(0x7f0600f6)));
    }

    tionContext()
    {
        this$0 = ClosetFragment.this;
        super();
    }
}
