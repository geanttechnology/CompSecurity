// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.adapters.profile.FollowingAdapter;
import my.googlemusic.play.internet.Response;

// Referenced classes of package my.googlemusic.play.activities:
//            FollowingActivity

class val.idUserFriend
    implements my.googlemusic.play.interfaces.val.idUserFriend
{

    final FollowingActivity this$0;
    final long val$idUserFriend;

    public void onFailure(Response response)
    {
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if ((obj instanceof String) && obj.equals("Success"))
        {
            FollowingActivity.access$200(FollowingActivity.this).setFollowing(val$idUserFriend);
            FollowingActivity.access$200(FollowingActivity.this).notifyDataSetChanged();
        }
    }

    er()
    {
        this$0 = final_followingactivity;
        val$idUserFriend = J.this;
        super();
    }
}
