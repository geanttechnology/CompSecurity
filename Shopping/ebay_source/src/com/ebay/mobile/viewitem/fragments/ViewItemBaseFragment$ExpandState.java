// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;


// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment

public static final class I extends Enum
{

    private static final EXPANDED_ALL $VALUES[];
    public static final EXPANDED_ALL COLLAPSED;
    public static final EXPANDED_ALL EXPANDED;
    public static final EXPANDED_ALL EXPANDED_ALL;
    public static final EXPANDED_ALL NONE;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/ebay/mobile/viewitem/fragments/ViewItemBaseFragment$ExpandState, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        COLLAPSED = new <init>("COLLAPSED", 1);
        EXPANDED = new <init>("EXPANDED", 2);
        EXPANDED_ALL = new <init>("EXPANDED_ALL", 3);
        $VALUES = (new .VALUES[] {
            NONE, COLLAPSED, EXPANDED, EXPANDED_ALL
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
