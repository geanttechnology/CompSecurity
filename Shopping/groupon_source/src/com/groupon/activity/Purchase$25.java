// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.Function0;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.activity:
//            Purchase

class this._cls0
    implements Function0
{

    final Purchase this$0;

    public void execute()
    {
        setIsRefreshingBreakdowns(false);
        if (!Purchase.access$2300(Purchase.this).get() && !Purchase.access$1000(Purchase.this))
        {
            setIsRefreshing(false);
        }
        fromGiftCodesScreen = false;
    }

    cBoolean()
    {
        this$0 = Purchase.this;
        super();
    }
}
