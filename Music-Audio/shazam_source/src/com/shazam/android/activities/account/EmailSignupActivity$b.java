// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import com.shazam.android.ad.e;
import com.shazam.l.a.b;
import com.shazam.model.account.EmailValidator;

// Referenced classes of package com.shazam.android.activities.account:
//            EmailSignupActivity

private final class <init> extends e
{

    final EmailSignupActivity a;

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        b b1 = EmailSignupActivity.a(a);
        charsequence = charsequence.toString();
        if (b1.b.a(charsequence))
        {
            b1.a.a();
            b1.a.d();
            b1.g = charsequence;
            return;
        } else
        {
            b1.a.b();
            b1.a.c();
            return;
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
