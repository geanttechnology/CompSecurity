// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.util.Log;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelsContainer;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssChannelsDataManager

private static final class ttl extends BaseDataMapped
{

    public final ChannelsContainer channelsContainer;
    public long ttl;

    public boolean isStale()
    {
        return System.currentTimeMillis() > ttl;
    }

    public (Content content)
    {
        channelsContainer = (ChannelsContainer)content.getData();
        ttl = System.currentTimeMillis() + 0xdbba0L;
        if (Log.isLoggable("UssChannelsDmTtl", 3))
        {
            ttl = System.currentTimeMillis() + 0x927c0L;
            UssChannelsDataManager.logger.ttl("overriding TTL to ten minutes");
        }
    }
}
