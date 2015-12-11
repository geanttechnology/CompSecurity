// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;

public class NTUserPrincipal
    implements Principal, Serializable
{

    private static final long serialVersionUID = 0xa0a840f7f0193992L;
    private final String domain;
    private final String ntname;
    private final String username;

    public NTUserPrincipal(String s, String s1)
    {
        Args.notNull(s1, "User name");
        username = s1;
        if (s != null)
        {
            domain = s.toUpperCase(Locale.ENGLISH);
        } else
        {
            domain = null;
        }
        if (domain != null && domain.length() > 0)
        {
            s = new StringBuilder();
            s.append(domain);
            s.append('\\');
            s.append(username);
            ntname = s.toString();
            return;
        } else
        {
            ntname = username;
            return;
        }
    }

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
