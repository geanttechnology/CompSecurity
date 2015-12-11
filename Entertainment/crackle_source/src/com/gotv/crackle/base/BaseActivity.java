// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.comscore.analytics.comScore;
import com.gotv.crackle.Application;
import com.gotv.crackle.DetailsActivityResolver;
import com.gotv.crackle.FacebookHelperActivity;
import com.gotv.crackle.LoadingActivity;
import com.gotv.crackle.VideoPlayerActivity;
import com.gotv.crackle.VideoPlayerActivityFlash;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.dialogs.MainDialogFragment;
import com.gotv.crackle.dialogs.ParentalPinDialog;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.helpers.MyCrackleViewHelper;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.LocalNotificationManager;
import com.inmobi.adtracker.androidsdk.IMAdTrackerAnalytics;
import com.millennialmedia.android.MMSDK;
import com.mobileapptracker.MobileAppTracker;
import com.nielsen.app.sdk.AppSdk;
import com.nielsen.app.sdk.IAppNotifier;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sessionm.api.ext.SessionM;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class BaseActivity extends ActionBarActivity
    implements com.gotv.crackle.data.DataRequest.DataRequestListener, IAppNotifier
{
    public static final class AppSection extends Enum
    {

        private static final AppSection $VALUES[];
        public static final AppSection HOME;
        public static final AppSection MOVIES;
        public static final AppSection SHOWS;
        public static final AppSection WATCHLISTS;

        public static AppSection valueOf(String s)
        {
            return (AppSection)Enum.valueOf(com/gotv/crackle/base/BaseActivity$AppSection, s);
        }

        public static AppSection[] values()
        {
            return (AppSection[])$VALUES.clone();
        }

        static 
        {
            HOME = new AppSection("HOME", 0);
            MOVIES = new AppSection("MOVIES", 1);
            SHOWS = new AppSection("SHOWS", 2);
            WATCHLISTS = new AppSection("WATCHLISTS", 3);
            $VALUES = (new AppSection[] {
                HOME, MOVIES, SHOWS, WATCHLISTS
            });
        }

        private AppSection(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface SignInListener
    {

        public abstract void onSignInSuccess();
    }


    public static CrackleAccountManager mAccountManager = new CrackleAccountManager();
    public static boolean mJustPlayedMovie;
    public static boolean mJustPlayedShow;
    protected static AppSdk mNielsenAppSdk;
    private static String mOptOutUrl = "";
    protected static MyCrackleViewHelper sMyCrackleHelper = new MyCrackleViewHelper();
    protected ChromeCastHelper mChromeCastHelper;
    private QueueManager mFullListManager;
    public ImageLoader mImageLoader;
    public DisplayImageOptions mImageOptions;
    public AlertDialog mNetworkDialog;
    protected View mRootView;
    public AppSection mSection;
    private SignInListener mSignInListener;

    public BaseActivity()
    {
        mImageLoader = ImageLoader.getInstance();
        mImageOptions = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).build();
    }

    public static MyCrackleViewHelper getMyCrackleHelper()
    {
        return sMyCrackleHelper;
    }

    public static String getNielsenConfig()
    {
        String s = Application.getInstance().getResources().getString(0x7f0b002d);
        return (new StringBuilder()).append("{\"appName\"         : \"").append(s).append("\",").append("\"appVersion\"      : \"").append(Application.getInstance().getVersion()).append("\",").append("\"appId\"           : \"").append("P15403C25-0FDA-4473-8700-6848752FF0F4").append("\",").append("\"nol_devDebug\"          : \"").append("true").append("\",").append("\"sfcode\"          : \"").append("US").append("\"").append("}").toString();
    }

    public static String getNielsenOptOutUrl()
    {
        return mNielsenAppSdk.userOptOutURLString();
    }

    private void playItem(String s)
    {
        Object obj = (ConnectivityManager)getSystemService("connectivity");
        if (((ConnectivityManager) (obj)).getActiveNetworkInfo() != null)
        {
            if (((ConnectivityManager) (obj)).getActiveNetworkInfo() != null)
            {
                obj = CrackleAccountManager.getUserID();
                if (obj != null)
                {
                    obj = new QueueManager(this, ((String) (obj)));
                    ((QueueManager) (obj)).removeFromHistory(s);
                    ((QueueManager) (obj)).addToHistory(s);
                }
            }
            String s1;
            if (mChromeCastHelper.isConnected())
            {
                obj = new Intent(this, com/gotv/crackle/DetailsActivityResolver);
                ((Intent) (obj)).putExtra("MEDIA_ITEM_ID", s);
                ((Intent) (obj)).putExtra("START_PLAYING", true);
            } else
            if (android.os.Build.VERSION.SDK_INT < 9 && !Application.isNookTablet())
            {
                obj = new Intent(this, com/gotv/crackle/VideoPlayerActivityFlash);
            } else
            {
                obj = new Intent(this, com/gotv/crackle/VideoPlayerActivity);
            }
            ((Intent) (obj)).putExtra("MEDIA_ID", s);
            s = getIntent().getStringExtra("CONTROL");
            s1 = getIntent().getStringExtra("SEEKTO");
            if ("START_BY_YOSEMITE".equals(s) && s1 != null)
            {
                ((Intent) (obj)).putExtra("SEEKTO", s1);
                ((Intent) (obj)).putExtra("CONTROL", s);
            }
            startActivity(((Intent) (obj)));
            return;
        } else
        {
            showDialogFragment(0x5a39fc);
            return;
        }
    }

    public static void removeDialogFragment(FragmentManager fragmentmanager, int i)
    {
        FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
        fragmentmanager = fragmentmanager.findFragmentByTag((new StringBuilder()).append("dialog").append(i).toString());
        if (fragmentmanager != null)
        {
            ((MainDialogFragment)fragmentmanager).dismissAllowingStateLoss();
            fragmenttransaction.remove(fragmentmanager);
        }
        fragmenttransaction.commit();
    }

    public static void setNielsenUserOptOut(String s)
    {
        mNielsenAppSdk.userOptOut(s);
    }

    public static void showDialogFragment(FragmentManager fragmentmanager, int i)
    {
        MainDialogFragment.newInstance(i).show(fragmentmanager, (new StringBuilder()).append("dialog").append(i).toString());
    }

    public void exitApp()
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.addFlags(0x4000000);
        intent.setFlags(0x10000000);
        startActivity(intent);
        finish();
    }

    public QueueManager getFullQueueManager()
    {
        return mFullListManager;
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
        Log.i("AppSdk", (new StringBuilder()).append("Timestamp(").append(String.valueOf(l)).append(") Code(").append(String.valueOf(i)).append(") Description(").append(s).append(")").toString());
        if (i == 2001 && (mOptOutUrl == null || mOptOutUrl.isEmpty()))
        {
            mOptOutUrl = mNielsenAppSdk.userOptOutURLString();
        }
    }

    public void onBackPressed()
    {
        if (MyCrackleViewHelper.isEnableSessionM() && SessionM.getInstance().isActivityPresented())
        {
            SessionM.getInstance().dismissActivity();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        setTheme();
        super.onCreate(bundle);
        Application.getInstance().setCurrentActivity(new WeakReference(this));
        if (Application.isLeanBack() && !(this instanceof LoadingActivity) && !(this instanceof VideoPlayerActivity))
        {
            getWindow().setBackgroundDrawableResource(0x7f020132);
            mRootView = findViewById(0x1020002);
            mRootView.setBackgroundColor(getResources().getColor(0x7f07001a));
        }
        bundle = CrackleAccountManager.getUserID();
        if (bundle != null)
        {
            mFullListManager = new QueueManager(this, bundle);
            mFullListManager.getWatchList();
        }
        mNielsenAppSdk = AppSdk.getInstance(getApplicationContext(), getNielsenConfig(), this);
        mAccountManager.updateBulkMediaProgress();
        mNetworkDialog = (new android.app.AlertDialog.Builder(this)).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b00a4)).setNegativeButton(getResources().getString(0x7f0b00a5), new android.content.DialogInterface.OnClickListener() {

            final BaseActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
                refreshData();
            }

            
            {
                this$0 = BaseActivity.this;
                super();
            }
        }).setPositiveButton(getResources().getString(0x7f0b00b5), new android.content.DialogInterface.OnClickListener() {

            final BaseActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
                exitApp();
            }

            
            {
                this$0 = BaseActivity.this;
                super();
            }
        }).create();
        IMAdTrackerAnalytics.getInstance().startSession(getApplicationContext(), "02781975-1a4e-4a4f-9687-6ba9bad5967d");
        if (!SharedPrefsManager.getCurrentVersion().equalsIgnoreCase(Application.getInstalledVersion()))
        {
            SharedPrefsManager.setCurrentVersion(Application.getInstalledVersion());
            IMAdTrackerAnalytics.getInstance().reportCustomGoal("Download");
        }
        if ((this instanceof LoadingActivity) || !Application.getInstance().getLocalization().allRequestsComplete() || !MyCrackleViewHelper.isEnableSessionM())
        {
            break MISSING_BLOCK_LABEL_334;
        }
        int i;
        SessionM.getInstance().startSession(this, "f9af3a3731f371a3b2b88a2a61f71521aee8a1b1");
        i = android.os.Build.VERSION.SDK_INT;
        if (i <= 10 || i >= 16)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        SessionM.getInstance().setHardwareAccelerationDisabled(true);
        com.gotv.crackle.util.Log.d("SessionM", (new StringBuilder()).append("SessionM Version = ").append(SessionM.getInstance().getSDKVersion()).toString());
