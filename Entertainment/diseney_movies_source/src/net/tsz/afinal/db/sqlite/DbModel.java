// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.db.sqlite;

import java.util.HashMap;

public class DbModel
{

    private HashMap dataMap;

    public DbModel()
    {
        dataMap = new HashMap();
    }

    public Object get(String s)
    {
        return dataMap.get(s);
    }

    public boolean getBoolean(String s)
    {
        return Boolean.valueOf(getString(s)).booleanValue();
    }

    public HashMap getDataMap()
    {
        return dataMap;
    }

    public double getDouble(String s)
    {
        return Double.valueOf(getString(s)).doubleValue();
    }

    public float getFloat(String s)
    {
        return Float.valueOf(getString(s)).floatValue();
    }

    public int getInt(String s)
    {
        return Integer.valueOf(getString(s)).intValue();
    }

    public long getLong(String s)
    {
        return Long.valueOf(getString(s)).longValue();
    }

    public String getString(String s)
    {
        return String.valueOf(get(s));
    }

    public void set(String s, Object obj)
    {
        dataMap.put(s, obj);
    }
}
