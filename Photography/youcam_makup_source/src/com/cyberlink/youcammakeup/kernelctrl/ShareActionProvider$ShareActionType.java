// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;


public final class  extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    private static final k l[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/ShareActionProvider$ShareActionType, s);
    }

    public static [] values()
    {
        return ([])l.clone();
    }

    static 
    {
        a = new <init>("Facebook", 0);
        b = new <init>("YouCamPerfectEdit", 1);
        c = new <init>("YouCamPerfectCollage", 2);
        d = new <init>("U", 3);
        e = new <init>("WeChat", 4);
        f = new <init>("WeChatMoment", 5);
        g = new <init>("Weibo", 6);
        h = new <init>("BeautyCircle", 7);
        i = new <init>("WhatsApp", 8);
        j = new <init>("Instagram", 9);
        k = new <init>("Line", 10);
        l = (new l[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }

    private (String s, int i1)
    {
        super(s, i1);
    }
}
