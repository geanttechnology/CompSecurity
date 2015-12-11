// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.upgrade;

import com.amazon.mShop.util.UpgradeUtil;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.UpgradeInfo;

// Referenced classes of package com.amazon.mShop.upgrade:
//            UpgradeSubscriber

public class UpgradeSubscriberAdapter
    implements UpgradeSubscriber
{

    public UpgradeSubscriberAdapter()
    {
    }

    public boolean awareUniqueId()
    {
        return true;
    }

    public void onCompeleted(UpgradeInfo upgradeinfo)
    {
        if (UpgradeUtil.isNewUpgrade(upgradeinfo, awareUniqueId()))
        {
            UpgradeUtil.saveNewUpgradeInfo(upgradeinfo);
            onUpgradeAvailable(upgradeinfo);
            return;
        } else
        {
            UpgradeUtil.clearNewUpgradeInfo();
            onNoUpgrade();
            return;
        }
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
    }

    public void onNoUpgrade()
    {
    }

    public void onUpgradeAvailable(UpgradeInfo upgradeinfo)
    {
    }
}
