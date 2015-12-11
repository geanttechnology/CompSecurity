// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.AccountManagerCallbackAdapter;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication

class  extends AccountManagerCallbackAdapter
{

    final CentralAccountManagerCommunication this$0;

    protected void onResult(Callback callback, Boolean boolean1)
    {
        if (boolean1 == null || !boolean1.booleanValue())
        {
            callback.onError(CentralAccountManagerCommunication.access$100(CentralAccountManagerCommunication.this));
            return;
        } else
        {
            callback.onSuccess(CentralAccountManagerCommunication.access$200(CentralAccountManagerCommunication.this));
            return;
        }
    }

    protected volatile void onResult(Callback callback, Object obj)
    {
        onResult(callback, (Boolean)obj);
    }

    (Callback callback)
    {
        this$0 = CentralAccountManagerCommunication.this;
        super(callback);
    }
}
