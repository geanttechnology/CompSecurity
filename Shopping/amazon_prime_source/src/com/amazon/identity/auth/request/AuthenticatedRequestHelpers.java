// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.request;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class AuthenticatedRequestHelpers
{

    public static final long DEFAULT_CONNECT_TO_SSO_TIMEOUT;

    public static Map getHeadersInBundle(Bundle bundle)
    {
        HashMap hashmap = new HashMap();
        bundle = bundle.getBundle("auth.headers");
        if (bundle != null)
        {
            Iterator iterator = bundle.keySet().iterator();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                hashmap.put(s, bundle.getString(s));
            }
        }
        return hashmap;
    }

    public static void setHeaderInBundle(Bundle bundle, String s, String s1)
    {
        Bundle bundle2 = bundle.getBundle("auth.headers");
        Bundle bundle1 = bundle2;
        if (bundle2 == null)
        {
            bundle1 = new Bundle();
            bundle.putBundle("auth.headers", bundle1);
        }
        bundle1.putString(s, s1);
    }

    static 
    {
        DEFAULT_CONNECT_TO_SSO_TIMEOUT = TimeUnit.MILLISECONDS.convert(20L, TimeUnit.SECONDS);
    }
}
