// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;


// Referenced classes of package com.google.zxing.qrcode.decoder:
//            Version

public final class Mode extends Enum
{

    private static final Mode $VALUES[];
    public static final Mode ALPHANUMERIC;
    public static final Mode BYTE;
    public static final Mode ECI;
    public static final Mode FNC1_FIRST_POSITION;
    public static final Mode FNC1_SECOND_POSITION;
    public static final Mode HANZI;
    public static final Mode KANJI;
    public static final Mode NUMERIC;
    public static final Mode STRUCTURED_APPEND;
    public static final Mode TERMINATOR;
    private final int bits;
    private final int characterCountBitsForVersions[];

    private Mode(String s, int i, int ai[], int j)
    {
        super(s, i);
        characterCountBitsForVersions = ai;
        bits = j;
    }

    public static Mode forBits(int i)
    {
        switch (i)
        {
        case 6: // '\006'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        default:
            throw new IllegalArgumentException();

        case 0: // '\0'
            return TERMINATOR;

        case 1: // '\001'
            return NUMERIC;

        case 2: // '\002'
            return ALPHANUMERIC;

        case 3: // '\003'
            return STRUCTURED_APPEND;

        case 4: // '\004'
            return BYTE;

        case 5: // '\005'
            return FNC1_FIRST_POSITION;

        case 7: // '\007'
            return ECI;

        case 8: // '\b'
            return KANJI;

        case 9: // '\t'
            return FNC1_SECOND_POSITION;

        case 13: // '\r'
            return HANZI;
        }
    }

    public static Mode valueOf(String s)
    {
        return (Mode)Enum.valueOf(com/google/zxing/qrcode/decoder/Mode, s);
    }

    public static Mode[] values()
    {
        return (Mode[])$VALUES.clone();
    }

    public int getBits()
    {
        return bits;
    }

    public int getCharacterCountBits(Version version)
    {
        int i = version.getVersionNumber();
        if (i <= 9)
        {
            i = 0;
        } else
        if (i <= 26)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        return characterCountBitsForVersions[i];
    }

    static 
    {
        TERMINATOR = new Mode("TERMINATOR", 0, new int[] {
            0, 0, 0
        }, 0);
        NUMERIC = new Mode("NUMERIC", 1, new int[] {
            10, 12, 14
        }, 1);
        ALPHANUMERIC = new Mode("ALPHANUMERIC", 2, new int[] {
            9, 11, 13
        }, 2);
        STRUCTURED_APPEND = new Mode("STRUCTURED_APPEND", 3, new int[] {
            0, 0, 0
        }, 3);
        BYTE = new Mode("BYTE", 4, new int[] {
            8, 16, 16
        }, 4);
        ECI = new Mode("ECI", 5, new int[] {
            0, 0, 0
        }, 7);
        KANJI = new Mode("KANJI", 6, new int[] {
            8, 10, 12
        }, 8);
        FNC1_FIRST_POSITION = new Mode("FNC1_FIRST_POSITION", 7, new int[] {
            0, 0, 0
        }, 5);
        FNC1_SECOND_POSITION = new Mode("FNC1_SECOND_POSITION", 8, new int[] {
            0, 0, 0
        }, 9);
        HANZI = new Mode("HANZI", 9, new int[] {
            8, 10, 12
        }, 13);
        $VALUES = (new Mode[] {
            TERMINATOR, NUMERIC, ALPHANUMERIC, STRUCTURED_APPEND, BYTE, ECI, KANJI, FNC1_FIRST_POSITION, FNC1_SECOND_POSITION, HANZI
        });
    }
}
