// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            ChangePasswordFragment

class this._cls0
    implements PMApiResponseHandler
{

    final ChangePasswordFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            hideProgressDialog();
            if (!pmapiresponse.hasError())
            {
                pmapiresponse = (com.poshmark.user.tatus)pmapiresponse.data;
                isPasswordSet = ((com.poshmark.user.tatus) (pmapiresponse)).password_set;
                ChangePasswordFragment.access$000(ChangePasswordFragment.this);
            }
        }
    }

    ()
    {
        this$0 = ChangePasswordFragment.this;
        super();
    }
}
