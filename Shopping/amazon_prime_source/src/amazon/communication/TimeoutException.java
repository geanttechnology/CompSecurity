// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;


public class TimeoutException extends Exception
{

    public TimeoutException(String s)
    {
        super(s);
    }

    public TimeoutException(String s, Exception exception)
    {
        super(s, exception);
    }
}
