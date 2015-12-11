// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.channels;

import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.channels:
//            ChannelObserver, ChannelFragment

public final class ChannelDispatcher
    implements ChannelObserver
{

    private final List references = new ArrayList();

    public ChannelDispatcher()
    {
    }

    public void onCategoryExpansion(ChannelFragment channelfragment, float f)
    {
        Iterator iterator = references.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ChannelObserver channelobserver = (ChannelObserver)iterator.next();
            if (channelobserver != null)
            {
                channelobserver.onCategoryExpansion(channelfragment, f);
            }
        } while (true);
    }

    public void onCategorySelected(ChannelFragment channelfragment, Category category)
    {
        Iterator iterator = references.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ChannelObserver channelobserver = (ChannelObserver)iterator.next();
            if (channelobserver != null)
            {
                channelobserver.onCategorySelected(channelfragment, category);
            }
        } while (true);
    }

    public void onContentLoaded(ChannelFragment channelfragment)
    {
        Iterator iterator = references.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ChannelObserver channelobserver = (ChannelObserver)iterator.next();
            if (channelobserver != null)
            {
                channelobserver.onContentLoaded(channelfragment);
            }
        } while (true);
    }

    public void onScrollChanged(ChannelFragment channelfragment, int i, int j)
    {
        Iterator iterator = references.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ChannelObserver channelobserver = (ChannelObserver)iterator.next();
            if (channelobserver != null)
            {
                channelobserver.onScrollChanged(channelfragment, i, j);
            }
        } while (true);
    }

    public void register(ChannelObserver channelobserver)
    {
        if (references.contains(channelobserver))
        {
            return;
        } else
        {
            references.add(channelobserver);
            return;
        }
    }

    public void unregister(ChannelObserver channelobserver)
    {
        if (references.contains(channelobserver))
        {
            references.remove(channelobserver);
        }
    }

    public void unregisterAll()
    {
        references.clear();
    }
}
