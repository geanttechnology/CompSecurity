// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.os.Bundle;
import com.digidust.elokence.akinator.factories.AkLog;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginResult;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            FacebookConnexionActivity

class this._cls0
    implements FacebookCallback
{

    final FacebookConnexionActivity this$0;

    public void onCancel()
    {
        disableAdOneTime();
        AkLog.d("FacebookConnexionActivity", "Facebook log cancel");
        FacebookConnexionActivity.access$002(FacebookConnexionActivity.this, false);
    }

    public void onError(FacebookException facebookexception)
    {
        disableAdOneTime();
        AkLog.d("FacebookConnexionActivity", (new StringBuilder()).append("Facebook log error  : ").append(facebookexception.toString()).toString());
        FacebookConnexionActivity.access$002(FacebookConnexionActivity.this, false);
    }

    public void onSuccess(LoginResult loginresult)
    {
        disableAdOneTime();
        AkLog.d("FacebookConnexionActivity", "Facebook log Ok");
        FacebookConnexionActivity.access$002(FacebookConnexionActivity.this, true);
        loginresult = new Bundle();
        loginresult.putString("fields", "birthday, gender");
    /* block-local class not found */
    class _cls1 {}

        GraphRequest graphrequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new _cls1());
        graphrequest.setParameters(loginresult);
        graphrequest.executeAsync();
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((LoginResult)obj);
    }

    _cls1()
    {
        this$0 = FacebookConnexionActivity.this;
        super();
    }
}
