// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPAndroidWebViewHelper

class this._cls0
    implements Callback
{

    final MAPAndroidWebViewHelper this$0;

    public void onError(Bundle bundle)
    {
        onEvent("ON_UNABLE_TO_GET_COOKIES", bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        MAPLog.i(MAPAndroidWebViewHelper.access$100(), "Successfully registered account, set cookies in WebView, and loaded return_to url");
    }

    ()
    {
        this$0 = MAPAndroidWebViewHelper.this;
        super();
    }
}
