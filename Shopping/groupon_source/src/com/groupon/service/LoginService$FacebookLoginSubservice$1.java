// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            LoginService

class val.onException
    implements FacebookCallback
{

    final onSuccess this$0;
    final Function0 val$onCancel;
    final Function1 val$onException;
    final Function0 val$onSuccess;

    public void onCancel()
    {
        Ln.d("FACEBOOK: login CANCEL", new Object[0]);
        val$onCancel.execute();
    }

    public void onError(FacebookException facebookexception)
    {
        Ln.d("FACEBOOK: login ERROR", new Object[0]);
        val$onException.execute(facebookexception);
    }

    public void onSuccess(LoginResult loginresult)
    {
        Ln.d("FACEBOOK: login SUCCESS", new Object[0]);
        loginresult = loginresult.getAccessToken();
        cess._mth1000(this._cls0.this, loginresult, val$onSuccess, val$onCancel, val$onException);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((LoginResult)obj);
    }

    ()
    {
        this$0 = final_;
        val$onSuccess = function0;
        val$onCancel = function0_1;
        val$onException = Function1.this;
        super();
    }
}
