// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPAndroidWebViewHelper

class val.directedId
    implements Callback
{

    final MAPAndroidWebViewHelper this$0;
    final String val$directedId;

    public void onError(Bundle bundle)
    {
        onEvent("ON_UNABLE_TO_GET_COOKIES", bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        MAPLog.i(MAPAndroidWebViewHelper.access$100(), (new StringBuilder("Cookies successfully set into webview for directed id: ")).append(val$directedId).toString());
    }

    ()
    {
        this$0 = final_mapandroidwebviewhelper;
        val$directedId = String.this;
        super();
    }
}
