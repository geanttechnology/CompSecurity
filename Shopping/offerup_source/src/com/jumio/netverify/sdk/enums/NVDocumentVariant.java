// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.enums;


public final class NVDocumentVariant extends Enum
{

    private static final NVDocumentVariant $VALUES[];
    public static final NVDocumentVariant PAPER;
    public static final NVDocumentVariant PLASTIC;

    private NVDocumentVariant(String s, int i)
    {
        super(s, i);
    }

    public static NVDocumentVariant valueOf(String s)
    {
        return (NVDocumentVariant)Enum.valueOf(com/jumio/netverify/sdk/enums/NVDocumentVariant, s);
    }

    public static NVDocumentVariant[] values()
    {
        return (NVDocumentVariant[])$VALUES.clone();
    }

    static 
    {
        PAPER = new NVDocumentVariant("PAPER", 0);
        PLASTIC = new NVDocumentVariant("PLASTIC", 1);
        $VALUES = (new NVDocumentVariant[] {
            PAPER, PLASTIC
        });
    }
}
