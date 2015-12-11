// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.registries;


public final class b extends Enum
{

    private static final b $VALUES[];
    public static final b EXTERNAL;
    public static final b MOBILE;
    public static final b STORE;
    public static final b UNKNOWN;
    public static final b WEB;
    private String mValue;

    private b(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/target/mothership/common/registries/b, s);
    }

    public static b[] values()
    {
        return (b[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        MOBILE = new b("MOBILE", 0, "M");
        WEB = new b("WEB", 1, "W");
        STORE = new b("STORE", 2, "S");
        EXTERNAL = new b("EXTERNAL", 3, "E");
        UNKNOWN = new b("UNKNOWN", 4, "");
        $VALUES = (new b[] {
            MOBILE, WEB, STORE, EXTERNAL, UNKNOWN
        });
    }
}
