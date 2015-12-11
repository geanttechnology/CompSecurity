// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import android.os.Message;
import com.wjj.eneity.RuningApp;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            PhoneBoostActivity

class this._cls0
    implements com.wjj.manager..BoostRuningAppManagerListener
{

    final PhoneBoostActivity this$0;

    public void DownCountSize(long l, RuningApp runingapp)
    {
        Message message = new Message();
        message.obj = Long.valueOf(l);
        message.what = 1;
        PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendMessage(message);
        message = new Message();
        PhoneBoostActivity.access$1(PhoneBoostActivity.this).add(runingapp);
        message.obj = PhoneBoostActivity.access$1(PhoneBoostActivity.this);
        message.what = 2;
        PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendMessage(message);
        message = new Message();
        message.obj = runingapp;
        message.what = 3;
        PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendMessage(message);
    }

    gAppManagerListener()
    {
        this$0 = PhoneBoostActivity.this;
        super();
    }
}
