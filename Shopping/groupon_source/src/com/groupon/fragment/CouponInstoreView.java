// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;

// Referenced classes of package com.groupon.fragment:
//            CouponInstoreOnlineView

public class CouponInstoreView extends CouponInstoreOnlineView
{

    public CouponInstoreView()
    {
    }

    public CouponInstoreView(String s, Channel channel, com.groupon.v3.view.list_view.CouponListItemType.ListItemType listitemtype, String s1, String s2)
    {
        super(s, channel, com/groupon/fragment/CouponInstoreView.getSimpleName(), listitemtype, s1, s2);
    }

    public com.groupon.activity.CouponInstoreOnlinePage.PageType getPageType()
    {
        return com.groupon.activity.CouponInstoreOnlinePage.PageType.INSTORE;
    }
}
