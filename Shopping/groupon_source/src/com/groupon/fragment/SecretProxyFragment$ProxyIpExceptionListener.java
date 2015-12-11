// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.widget.Toast;
import com.groupon.util.Function3;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import roboguice.inject.Lazy;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.fragment:
//            SecretProxyFragment

private class shouldResetProxyPortPref
    implements Function3
{

    private final boolean shouldResetProxyIpPref;
    private final boolean shouldResetProxyPortPref;
    final SecretProxyFragment this$0;

    public void execute(Exception exception, String s, String s1)
    {
        if (shouldResetProxyIpPref)
        {
            SecretProxyFragment.access$300(SecretProxyFragment.this).setSummary("");
            ((SharedPreferences)prefs.get()).edit()._mth0("proxyIp", "")._mth0();
        }
        if (shouldResetProxyPortPref)
        {
            SecretProxyFragment.access$400(SecretProxyFragment.this).setSummary("9090");
            ((SharedPreferences)prefs.get()).edit()._mth0("proxyPort", "9090")._mth0();
        }
        if (exception instanceof UnknownHostException)
        {
            Ln.e(exception);
            Toast.makeText(getActivity(), (new StringBuilder()).append("Cannot resolve the host ").append(s).append(":").append(s1).toString(), 0).show();
            return;
        }
        if (exception instanceof GeneralSecurityException)
        {
            Ln.e(exception);
            Toast.makeText(getActivity(), "Check logs for general security exception", 0).show();
            return;
        }
        if (exception instanceof NumberFormatException)
        {
            Ln.e(exception);
            Toast.makeText(getActivity(), "Port must be an integer value", 0).show();
            return;
        }
        if (exception instanceof IllegalArgumentException)
        {
            Ln.e(exception);
            Toast.makeText(getActivity(), "Port must be between 0 and 65535 (inclusive)", 0).show();
            return;
        } else
        {
            throw new RuntimeException(exception);
        }
    }

    public volatile void execute(Object obj, Object obj1, Object obj2)
        throws Exception
    {
        execute((Exception)obj, (String)obj1, (String)obj2);
    }

    (boolean flag, boolean flag1)
    {
        this$0 = SecretProxyFragment.this;
        super();
        shouldResetProxyIpPref = flag;
        shouldResetProxyPortPref = flag1;
    }
}
