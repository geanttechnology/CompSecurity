// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            VideoCastManager

class this._cls0
    implements ResultCallback
{

    final VideoCastManager this$0;

    public void onResult(com.google.android.gms.cast.ediaChannelResult ediachannelresult)
    {
        if (!ediachannelresult.getStatus().isSuccess())
        {
            onFailed(com.google.sample.castcompanionlibrary.tus_request, ediachannelresult.getStatus().getStatusCode());
        }
    }

    public volatile void onResult(Result result)
    {
        onResult((com.google.android.gms.cast.ediaChannelResult)result);
    }

    t()
    {
        this$0 = VideoCastManager.this;
        super();
    }
}
