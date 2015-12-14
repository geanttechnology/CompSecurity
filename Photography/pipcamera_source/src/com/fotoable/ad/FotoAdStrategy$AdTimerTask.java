// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

// Referenced classes of package com.fotoable.ad:
//            FotoAdStrategy

class  extends TimerTask
{

    public void run()
    {
        Message message = new Message();
        message.what = 1;
        FotoAdStrategy.handler.sendMessage(message);
    }

    ()
    {
    }
}
