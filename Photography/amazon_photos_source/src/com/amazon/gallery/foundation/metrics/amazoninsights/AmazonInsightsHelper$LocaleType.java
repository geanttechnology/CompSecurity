// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.amazoninsights;


// Referenced classes of package com.amazon.gallery.foundation.metrics.amazoninsights:
//            AmazonInsightsHelper

public static final class  extends Enum
{

    private static final LOCALE $VALUES[];
    public static final LOCALE LANGUAGE_ONLY;
    public static final LOCALE LOCALE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/foundation/metrics/amazoninsights/AmazonInsightsHelper$LocaleType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LANGUAGE_ONLY = new <init>("LANGUAGE_ONLY", 0);
        LOCALE = new <init>("LOCALE", 1);
        $VALUES = (new .VALUES[] {
            LANGUAGE_ONLY, LOCALE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
