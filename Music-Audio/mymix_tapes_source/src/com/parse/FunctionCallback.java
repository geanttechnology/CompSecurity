// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback, ParseException

public abstract class FunctionCallback extends ParseCallback
{

    public FunctionCallback()
    {
    }

    public abstract void done(Object obj, ParseException parseexception);

    final void internalDone(Object obj, ParseException parseexception)
    {
        done(obj, parseexception);
    }
}
