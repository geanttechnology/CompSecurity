// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.nautilus.domain.content.dm.SymbanDataManager;

// Referenced classes of package com.ebay.mobile.notifications:
//            PollService

class taManager
    implements Runnable
{

    final PollService this$0;
    final SymbanDataManager val$symbanDataManager;

    public void run()
    {
        val$symbanDataManager.reloadCount();
    }

    taManager()
    {
        this$0 = final_pollservice;
        val$symbanDataManager = SymbanDataManager.this;
        super();
    }
}
