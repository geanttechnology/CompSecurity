// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.Preference;
import com.groupon.http.GrouponOkHttpClient;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretLoggingFragment

private class <init>
    implements android.preference.r
{

    final SecretLoggingFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        ((GrouponOkHttpClient)grouponOkHttpClient.get()).configureProxyAsync(((SharedPreferences)prefs.get()).getString("proxyIp", ""), ((SharedPreferences)prefs.get()).getString("proxyPort", "3128"), new it>(SecretLoggingFragment.this, ((Boolean)obj).booleanValue()), null);
        return true;
    }

    private ()
    {
        this$0 = SecretLoggingFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
