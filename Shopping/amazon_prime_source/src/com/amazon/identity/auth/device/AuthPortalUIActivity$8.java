// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.RemoteCallbackWrapper;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

class val.result
    implements Runnable
{

    final AuthPortalUIActivity this$0;
    final RemoteCallbackWrapper val$callbackWrapper;
    final Bundle val$result;

    public void run()
    {
        if (val$callbackWrapper != null)
        {
            val$callbackWrapper.onSuccess(val$result);
        }
        finish();
    }

    Wrapper()
    {
        this$0 = final_authportaluiactivity;
        val$callbackWrapper = remotecallbackwrapper;
        val$result = Bundle.this;
        super();
    }
}
