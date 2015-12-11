// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;

import java.net.URI;

// Referenced classes of package amazon.communication.identity:
//            DeviceIdentity, ExplicitServiceIdentity, ServiceIdentity, UrlEndpointIdentity, 
//            EndpointIdentity

public class EndpointIdentityFactory
{

    private EndpointIdentityFactory()
    {
    }

    public static EndpointIdentity createFromUrn(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            throw new IllegalArgumentException("URN must be non-empty");
        }
        if (DeviceIdentity.matchesUrn(s))
        {
            return new DeviceIdentity(s);
        }
        if (ExplicitServiceIdentity.matchesUrn(s))
        {
            return new ExplicitServiceIdentity(s);
        }
        if (ServiceIdentity.matchesUrn(s))
        {
            return new ServiceIdentity(s);
        }
        UrlEndpointIdentity urlendpointidentity;
        try
        {
            URI.create(s);
            urlendpointidentity = new UrlEndpointIdentity(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid URN: ").append(s).append(" Urn should map to one of the sub-classes of EndpointIdentity.").toString());
        }
        return urlendpointidentity;
    }

    public static ServiceIdentity createServiceIdentity(String s)
    {
        return createServiceIdentity(s, null, null, null, null);
    }

    public static ServiceIdentity createServiceIdentity(String s, String s1, String s2, String s3, Integer integer)
    {
        return new ServiceIdentity(s, s1, s2, s3, integer);
    }

    public static UrlEndpointIdentity createUrlEndpointIdentity(String s)
    {
        return new UrlEndpointIdentity(s);
    }
}
