// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;


// Referenced classes of package amazon.communication:
//            CommunicationBaseException

public class RegistrationFailedException extends CommunicationBaseException
{

    public RegistrationFailedException(Exception exception)
    {
        super(exception);
    }

    public RegistrationFailedException(String s)
    {
        super(s);
    }
}
