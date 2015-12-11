// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig.json;


public class ConfigEntry
{

    private String key;
    private String value;

    public ConfigEntry()
    {
    }

    public ConfigEntry(String s, String s1)
    {
        key = s;
        value = s1;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    public void setKey(String s)
    {
        key = s;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
