// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.authentication;


public class SigningException extends Exception
{

    public SigningException(String s)
    {
        super(s);
    }

    public SigningException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
