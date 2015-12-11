// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            DealTypeService

class val.callback
    implements Runnable
{

    final DealTypeService this$0;
    final Function1 val$callback;

    public void run()
    {
        if (val$callback != null)
        {
            val$callback.execute(DealTypeService.access$200());
        }
    }

    ()
    {
        this$0 = final_dealtypeservice;
        val$callback = Function1.this;
        super();
    }
}
