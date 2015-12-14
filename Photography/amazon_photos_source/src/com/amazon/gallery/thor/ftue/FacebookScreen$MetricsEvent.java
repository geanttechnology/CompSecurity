// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;


// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

public static final class  extends Enum
{

    private static final FacebookPhotosImported $VALUES[];
    public static final FacebookPhotosImported FacebookPhotosImported;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/ftue/FacebookScreen$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FacebookPhotosImported = new <init>("FacebookPhotosImported", 0);
        $VALUES = (new .VALUES[] {
            FacebookPhotosImported
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
