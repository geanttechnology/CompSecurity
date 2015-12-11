// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.auth;

import com.comcast.cim.httpcomponentsandroid.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.auth:
//            Credentials, BasicUserPrincipal

public class UsernamePasswordCredentials
    implements Credentials, Serializable
{

    private final String password;
    private final BasicUserPrincipal principal;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof UsernamePasswordCredentials) || !LangUtils.equals(principal, ((UsernamePasswordCredentials) (obj = (UsernamePasswordCredentials)obj)).principal))
            {
                return false;
            }
        }
        return true;
    }

    public String getPassword()
    {
        return password;
    }

    public String getUserName()
    {
        return principal.getName();
    }

    public Principal getUserPrincipal()
    {
        return principal;
    }

    public int hashCode()
    {
        return principal.hashCode();
    }

    public String toString()
    {
        return principal.toString();
    }
}
