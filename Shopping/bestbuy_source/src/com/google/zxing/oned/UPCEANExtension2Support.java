// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader

final class UPCEANExtension2Support
{

    private final int decodeMiddleCounters[] = new int[4];
    private final StringBuilder decodeRowStringBuffer = new StringBuilder();

    UPCEANExtension2Support()
    {
    }

    private static Map parseExtensionString(String s)
    {
        if (s.length() != 2)
        {
            return null;
        } else
        {
            EnumMap enummap = new EnumMap(com/google/zxing/ResultMetadataType);
            enummap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(s));
            return enummap;
        }
    }

    int decodeMiddle(BitArray bitarray, int ai[], StringBuilder stringbuilder)
    {
        int ai1[] = decodeMiddleCounters;
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        ai1[3] = 0;
        int j1 = bitarray.getSize();
        int i = ai[1];
        int k = 0;
        int j;
        int i1;
        for (j = 0; k < 2 && i < j1; j = i1)
        {
            int k1 = UPCEANReader.decodeDigit(bitarray, ai1, i, UPCEANReader.L_AND_G_PATTERNS);
            stringbuilder.append((char)(k1 % 10 + 48));
            int l1 = ai1.length;
            for (int l = 0; l < l1;)
            {
                int i2 = ai1[l];
                l++;
                i = i2 + i;
            }

            i1 = j;
            if (k1 >= 10)
            {
                i1 = j | 1 << 1 - k;
            }
            j = i;
            if (k != 1)
            {
                j = bitarray.getNextUnset(bitarray.getNextSet(i));
            }
            k++;
            i = j;
        }

        if (stringbuilder.length() != 2)
        {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(stringbuilder.toString()) % 4 != j)
        {
            throw NotFoundException.getNotFoundInstance();
        } else
        {
            return i;
        }
    }

    Result decodeRow(int i, BitArray bitarray, int ai[])
    {
        Object obj = decodeRowStringBuffer;
        ((StringBuilder) (obj)).setLength(0);
        int j = decodeMiddle(bitarray, ai, ((StringBuilder) (obj)));
        obj = ((StringBuilder) (obj)).toString();
        bitarray = parseExtensionString(((String) (obj)));
        ai = new ResultPoint((float)(ai[0] + ai[1]) / 2.0F, i);
        ResultPoint resultpoint = new ResultPoint(j, i);
        BarcodeFormat barcodeformat = BarcodeFormat.UPC_EAN_EXTENSION;
        ai = new Result(((String) (obj)), null, new ResultPoint[] {
            ai, resultpoint
        }, barcodeformat);
        if (bitarray != null)
        {
            ai.putAllMetadata(bitarray);
        }
        return ai;
    }
}
