// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.ReturningFunction1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            GiftCodes

class this._cls0
    implements ReturningFunction1
{

    final GiftCodes this$0;

    public Boolean execute(Exception exception)
    {
        Ln.d("CODES: exception", new Object[0]);
        return Boolean.valueOf(true);
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    n1()
    {
        this$0 = GiftCodes.this;
        super();
    }
}
