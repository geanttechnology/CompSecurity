// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import co.vine.android.api.VinePost;
import co.vine.android.widget.FeedAdapter;

// Referenced classes of package co.vine.android:
//            BaseTimelineFragment

class > extends BroadcastReceiver
{

    final BaseTimelineFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (intent != null && "co.vine.android.service.mergePostFeed".equals(intent.getAction()))
        {
            context = (VinePost)intent.getExtras().getParcelable("post");
            ((FeedAdapter)mFeedAdapter).mergeMyPost(context);
        }
    }

    ()
    {
        this$0 = BaseTimelineFragment.this;
        super();
    }
}
