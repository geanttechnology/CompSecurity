// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.adapters.profile.FollowerAdapter;
import my.googlemusic.play.internet.Response;

// Referenced classes of package my.googlemusic.play.activities:
//            FollowerActivity

class val.idUserFriend
    implements my.googlemusic.play.interfaces.val.idUserFriend
{

    final FollowerActivity this$0;
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
            FollowerActivity.access$200(FollowerActivity.this).setFollowing(val$idUserFriend);
            FollowerActivity.access$200(FollowerActivity.this).notifyDataSetChanged();
        }
    }

    er()
    {
        this$0 = final_followeractivity;
        val$idUserFriend = J.this;
        super();
    }
}
