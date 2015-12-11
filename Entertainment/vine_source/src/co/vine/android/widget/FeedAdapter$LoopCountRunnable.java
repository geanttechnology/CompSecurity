// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import co.vine.android.util.LoopManager;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.widget:
//            FeedAdapter

private class postId
    implements Runnable
{

    public final int lastCurrentPlaying;
    public final long postId;
    final FeedAdapter this$0;

    public void run()
    {
        if (FeedAdapter.access$000(FeedAdapter.this) == lastCurrentPlaying)
        {
            SLog.d("incrementing loops for currentPlaying={},  postId={}", Integer.valueOf(lastCurrentPlaying), Long.valueOf(postId));
            LoopManager.get(mContext).increment(postId);
        }
    }

    public (int i, long l)
    {
        this$0 = FeedAdapter.this;
        super();
        lastCurrentPlaying = i;
        postId = l;
    }
}
