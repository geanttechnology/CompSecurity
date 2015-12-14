// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.adapters.search.SearchUserAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.ListSpaceUtil;
import my.googlemusic.play.utils.views.RobotoTextView;

// Referenced classes of package my.googlemusic.play.activities:
//            LoginActivity

public class CreateAccountStepThreeActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, my.googlemusic.play.adapters.search.SearchUserAdapter.OnItemSearchUserClickListener
{
    private static class ViewHolder
    {

        private RobotoTextView finish;
        private View info;
        private ListView list;
        private View loading;
        private RobotoTextView total;



/*
        static View access$102(ViewHolder viewholder, View view)
        {
            viewholder.info = view;
            return view;
        }

*/



/*
        static View access$202(ViewHolder viewholder, View view)
        {
            viewholder.loading = view;
            return view;
        }

*/



/*
        static ListView access$302(ViewHolder viewholder, ListView listview)
        {
            viewholder.list = listview;
            return listview;
        }

*/



/*
        static RobotoTextView access$402(ViewHolder viewholder, RobotoTextView robototextview)
        {
            viewholder.finish = robototextview;
            return robototextview;
        }

*/



/*
        static RobotoTextView access$502(ViewHolder viewholder, RobotoTextView robototextview)
        {
            viewholder.total = robototextview;
            return robototextview;
        }

*/

        private ViewHolder()
        {
        }

    }


    private SearchUserAdapter mAdapter;
    private ViewHolder mHolder;
    private Server mServer;
    private List mUserList;

    public CreateAccountStepThreeActivity()
    {
    }

    private void initData()
    {
        mServer = ((App)getApplication()).getServer();
    }

    private void initSearch()
    {
        mServer.getRecommendedUser(new my.googlemusic.play.interfaces.Server.Callback() {

            final CreateAccountStepThreeActivity this$0;

            public void onFailure(Response response)
            {
                mUserList = new ArrayList();
                mAdapter = new SearchUserAdapter(CreateAccountStepThreeActivity.this, mUserList, mServer.getUser(), CreateAccountStepThreeActivity.this, mServer);
                mHolder.list.setAdapter(mAdapter);
                setLoading(false);
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof List)
                {
                    mUserList = (List)obj;
                    mAdapter = new SearchUserAdapter(CreateAccountStepThreeActivity.this, mUserList, mServer.getUser(), CreateAccountStepThreeActivity.this, mServer);
                    mHolder.list.setAdapter(mAdapter);
                    if (mUserList.size() == 0)
                    {
                        setInfo(true);
                        setLoading(false);
                    } else
                    {
                        mHolder.total.setText((new StringBuilder()).append(mUserList.size()).append("").toString());
                    }
                    setLoading(false);
                }
            }

            
            {
                this$0 = CreateAccountStepThreeActivity.this;
                super();
            }
        });
    }

    private void initView()
    {
        getSupportActionBar().hide();
        setContentView(0x7f030020);
        mHolder = new ViewHolder();
        mHolder.info = findViewById(0x7f0d00ac);
        mHolder.loading = findViewById(0x7f0d019b);
        mHolder.list = (ListView)findViewById(0x7f0d00a8);
        mHolder.finish = (RobotoTextView)findViewById(0x7f0d00ab);
        mHolder.total = (RobotoTextView)findViewById(0x7f0d00a7);
        mHolder.finish.setOnClickListener(this);
        mHolder.list.addHeaderView(ListSpaceUtil.getSpace(this, 8));
        mHolder.list.addFooterView(ListSpaceUtil.getSpace(this, 8));
        registerForContextMenu(mHolder.list);
        setLoading(true);
        setInfo(false);
    }

    private void setInfo(boolean flag)
    {
        View view = mHolder.info;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void setLoading(boolean flag)
    {
        View view = mHolder.loading;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void onAddSearchUserClick(final User friendUser)
    {
        User user = mServer.getUser();
        if (friendUser.isFollower())
        {
            mServer.removeFriend(user.getId(), friendUser.getId(), new my.googlemusic.play.interfaces.Server.Callback() {

                final CreateAccountStepThreeActivity this$0;
                final User val$friendUser;

                public void onFailure(Response response)
                {
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    mAdapter.setFollowing(friendUser);
                    mAdapter.notifyDataSetChanged();
                }

            
            {
                this$0 = CreateAccountStepThreeActivity.this;
                friendUser = user;
                super();
            }
            });
            return;
        } else
        {
            mServer.addFriend(user.getId(), friendUser.getId(), new my.googlemusic.play.interfaces.Server.Callback() {

                final CreateAccountStepThreeActivity this$0;
                final User val$friendUser;

                public void onFailure(Response response)
                {
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    mAdapter.setFollowing(friendUser);
                    mAdapter.notifyDataSetChanged();
                }

            
            {
                this$0 = CreateAccountStepThreeActivity.this;
                friendUser = user;
                super();
            }
            });
            return;
        }
    }

    public void onBackPressed()
    {
        startActivity((new Intent(this, my/googlemusic/play/activities/LoginActivity)).setFlags(0x10008000));
        finish();
    }

    public void onClick(View view)
    {
        if (view == mHolder.finish)
        {
            startActivity((new Intent(this, my/googlemusic/play/activities/LoginActivity)).setFlags(0x10008000));
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initData();
        initView();
        initSearch();
    }

    public void onItemSearchUserClick(User user)
    {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }





/*
    static List access$602(CreateAccountStepThreeActivity createaccountstepthreeactivity, List list)
    {
        createaccountstepthreeactivity.mUserList = list;
        return list;
    }

*/



/*
    static SearchUserAdapter access$702(CreateAccountStepThreeActivity createaccountstepthreeactivity, SearchUserAdapter searchuseradapter)
    {
        createaccountstepthreeactivity.mAdapter = searchuseradapter;
        return searchuseradapter;
    }

*/


}
