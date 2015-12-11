// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.os.Handler;
import android.os.Message;
import com.aio.downloader.dialog.InstallfirstDialog;
import com.umeng.analytics.MobclickAgent;

// Referenced classes of package com.aio.downloader.service:
//            ServiceGallery

class this._cls0 extends Handler
{

    private String icon0;
    private String icon1;
    private String icon2;
    private String icon3;
    private String icon4;
    private String icon5;
    private String icon6;
    private String icon7;
    final ServiceGallery this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 30: // '\036'
            MobclickAgent.onEvent(getApplicationContext(), "first_insall_cleaner");
            break;
        }
        ServiceGallery.access$0(ServiceGallery.this).show();
    }

    ()
    {
        this$0 = ServiceGallery.this;
        super();
    }
}
