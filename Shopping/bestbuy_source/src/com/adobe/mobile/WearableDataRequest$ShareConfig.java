// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import atz;

// Referenced classes of package com.adobe.mobile:
//            WearableDataRequest, ConfigSynchronizer

class uuid extends WearableDataRequest
{

    protected atz getDataMap()
    {
        atz atz1 = new atz();
        atz1.a("Type", "Config");
        atz1.a("ID", uuid);
        return atz1;
    }

    protected atz handle(Context context)
    {
        context = new atz();
        context.a("ID", uuid);
        context.a("Type", "Config");
        context.a(ConfigSynchronizer.getSharedConfig());
        return context;
    }

    protected (int i)
    {
        super(i);
    }

    protected (atz atz1)
    {
        uuid = atz1.f("ID");
    }
}
