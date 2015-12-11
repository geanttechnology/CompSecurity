// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import com.groupon.util.Function0;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretProxyFragment

private class <init>
    implements Function0
{

    final SecretProxyFragment this$0;

    public void execute()
    {
        ((SharedPreferences)prefs.get()).edit().ener("proxyIp", "10.63.9.31").ener("proxyPort", "9090").ener();
        SecretProxyFragment.access$300(SecretProxyFragment.this).setSummary("10.63.9.31");
        SecretProxyFragment.access$400(SecretProxyFragment.this).setSummary("9090");
        SecretProxyFragment.access$300(SecretProxyFragment.this).getOnPreferenceChangeListener().Change(null, "10.63.9.31");
        SecretProxyFragment.access$400(SecretProxyFragment.this).getOnPreferenceChangeListener().Change(null, "9090");
    }

    private ()
    {
        this$0 = SecretProxyFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
