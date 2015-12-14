// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback, ParseConfig, ParseException

public abstract class ConfigCallback extends ParseCallback
{

    public ConfigCallback()
    {
    }

    public abstract void done(ParseConfig parseconfig, ParseException parseexception);

    final void internalDone(ParseConfig parseconfig, ParseException parseexception)
    {
        done(parseconfig, parseexception);
    }

    volatile void internalDone(Object obj, ParseException parseexception)
    {
        internalDone((ParseConfig)obj, parseexception);
    }
}
