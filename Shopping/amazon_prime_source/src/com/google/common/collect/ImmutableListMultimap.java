// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableMultimap, ListMultimap, Multimap, ImmutableMap, 
//            ImmutableList, EmptyImmutableListMultimap, ImmutableCollection

public class ImmutableListMultimap extends ImmutableMultimap
    implements ListMultimap
{
    public static final class Builder extends ImmutableMultimap.Builder
    {

        public ImmutableListMultimap build()
        {
            return (ImmutableListMultimap)super.build();
        }

        public volatile ImmutableMultimap build()
        {
            return build();
        }

        public Builder put(Object obj, Object obj1)
        {
            super.put(obj, obj1);
            return this;
        }

        public volatile ImmutableMultimap.Builder put(Object obj, Object obj1)
        {
            return put(obj, obj1);
        }

        public Builder()
        {
        }
    }


    ImmutableListMultimap(ImmutableMap immutablemap, int i)
    {
        super(immutablemap, i);
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static ImmutableListMultimap copyOf(Multimap multimap)
    {
        if (!multimap.isEmpty()) goto _L2; else goto _L1
_L1:
        ImmutableListMultimap immutablelistmultimap = of();
_L4:
        return immutablelistmultimap;
_L2:
        ImmutableListMultimap immutablelistmultimap1;
        if (!(multimap instanceof ImmutableListMultimap))
        {
            break; /* Loop/switch isn't completed */
        }
        immutablelistmultimap1 = (ImmutableListMultimap)multimap;
        immutablelistmultimap = immutablelistmultimap1;
        if (!immutablelistmultimap1.isPartialView()) goto _L4; else goto _L3
_L3:
        ImmutableMap.Builder builder1 = ImmutableMap.builder();
        multimap = multimap.asMap().entrySet().iterator();
        int i = 0;
        do
        {
            if (!multimap.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)multimap.next();
            ImmutableList immutablelist = ImmutableList.copyOf((Collection)entry.getValue());
            if (!immutablelist.isEmpty())
            {
                builder1.put(entry.getKey(), immutablelist);
                i = immutablelist.size() + i;
            }
        } while (true);
        return new ImmutableListMultimap(builder1.build(), i);
    }

    public static ImmutableListMultimap of()
    {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static ImmutableListMultimap of(Object obj, Object obj1)
    {
        Builder builder1 = builder();
        builder1.put(obj, obj1);
        return builder1.build();
    }

    public volatile ImmutableCollection get(Object obj)
    {
        return get(obj);
    }

    public ImmutableList get(Object obj)
    {
        ImmutableList immutablelist = (ImmutableList)map.get(obj);
        obj = immutablelist;
        if (immutablelist == null)
        {
            obj = ImmutableList.of();
        }
        return ((ImmutableList) (obj));
    }

    public volatile Collection get(Object obj)
    {
        return get(obj);
    }
}
