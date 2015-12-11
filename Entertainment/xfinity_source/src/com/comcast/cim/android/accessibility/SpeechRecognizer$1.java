// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            SpeechRecognizer, TalkDelegate

class this._cls0 extends Handler
{

    final SpeechRecognizer this$0;

    public void handleMessage(Message message)
    {
        if (message.what == 8)
        {
            getTalkDelegate().speak(getString(com.comcast.cim.android.log_timeout));
            finish();
            return;
        }
        if (message.what == 9)
        {
            getTalkDelegate().speak(getString(com.comcast.cim.android.log_timeout_service_unavail));
            finish();
            return;
        } else
        {
            super.handleMessage(message);
            return;
        }
    }

    ()
    {
        this$0 = SpeechRecognizer.this;
        super();
    }
}
