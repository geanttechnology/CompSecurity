// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.impl;

import com.amazon.insights.InsightsCredentials;

public class DefaultInsightsCredentials
    implements InsightsCredentials
{

    final String applicationKey;
    final String privateKey;

    public DefaultInsightsCredentials(String s, String s1)
    {
        applicationKey = s;
        privateKey = s1;
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj != null)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj instanceof InsightsCredentials)
            {
                obj = (InsightsCredentials)obj;
                if (!getApplicationKey().equals(((InsightsCredentials) (obj)).getApplicationKey()) || !getPrivateKey().equals(((InsightsCredentials) (obj)).getPrivateKey()))
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public String getApplicationKey()
    {
        return applicationKey;
    }

    public String getPrivateKey()
    {
        return privateKey;
    }

    public int hashCode()
    {
        return (new StringBuilder()).append(getApplicationKey()).append(getPrivateKey()).toString().hashCode();
    }
}
