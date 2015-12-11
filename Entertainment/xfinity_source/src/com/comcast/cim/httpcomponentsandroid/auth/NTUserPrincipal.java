// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.auth;

import com.comcast.cim.httpcomponentsandroid.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

public class NTUserPrincipal
    implements Serializable, Principal
{

    private final String domain;
    private final String ntname;
    private final String username;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof NTUserPrincipal) || (!LangUtils.equals(username, ((NTUserPrincipal) (obj = (NTUserPrincipal)obj)).username) || !LangUtils.equals(domain, ((NTUserPrincipal) (obj)).domain)))
            {
                return false;
            }
        }
        return true;
    }

    public String getDomain()
    {
        return domain;
    }

    public String getName()
    {
        return ntname;
    }

    public String getUsername()
    {
        return username;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(17, username), domain);
    }

    public String toString()
    {
        return ntname;
    }
}
