// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            Descriptors

static final class A extends Enum
{

    private static final ALL_SYMBOLS $VALUES[];
    public static final ALL_SYMBOLS AGGREGATES_ONLY;
    public static final ALL_SYMBOLS ALL_SYMBOLS;
    public static final ALL_SYMBOLS TYPES_ONLY;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/google/protobuf/Descriptors$DescriptorPool$SearchFilter, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        TYPES_ONLY = new <init>("TYPES_ONLY", 0);
        AGGREGATES_ONLY = new <init>("AGGREGATES_ONLY", 1);
        ALL_SYMBOLS = new <init>("ALL_SYMBOLS", 2);
        $VALUES = (new .VALUES[] {
            TYPES_ONLY, AGGREGATES_ONLY, ALL_SYMBOLS
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
