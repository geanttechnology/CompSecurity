// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.fotoable.ad:
//            ApplicationState

class this._cls0 extends Handler
{

    final ApplicationState this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            ApplicationState.access$000(ApplicationState.this);
            break;
        }
    }

    ()
    {
        this$0 = ApplicationState.this;
        super();
    }
}
