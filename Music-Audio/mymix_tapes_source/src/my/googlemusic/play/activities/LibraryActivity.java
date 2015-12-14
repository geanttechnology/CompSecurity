// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.fragments.manager.LibraryFragment;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.appbar.AppBar;

public class LibraryActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener
{
    private static class ViewHolder
    {

        RelativeLayout adView;
        AppBar appBar;
        View nowPlaying;

        private ViewHolder()
        {
        }

    }


    private final String ACTIONBAR_TITLE = "Music Library";
    private ViewHolder mHolder;
    private Server mServer;

    public LibraryActivity()
    {
    }

    private void initFragment()
    {
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.add(0x7f0d00e8, LibraryFragment.newInstance());
        fragmenttransaction.commit();
    }

    private void initView()
    {
        mServer = ((App)getApplication()).getServer();
        getSupportActionBar().hide();
        setContentView(0x7f03002a);
        mHolder = new ViewHolder();
        mHolder.nowPlaying = findViewById(0x7f0d00e6);
        mHolder.adView = (RelativeLayout)findViewById(0x7f0d00e7);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("Music Library").back();
    }

    void initAds()
    {
        if (!mServer.getUser().isPremium())
        {
            BannerManager.loadmmdevbanner(mHolder.adView);
        }
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initView();
        initFragment();
        initAds();
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

    public void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        mServer.verifyDownloadsFiles();
    }
}
