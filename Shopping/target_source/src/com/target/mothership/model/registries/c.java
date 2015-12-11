// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.registries;

import com.target.mothership.b;
import com.target.mothership.common.params.RegistryDetailsParam;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.model.a;
import com.target.mothership.model.h;

// Referenced classes of package com.target.mothership.model.registries:
//            a, d, b

public class c extends a
    implements com.target.mothership.model.registries.a
{

    private com.target.mothership.model.registries.a mDataSource;

    public c()
    {
        if (b.a().m())
        {
            mDataSource = new d();
            return;
        } else
        {
            mDataSource = new com.target.mothership.model.registries.b();
            return;
        }
    }

    public void a(RegistryDetailsParam registrydetailsparam, h h)
    {
        mDataSource.a(registrydetailsparam, h);
    }

    public void a(RegistrySearchParam registrysearchparam, h h)
    {
        mDataSource.a(registrysearchparam, h);
    }
}
