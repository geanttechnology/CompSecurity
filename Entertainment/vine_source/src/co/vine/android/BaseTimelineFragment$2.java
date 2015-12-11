// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.MuteUtil;
import co.vine.android.widget.GenericTimelineAdapter;

// Referenced classes of package co.vine.android:
//            BaseTimelineFragment

class > extends BroadcastReceiver
{

    final BaseTimelineFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent == null || intent.getAction() == null)
        {
            CrashUtil.log("Something wrong has happened");
            return;
        } else
        {
            boolean flag = intent.getAction().equals(MuteUtil.ACTION_CHANGED_TO_MUTE);
            mFeedAdapter.toggleMute(flag);
            return;
        }
    }

    dapter()
    {
        this$0 = BaseTimelineFragment.this;
        super();
    }
}
