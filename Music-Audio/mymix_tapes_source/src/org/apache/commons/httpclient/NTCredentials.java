// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import org.apache.commons.httpclient.util.LangUtils;

// Referenced classes of package org.apache.commons.httpclient:
//            UsernamePasswordCredentials

public class NTCredentials extends UsernamePasswordCredentials
{

    private String domain;
    private String host;

    public NTCredentials()
    {
    }

    public NTCredentials(String s, String s1, String s2, String s3)
    {
        super(s, s1);
        if (s3 == null)
        {
            throw new IllegalArgumentException("Domain may not be null");
        }
        domain = s3;
        if (s2 == null)
        {
            throw new IllegalArgumentException("Host may not be null");
        } else
        {
            host = s2;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (super.equals(obj) && (obj instanceof NTCredentials))
            {
                obj = (NTCredentials)obj;
                if (!LangUtils.equals(domain, ((NTCredentials) (obj)).domain) || !LangUtils.equals(host, ((NTCredentials) (obj)).host))
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public String getDomain()
    {
        return domain;
    }

    public String getHost()
    {
        return host;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(super.hashCode(), host), domain);
    }

    public void setDomain(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Domain may not be null");
        } else
        {
            domain = s;
            return;
        }
    }

    public void setHost(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Host may not be null");
        } else
        {
            host = s;
            return;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(super.toString());
        stringbuffer.append("@");
        stringbuffer.append(host);
        stringbuffer.append(".");
        stringbuffer.append(domain);
        return stringbuffer.toString();
    }
}
