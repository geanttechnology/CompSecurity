// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.Function2;

// Referenced classes of package com.groupon.activity:
//            AbstractDetailsBase

class this._cls0
    implements Function2
{

    final AbstractDetailsBase this$0;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        if (AbstractDetailsBase.access$000(AbstractDetailsBase.this))
        {
            return;
        }
        if (isDeepLinked)
        {
            handleDeepLinkError();
            return;
        } else
        {
            handleException(exception);
            return;
        }
    }

    ()
    {
        this$0 = AbstractDetailsBase.this;
        super();
    }
}
