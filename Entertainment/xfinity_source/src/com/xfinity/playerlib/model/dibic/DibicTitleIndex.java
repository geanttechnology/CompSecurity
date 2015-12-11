// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.comcast.cim.utils.NonAsciiRemover;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicProgram

public class DibicTitleIndex
{

    private final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/dibic/DibicTitleIndex);
    private final NonAsciiRemover nonAsciiRemover = new NonAsciiRemover();
    private final List programs;
    private final SortedMap titleIndex;

    public DibicTitleIndex(List list)
    {
        programs = Collections.unmodifiableList(list);
        titleIndex = buildIndex(list);
    }

    private SortedMap buildIndex(List list)
    {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        java.util.TreeMap treemap = Maps.newTreeMap();
        HashMap hashmap = new HashMap();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            DibicProgram dibicprogram = (DibicProgram)iterator.next();
            Iterator iterator1 = dibicprogram.getTitleWords().iterator();
            while (iterator1.hasNext()) 
            {
                Object obj1 = (String)iterator1.next();
                if (!((String) (obj1)).equals(" "))
                {
                    Object obj = (String)hashmap.get(obj1);
                    list = ((List) (obj));
                    if (obj == null)
                    {
                        list = nonAsciiRemover.convertNonAscii(((String) (obj1)).toLowerCase(Locale.US));
                        hashmap.put(obj1, list);
                    }
                    obj1 = (Set)treemap.get(list);
                    obj = obj1;
                    if (obj1 == null)
                    {
                        obj = Sets.newHashSet();
                        treemap.put(list, obj);
                    }
                    ((Set) (obj)).add(dibicprogram);
                }
            }
        }

        stopwatch.stop();
        LOG.debug("Built index in {}", stopwatch);
        return Collections.unmodifiableSortedMap(treemap);
    }

    public SortedMap filterPrefix(SortedMap sortedmap, String s)
    {
        SortedMap sortedmap1 = sortedmap;
        if (s.length() > 0)
        {
            char c = (char)(s.charAt(s.length() - 1) + 1);
            sortedmap1 = sortedmap.subMap(s, (new StringBuilder()).append(s.substring(0, s.length() - 1)).append(c).toString());
        }
        return sortedmap1;
    }

    public List getSublistMatchingTitleQuery(String s)
    {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        String as[] = StringUtils.split(s);
        Object obj1 = Sets.newLinkedHashSet();
        Object obj = new HashSet(programs);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            Object obj2 = as[i].toLowerCase(Locale.US);
            obj1 = Sets.newLinkedHashSet();
            for (obj2 = filterPrefix(titleIndex, ((String) (obj2))).values().iterator(); ((Iterator) (obj2)).hasNext(); ((Set) (obj1)).addAll((Set)((Iterator) (obj2)).next())) { }
            obj1 = Sets.intersection(((Set) (obj1)), ((Set) (obj)));
            obj = obj1;
        }

        stopwatch.stop();
        LOG.debug("Search performed for {} in {}", s, stopwatch);
        return Lists.newArrayList(((Iterable) (obj1)));
    }
}
