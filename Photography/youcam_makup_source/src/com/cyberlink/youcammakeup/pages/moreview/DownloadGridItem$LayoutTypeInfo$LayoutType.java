// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;


public final class  extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    private static final i j[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/pages/moreview/DownloadGridItem$LayoutTypeInfo$LayoutType, s);
    }

    public static [] values()
    {
        return ([])j.clone();
    }

    static 
    {
        a = new <init>("LOOK_TYPE", 0);
        b = new <init>("EYE_SHADOW_TYPE", 1);
        c = new <init>("EYE_LINE_TYPE", 2);
        d = new <init>("EYE_LASH_TYPE", 3);
        e = new <init>("CATEGOTY_LOOK_TYPE", 4);
        f = new <init>("PROMOTION_LOOK_TYPE", 5);
        g = new <init>("WIG_TYPE", 6);
        h = new <init>("CATEGORY_ACCESSORY_TYPE", 7);
        i = new <init>("ACCESSORY_TYPE", 8);
        j = (new j[] {
            a, b, c, d, e, f, g, h, i
        });
    }

    private (String s, int k)
    {
        super(s, k);
    }
}
