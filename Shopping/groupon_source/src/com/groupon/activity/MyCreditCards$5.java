// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.activity:
//            MyCreditCards

class this._cls0
    implements Function1
{

    final MyCreditCards this$0;

    public void execute(UserContainer usercontainer)
    {
        if (usercontainer != null)
        {
            if (MyCreditCards.access$400(MyCreditCards.this))
            {
                java.util.List list = usercontainer.user.billingRecords;
                MyCreditCards.access$500(MyCreditCards.this, list);
            }
            usercontainer = usercontainer.user.creditsAvailable;
            MyCreditCards.access$600(MyCreditCards.this, usercontainer);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((UserContainer)obj);
    }

    ()
    {
        this$0 = MyCreditCards.this;
        super();
    }
}
