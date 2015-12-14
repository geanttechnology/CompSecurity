// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;


// Referenced classes of package com.amazon.gallery.thor.ftue:
//            DesktopScreen

public static final class  extends Enum
{

    private static final EmailSent $VALUES[];
    public static final EmailSent EmailSent;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/ftue/DesktopScreen$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EmailSent = new <init>("EmailSent", 0);
        $VALUES = (new .VALUES[] {
            EmailSent
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
