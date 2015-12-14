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
import my.googlemusic.play.adapters.profile.FollowerAdapter;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Follower;
import my.googlemusic.play.model.User;

// Referenced classes of package my.googlemusic.play.activities:
//            FollowerActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final FollowerActivity this$0;

    public void onFailure(Response response)
    {
        FollowerActivity.access$600(FollowerActivity.this, false);
        FollowerActivity.access$400(FollowerActivity.this).loading.setVisibility(8);
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (!(obj instanceof List)) goto _L2; else goto _L1
_L1:
        FollowerActivity.access$102(FollowerActivity.this, new ArrayList());
        User user;
        for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); FollowerActivity.access$100(FollowerActivity.this).add(new Follower(user)))
        {
            user = (User)((Iterator) (obj)).next();
        }

        if (FollowerActivity.access$200(FollowerActivity.this) != null) goto _L4; else goto _L3
_L3:
        FollowerActivity.access$202(FollowerActivity.this, new FollowerAdapter(FollowerActivity.this, FollowerActivity.access$100(FollowerActivity.this), FollowerActivity.access$300(FollowerActivity.this).getUser().getId(), FollowerActivity.this, FollowerActivity.access$300(FollowerActivity.this)));
        FollowerActivity.access$400(FollowerActivity.this).list.setAdapter(FollowerActivity.access$200(FollowerActivity.this));
_L6:
        if (FollowerActivity.access$100(FollowerActivity.this) != null && FollowerActivity.access$200(FollowerActivity.this).getCount() == 0 && FollowerActivity.access$100(FollowerActivity.this).isEmpty())
        {
            FollowerActivity.access$400(FollowerActivity.this).noFriends.setVisibility(0);
            FollowerActivity.access$400(FollowerActivity.this).noFriendsMessage.setVisibility(0);
        }
        FollowerActivity.access$508(FollowerActivity.this);
_L2:
        mLoading = false;
        FollowerActivity.access$600(FollowerActivity.this, false);
        FollowerActivity.access$400(FollowerActivity.this).loading.setVisibility(8);
        return;
_L4:
        if (!FollowerActivity.access$100(FollowerActivity.this).isEmpty())
        {
            FollowerActivity.access$200(FollowerActivity.this).addList(FollowerActivity.access$100(FollowerActivity.this));
            FollowerActivity.access$200(FollowerActivity.this).notifyDataSetChanged();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    er()
    {
        this$0 = FollowerActivity.this;
        super();
    }
}
