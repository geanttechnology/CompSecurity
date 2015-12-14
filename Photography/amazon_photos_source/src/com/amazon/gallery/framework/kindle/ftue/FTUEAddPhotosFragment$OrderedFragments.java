// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;


// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            FTUEAddPhotosFragment

public static final class  extends Enum
{

    private static final MOBILE $VALUES[];
    public static final MOBILE DESKTOP;
    public static final MOBILE FACEBOOK;
    public static final MOBILE MOBILE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/ftue/FTUEAddPhotosFragment$OrderedFragments, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DESKTOP = new <init>("DESKTOP", 0);
        FACEBOOK = new <init>("FACEBOOK", 1);
        MOBILE = new <init>("MOBILE", 2);
        $VALUES = (new .VALUES[] {
            DESKTOP, FACEBOOK, MOBILE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
