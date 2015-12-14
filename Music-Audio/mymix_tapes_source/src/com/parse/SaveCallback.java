// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback, ParseException

public abstract class SaveCallback extends ParseCallback
{

    public SaveCallback()
    {
    }

    public abstract void done(ParseException parseexception);

    volatile void internalDone(Object obj, ParseException parseexception)
    {
        internalDone((Void)obj, parseexception);
    }

    final void internalDone(Void void1, ParseException parseexception)
    {
        done(parseexception);
    }
}
