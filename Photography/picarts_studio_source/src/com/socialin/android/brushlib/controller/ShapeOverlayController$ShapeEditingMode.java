// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;


public final class  extends Enum
{

    private static final EDIT $VALUES[];
    public static final EDIT DRAW;
    public static final EDIT EDIT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/brushlib/controller/ShapeOverlayController$ShapeEditingMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAW = new <init>("DRAW", 0);
        EDIT = new <init>("EDIT", 1);
        $VALUES = (new .VALUES[] {
            DRAW, EDIT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
