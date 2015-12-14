// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.util;


public class SDKInfo
{

    private final String name;
    private final String version;

    public SDKInfo(String s, String s1)
    {
        name = s;
        version = s1;
    }

    public String getName()
    {
        return name;
    }

    public String getVersion()
    {
        return version;
    }

    public String toString()
    {
        return (new StringBuilder()).append(name).append("-").append(version).toString();
    }
}
