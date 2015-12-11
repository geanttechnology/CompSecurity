// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.table;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyValue
{

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String key;
    private Object value;

    public KeyValue()
    {
    }

    public KeyValue(String s, Object obj)
    {
        key = s;
        value = obj;
    }

    public String getKey()
    {
        return key;
    }

    public Object getValue()
    {
        if ((value instanceof Date) || (value instanceof java.sql.Date))
        {
            return sdf.format(value);
        } else
        {
            return value;
        }
    }

    public void setKey(String s)
    {
        key = s;
    }

    public void setValue(Object obj)
    {
        value = obj;
    }

}
