// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            AbstractDibicResource, DibicResource, DibicProgram

public class CompositeDibicResource extends AbstractDibicResource
{

    private final Set resources;

    public CompositeDibicResource(Set set)
    {
        resources = set;
    }

    public Map getGenreMapForNetwork(Network network)
    {
        java.util.TreeMap treemap = Maps.newTreeMap();
        for (Iterator iterator = resources.iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((DibicResource)iterator.next()).getGenreMapForNetwork(network).entrySet().iterator();
            while (iterator1.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                String s = (String)entry.getKey();
                List list = (List)treemap.get(s);
                Object obj = list;
                if (list == null)
                {
                    obj = Lists.newArrayList();
                    treemap.put(s, obj);
                }
                ((List) (obj)).addAll((Collection)entry.getValue());
            }
        }

        return treemap;
    }

    public DibicProgram getProgramByMerlinId(MerlinId merlinid)
    {
        for (Iterator iterator = resources.iterator(); iterator.hasNext();)
        {
            DibicProgram dibicprogram = ((DibicResource)iterator.next()).getProgramByMerlinId(merlinid);
            if (dibicprogram != null)
            {
                return dibicprogram;
            }
        }

        return null;
    }

    public List getPrograms()
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        for (Iterator iterator = resources.iterator(); iterator.hasNext(); arraylist.addAll(((DibicResource)iterator.next()).getPrograms())) { }
        return arraylist;
    }

    public Map getProgramsMatchingGenresAndNetwork(List list, Network network)
    {
        java.util.TreeMap treemap = Maps.newTreeMap();
        for (Iterator iterator = resources.iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((DibicResource)iterator.next()).getProgramsMatchingGenresAndNetwork(list, network).entrySet().iterator();
            while (iterator1.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                OrderedTag orderedtag = (OrderedTag)entry.getKey();
                List list1 = (List)treemap.get(orderedtag);
                Object obj = list1;
                if (list1 == null)
                {
                    obj = Lists.newArrayList();
                    treemap.put(orderedtag, obj);
                }
                ((List) (obj)).addAll((Collection)entry.getValue());
            }
        }

        return treemap;
    }

    public List getProgramsMatchingTitleFilter(String s)
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        for (Iterator iterator = resources.iterator(); iterator.hasNext(); arraylist.addAll(((DibicResource)iterator.next()).getProgramsMatchingTitleFilter(s))) { }
        return arraylist;
    }
}
