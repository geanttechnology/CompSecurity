// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.rtm.RtmHelper;
import java.util.List;

// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager

public static final class rtmRequestContext
{

    public RtmHelper rtmHelper;
    public List rtmRequestContext;

    public (RtmHelper rtmhelper)
    {
        rtmHelper = rtmhelper;
    }

    public rtmHelper(List list)
    {
        rtmRequestContext = list;
    }
}
