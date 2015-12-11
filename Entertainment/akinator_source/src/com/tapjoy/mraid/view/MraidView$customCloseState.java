// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;


// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

public static final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN HIDDEN;
    public static final UNKNOWN OPEN;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/tapjoy/mraid/view/MraidView$customCloseState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HIDDEN = new <init>("HIDDEN", 0);
        OPEN = new <init>("OPEN", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            HIDDEN, OPEN, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
