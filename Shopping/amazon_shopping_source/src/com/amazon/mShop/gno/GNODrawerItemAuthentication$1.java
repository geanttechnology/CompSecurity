// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemAuthentication

class val.callingActivity
    implements Runnable
{

    final GNODrawerItemAuthentication this$0;
    final AmazonActivity val$callingActivity;

    public void run()
    {
        if (GNODrawerItemAuthentication.access$100(GNODrawerItemAuthentication.this) == com.amazon.mShop.android.lib.)
        {
            ActivityUtils.startLoginActivity(val$callingActivity, "gno", true, null, new int[0]);
        } else
        {
            if (GNODrawerItemAuthentication.access$100(GNODrawerItemAuthentication.this) == com.amazon.mShop.android.lib.)
            {
                ActivityUtils.startLogoutActivity(val$callingActivity);
                return;
            }
            if (GNODrawerItemAuthentication.access$100(GNODrawerItemAuthentication.this) == com.amazon.mShop.android.lib.)
            {
                SSOUtil.getCurrentIdentityType().handleSSOLogin(val$callingActivity, true, false, false, "gno");
                return;
            }
            if (GNODrawerItemAuthentication.access$100(GNODrawerItemAuthentication.this) == com.amazon.mShop.android.lib.)
            {
                SSOUtil.getCurrentIdentityType().handleSSOLogout(val$callingActivity);
                return;
            }
        }
    }

    ()
    {
        this$0 = final_gnodraweritemauthentication;
        val$callingActivity = AmazonActivity.this;
        super();
    }
}
