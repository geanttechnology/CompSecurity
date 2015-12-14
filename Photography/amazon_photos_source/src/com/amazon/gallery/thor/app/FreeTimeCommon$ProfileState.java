// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;


// Referenced classes of package com.amazon.gallery.thor.app:
//            FreeTimeCommon

public static final class maturity extends Enum
{

    private static final PARENT $VALUES[];
    public static final PARENT FREETIME;
    public static final PARENT PARENT;
    public static final PARENT TEENTIME;
    public static final PARENT TWEENTIME;
    private final String maturity;

    public static maturity valueOf(String s)
    {
        return (maturity)Enum.valueOf(com/amazon/gallery/thor/app/FreeTimeCommon$ProfileState, s);
    }

    public static maturity[] values()
    {
        return (maturity[])$VALUES.clone();
    }

    public String getMaturity()
    {
        return maturity;
    }

    static 
    {
        FREETIME = new <init>("FREETIME", 0, "FREETIME");
        TWEENTIME = new <init>("TWEENTIME", 1, "TEENTIME");
        TEENTIME = new <init>("TEENTIME", 2, "TEENTIME");
        PARENT = new <init>("PARENT", 3, "ADULT");
        $VALUES = (new .VALUES[] {
            FREETIME, TWEENTIME, TEENTIME, PARENT
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        maturity = s1;
    }
}
