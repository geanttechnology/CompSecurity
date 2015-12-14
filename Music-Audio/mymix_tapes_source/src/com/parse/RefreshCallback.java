// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback, ParseObject, ParseException

public abstract class RefreshCallback extends ParseCallback
{

    public RefreshCallback()
    {
    }

    public abstract void done(ParseObject parseobject, ParseException parseexception);

    final void internalDone(ParseObject parseobject, ParseException parseexception)
    {
        done(parseobject, parseexception);
    }

    volatile void internalDone(Object obj, ParseException parseexception)
    {
        internalDone((ParseObject)obj, parseexception);
    }
}
