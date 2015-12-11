// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import com.comcast.cim.model.user.AuthKeys;
import com.comcast.cim.model.user.XipUserManager;

// Referenced classes of package com.comcast.cim.android.authentication:
//            AuthenticationActivity, UserCredentials

class val.authKeys
    implements Runnable
{

    final AuthenticationActivity this$0;
    final AuthKeys val$authKeys;
    final UserCredentials val$userCredentials;

    public void run()
    {
        com.comcast.cim.model.user.XipUser xipuser = getUserManager().createUser(val$userCredentials, val$authKeys);
        AuthenticationActivity.access$100(AuthenticationActivity.this, xipuser);
        setResult(3);
        onPostSignIn();
        finish();
    }

    ()
    {
        this$0 = final_authenticationactivity;
        val$userCredentials = usercredentials;
        val$authKeys = AuthKeys.this;
        super();
    }
}
