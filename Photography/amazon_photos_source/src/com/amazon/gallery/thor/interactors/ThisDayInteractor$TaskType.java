// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.interactors;


// Referenced classes of package com.amazon.gallery.thor.interactors:
//            ThisDayInteractor

private static final class  extends Enum
{

    private static final REFRESH_SHUFFLE $VALUES[];
    public static final REFRESH_SHUFFLE REFRESH_SHUFFLE;
    public static final REFRESH_SHUFFLE RELOAD_SHUFFLE;
    public static final REFRESH_SHUFFLE RELOAD_THIS_DAY;
    public static final REFRESH_SHUFFLE RELOAD_THIS_WEEK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/interactors/ThisDayInteractor$TaskType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RELOAD_THIS_DAY = new <init>("RELOAD_THIS_DAY", 0);
        RELOAD_THIS_WEEK = new <init>("RELOAD_THIS_WEEK", 1);
        RELOAD_SHUFFLE = new <init>("RELOAD_SHUFFLE", 2);
        REFRESH_SHUFFLE = new <init>("REFRESH_SHUFFLE", 3);
        $VALUES = (new .VALUES[] {
            RELOAD_THIS_DAY, RELOAD_THIS_WEEK, RELOAD_SHUFFLE, REFRESH_SHUFFLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
