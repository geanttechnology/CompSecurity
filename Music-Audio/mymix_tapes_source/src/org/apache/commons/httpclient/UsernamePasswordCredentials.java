// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import org.apache.commons.httpclient.util.LangUtils;

// Referenced classes of package org.apache.commons.httpclient:
//            Credentials

public class UsernamePasswordCredentials
    implements Credentials
{

    private String password;
    private String userName;

    public UsernamePasswordCredentials()
    {
    }

    public UsernamePasswordCredentials(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Username:password string may not be null");
        }
        int i = s.indexOf(':');
        if (i >= 0)
        {
            userName = s.substring(0, i);
            password = s.substring(i + 1);
            return;
        } else
        {
            userName = s;
            return;
        }
    }

    public UsernamePasswordCredentials(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Username may not be null");
        } else
        {
            userName = s;
            password = s1;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (getClass().equals(obj.getClass()))
            {
                obj = (UsernamePasswordCredentials)obj;
                if (LangUtils.equals(userName, ((UsernamePasswordCredentials) (obj)).userName) && LangUtils.equals(password, ((UsernamePasswordCredentials) (obj)).password))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public String getPassword()
    {
        return password;
    }

    public String getUserName()
    {
        return userName;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(17, userName), password);
    }

    public void setPassword(String s)
    {
        password = s;
    }

    public void setUserName(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Username may not be null");
        } else
        {
            userName = s;
            return;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(userName);
        stringbuffer.append(":");
        String s;
        if (password == null)
        {
            s = "null";
        } else
        {
            s = password;
        }
        stringbuffer.append(s);
        return stringbuffer.toString();
    }
}
