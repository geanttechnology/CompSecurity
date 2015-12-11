// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

public static interface num
{

    public transient abstract Channel getChannel(int ai[]);

    public abstract int getChannelIndex(ChannelEnum channelenum);

    public abstract void navigateToChannel(ChannelEnum channelenum, boolean flag, boolean flag1);
}
