// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import android.os.Handler;
import android.os.Message;
import com.samsung.rest.Response;

// Referenced classes of package com.gotv.crackle.smarttv:
//            SmartTVConnection

private class <init> extends Handler
{

    final SmartTVConnection this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        case 4: // '\004'
        default:
            return;

        case 3: // '\003'
            SmartTVConnection.access$200(SmartTVConnection.this, (Response)message.obj);
            return;

        case 1: // '\001'
            SmartTVConnection.access$300(SmartTVConnection.this, (Response)message.obj);
            return;

        case 2: // '\002'
            SmartTVConnection.access$400(SmartTVConnection.this, (Response)message.obj);
            return;

        case 5: // '\005'
            SmartTVConnection.access$500(SmartTVConnection.this, (Response)message.obj);
            break;
        }
    }

    private ()
    {
        this$0 = SmartTVConnection.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
