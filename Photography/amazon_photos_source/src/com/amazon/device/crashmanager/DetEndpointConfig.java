// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import amazon.communication.identity.EndpointIdentity;
import amazon.communication.identity.EndpointIdentityFactory;

// Referenced classes of package com.amazon.device.crashmanager:
//            Domain

class DetEndpointConfig
{

    static EndpointIdentity getServiceEndpoint(Domain domain)
        throws Exception
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$device$crashmanager$Domain[];

            static 
            {
                $SwitchMap$com$amazon$device$crashmanager$Domain = new int[Domain.values().length];
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$Domain[Domain.PROD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$device$crashmanager$Domain[Domain.BETA.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.device.crashmanager.Domain[domain.ordinal()])
        {
        default:
            return EndpointIdentityFactory.createFromUrn("https://det-ta-g7g.vipinteg.amazon.com:443");

        case 1: // '\001'
            return EndpointIdentityFactory.createFromUrn("https://det-ta-g7g.amazon.com:443");
        }
    }
}
