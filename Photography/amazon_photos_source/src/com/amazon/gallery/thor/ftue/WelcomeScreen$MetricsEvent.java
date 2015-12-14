// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;


// Referenced classes of package com.amazon.gallery.thor.ftue:
//            WelcomeScreen

public static final class  extends Enum
{

    private static final LearnMoreOpened $VALUES[];
    public static final LearnMoreOpened LearnMoreOpened;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/ftue/WelcomeScreen$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LearnMoreOpened = new <init>("LearnMoreOpened", 0);
        $VALUES = (new .VALUES[] {
            LearnMoreOpened
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
