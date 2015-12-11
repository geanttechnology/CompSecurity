// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            NewFeedFragment

class this._cls0
    implements PMApiResponseHandler
{

    final NewFeedFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            NewFeedFragment.access$200(NewFeedFragment.this, pmapiresponse, true);
        }
    }

    ()
    {
        this$0 = NewFeedFragment.this;
        super();
    }
}
