// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

// Referenced classes of package com.offerup.android.activities:
//            TruYouInitActivity

final class ib
    implements FacebookCallback
{

    private TruYouInitActivity a;

    private ib(TruYouInitActivity truyouinitactivity)
    {
        a = truyouinitactivity;
        super();
    }

    ib(TruYouInitActivity truyouinitactivity, byte byte0)
    {
        this(truyouinitactivity);
    }

    public final void onCancel()
    {
    }

    public final void onError(FacebookException facebookexception)
    {
        a.a(a.getString(0x7f09017d), a.getString(0x7f09017b));
        g.a(this, facebookexception);
    }

    public final void onSuccess(Object obj)
    {
        obj = (LoginResult)obj;
        if (((LoginResult) (obj)).getAccessToken() != null)
        {
            TruYouInitActivity.a(a, ((LoginResult) (obj)).getAccessToken());
            TruYouInitActivity.a(a, true);
            TruYouInitActivity.e(a);
            return;
        } else
        {
            a.a(a.getString(0x7f09017d), a.getString(0x7f09017b));
            return;
        }
    }
}
