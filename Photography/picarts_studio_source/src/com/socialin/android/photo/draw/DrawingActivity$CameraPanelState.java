// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;


final class  extends Enum
{

    private static final OPENED $VALUES[];
    public static final OPENED CLOSED;
    public static final OPENED CLOSING;
    public static final OPENED OPENED;
    public static final OPENED OPENING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/draw/DrawingActivity$CameraPanelState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OPENING = new <init>("OPENING", 0);
        CLOSING = new <init>("CLOSING", 1);
        CLOSED = new <init>("CLOSED", 2);
        OPENED = new <init>("OPENED", 3);
        $VALUES = (new .VALUES[] {
            OPENING, CLOSING, CLOSED, OPENED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
