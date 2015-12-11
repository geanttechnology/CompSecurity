// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.NameValuePair;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import com.comcast.cim.httpcomponentsandroid.util.LangUtils;
import java.io.Serializable;

public class BasicNameValuePair
    implements NameValuePair, Serializable, Cloneable
{

    private final String name;
    private final String value;

    public BasicNameValuePair(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        } else
        {
            name = s;
            value = s1;
            return;
        }
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof NameValuePair)
            {
                if (!name.equals(((BasicNameValuePair) (obj = (BasicNameValuePair)obj)).name) || !LangUtils.equals(value, ((BasicNameValuePair) (obj)).value))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
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

    public String toString()
    {
        if (value == null)
        {
            return name;
        } else
        {
            CharArrayBuffer chararraybuffer = new CharArrayBuffer(name.length() + 1 + value.length());
            chararraybuffer.append(name);
            chararraybuffer.append("=");
            chararraybuffer.append(value);
            return chararraybuffer.toString();
        }
    }
}
