// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.hal;

import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.consumable.hal.HalVideo;
import java.util.List;

// Referenced classes of package com.comcast.cim.model.hal:
//            HalVideoFilter

public class NetworkMatchingHalVideoFilter extends HalVideoFilter
{

    private final List matchingNetworkIds;

    protected boolean matches(HalVideo halvideo)
    {
        return matchingNetworkIds.contains(Long.valueOf(halvideo.getProvider().getCompanyId()));
    }
}
