// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.EnumSet;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CentralCustomerAttributeStoreCommunication, AttributeCallbackHelpers

class val.callbackFuture
    implements Runnable
{

    final CentralCustomerAttributeStoreCommunication this$0;
    final CallbackFuture val$callbackFuture;
    final String val$directedId;
    final Bundle val$info;
    final String val$key;
    final EnumSet val$options;

    public void run()
    {
        Object obj = CentralCustomerAttributeStoreCommunication.access$000(CentralCustomerAttributeStoreCommunication.this, "getAttribute", val$directedId, val$key, val$info, val$options);
        if (obj == null)
        {
            AttributeCallbackHelpers.callbackWithError(val$callbackFuture, 1, "Cannot construct command");
            return;
        }
        try
        {
            obj = CentralCustomerAttributeStoreCommunication.access$100(CentralCustomerAttributeStoreCommunication.this, ((org.json.JSONObject) (obj)));
            Object obj1 = CentralCustomerAttributeStoreCommunication.this;
            obj1 = val$key;
            CentralCustomerAttributeStoreCommunication.access$200$556cb143$6c7269f3(val$callbackFuture, ((Bundle) (obj)), 2, String.format("Key %s not supported", new Object[] {
                val$key
            }));
            return;
        }
        catch (RemoteMAPException remotemapexception)
        {
            MAPLog.e(CentralCustomerAttributeStoreCommunication.access$300(), "Failed to call getAttribute", remotemapexception);
        }
        AttributeCallbackHelpers.callbackWithError(val$callbackFuture, 4, "Failed to call getAttribute");
    }

    ()
    {
        this$0 = final_centralcustomerattributestorecommunication;
        val$directedId = s;
        val$key = s1;
        val$info = bundle;
        val$options = enumset;
        val$callbackFuture = CallbackFuture.this;
        super();
    }
}
