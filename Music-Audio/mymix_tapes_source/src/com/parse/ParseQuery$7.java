// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseQuery, ParseCommand

class 
    implements Callable
{

    final ParseQuery this$0;
    final boolean val$shouldRetry;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        if (val$shouldRetry)
        {
            ParseQuery.access$400(ParseQuery.this).enableRetrying();
        }
        return null;
    }

    llable()
    {
        this$0 = final_parsequery;
        val$shouldRetry = Z.this;
        super();
    }
}
