// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            PoGCoachmarkDialog

public static final class  extends Enum
{

    private static final DOLLAR $VALUES[];
    public static final DOLLAR CAMERA;
    public static final DOLLAR DOLLAR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/fragment/PoGCoachmarkDialog$DialogType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CAMERA = new <init>("CAMERA", 0);
        DOLLAR = new <init>("DOLLAR", 1);
        $VALUES = (new .VALUES[] {
            CAMERA, DOLLAR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
