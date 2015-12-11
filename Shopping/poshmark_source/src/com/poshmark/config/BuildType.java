// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.config;


public final class BuildType extends Enum
{

    private static final BuildType $VALUES[];
    public static final BuildType DEBUG;
    public static final BuildType RELEASE;

    private BuildType(String s, int i)
    {
        super(s, i);
    }

    public static BuildType valueOf(String s)
    {
        return (BuildType)Enum.valueOf(com/poshmark/config/BuildType, s);
    }

    public static BuildType[] values()
    {
        return (BuildType[])$VALUES.clone();
    }

    static 
    {
        DEBUG = new BuildType("DEBUG", 0);
        RELEASE = new BuildType("RELEASE", 1);
        $VALUES = (new BuildType[] {
            DEBUG, RELEASE
        });
    }
}
