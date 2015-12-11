// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseException, ParseRequest

private static class isPermanentFailure extends ParseException
{

    boolean isPermanentFailure;

    public (int i, String s)
    {
        super(i, s);
        isPermanentFailure = false;
    }

    public isPermanentFailure(int i, String s, Throwable throwable)
    {
        super(i, s, throwable);
        isPermanentFailure = false;
    }
}
