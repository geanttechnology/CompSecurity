// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;


// Referenced classes of package com.amazon.gallery.framework.data.store:
//            Asset

public static final class value extends Enum
{

    private static final BOUND_4096 $VALUES[];
    public static final BOUND_4096 BOUND_0;
    public static final BOUND_4096 BOUND_1;
    public static final BOUND_4096 BOUND_1024;
    public static final BOUND_4096 BOUND_128;
    public static final BOUND_4096 BOUND_16;
    public static final BOUND_4096 BOUND_2;
    public static final BOUND_4096 BOUND_2048;
    public static final BOUND_4096 BOUND_256;
    public static final BOUND_4096 BOUND_32;
    public static final BOUND_4096 BOUND_4;
    public static final BOUND_4096 BOUND_4096;
    public static final BOUND_4096 BOUND_512;
    public static final BOUND_4096 BOUND_64;
    public static final BOUND_4096 BOUND_8;
    int value;

    static value getBoundingSize(int i)
        throws oesNotExistException
    {
        switch (i)
        {
        default:
            throw new oesNotExistException();

        case 0: // '\0'
            return BOUND_0;

        case 1: // '\001'
            return BOUND_1;

        case 2: // '\002'
            return BOUND_2;

        case 4: // '\004'
            return BOUND_4;

        case 8: // '\b'
            return BOUND_8;

        case 16: // '\020'
            return BOUND_16;

        case 32: // ' '
            return BOUND_32;

        case 64: // '@'
            return BOUND_64;

        case 128: 
            return BOUND_128;

        case 256: 
            return BOUND_256;

        case 512: 
            return BOUND_512;

        case 1024: 
            return BOUND_1024;

        case 2048: 
            return BOUND_2048;

        case 4096: 
            return BOUND_4096;
        }
    }

    public static BOUND_4096 valueOf(String s)
    {
        return (BOUND_4096)Enum.valueOf(com/amazon/gallery/framework/data/store/Asset$BoundingSize, s);
    }

    public static BOUND_4096[] values()
    {
        return (BOUND_4096[])$VALUES.clone();
    }

    public int getSize()
    {
        return value;
    }

    static 
    {
        BOUND_0 = new <init>("BOUND_0", 0, 0);
        BOUND_1 = new <init>("BOUND_1", 1, 1);
        BOUND_2 = new <init>("BOUND_2", 2, 2);
        BOUND_4 = new <init>("BOUND_4", 3, 4);
        BOUND_8 = new <init>("BOUND_8", 4, 8);
        BOUND_16 = new <init>("BOUND_16", 5, 16);
        BOUND_32 = new <init>("BOUND_32", 6, 32);
        BOUND_64 = new <init>("BOUND_64", 7, 64);
        BOUND_128 = new <init>("BOUND_128", 8, 128);
        BOUND_256 = new <init>("BOUND_256", 9, 256);
        BOUND_512 = new <init>("BOUND_512", 10, 512);
        BOUND_1024 = new <init>("BOUND_1024", 11, 1024);
        BOUND_2048 = new <init>("BOUND_2048", 12, 2048);
        BOUND_4096 = new <init>("BOUND_4096", 13, 4096);
        $VALUES = (new .VALUES[] {
            BOUND_0, BOUND_1, BOUND_2, BOUND_4, BOUND_8, BOUND_16, BOUND_32, BOUND_64, BOUND_128, BOUND_256, 
            BOUND_512, BOUND_1024, BOUND_2048, BOUND_4096
        });
    }

    private oesNotExistException(String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
