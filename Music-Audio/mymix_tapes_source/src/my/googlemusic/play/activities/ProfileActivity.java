// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import java.util.List;
import my.googlemusic.play.adapters.feed.HeaderLayoutManagerFixed;
import my.googlemusic.play.adapters.feed.ParallaxRecyclerAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.feed.FeedBox;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            LoginActivity, SearchActivity, SettingsActivity

public class ProfileActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, my.googlemusic.play.feed.viewholder.HeaderViewHolder.OnHeaderStartActivityForResult
{
    private static class ViewHolder
    {

        Button activity;
        AppBar appBar;
        ImageView background;
        RecyclerView recycleView;
        View statusBar;

        private ViewHolder()
        {
        }

    }


    private static final int ACTIVITY_SETTINGS = 1000;
    private static final String lastDate = "";
    private static final int totalItems = 20;
    private ParallaxRecyclerAdapter mAdapter;
    private FeedBox mData;
    private ViewHolder mHolder;
    private String mInstagram;
    private HeaderLayoutManagerFixed mLayoutManagerFixed;
    private Server mServer;
    private long mTargetId;

    public ProfileActivity()
    {
    }

    private String getInstagram()
    {
        return mInstagram;
    }

    private void initData()
    {
        mTargetId = getIntent().getExtras().getLong("user");
        mServer = ((App)getApplication()).getServer();
        mServer.getProfileFeed(mTargetId, 20, "", new my.googlemusic.play.interfaces.Server.Callback() {

            final ProfileActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                mData = (FeedBox)obj;
                if (!isAdapterCreated())
                {
                    obj = getLayoutInflater().inflate(0x7f03005e, mHolder.recycleView, false);
                    mLayoutManagerFixed.setHeaderIncrementFixer(((View) (obj)));
                    mAdapter = new ParallaxRecyclerAdapter();
                    mAdapter.setShouldClipView(false);
                    mAdapter.setParallaxHeader(((View) (obj)), mHolder.recycleView);
                    mHolder.recycleView.setAdapter(mAdapter);
                    mAdapter.setHeaderViews(mHolder.appBar.getBackground(), mHolder.statusBar);
                    mAdapter.setData(mData.getList());
                    if (mAdapter.hasHeader())
                    {
                        bindHeaderProfile();
                    }
                }
            /* block-local class not found */
            class _cls1 {}

                mAdapter.implementRecyclerAdapterMethods(new _cls1());
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
    }

    private void initView()
    {
        getSupportActionBar().hide();
        mHolder = new ViewHolder();
        mHolder.statusBar = findViewById(0x7f0d011f);
        mHolder.background = (ImageView)findViewById(0x7f0d011c);
        mHolder.recycleView = (RecyclerView)findViewById(0x7f0d011e);
        mLayoutManagerFixed = new HeaderLayoutManagerFixed(this);
        mHolder.recycleView.setLayoutManager(mLayoutManagerFixed);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).back().search();
        if (CompatibilityUtil.getSdkVersion() > 11)
        {
            mHolder.statusBar.setAlpha(0.0F);
            mHolder.appBar.getBackground().setAlpha(0.0F);
        }
        if (CompatibilityUtil.getSdkVersion() < 19)
        {
            mHolder.statusBar.setVisibility(8);
        }
    }

    private boolean isAdapterCreated()
    {
        return mAdapter != null;
    }

    private void setInstagram(String s)
    {
        mInstagram = s;
        if (!s.equalsIgnoreCase("null"))
        {
            mHolder.appBar.instagram();
        }
    }

    public void bindHeaderProfile()
    {
        if (mServer.getUser() != null)
        {
            mServer.getProfile(mServer.getUser().getId(), mTargetId, new my.googlemusic.play.interfaces.Server.Callback() {

                final ProfileActivity this$0;

                public void onFailure(Response response)
                {
                    mAdapter.bindHeader(null, true, mAdapter.getItemCount(), ProfileActivity.this);
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    obj = (List)obj;
                    mAdapter.bindHeader(obj, false, mAdapter.getItemCount(), ProfileActivity.this);
                    if (obj != null && ((List) (obj)).get(0) != null && (((List) (obj)).get(0) instanceof User))
                    {
                        obj = (User)((List) (obj)).get(0);
                        setInstagram(((User) (obj)).getInstagram());
                        mHolder.appBar.title(((User) (obj)).getUsername());
                    }
                }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
            });
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 1000)
        {
            if (j == 13000 || j == 12000)
            {
                bindHeaderProfile();
            } else
            if (j == 10000)
            {
                startActivity((new Intent(this, my/googlemusic/play/activities/LoginActivity)).setFlags(0x10008000).putExtra("register", false));
                setResult(10000);
                return;
            }
        }
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        } else
        {
            if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.SEARCH)
            {
                startActivity(new Intent(this, my/googlemusic/play/activities/SearchActivity));
                return;
            }
            if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.INSTAGRAM && getInstagram() != null)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://instagram.com/").append(getInstagram()).toString())));
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (CompatibilityUtil.getSdkVersion() >= 19)
        {
            getWindow().setFlags(0x4000000, 0x4000000);
        }
        setContentView(0x7f030032);
        initView();
        initData();
    }

    public void onHeaderStartActivityForResult(boolean flag)
    {
        startActivityForResult(new Intent(this, my/googlemusic/play/activities/SettingsActivity), 1000);
    }

    protected void onResume()
    {
        super.onResume();
    }



/*
    static FeedBox access$102(ProfileActivity profileactivity, FeedBox feedbox)
    {
        profileactivity.mData = feedbox;
        return feedbox;
    }

*/






/*
    static ParallaxRecyclerAdapter access$502(ProfileActivity profileactivity, ParallaxRecyclerAdapter parallaxrecycleradapter)
    {
        profileactivity.mAdapter = parallaxrecycleradapter;
        return parallaxrecycleradapter;
    }

*/

}
