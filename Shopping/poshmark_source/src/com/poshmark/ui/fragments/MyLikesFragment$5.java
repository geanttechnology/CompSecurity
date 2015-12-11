// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.customviews.ListingsFilterWidget;

// Referenced classes of package com.poshmark.ui.fragments:
//            MyLikesFragment

class this._cls0
    implements PMApiResponseHandler
{

    final MyLikesFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            MyLikesFragment.access$200(MyLikesFragment.this, pmapiresponse, false);
            if (filterWidget != null)
            {
                filterWidget.setVisibility(0);
            }
        }
    }

    dget()
    {
        this$0 = MyLikesFragment.this;
        super();
    }
}
