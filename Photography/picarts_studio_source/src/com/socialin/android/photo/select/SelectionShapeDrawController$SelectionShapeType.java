// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;


public final class  extends Enum
{

    private static final CIRCLE $VALUES[];
    public static final CIRCLE CIRCLE;
    public static final CIRCLE RECTANGLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/select/SelectionShapeDrawController$SelectionShapeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RECTANGLE = new <init>("RECTANGLE", 0);
        CIRCLE = new <init>("CIRCLE", 1);
        $VALUES = (new .VALUES[] {
            RECTANGLE, CIRCLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
