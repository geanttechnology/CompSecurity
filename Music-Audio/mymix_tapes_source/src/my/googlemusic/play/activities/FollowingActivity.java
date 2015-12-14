// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import my.googlemusic.play.adapters.profile.FollowingAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Following;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            ProfileActivity

public class FollowingActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, android.widget.AbsListView.OnScrollListener, my.googlemusic.play.adapters.profile.FollowingAdapter.OnFollowingListener
{
    private static class ViewHolder
    {

        AppBar appBar;
        View footer;
        ListView list;
        View loading;
        ImageView noFriends;
        TextView noFriendsMessage;

        private ViewHolder()
        {
        }

    }


    int currentFirstVisibleItem;
    int currentScrollState;
    int currentVisibleItemCount;
    private int followingSize;
    private FollowingAdapter mAdapter;
    private ViewHolder mHolder;
    private long mIdUser;
    private List mListFeed;
    boolean mLoading;
    private int mPage;
    private Server mServer;

    public FollowingActivity()
    {
        mPage = 1;
    }

    private void initData()
    {
        mServer = ((App)getApplication()).getServer();
        mIdUser = getIntent().getExtras().getLong("idUser");
        followingSize = getIntent().getExtras().getInt("friends");
        mListFeed = new ArrayList();
    }

    private void initView()
    {
        getSupportActionBar().hide();
        mHolder = new ViewHolder();
        setContentView(0x7f030027);
        mHolder.loading = findViewById(0x7f0d00e0);
        mHolder.list = (ListView)findViewById(0x7f0d00df);
        mHolder.noFriends = (ImageView)findViewById(0x7f0d00e1);
        mHolder.noFriendsMessage = (TextView)findViewById(0x7f0d00e2);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title((new StringBuilder()).append(followingSize).append(" following").toString()).back();
        mHolder.footer = LayoutInflater.from(this).inflate(0x7f030040, mHolder.list, false);
        mHolder.list.addFooterView(mHolder.footer);
        mHolder.list.setOnScrollListener(this);
    }

    private void isScrollCompleted()
    {
        if (currentVisibleItemCount > 0 && currentScrollState == 0 && !mLoading)
        {
            mLoading = true;
            onLoadData();
        }
    }

    private void onLoadData()
    {
        mServer.getFollowing(mServer.getUser().getId(), mIdUser, mPage, new my.googlemusic.play.interfaces.Server.Callback() {

            final FollowingActivity this$0;

            public void onFailure(Response response)
            {
                setLoading(false);
                mHolder.loading.setVisibility(8);
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (!(obj instanceof List)) goto _L2; else goto _L1
_L1:
                mListFeed = new ArrayList();
                User user;
                for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); mListFeed.add(new Following(user)))
                {
                    user = (User)((Iterator) (obj)).next();
                }

                if (mAdapter != null) goto _L4; else goto _L3
_L3:
                mAdapter = new FollowingAdapter(FollowingActivity.this, mListFeed, Long.valueOf(mServer.getUser().getId()), FollowingActivity.this, mServer);
                mHolder.list.setAdapter(mAdapter);
_L6:
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = FollowingActivity.this;
                super();
            }
        });
    }

    private void setLoading(boolean flag)
    {
        if (flag)
        {
            mHolder.list.addFooterView(mHolder.footer);
        } else
        if (mHolder.list.getCount() > 0)
        {
            mHolder.list.removeFooterView(mHolder.footer);
            return;
        }
    }

    public void onAddFriend(final long idUserFriend)
    {
        mServer.addFriend(mIdUser, idUserFriend, new my.googlemusic.play.interfaces.Server.Callback() {

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
                    mAdapter.setFollowing(idUserFriend);
                    mAdapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = FollowingActivity.this;
                idUserFriend = l;
                super();
            }
        });
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        onCreate(bundle);
        initData();
        initView();
        onLoadData();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return i == 82 || onKeyDown(i, keyevent);
    }

    public void onRemoveFriend(final long idUserFriend)
    {
        mServer.removeFriend(mIdUser, idUserFriend, new my.googlemusic.play.interfaces.Server.Callback() {

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
                    mAdapter.setFollowing(idUserFriend);
                    mAdapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = FollowingActivity.this;
                idUserFriend = l;
                super();
            }
        });
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        currentFirstVisibleItem = i;
        currentVisibleItemCount = j;
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        currentScrollState = i;
        isScrollCompleted();
    }

    public void onUserProfile(long l)
    {
        startActivity((new Intent(this, my/googlemusic/play/activities/ProfileActivity)).putExtra("user", l));
    }



/*
    static List access$102(FollowingActivity followingactivity, List list)
    {
        followingactivity.mListFeed = list;
        return list;
    }

*/



/*
    static FollowingAdapter access$202(FollowingActivity followingactivity, FollowingAdapter followingadapter)
    {
        followingactivity.mAdapter = followingadapter;
        return followingadapter;
    }

*/




/*
    static int access$508(FollowingActivity followingactivity)
    {
        int i = followingactivity.mPage;
        followingactivity.mPage = i + 1;
        return i;
    }

*/

}
