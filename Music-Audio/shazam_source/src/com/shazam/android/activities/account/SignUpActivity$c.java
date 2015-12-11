// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.app.AlertDialog;
import android.view.View;
import com.shazam.l.a.c;

// Referenced classes of package com.shazam.android.activities.account:
//            SignUpActivity

private final class <init>
    implements android.view.ner
{

    final SignUpActivity a;

    public final void onClick(View view)
    {
        com.shazam.android.activities.account.SignUpActivity.c(a).dismiss();
        SignUpActivity.b(a).d();
    }

    private (SignUpActivity signupactivity)
    {
        a = signupactivity;
        super();
    }

    a(SignUpActivity signupactivity, byte byte0)
    {
        this(signupactivity);
    }
}
