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
import my.googlemusic.play.adapters.profile.FollowerAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Follower;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            ProfileActivity

public class FollowerActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, android.widget.AbsListView.OnScrollListener, my.googlemusic.play.adapters.profile.FollowerAdapter.OnFollowListener
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
    private int friendsSize;
    private long idUser;
    private FollowerAdapter mAdapter;
    private ViewHolder mHolder;
    private List mListFollowers;
    boolean mLoading;
    private int mPage;
    private Server mServer;

    public FollowerActivity()
    {
        mPage = 1;
    }

    private void initData()
    {
        mServer = ((App)getApplication()).getServer();
        idUser = getIntent().getExtras().getLong("idUser");
        friendsSize = getIntent().getExtras().getInt("friends");
        mListFollowers = new ArrayList();
    }

    private void initView()
    {
        getSupportActionBar().hide();
        mHolder = new ViewHolder();
        setContentView(0x7f030026);
        setAppBar(friendsSize);
        mHolder.loading = findViewById(0x7f0d00dc);
        mHolder.noFriends = (ImageView)findViewById(0x7f0d00dd);
        mHolder.noFriendsMessage = (TextView)findViewById(0x7f0d00de);
        mHolder.list = (ListView)findViewById(0x7f0d00db);
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
        mServer.getFollowers(mServer.getUser().getId(), idUser, mPage, new my.googlemusic.play.interfaces.Server.Callback() {

            final FollowerActivity this$0;

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
                mListFollowers = new ArrayList();
                User user;
                for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); mListFollowers.add(new Follower(user)))
                {
                    user = (User)((Iterator) (obj)).next();
                }

                if (mAdapter != null) goto _L4; else goto _L3
_L3:
                mAdapter = new FollowerAdapter(FollowerActivity.this, mListFollowers, mServer.getUser().getId(), FollowerActivity.this, mServer);
                mHolder.list.setAdapter(mAdapter);
_L6:
                if (mListFollowers != null && mAdapter.getCount() == 0 && mListFollowers.isEmpty())
                {
                    mHolder.noFriends.setVisibility(0);
                    mHolder.noFriendsMessage.setVisibility(0);
                }
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = FollowerActivity.this;
                super();
            }
        });
    }

    private void setAppBar(int i)
    {
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title((new StringBuilder()).append(i).append(" followers").toString()).back();
    }

    private void setLoading(boolean flag)
    {
        if (flag)
        {
            mHolder.footer.setVisibility(0);
            return;
        } else
        {
            mHolder.footer.setVisibility(8);
            return;
        }
    }

    public void onAddFriend(final long idUserFriend)
    {
        mServer.addFriend(idUser, idUserFriend, new my.googlemusic.play.interfaces.Server.Callback() {

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
                    mAdapter.setFollowing(idUserFriend);
                    mAdapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = FollowerActivity.this;
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
        mServer.removeFriend(idUser, idUserFriend, new my.googlemusic.play.interfaces.Server.Callback() {

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
                    mAdapter.setFollowing(idUserFriend);
                    mAdapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = FollowerActivity.this;
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
    static List access$102(FollowerActivity followeractivity, List list)
    {
        followeractivity.mListFollowers = list;
        return list;
    }

*/



/*
    static FollowerAdapter access$202(FollowerActivity followeractivity, FollowerAdapter followeradapter)
    {
        followeractivity.mAdapter = followeradapter;
        return followeradapter;
    }

*/




/*
    static int access$508(FollowerActivity followeractivity)
    {
        int i = followeractivity.mPage;
        followeractivity.mPage = i + 1;
        return i;
    }

*/

}
