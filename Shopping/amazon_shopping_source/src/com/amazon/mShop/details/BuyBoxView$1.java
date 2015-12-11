// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;


// Referenced classes of package com.amazon.mShop.details:
//            BuyBoxView

class val.isLoading
    implements Runnable
{

    final BuyBoxView this$0;
    final boolean val$isLoading;

    public void run()
    {
        updateButtons(val$isLoading);
        updateStatus(val$isLoading);
    }

    ()
    {
        this$0 = final_buyboxview;
        val$isLoading = Z.this;
        super();
    }
}
