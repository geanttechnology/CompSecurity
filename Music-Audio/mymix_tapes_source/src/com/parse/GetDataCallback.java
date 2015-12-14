// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback, ParseException

public abstract class GetDataCallback extends ParseCallback
{

    public GetDataCallback()
    {
    }

    public abstract void done(byte abyte0[], ParseException parseexception);

    volatile void internalDone(Object obj, ParseException parseexception)
    {
        internalDone((byte[])obj, parseexception);
    }

    final void internalDone(byte abyte0[], ParseException parseexception)
    {
        done(abyte0, parseexception);
    }
}
