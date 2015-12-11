// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            AbstractDibicResource, DibicTitleIndex, DibicProgram

public class DefaultDibicResource extends AbstractDibicResource
{
    private class ProcessedItems
    {

        Set adultGenres;
        Map adultMerlinIdMap;
        Map adultNetworkGenreMaps;
        Map merlinIdMap;
        Map networkGenreMaps;
        List nonAdultPrograms;
        final DefaultDibicResource this$0;

        private ProcessedItems()
        {
            this$0 = DefaultDibicResource.this;
            super();
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/dibic/DefaultDibicResource);
    private final List allPrograms;
    private final ProcessedItems processedItems;
    private final DibicTitleIndex titleIndex;
    private final PlayNowUserManager userManager;

    public DefaultDibicResource(List list, TagsRoot tagsroot, PlayNowUserManager playnowusermanager)
    {
        userManager = playnowusermanager;
        allPrograms = Collections.unmodifiableList(list);
        processedItems = processPrograms(list, tagsroot);
        titleIndex = new DibicTitleIndex(processedItems.nonAdultPrograms);
    }

    private void addOrUpdate(Map map, Network network, String s, DibicProgram dibicprogram)
    {
        Object obj = (Map)map.get(network);
        if (obj == null)
        {
            obj = new ArrayList();
            ((List) (obj)).add(dibicprogram);
            dibicprogram = new HashMap();
            dibicprogram.put(s, obj);
            map.put(network, dibicprogram);
            return;
        }
        map = (List)((Map) (obj)).get(s);
        if (map == null)
        {
            map = new ArrayList();
            map.add(dibicprogram);
            ((Map) (obj)).put(s, map);
            return;
        } else
        {
            map.add(dibicprogram);
            return;
        }
    }

    private boolean isAdultContentEnabledInSettings()
    {
        boolean flag;
        try
        {
            flag = ((PlayerUserSettings)userManager.getUserSettings()).getWantsAdultContent();
        }
        catch (Exception exception)
        {
            LOG.error("Cannot check settings for the wants adult content flag", exception);
            return false;
        }
        return flag;
    }

    private ProcessedItems processPrograms(List list, TagsRoot tagsroot)
    {
        ProcessedItems processeditems = new ProcessedItems();
        ArrayList arraylist = Lists.newArrayList();
        HashSet hashset = new HashSet();
        HashMap hashmap = Maps.newHashMap();
        HashMap hashmap1 = Maps.newHashMap();
        HashMap hashmap2 = Maps.newHashMap();
        HashMap hashmap3 = Maps.newHashMap();
        HashSet hashset1 = new HashSet();
        for (Iterator iterator = tagsroot.getPublicMovieGenres().iterator(); iterator.hasNext(); hashset1.add(((OrderedTag)iterator.next()).getId())) { }
        for (tagsroot = tagsroot.getPublicTvGenres().iterator(); tagsroot.hasNext(); hashset1.add(((OrderedTag)tagsroot.next()).getId())) { }
        for (list = list.iterator(); list.hasNext();)
        {
            tagsroot = (DibicProgram)list.next();
            boolean flag = tagsroot.isMovie();
            if (!tagsroot.isAdult())
            {
                arraylist.add(tagsroot);
                hashmap.put(tagsroot.getMerlinId(), tagsroot);
            }
            Iterator iterator1 = tagsroot.getNetworks().iterator();
            while (iterator1.hasNext()) 
            {
                Network network = (Network)iterator1.next();
                if (tagsroot.isAdult())
                {
                    if (network.isPremium())
                    {
                        Iterator iterator2 = tagsroot.getGenreIds().iterator();
                        while (iterator2.hasNext()) 
                        {
                            String s = (String)iterator2.next();
                            addOrUpdate(hashmap3, network, s, tagsroot);
                            hashmap1.put(tagsroot.getMerlinId(), tagsroot);
                            if (!hashset1.contains(s))
                            {
                                hashset.add(s);
                            }
                        }
                    }
                } else
                {
                    if (network.isPremium())
                    {
                        String s1;
                        for (Iterator iterator3 = tagsroot.getGenreIds().iterator(); iterator3.hasNext(); addOrUpdate(hashmap3, network, s1, tagsroot))
                        {
                            s1 = (String)iterator3.next();
                            addOrUpdate(hashmap2, network, s1, tagsroot);
                        }

                    }
                    if ((network.getCategories().size() == 0 || network.hasAllMoviesCategory()) && flag)
                    {
                        addOrUpdate(hashmap2, network, OrderedTag.ALL_MOVIES.getId(), tagsroot);
                        addOrUpdate(hashmap3, network, OrderedTag.ALL_MOVIES.getId(), tagsroot);
                    } else
                    if ((network.getCategories().size() == 0 || network.hasAllTvCategory()) && !flag)
                    {
                        addOrUpdate(hashmap2, network, OrderedTag.ALL_TV.getId(), tagsroot);
                        addOrUpdate(hashmap3, network, OrderedTag.ALL_TV.getId(), tagsroot);
                    }
                }
            }
        }

        processeditems.adultGenres = Collections.unmodifiableSet(hashset);
        processeditems.nonAdultPrograms = Collections.unmodifiableList(arraylist);
        processeditems.merlinIdMap = Collections.unmodifiableMap(hashmap);
        processeditems.adultMerlinIdMap = Collections.unmodifiableMap(hashmap1);
        processeditems.networkGenreMaps = Collections.unmodifiableMap(hashmap2);
        processeditems.adultNetworkGenreMaps = Collections.unmodifiableMap(hashmap3);
        return processeditems;
    }

