// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.shazam.android.activities.account:
//            EmailSignupActivity

private final class <init>
    implements android.view.nt.EmailSignupActivity.d, android.widget.nListener
{

    final EmailSignupActivity a;

    public final void onClick(View view)
    {
        EmailSignupActivity.d(a);
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 5)
        {
            if (EmailSignupActivity.c(a).isEnabled())
            {
                EmailSignupActivity.d(a);
            }
            return true;
        } else
        {
            return false;
        }
    }

    private A(EmailSignupActivity emailsignupactivity)
    {
        a = emailsignupactivity;
        super();
    }

    a(EmailSignupActivity emailsignupactivity, byte byte0)
    {
        this(emailsignupactivity);
    }
}
