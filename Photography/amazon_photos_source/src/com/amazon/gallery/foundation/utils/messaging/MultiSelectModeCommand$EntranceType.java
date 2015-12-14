// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.messaging;


// Referenced classes of package com.amazon.gallery.foundation.utils.messaging:
//            MultiSelectModeCommand

public static final class  extends Enum
{

    private static final BACK $VALUES[];
    public static final BACK BACK;
    public static final BACK BUTTON;
    public static final BACK TAP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/foundation/utils/messaging/MultiSelectModeCommand$EntranceType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TAP = new <init>("TAP", 0);
        BUTTON = new <init>("BUTTON", 1);
        BACK = new <init>("BACK", 2);
        $VALUES = (new .VALUES[] {
            TAP, BUTTON, BACK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
