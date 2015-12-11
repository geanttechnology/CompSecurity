// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameRewardsActivity

class a
    implements FacebookCallback
{

    final GameRewardsActivity a;

    public void a(LoginResult loginresult)
    {
        GameRewardsActivity.a(a);
    }

    public void onCancel()
    {
        GameRewardsActivity.a(a);
    }

    public void onError(FacebookException facebookexception)
    {
        aa.c(GameRewardsActivity.c(), "Facebook Error", facebookexception);
        GameRewardsActivity.a(a);
    }

    public void onSuccess(Object obj)
    {
        a((LoginResult)obj);
    }

    (GameRewardsActivity gamerewardsactivity)
    {
        a = gamerewardsactivity;
        super();
    }
}
