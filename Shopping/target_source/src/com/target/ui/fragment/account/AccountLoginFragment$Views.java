// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import com.target.ui.view.a;
import com.target.ui.view.account.AccountCredentialsInputView;
import com.target.ui.view.account.AccountExternalLaunchView;
import com.target.ui.view.account.AccountInternalLaunchView;
import com.target.ui.view.account.AccountLoginHeaderView;
import com.target.ui.view.account.SettingsView;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountLoginFragment

static class  extends a
{

    AccountCredentialsInputView accountInputView;
    AccountExternalLaunchView externalLaunchView;
    View forgotPasswordButton;
    AccountLoginHeaderView header;
    AccountInternalLaunchView internalLaunchView;
    Button loginButton;
    ScrollView scrollContainer;
    SettingsView settingsView;

    (View view)
    {
        super(view);
    }
}
