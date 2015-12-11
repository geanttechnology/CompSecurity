// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.rmr;


// Referenced classes of package amazon.communication.rmr:
//            RmrResponseException

public class RmrResponseCanceledException extends RmrResponseException
{

    public RmrResponseCanceledException()
    {
        super("Request canceled");
    }
}
