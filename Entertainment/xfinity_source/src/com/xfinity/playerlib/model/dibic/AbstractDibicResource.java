// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicResource

public abstract class AbstractDibicResource
    implements DibicResource
{

    public AbstractDibicResource()
    {
    }

    public List getProgramsMatchingGenreAndNetwork(OrderedTag orderedtag, Network network)
    {
        network = (List)getProgramsMatchingGenresAndNetwork(Lists.newArrayList(new OrderedTag[] {
            orderedtag
        }), network).get(orderedtag);
        orderedtag = network;
        if (network == null)
        {
            orderedtag = new ArrayList();
        }
        return orderedtag;
    }
}
