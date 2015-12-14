// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;


final class  extends Enum
{

    private static final FREE $VALUES[];
    public static final FREE FREE;
    public static final FREE LINEAR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/editor/fragment/MotionFragment$MotionMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LINEAR = new <init>("LINEAR", 0);
        FREE = new <init>("FREE", 1);
        $VALUES = (new .VALUES[] {
            LINEAR, FREE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
