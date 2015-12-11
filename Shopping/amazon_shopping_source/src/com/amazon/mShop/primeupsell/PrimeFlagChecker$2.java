// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;


// Referenced classes of package com.amazon.mShop.primeupsell:
//            PrimeFlagChecker

class this._cls0
    implements Runnable
{

    final PrimeFlagChecker this$0;

    public void run()
    {
        if (PrimeFlagChecker.access$000(PrimeFlagChecker.this) != null)
        {
            PrimeFlagChecker.access$000(PrimeFlagChecker.this).onCancelled();
        }
    }

    bscriber()
    {
        this$0 = PrimeFlagChecker.this;
        super();
    }
}
