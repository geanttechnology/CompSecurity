// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries;

import com.target.mothership.common.params.RegistryDetailsParam;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.model.c;
import com.target.mothership.util.h;

// Referenced classes of package com.target.mothership.model.registries:
//            a, b

public class d extends c
    implements a
{

    private b mLiveDataSource;

    public d()
    {
        mLiveDataSource = new b();
    }

    public void a(RegistryDetailsParam registrydetailsparam, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("registry_details.json");
            mLiveDataSource.a(registrydetailsparam, h1);
            return;
        }
    }

    public void a(RegistrySearchParam registrysearchparam, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("registry_search.json");
            mLiveDataSource.a(registrysearchparam, h1);
            return;
        }
    }
}
