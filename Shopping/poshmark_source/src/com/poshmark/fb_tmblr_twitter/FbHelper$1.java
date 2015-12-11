// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.http.api.PMApi;
import com.poshmark.utils.DateUtils;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            FbHelper

class this._cls0 extends AccessTokenTracker
{

    final FbHelper this$0;

    protected void onCurrentAccessTokenChanged(AccessToken accesstoken, AccessToken accesstoken1)
    {
        if (!handleTokenChange.get() || accesstoken == null) goto _L2; else goto _L1
_L1:
        if (accesstoken1 != null) goto _L4; else goto _L3
_L3:
        PMApi.unlinkExternalService("fb", null);
        PMApplicationSession.GetPMSession().clearFacebookInfo();
_L6:
        handleTokenChange.set(false);
_L2:
        return;
_L4:
        accesstoken = FbHelper.access$100(FbHelper.this);
        if (accesstoken != null && FbHelper.access$200(FbHelper.this, accesstoken, accesstoken1))
        {
            accesstoken = FbHelper.access$300(FbHelper.this, accesstoken1);
            PMApplicationSession.GetPMSession().updateFacebookData(accesstoken);
            accesstoken = DateUtils.getStringFromUTCDate(accesstoken1.getExpires());
            PMApi.saveExternalServiceInfo("fb", accesstoken1.getToken(), accesstoken, null, null);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    sion()
    {
        this$0 = FbHelper.this;
        super();
    }
}
