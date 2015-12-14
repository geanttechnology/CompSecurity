// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import my.googlemusic.play.adapters.feed.HeaderLayoutManagerFixed;
import my.googlemusic.play.adapters.feed.ParallaxRecyclerAdapter;
import my.googlemusic.play.feed.FeedBox;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            ProfileActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final ProfileActivity this$0;

    public void onFailure(Response response)
    {
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        ProfileActivity.access$102(ProfileActivity.this, (FeedBox)obj);
        if (!ProfileActivity.access$200(ProfileActivity.this))
        {
            obj = getLayoutInflater().inflate(0x7f03005e, ProfileActivity.access$300(ProfileActivity.this).recycleView, false);
            ProfileActivity.access$400(ProfileActivity.this).setHeaderIncrementFixer(((android.view.View) (obj)));
            ProfileActivity.access$502(ProfileActivity.this, new ParallaxRecyclerAdapter());
            ProfileActivity.access$500(ProfileActivity.this).setShouldClipView(false);
            ProfileActivity.access$500(ProfileActivity.this).setParallaxHeader(((android.view.View) (obj)), ProfileActivity.access$300(ProfileActivity.this).recycleView);
            ProfileActivity.access$300(ProfileActivity.this).recycleView.setAdapter(ProfileActivity.access$500(ProfileActivity.this));
            ProfileActivity.access$500(ProfileActivity.this).setHeaderViews(ProfileActivity.access$300(ProfileActivity.this).appBar.getBackground(), ProfileActivity.access$300(ProfileActivity.this).statusBar);
            ProfileActivity.access$500(ProfileActivity.this).setData(ProfileActivity.access$100(ProfileActivity.this).getList());
            if (ProfileActivity.access$500(ProfileActivity.this).hasHeader())
            {
                bindHeaderProfile();
            }
        }
    /* block-local class not found */
    class _cls1 {}

        ProfileActivity.access$500(ProfileActivity.this).implementRecyclerAdapterMethods(new _cls1());
    }

    _cls1()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
