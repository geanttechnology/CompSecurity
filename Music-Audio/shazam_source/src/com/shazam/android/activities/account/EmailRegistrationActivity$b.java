// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import com.shazam.android.ad.e;

// Referenced classes of package com.shazam.android.activities.account:
//            EmailRegistrationActivity

private final class <init> extends e
{

    final EmailRegistrationActivity a;

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        if (EmailRegistrationActivity.a(a))
        {
            EmailRegistrationActivity.i(a);
            return;
        } else
        {
            EmailRegistrationActivity.j(a);
            return;
        }
    }

    private (EmailRegistrationActivity emailregistrationactivity)
    {
        a = emailregistrationactivity;
        super();
    }

    a(EmailRegistrationActivity emailregistrationactivity, byte byte0)
    {
        this(emailregistrationactivity);
    }
}
