// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import com.groupon.http.GrouponOkHttpClient;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretProxyFragment

private class <init>
    implements android.preference.r
{

    final SecretProxyFragment this$0;

    public boolean onPreferenceClick(Preference preference)
    {
        ((GrouponOkHttpClient)grouponOkHttpClient.get()).configureProxyAsync("10.63.9.31", "9090", new <init>(SecretProxyFragment.this, null), new this._cls0(SecretProxyFragment.this, true, true));
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
