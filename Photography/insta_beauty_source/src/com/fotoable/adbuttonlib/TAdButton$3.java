// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdButton

class this._cls0 extends Handler
{

    final TAdButton this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            TAdButton.access$500(TAdButton.this);
            break;
        }
    }

    ()
    {
        this$0 = TAdButton.this;
        super();
    }
}
