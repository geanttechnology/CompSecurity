// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            BackgroundState

class this._cls0 extends BroadcastReceiver
{

    final BackgroundState this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getAction().equals("android.intent.action.USER_PRESENT"))
        {
            return;
        } else
        {
            BackgroundState.access$000(BackgroundState.this);
            BackgroundState.access$100(BackgroundState.this);
            return;
        }
    }

    I()
    {
        this$0 = BackgroundState.this;
        super();
    }
}