_L2:
        mChromeCastHelper = ChromeCastHelper.getInstance(this);
        return;
        bundle;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onDataFailed(final String tag, final String Message)
    {
        runOnUiThread(new Runnable() {

            final BaseActivity this$0;
            final String val$Message;
            final String val$tag;

            public void run()
            {
                if (tag.equalsIgnoreCase("ForgotPassword"))
                {
                    BaseActivity.sMyCrackleHelper.dismissForgotPasswordDialog();
                    removeDialogFragment(42340);
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(BaseActivity.this);
                    builder.setMessage(Message);
                    builder.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    builder.create().show();
                } else
                if (tag.compareTo("CrackleAccountManager Register") == 0 || tag.compareTo("CrackleAccountManager Sign In") == 0)
                {
                    removeDialogFragment(42340);
                    android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(BaseActivity.this);
                    builder1.setMessage(Message);
                    builder1.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    builder1.create().show();
                    return;
                }
            }

            
            {
                this$0 = BaseActivity.this;
                tag = s;
                Message = s1;
                super();
            }
        });
    }

    public void onDataSuccess(final String tag)
    {
        runOnUiThread(new Runnable() {

            final BaseActivity this$0;
            final String val$tag;

            public void run()
            {
                if (tag.compareTo("GetLocation") != 0) goto _L2; else goto _L1
_L1:
                if (!Application.getInstance().getLocalization().isCurrentCountryCodeValid())
                {
                    removeDialogFragment(42340);
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(BaseActivity.this);
                    builder.setMessage(getResources().getString(0x7f0b00b3));
                    builder.setPositiveButton(getResources().getString(0x7f0b00b5), new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent("android.intent.action.MAIN");
                            dialoginterface.addCategory("android.intent.category.HOME");
                            dialoginterface.addFlags(0x4000000);
                            dialoginterface.setFlags(0x10000000);
                            startActivity(dialoginterface);
                            Process.killProcess(Process.myPid());
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    builder.create().show();
                }
_L4:
                return;
_L2:
                if (tag.compareTo("FULL_WATCHLIST") != 0)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (mFullListManager.getItems() != null && mFullListManager.getItems().size() > 0)
                {
                    (new LocalNotificationManager()).regenerateWatchlistAlerts(BaseActivity.this, mFullListManager.getItems());
                    return;
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (tag.compareTo("CrackleAccountManager Register") != 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                removeDialogFragment(42340);
                BaseActivity.sMyCrackleHelper.dismissRegistrationDialog();
                BaseActivity.sMyCrackleHelper.dismissSignInRegistrationDialog();
                BaseActivity.sMyCrackleHelper.setUpLogOut();
                Toast.makeText(BaseActivity.this, getResources().getString(0x7f0b0082), 0).show();
                Application.getInstance().getHasOffersTracking().measureAction("registration");
                SessionM.getInstance().presentActivity(com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT, new Object[] {
                    "register"
                });
                String s = CrackleAccountManager.getUserID();
                if (s != null)
                {
                    mFullListManager = new QueueManager(BaseActivity.this, s);
                    mFullListManager.getWatchList();
                    return;
                }
                continue; /* Loop/switch isn't completed */
                if (tag.compareTo("CrackleAccountManager Sign In") != 0) goto _L4; else goto _L5
_L5:
                removeDialogFragment(42340);
                BaseActivity.sMyCrackleHelper.dismissSignInDialog();
                BaseActivity.sMyCrackleHelper.dismissSignInRegistrationDialog();
                BaseActivity.sMyCrackleHelper.setUpLogOut();
                Toast.makeText(BaseActivity.this, getResources().getString(0x7f0b0083), 0).show();
                if (mSignInListener != null)
                {
                    mSignInListener.onSignInSuccess();
                }
                String s1 = CrackleAccountManager.getUserID();
                if (s1 != null)
                {
                    mFullListManager = new QueueManager(BaseActivity.this, s1);
                    mFullListManager.getWatchList();
                    return;
                }
                if (true) goto _L4; else goto _L6
_L6:
            }

            
            {
                this$0 = BaseActivity.this;
                tag = s;
                super();
            }
        });
    }

    protected void onDestroy()
    {
        mImageLoader.clearMemoryCache();
        super.onDestroy();
        sMyCrackleHelper.dismissRegistrationDialog();
        sMyCrackleHelper.dismissSignInDialog();
        sMyCrackleHelper.dismissSignInRegistrationDialog();
    }

    protected void onPause()
    {
        mImageLoader.clearMemoryCache();
        if (MyCrackleViewHelper.isEnableSessionM())
        {
            try
            {
                SessionM.getInstance().onActivityPause(this);
            }
            catch (Exception exception) { }
        }
        mChromeCastHelper.onPause();
        comScore.onExitForeground();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        Application.getInstance().getHasOffersTracking().setReferralSources(this);
        Application.getInstance().getHasOffersTracking().measureSession();
        Application.getInstance().setCurrentActivity(new WeakReference(this));
        if (!(this instanceof LoadingActivity) && Application.getInstance().isNewInstance())
        {
            SessionM.getInstance().logAction("Launched Crackle");
            MMSDK.initialize(this);
            MMSDK.trackConversion(this, "30976");
        }
        if (MyCrackleViewHelper.isEnableSessionM())
        {
            SessionM.getInstance().onActivityResume(this);
        }
        if (mJustPlayedMovie)
        {
            mJustPlayedMovie = false;
            SessionM.getInstance().logAction("watchedMovie");
        }
        if (mJustPlayedShow)
        {
            mJustPlayedShow = false;
            SessionM.getInstance().logAction("watchedShow");
        }
        if (!(this instanceof LoadingActivity) && !(this instanceof VideoPlayerActivity) && !(this instanceof VideoPlayerActivityFlash))
        {
            SessionM.getInstance().presentActivity(com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT);
        }
        sMyCrackleHelper.dismissRegistrationDialog();
        sMyCrackleHelper.dismissSignInDialog();
        sMyCrackleHelper.dismissSignInRegistrationDialog();
        mChromeCastHelper.onResume();
        comScore.onEnterForeground();
    }

    protected void onStart()
    {
        super.onStart();
        if (!MyCrackleViewHelper.isEnableSessionM())
        {
            break MISSING_BLOCK_LABEL_17;
        }
        SessionM.getInstance().onActivityStart(this);
        return;
        Exception exception;
        exception;
    }

    protected void onStop()
    {
        if (MyCrackleViewHelper.isEnableSessionM())
        {
            try
            {
                SessionM.getInstance().onActivityStop(this);
            }
            catch (Exception exception) { }
        }
        super.onStop();
    }

    protected abstract void performMenuAction(int i);

    public void playMediaItem(String s)
    {
        playMediaItem(s, null);
    }

    public void playMediaItem(final String itemID, final Runnable runAfterPlay)
    {
        if (!((ConnectivityManager)getSystemService("connectivity")).getNetworkInfo(1).isConnected() && SharedPrefsManager.getWifiOnlyEnabled())
        {
            showDialogFragment(0xcb51c);
        } else
        {
            if (SharedPrefsManager.getIsParentalLockEnabled(com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl.RESTRICT_MATURE_CONTENT) || SharedPrefsManager.getIsParentalLockEnabled(com.gotv.crackle.helpers.SharedPrefsManager.ParentalControl.RESTRICT_ALL_CONTENT))
            {
                runOnUiThread(new Runnable() {

                    final BaseActivity this$0;
                    final String val$itemID;
                    final Runnable val$runAfterPlay;

                    public void run()
                    {
                        ParentalPinDialog parentalpindialog = new ParentalPinDialog(BaseActivity.this);
                        ((TextView)parentalpindialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
                        parentalpindialog.setTitle(getString(0x7f0b0069));
                        parentalpindialog.setOnDismissListener(parentalpindialog. new android.content.DialogInterface.OnDismissListener() {

                            final _cls7 this$1;
                            final ParentalPinDialog val$dialog;

                            public void onDismiss(DialogInterface dialoginterface)
                            {
                                if (!dialog.wasCancelled())
                                {
                                    if (dialog.getCode().compareTo(SharedPrefsManager.getParentalLockCode()) != 0)
                                    {
                                        dialog.show();
                                        dialog.clearInput();
                                    } else
                                    {
                                        playItem(itemID);
                                    }
                                }
                                if (runAfterPlay != null)
                                {
                                    runAfterPlay.run();
                                }
                            }

            
            {
                this$1 = final__pcls7;
                dialog = ParentalPinDialog.this;
                super();
            }
                        });
                        parentalpindialog.show();
                    }

            
            {
                this$0 = BaseActivity.this;
                itemID = s;
                runAfterPlay = runnable;
                super();
            }
                });
                return;
            }
            playItem(itemID);
            if (runAfterPlay != null)
            {
                runAfterPlay.run();
                return;
            }
        }
    }

    public void postRefreshData()
    {
        runOnUiThread(new Runnable() {

            final BaseActivity this$0;

            public void run()
            {
                refreshData();
            }

            
            {
                this$0 = BaseActivity.this;
                super();
            }
        });
    }

    public void postToFacebook(boolean flag, MediaDetailsItem mediadetailsitem)
    {
        if (mediadetailsitem != null)
        {
            Intent intent = new Intent(this, com/gotv/crackle/FacebookHelperActivity);
            if (flag)
            {
                intent.putExtra("REQUEST_TYPE", 2);
            } else
            {
                intent.putExtra("REQUEST_TYPE", 1);
            }
            intent.putExtra("SHARE_STRING", mediadetailsitem.getPermaLink());
            startActivity(intent);
        }
    }

    protected void refreshData()
    {
    }

    public void removeDialogFragment(int i)
    {
        removeDialogFragment(getSupportFragmentManager(), i);
    }

    protected void setActionBarTitle(String s)
    {
        ActionBar actionbar = getSupportActionBar();
        if (Application.isLeanBack())
        {
            try
            {
                actionbar.setDisplayShowTitleEnabled(false);
                View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03003e, null, false);
                ((TextView)view.findViewById(0x7f0a00cb)).setText(s);
                getSupportActionBar().setCustomView(view);
                actionbar.setDisplayOptions(16);
                ((ImageButton)view.findViewById(0x7f0a0077)).setOnClickListener(new android.view.View.OnClickListener() {

                    final BaseActivity this$0;

                    public void onClick(View view1)
                    {
                        performMenuAction(0x102002c);
                    }

            
            {
                this$0 = BaseActivity.this;
                super();
            }
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
        } else
        {
            actionbar.setDisplayShowTitleEnabled(true);
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setTitle(s);
            return;
        }
    }

    public void setSignInListener(SignInListener signinlistener)
    {
        mSignInListener = signinlistener;
    }

    protected void setTheme()
    {
        if (Application.isLeanBack())
        {
            setTheme(0x7f0c0094);
            return;
        } else
        {
            setTheme(0x7f0c008e);
            return;
        }
    }

    public void shareMailClicked(MediaDetailsItem mediadetailsitem)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(getResources().getString(0x7f0b00c3)).append(" ").append(mediadetailsitem.getTitle()).append(" ").append(getResources().getString(0x7f0b00c4)).toString());
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(getResources().getString(0x7f0b00c5)).append(" ").append(mediadetailsitem.getTitle()).append(" ").append(getResources().getString(0x7f0b00c6)).append("\n\n").append(mediadetailsitem.getPermaLink()).toString());
        startActivity(intent);
    }

    public void shareSMSClicked(MediaDetailsItem mediadetailsitem)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sms:"));
        intent.putExtra("sms_body", (new StringBuilder()).append(getResources().getString(0x7f0b00c5)).append(" ").append(mediadetailsitem.getTitle()).append(" ").append(getResources().getString(0x7f0b00c6)).append("\n\n").append(mediadetailsitem.getPermaLink()).toString());
        startActivity(intent);
    }

    public void showDialogFragment(int i)
    {
        showDialogFragment(getSupportFragmentManager(), i);
    }

    public void showDialogFragment(int i, String s)
    {
        MainDialogFragment.newInstance(i, s).show(getSupportFragmentManager(), (new StringBuilder()).append("dialog").append(i).toString());
    }




/*
    static QueueManager access$002(BaseActivity baseactivity, QueueManager queuemanager)
    {
        baseactivity.mFullListManager = queuemanager;
        return queuemanager;
    }

*/


}
