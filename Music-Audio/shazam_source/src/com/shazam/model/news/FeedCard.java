// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import com.shazam.model.Actions;
import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.shazam.model.news:
//            FeedCardType

public abstract class FeedCard
{

    private Actions actions;
    private Map beaconData;
    private String classType;
    public String id;
    public long timestamp;

    protected FeedCard()
    {
    }

    protected FeedCard(long l, Actions actions1, String s, Map map)
    {
        timestamp = l;
        actions = actions1;
        id = s;
        beaconData = map;
        classType = getClass().getName();
    }

    public abstract FeedCardType a();

    public final Actions c()
    {
        if (actions != null)
        {
            return actions;
        } else
        {
            return com.shazam.model.Actions.Builder.a().b();
        }
    }

    public final Map d()
    {
        if (beaconData == null)
        {
            return Collections.emptyMap();
        } else
        {
            return beaconData;
        }
    }
}
