// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;


public final class  extends Enum
{

    private static final CLOSE $VALUES[];
    public static final CLOSE CLOSE;
    public static final CLOSE OPEN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/beautyui/other/ArcMenu$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OPEN = new <init>("OPEN", 0);
        CLOSE = new <init>("CLOSE", 1);
        $VALUES = (new .VALUES[] {
            OPEN, CLOSE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
