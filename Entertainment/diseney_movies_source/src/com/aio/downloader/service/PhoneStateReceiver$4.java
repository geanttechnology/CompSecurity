// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import com.aio.downloader.dialog.CallerOutDialog1;

// Referenced classes of package com.aio.downloader.service:
//            PhoneStateReceiver

class this._cls0
    implements Runnable
{

    final PhoneStateReceiver this$0;

    public void run()
    {
        PhoneStateReceiver.access$3(PhoneStateReceiver.this).show();
    }

    ()
    {
        this$0 = PhoneStateReceiver.this;
        super();
    }
}
