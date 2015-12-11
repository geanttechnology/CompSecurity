// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.auth;

import com.comcast.cim.httpcomponentsandroid.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.auth:
//            Credentials, NTUserPrincipal

public class NTCredentials
    implements Credentials, Serializable
{

    private final String password;
    private final NTUserPrincipal principal;
    private final String workstation;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof NTCredentials) || (!LangUtils.equals(principal, ((NTCredentials) (obj = (NTCredentials)obj)).principal) || !LangUtils.equals(workstation, ((NTCredentials) (obj)).workstation)))
            {
                return false;
            }
        }
        return true;
    }

    public String getDomain()
    {
        return principal.getDomain();
    }

    public String getPassword()
    {
        return password;
    }

    public String getUserName()
    {
        return principal.getUsername();
    }

    public Principal getUserPrincipal()
    {
        return principal;
    }

    public String getWorkstation()
    {
        return workstation;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(17, principal), workstation);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[principal: ");
        stringbuilder.append(principal);
        stringbuilder.append("][workstation: ");
        stringbuilder.append(workstation);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
