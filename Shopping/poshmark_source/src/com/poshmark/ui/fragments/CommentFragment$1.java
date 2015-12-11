// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.data_model.models.UserInteractions;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            CommentFragment

class this._cls0
    implements PMApiResponseHandler
{

    final CommentFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded() && !pmapiresponse.hasError())
        {
            interactionsData = (UserInteractions)pmapiresponse.data;
            interactionsData.addContextualData(listingDetails);
            CommentFragment.access$000(CommentFragment.this);
        }
    }

    ons()
    {
        this$0 = CommentFragment.this;
        super();
    }
}
