// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c;


public final class c extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;
    private static final c k[];

    private c(String s, int l)
    {
        super(s, l);
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/google/c/c, s);
    }

    public static c[] values()
    {
        return (c[])k.clone();
    }

    static 
    {
        a = new c("ERROR_CORRECTION", 0);
        b = new c("CHARACTER_SET", 1);
        c = new c("DATA_MATRIX_SHAPE", 2);
        d = new c("MIN_SIZE", 3);
        e = new c("MAX_SIZE", 4);
        f = new c("MARGIN", 5);
        g = new c("PDF417_COMPACT", 6);
        h = new c("PDF417_COMPACTION", 7);
        i = new c("PDF417_DIMENSIONS", 8);
        j = new c("AZTEC_LAYERS", 9);
        k = (new c[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
