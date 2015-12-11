// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;

import com.supersonic.mediationsdk.logger.SupersonicError;

// Referenced classes of package com.supersonic.mediationsdk.sdk:
//            ListenersWrapper, OfferwallListener

class val.supersonicError
    implements Runnable
{

    final ListenersWrapper this$0;
    final SupersonicError val$supersonicError;

    public void run()
    {
        ListenersWrapper.access$300(ListenersWrapper.this).onOfferwallInitFail(val$supersonicError);
    }

    _cls9()
    {
        this$0 = final_listenerswrapper;
        val$supersonicError = SupersonicError.this;
        super();
    }
}
