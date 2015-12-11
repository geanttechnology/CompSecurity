// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import com.ebay.common.model.UserDetail;
import com.ebay.mobile.MyApp;

// Referenced classes of package com.ebay.common:
//            UserCache, Preferences

class val.profile
    implements Runnable
{

    final val.profile this$0;
    final UserDetail val$profile;

    public void run()
    {
        cess._mth800(this._cls0.this).tails(val$profile);
        Preferences preferences = MyApp.getPrefs();
        preferences.setPayPalAccountStatus(val$profile.payPalAccountStatus);
        preferences.setUserIsPpa(val$profile.isPpa);
    }

    ()
    {
        this$0 = final_;
        val$profile = UserDetail.this;
        super();
    }
}
