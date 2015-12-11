// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.UserReferenceList;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindFriendsFragment

class this._cls0
    implements PMApiResponseHandler
{

    final FindFriendsFragment this$0;

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
                twitterList = (UserReferenceList)pmapiresponse.data;
                FindFriendsFragment.access$300(FindFriendsFragment.this);
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ionContext.FETCH_TWITTER_PM_USERS));
    }

    ontext()
    {
        this$0 = FindFriendsFragment.this;
        super();
    }
}
