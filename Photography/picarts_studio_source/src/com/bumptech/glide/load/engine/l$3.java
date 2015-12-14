// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

// Referenced classes of package com.bumptech.glide.load.engine:
//            l

final class egy extends l
{

    public final boolean a()
    {
        return false;
    }

    public final boolean a(DataSource datasource)
    {
        return datasource != DataSource.DATA_DISK_CACHE && datasource != DataSource.MEMORY_CACHE;
    }

    public final boolean a(boolean flag, DataSource datasource, EncodeStrategy encodestrategy)
    {
        return false;
    }

    public final boolean b()
    {
        return true;
    }

    egy()
    {
    }
}
