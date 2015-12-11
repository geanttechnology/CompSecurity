// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import co.vine.android.api.VineLogin;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import co.vine.android.widgets.PromptDialogSupportFragment;

// Referenced classes of package co.vine.android:
//            LoginTwitterActivity, VineLoggingException, StartActivity, SignUpPagerActivity

class this._cls0 extends AppSessionListener
{

    final LoginTwitterActivity this$0;

    public void onCheckTwitterComplete(String s, int i, String s1, int j, boolean flag, VineUser vineuser, VineLogin vinelogin)
    {
        if (!flag || i != 200)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        mAppController.loginComplete(mAppController.getActiveSession(), i, vineuser.username, null, vinelogin, vineuser.avatarUrl);
        if (LoginTwitterActivity.access$100(LoginTwitterActivity.this))
        {
            finish();
            return;
        }
        try
        {
            StartActivity.toStart(LoginTwitterActivity.this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Util.showCenteredToast(LoginTwitterActivity.this, 0x7f0e00d7);
        }
        CrashUtil.logException(s);
        finish();
        return;
        dismissDialog();
        if (i == 400)
        {
            s = new Bundle();
            s.putParcelable("user", vinelogin);
            startActivity(SignUpPagerActivity.getIntent(LoginTwitterActivity.this, s));
            return;
        }
        if (j == co.vine.android.api.TED.TED)
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
            Util.showCenteredToast(LoginTwitterActivity.this, s1);
            return;
        }
    }

    public void onTwitterxAuthComplete(String s, int i, String s1, VineLogin vinelogin)
    {
        if (LoginTwitterActivity.access$100(LoginTwitterActivity.this))
        {
            if (i == 200)
            {
                if (!mAppController.isLoggedIn())
                {
                    mAppController.loginCheckTwitter(vinelogin.twitterUsername, vinelogin.twitterToken, vinelogin.twitterSecret, vinelogin.twitterUserId, false);
                    return;
                } else
                {
                    s = new Intent();
                    s.putExtra("token", vinelogin.twitterToken);
                    s.putExtra("secret", vinelogin.twitterSecret);
                    s.putExtra("user_id", vinelogin.twitterUserId);
                    s.putExtra("screen_name", vinelogin.twitterUsername);
                    setResult(-1, s);
                    finish();
                    return;
                }
            } else
            {
                dismissDialog();
                Util.showCenteredToast(LoginTwitterActivity.this, 0x7f0e00f2);
                return;
            }
        }
        if (i == 200 && vinelogin != null)
        {
            LoginTwitterActivity.access$202(LoginTwitterActivity.this, vinelogin);
            mAppController.loginCheckTwitter(vinelogin.twitterUsername, vinelogin.twitterToken, vinelogin.twitterSecret, vinelogin.twitterUserId, false);
            return;
        }
        dismissDialog();
        if (!TextUtils.isEmpty(s1))
        {
            Util.showCenteredToast(LoginTwitterActivity.this, s1);
            return;
        } else
        {
            Util.showCenteredToast(LoginTwitterActivity.this, 0x7f0e00d0);
            return;
        }
    }

    ()
    {
        this$0 = LoginTwitterActivity.this;
        super();
    }
}
