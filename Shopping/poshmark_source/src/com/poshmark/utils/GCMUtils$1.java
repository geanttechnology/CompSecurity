// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.application.PMApplicationSession;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.utils:
//            GCMUtils

class this._cls0
    implements PMApiResponseHandler
{

    final GCMUtils this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (!pmapiresponse.hasError())
        {
            PMApplicationSession.GetPMSession().setGCMRegIdSentFlag(true);
            return;
        } else
        {
            PMApplicationSession.GetPMSession().setGCMRegIdSentFlag(false);
            return;
        }
    }

    ponse()
    {
        this$0 = GCMUtils.this;
        super();
    }
}
