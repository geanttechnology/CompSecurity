// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback, ParseException

public abstract class ProgressCallback extends ParseCallback
{

    Integer maxProgressSoFar;

    public ProgressCallback()
    {
        maxProgressSoFar = Integer.valueOf(0);
    }

    public abstract void done(Integer integer);

    final void internalDone(Integer integer, ParseException parseexception)
    {
        if (integer.intValue() > maxProgressSoFar.intValue())
        {
            maxProgressSoFar = integer;
            done(integer);
        }
    }

    volatile void internalDone(Object obj, ParseException parseexception)
    {
        internalDone((Integer)obj, parseexception);
    }
}
