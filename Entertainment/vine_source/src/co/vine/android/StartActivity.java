// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import co.vine.android.api.VineLogin;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.player.VideoViewInterface;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import co.vine.android.widgets.PromptDialogSupportFragment;
import com.edisonwang.android.slog.SLog;
import com.twitter.android.sdk.Twitter;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, AppImpl, ConversationActivity, HomeTabActivity, 
//            AppInterface, LoginActivity, SignUpPagerActivity, LoginTwitterActivity, 
//            VineLoggingException

public class StartActivity extends BaseControllerActionBarActivity
    implements android.view.View.OnClickListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{
    class StartSessionListener extends AppSessionListener
    {

        final StartActivity this$0;

        public void onCheckTwitterComplete(String s, int i, String s1, int j, boolean flag, VineUser vineuser, VineLogin vinelogin)
        {
            if (flag && i == 200)
            {
                dismissDialog();
                try
                {
                    mAppController.loginComplete(mAppController.getActiveSession(), i, vineuser.username, null, vinelogin, vineuser.avatarUrl);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Util.showCenteredToast(StartActivity.this, 0x7f0e00d7);
                    CrashUtil.logException(s);
                    finish();
                    return;
                }
                if (mLoginRequest)
                {
                    setResult(-1);
                    finish();
                    return;
                } else
                {
                    StartActivity.toStart(StartActivity.this);
                    return;
                }
            }
            dismissDialog();
            if (i == 400)
            {
                s = new Bundle();
                s.putParcelable("user", vinelogin);
                startActivity(SignUpPagerActivity.getIntent(StartActivity.this, s));
                return;
            }
            if (j == co.vine.android.api.VineError.VineKnownErrors.ACCOUNT_DEACTIVATED.code)
            {
                s = PromptDialogSupportFragment.newInstance(1);
                s.setMessage(0x7f0e01ce);
                s.setTitle(0x7f0e01cf);
                s.setNegativeButton(0x7f0e0057);
                s.setPositiveButton(0x7f0e01cd);
                s.show(getSupportFragmentManager());
                return;
            } else
            {
                Util.showCenteredToast(StartActivity.this, s1);
                return;
            }
        }

        StartSessionListener()
        {
            this$0 = StartActivity.this;
            super();
        }
    }


    public static final String ACTION_ACTIVITY_NOTIFICATION_PRESSED = "co.vine.android.ACTIVITY_NOTIFICATION_PRESSED";
    public static final String ACTION_MESSAGE_NOTIFICATION_PRESSED = "co.vine.android.MESSAGE_NOTIFICATION_PRESSED";
    public static final String ACTION_RECORD = "co.vine.android.RECORD";
    public static final String ACTION_VIEW_UPLOAD_LIST = "co.vine.android.UPLOAD_LIST";
    private static final int DIALOG_ACTIVATE_ACCOUNT = 1;
    public static final String EXTRA_IS_NEW_USER = "is_new_user";
    public static final String EXTRA_LOGIN_REQUEST = "login_request_start_activity";
    private static final String PREF_LOG_STARTUP_FAIL = "pref_log_startup_fail";
    private static final int REQUEST_CODE_TWITTER_SDK = 1;
    private static final String STATE_AUTH_INTENT = "auth_intent";
    private static final String STATE_STOP_POSITION = "state_p";
    private Intent mAuthIntent;
    private Handler mHandler;
    private boolean mLoginRequest;
    private int mStopPosition;
    private Twitter mTwitter;
    private VideoViewInterface mVideoView;

    public StartActivity()
    {
        mHandler = new Handler();
    }

    private static void broadcastFinish(Context context)
    {
        Intent intent = new Intent();
        intent.setAction("co.vine.android.FINISH");
        context.sendBroadcast(intent, "co.vine.android.BROADCAST");
    }

    public static Intent getStartIntent(Context context)
    {
        return getStartIntent(context, "android.intent.action.VIEW");
    }

    public static Intent getStartIntent(Context context, String s)
    {
        context = new Intent(context, co/vine/android/StartActivity);
        context.setAction(s);
        context.setFlags(0x10008000);
        return context;
    }

    private void loginCheckTwitter(Intent intent, boolean flag)
    {
        if (intent == null)
        {
            return;
        } else
        {
            String s = intent.getStringExtra("screen_name");
            String s1 = intent.getStringExtra("tk");
            String s2 = intent.getStringExtra("ts");
            ProgressDialog progressdialog = new ProgressDialog(this, 0x7f0f0037);
            progressdialog.setProgressStyle(0);
            progressdialog.setMessage(getString(0x7f0e021d));
            progressdialog.show();
            mProgressDialog = progressdialog;
            mAppController.loginCheckTwitter(s, s1, s2, intent.getLongExtra("user_id", 0L), flag);
            return;
        }
    }

    private void openStartVideo()
    {
        mVideoView.setOnPreparedListener(null);
        mVideoView.setOnErrorListener(null);
        mVideoView.setVideoPathDirect(SystemUtil.getPathFromResourceRaw(this, 0x7f060001));
        mVideoView.seekTo(mStopPosition);
        mVideoView.start();
    }

    private boolean processIntent(Intent intent)
    {
        Object obj;
        setRequestedOrientation(1);
        obj = AppController.getInstance(this);
        if (!((AppController) (obj)).getActiveSession().isLoggedIn()) goto _L2; else goto _L1
_L1:
        if (intent != null && intent.getAction() != null && intent.getAction().startsWith("com.facebook.application"))
        {
            mLoginRequest = false;
        } else
        {
            boolean flag;
            if (intent != null && intent.getBooleanExtra("login_request_start_activity", false))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mLoginRequest = flag;
        }
        if (!mLoginRequest) goto _L4; else goto _L3
_L3:
        setResult(-1);
_L19:
        finish();
        return true;
_L4:
        Object obj1;
        String s;
        AppImpl appimpl;
        byte byte0;
        obj1 = AppImpl.getInstance();
        boolean flag1;
        if (intent != null && "co.vine.android.RECORD".equals(intent.getAction()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        ((AppImpl) (obj1)).updateClientProfile(this, ((AppController) (obj)), flag1);
        if (intent == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = intent.getAction();
        flag1 = "co.vine.android.RECORD".equals(s);
        appimpl = AppImpl.getInstance();
        obj1 = null;
        obj = obj1;
        if ("co.vine.android.MESSAGE_NOTIFICATION_PRESSED".equals(s))
        {
            mAppController.clearPushNotifications(2);
            obj = intent.getDataString();
            String s1 = intent.getStringExtra("username");
            long l1 = intent.getLongExtra("user_id", -1L);
            boolean flag2 = intent.getBooleanExtra("am_following", false);
            long l;
            if (obj != null)
            {
                l = Long.parseLong(((String) (obj)));
            } else
            {
                l = -1L;
            }
            obj = obj1;
            if (l > 0L)
            {
                obj = ConversationActivity.getIntent(this, l, s1, l1, flag2, false);
                ((Intent) (obj)).setAction(s);
            }
        }
        obj1 = obj;
        if (obj != null) goto _L6; else goto _L5
_L5:
        if (flag1) goto _L8; else goto _L7
_L7:
        obj = new Intent(this, co/vine/android/HomeTabActivity);
        ((Intent) (obj)).setFlags(0x14000000);
        ((Intent) (obj)).setAction(s);
        obj1 = obj;
        if (s == null) goto _L6; else goto _L9
_L9:
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 336
    //                   -1173171990: 392
    //                   -287654883: 408
    //                   -131004953: 424;
           goto _L10 _L11 _L12 _L13
_L10:
        byte0;
        JVM INSTR tableswitch 0 2: default 364
    //                   0 440
    //                   1 473
    //                   2 501;
           goto _L14 _L15 _L16 _L17
_L14:
        obj1 = obj;
_L6:
        if (obj1 != null)
        {
            startActivity(((Intent) (obj1)));
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (s.equals("android.intent.action.VIEW"))
        {
            byte0 = 0;
        }
          goto _L10
_L12:
        if (s.equals("co.vine.android.ACTIVITY_NOTIFICATION_PRESSED"))
        {
            byte0 = 1;
        }
          goto _L10
_L13:
        if (s.equals("co.vine.android.MESSAGE_NOTIFICATION_PRESSED"))
        {
            byte0 = 2;
        }
          goto _L10
_L15:
        ((Intent) (obj)).setData(intent.getData());
        obj1 = obj;
        if (intent.hasExtra("is_new_user"))
        {
            ((Intent) (obj)).putExtra("is_new_user", true);
            obj1 = obj;
        }
          goto _L6
_L16:
        ((Intent) (obj)).setAction(s);
        mAppController.clearPushNotifications(1);
        ((Intent) (obj)).setFlags(0x4000000);
        obj1 = obj;
          goto _L6
_L17:
        ((Intent) (obj)).setAction(s);
        ((Intent) (obj)).setFlags(0);
        obj1 = obj;
          goto _L6
_L8:
        obj1 = appimpl.getRecordingIntent(this, 0x20000, (new StringBuilder()).append("StartActivity: ").append(getCallingActivity()).toString());
          goto _L6
_L2:
        mAppController.fetchClientFlags(false);
        return false;
        if (true) goto _L19; else goto _L18
_L18:
    }

    public static void toStart(Context context)
    {
        toStart(context, false);
    }

    public static void toStart(Context context, boolean flag)
    {
        Intent intent = getStartIntent(context);
        if (flag)
        {
            intent.putExtra("is_new_user", flag);
        }
        context.startActivity(intent);
        if (BuildUtil.isExplore() && !(context instanceof StartActivity))
        {
            broadcastFinish(context);
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 1)
        {
            loginCheckTwitter(intent, false);
            mAuthIntent = intent;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131362338 2131362341: default 36
    //                   2131362338 37
    //                   2131362339 36
    //                   2131362340 62
    //                   2131362341 95;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        return;
_L2:
        if (mLoginRequest)
        {
            startActivity(LoginActivity.getIntentWithFinish(this));
            return;
        } else
        {
            startActivity(LoginActivity.getIntent(this));
            return;
        }
_L3:
        view = new Bundle();
        if (mLoginRequest)
        {
            view.putBoolean("finish", true);
        }
        startActivity(SignUpPagerActivity.getIntent(this, view));
        return;
_L4:
        if (mTwitter.startAuthActivityForResult(this, 1)) goto _L1; else goto _L5
_L5:
        if (mLoginRequest)
        {
            startActivity(LoginTwitterActivity.getIntentWithFinish(this));
            return;
        }
        try
        {
            startActivity(LoginTwitterActivity.getIntent(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            if (mLoginRequest)
            {
                startActivity(LoginTwitterActivity.getIntentWithFinish(this));
                return;
            } else
            {
                startActivity(LoginTwitterActivity.getIntent(this));
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030098, false);
        if ((getIntent().getFlags() & 0x400000) == 0 || !"android.intent.action.MAIN".equals(getIntent().getAction())) goto _L2; else goto _L1
_L1:
        finish();
_L4:
        return;
_L2:
        if (android.os.Build.VERSION.SDK_INT <= 14)
        {
            ActionBar actionbar = getSupportActionBar();
            if (actionbar != null)
            {
                actionbar.hide();
            }
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        if (bundle.containsKey("auth_intent"))
        {
            mAuthIntent = (Intent)bundle.getParcelable("auth_intent");
            loginCheckTwitter(mAuthIntent, false);
        }
        boolean flag = processIntent(getIntent());
        if (flag) goto _L4; else goto _L3
_L3:
        StyleSpan stylespan;
        StyleSpan astylespan[];
        Spanned spanned;
        Object obj;
        Spannable spannable;
        int i;
        int j;
        try
        {
            if (Util.getActiveNetworkType(this) == 0)
            {
                mAppController.fetchClientFlags(false);
            }
            stylespan = new StyleSpan(1);
            astylespan = new StyleSpan[1];
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            SharedPreferences sharedpreferences = Util.getDefaultSharedPrefs(this);
            CrashUtil.logException(bundle, "pref_log_startup_fail: {}.", new Object[] {
                Integer.valueOf(sharedpreferences.getInt("pref_log_startup_fail", 0))
            });
            Util.showCenteredToast(this, 0x7f0e022e);
            sharedpreferences.edit().putInt("pref_log_startup_fail", 1).commit();
            finish();
            return;
        }
        astylespan[0] = stylespan;
        obj = (Button)findViewById(0x7f0a0224);
        ((Button) (obj)).setText(Util.getSpannedText(astylespan, getString(0x7f0e022c), '"'));
        ((Button) (obj)).setOnClickListener(this);
        obj = (Button)findViewById(0x7f0a0225);
        ((Button) (obj)).setText(Util.getSpannedText(astylespan, getString(0x7f0e022d), '"'));
        ((Button) (obj)).setOnClickListener(this);
        obj = (TextView)findViewById(0x7f0a0222);
        ((TextView) (obj)).setMovementMethod(LinkMovementMethod.getInstance());
        spanned = Util.getSpannedText(astylespan, getString(0x7f0e022a), '"');
        ((TextView) (obj)).setText(spanned);
        spannable = (Spannable)((TextView) (obj)).getText();
        i = spanned.getSpanStart(stylespan);
        j = spanned.getSpanEnd(stylespan);
        Util.safeSetSpan(spannable, new ForegroundColorSpan(getResources().getColor(0x7f090083)), i, j, 33);
        ((TextView) (obj)).setOnClickListener(this);
        mTwitter = mAppController.getTwitter();
        mVideoView = (VideoViewInterface)findViewById(0x7f0a0221);
        mVideoView.setKeepScreenOn(true);
        mVideoView.setLooping(true);
        if (SystemUtil.isNormalVideoPlayable(this) != co.vine.android.util.SystemUtil.PrefBooleanState.UNKNOWN)
        {
            break MISSING_BLOCK_LABEL_631;
        }
        mVideoView.setVideoPathDirect(SystemUtil.getPathFromResourceRaw(this, 0x7f060002));
        mVideoView.setOnErrorListener(new co.vine.android.player.VideoViewInterface.OnErrorListener() {

            final StartActivity this$0;

            public boolean onError(VideoViewInterface videoviewinterface, int k, int l)
            {
                SLog.d("Video test failed.");
                SystemUtil.setNormalVideoPlayable(getApplicationContext(), false);
                mHandler.postDelayed(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        openStartVideo();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }, 50L);
                return true;
            }

            
            {
                this$0 = StartActivity.this;
                super();
            }
        });
        mVideoView.setOnPreparedListener(new co.vine.android.player.VideoViewInterface.OnPreparedListener() {

            final StartActivity this$0;

            public void onPrepared(VideoViewInterface videoviewinterface)
            {
                SystemUtil.setNormalVideoPlayable(getApplicationContext(), true);
                mVideoView.start();
                SLog.d("Video test completed, assuming success, may change later.");
            }

            
            {
                this$0 = StartActivity.this;
                super();
            }
        });
_L5:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_450;
        }
        if (bundle.containsKey("state_p"))
        {
            mStopPosition = bundle.getInt("state_p");
        }
        mAppSessionListener = new StartSessionListener();
        mAppController = AppController.getInstance(this);
        Util.getDefaultSharedPrefs(this).edit().putInt("pref_log_startup_fail", 0).commit();
        return;
        bundle;
        CrashUtil.logException(bundle, (new StringBuilder()).append("Failed to process intent: ").append(getCallingPackage()).append(" - ").append(getIntent().getAction()).append(" - ").append(getCallingActivity()).toString(), new Object[0]);
        Util.showCenteredToast(this, 0x7f0e022e);
        finish();
        return;
        openStartVideo();
          goto _L5
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (mVideoView != null)
        {
            mVideoView.suspend();
        }
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        i;
        JVM INSTR tableswitch 1 1: default 20
    //                   1 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        switch (j)
        {
        default:
            return;

        case -1: 
            break;
        }
        if (mAuthIntent != null)
        {
            loginCheckTwitter(mAuthIntent, true);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onNewIntent(Intent intent)
    {
        processIntent(intent);
    }

    protected void onPause()
    {
        super.onPause();
        if (mVideoView != null)
        {
            mStopPosition = mVideoView.getCurrentPosition();
            mVideoView.pause();
        }
        dismissDialog();
    }

    protected void onResume()
    {
        super.onResume();
        if (mVideoView != null)
        {
            mVideoView.seekTo(mStopPosition);
            if (mVideoView.isPlaying())
            {
                mVideoView.resume();
            } else
            {
                mVideoView.start();
            }
        }
        if (mAppController.isLoggedIn() && mLoginRequest)
        {
            setResult(-1);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mAuthIntent != null)
        {
            bundle.putParcelable("auth_intent", mAuthIntent);
        }
    }

    protected void onStop()
    {
        FlurryUtils.trackLockOutSessionCount();
        super.onStop();
    }




}
