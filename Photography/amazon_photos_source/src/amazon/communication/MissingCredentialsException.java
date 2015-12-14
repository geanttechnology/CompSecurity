// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;


// Referenced classes of package amazon.communication:
//            CommunicationBaseException

public final class MissingCredentialsException extends CommunicationBaseException
{

    public MissingCredentialsException(String s)
    {
        super(s);
    }

    public MissingCredentialsException(String s, Exception exception)
    {
        super(s, exception);
    }
}
