// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DeviceConfigurationManager

class operties
    implements Runnable
{

    final DeviceConfigurationManager this$0;
    final operties val$config;

    public void run()
    {
        DeviceConfigurationManager.access$200(DeviceConfigurationManager.this, val$config);
    }

    operties()
    {
        this$0 = final_deviceconfigurationmanager;
        val$config = operties.this;
        super();
    }
}
