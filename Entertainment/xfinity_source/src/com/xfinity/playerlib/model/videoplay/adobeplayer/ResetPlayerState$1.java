// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            ResetPlayerState, VideoStateController

class this._cls0 extends BroadcastReceiver
{

    final ResetPlayerState this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getAction().equals("android.intent.action.USER_PRESENT"))
        {
            return;
        } else
        {
            ResetPlayerState.access$000(ResetPlayerState.this).reset();
            ResetPlayerState.access$100(ResetPlayerState.this);
            return;
        }
    }

    r()
    {
        this$0 = ResetPlayerState.this;
        super();
    }
}
