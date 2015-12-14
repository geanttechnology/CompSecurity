// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;


public final class  extends Enum
{

    private static final UNSELECT $VALUES[];
    public static final UNSELECT SELECT;
    public static final UNSELECT UNSELECT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/photo/morph/brushes/SelectBrush$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SELECT = new <init>("SELECT", 0);
        UNSELECT = new <init>("UNSELECT", 1);
        $VALUES = (new .VALUES[] {
            SELECT, UNSELECT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
