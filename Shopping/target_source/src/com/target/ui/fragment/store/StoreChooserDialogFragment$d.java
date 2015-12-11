// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;


// Referenced classes of package com.target.ui.fragment.store:
//            StoreChooserDialogFragment

public static final class  extends Enum
{

    private static final FIATS $VALUES[];
    public static final FIATS FIATS;
    public static final FIATS NEARBY_STORES;
    public static final FIATS WEEKLY_AD;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/fragment/store/StoreChooserDialogFragment$d, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NEARBY_STORES = new <init>("NEARBY_STORES", 0);
        WEEKLY_AD = new <init>("WEEKLY_AD", 1);
        FIATS = new <init>("FIATS", 2);
        $VALUES = (new .VALUES[] {
            NEARBY_STORES, WEEKLY_AD, FIATS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
