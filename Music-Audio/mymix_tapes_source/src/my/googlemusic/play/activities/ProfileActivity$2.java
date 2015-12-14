// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import java.util.List;
import my.googlemusic.play.adapters.feed.ParallaxRecyclerAdapter;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            ProfileActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final ProfileActivity this$0;

    public void onFailure(Response response)
    {
        ProfileActivity.access$500(ProfileActivity.this).bindHeader(null, true, ProfileActivity.access$500(ProfileActivity.this).getItemCount(), ProfileActivity.this);
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        obj = (List)obj;
        ProfileActivity.access$500(ProfileActivity.this).bindHeader(obj, false, ProfileActivity.access$500(ProfileActivity.this).getItemCount(), ProfileActivity.this);
        if (obj != null && ((List) (obj)).get(0) != null && (((List) (obj)).get(0) instanceof User))
        {
            obj = (User)((List) (obj)).get(0);
            ProfileActivity.access$600(ProfileActivity.this, ((User) (obj)).getInstagram());
            ProfileActivity.access$300(ProfileActivity.this).appBar.title(((User) (obj)).getUsername());
        }
    }

    ewHolder()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
