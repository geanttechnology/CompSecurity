// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.activity:
//            PurchaseEu

class this._cls0
    implements ReturningFunction1
{

    final PurchaseEu this$0;

    public Boolean execute(Exception exception)
        throws RuntimeException
    {
        PurchaseEu.access$700(PurchaseEu.this, exception);
        PurchaseEu.access$800(PurchaseEu.this, exception);
        return Boolean.valueOf(true);
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    _cls1()
    {
        this$0 = PurchaseEu.this;
        super();
    }
}
