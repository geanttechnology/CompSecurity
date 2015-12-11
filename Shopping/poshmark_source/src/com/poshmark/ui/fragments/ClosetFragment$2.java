// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.LinearLayout;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.view_holders.ClosetHeaderViewHolder;

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
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                ClosetFragment.access$102(ClosetFragment.this, (UserInfoDetails)pmapiresponse.data);
                ClosetFragment.access$000(ClosetFragment.this, false);
                ClosetFragment.access$200(ClosetFragment.this);
                setupActionBar();
                ClosetFragment.access$300(ClosetFragment.this).filterWidgetLayout.setVisibility(0);
            }
            return;
        }
        hideProgressDialog();
        int i;
        if (pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_NOT_FOUND || pmapiresponse.apiError.pmErrorType == PMErrorType.HTTP_GONE)
        {
            i = 0x7f0600dd;
        } else
        {
            i = 0x7f0600eb;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.t.ActionContext.LOAD_USER_PROFILE, getString(i)));
    }

    tionContext()
    {
        this$0 = ClosetFragment.this;
        super();
    }
}
