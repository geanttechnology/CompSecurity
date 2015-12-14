// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;


// Referenced classes of package com.amazon.gallery.thor.packageupdate:
//            PackageUpdateService

public static final class  extends Enum
{

    private static final OptionalUpdateNotification $VALUES[];
    public static final OptionalUpdateNotification MandatoryUpdateNotification;
    public static final OptionalUpdateNotification OptionalUpdateNotification;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/packageupdate/PackageUpdateService$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MandatoryUpdateNotification = new <init>("MandatoryUpdateNotification", 0);
        OptionalUpdateNotification = new <init>("OptionalUpdateNotification", 1);
        $VALUES = (new .VALUES[] {
            MandatoryUpdateNotification, OptionalUpdateNotification
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
