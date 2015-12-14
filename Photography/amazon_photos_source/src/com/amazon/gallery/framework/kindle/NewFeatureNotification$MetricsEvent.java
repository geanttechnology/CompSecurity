// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;


// Referenced classes of package com.amazon.gallery.framework.kindle:
//            NewFeatureNotification

public static final class  extends Enum
{

    private static final NewFeatureDialogDisplayed $VALUES[];
    public static final NewFeatureDialogDisplayed NewFeatureDialogDisplayed;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/NewFeatureNotification$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NewFeatureDialogDisplayed = new <init>("NewFeatureDialogDisplayed", 0);
        $VALUES = (new .VALUES[] {
            NewFeatureDialogDisplayed
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
