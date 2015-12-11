// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.config;


public final class Env extends Enum
{

    private static final Env $VALUES[];
    public static final Env DEV;
    public static final Env DEVTEAM;
    public static final Env PRODUCTION;
    public static final Env RC;
    public static final Env STAGE;

    private Env(String s, int i)
    {
        super(s, i);
    }

    public static Env valueOf(String s)
    {
        return (Env)Enum.valueOf(com/poshmark/config/Env, s);
    }

    public static Env[] values()
    {
        return (Env[])$VALUES.clone();
    }

    static 
    {
        DEV = new Env("DEV", 0);
        DEVTEAM = new Env("DEVTEAM", 1);
        STAGE = new Env("STAGE", 2);
        PRODUCTION = new Env("PRODUCTION", 3);
        RC = new Env("RC", 4);
        $VALUES = (new Env[] {
            DEV, DEVTEAM, STAGE, PRODUCTION, RC
        });
    }
}
