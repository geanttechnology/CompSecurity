// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import java.io.IOException;

// Referenced classes of package com.amazon.client.framework.androidresparser:
//            WordReader

public class Res_value
{

    public static final int COMPLEX_MANTISSA_MASK = 0xffffff;
    public static final int COMPLEX_MANTISSA_SHIFT = 8;
    public static final int COMPLEX_RADIX_0p23 = 3;
    public static final int COMPLEX_RADIX_16p7 = 1;
    public static final int COMPLEX_RADIX_23p0 = 0;
    public static final int COMPLEX_RADIX_8p15 = 2;
    public static final int COMPLEX_RADIX_MASK = 3;
    public static final int COMPLEX_RADIX_SHIFT = 4;
    public static final int COMPLEX_UNIT_DIP = 1;
    public static final int COMPLEX_UNIT_FRACTION = 0;
    public static final int COMPLEX_UNIT_FRACTION_PARENT = 1;
    public static final int COMPLEX_UNIT_IN = 4;
    public static final int COMPLEX_UNIT_MASK = 15;
    public static final int COMPLEX_UNIT_MM = 5;
    public static final int COMPLEX_UNIT_PT = 3;
    public static final int COMPLEX_UNIT_PX = 0;
    public static final int COMPLEX_UNIT_SHIFT = 0;
    public static final int COMPLEX_UNIT_SP = 2;
    public static final int TYPE_ATTRIBUTE = 2;
    public static final int TYPE_DIMENSION = 5;
    public static final int TYPE_FIRST_COLOR_INT = 28;
    public static final int TYPE_FIRST_INT = 16;
    public static final int TYPE_FLOAT = 4;
    public static final int TYPE_FRACTION = 6;
    public static final int TYPE_INT_BOOLEAN = 18;
    public static final int TYPE_INT_COLOR_ARGB4 = 30;
    public static final int TYPE_INT_COLOR_ARGB8 = 28;
    public static final int TYPE_INT_COLOR_RGB4 = 31;
    public static final int TYPE_INT_COLOR_RGB8 = 29;
    public static final int TYPE_INT_DEC = 16;
    public static final int TYPE_INT_HEX = 17;
    public static final int TYPE_LAST_COLOR_INT = 31;
    public static final int TYPE_LAST_INT = 31;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_REFERENCE = 1;
    public static final int TYPE_STRING = 3;
    public static final int sizeof = 8;
    public int data;
    public int dataType;
    public int res0;
    public int size;

    public Res_value()
    {
    }

    public static int readValue(WordReader wordreader, Res_value res_value)
        throws IOException
    {
        res_value.size = wordreader.readWord();
        res_value.res0 = wordreader.readByte();
        res_value.dataType = wordreader.readByte();
        res_value.data = wordreader.readDWord();
        return 8;
    }

    public static int readValue(byte abyte0[], int i, Res_value res_value)
    {
        res_value.size = WordReader.readBytesFrom(abyte0, i, 2);
        i += 2;
        res_value.res0 = WordReader.readBytesFrom(abyte0, i, 1);
        i++;
        res_value.dataType = WordReader.readBytesFrom(abyte0, i, 1);
        i++;
        res_value.data = WordReader.readBytesFrom(abyte0, i, 4);
        return 8;
    }
}
