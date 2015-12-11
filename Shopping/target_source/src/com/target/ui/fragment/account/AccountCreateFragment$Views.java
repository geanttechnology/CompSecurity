// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.target.ui.view.a;
import com.target.ui.view.account.AccountCreationEmailView;
import com.target.ui.view.account.AccountCreationHeaderView;
import com.target.ui.view.account.AccountCreationPasswordView;
import com.target.ui.view.common.NameView;

// Referenced classes of package com.target.ui.fragment.account:
//            AccountCreateFragment

static class  extends a
{

    Button createButton;
    AccountCreationEmailView email;
    com.target.ui.view.common.a emailOptOut;
    AccountCreationHeaderView header;
    NameView name;
    AccountCreationPasswordView password;
    ScrollView scrollContainer;
    TextView termsAndConditionText;

    (View view)
    {
        super(view);
    }
}
