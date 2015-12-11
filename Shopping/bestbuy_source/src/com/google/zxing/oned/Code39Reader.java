// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            OneDReader

public final class Code39Reader extends OneDReader
{

    private static final char ALPHABET[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[39];
    static final int CHARACTER_ENCODINGS[] = {
        52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 
        265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 
        259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 
        385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 
        168, 162, 138, 42
    };
    private final int counters[];
    private final StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    public Code39Reader()
    {
        this(false);
    }

    public Code39Reader(boolean flag)
    {
        this(flag, false);
    }

    public Code39Reader(boolean flag, boolean flag1)
    {
        usingCheckDigit = flag;
        extendedMode = flag1;
        decodeRowResult = new StringBuilder(20);
        counters = new int[9];
    }

    private static String decodeExtended(CharSequence charsequence)
    {
        StringBuilder stringbuilder;
        int i;
        int j;
        j = charsequence.length();
        stringbuilder = new StringBuilder(j);
        i = 0;
_L9:
        char c;
        char c1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_289;
        }
        c = charsequence.charAt(i);
        if (c != '+' && c != '$' && c != '%' && c != '/')
        {
            break MISSING_BLOCK_LABEL_280;
        }
        c1 = charsequence.charAt(i + 1);
        c;
        JVM INSTR lookupswitch 4: default 112
    //                   36: 159
    //                   37: 187
    //                   43: 131
    //                   47: 239;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        c = '\0';
_L6:
        stringbuilder.append(c);
        i++;
_L7:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        if (c1 >= 'A' && c1 <= 'Z')
        {
            c = (char)(c1 + 32);
        } else
        {
            throw FormatException.getFormatInstance();
        }
          goto _L6
_L2:
        if (c1 >= 'A' && c1 <= 'Z')
        {
            c = (char)(c1 - 64);
        } else
        {
            throw FormatException.getFormatInstance();
        }
          goto _L6
_L3:
        if (c1 >= 'A' && c1 <= 'E')
        {
            c = (char)(c1 - 38);
        } else
        if (c1 >= 'F' && c1 <= 'W')
        {
            c = (char)(c1 - 11);
        } else
        {
            throw FormatException.getFormatInstance();
        }
          goto _L6
_L5:
        if (c1 >= 'A' && c1 <= 'O')
        {
            c = (char)(c1 - 32);
        } else
        if (c1 == 'Z')
        {
            c = ':';
        } else
        {
            throw FormatException.getFormatInstance();
        }
          goto _L6
        stringbuilder.append(c);
          goto _L7
        return stringbuilder.toString();
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static int[] findAsteriskPattern(BitArray bitarray, int ai[])
    {
        int j1 = bitarray.getSize();
        int i = bitarray.getNextSet(0);
        int k1 = ai.length;
        int k = i;
        int l = 0;
        int i1 = 0;
        while (k < j1) 
        {
            int j;
            if ((bitarray.get(k) ^ l) != 0)
            {
                ai[i1] = ai[i1] + 1;
                j = l;
                l = i;
            } else
            {
                if (i1 == k1 - 1)
                {
                    if (toNarrowWidePattern(ai) == ASTERISK_ENCODING && bitarray.isRange(Math.max(0, i - (k - i >> 1)), i, false))
                    {
                        return (new int[] {
                            i, k
                        });
                    }
                    j = i + (ai[0] + ai[1]);
                    System.arraycopy(ai, 2, ai, 0, k1 - 2);
                    ai[k1 - 2] = 0;
                    ai[k1 - 1] = 0;
                    i = i1 - 1;
                } else
                {
                    i1++;
                    j = i;
                    i = i1;
                }
                ai[i] = 1;
                if (l == 0)
                {
                    boolean flag = true;
                    l = j;
                    i1 = i;
                    j = ((flag) ? 1 : 0);
                } else
                {
                    boolean flag1 = false;
                    l = j;
                    i1 = i;
                    j = ((flag1) ? 1 : 0);
                }
            }
            k++;
            i = l;
            l = j;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char patternToChar(int i)
    {
        for (int j = 0; j < CHARACTER_ENCODINGS.length; j++)
        {
            if (CHARACTER_ENCODINGS[j] == i)
            {
                return ALPHABET[j];
            }
        }

        throw NotFoundException.getNotFoundInstance();
    }

    private static int toNarrowWidePattern(int ai[])
    {
        boolean flag = false;
        int l3 = ai.length;
        int j = 0;
        do
        {
            int i = 0x7fffffff;
            int j2 = ai.length;
            for (int k = 0; k < j2;)
            {
                int k1 = ai[k];
                int i1 = i;
                if (k1 < i)
                {
                    i1 = i;
                    if (k1 > j)
                    {
                        i1 = k1;
                    }
                }
                k++;
                i = i1;
            }

            int l = 0;
            int l1 = 0;
            j = 0;
            int j1;
            int k2;
            for (j1 = 0; l1 < l3; j1 = k2)
            {
                int i4 = ai[l1];
                int k3 = l;
                int i3 = j;
                k2 = j1;
                if (i4 > i)
                {
                    i3 = j | 1 << l3 - 1 - l1;
                    k3 = l + 1;
                    k2 = j1 + i4;
                }
                l1++;
                l = k3;
                j = i3;
            }

            if (l == 3)
            {
                int i2 = ((flag) ? 1 : 0);
                do
                {
                    int l2;
label0:
                    {
                        l2 = j;
                        if (i2 < l3)
                        {
                            l2 = j;
                            if (l > 0)
                            {
                                int j3 = ai[i2];
                                l2 = l;
                                if (j3 <= i)
                                {
                                    break label0;
                                }
                                l2 = l - 1;
                                if (j3 << 1 < j1)
                                {
                                    break label0;
                                }
                                l2 = -1;
                            }
                        }
                        return l2;
                    }
                    i2++;
                    l = l2;
                } while (true);
            }
            if (l <= 3)
            {
                return -1;
            }
            j = i;
        } while (true);
    }

    public Result decodeRow(int i, BitArray bitarray, Map map)
    {
        int ai[] = counters;
        Arrays.fill(ai, 0);
        Object obj = decodeRowResult;
        ((StringBuilder) (obj)).setLength(0);
        map = findAsteriskPattern(bitarray, ai);
        int j = bitarray.getNextSet(map[1]);
        int i2 = bitarray.getSize();
        do
        {
            recordPattern(bitarray, j, ai);
            int k = toNarrowWidePattern(ai);
            if (k < 0)
            {
                throw NotFoundException.getNotFoundInstance();
            }
            char c = patternToChar(k);
            ((StringBuilder) (obj)).append(c);
            int l1 = ai.length;
            k = 0;
            int i1 = j;
            for (; k < l1; k++)
            {
                i1 += ai[k];
            }

            l1 = bitarray.getNextSet(i1);
            if (c == '*')
            {
                ((StringBuilder) (obj)).setLength(((StringBuilder) (obj)).length() - 1);
                int l = 0;
                int k2 = ai.length;
                for (int j1 = 0; j1 < k2; j1++)
                {
                    l += ai[j1];
                }

                if (l1 != i2 && l1 - j - l >> 1 < l)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (usingCheckDigit)
                {
                    int j2 = ((StringBuilder) (obj)).length() - 1;
                    l1 = 0;
                    for (int k1 = 0; k1 < j2; k1++)
                    {
                        l1 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(decodeRowResult.charAt(k1));
                    }

                    if (((StringBuilder) (obj)).charAt(j2) != ALPHABET[l1 % 43])
                    {
                        throw ChecksumException.getChecksumInstance();
                    }
                    ((StringBuilder) (obj)).setLength(j2);
                }
                if (((StringBuilder) (obj)).length() == 0)
                {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f;
                float f1;
                float f2;
                ResultPoint resultpoint;
                if (extendedMode)
                {
                    bitarray = decodeExtended(((CharSequence) (obj)));
                } else
                {
                    bitarray = ((StringBuilder) (obj)).toString();
                }
                f = (float)(map[1] + map[0]) / 2.0F;
                f1 = j;
                f2 = (float)l / 2.0F;
                map = new ResultPoint(f, i);
                resultpoint = new ResultPoint(f1 + f2, i);
                obj = BarcodeFormat.CODE_39;
                return new Result(bitarray, null, new ResultPoint[] {
                    map, resultpoint
                }, ((BarcodeFormat) (obj)));
            }
            j = l1;
        } while (true);
    }

}
