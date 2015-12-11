// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class XuaApplicationInfo
{

    private String accountId;
    private String applicationName;
    private String applicationVersion;
    private String pluginName;
    private String pluginVersion;

    public XuaApplicationInfo()
    {
    }

    public XuaApplicationInfo(String s, String s1, String s2, String s3, String s4)
    {
        applicationName = s;
        applicationVersion = s1;
        pluginName = s2;
        pluginVersion = s3;
        setAccountId(s4);
    }

    private String toMD5(String s)
    {
        StringBuffer stringbuffer;
        int i;
        try
        {
            s = MessageDigest.getInstance("MD5").digest(s.getBytes());
            stringbuffer = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        i = 0;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuffer.append(Integer.toHexString(s[i] & 0xff | 0x100).substring(1, 3));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_23;
_L1:
        s = stringbuffer.toString();
        return s;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public String getApplicationName()
    {
        return applicationName;
    }

    public String getApplicationVersion()
    {
        return applicationVersion;
    }

    public String getPluginName()
    {
        return pluginName;
    }

    public String getPluginVersion()
    {
        return pluginVersion;
    }

    public void setAccountId(String s)
    {
        if (s != null)
        {
            accountId = toMD5(s);
        }
    }

    public void setApplicationName(String s)
    {
        applicationName = s;
    }

    public void setApplicationVersion(String s)
    {
        applicationVersion = s;
    }

    public void setPluginName(String s)
    {
        pluginName = s;
    }

    public void setPluginVersion(String s)
    {
        pluginVersion = s;
    }
}
