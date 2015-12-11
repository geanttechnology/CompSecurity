// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicResource, DibicProgram

public class NullDibicResource
    implements DibicResource
{

    public NullDibicResource()
    {
    }

    public Map getGenreMapForNetwork(Network network)
    {
        return Collections.emptyMap();
    }

    public DibicProgram getProgramByMerlinId(MerlinId merlinid)
    {
        return null;
    }

    public List getPrograms()
    {
        return Collections.emptyList();
    }

    public List getProgramsMatchingGenreAndNetwork(OrderedTag orderedtag, Network network)
    {
        return Collections.emptyList();
    }

    public Map getProgramsMatchingGenresAndNetwork(List list, Network network)
    {
        return Collections.emptyMap();
    }

    public List getProgramsMatchingTitleFilter(String s)
    {
        return Collections.emptyList();
    }
}
