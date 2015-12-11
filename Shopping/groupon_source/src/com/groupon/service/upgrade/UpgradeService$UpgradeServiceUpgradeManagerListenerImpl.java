// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.upgrade;

import com.groupon.service.upgrade.listener.UpgradeManagerListener;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.groupon.service.upgrade:
//            UpgradeService

private class <init>
    implements UpgradeManagerListener
{

    final UpgradeService this$0;

    public void onUpgradeSuccess()
    {
        UpgradeService.access$100(UpgradeService.this).countDown();
    }

    private Y()
    {
        this$0 = UpgradeService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
