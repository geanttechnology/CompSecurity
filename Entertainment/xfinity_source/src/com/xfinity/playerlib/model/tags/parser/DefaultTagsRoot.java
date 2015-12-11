// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags.parser;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.tags.parser:
//            TagsRoot

public final class DefaultTagsRoot
    implements TagsRoot
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/tags/parser/DefaultTagsRoot);
    private final Map allPublicGenresMap;
    private final String client;
    private final Map companyIdMap;
    private final List networks;
    private final List publicMovieGenres;
    private final List publicTvGenres;

    public DefaultTagsRoot(String s, List list, List list1, List list2)
    {
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        list = list1;
        if (list1 == null)
        {
            list = new ArrayList();
        }
        list1 = list2;
        if (list2 == null)
        {
            list1 = new ArrayList();
        }
        Collections.sort(((List) (obj)));
        Collections.sort(list);
        Collections.sort(list1);
        list2 = Maps.newHashMap();
        java.util.HashMap hashmap = Maps.newHashMap();
        Network network;
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); hashmap.put(network.getName(), network))
        {
            network = (Network)iterator.next();
            list2.put(Long.valueOf(network.getCompanyId()), network);
        }

        companyIdMap = Collections.unmodifiableMap(list2);
        client = s;
        networks = Collections.unmodifiableList(((List) (obj)));
        publicMovieGenres = Collections.unmodifiableList(list);
        publicTvGenres = Collections.unmodifiableList(list1);
        s = Maps.newHashMap();
        for (list1 = list1.iterator(); list1.hasNext(); s.put(list2.getId(), list2))
        {
            list2 = (OrderedTag)list1.next();
        }

        for (list = list.iterator(); list.hasNext(); s.put(list1.getId(), list1))
        {
            list1 = (OrderedTag)list.next();
        }

        allPublicGenresMap = Collections.unmodifiableMap(s);
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (DefaultTagsRoot)obj;
            if (client == null ? ((DefaultTagsRoot) (obj)).client != null : !client.equals(((DefaultTagsRoot) (obj)).client))
            {
                return false;
            }
            if (networks == null ? ((DefaultTagsRoot) (obj)).networks != null : !networks.equals(((DefaultTagsRoot) (obj)).networks))
            {
                return false;
            }
            if (publicMovieGenres == null ? ((DefaultTagsRoot) (obj)).publicMovieGenres != null : !publicMovieGenres.equals(((DefaultTagsRoot) (obj)).publicMovieGenres))
            {
                return false;
            }
            if (publicTvGenres == null ? ((DefaultTagsRoot) (obj)).publicTvGenres != null : !publicTvGenres.equals(((DefaultTagsRoot) (obj)).publicTvGenres))
            {
                return false;
            }
        }
        return true;
    }

    public Set getAllPublicGenres()
    {
        HashSet hashset = Sets.newHashSet();
        for (Iterator iterator = allPublicGenresMap.values().iterator(); iterator.hasNext(); hashset.add((OrderedTag)iterator.next())) { }
        return hashset;
    }

    public String getClient()
    {
        return client;
    }

    public OrderedTag getGenreById(String s)
    {
        return (OrderedTag)allPublicGenresMap.get(s);
    }

    public Network getNetworkByCompanyId(long l)
    {
        Network network = (Network)companyIdMap.get(Long.valueOf(l));
        if (network == null)
        {
            LOG.warn("No network found in map for id {}", Long.valueOf(l));
        }
        return network;
    }

    public List getNetworks()
    {
        return networks;
    }

    public Set getNetworksByCompanyIds(List list)
    {
        HashSet hashset = new HashSet();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Network network = getNetworkByCompanyId(((Long)list.next()).longValue());
            if (network != null)
            {
                hashset.add(network);
            }
        } while (true);
        return hashset;
    }

    public List getPublicMovieGenres()
    {
        return publicMovieGenres;
    }

    public List getPublicTvGenres()
    {
        return publicTvGenres;
    }

    public final int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (client != null)
        {
            i = client.hashCode();
        } else
        {
            i = 0;
        }
        if (networks != null)
        {
            j = networks.hashCode();
        } else
        {
            j = 0;
        }
        if (publicMovieGenres != null)
        {
            k = publicMovieGenres.hashCode();
        } else
        {
            k = 0;
        }
        if (publicTvGenres != null)
        {
            l = publicTvGenres.hashCode();
        }
        return ((i * 31 + j) * 31 + k) * 31 + l;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append(client).append(networks).append(publicMovieGenres).append(publicTvGenres).toString();
    }

}
