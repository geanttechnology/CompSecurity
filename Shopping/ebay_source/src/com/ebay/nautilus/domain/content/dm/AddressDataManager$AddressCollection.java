// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.util.Log;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            AddressDataManager

private static final class ttl extends BaseDataMapped
{

    public List content;
    public long ttl;

    public boolean isStale()
    {
        return System.currentTimeMillis() > ttl;
    }

    public ()
    {
        content = null;
    }

    public content(Content content1)
    {
        content = null;
        content = (List)content1.getData();
        ttl = System.currentTimeMillis() + 0x5265c00L;
        if (Log.isLoggable("AddressDataManagerTtl", 3))
        {
            ttl = System.currentTimeMillis() + 0x927c0L;
            AddressDataManager.logger.ttl("overriding TTL to ten minutes");
        }
    }
}
