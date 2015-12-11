// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.FormatException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANReader, EAN13Reader

public final class UPCAReader extends UPCEANReader
{

    private final UPCEANReader ean13Reader = new EAN13Reader();

    public UPCAReader()
    {
    }

    private static Result maybeReturnResult(Result result)
    {
        String s = result.getText();
        if (s.charAt(0) == '0')
        {
            return new Result(s.substring(1), null, result.getResultPoints(), BarcodeFormat.UPC_A);
        } else
        {
            throw FormatException.getFormatInstance();
        }
    }

    public Result decode(BinaryBitmap binarybitmap)
    {
        return maybeReturnResult(ean13Reader.decode(binarybitmap));
    }

    public Result decode(BinaryBitmap binarybitmap, Map map)
    {
        return maybeReturnResult(ean13Reader.decode(binarybitmap, map));
    }

    protected int decodeMiddle(BitArray bitarray, int ai[], StringBuilder stringbuilder)
    {
        return ean13Reader.decodeMiddle(bitarray, ai, stringbuilder);
    }

    public Result decodeRow(int i, BitArray bitarray, Map map)
    {
        return maybeReturnResult(ean13Reader.decodeRow(i, bitarray, map));
    }

    public Result decodeRow(int i, BitArray bitarray, int ai[], Map map)
    {
        return maybeReturnResult(ean13Reader.decodeRow(i, bitarray, ai, map));
    }

    BarcodeFormat getBarcodeFormat()
    {
        return BarcodeFormat.UPC_A;
    }
}
