// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;

import com.supersonic.mediationsdk.logger.SupersonicError;

// Referenced classes of package com.supersonic.mediationsdk.sdk:
//            ListenersWrapper, RewardedVideoListener

class val.error
    implements Runnable
{

    final ListenersWrapper this$0;
    final SupersonicError val$error;

    public void run()
    {
        ListenersWrapper.access$100(ListenersWrapper.this).onRewardedVideoInitFail(val$error);
    }

    er()
    {
        this$0 = final_listenerswrapper;
        val$error = SupersonicError.this;
        super();
    }
}
