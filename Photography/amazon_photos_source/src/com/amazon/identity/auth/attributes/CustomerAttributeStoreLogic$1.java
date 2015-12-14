// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.KeyInfo;
import java.util.EnumSet;

// Referenced classes of package com.amazon.identity.auth.attributes:
//            CustomerAttributeStoreLogic, CustomerAttributeStoreKeyUtils

class val.tracer
    implements Runnable
{

    final CustomerAttributeStoreLogic this$0;
    final CallbackFuture val$callbackFuture;
    final String val$directedId;
    final String val$key;
    final EnumSet val$options;
    final Tracer val$tracer;

    public void run()
    {
        KeyInfo keyinfo = KeyInfo.parseKey(val$key);
        if (CustomerAttributeStoreKeyUtils.isCorPfm(keyinfo))
        {
            CustomerAttributeStoreLogic.access$000(CustomerAttributeStoreLogic.this, val$callbackFuture, val$directedId, keyinfo.getKey(), val$options, val$tracer);
            return;
        }
        if (CustomerAttributeStoreKeyUtils.isCustomerProfileAttributeKey(keyinfo))
        {
            CustomerAttributeStoreLogic.access$100(CustomerAttributeStoreLogic.this, val$callbackFuture, val$directedId, keyinfo, val$options, val$tracer);
            return;
        }
        if (CustomerAttributeStoreKeyUtils.isXMainAndXACBCookies(keyinfo))
        {
            keyinfo = keyinfo.getPackagelessKeyInfo();
            CustomerAttributeStoreLogic.access$200(CustomerAttributeStoreLogic.this, val$callbackFuture, val$directedId, keyinfo, val$options, val$tracer);
            return;
        }
        if (CustomerAttributeStoreKeyUtils.isXFSNCookie(keyinfo))
        {
            CustomerAttributeStoreLogic.access$300(CustomerAttributeStoreLogic.this, val$callbackFuture, val$directedId, keyinfo);
            return;
        } else
        {
            CustomerAttributeStoreLogic.access$400(CustomerAttributeStoreLogic.this, val$callbackFuture, keyinfo.getRawKey());
            return;
        }
    }

    ()
    {
        this$0 = final_customerattributestorelogic;
        val$key = s;
        val$callbackFuture = callbackfuture;
        val$directedId = s1;
        val$options = enumset;
        val$tracer = Tracer.this;
        super();
    }
}
