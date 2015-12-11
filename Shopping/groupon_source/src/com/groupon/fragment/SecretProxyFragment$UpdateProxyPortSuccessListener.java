// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.EditTextPreference;
import com.groupon.service.LoginService;
import com.groupon.util.Function0;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretProxyFragment

private class newProxyPort
    implements Function0
{

    private String newProxyPort;
    final SecretProxyFragment this$0;

    public void execute()
    {
        SecretProxyFragment.access$400(SecretProxyFragment.this).setSummary(newProxyPort);
        ((LoginService)loginService.get()).logout();
    }

    public (String s)
    {
        this$0 = SecretProxyFragment.this;
        super();
        newProxyPort = s;
    }
}
