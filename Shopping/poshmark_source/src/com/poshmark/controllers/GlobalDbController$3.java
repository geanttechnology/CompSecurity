// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.os.AsyncTask;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.poshmark.db.AllBrandsModel;
import com.poshmark.db.FollowingBrandsUpdater;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.controllers:
//            GlobalDbController

class this._cls0
    implements PMApiResponseHandler
{

    final GlobalDbController this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        Void avoid[];
label0:
        {
            if (!pmapiresponse.hasError())
            {
                pmapiresponse = new FollowingBrandsUpdater((AllBrandsModel)pmapiresponse.data, true);
                avoid = new Void[0];
                if (pmapiresponse instanceof AsyncTask)
                {
                    break label0;
                }
                pmapiresponse.execute(avoid);
            }
            return;
        }
        AsyncTaskInstrumentation.execute((AsyncTask)pmapiresponse, avoid);
    }

    ncTaskInstrumentation()
    {
        this$0 = GlobalDbController.this;
        super();
    }
}
