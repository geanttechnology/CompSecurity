// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            IncentiveTickets

class this._cls0
    implements Function1
{

    final IncentiveTickets this$0;

    public void execute(UserContainer usercontainer)
    {
        boolean flag = false;
        IncentiveTickets.access$002(IncentiveTickets.this, usercontainer.user.incentiveTickets);
        IncentiveTickets.access$100(IncentiveTickets.this).notifyDataSetChanged();
        IncentiveTickets.access$200(IncentiveTickets.this, loadingView, false);
        usercontainer = IncentiveTickets.this;
        android.widget.TextView textview = emptyView;
        if (IncentiveTickets.access$000(IncentiveTickets.this) == null || IncentiveTickets.access$000(IncentiveTickets.this).size() == 0)
        {
            flag = true;
        }
        IncentiveTickets.access$200(usercontainer, textview, flag);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((UserContainer)obj);
    }

    centiveTicketsAdapter()
    {
        this$0 = IncentiveTickets.this;
        super();
    }
}
