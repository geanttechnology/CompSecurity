// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.deduplicate;

import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.deduplicate:
//            Deduplicater

public class CompositeDeduplicater
    implements Deduplicater
{

    private List deduplicaters;

    public CompositeDeduplicater()
    {
        deduplicaters = new ArrayList();
    }

    public void addDeduplicater(Deduplicater deduplicater)
    {
        deduplicaters.add(deduplicater);
    }

    public List getCloudDuplicates(MediaItem mediaitem)
    {
        for (Iterator iterator = deduplicaters.iterator(); iterator.hasNext();)
        {
            List list = ((Deduplicater)iterator.next()).getCloudDuplicates(mediaitem);
            if (list != null && !list.isEmpty())
            {
                return list;
            }
        }

        return Collections.emptyList();
    }

    public List getLocalDuplicates(MediaItem mediaitem)
    {
        for (Iterator iterator = deduplicaters.iterator(); iterator.hasNext();)
        {
            List list = ((Deduplicater)iterator.next()).getLocalDuplicates(mediaitem);
            if (list != null && !list.isEmpty())
            {
                return list;
            }
        }

        return Collections.emptyList();
    }

    public void onAccountRegistered()
    {
        for (Iterator iterator = deduplicaters.iterator(); iterator.hasNext(); ((Deduplicater)iterator.next()).onAccountRegistered()) { }
    }
}
