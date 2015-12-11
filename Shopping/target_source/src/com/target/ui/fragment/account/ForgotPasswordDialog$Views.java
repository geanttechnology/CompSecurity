// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.ui.view.RevealImageView;
import com.target.ui.view.a;
import com.target.ui.view.account.ForgotPasswordInputView;

// Referenced classes of package com.target.ui.fragment.account:
//            ForgotPasswordDialog

static class root extends a
{

    RevealImageView bullseye;
    ViewGroup contentContainer;
    ForgotPasswordInputView emailInput;
    TextView header;
    TextView message;
    ViewGroup progressContainer;
    View root;
    View textContainer;
    View textSentContainer;

    (View view)
    {
        super(view);
        root = view;
    }
}
