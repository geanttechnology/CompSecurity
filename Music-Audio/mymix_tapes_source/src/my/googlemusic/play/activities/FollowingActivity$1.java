// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import my.googlemusic.play.adapters.profile.FollowingAdapter;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Following;
import my.googlemusic.play.model.User;

// Referenced classes of package my.googlemusic.play.activities:
//            FollowingActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final FollowingActivity this$0;

    public void onFailure(Response response)
    {
        FollowingActivity.access$600(FollowingActivity.this, false);
        FollowingActivity.access$400(FollowingActivity.this).loading.setVisibility(8);
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (!(obj instanceof List)) goto _L2; else goto _L1
_L1:
        FollowingActivity.access$102(FollowingActivity.this, new ArrayList());
        User user;
        for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); FollowingActivity.access$100(FollowingActivity.this).add(new Following(user)))
        {
            user = (User)((Iterator) (obj)).next();
        }

        if (FollowingActivity.access$200(FollowingActivity.this) != null) goto _L4; else goto _L3
_L3:
        FollowingActivity.access$202(FollowingActivity.this, new FollowingAdapter(FollowingActivity.this, FollowingActivity.access$100(FollowingActivity.this), Long.valueOf(FollowingActivity.access$300(FollowingActivity.this).getUser().getId()), FollowingActivity.this, FollowingActivity.access$300(FollowingActivity.this)));
        FollowingActivity.access$400(FollowingActivity.this).list.setAdapter(FollowingActivity.access$200(FollowingActivity.this));
_L6:
        FollowingActivity.access$508(FollowingActivity.this);
_L2:
        if (FollowingActivity.access$100(FollowingActivity.this) != null && FollowingActivity.access$100(FollowingActivity.this).isEmpty())
        {
            FollowingActivity.access$400(FollowingActivity.this).noFriends.setVisibility(0);
            FollowingActivity.access$400(FollowingActivity.this).noFriendsMessage.setVisibility(0);
        }
        mLoading = false;
        FollowingActivity.access$600(FollowingActivity.this, false);
        FollowingActivity.access$400(FollowingActivity.this).loading.setVisibility(8);
        return;
_L4:
        if (!FollowingActivity.access$100(FollowingActivity.this).isEmpty())
        {
            FollowingActivity.access$200(FollowingActivity.this).addList(FollowingActivity.access$100(FollowingActivity.this));
            FollowingActivity.access$200(FollowingActivity.this).notifyDataSetChanged();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    er()
    {
        this$0 = FollowingActivity.this;
        super();
    }
}
