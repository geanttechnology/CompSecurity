// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

// Referenced classes of package com.google.zxing:
//            LuminanceSource

public abstract class Binarizer
{

    private final LuminanceSource source;

    public Binarizer(LuminanceSource luminancesource)
    {
        source = luminancesource;
    }

    public abstract Binarizer createBinarizer(LuminanceSource luminancesource);

    public abstract BitMatrix getBlackMatrix();

    public abstract BitArray getBlackRow(int i, BitArray bitarray);

    public final int getHeight()
    {
        return source.getHeight();
    }

    public final LuminanceSource getLuminanceSource()
    {
        return source;
    }

    public final int getWidth()
    {
        return source.getWidth();
    }
}
