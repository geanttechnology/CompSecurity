// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.List;

// Referenced classes of package com.targetspot.android.sdk.service:
//            LoggingManager, AdBreak, AdLink, AdSegment

class this._cls1 extends Handler
{

    final  this$1;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 8: default 56
    //                   0 57
    //                   1 112
    //                   2 166
    //                   3 246
    //                   4 272
    //                   5 291
    //                   6 192
    //                   7 138
    //                   8 218;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        return;
_L2:
        Log.d("LoggingManager", "Started (MSG_START)");
        loadLogInfo();
        if (LoggingManager.access$100(_fld0).size() > 0)
        {
            LoggingManager.access$000(_fld0).sendEmptyMessageDelayed(4, 0xdbba0L);
            return;
        }
          goto _L1
_L3:
        Log.d("LoggingManager", "Adding impression(s) (MSG_ADD)");
        storeImpression((AdBreak)message.obj);
        return;
_L9:
        Log.d("LoggingManager", "Adding impression(s) (MSG_ADD_START)");
        storeImpression((AdBreak)message.obj, "start");
        return;
_L4:
        Log.d("LoggingManager", "Adding impression url (MSG_ADD_LINK)");
        storeImpression((AdLink)message.obj);
        return;
_L8:
        Log.d("LoggingManager", "Adding impression (MSG_ADD_SEGMENT)");
        storeImpression((AdSegment)message.obj);
        return;
_L10:
        Log.d("LoggingManager", "Adding impression (MSG_ADD_SEGMENT_START)");
        storeImpression((AdSegment)message.obj, "start");
        return;
_L5:
        Log.d("LoggingManager", "Adding unfilled (MSG_ADD_UNFILLED)");
        storeUnfilled(()message.obj);
        return;
_L6:
        Log.d("LoggingManager", "Check for network & send (MSG_SEND)");
        sendLogInfo();
        return;
_L7:
        Log.d("LoggingManager", "Thread exit (MSG_QUIT)");
        Looper.myLooper().quit();
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
