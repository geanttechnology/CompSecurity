// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.qrcode.decoder:
//            Mode, ErrorCorrectionLevel, Version

final class DecodedBitStreamParser
{

    private static final char ALPHANUMERIC_CHARS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', 
        '+', '-', '.', '/', ':'
    };
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser()
    {
    }

    static DecoderResult decode(byte abyte0[], Version version, ErrorCorrectionLevel errorcorrectionlevel, Map map)
    {
        CharacterSetECI characterseteci;
        ArrayList arraylist;
        BitSource bitsource;
        StringBuilder stringbuilder;
        boolean flag;
        bitsource = new BitSource(abyte0);
        stringbuilder = new StringBuilder(50);
        arraylist = new ArrayList(1);
        flag = false;
        characterseteci = null;
_L7:
        if (bitsource.available() >= 4) goto _L2; else goto _L1
_L1:
        Mode mode = Mode.TERMINATOR;
_L8:
        if (mode == Mode.TERMINATOR) goto _L4; else goto _L3
_L3:
        if (mode == Mode.FNC1_FIRST_POSITION || mode == Mode.FNC1_SECOND_POSITION)
        {
            break MISSING_BLOCK_LABEL_373;
        }
          goto _L5
_L4:
        Mode mode1;
        try
        {
            mode1 = Mode.TERMINATOR;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw FormatException.getFormatInstance();
        }
        if (mode != mode1) goto _L7; else goto _L6
_L6:
        map = stringbuilder.toString();
        version = arraylist;
        if (arraylist.isEmpty())
        {
            version = null;
        }
        int i;
        int j;
        if (errorcorrectionlevel == null)
        {
            errorcorrectionlevel = null;
        } else
        {
            errorcorrectionlevel = errorcorrectionlevel.toString();
        }
        return new DecoderResult(abyte0, map, version, errorcorrectionlevel);
_L2:
        mode = Mode.forBits(bitsource.readBits(4));
          goto _L8
_L5:
        if (mode != Mode.STRUCTURED_APPEND)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        if (bitsource.available() < 16)
        {
            throw FormatException.getFormatInstance();
        }
        bitsource.readBits(16);
          goto _L4
        if (mode != Mode.ECI)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        characterseteci = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitsource));
        if (characterseteci != null) goto _L4; else goto _L9
_L9:
        throw FormatException.getFormatInstance();
        if (mode != Mode.HANZI)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        i = bitsource.readBits(4);
        j = bitsource.readBits(mode.getCharacterCountBits(version));
        if (i != 1) goto _L4; else goto _L10
_L10:
        decodeHanziSegment(bitsource, stringbuilder, j);
          goto _L4
label0:
        {
            i = bitsource.readBits(mode.getCharacterCountBits(version));
            if (mode != Mode.NUMERIC)
            {
                break label0;
            }
            decodeNumericSegment(bitsource, stringbuilder, i);
        }
          goto _L4
label1:
        {
            if (mode != Mode.ALPHANUMERIC)
            {
                break label1;
            }
            decodeAlphanumericSegment(bitsource, stringbuilder, i, flag);
        }
          goto _L4
label2:
        {
            if (mode != Mode.BYTE)
            {
                break label2;
            }
            decodeByteSegment(bitsource, stringbuilder, i, characterseteci, arraylist, map);
        }
          goto _L4
