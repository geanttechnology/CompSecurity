// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback, ParseUser, ParseException

public abstract class LogInCallback extends ParseCallback
{

    public LogInCallback()
    {
    }

    public abstract void done(ParseUser parseuser, ParseException parseexception);

    void internalDone(ParseUser parseuser, ParseException parseexception)
    {
        done(parseuser, parseexception);
    }

    volatile void internalDone(Object obj, ParseException parseexception)
    {
        internalDone((ParseUser)obj, parseexception);
    }
}
