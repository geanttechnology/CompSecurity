// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.Preference;
import com.groupon.http.GrouponOkHttpClient;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SecretProxyFragment

private class <init>
    implements android.preference.r
{

    final SecretProxyFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        preference = Strings.toString(obj);
        obj = ((SharedPreferences)prefs.get()).getString("proxyPort", "3128");
        ((GrouponOkHttpClient)grouponOkHttpClient.get()).configureProxyAsync(preference, ((String) (obj)), new it>(SecretProxyFragment.this, preference), new this._cls0(SecretProxyFragment.this, true, false));
        return true;
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
