// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.module;


public final class KindleFamily extends Enum
{

    private static final KindleFamily $VALUES[];
    public static final KindleFamily GEN5;
    public static final KindleFamily GEN6;
    public static final KindleFamily GEN7;

    private KindleFamily(String s, int i)
    {
        super(s, i);
    }

    public static KindleFamily valueOf(String s)
    {
        return (KindleFamily)Enum.valueOf(com/amazon/shopapp/voice/module/KindleFamily, s);
    }

    public static KindleFamily[] values()
    {
        return (KindleFamily[])$VALUES.clone();
    }

    static 
    {
        GEN5 = new KindleFamily("GEN5", 0);
        GEN6 = new KindleFamily("GEN6", 1);
        GEN7 = new KindleFamily("GEN7", 2);
        $VALUES = (new KindleFamily[] {
            GEN5, GEN6, GEN7
        });
    }
}
