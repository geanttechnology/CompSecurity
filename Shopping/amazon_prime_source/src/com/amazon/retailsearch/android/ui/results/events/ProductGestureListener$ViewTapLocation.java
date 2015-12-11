// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.events;


// Referenced classes of package com.amazon.retailsearch.android.ui.results.events:
//            ProductGestureListener

private static final class  extends Enum
{

    private static final WITHIN_PADDING $VALUES[];
    public static final WITHIN_PADDING IN_VIEW;
    public static final WITHIN_PADDING MISS;
    public static final WITHIN_PADDING WITHIN_PADDING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MISS = new <init>("MISS", 0);
        IN_VIEW = new <init>("IN_VIEW", 1);
        WITHIN_PADDING = new <init>("WITHIN_PADDING", 2);
        $VALUES = (new .VALUES[] {
            MISS, IN_VIEW, WITHIN_PADDING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
