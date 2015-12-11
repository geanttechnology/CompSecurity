// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity

class a
    implements FacebookCallback
{

    final GoodJobActivity a;

    public void a(LoginResult loginresult)
    {
        GoodJobActivity.a(a);
    }

    public void onCancel()
    {
    }

    public void onError(FacebookException facebookexception)
    {
        aa.c(GoodJobActivity.d(), "Facebook Error", facebookexception);
    }

    public void onSuccess(Object obj)
    {
        a((LoginResult)obj);
    }

    _cls9(GoodJobActivity goodjobactivity)
    {
        a = goodjobactivity;
        super();
    }
}
