// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.poshmark.controllers:
//            GlobalPartiesController

class this._cls0 extends Handler
{

    final GlobalPartiesController this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            message = (String)message.obj;
            break;
        }
        GlobalPartiesController.access$100(GlobalPartiesController.this, message);
    }

    ()
    {
        this$0 = GlobalPartiesController.this;
        super();
    }
}
