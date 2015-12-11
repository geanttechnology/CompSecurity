// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;


public final class t extends Enum
{

    private static final t $VALUES[];
    public static final t Json;
    public static final t Xml;

    private t(String s, int i)
    {
        super(s, i);
    }

    public static t valueOf(String s)
    {
        return (t)Enum.valueOf(com/target/mothership/services/t, s);
    }

    public static t[] values()
    {
        return (t[])$VALUES.clone();
    }

    static 
    {
        Json = new t("Json", 0);
        Xml = new t("Xml", 1);
        $VALUES = (new t[] {
            Json, Xml
        });
    }
}
