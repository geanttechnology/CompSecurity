// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.wallet.wobl.renderer.android.views;


// Referenced classes of package com.google.wallet.wobl.renderer.android.views:
//            LineView

public static final class  extends Enum
{

    private static final VERTICAL $VALUES[];
    public static final VERTICAL HORIZONTAL;
    public static final VERTICAL VERTICAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/wallet/wobl/renderer/android/views/LineView$Orientation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HORIZONTAL = new <init>("HORIZONTAL", 0);
        VERTICAL = new <init>("VERTICAL", 1);
        $VALUES = (new .VALUES[] {
            HORIZONTAL, VERTICAL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
