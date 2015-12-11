// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.data_model.models.Features;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import java.util.Date;

// Referenced classes of package com.poshmark.utils:
//            FeatureManager

class this._cls0
    implements PMApiResponseHandler
{

    final FeatureManager this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        synchronized (mutex)
        {
            if (!pmapiresponse.hasError())
            {
                lastFetchTime = new Date();
                currentFeatures = (Features)pmapiresponse.data;
                FeatureManager.access$000(FeatureManager.this);
            }
        }
        return;
        pmapiresponse;
        obj;
        JVM INSTR monitorexit ;
        throw pmapiresponse;
    }

    res()
    {
        this$0 = FeatureManager.this;
        super();
    }
}
