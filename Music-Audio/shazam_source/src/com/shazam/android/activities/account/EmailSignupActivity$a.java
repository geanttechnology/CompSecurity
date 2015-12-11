// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

// Referenced classes of package com.shazam.android.activities.account:
//            EmailSignupActivity

private final class <init>
    implements android.widget.kListener
{

    final EmailSignupActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        EmailSignupActivity.b(a).requestFocus();
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