label3:
        {
            if (mode != Mode.KANJI)
            {
                break label3;
            }
            decodeKanjiSegment(bitsource, stringbuilder, i);
        }
          goto _L4
        throw FormatException.getFormatInstance();
        flag = true;
          goto _L4
    }

    private static void decodeAlphanumericSegment(BitSource bitsource, StringBuilder stringbuilder, int i, boolean flag)
    {
        int j = stringbuilder.length();
        for (; i > 1; i -= 2)
        {
            if (bitsource.available() < 11)
            {
                throw FormatException.getFormatInstance();
            }
            int k = bitsource.readBits(11);
            stringbuilder.append(toAlphaNumericChar(k / 45));
            stringbuilder.append(toAlphaNumericChar(k % 45));
        }

        if (i == 1)
        {
            if (bitsource.available() < 6)
            {
                throw FormatException.getFormatInstance();
            }
            stringbuilder.append(toAlphaNumericChar(bitsource.readBits(6)));
        }
        if (flag)
        {
            i = j;
            while (i < stringbuilder.length()) 
            {
                if (stringbuilder.charAt(i) == '%')
                {
                    if (i < stringbuilder.length() - 1 && stringbuilder.charAt(i + 1) == '%')
                    {
                        stringbuilder.deleteCharAt(i + 1);
                    } else
                    {
                        stringbuilder.setCharAt(i, '\035');
                    }
                }
                i++;
            }
        }
    }

    private static void decodeByteSegment(BitSource bitsource, StringBuilder stringbuilder, int i, CharacterSetECI characterseteci, Collection collection, Map map)
    {
        if (i << 3 > bitsource.available())
        {
            throw FormatException.getFormatInstance();
        }
        byte abyte0[] = new byte[i];
        for (int j = 0; j < i; j++)
        {
            abyte0[j] = (byte)bitsource.readBits(8);
        }

        if (characterseteci == null)
        {
            bitsource = StringUtils.guessEncoding(abyte0, map);
        } else
        {
            bitsource = characterseteci.name();
        }
        try
        {
            stringbuilder.append(new String(abyte0, bitsource));
        }
        // Misplaced declaration of an exception variable
        catch (BitSource bitsource)
        {
            throw FormatException.getFormatInstance();
        }
        collection.add(abyte0);
    }

    private static void decodeHanziSegment(BitSource bitsource, StringBuilder stringbuilder, int i)
    {
        if (i * 13 > bitsource.available())
        {
            throw FormatException.getFormatInstance();
        }
        byte abyte0[] = new byte[i * 2];
        boolean flag = false;
        int j = i;
        i = ((flag) ? 1 : 0);
        while (j > 0) 
        {
            int k = bitsource.readBits(13);
            k = k % 96 | k / 96 << 8;
            if (k < 959)
            {
                k += 41377;
            } else
            {
                k += 42657;
            }
            abyte0[i] = (byte)(k >> 8 & 0xff);
            abyte0[i + 1] = (byte)(k & 0xff);
            j--;
            i += 2;
        }
        try
        {
            stringbuilder.append(new String(abyte0, "GB2312"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (BitSource bitsource)
        {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitsource, StringBuilder stringbuilder, int i)
    {
        if (i * 13 > bitsource.available())
        {
            throw FormatException.getFormatInstance();
        }
        byte abyte0[] = new byte[i * 2];
        boolean flag = false;
        int j = i;
        i = ((flag) ? 1 : 0);
        while (j > 0) 
        {
            int k = bitsource.readBits(13);
            k = k % 192 | k / 192 << 8;
            if (k < 7936)
            {
                k += 33088;
            } else
            {
                k += 49472;
            }
            abyte0[i] = (byte)(k >> 8);
            abyte0[i + 1] = (byte)k;
            j--;
            i += 2;
        }
        try
        {
            stringbuilder.append(new String(abyte0, "SJIS"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (BitSource bitsource)
        {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeNumericSegment(BitSource bitsource, StringBuilder stringbuilder, int i)
    {
        for (; i >= 3; i -= 3)
        {
            if (bitsource.available() < 10)
            {
                throw FormatException.getFormatInstance();
            }
            int j = bitsource.readBits(10);
            if (j >= 1000)
            {
                throw FormatException.getFormatInstance();
            }
            stringbuilder.append(toAlphaNumericChar(j / 100));
            stringbuilder.append(toAlphaNumericChar((j / 10) % 10));
            stringbuilder.append(toAlphaNumericChar(j % 10));
        }

        if (i == 2)
        {
            if (bitsource.available() < 7)
            {
                throw FormatException.getFormatInstance();
            }
            i = bitsource.readBits(7);
            if (i >= 100)
            {
                throw FormatException.getFormatInstance();
            }
            stringbuilder.append(toAlphaNumericChar(i / 10));
            stringbuilder.append(toAlphaNumericChar(i % 10));
        } else
        if (i == 1)
        {
            if (bitsource.available() < 4)
            {
                throw FormatException.getFormatInstance();
            }
            i = bitsource.readBits(4);
            if (i >= 10)
            {
                throw FormatException.getFormatInstance();
            } else
            {
                stringbuilder.append(toAlphaNumericChar(i));
                return;
            }
        }
    }

    private static int parseECIValue(BitSource bitsource)
    {
        int i = bitsource.readBits(8);
        if ((i & 0x80) == 0)
        {
            return i & 0x7f;
        }
        if ((i & 0xc0) == 128)
        {
            return (i & 0x3f) << 8 | bitsource.readBits(8);
        }
        if ((i & 0xe0) == 192)
        {
            return (i & 0x1f) << 16 | bitsource.readBits(16);
        } else
        {
            throw FormatException.getFormatInstance();
        }
    }

    private static char toAlphaNumericChar(int i)
    {
        if (i >= ALPHANUMERIC_CHARS.length)
        {
            throw FormatException.getFormatInstance();
        } else
        {
            return ALPHANUMERIC_CHARS[i];
        }
    }

}
