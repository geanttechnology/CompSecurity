// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.SharedPreferences;
import com.groupon.util.Function0;
import com.groupon.util.LoginUtil;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            GrouponSSO

class val.username
    implements Function0
{

    final GrouponSSO this$0;
    final String val$username;

    public void execute()
    {
        setResult(-1);
        GrouponSSO.access$300(GrouponSSO.this).edit().putString("emailPrefill", val$username).apply();
        refreshCachedCart();
        GrouponSSO.access$400(GrouponSSO.this).startNextActivity(next);
        finish();
        ssoSignInButton.stopSpinning();
    }

    Editor()
    {
        this$0 = final_grouponsso;
        val$username = String.this;
        super();
    }
}
