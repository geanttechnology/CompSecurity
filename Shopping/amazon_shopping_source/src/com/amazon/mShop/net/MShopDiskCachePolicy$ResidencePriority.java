// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            MShopDiskCachePolicy

public static final class A extends Enum
{

    private static final RESIDENCE_PRIORITY_1 $VALUES[];
    public static final RESIDENCE_PRIORITY_1 RESIDENCE_PRIORITY_0;
    public static final RESIDENCE_PRIORITY_1 RESIDENCE_PRIORITY_1;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        RESIDENCE_PRIORITY_0 = new <init>("RESIDENCE_PRIORITY_0", 0);
        RESIDENCE_PRIORITY_1 = new <init>("RESIDENCE_PRIORITY_1", 1);
        $VALUES = (new .VALUES[] {
            RESIDENCE_PRIORITY_0, RESIDENCE_PRIORITY_1
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
