// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            FeedFragment

class this._cls0
    implements PMApiResponseHandler
{

    final FeedFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            FeedFragment.access$200(FeedFragment.this, pmapiresponse, false);
        }
    }

    r()
    {
        this$0 = FeedFragment.this;
        super();
    }
}
