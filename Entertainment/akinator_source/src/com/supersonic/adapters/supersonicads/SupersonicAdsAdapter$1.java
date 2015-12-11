// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.adapters.supersonicads;

import com.supersonic.mediationsdk.sdk.OfferwallListener;
import com.supersonicads.sdk.SSAFactory;

// Referenced classes of package com.supersonic.adapters.supersonicads:
//            SupersonicAdsAdapter

class this._cls0
    implements Runnable
{

    final SupersonicAdsAdapter this$0;

    public void run()
    {
        SupersonicAdsAdapter.access$002(SupersonicAdsAdapter.this, SSAFactory.getPublisherInstance(SupersonicAdsAdapter.access$100(SupersonicAdsAdapter.this)));
        SupersonicAdsAdapter.access$200(SupersonicAdsAdapter.this).onOfferwallInitSuccess();
    }

    ()
    {
        this$0 = SupersonicAdsAdapter.this;
        super();
    }
}
