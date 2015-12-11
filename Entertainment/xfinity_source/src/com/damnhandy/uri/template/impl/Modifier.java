// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template.impl;


public final class Modifier extends Enum
{

    private static final Modifier $VALUES[];
    public static final Modifier DEFAULT_VALUE;
    public static final Modifier EXPLODE;
    public static final Modifier NONE;
    public static final Modifier PREFIX;
    private String value;

    private Modifier(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static Modifier valueOf(String s)
    {
        return (Modifier)Enum.valueOf(com/damnhandy/uri/template/impl/Modifier, s);
    }

    public static Modifier[] values()
    {
        return (Modifier[])$VALUES.clone();
    }

    public String getValue()
    {
        return value;
    }

    static 
    {
        NONE = new Modifier("NONE", 0, "na");
        PREFIX = new Modifier("PREFIX", 1, ":");
        EXPLODE = new Modifier("EXPLODE", 2, "*");
        DEFAULT_VALUE = new Modifier("DEFAULT_VALUE", 3, "=");
        $VALUES = (new Modifier[] {
            NONE, PREFIX, EXPLODE, DEFAULT_VALUE
        });
    }
}
