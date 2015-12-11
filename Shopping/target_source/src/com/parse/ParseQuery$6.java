// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback2, ParseQuery, CountCallback, ParseException

class 
    implements ParseCallback2
{

    final ParseQuery this$0;
    final CountCallback val$callback;

    public void done(Integer integer, ParseException parseexception)
    {
        CountCallback countcallback = val$callback;
        int i;
        if (parseexception == null)
        {
            i = integer.intValue();
        } else
        {
            i = -1;
        }
        countcallback.done(i, parseexception);
    }

    public volatile void done(Object obj, Throwable throwable)
    {
        done((Integer)obj, (ParseException)throwable);
    }

    ()
    {
        this$0 = final_parsequery;
        val$callback = CountCallback.this;
        super();
    }
}
