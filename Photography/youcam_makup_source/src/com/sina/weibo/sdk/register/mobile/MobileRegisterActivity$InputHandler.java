// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            MobileRegisterActivity

class <init> extends Handler
{

    final MobileRegisterActivity this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            MobileRegisterActivity.access$5(MobileRegisterActivity.this).setVisibility(0);
            MobileRegisterActivity.access$6(MobileRegisterActivity.this).setVisibility(0);
            return;

        case 1: // '\001'
            MobileRegisterActivity.access$5(MobileRegisterActivity.this).setVisibility(8);
            break;
        }
        MobileRegisterActivity.access$6(MobileRegisterActivity.this).setVisibility(8);
    }

    private ()
    {
        this$0 = MobileRegisterActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
