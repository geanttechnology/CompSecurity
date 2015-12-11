// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries;

import com.target.mothership.common.params.RegistryDetailsParam;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.model.e;
import com.target.mothership.model.h;
import com.target.mothership.services.apigee.k.c.a;

// Referenced classes of package com.target.mothership.model.registries:
//            a

public class b
    implements com.target.mothership.model.registries.a
{

    private com.target.mothership.services.e.g.c.a mRedSkyRegistryDetailService;
    private a mServices;

    public b()
    {
        mServices = new a();
        mRedSkyRegistryDetailService = new com.target.mothership.services.e.g.c.a();
    }

    public void a(RegistryDetailsParam registrydetailsparam, h h)
    {
        h = new e(new com.target.mothership.model.registries.handler.a(h));
        mRedSkyRegistryDetailService.a(registrydetailsparam, h);
    }

    public void a(RegistrySearchParam registrysearchparam, h h)
    {
        h = new e(new com.target.mothership.model.registries.handler.b(h));
        mServices.a(registrysearchparam, h);
    }
}
