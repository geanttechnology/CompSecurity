// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.Comparator;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            MediaStoreHelperImpl

static final class 
    implements Comparator
{

    public int compare(MediaItem mediaitem, MediaItem mediaitem1)
    {
        return (int)(mediaitem.getDateModifiedMs() - mediaitem1.getDateModifiedMs());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((MediaItem)obj, (MediaItem)obj1);
    }

    ()
    {
    }
}
