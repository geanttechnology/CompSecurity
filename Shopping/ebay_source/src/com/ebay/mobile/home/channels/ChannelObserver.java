// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.channels;

import com.ebay.nautilus.domain.data.UnifiedStream.Category;

// Referenced classes of package com.ebay.mobile.home.channels:
//            ChannelFragment

public interface ChannelObserver
{

    public abstract void onCategoryExpansion(ChannelFragment channelfragment, float f);

    public abstract void onCategorySelected(ChannelFragment channelfragment, Category category);

    public abstract void onContentLoaded(ChannelFragment channelfragment);

    public abstract void onScrollChanged(ChannelFragment channelfragment, int i, int j);
}
