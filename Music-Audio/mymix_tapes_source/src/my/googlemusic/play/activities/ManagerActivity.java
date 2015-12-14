// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.PrintStream;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.fragments.components.NavigationFragment;
import my.googlemusic.play.fragments.manager.DrawerFragment;
import my.googlemusic.play.fragments.manager.FeatureFragment;
import my.googlemusic.play.fragments.manager.FeedFragment;
import my.googlemusic.play.fragments.manager.JustAddedFragment;
import my.googlemusic.play.fragments.manager.SinglesFragment;
import my.googlemusic.play.fragments.manager.VideosFragment;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;
import my.googlemusic.play.services.notification.NotificationService;
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.animations.ViewQuickReturn;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.dialog.DialogUpdate;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity, ReplyActivity, PresentationActivity, LoginActivity, 
//            SearchActivity, ProfileActivity

public class ManagerActivity extends ActionBarActivity
    implements my.googlemusic.play.fragments.components.NavigationFragment.OnNavigationListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener
{
    public static class ViewHolder
    {

        RelativeLayout adView;
        AppBar appBar;
        View background;
        ProgressBar loading;
        LinearLayout loadingLayout;
        View navigationContainer;
        View newFeed;

        public ViewHolder()
        {
        }
    }


    public static final String EXTRA_WEB_LINK = "web_link";
    public static final int RESULT_CODE_LOGOUT = 10000;
    public static final int RESULT_CODE_LOGOUT_REGISTER = 11000;
    public static final int RESULT_CODE_UPDATE_IMAGE_PROFILE = 12000;
    public static final int RESULT_CODE_UPDATE_USERNAME = 13000;
    private static final int TITLES[] = {
        0x7f0600ec, 0x7f0600ea, 0x7f0600e8, 0x7f0600f2, 0x7f0600e6
    };
    private static long mBackPressed;
    public static String mPreferences = "feed";
    public static String sPreferencesName = "skipPresentation";
    private int currentNavigation;
    private boolean isActive;
    private DrawerFragment mDrawer;
    private ViewHolder mHolder;
    private NavigationFragment mNavigation;
    private Server mServer;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences mSharedPreferencesFeed;
    private String mTagFragmentShowing;
    private ViewQuickReturn mViewQuickReturn;
    private String mWeblink;
    private long pushIdAlbum;
    private long pushIdTarget;
    private int pushType;

    public ManagerActivity()
    {
        currentNavigation = 2;
        mTagFragmentShowing = "";
    }

    private void checkIfWasStartedByWeb()
    {
        if (mWeblink != null)
        {
            mHolder.loadingLayout.setVisibility(0);
            mHolder.loading.setIndeterminate(true);
            mServer.getRealAlbumId(mWeblink, new my.googlemusic.play.interfaces.Server.Callback() {

                final ManagerActivity this$0;

                public void onFailure(Response response)
                {
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    Intent intent = new Intent(ManagerActivity.this, my/googlemusic/play/activities/AlbumActivity);
                    intent.putExtra("album", App.getGson().toJson(mServer.getAlbum(((Long)obj).longValue())));
                    startActivity(intent);
                    mWeblink = null;
                }

            
            {
                this$0 = ManagerActivity.this;
                super();
            }
            });
        }
    }

    private Fragment getFragmentByPosition(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            if (mServer.getUser().isSkip())
            {
                (new DialogSkipUser()).show(getSupportFragmentManager(), null);
            }
            return new FeedFragment();

        case 1: // '\001'
            return new JustAddedFragment();

        case 2: // '\002'
            return new FeatureFragment();

        case 3: // '\003'
            return new SinglesFragment();

        case 4: // '\004'
            return new VideosFragment();
        }
    }

    private void initActionSong()
    {
        Uri uri = getIntent().getData();
        if (uri != null && uri.getPath().startsWith("/track/"))
        {
            Object obj = getIntent().getData().getPath().substring(7);
            obj = mServer.getSong(Long.parseLong(((String) (obj))));
            if (obj != null)
            {
                Intent intent = new Intent(this, my/googlemusic/play/activities/AlbumActivity);
                intent.putExtra("album", App.getGson().toJson(((Song) (obj)).getAlbum()));
                intent.putExtra("actionSong", App.getGson().toJson(obj));
                startActivity(intent);
            }
        }
    }

    private void initActivity()
    {
        if (pushType == 1)
        {
            onNavigationSelected(0);
            return;
        }
        if (pushType == 5)
        {
            startActivity((new Intent(this, my/googlemusic/play/activities/ReplyActivity)).putExtra("idComment", pushIdTarget).putExtra("idAlbum", pushIdAlbum));
            return;
        } else
        {
            onNavigationSelected(currentNavigation);
            return;
        }
    }

    private void initAds()
    {
        BannerManager.loadmmdevbanner(mHolder.adView);
    }

    private void initData()
    {
        if (getIntent().getExtras() != null)
        {
            pushType = getIntent().getExtras().getInt("push_type");
            pushIdAlbum = getIntent().getExtras().getLong("push_id_album");
            pushIdTarget = getIntent().getExtras().getLong("push_id_target");
            mWeblink = getIntent().getExtras().getString("web_link");
        }
        mServer = ((App)getApplication()).getServer();
        startService(new Intent(this, my/googlemusic/play/services/notification/NotificationService));
        verifyVersion();
    }

    private void initDrawer()
    {
        DrawerLayout drawerlayout = (DrawerLayout)findViewById(0x7f0d00f0);
        mDrawer = (DrawerFragment)getSupportFragmentManager().findFragmentById(0x7f0d00f9);
        mDrawer.setUp(drawerlayout);
    }

    private void initPresentation()
    {
        if (!isPresentated())
        {
            startActivity(new Intent(this, my/googlemusic/play/activities/PresentationActivity));
        }
    }

    private void initView()
    {
        setContentView(0x7f03002d);
        mHolder = new ViewHolder();
        mHolder.background = findViewById(0x7f0d00ef);
        mHolder.adView = (RelativeLayout)findViewById(0x7f0d00f5);
        mHolder.navigationContainer = findViewById(0x7f0d00f3);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("My Mixtapez").drawer().profile().search();
        mNavigation = (NavigationFragment)getSupportFragmentManager().findFragmentById(0x7f0d00f6);
        mViewQuickReturn = new ViewQuickReturn(mHolder.navigationContainer, findViewById(0x7f0d00f6));
        mHolder.loadingLayout = (LinearLayout)findViewById(0x7f0d00f7);
        mHolder.loading = (ProgressBar)findViewById(0x7f0d00f8);
        mHolder.newFeed = findViewById(0x7f0d019d);
        setNewFeedVisibility(false);
    }

    private void registerGCMPush()
    {
        if (CompatibilityUtil.getSdkVersion() < 20)
        {
            System.out.println("::C2DM:: start registration process");
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.putExtra("app", PendingIntent.getBroadcast(this, 0, new Intent(), 0));
            intent.putExtra("sender", "153190082422");
            startService(intent);
        }
    }

    private void removeNewFeed()
    {
        if (mSharedPreferencesFeed == null)
        {
            mSharedPreferencesFeed = getSharedPreferences(mPreferences, 0);
        }
        android.content.SharedPreferences.Editor editor = mSharedPreferencesFeed.edit();
        editor.putBoolean(mPreferences, false);
        editor.commit();
        setNewFeedVisibility(haveNewFeed());
    }

    private void setNewFeedVisibility(boolean flag)
    {
        View view = mHolder.newFeed;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        view.setVisibility(i);
    }

    private int updatePosition(int i)
    {
        return i;
    }

    private void verifyVersion()
    {
        ((App)getApplicationContext()).getServer().verifyVersion(new my.googlemusic.play.interfaces.Server.Callback() {

            final ManagerActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                int i;
                try
                {
                    i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    i = 0x3b9ac9ff;
                    namenotfoundexception.printStackTrace();
                }
                if (obj.toString().equals(""))
                {
                    obj = "0";
                } else
                {
                    obj = obj.toString();
                }
                if (Integer.parseInt(((String) (obj))) > i)
                {
                    (new DialogUpdate()).show(getSupportFragmentManager(), null);
                }
            }

            
            {
                this$0 = ManagerActivity.this;
                super();
            }
        });
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 38
    //                   1 32
    //                   2 49;
           goto _L1 _L2 _L1 _L3
