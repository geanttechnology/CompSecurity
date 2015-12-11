// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.exceptions;


// Referenced classes of package com.digidust.elokence.akinator.exceptions:
//            AkException

public class AkTraductionsNotLoadedException extends AkException
{

    private static final long serialVersionUID = 0xa8207ead31cb8f8bL;

    public AkTraductionsNotLoadedException()
    {
    }

    public AkTraductionsNotLoadedException(String s)
    {
        super(s);
    }

    public AkTraductionsNotLoadedException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public AkTraductionsNotLoadedException(Throwable throwable)
    {
        super(throwable);
    }
}
