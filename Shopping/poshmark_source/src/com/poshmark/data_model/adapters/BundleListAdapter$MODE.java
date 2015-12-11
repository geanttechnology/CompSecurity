// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;


// Referenced classes of package com.poshmark.data_model.adapters:
//            BundleListAdapter

public static final class  extends Enum
{

    private static final VIEW_UNAVAILABLE_ITEMS $VALUES[];
    public static final VIEW_UNAVAILABLE_ITEMS VIEW_BUNDLE;
    public static final VIEW_UNAVAILABLE_ITEMS VIEW_UNAVAILABLE_ITEMS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/data_model/adapters/BundleListAdapter$MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VIEW_BUNDLE = new <init>("VIEW_BUNDLE", 0);
        VIEW_UNAVAILABLE_ITEMS = new <init>("VIEW_UNAVAILABLE_ITEMS", 1);
        $VALUES = (new .VALUES[] {
            VIEW_BUNDLE, VIEW_UNAVAILABLE_ITEMS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
