// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.upgrade;

import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.rio.j2me.client.services.mShop.UpgradeInfo;

public interface UpgradeSubscriber
    extends GenericSubscriber
{

    public abstract void onCompeleted(UpgradeInfo upgradeinfo);
}
