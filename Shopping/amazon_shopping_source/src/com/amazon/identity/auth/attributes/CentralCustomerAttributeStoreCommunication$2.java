// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CentralCustomerAttributeStoreCommunication, AttributeCallbackHelpers

class val.callbackFuture
    implements Runnable
{

    final CentralCustomerAttributeStoreCommunication this$0;
    final CallbackFuture val$callbackFuture;
    final String val$directedId;
    final String val$key;
    final String val$value;

    public void run()
    {
        Bundle bundle;
        Object obj;
        bundle = new Bundle();
        bundle.putString(val$key, val$value);
        obj = CentralCustomerAttributeStoreCommunication.access$000(CentralCustomerAttributeStoreCommunication.this, "setAttribute", val$directedId, val$key, bundle, null);
        if (obj == null)
        {
            AttributeCallbackHelpers.callbackWithError(val$callbackFuture, 1, "Cannot construct command");
            return;
        }
        bundle = null;
        obj = CentralCustomerAttributeStoreCommunication.access$100(CentralCustomerAttributeStoreCommunication.this, ((org.json.JSONObject) (obj)));
        bundle = ((Bundle) (obj));
_L2:
        CentralCustomerAttributeStoreCommunication.access$200(CentralCustomerAttributeStoreCommunication.this, val$key, val$callbackFuture, bundle, 5, String.format("Unable to set the attribute for key: %s.", new Object[] {
            val$key
        }));
        return;
        ExecutionException executionexception;
        executionexception;
        MAPLog.e(CentralCustomerAttributeStoreCommunication.access$300(), "Failed to setAttribute in central customer attribute store", executionexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$0 = final_centralcustomerattributestorecommunication;
        val$key = s;
        val$value = s1;
        val$directedId = s2;
        val$callbackFuture = CallbackFuture.this;
        super();
    }
}
