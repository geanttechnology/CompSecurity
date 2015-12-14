// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.parse:
//            PushConnection, Parse

class this._cls1 extends BroadcastReceiver
{

    final this._cls1 this$1;

    public void onReceive(Context context, Intent intent)
    {
        long l = SystemClock.elapsedRealtime() - PushConnection.access$1100(_fld0).get();
        if (l > PushConnection.KEEP_ALIVE_ACK_INTERVAL * 2L)
        {
            Parse.logV("com.parse.PushConnection", (new StringBuilder()).append("Keep alive failure: last read was ").append(l).append(" ms ago.").toString());
            cess._mth1200(this._cls1.this);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
