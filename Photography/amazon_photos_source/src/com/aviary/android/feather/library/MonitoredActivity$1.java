// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library;

import com.aviary.android.feather.receipt.ReceiptManager;

// Referenced classes of package com.aviary.android.feather.library:
//            MonitoredActivity

class this._cls0
    implements Runnable
{

    final MonitoredActivity this$0;

    public void run()
    {
        MonitoredActivity.access$000(MonitoredActivity.this);
        MonitoredActivity.access$100(MonitoredActivity.this);
        ReceiptManager receiptmanager = ReceiptManager.getInstance(getApplicationContext());
        receiptmanager.open();
        receiptmanager.upload();
    }

    ()
    {
        this$0 = MonitoredActivity.this;
        super();
    }
}
