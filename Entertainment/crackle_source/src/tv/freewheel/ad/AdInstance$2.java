// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import tv.freewheel.ad.state.AdState;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad:
//            AdInstance

class this._cls0 extends Handler
{

    final AdInstance this$0;

    public void handleMessage(Message message)
    {
        String s = message.getData().getString("CODE");
        message = message.getData().getString("MSG");
        logger.debug((new StringBuilder()).append("renderer load complete code:").append(s).append(" msg:").append(message).toString());
        if (s.equals("ERROR"))
        {
            AdInstance.access$102(AdInstance.this, message);
        }
        state.notifyRendererModuleLoaded(AdInstance.this);
    }

    (Looper looper)
    {
        this$0 = AdInstance.this;
        super(looper);
    }
}
