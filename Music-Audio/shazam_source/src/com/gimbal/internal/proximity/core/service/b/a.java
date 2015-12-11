// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.b;

import com.gimbal.internal.c.c;
import com.gimbal.internal.d.b;
import com.gimbal.internal.proximity.core.c.d;
import com.gimbal.internal.proximity.core.service.protocol.ResolveTransmittersRequest;
import com.gimbal.internal.proximity.core.service.protocol.ResolveTransmittersResponse;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import org.springframework.web.client.RestTemplate;

// Referenced classes of package com.gimbal.internal.proximity.core.service.b:
//            c

public class a extends com.gimbal.internal.proximity.core.service.b.c
{

    private static final com.gimbal.a.a b = c.e(com/gimbal/internal/proximity/core/service/b/a.getName());

    public a(com.gimbal.internal.rest.c c1)
    {
        super(c1);
    }

    public final void a(Object obj, com.gimbal.internal.proximity.c c1, RestTemplate resttemplate)
    {
        obj = (ResolveTransmittersRequest)obj;
        ((ResolveTransmittersRequest) (obj)).getSighting().getServiceId().equals(d.f);
        resttemplate = (ResolveTransmittersResponse)resttemplate.getForObject(a.a(String.format("%s%s", new Object[] {
            "beacon/payload/", ((ResolveTransmittersRequest) (obj)).getPayload()
        })), com/gimbal/internal/proximity/core/service/protocol/ResolveTransmittersResponse, new Object[0]);
        if (b.a())
        {
            (new StringBuilder("GET RESULT - \n")).append(com.gimbal.internal.d.b.b(resttemplate));
        }
        resttemplate.setSighting(((ResolveTransmittersRequest) (obj)).getSighting());
        c1.a(resttemplate);
    }

}
