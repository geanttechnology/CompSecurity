// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            PMException

public class InvalidShareCallerException extends PMException
{

    public InvalidShareCallerException()
    {
        super("An Activity or a fragment class needs to be passed in as the first parameter!");
    }

    public InvalidShareCallerException(Throwable throwable)
    {
        super("An Activity or a fragment class needs to be passed in as the first parameter!", throwable);
    }
}
