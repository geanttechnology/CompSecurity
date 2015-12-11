// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.callback;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.identity.auth.device.callback:
//            RemoteCallbackWrapper

class val.result
    implements Runnable
{

    final val.result this$0;
    final Bundle val$result;

    public void run()
    {
        cess._mth000(this._cls0.this).onError(val$result);
    }

    ()
    {
        this$0 = final_;
        val$result = Bundle.this;
        super();
    }
}
