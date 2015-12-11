// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.TextUtils;
import android.view.MenuItem;
import co.vine.android.api.TwitterUser;
import co.vine.android.api.VineError;
import co.vine.android.api.VineLogin;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;
import co.vine.android.widget.ConfigurableViewPager;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, FindFriendsNUXActivity, VineLoggingException, ConfirmationFlowActivity, 
//            SignUpNameAvatarFragment, SignUpDetailsFragment

public class SignUpPagerActivity extends BaseControllerActionBarActivity
{
    class SignUpListener extends AppSessionListener
    {

        final SignUpPagerActivity this$0;

        public void onCheckTwitterComplete(String s, int i, String s1, int j, boolean flag, VineUser vineuser, VineLogin vinelogin)
        {
            if (flag && i == 200)
            {
                try
                {
                    mAppController.loginComplete(mAppController.getActiveSession(), i, vineuser.username, null, vinelogin, vineuser.avatarUrl);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Util.showCenteredToast(SignUpPagerActivity.this, 0x7f0e00d7);
                    CrashUtil.logException(s);
                    dismissDialog();
                    finish();
                    return;
                }
                dismissDialog();
                if (mFinish)
                {
                    setResult(-1);
                    finish();
                    return;
                }
                if (!TextUtils.isEmpty(mPhone))
                {
                    ConfirmationFlowActivity.requestPhoneVerification(mAppController, mPhone);
                    startActivityForResult(ConfirmationFlowActivity.getIntent(SignUpPagerActivity.this, mPhone, true), 1653);
                    return;
                } else
                {
                    s = new Intent(SignUpPagerActivity.this, co/vine/android/FindFriendsNUXActivity);
                    s.putExtra("is_twitter_reg", true);
                    startActivity(s);
                    return;
                }
            }
            if (!flag && i == 400)
            {
                s = new Bundle();
                s.putParcelable("user", vinelogin);
                startActivity(SignUpPagerActivity.getIntent(SignUpPagerActivity.this, s));
                return;
            } else
            {
                Util.showCenteredToast(SignUpPagerActivity.this, s1);
                return;
            }
        }

        public void onLoginComplete(Session session, String s, int i, String s1, int j, VineLogin vinelogin)
        {
            dismissDialog();
            if (i == 200)
            {
                Util.showCenteredToast(SignUpPagerActivity.this, getString(0x7f0e0126));
                if (mFinish)
                {
                    setResult(-1);
                    finish();
                    return;
                }
                if (!TextUtils.isEmpty(mPhone))
                {
                    ConfirmationFlowActivity.requestPhoneVerification(mAppController, mPhone);
                    startActivityForResult(ConfirmationFlowActivity.getIntent(SignUpPagerActivity.this, mPhone, true), 1653);
                    return;
                } else
                {
                    FindFriendsNUXActivity.start(SignUpPagerActivity.this);
                    mAppController.getEditions();
                    return;
                }
            }
            if (!TextUtils.isEmpty(s1))
            {
                Util.showCenteredToast(SignUpPagerActivity.this, s1);
                return;
            } else
            {
                Util.showCenteredToast(SignUpPagerActivity.this, 0x7f0e00cd);
                return;
            }
        }

