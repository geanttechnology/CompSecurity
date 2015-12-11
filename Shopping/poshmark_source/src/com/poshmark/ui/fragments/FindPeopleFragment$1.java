// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.UserReferenceList;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindPeopleFragment

class this._cls0
    implements PMApiResponseHandler
{

    final FindPeopleFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            hideProgressDialog();
            if (isAdded())
            {
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                suggestedUserList = (UserReferenceList)pmapiresponse.data;
                FindPeopleFragment.access$000(FindPeopleFragment.this);
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.tionContext.FETCH_SUGGESTED_USERS));
    }

    Context()
    {
        this$0 = FindPeopleFragment.this;
        super();
    }
}
