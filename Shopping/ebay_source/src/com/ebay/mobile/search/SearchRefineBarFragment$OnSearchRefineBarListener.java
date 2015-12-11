// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;


// Referenced classes of package com.ebay.mobile.search:
//            SearchRefineBarFragment, DetailMode, DetailLaunchMode

public static interface 
{

    public abstract void onFollowSearch( );

    public abstract void onShowRefinement(DetailMode detailmode, DetailLaunchMode detaillaunchmode);

    public abstract void onUnfollowSearch();

    public abstract void onViewSwitched(int i);
}
