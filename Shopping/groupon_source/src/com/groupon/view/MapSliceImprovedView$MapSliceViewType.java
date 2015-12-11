// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;


// Referenced classes of package com.groupon.view:
//            MapSliceImprovedView

public static final class  extends Enum
{

    private static final WEBSITE $VALUES[];
    public static final WEBSITE ADDRESS;
    public static final WEBSITE MAP;
    public static final WEBSITE MULTIPLE_LOCATIONS;
    public static final WEBSITE PHONE;
    public static final WEBSITE WEBSITE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/view/MapSliceImprovedView$MapSliceViewType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MAP = new <init>("MAP", 0);
        ADDRESS = new <init>("ADDRESS", 1);
        MULTIPLE_LOCATIONS = new <init>("MULTIPLE_LOCATIONS", 2);
        PHONE = new <init>("PHONE", 3);
        WEBSITE = new <init>("WEBSITE", 4);
        $VALUES = (new .VALUES[] {
            MAP, ADDRESS, MULTIPLE_LOCATIONS, PHONE, WEBSITE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
