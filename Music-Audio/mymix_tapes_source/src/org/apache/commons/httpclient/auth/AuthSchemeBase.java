// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;


// Referenced classes of package org.apache.commons.httpclient.auth:
//            AuthScheme, MalformedChallengeException

public abstract class AuthSchemeBase
    implements AuthScheme
{

    private String challenge;

    public AuthSchemeBase(String s)
        throws MalformedChallengeException
    {
        challenge = null;
        if (s == null)
        {
            throw new IllegalArgumentException("Challenge may not be null");
        } else
        {
            challenge = s;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof AuthSchemeBase)
        {
            return challenge.equals(((AuthSchemeBase)obj).challenge);
        } else
        {
            return super.equals(obj);
        }
    }

    public int hashCode()
    {
        return challenge.hashCode();
    }

    public String toString()
    {
        return challenge;
    }
}
