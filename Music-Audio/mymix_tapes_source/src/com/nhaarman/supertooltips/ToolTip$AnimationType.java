// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.supertooltips;


// Referenced classes of package com.nhaarman.supertooltips:
//            ToolTip

public static final class  extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE FROM_MASTER_VIEW;
    public static final NONE FROM_TOP;
    public static final NONE NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/nhaarman/supertooltips/ToolTip$AnimationType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FROM_MASTER_VIEW = new <init>("FROM_MASTER_VIEW", 0);
        FROM_TOP = new <init>("FROM_TOP", 1);
        NONE = new <init>("NONE", 2);
        $VALUES = (new .VALUES[] {
            FROM_MASTER_VIEW, FROM_TOP, NONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
