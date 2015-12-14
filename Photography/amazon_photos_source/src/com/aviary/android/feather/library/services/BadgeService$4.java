// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;


// Referenced classes of package com.aviary.android.feather.library.services:
//            BadgeService

class y.Tools
    implements Runnable
{

    final BadgeService this$0;
    final ToolBadgesUpdateListener val$l;
    final com.aviary.android.feather.library.filters.ry.Tools val$type;

    public void run()
    {
        val$l.onToolBadgeSingleUpdate(BadgeService.this, val$type);
    }

    y.Tools()
    {
        this$0 = final_badgeservice;
        val$l = toolbadgesupdatelistener;
        val$type = com.aviary.android.feather.library.filters.ry.Tools.this;
        super();
    }
}
