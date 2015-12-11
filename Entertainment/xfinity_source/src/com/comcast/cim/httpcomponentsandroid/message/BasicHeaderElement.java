// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.HeaderElement;
import com.comcast.cim.httpcomponentsandroid.NameValuePair;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import com.comcast.cim.httpcomponentsandroid.util.LangUtils;

public class BasicHeaderElement
    implements HeaderElement, Cloneable
{

    private final String name;
    private final NameValuePair parameters[];
    private final String value;

    public BasicHeaderElement(String s, String s1, NameValuePair anamevaluepair[])
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        }
        name = s;
        value = s1;
        if (anamevaluepair != null)
        {
            parameters = anamevaluepair;
            return;
        } else
        {
            parameters = new NameValuePair[0];
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
            if (obj instanceof HeaderElement)
            {
                if (!name.equals(((BasicHeaderElement) (obj = (BasicHeaderElement)obj)).name) || !LangUtils.equals(value, ((BasicHeaderElement) (obj)).value) || !LangUtils.equals(parameters, ((BasicHeaderElement) (obj)).parameters))
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

    public NameValuePair getParameterByName(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        }
        Object obj = null;
        int i = 0;
        do
        {
label0:
            {
                NameValuePair namevaluepair = obj;
                if (i < parameters.length)
                {
                    namevaluepair = parameters[i];
                    if (!namevaluepair.getName().equalsIgnoreCase(s))
                    {
                        break label0;
                    }
                }
                return namevaluepair;
            }
            i++;
        } while (true);
    }

    public int getParameterCount()
    {
        return parameters.length;
    }

    public NameValuePair[] getParameters()
    {
        return (NameValuePair[])(NameValuePair[])parameters.clone();
    }

    public String getValue()
    {
        return value;
    }

    public int hashCode()
    {
        int j = LangUtils.hashCode(LangUtils.hashCode(17, name), value);
        for (int i = 0; i < parameters.length; i++)
        {
            j = LangUtils.hashCode(j, parameters[i]);
        }

        return j;
    }

    public String toString()
    {
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(64);
        chararraybuffer.append(name);
        if (value != null)
        {
            chararraybuffer.append("=");
            chararraybuffer.append(value);
        }
        for (int i = 0; i < parameters.length; i++)
        {
            chararraybuffer.append("; ");
            chararraybuffer.append(parameters[i]);
        }

        return chararraybuffer.toString();
    }
}
