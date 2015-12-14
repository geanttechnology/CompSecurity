// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.overlays;


// Referenced classes of package com.aviary.android.feather.sdk.overlays:
//            BlemishOverlay

static final class  extends Enum
{

    private static final ALL $VALUES[];
    public static final ALL ALL;
    public static final ALL FIRST;
    public static final ALL NONE;
    public static final ALL SECOND;
    public static final ALL THIRD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/overlays/BlemishOverlay$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        FIRST = new <init>("FIRST", 1);
        SECOND = new <init>("SECOND", 2);
        THIRD = new <init>("THIRD", 3);
        ALL = new <init>("ALL", 4);
        $VALUES = (new .VALUES[] {
            NONE, FIRST, SECOND, THIRD, ALL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
