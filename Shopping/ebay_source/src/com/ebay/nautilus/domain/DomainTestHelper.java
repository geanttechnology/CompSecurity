// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

public class DomainTestHelper
{

    public DomainTestHelper()
    {
    }

    public void after()
    {
        DeviceConfiguration.TEST_setDcsTestHook(false);
        DataManager.TEST_resetAllForTestCase();
    }

    public void before()
    {
        DeviceConfiguration.TEST_setDcsTestHook(true);
        DataManager.TEST_resetAllForTestCase();
    }
}
