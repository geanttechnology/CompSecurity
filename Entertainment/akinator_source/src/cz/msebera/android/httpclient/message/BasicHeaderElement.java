// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;

public class BasicHeaderElement
    implements HeaderElement, Cloneable
{

    private final String name;
    private final NameValuePair parameters[];
    private final String value;

    public BasicHeaderElement(String s, String s1)
    {
        this(s, s1, null);
    }

    public BasicHeaderElement(String s, String s1, NameValuePair anamevaluepair[])
    {
        name = (String)Args.notNull(s, "Name");
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

    public NameValuePair getParameter(int i)
    {
        return parameters[i];
    }

    public NameValuePair getParameterByName(String s)
    {
        Args.notNull(s, "Name");
        Object obj = null;
        NameValuePair anamevaluepair[] = parameters;
        int j = anamevaluepair.length;
        int i = 0;
        do
        {
label0:
            {
                NameValuePair namevaluepair = obj;
                if (i < j)
                {
                    namevaluepair = anamevaluepair[i];
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
        return (NameValuePair[])parameters.clone();
    }

    public String getValue()
    {
        return value;
    }

    public int hashCode()
    {
        int j = LangUtils.hashCode(LangUtils.hashCode(17, name), value);
        NameValuePair anamevaluepair[] = parameters;
        int k = anamevaluepair.length;
        for (int i = 0; i < k; i++)
        {
            j = LangUtils.hashCode(j, anamevaluepair[i]);
        }

        return j;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(name);
        if (value != null)
        {
            stringbuilder.append("=");
            stringbuilder.append(value);
        }
        NameValuePair anamevaluepair[] = parameters;
        int j = anamevaluepair.length;
        for (int i = 0; i < j; i++)
        {
            NameValuePair namevaluepair = anamevaluepair[i];
            stringbuilder.append("; ");
            stringbuilder.append(namevaluepair);
        }

        return stringbuilder.toString();
    }
}
