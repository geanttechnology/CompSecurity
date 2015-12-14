// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.filters;


public final class  extends Enum
{

    private static final SAVE $VALUES[];
    public static final SAVE APPLY;
    public static final SAVE FREE;
    public static final SAVE INIT;
    public static final SAVE RESET;
    public static final SAVE SAVE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/filters/FilterUIEnhance$EnhanceAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        APPLY = new <init>("APPLY", 0);
        RESET = new <init>("RESET", 1);
        INIT = new <init>("INIT", 2);
        FREE = new <init>("FREE", 3);
        SAVE = new <init>("SAVE", 4);
        $VALUES = (new .VALUES[] {
            APPLY, RESET, INIT, FREE, SAVE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
