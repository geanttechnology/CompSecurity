// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback2, ParseTaskUtils, ParseException, ParseCallback1

static final class val.callback
    implements ParseCallback2
{

    final ParseCallback1 val$callback;

    public volatile void done(Object obj, Throwable throwable)
    {
        done((Void)obj, (ParseException)throwable);
    }

    public void done(Void void1, ParseException parseexception)
    {
        val$callback.done(parseexception);
    }

    (ParseCallback1 parsecallback1)
    {
        val$callback = parsecallback1;
        super();
    }
}
