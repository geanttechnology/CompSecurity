// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.MuteUtil;

// Referenced classes of package co.vine.android:
//            ConversationFragment, ConversationAdapter

class > extends BroadcastReceiver
{

    final ConversationFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent == null || intent.getAction() == null)
        {
            CrashUtil.log("Something wrong has happened");
            return;
        } else
        {
            boolean flag = intent.getAction().equals(MuteUtil.ACTION_CHANGED_TO_MUTE);
            ((ConversationAdapter)mCursorAdapter).toggleMute(flag);
            return;
        }
    }

    ()
    {
        this$0 = ConversationFragment.this;
        super();
    }
}
