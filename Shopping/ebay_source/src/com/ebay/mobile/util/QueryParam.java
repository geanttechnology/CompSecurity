// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryParam
{

    public String key;
    public String value;

    public QueryParam()
    {
    }

    public QueryParam(String s, String s1)
    {
        key = s;
        value = s1;
    }

    public static QueryParam fromKVP(String s)
    {
        QueryParam queryparam = new QueryParam(s, null);
        int i = s.indexOf("=");
        if (i > 0)
        {
            queryparam.key = s.substring(0, i);
            queryparam.value = s.substring(i + 1);
        }
        return queryparam;
    }

    public static List fromQueryString(String s)
    {
        ArrayList arraylist = new ArrayList();
        if (s != null)
        {
            s = s.split("&");
            for (int i = 0; i < s.length; i++)
            {
                arraylist.add(fromKVP(s[i]));
            }

        }
        return arraylist;
    }

    public static QueryParam getByKey(List list, String s)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            QueryParam queryparam = (QueryParam)list.next();
            if (queryparam.key.equals(s))
            {
                return queryparam;
            }
        }

        return null;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof QueryParam))
        {
            if (key.equals(((QueryParam) (obj = (QueryParam)obj)).key) && (value == null && ((QueryParam) (obj)).value == null || value != null && value.equals(((QueryParam) (obj)).value)))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (key == null)
        {
            i = 0;
        } else
        {
            i = key.hashCode();
        }
        if (value != null)
        {
            j = value.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public String toString()
    {
        return (new StringBuilder()).append(key).append("=").append(value).toString();
    }
}
