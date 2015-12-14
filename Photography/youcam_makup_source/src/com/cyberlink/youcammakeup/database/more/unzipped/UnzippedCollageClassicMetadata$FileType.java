// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.unzipped;


public final class  extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    private static final f g[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/database/more/unzipped/UnzippedCollageClassicMetadata$FileType, s);
    }

    public static [] values()
    {
        return ([])g.clone();
    }

    static 
    {
        a = new <init>("THUMBNAIL", 0);
        b = new <init>("LAYOUT_XML", 1);
        c = new <init>("LAYOUT_PICTURE", 2);
        d = new <init>("COVER_MASK", 3);
        e = new <init>("GLOBAL_MASK", 4);
        f = new <init>("THUMBNAIL_2", 5);
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
