// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.sample.castcompanionlibrary.utils.LogUtils;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            BaseCastManager

class this._cls0
    implements ResultCallback
{

    final BaseCastManager this$0;

    public void onResult(com.google.android.gms.cast.nnectionResult nnectionresult)
    {
        if (nnectionresult.getStatus().isSuccess())
        {
            LogUtils.LOGD(BaseCastManager.access$000(), "joinApplication() -> success");
            onApplicationConnected(nnectionresult.getApplicationMetadata(), nnectionresult.getApplicationStatus(), nnectionresult.getSessionId(), nnectionresult.getWasLaunched());
            return;
        } else
        {
            LogUtils.LOGD(BaseCastManager.access$000(), "joinApplication() -> failure");
            onApplicationConnectionFailed(nnectionresult.getStatus().getStatusCode());
            return;
        }
    }

    public volatile void onResult(Result result)
    {
        onResult((com.google.android.gms.cast.nnectionResult)result);
    }

    ()
    {
        this$0 = BaseCastManager.this;
        super();
    }
}
