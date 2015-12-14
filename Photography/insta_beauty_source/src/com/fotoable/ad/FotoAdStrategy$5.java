// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.fotoable.ad:
//            FotoAdStrategy

final class  extends Handler
{

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            boolean _tmp = FotoAdStrategy.access$402(false);
            break;
        }
        FotoAdStrategy.cancelTimer();
    }

    ()
    {
    }
}
