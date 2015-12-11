// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdController, DeviceInfo

class this._cls0
    implements Runnable
{

    final AdController this$0;

    public void run()
    {
        if (DeviceInfo.getUserAgentString() == null)
        {
            AdController.access$000(AdController.this);
        }
    }

    ()
    {
        this$0 = AdController.this;
        super();
    }
}
