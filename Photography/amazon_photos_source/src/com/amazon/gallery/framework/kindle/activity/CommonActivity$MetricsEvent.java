// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;


// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CommonActivity

public static final class  extends Enum
{

    private static final OrientationChanged $VALUES[];
    public static final OrientationChanged OrientationChanged;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/activity/CommonActivity$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OrientationChanged = new <init>("OrientationChanged", 0);
        $VALUES = (new .VALUES[] {
            OrientationChanged
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
