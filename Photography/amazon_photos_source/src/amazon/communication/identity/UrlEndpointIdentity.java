// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;


// Referenced classes of package amazon.communication.identity:
//            EndpointIdentity

public class UrlEndpointIdentity extends EndpointIdentity
{

    private final String mUrn;

    UrlEndpointIdentity(String s)
    {
        mUrn = s;
    }

    public String toLogSafeString()
    {
        return "URNs may contain PII";
    }

    public String toString()
    {
        return mUrn;
    }
}
