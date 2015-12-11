// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g.b:
//            k, w

final class v
    implements FacebookCallback
{

    private k a;

    private v(k k1)
    {
        a = k1;
        super();
    }

    v(k k1, byte byte0)
    {
        this(k1);
    }

    public final void onCancel()
    {
        if (AccessToken.getCurrentAccessToken() != null && k.i(a))
        {
            k.h(a).a();
        }
    }

    public final void onError(FacebookException facebookexception)
    {
        k.h(a).a(facebookexception);
    }

    public final void onSuccess(Object obj)
    {
        obj = (LoginResult)obj;
        if (((LoginResult) (obj)).getAccessToken() != null)
        {
            com.offerup.android.tracker.a.b("SignupLogin_Facebook-Button_success");
            k.h(a).a(((LoginResult) (obj)).getAccessToken());
        }
    }
}
