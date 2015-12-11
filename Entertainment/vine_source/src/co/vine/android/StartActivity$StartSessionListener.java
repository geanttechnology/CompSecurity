// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import co.vine.android.api.VineLogin;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import co.vine.android.widgets.PromptDialogSupportFragment;

// Referenced classes of package co.vine.android:
//            StartActivity, VineLoggingException, SignUpPagerActivity

class this._cls0 extends AppSessionListener
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
            if (StartActivity.access$300(StartActivity.this))
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
        if (j == co.vine.android.api.EACTIVATED.EACTIVATED)
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

    ()
    {
        this$0 = StartActivity.this;
        super();
    }
}
