// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.b;

import com.gimbal.a.a;
import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.service.protocol.ResolveTransmittersRequest;
import com.gimbal.internal.proximity.core.service.protocol.ResolveTransmittersResponse;
import org.springframework.web.client.RestTemplate;

// Referenced classes of package com.gimbal.internal.proximity.core.service.b:
//            c, a

public final class b extends com.gimbal.internal.proximity.core.service.b.c
{

    private static final a b = c.e(com/gimbal/internal/proximity/core/service/b/a.getName());

    public b(com.gimbal.internal.rest.c c1)
    {
        super(c1);
    }

    public final void a(Object obj, com.gimbal.internal.proximity.c c1, RestTemplate resttemplate)
    {
        obj = (ResolveTransmittersRequest)obj;
        resttemplate = (ResolveTransmittersResponse)resttemplate.getForObject(a.a(String.format("%s%s%s", new Object[] {
            "beacon/payload/", ((ResolveTransmittersRequest) (obj)).getPayload(), "/lookahead"
        })), com/gimbal/internal/proximity/core/service/protocol/ResolveTransmittersResponse, new Object[0]);
        if (b.a())
        {
            (new StringBuilder("GET RESULT - \n")).append(com.gimbal.internal.d.b.b(resttemplate));
        }
        resttemplate.setSighting(((ResolveTransmittersRequest) (obj)).getSighting());
        c1.a(resttemplate);
    }

}
