// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.monitor;


// Referenced classes of package com.penthera.virtuososdk.monitor:
//            BatteryMonitor

public static interface 
{

    public abstract void onBatteryLevelChanged(int i);

    public abstract void onPowerConnected();

    public abstract void onPowerDisconnected();
}
