// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.Serializable;
import org.apache.commons.httpclient.util.LangUtils;

public class NameValuePair
    implements Serializable
{

    private String name;
    private String value;

    public NameValuePair()
    {
        this(null, null);
    }

    public NameValuePair(String s, String s1)
    {
        name = null;
        value = null;
        name = s;
        value = s1;
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
            if (obj instanceof NameValuePair)
            {
                obj = (NameValuePair)obj;
                if (!LangUtils.equals(name, ((NameValuePair) (obj)).name) || !LangUtils.equals(value, ((NameValuePair) (obj)).value))
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(17, name), value);
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setValue(String s)
    {
        value = s;
    }

    public String toString()
    {
        return "name=" + name + ", " + "value=" + value;
    }
}
