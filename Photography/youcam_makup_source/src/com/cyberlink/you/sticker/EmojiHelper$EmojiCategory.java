// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;


public final class _cls9 extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/cyberlink/you/sticker/EmojiHelper$EmojiCategory, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])f.clone();
    }

    static 
    {
        a = new <init>("People", 0);
        b = new <init>("Nature", 1);
        c = new <init>("Objects", 2);
        d = new <init>("Cars", 3);
        e = new <init>("Punctuation", 4);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