        public void onSignUpComplete(String s, int i, String s1, VineLogin vinelogin, String s2, String s3, String s4)
        {
            if (i == 200 && vinelogin != null && vinelogin.userId > 0L)
            {
                switch (vinelogin.loginType)
                {
                default:
                    return;

                case 1: // '\001'
                    try
                    {
                        mAppController.loginComplete(mAppController.getActiveSession(), i, s2, s3, vinelogin, s4);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        dismissDialog();
                        Util.showCenteredToast(SignUpPagerActivity.this, 0x7f0e00d7);
                        CrashUtil.logException(s);
                        finish();
                        return;
                    }
                    dismissDialog();
                    if (mFinish)
                    {
                        setResult(-1);
                        finish();
                        return;
                    }
                    if (!TextUtils.isEmpty(mPhone))
                    {
                        ConfirmationFlowActivity.requestPhoneVerification(mAppController, mPhone);
                        startActivityForResult(ConfirmationFlowActivity.getIntent(SignUpPagerActivity.this, mPhone, true), 1653);
                        return;
                    } else
                    {
                        FindFriendsNUXActivity.start(SignUpPagerActivity.this);
                        return;
                    }

                case 2: // '\002'
                    break;
                }
                if (mVineLogin != null)
                {
                    s = new ProgressDialog(SignUpPagerActivity.this, 0x7f0f0037);
                    mProgressDialog = s;
                    s.setProgressStyle(0);
                    s.setMessage(getString(0x7f0e0221));
                    s.show();
                    mAppController.loginCheckTwitter(mVineLogin.twitterUsername, mVineLogin.twitterToken, mVineLogin.twitterSecret, mVineLogin.userId, false);
                    return;
                } else
                {
                    FlurryUtils.onSignupFailure(true, new VineError(-1, "mVineLogin is null."), -1);
                    finish();
                    return;
                }
            }
            dismissDialog();
            if (!TextUtils.isEmpty(s1))
            {
                Util.showCenteredToast(SignUpPagerActivity.this, s1);
                return;
            } else
            {
                Util.showCenteredToast(SignUpPagerActivity.this, 0x7f0e00cd);
                return;
            }
        }

        SignUpListener()
        {
            this$0 = SignUpPagerActivity.this;
            super();
        }
    }

    private class SignUpPagerAdapter extends FragmentStatePagerAdapter
    {

        final SignUpPagerActivity this$0;

        public int getCount()
        {
            return 2;
        }

        public Fragment getItem(int i)
        {
            switch (i)
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("no pager found for ").append(i).toString());

            case 0: // '\0'
                SignUpNameAvatarFragment signupnameavatarfragment = new SignUpNameAvatarFragment();
                if (mVineLogin != null)
                {
                    signupnameavatarfragment.setArguments(getIntent().getExtras());
                }
                mAvatarFrag = new WeakReference(signupnameavatarfragment);
                return signupnameavatarfragment;

