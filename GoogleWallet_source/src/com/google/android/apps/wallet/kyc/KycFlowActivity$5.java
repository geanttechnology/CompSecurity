// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.wallet.kyc;

import com.google.android.apps.wallet.kyc.api.KycClient;
import java.util.concurrent.Callable;

// Referenced classes of package com.google.android.apps.wallet.kyc:
//            KycFlowActivity

final class this._cls0
    implements Callable
{

    final KycFlowActivity this$0;

    private com.google.wallet.proto.api.ycDataResponse call()
        throws Exception
    {
        return kycClient.getKycData();
    }

    public final volatile Object call()
        throws Exception
    {
        return call();
    }

    esponse()
    {
        this$0 = KycFlowActivity.this;
        super();
    }
}
