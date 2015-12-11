// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import com.shazam.android.ad.e;
import com.shazam.l.a.b;

// Referenced classes of package com.shazam.android.activities.account:
//            EmailSignupActivity

private final class <init> extends e
{

    final EmailSignupActivity a;

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        EmailSignupActivity.a(a).h = charsequence.toString();
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
