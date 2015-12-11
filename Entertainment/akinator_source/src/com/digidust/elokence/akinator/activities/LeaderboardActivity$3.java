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
//            LeaderboardActivity

class this._cls0
    implements FacebookCallback
{

    final LeaderboardActivity this$0;

    public void onCancel()
    {
        disableAdOneTime();
        AkLog.d("LeaderboardActivity", "Facebook log cancel");
        LeaderboardActivity.access$202(LeaderboardActivity.this, false);
    }

    public void onError(FacebookException facebookexception)
    {
        disableAdOneTime();
        AkLog.d("LeaderboardActivity", (new StringBuilder()).append("Facebook log error  : ").append(facebookexception.toString()).toString());
        LeaderboardActivity.access$202(LeaderboardActivity.this, false);
    }

    public void onSuccess(LoginResult loginresult)
    {
        disableAdOneTime();
        AkLog.d("LeaderboardActivity", "Facebook log Ok");
        LeaderboardActivity.access$202(LeaderboardActivity.this, true);
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
        this$0 = LeaderboardActivity.this;
        super();
    }
}
