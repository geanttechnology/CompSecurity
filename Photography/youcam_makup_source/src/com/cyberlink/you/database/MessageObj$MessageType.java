// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;


public final class  extends Enum
{

    public static final n a;
    public static final n b;
    public static final n c;
    public static final n d;
    public static final n e;
    public static final n f;
    public static final n g;
    public static final n h;
    public static final n i;
    public static final n j;
    public static final n k;
    public static final n l;
    public static final n m;
    public static final n n;
    private static final n o[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/you/database/MessageObj$MessageType, s);
    }

    public static [] values()
    {
        return ([])o.clone();
    }

    static 
    {
        a = new <init>("Text", 0);
        b = new <init>("Photo", 1);
        c = new <init>("Sticker", 2);
        d = new <init>("AnimSticker", 3);
        e = new <init>("DeliveryReceipt", 4);
        f = new <init>("None", 5);
        g = new <init>("Date", 6);
        h = new <init>("Event", 7);
        i = new <init>("AnimPngSticker", 8);
        j = new <init>("NewVersion", 9);
        k = new <init>("StickerTypeUnknown", 10);
        l = new <init>("UnreadLine", 11);
        m = new <init>("ReplyText", 12);
        n = new <init>("BCPost", 13);
        o = (new o[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n
        });
    }

    private (String s, int i1)
    {
        super(s, i1);
    }
}
