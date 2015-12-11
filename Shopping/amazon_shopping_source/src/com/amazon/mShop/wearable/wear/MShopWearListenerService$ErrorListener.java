// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import com.amazon.mShop.wearable.AbstractResultListener;
import com.amazon.mShop.wearable.WearableService;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

private abstract class mMessageId extends AbstractResultListener
{

    private final String mError;
    protected final String mMessageId;
    protected final String mNode;
    final MShopWearListenerService this$0;

    public final void onError(String s, Throwable throwable)
    {
        MShopWearListenerService.access$1400(mNode, mMessageId, "/error", s);
        if (mError != null)
        {
            MShopWearListenerService.access$1500(MShopWearListenerService.this).incrementMetricCounter("VoiceSearch", mError, 1);
        }
    }

    public (String s, String s1)
    {
        this(s, s1, null);
    }

    public <init>(String s, String s1, String s2)
    {
        this$0 = MShopWearListenerService.this;
        super();
        mNode = s;
        mError = s2;
        mMessageId = s1;
    }
}
