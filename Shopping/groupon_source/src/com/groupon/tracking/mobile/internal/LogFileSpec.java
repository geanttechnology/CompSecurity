// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;


public class LogFileSpec
{

    private String extension;
    private String prefix;

    public LogFileSpec(String s, String s1)
    {
        prefix = s;
        extension = s1;
    }

    public String createFileName(String s)
    {
        return (new StringBuilder()).append(prefix).append(s).append(".").append(extension).toString();
    }

    public String getExtension()
    {
        return extension;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public boolean matchesSpec(String s)
    {
        return s.startsWith(prefix) && s.endsWith(extension);
    }
}
