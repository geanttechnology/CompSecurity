// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;
import java.security.Principal;

public final class BasicUserPrincipal
    implements Principal, Serializable
{

    private static final long serialVersionUID = 0xe08c7771113f019dL;
    private final String username;

    public BasicUserPrincipal(String s)
    {
        Args.notNull(s, "User name");
        username = s;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof BasicUserPrincipal) || !LangUtils.equals(username, ((BasicUserPrincipal) (obj = (BasicUserPrincipal)obj)).username))
            {
                return false;
            }
        }
        return true;
    }

    public String getName()
    {
        return username;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(17, username);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[principal: ");
        stringbuilder.append(username);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