            case 1: // '\001'
                SignUpDetailsFragment signupdetailsfragment = new SignUpDetailsFragment();
                mDetailsFrag = new WeakReference(signupdetailsfragment);
                return signupdetailsfragment;
            }
        }

        public SignUpPagerAdapter(FragmentManager fragmentmanager)
        {
            this$0 = SignUpPagerActivity.this;
            super(fragmentmanager);
        }
    }


    public static final String EXTRA_FINISH = "finish";
    public static final String EXTRA_LOGIN = "user";
    public static final int FLOW_STEP_DETAILS = 1;
    public static final int FLOW_STEP_NAME_AVATAR = 0;
    private static final int NUM_PAGES = 2;
    public static final int REQUEST_CODE_CONFIRM_PHONE = 1653;
    private static final String STATE_LOGIN = "s_login";
    private static final String STATE_NAME = "s_name";
    private static final String STATE_PASSWORD = "s_password";
    private static final String STATE_PHONE = "s_phone";
    private static final String STATE_PROFILE = "s_profile";
    private WeakReference mAvatarFrag;
    private WeakReference mDetailsFrag;
    private boolean mFinish;
    private String mLogin;
    private String mName;
    private ConfigurableViewPager mPager;
    private String mPassword;
    private String mPhone;
    private Uri mProfile;
    private TwitterUser mTwitterUser;
    private VineLogin mVineLogin;

    public SignUpPagerActivity()
    {
    }

    public static Intent getIntent(Context context, Bundle bundle)
    {
        context = new Intent(context, co/vine/android/SignUpPagerActivity);
        if (bundle != null)
        {
            context.putExtras(bundle);
        }
        return context;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1653 1653: default 20
    //                   1653 49;
           goto _L1 _L2
_L1:
        mPager.getCurrentItem();
        JVM INSTR tableswitch 0 1: default 48
    //                   0 54
    //                   1 87;
           goto _L3 _L4 _L5
_L3:
        return;
_L2:
        FindFriendsNUXActivity.start(this);
        return;
_L4:
        Fragment fragment;
        if (mAvatarFrag != null && (fragment = (Fragment)mAvatarFrag.get()) != null)
        {
            fragment.onActivityResult(i, j, intent);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mDetailsFrag != null)
        {
            Fragment fragment1 = (Fragment)mDetailsFrag.get();
            if (fragment1 != null)
            {
                fragment1.onActivityResult(i, j, intent);
                return;
            }
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    public void onBackPressed()
    {
        if (mPager.getCurrentItem() == 0)
        {
            super.onBackPressed();
            return;
        } else
        {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030093, false);
        Intent intent = getIntent();
        if (intent != null)
        {
            mFinish = intent.getBooleanExtra("finish", false);
        }
        mPager = (ConfigurableViewPager)findViewById(0x7f0a00da);
        mPager.setSwipingEnabled(false);
        mPager.setAdapter(new SignUpPagerAdapter(getSupportFragmentManager()));
        mAppSessionListener = new SignUpListener();
        mVineLogin = (VineLogin)getIntent().getParcelableExtra("user");
        if (bundle != null)
        {
            mLogin = bundle.getString("s_login");
            mName = bundle.getString("s_name");
            mPassword = bundle.getString("s_password");
            mPhone = bundle.getString("s_phone");
            mProfile = (Uri)bundle.getParcelable("s_profile");
        }
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(true));
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            break;
        }
        return true;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("s_login", mLogin);
        bundle.putString("s_password", mPassword);
        bundle.putString("s_name", mName);
        bundle.putString("s_phone", mPhone);
        bundle.putParcelable("s_profile", mProfile);
    }

    protected void setBarTitle(int i)
    {
        setupActionBar(null, Boolean.valueOf(true), i, null);
    }

    public void setLogin(String s)
    {
        mLogin = s;
    }

    public void setName(String s)
    {
        mName = s;
    }

    public void setPassword(String s)
    {
        mPassword = s;
    }

    public void setPhone(String s)
    {
        mPhone = s;
    }

    public void setProfile(Uri uri)
    {
        mProfile = uri;
    }

    public void setTwitterUser(TwitterUser twitteruser)
    {
        mTwitterUser = twitteruser;
    }

    protected void toNextStep()
    {
        switch (mPager.getCurrentItem())
        {
        default:
            return;

        case 0: // '\0'
            if (mTwitterUser != null)
            {
                ProgressDialog progressdialog = new ProgressDialog(this, 0x7f0f0037);
                progressdialog.setMessage(getString(0x7f0e0129));
                progressdialog.setProgress(0);
                try
                {
                    progressdialog.show();
                }
                catch (Exception exception1) { }
                mProgressDialog = progressdialog;
                mAppController.signUp(null, null, mName, mPhone, mProfile, mTwitterUser, mVineLogin);
                return;
            } else
            {
                mPager.setCurrentItem(1);
                return;
            }

        case 1: // '\001'
            progressdialog = new ProgressDialog(this, 0x7f0f0037);
            mProgressDialog = progressdialog;
            progressdialog.setProgressStyle(0);
            progressdialog.setMessage(getString(0x7f0e0221));
            break;
        }
        try
        {
            progressdialog.show();
        }
        catch (Exception exception) { }
        mAppController.signUp(mLogin, mPassword, mName, mPhone, mProfile, null, null);
    }



/*
    static WeakReference access$102(SignUpPagerActivity signuppageractivity, WeakReference weakreference)
    {
        signuppageractivity.mAvatarFrag = weakreference;
        return weakreference;
    }

*/


/*
    static WeakReference access$202(SignUpPagerActivity signuppageractivity, WeakReference weakreference)
    {
        signuppageractivity.mDetailsFrag = weakreference;
        return weakreference;
    }

*/


}
