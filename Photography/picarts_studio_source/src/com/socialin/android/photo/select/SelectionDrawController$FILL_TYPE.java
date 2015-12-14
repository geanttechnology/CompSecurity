// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;


public final class I extends Enum
{

    private static final DEFAULT $VALUES[];
    public static final DEFAULT ADD;
    public static final DEFAULT CLEAR;
    public static final DEFAULT DEFAULT;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/socialin/android/photo/select/SelectionDrawController$FILL_TYPE, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        ADD = new <init>("ADD", 0);
        CLEAR = new <init>("CLEAR", 1);
        DEFAULT = new <init>("DEFAULT", 2);
        $VALUES = (new .VALUES[] {
            ADD, CLEAR, DEFAULT
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
