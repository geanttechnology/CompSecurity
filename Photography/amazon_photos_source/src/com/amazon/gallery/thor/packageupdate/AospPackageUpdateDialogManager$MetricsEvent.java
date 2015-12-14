// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;


// Referenced classes of package com.amazon.gallery.thor.packageupdate:
//            AospPackageUpdateDialogManager

public static final class  extends Enum
{

    private static final OptionalUpdateLaunched $VALUES[];
    public static final OptionalUpdateLaunched MandatoryUpdateLaunched;
    public static final OptionalUpdateLaunched OptionalUpdateLaunched;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/packageupdate/AospPackageUpdateDialogManager$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MandatoryUpdateLaunched = new <init>("MandatoryUpdateLaunched", 0);
        OptionalUpdateLaunched = new <init>("OptionalUpdateLaunched", 1);
        $VALUES = (new .VALUES[] {
            MandatoryUpdateLaunched, OptionalUpdateLaunched
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
