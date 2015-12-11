// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import co.vine.android.api.VineError;
import co.vine.android.api.VineLogin;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.FlurryUtils;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            SignUpPagerActivity, VineLoggingException, ConfirmationFlowActivity, FindFriendsNUXActivity

class this._cls0 extends AppSessionListener
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
            if (SignUpPagerActivity.access$300(SignUpPagerActivity.this))
            {
                setResult(-1);
                finish();
                return;
            }
            if (!TextUtils.isEmpty(SignUpPagerActivity.access$400(SignUpPagerActivity.this)))
            {
                ConfirmationFlowActivity.requestPhoneVerification(mAppController, SignUpPagerActivity.access$400(SignUpPagerActivity.this));
                startActivityForResult(ConfirmationFlowActivity.getIntent(SignUpPagerActivity.this, SignUpPagerActivity.access$400(SignUpPagerActivity.this), true), 1653);
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
            if (SignUpPagerActivity.access$300(SignUpPagerActivity.this))
            {
                setResult(-1);
                finish();
                return;
            }
            if (!TextUtils.isEmpty(SignUpPagerActivity.access$400(SignUpPagerActivity.this)))
            {
                ConfirmationFlowActivity.requestPhoneVerification(mAppController, SignUpPagerActivity.access$400(SignUpPagerActivity.this));
                startActivityForResult(ConfirmationFlowActivity.getIntent(SignUpPagerActivity.this, SignUpPagerActivity.access$400(SignUpPagerActivity.this), true), 1653);
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
                if (SignUpPagerActivity.access$300(SignUpPagerActivity.this))
                {
                    setResult(-1);
                    finish();
                    return;
                }
                if (!TextUtils.isEmpty(SignUpPagerActivity.access$400(SignUpPagerActivity.this)))
                {
                    ConfirmationFlowActivity.requestPhoneVerification(mAppController, SignUpPagerActivity.access$400(SignUpPagerActivity.this));
                    startActivityForResult(ConfirmationFlowActivity.getIntent(SignUpPagerActivity.this, SignUpPagerActivity.access$400(SignUpPagerActivity.this), true), 1653);
                    return;
                } else
                {
                    FindFriendsNUXActivity.start(SignUpPagerActivity.this);
                    return;
                }

            case 2: // '\002'
                break;
            }
            if (SignUpPagerActivity.access$000(SignUpPagerActivity.this) != null)
            {
                s = new ProgressDialog(SignUpPagerActivity.this, 0x7f0f0037);
                mProgressDialog = s;
                s.setProgressStyle(0);
                s.setMessage(getString(0x7f0e0221));
                s.show();
                mAppController.loginCheckTwitter(SignUpPagerActivity.access$000(SignUpPagerActivity.this).twitterUsername, SignUpPagerActivity.access$000(SignUpPagerActivity.this).twitterToken, SignUpPagerActivity.access$000(SignUpPagerActivity.this).twitterSecret, SignUpPagerActivity.access$000(SignUpPagerActivity.this).userId, false);
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

    ()
    {
        this$0 = SignUpPagerActivity.this;
        super();
    }
}
