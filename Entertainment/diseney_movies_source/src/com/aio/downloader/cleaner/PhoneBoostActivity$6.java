// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import com.wjj.manager.BoostRuningAppManager;

// Referenced classes of package com.aio.downloader.cleaner:
//            PhoneBoostActivity

class this._cls0 extends Thread
{

    final PhoneBoostActivity this$0;

    public void run()
    {
        PhoneBoostActivity.access$22(PhoneBoostActivity.this, PhoneBoostActivity.access$20(PhoneBoostActivity.this).getRuningUserApp(PhoneBoostActivity.access$21(PhoneBoostActivity.this)));
        PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(0);
        super.run();
    }

    ()
    {
        this$0 = PhoneBoostActivity.this;
        super();
    }
}
