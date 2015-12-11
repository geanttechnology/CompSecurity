// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.os.ParcelUuid;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;

// Referenced classes of package com.poshmark.ui.fragments:
//            ClosetFragment

class this._cls0
    implements PMApiResponseHandler
{

    final ClosetFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
label0:
        {
            if (isAdded())
            {
                if (pmapiresponse.hasError())
                {
                    break label0;
                }
                showAutoHideSuccessMessage(getString(0x7f0602b8));
                ClosetFragment.access$100(ClosetFragment.this).setBlockedFlag(false);
                pmapiresponse = new Bundle();
                pmapiresponse.putParcelable("PARENT_ID", new ParcelUuid(fragmentId));
                pmapiresponse.putBoolean("BLOCK_USER_STATUS", false);
                PMNotificationManager.fireNotification("com.poshmark.intents.SET_BLOCK_USER_STATUS_ACTION", pmapiresponse);
            }
            return;
        }
        showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.t.ActionContext.UNBLOCK_USER, getString(0x7f0600fd)));
    }

    tionContext()
    {
        this$0 = ClosetFragment.this;
        super();
    }
}
