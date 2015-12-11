// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.View;
import co.vine.android.ProfileActivity;
import co.vine.android.api.VinePost;

// Referenced classes of package co.vine.android.widget:
//            FeedAdapter

class val.post
    implements android.view.stener
{

    final FeedAdapter this$0;
    final VinePost val$post;

    public void onClick(View view)
    {
        ProfileActivity.start(mContext, val$post.userId, mFollowEventSource);
    }

    ()
    {
        this$0 = final_feedadapter;
        val$post = VinePost.this;
        super();
    }
}
