// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import my.googlemusic.play.adapters.upcoming.UpcomingAdapter;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;

public class UpcomingActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener
{
    private static class ViewHolder
    {

        RelativeLayout adView;
        AppBar appBar;
        Button goToLibrary;
        ListView list;
        View loading;
        View offline;

        private ViewHolder()
        {
        }

    }


    private UpcomingAdapter mAdapter;
    private ViewHolder mHolder;
    private Server mServer;

    public UpcomingActivity()
    {
    }

    private void initAds()
    {
        BannerManager.loadmmdevbanner(mHolder.adView);
    }

    private void initData()
    {
        setLoading(true);
        mServer = ((App)getApplication()).getServer();
        mServer.getUpcoming(new my.googlemusic.play.interfaces.Server.Callback() {

            final UpcomingActivity this$0;

            public void onFailure(Response response)
            {
                if (response.getStatus() == 6)
                {
                    mHolder.offline.setVisibility(0);
                    ((TextView)findViewById(0x7f0d01a6)).setText("Upcoming are not available offline");
            /* block-local class not found */
            class _cls1 {}

                    mHolder.goToLibrary.setOnClickListener(new _cls1());
                }
                setLoading(false);
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof List)
                {
                    initUpcoming((List)obj);
                }
                setLoading(false);
            }

            
            {
                this$0 = UpcomingActivity.this;
                super();
            }
        });
    }

    private void initUpcoming(List list)
    {
        mAdapter = new UpcomingAdapter(this, list);
        mHolder.list.setAdapter(mAdapter);
        setLoading(false);
    }

    private void initView()
    {
        getSupportActionBar().hide();
        mHolder = new ViewHolder();
        mHolder.offline = findViewById(0x7f0d01a3);
        mHolder.loading = findViewById(0x7f0d019b);
        mHolder.list = (ListView)findViewById(0x7f0d0177);
        mHolder.adView = (RelativeLayout)findViewById(0x7f0d0178);
        mHolder.goToLibrary = (Button)findViewById(0x7f0d01a7);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("Upcoming Mixtapes").back();
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

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030038);
        initView();
        initData();
        initAds();
    }

    protected void onDestroy()
    {
        super.onDestroy();
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

    protected void onResume()
    {
        super.onResume();
        if (mServer.getUser().isPremium() && mHolder.adView.getVisibility() == 0)
        {
            mHolder.adView.setVisibility(8);
        }
    }



}
