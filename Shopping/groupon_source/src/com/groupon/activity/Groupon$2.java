// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.activity:
//            Groupon

class this._cls0
    implements ReturningFunction1
{

    final Groupon this$0;

    public Boolean execute(Exception exception)
    {
        Groupon.access$202(Groupon.this, false);
        refresh();
        return Boolean.valueOf(true);
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    ion1()
    {
        this$0 = Groupon.this;
        super();
    }
}
