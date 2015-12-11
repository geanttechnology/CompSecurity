// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.rtm.RtmHelper;
import java.util.List;

// Referenced classes of package com.ebay.common.content.dm:
//            AdRtmDataManager

public static interface Type
{

    public abstract void onAdsContextReady(List list, Type type);

    public abstract void onAdsReady(RtmHelper rtmhelper, Type type);
}