_L1:
        return super.dispatchTouchEvent(motionevent);
_L2:
        mViewQuickReturn.onDownMotionEvent(motionevent);
        continue; /* Loop/switch isn't completed */
_L3:
        mViewQuickReturn.onMoveMotionEvent(motionevent);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean haveNewFeed()
    {
        if (mSharedPreferencesFeed == null)
        {
            mSharedPreferencesFeed = getSharedPreferences(mPreferences, 0);
        }
        return mSharedPreferencesFeed.getBoolean(mPreferences, true);
    }

    public boolean isPresentated()
    {
        if (mSharedPreferences == null)
        {
            mSharedPreferences = getSharedPreferences(sPreferencesName, 0);
        }
        return mSharedPreferences.getBoolean("skipPresentation", false);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == 10000 || j == 11000)
        {
            finish();
            intent = new Intent(this, my/googlemusic/play/activities/LoginActivity);
            if (j == 11000)
            {
                intent.putExtra("register", true);
            }
            startActivity(intent);
        } else
        {
            if (j == 12000)
            {
                mDrawer.initHeadDrawer();
                return;
            }
            if (j == 13000)
            {
                mDrawer.initData();
                mDrawer.initHeadDrawer();
                return;
            }
        }
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action != my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.DRAWER) goto _L2; else goto _L1
_L1:
        if (!mDrawer.isOpen()) goto _L4; else goto _L3
