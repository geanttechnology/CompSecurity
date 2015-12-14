// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;


public final class type extends Enum
{

    private static final BOOLEAN $VALUES[];
    public static final BOOLEAN BOOLEAN;
    public static final BOOLEAN DOUBLE;
    public static final BOOLEAN INTEGER;
    public static final BOOLEAN LONG;
    public static final BOOLEAN STRING;
    private String type;

    public static type getValue(String s)
    {
        return valueOf(s);
    }

    public static valueOf valueOf(String s)
    {
        return (valueOf)Enum.valueOf(com/socialin/android/apiv3/log/Attribute$ValidValueTypes, s);
    }

    public static valueOf[] values()
    {
        return (valueOf[])$VALUES.clone();
    }

    public final String getName()
    {
        return type;
    }

    static 
    {
        INTEGER = new <init>("INTEGER", 0, "integer");
        LONG = new <init>("LONG", 1, "long");
        DOUBLE = new <init>("DOUBLE", 2, "double");
        STRING = new <init>("STRING", 3, "string");
        BOOLEAN = new <init>("BOOLEAN", 4, "boolean");
        $VALUES = (new .VALUES[] {
            INTEGER, LONG, DOUBLE, STRING, BOOLEAN
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        type = s1;
    }
}
