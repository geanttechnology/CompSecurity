// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clone;


public final class  extends Enum
{

    private static final CLONE $VALUES[];
    public static final CLONE CLONE;
    public static final CLONE SOURCE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/clone/CloneDrawController$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SOURCE = new <init>("SOURCE", 0);
        CLONE = new <init>("CLONE", 1);
        $VALUES = (new .VALUES[] {
            SOURCE, CLONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
