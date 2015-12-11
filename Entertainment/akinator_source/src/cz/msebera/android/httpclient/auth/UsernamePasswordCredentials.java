// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

// Referenced classes of package cz.msebera.android.httpclient.auth:
//            Credentials, BasicUserPrincipal

public class UsernamePasswordCredentials
    implements Credentials, Serializable
{

    private static final long serialVersionUID = 0x36087f34635c8cbL;
    private final String password;
    private final BasicUserPrincipal principal;

    public UsernamePasswordCredentials(String s)
    {
        Args.notNull(s, "Username:password string");
        int i = s.indexOf(':');
        if (i >= 0)
        {
            principal = new BasicUserPrincipal(s.substring(0, i));
            password = s.substring(i + 1);
            return;
        } else
        {
            principal = new BasicUserPrincipal(s);
            password = null;
            return;
        }
    }

    public UsernamePasswordCredentials(String s, String s1)
    {
        Args.notNull(s, "Username");
        principal = new BasicUserPrincipal(s);
        password = s1;
    }

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