    public Map getGenreMapForNetwork(Network network)
    {
        Object obj;
        if (isAdultContentEnabledInSettings())
        {
            network = (Map)processedItems.adultNetworkGenreMaps.get(network);
        } else
        {
            network = (Map)processedItems.networkGenreMaps.get(network);
        }
        obj = network;
        if (network == null)
        {
            obj = new HashMap();
        }
        return ((Map) (obj));
    }

    public DibicProgram getProgramByMerlinId(MerlinId merlinid)
    {
        DibicProgram dibicprogram1 = (DibicProgram)processedItems.merlinIdMap.get(merlinid);
        DibicProgram dibicprogram = dibicprogram1;
        if (dibicprogram1 == null)
        {
            dibicprogram = dibicprogram1;
            if (isAdultContentEnabledInSettings())
            {
                dibicprogram = (DibicProgram)processedItems.adultMerlinIdMap.get(merlinid);
            }
        }
        return dibicprogram;
    }

    public List getPrograms()
    {
        return processedItems.nonAdultPrograms;
    }

    public Map getProgramsMatchingGenresAndNetwork(List list, Network network)
    {
        TreeMap treemap = new TreeMap();
        if (list != null && list.size() != 0) goto _L2; else goto _L1
_L1:
        list = getProgramsMatchingNetwork(network);
        if (list == null || list.size() <= 0) goto _L4; else goto _L3
_L3:
        if (!((DibicProgram)list.get(0)).isMovie()) goto _L6; else goto _L5
_L5:
        treemap.put(OrderedTag.ALL_MOVIES, list);
_L4:
        return treemap;
_L6:
        treemap.put(OrderedTag.ALL_TV, list);
        return treemap;
_L2:
        boolean flag1 = false;
        Iterator iterator = list.iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            OrderedTag orderedtag1 = (OrderedTag)iterator.next();
            if (!processedItems.adultGenres.contains(orderedtag1.getId()))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        if (flag)
        {
            network = getGenreMapForNetwork(network);
        } else
        {
            network = (Map)processedItems.networkGenreMaps.get(network);
        }
        if (network != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                OrderedTag orderedtag = (OrderedTag)list.next();
                List list1 = (List)network.get(orderedtag.getId());
                if (list1 != null)
                {
                    treemap.put(orderedtag, list1);
                }
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public List getProgramsMatchingNetwork(Network network)
    {
        Validate.notNull(network);
        ArrayList arraylist = new ArrayList();
        Iterator iterator = processedItems.nonAdultPrograms.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DibicProgram dibicprogram = (DibicProgram)iterator.next();
            if (dibicprogram.getNetworks().contains(network))
            {
                arraylist.add(dibicprogram);
            }
        } while (true);
        return arraylist;
    }

    public List getProgramsMatchingTitleFilter(String s)
    {
        return titleIndex.getSublistMatchingTitleQuery(s);
    }

}
