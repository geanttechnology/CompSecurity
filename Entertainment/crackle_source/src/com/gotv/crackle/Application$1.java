// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.os.Handler;
import android.os.Message;
import com.gotv.crackle.data.Localization;
import java.util.Date;

// Referenced classes of package com.gotv.crackle:
//            Application

static final class ion extends Handler
{

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 123415 123415: default 24
    //                   123415 30;
           goto _L1 _L2
_L1:
        super.handleMessage(message);
        return;
_L2:
        Application.getInstance().getLocalization().updateCurrentLocationAsync();
        Application.access$002(new Date());
        Message message1 = Message.obtain();
        message1.what = 0x1e217;
        Application.access$100().sendMessageDelayed(message1, 0x1b7740L);
        if (true) goto _L1; else goto _L3
_L3:
    }

    ion()
    {
    }
}
