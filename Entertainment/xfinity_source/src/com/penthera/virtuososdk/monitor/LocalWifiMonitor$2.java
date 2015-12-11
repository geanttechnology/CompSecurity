// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.monitor;


// Referenced classes of package com.penthera.virtuososdk.monitor:
//            LocalWifiMonitor

class this._cls0
    implements Runnable
{

    final LocalWifiMonitor this$0;

    public void run()
    {
        boolean flag = LocalWifiMonitor.access$3(LocalWifiMonitor.this, LocalWifiMonitor.access$2());
        if (!flag)
        {
            LocalWifiMonitor.access$4(LocalWifiMonitor.this);
        }
        LocalWifiMonitor.access$5(LocalWifiMonitor.this, flag);
        LocalWifiMonitor.access$6(0);
        LocalWifiMonitor.access$7(false);
    }

    _cls9()
    {
        this$0 = LocalWifiMonitor.this;
        super();
    }
}
