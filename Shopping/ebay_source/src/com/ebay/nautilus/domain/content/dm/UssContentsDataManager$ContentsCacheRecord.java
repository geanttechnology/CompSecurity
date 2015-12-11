// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.util.Log;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssContentsDataManager

private static final class ttl extends BaseDataMapped
{

    public final Contents content;
    public ContentSourceEnum staleContentSources[];
    public long ttl;

    public transient void addStaleContentSources(ContentSourceEnum acontentsourceenum[])
    {
        if (acontentsourceenum != null)
        {
            HashSet hashset;
            int j;
            if (staleContentSources == null)
            {
                hashset = new HashSet();
            } else
            {
                hashset = new HashSet(Arrays.asList(staleContentSources));
            }
            j = acontentsourceenum.length;
            for (int i = 0; i < j; i++)
            {
                hashset.add(acontentsourceenum[i]);
            }

            staleContentSources = new ContentSourceEnum[hashset.size()];
            hashset.toArray(staleContentSources);
        }
    }

    public boolean isStale()
    {
        return System.currentTimeMillis() > ttl;
    }

    public boolean isStaleContentSources(List list)
    {
label0:
        {
            HashSet hashset;
            if (staleContentSources == null)
            {
                hashset = new HashSet();
            } else
            {
                hashset = new HashSet(Arrays.asList(staleContentSources));
            }
            if ((list == null || list.isEmpty()) && !hashset.isEmpty())
            {
                return true;
            }
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
            } while (!hashset.contains((ContentSourceEnum)list.next()));
            return true;
        }
        return false;
    }

    public (Content content1)
    {
        content = (Contents)content1.getData();
        ttl = System.currentTimeMillis() + 0xdbba0L;
        if (Log.isLoggable("UssDataManagerTtl", 3))
        {
            ttl = System.currentTimeMillis() + 0x927c0L;
            UssContentsDataManager.logger.ttl("overriding TTL to ten minutes");
        } else
        if (UssContentsDataManager.TEST_instantStale)
        {
            ttl = System.currentTimeMillis();
            UssContentsDataManager.logger.ttl("Overriding TTL to instant stale");
            return;
        }
    }
}
