// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            SharingSettingsFragment

class this._cls0
    implements PMApiResponseHandler
{

    final SharingSettingsFragment this$0;

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
                settingsData = (com.poshmark.user.gment.settingsData)pmapiresponse.data;
                SharingSettingsFragment.access$000(SharingSettingsFragment.this, getView());
                if (SharingSettingsFragment.access$100(SharingSettingsFragment.this))
                {
                    SharingSettingsFragment.access$200(SharingSettingsFragment.this);
                }
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ontext.LOAD_USER_SETTINGS, getString(0x7f0600ed)));
    }

    xt()
    {
        this$0 = SharingSettingsFragment.this;
        super();
    }
}