_L3:
        mDrawer.close();
_L6:
        return;
_L4:
        mDrawer.open();
        return;
_L2:
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.SEARCH)
        {
            startActivity(new Intent(this, my/googlemusic/play/activities/SearchActivity));
            return;
        }
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.PROFILE)
        {
            if (mServer.getUser().isSkip())
            {
                (new DialogSkipUser()).show(getSupportFragmentManager(), null);
                return;
            } else
            {
                startActivity((new Intent(this, my/googlemusic/play/activities/ProfileActivity)).putExtra("user", mServer.getUser().getId()));
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onBackPressed()
    {
        if (mBackPressed + 2000L > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        } else
        {
            Toast.with(this).message("Press back again to exit!").show();
            mBackPressed = System.currentTimeMillis();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        initData();
        initView();
        checkIfWasStartedByWeb();
        initDrawer();
        initActivity();
        initAds();
        initPresentation();
        registerGCMPush();
        initActionSong();
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

    public void onNavigationSelected(int i)
    {
        if (!mTagFragmentShowing.equals(String.valueOf(i)))
        {
            currentNavigation = i;
            mNavigation.setNavigationSelected(i);
            FragmentManager fragmentmanager = getSupportFragmentManager();
            Fragment fragment = fragmentmanager.findFragmentByTag(mTagFragmentShowing);
            if (fragment != null && fragment.isVisible())
            {
                fragmentmanager.beginTransaction().hide(fragment).commit();
            }
            mTagFragmentShowing = String.valueOf(i);
            fragment = fragmentmanager.findFragmentByTag(mTagFragmentShowing);
            if (fragment != null && fragment.isHidden())
            {
                fragmentmanager.beginTransaction().show(fragment).commit();
            } else
            if (fragment == null)
            {
                fragmentmanager.beginTransaction().add(0x7f0d00f2, getFragmentByPosition(i), mTagFragmentShowing).setTransition(0).commit();
            }
            ((TextView)findViewById(0x7f0d00bd)).setText(TITLES[updatePosition(i)]);
            setNewFeedVisibility(haveNewFeed());
            if (i == 0)
            {
                removeNewFeed();
                return;
            }
        }
    }

    protected void onPause()
    {
        super.onPause();
        isActive = false;
    }

    protected void onResume()
    {
        super.onResume();
        isActive = true;
        if (mServer.getUser().isPremium() && mHolder.adView.getVisibility() == 0)
        {
            mHolder.adView.setVisibility(8);
            mDrawer.removePremiumItem();
        }
        if (mWeblink == null && mHolder.loadingLayout.getVisibility() == 0)
        {
            mHolder.loadingLayout.setVisibility(8);
            mHolder.loading.setVisibility(8);
        }
    }

    protected void onResumeFragments()
    {
        super.onResumeFragments();
        setNewFeedVisibility(haveNewFeed());
    }




/*
    static String access$102(ManagerActivity manageractivity, String s)
    {
        manageractivity.mWeblink = s;
        return s;
    }

*/
}
