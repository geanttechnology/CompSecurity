// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;


// Referenced classes of package com.groupon.manager.sync_process:
//            CouponResultSyncManagerProcess

static class 
{

    static final int $SwitchMap$com$groupon$activity$CouponInstoreOnlinePage$PageType[];
    static final int $SwitchMap$com$groupon$v3$view$list_view$CouponListItemType$ListItemType[];

    static 
    {
        $SwitchMap$com$groupon$activity$CouponInstoreOnlinePage$PageType = new int[com.groupon.activity.values().length];
        try
        {
            $SwitchMap$com$groupon$activity$CouponInstoreOnlinePage$PageType[com.groupon.activity.INSTORE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$groupon$activity$CouponInstoreOnlinePage$PageType[com.groupon.activity.ONLINE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$groupon$v3$view$list_view$CouponListItemType$ListItemType = new int[com.groupon.v3.view.list_view.alues().length];
        try
        {
            $SwitchMap$com$groupon$v3$view$list_view$CouponListItemType$ListItemType[com.groupon.v3.view.list_view.OUPON_MERCHANT.rdinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$groupon$v3$view$list_view$CouponListItemType$ListItemType[com.groupon.v3.view.list_view.OUPON_CATEGORY.rdinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
