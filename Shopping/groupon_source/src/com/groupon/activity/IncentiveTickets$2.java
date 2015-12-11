// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.ReturningFunction1;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            IncentiveTickets

class this._cls0
    implements ReturningFunction1
{

    final IncentiveTickets this$0;

    public Boolean execute(Exception exception)
    {
        IncentiveTickets.access$200(IncentiveTickets.this, loadingView, false);
        exception = IncentiveTickets.this;
        android.widget.TextView textview = emptyView;
        boolean flag;
        if (IncentiveTickets.access$000(IncentiveTickets.this) == null || IncentiveTickets.access$000(IncentiveTickets.this).size() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        IncentiveTickets.access$200(exception, textview, flag);
        return Boolean.valueOf(false);
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    ()
    {
        this$0 = IncentiveTickets.this;
        super();
    }
}
