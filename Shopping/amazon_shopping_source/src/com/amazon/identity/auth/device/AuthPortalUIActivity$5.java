// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.RemoteCallbackWrapper;

// Referenced classes of package com.amazon.identity.auth.device:
//            AuthPortalUIActivity

class val.errorBundle
    implements Runnable
{

    final AuthPortalUIActivity this$0;
    final Bundle val$errorBundle;

    public void run()
    {
        if (val$errorBundle == null)
        {
            finish();
            return;
        }
        RemoteCallbackWrapper remotecallbackwrapper = AuthPortalUIActivity.access$2500(AuthPortalUIActivity.this);
        if (remotecallbackwrapper != null)
        {
            remotecallbackwrapper.onError(val$errorBundle);
        }
        AuthPortalUIActivity.access$2600(AuthPortalUIActivity.this);
    }

    Wrapper()
    {
        this$0 = final_authportaluiactivity;
        val$errorBundle = Bundle.this;
        super();
    }
}
