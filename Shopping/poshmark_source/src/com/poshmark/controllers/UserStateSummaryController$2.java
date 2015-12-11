// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.poshmark.controllers:
//            UserStateSummaryController

class this._cls0 extends Handler
{

    final UserStateSummaryController this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            UserStateSummaryController.access$100(UserStateSummaryController.this);
            break;
        }
        refreshModels();
    }

    ()
    {
        this$0 = UserStateSummaryController.this;
        super();
    }
}
