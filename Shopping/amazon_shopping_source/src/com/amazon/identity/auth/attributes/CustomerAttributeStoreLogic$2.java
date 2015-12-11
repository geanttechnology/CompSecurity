// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CustomerAttributeStoreLogic

class val.callbackFuture
    implements Runnable
{

    final CustomerAttributeStoreLogic this$0;
    final CallbackFuture val$callbackFuture;
    final String val$directedId;
    final String val$key;
    final String val$value;

    public void run()
    {
        KeyInfo keyinfo = KeyInfo.parseKey(val$key);
        MAPLog.i(CustomerAttributeStoreLogic.access$500(), String.format("Setting the attribute for key: %s", new Object[] {
            keyinfo.getRawKey()
        }));
        CustomerAttributeStoreLogic.access$600(CustomerAttributeStoreLogic.this).setUserData(val$directedId, keyinfo.getRawKey(), val$value);
        CustomerAttributeStoreLogic.access$700(CustomerAttributeStoreLogic.this, val$callbackFuture, val$value, null);
    }

    ge()
    {
        this$0 = final_customerattributestorelogic;
        val$key = s;
        val$directedId = s1;
        val$value = s2;
        val$callbackFuture = CallbackFuture.this;
        super();
    }
}
