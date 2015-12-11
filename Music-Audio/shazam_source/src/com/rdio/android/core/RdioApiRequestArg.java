// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RdioApiRequestArg
{

    private String name;
    private String value;

    public RdioApiRequestArg(String s, Object obj)
    {
        name = s;
        if (obj instanceof List)
        {
            value = convertListValueToString((List)obj);
            return;
        } else
        {
            value = convertValueToString(obj);
            return;
        }
    }

    public RdioApiRequestArg(String s, Object aobj[])
    {
        name = s;
        value = convertArrayValueToString(aobj);
    }

    private String convertArrayValueToString(Object aobj[])
    {
        if (aobj == null || aobj.length == 0)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(convertValueToString(aobj[0]));
        for (int i = 1; i < aobj.length; i++)
        {
            stringbuilder.append(",");
            stringbuilder.append(convertValueToString(aobj[i]));
        }

        return stringbuilder.toString();
    }

    private String convertListValueToString(List list)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(list.get(0));
        for (int i = 1; i < list.size(); i++)
        {
            stringbuilder.append(",");
            stringbuilder.append(convertValueToString(list.get(i)));
        }

        return stringbuilder.toString();
    }

    private String convertValueToString(Object obj)
    {
        if ((obj instanceof Integer) || (obj instanceof Boolean))
        {
            return obj.toString();
        }
        if (obj instanceof String)
        {
            return (String)obj;
        } else
        {
            return null;
        }
    }

    public static Map createMapFromArgs(RdioApiRequestArg ardioapirequestarg[])
    {
        HashMap hashmap = new HashMap(ardioapirequestarg.length);
        for (int i = 0; i < ardioapirequestarg.length; i++)
        {
            if (ardioapirequestarg[i].getValue() != null)
            {
                hashmap.put(ardioapirequestarg[i].getName(), ardioapirequestarg[i].getValue());
            }
        }

        return hashmap;
    }

    public String getName()
    {
        return name;
    }

    public String getValue()
    {
        return value;
    }

    public String toString()
    {
        return (new StringBuilder()).append(name).append("=").append(value).toString();
    }
}
