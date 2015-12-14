// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryNavBarViewFlipper

static final class  extends Enum
{

    private static final Close $VALUES[];
    public static final Close Close;
    public static final Close Open;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/widget/AviaryNavBarViewFlipper$ViewState$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Open = new <init>("Open", 0);
        Close = new <init>("Close", 1);
        $VALUES = (new .VALUES[] {
            Open, Close
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
