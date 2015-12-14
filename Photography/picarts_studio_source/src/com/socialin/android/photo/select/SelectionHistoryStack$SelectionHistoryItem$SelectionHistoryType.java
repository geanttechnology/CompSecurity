// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;


public final class  extends Enum
{

    private static final Mask $VALUES[];
    public static final Mask File;
    public static final Mask Mask;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/select/SelectionHistoryStack$SelectionHistoryItem$SelectionHistoryType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        File = new <init>("File", 0);
        Mask = new <init>("Mask", 1);
        $VALUES = (new .VALUES[] {
            File, Mask
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
