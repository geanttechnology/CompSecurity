// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback, ParseException

public abstract class CountCallback extends ParseCallback
{

    public CountCallback()
    {
    }

    public abstract void done(int i, ParseException parseexception);

    void internalDone(Integer integer, ParseException parseexception)
    {
        if (parseexception == null)
        {
            done(integer.intValue(), null);
            return;
        } else
        {
            done(-1, parseexception);
            return;
        }
    }

    volatile void internalDone(Object obj, ParseException parseexception)
    {
        internalDone((Integer)obj, parseexception);
    }
}
