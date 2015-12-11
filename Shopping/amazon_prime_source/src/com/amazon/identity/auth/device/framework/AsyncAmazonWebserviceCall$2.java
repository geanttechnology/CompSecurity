// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.kcpsdk.auth.AmazonWebserviceCall;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            AsyncAmazonWebserviceCall

class this._cls0
    implements Runnable
{

    final AsyncAmazonWebserviceCall this$0;

    public void run()
    {
        AsyncAmazonWebserviceCall.access$100(AsyncAmazonWebserviceCall.this).call();
    }

    ()
    {
        this$0 = AsyncAmazonWebserviceCall.this;
        super();
    }
}
