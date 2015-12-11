// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.utils.DateUtils;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            FbHelper, FBConnectCallback

class this._cls0
    implements FacebookCallback
{

    final FbHelper this$0;

    public void onCancel()
    {
    }

    public void onError(FacebookException facebookexception)
    {
    }

    public void onSuccess(LoginResult loginresult)
    {
        Object obj = loginresult.getRecentlyGrantedPermissions();
        int i = FbHelper.access$400(FbHelper.this, ((java.util.Set) (obj)));
        loginresult = loginresult.getAccessToken();
        loginresult.getToken();
        obj = DateUtils.getStringFromUTCDate(loginresult.getExpires());
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            linkWithPM(loginresult.getToken(), ((String) (obj)), i);
            return;
        }
        if (FbHelper.access$500(FbHelper.this) != null)
        {
            FbHelper.access$500(FbHelper.this).success(i, loginresult.getToken(), ((String) (obj)));
            return;
        } else
        {
            FbHelper.access$600(FbHelper.this, i, loginresult.getToken(), ((String) (obj)));
            return;
        }
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((LoginResult)obj);
    }

    llback()
    {
        this$0 = FbHelper.this;
        super();
    }
}
