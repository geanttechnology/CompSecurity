// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;


public class Metadatum
{

    private String key;
    private String value;

    private Metadatum()
    {
    }

    public Metadatum(String s, String s1)
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
}
