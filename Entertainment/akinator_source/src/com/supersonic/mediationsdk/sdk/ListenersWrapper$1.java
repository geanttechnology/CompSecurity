// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;


// Referenced classes of package com.supersonic.mediationsdk.sdk:
//            ListenersWrapper, RewardedVideoListener

class this._cls0
    implements Runnable
{

    final ListenersWrapper this$0;

    public void run()
    {
        ListenersWrapper.access$100(ListenersWrapper.this).onRewardedVideoInitSuccess();
    }

    er()
    {
        this$0 = ListenersWrapper.this;
        super();
    }
}
