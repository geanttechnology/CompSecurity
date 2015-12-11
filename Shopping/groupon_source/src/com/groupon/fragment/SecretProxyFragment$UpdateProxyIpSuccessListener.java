// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import com.groupon.service.LoginService;
import com.groupon.util.Function0;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretProxyFragment

private class newProxyIp
    implements Function0
{

    private String newProxyIp;
    final SecretProxyFragment this$0;

    public void execute()
    {
        SecretProxyFragment.access$300(SecretProxyFragment.this).setSummary(newProxyIp);
        ((SharedPreferences)prefs.get()).edit().newProxyIp("proxyIp", newProxyIp).newProxyIp();
        ((LoginService)loginService.get()).logout();
    }

    public (String s)
    {
        this$0 = SecretProxyFragment.this;
        super();
        newProxyIp = s;
    }
}
