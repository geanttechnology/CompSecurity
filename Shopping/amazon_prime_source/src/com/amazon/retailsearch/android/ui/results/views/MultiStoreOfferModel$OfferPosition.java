// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;


// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            MultiStoreOfferModel

public static final class Y extends Enum
{

    private static final MIDDLE $VALUES[];
    public static final MIDDLE BOTTOM;
    public static final MIDDLE MIDDLE;
    public static final MIDDLE TOP;

    public static Y valueOf(String s)
    {
        return (Y)Enum.valueOf(com/amazon/retailsearch/android/ui/results/views/MultiStoreOfferModel$OfferPosition, s);
    }

    public static Y[] values()
    {
        return (Y[])$VALUES.clone();
    }

    static 
    {
        TOP = new <init>("TOP", 0);
        BOTTOM = new <init>("BOTTOM", 1);
        MIDDLE = new <init>("MIDDLE", 2);
        $VALUES = (new .VALUES[] {
            TOP, BOTTOM, MIDDLE
        });
    }

    private Y(String s, int i)
    {
        super(s, i);
    }
}
