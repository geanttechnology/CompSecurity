// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import com.groupon.util.Function0;

// Referenced classes of package com.groupon.service.marketrate:
//            HotelsService

protected static class onFinally
    implements Function0
{

    protected final Function0 onFinally;

    public void execute()
    {
        if (onFinally != null)
        {
            onFinally.execute();
        }
    }

    public (Function0 function0)
    {
        onFinally = function0;
    }
}
