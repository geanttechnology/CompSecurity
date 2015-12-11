// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.wear;

import com.amazon.mShop.wearable.WearableService;

// Referenced classes of package com.amazon.mShop.wearable.wear:
//            MShopWearListenerService

private class mSuccess extends mSuccess
{

    private final String mPath;
    private final String mSuccess;
    final MShopWearListenerService this$0;

    public void onSuccess()
    {
        MShopWearListenerService.access$1100(mNode, mMessageId, mPath, null);
        if (mSuccess != null)
        {
            MShopWearListenerService.access$1500(MShopWearListenerService.this).incrementMetricCounter("VoiceSearch", mSuccess, 1);
        }
    }

    public (String s, String s1, String s2)
    {
        this(s, s1, s2, null, null);
    }

    public <init>(String s, String s1, String s2, String s3, String s4)
    {
        this$0 = MShopWearListenerService.this;
        super(MShopWearListenerService.this, s, s1, s4);
        mPath = s2;
        mSuccess = s3;
    }
}
