// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.exceptions;


// Referenced classes of package com.amazon.clouddrive.exceptions:
//            RetryException

public class SystemFault extends RetryException
{

    public SystemFault()
    {
    }

    public SystemFault(String s)
    {
        super(s);
    }

    public SystemFault(String s, String s1, String s2)
    {
        super(s, s1, s2);
    }
}
