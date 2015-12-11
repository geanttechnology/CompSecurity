// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.startup;

import com.groupon.service.upgrade.listener.UpgradeManagerListener;

// Referenced classes of package com.groupon.service.startup:
//            StartupDirector

private class isUpgradeManagerOnly
    implements UpgradeManagerListener
{

    private boolean isUpgradeManagerOnly;
    final StartupDirector this$0;

    public void onUpgradeSuccess()
    {
        StartupDirector.access$400(StartupDirector.this, isUpgradeManagerOnly);
    }

    public (boolean flag)
    {
        this$0 = StartupDirector.this;
        super();
        isUpgradeManagerOnly = flag;
    }
}
