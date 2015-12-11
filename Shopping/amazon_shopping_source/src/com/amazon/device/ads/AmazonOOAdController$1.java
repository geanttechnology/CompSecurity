// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOOAdController, AmazonOOAdListener, AdView

class obileExecutor extends obileExecutor
{

    final AmazonOOAdController this$0;

    protected void handleApplicationDefinedSpecialURL(String s)
    {
        AmazonOOAdListener amazonooadlistener = AmazonOOAdController.access$000(AmazonOOAdController.this);
        if (amazonooadlistener != null)
        {
            amazonooadlistener.onSpecialUrlClicked(getAdLayout(), s);
        }
    }

    obileExecutor(AdView adview, Context context)
    {
        this$0 = AmazonOOAdController.this;
        super(adview, context);
    }
}
