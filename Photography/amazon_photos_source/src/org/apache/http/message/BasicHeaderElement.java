// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public class BasicHeaderElement
    implements Cloneable, HeaderElement
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
        boolean flag = true;
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj instanceof HeaderElement)
            {
                obj = (BasicHeaderElement)obj;
                if (!name.equals(((BasicHeaderElement) (obj)).name) || !LangUtils.equals(value, ((BasicHeaderElement) (obj)).value) || !LangUtils.equals(parameters, ((BasicHeaderElement) (obj)).parameters))
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
