// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.UserReferenceList;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;
import java.util.List;

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
label1:
            {
                if (isAdded())
                {
                    hideProgressDialog();
                    if (pmapiresponse.hasError())
                    {
                        break label0;
                    }
                    searchResultsList = (UserReferenceList)pmapiresponse.data;
                    if (searchResultsList.getConnectionInfoList().size() <= 0)
                    {
                        break label1;
                    }
                    FindPeopleFragment.access$300(FindPeopleFragment.this, searchResultsList, _LIST_MODE.SEARCH_PEOPLE_MODE);
                }
                return;
            }
            showAutoHideProgressDialogWithMessage(getString(0x7f0601d3));
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.tionContext.FETCH_FACEBOOK_PM_USERS));
    }

    Context()
    {
        this$0 = FindPeopleFragment.this;
        super();
    }
}
