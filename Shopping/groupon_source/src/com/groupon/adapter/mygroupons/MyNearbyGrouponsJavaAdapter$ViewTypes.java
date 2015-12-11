// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.mygroupons;


// Referenced classes of package com.groupon.adapter.mygroupons:
//            MyNearbyGrouponsJavaAdapter

private static final class  extends Enum
{

    private static final LIST_HEADER_VIEW_TYPE $VALUES[];
    public static final LIST_HEADER_VIEW_TYPE GROUPON_CARD_VIEW_TYPE;
    public static final LIST_HEADER_VIEW_TYPE LIST_HEADER_VIEW_TYPE;
    public static final LIST_HEADER_VIEW_TYPE SECTION_HEADER_VIEW_TYPE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/adapter/mygroupons/MyNearbyGrouponsJavaAdapter$ViewTypes, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        GROUPON_CARD_VIEW_TYPE = new <init>("GROUPON_CARD_VIEW_TYPE", 0);
        SECTION_HEADER_VIEW_TYPE = new <init>("SECTION_HEADER_VIEW_TYPE", 1);
        LIST_HEADER_VIEW_TYPE = new <init>("LIST_HEADER_VIEW_TYPE", 2);
        $VALUES = (new .VALUES[] {
            GROUPON_CARD_VIEW_TYPE, SECTION_HEADER_VIEW_TYPE, LIST_HEADER_VIEW_TYPE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
