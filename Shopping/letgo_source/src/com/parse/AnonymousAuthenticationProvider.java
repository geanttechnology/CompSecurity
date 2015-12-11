// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.parse:
//            ParseAuthenticationProvider

class AnonymousAuthenticationProvider extends ParseAuthenticationProvider
{

    AnonymousAuthenticationProvider()
    {
    }

    public cu authenticateAsync()
    {
        return cu.a(getAuthData());
    }

    public void cancel()
    {
    }

    public void deauthenticate()
    {
    }

    public Map getAuthData()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("id", UUID.randomUUID().toString());
        return hashmap;
    }

    public String getAuthType()
    {
        return "anonymous";
    }

    public boolean restoreAuthentication(Map map)
    {
        return true;
    }
}
