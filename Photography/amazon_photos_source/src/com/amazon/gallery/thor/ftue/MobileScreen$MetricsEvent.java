// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;


// Referenced classes of package com.amazon.gallery.thor.ftue:
//            MobileScreen

public static final class  extends Enum
{

    private static final SmsSent $VALUES[];
    public static final SmsSent SmsSent;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/ftue/MobileScreen$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SmsSent = new <init>("SmsSent", 0);
        $VALUES = (new .VALUES[] {
            SmsSent
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
