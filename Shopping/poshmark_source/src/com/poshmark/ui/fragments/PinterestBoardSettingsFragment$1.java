// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.meta_data.PinterestSettings;

// Referenced classes of package com.poshmark.ui.fragments:
//            PinterestBoardSettingsFragment

class this._cls0
    implements PMApiResponseHandler
{

    final PinterestBoardSettingsFragment this$0;

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
                pins = (PinterestSettings)pmapiresponse.data;
                PinterestBoardSettingsFragment.access$000(PinterestBoardSettingsFragment.this);
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.LOAD_USER_SETTINGS, getString(0x7f0600ed)));
    }

    ()
    {
        this$0 = PinterestBoardSettingsFragment.this;
        super();
    }
}
