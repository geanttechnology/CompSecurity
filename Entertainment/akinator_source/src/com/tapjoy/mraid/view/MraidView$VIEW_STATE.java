// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;


// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

public static final class  extends Enum
{

    private static final OPENED $VALUES[];
    public static final OPENED DEFAULT;
    public static final OPENED EXPANDED;
    public static final OPENED HIDDEN;
    public static final OPENED LEFT_BEHIND;
    public static final OPENED OPENED;
    public static final OPENED RESIZED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/tapjoy/mraid/view/MraidView$VIEW_STATE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        RESIZED = new <init>("RESIZED", 1);
        EXPANDED = new <init>("EXPANDED", 2);
        HIDDEN = new <init>("HIDDEN", 3);
        LEFT_BEHIND = new <init>("LEFT_BEHIND", 4);
        OPENED = new <init>("OPENED", 5);
        $VALUES = (new .VALUES[] {
            DEFAULT, RESIZED, EXPANDED, HIDDEN, LEFT_BEHIND, OPENED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
