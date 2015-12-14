// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;


// Referenced classes of package com.amazon.gallery.thor.widget:
//            RangeSeekBar

public static final class  extends Enum
{

    private static final MIDDLE $VALUES[];
    public static final MIDDLE MAX;
    public static final MIDDLE MIDDLE;
    public static final MIDDLE MIN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/widget/RangeSeekBar$Thumb, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MIN = new <init>("MIN", 0);
        MAX = new <init>("MAX", 1);
        MIDDLE = new <init>("MIDDLE", 2);
        $VALUES = (new .VALUES[] {
            MIN, MAX, MIDDLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
