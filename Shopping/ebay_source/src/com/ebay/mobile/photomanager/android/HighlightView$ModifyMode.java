// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.android;


// Referenced classes of package com.ebay.mobile.photomanager.android:
//            HighlightView

static final class  extends Enum
{

    private static final Grow $VALUES[];
    public static final Grow Grow;
    public static final Grow Move;
    public static final Grow None;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/photomanager/android/HighlightView$ModifyMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        Move = new <init>("Move", 1);
        Grow = new <init>("Grow", 2);
        $VALUES = (new .VALUES[] {
            None, Move, Grow
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
