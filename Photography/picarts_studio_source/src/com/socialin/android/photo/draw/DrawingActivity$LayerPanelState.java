// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;


final class  extends Enum
{

    private static final CLOSED $VALUES[];
    public static final CLOSED CLOSED;
    public static final CLOSED CLOSING;
    public static final CLOSED OPENED;
    public static final CLOSED OPENING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/draw/DrawingActivity$LayerPanelState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OPENED = new <init>("OPENED", 0);
        OPENING = new <init>("OPENING", 1);
        CLOSING = new <init>("CLOSING", 2);
        CLOSED = new <init>("CLOSED", 3);
        $VALUES = (new .VALUES[] {
            OPENED, OPENING, CLOSING, CLOSED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
