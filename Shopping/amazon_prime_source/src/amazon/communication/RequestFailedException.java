// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;


public class RequestFailedException extends Exception
{

    public RequestFailedException(Exception exception)
    {
        super(exception);
    }

    public RequestFailedException(String s)
    {
        super(s);
    }

    public RequestFailedException(String s, Exception exception)
    {
        super(s, exception);
    }
}
