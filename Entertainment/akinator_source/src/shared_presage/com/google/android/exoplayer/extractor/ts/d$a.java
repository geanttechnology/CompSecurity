// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import java.util.Arrays;
import shared_presage.com.google.android.exoplayer.util.ParsableBitArray;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.ts:
//            d

private static final class a
{

    private final ParsableBitArray a;
    private byte b[];
    private int c;
    private boolean d;
    private int e;

    public final void a()
    {
        d = false;
        c = 0;
        e = -1;
    }

    public final void a(int i)
    {
        if (i == 1)
        {
            a();
            d = true;
        }
    }

    public final void a(byte abyte0[], int i, int j)
    {
        if (d)
        {
            j -= i;
            if (b.length < c + j)
            {
                b = Arrays.copyOf(b, (c + j) * 2);
            }
            System.arraycopy(abyte0, i, b, c, j);
            c = j + c;
            a.reset(b, c);
            i = a.peekExpGolombCodedNumLength();
            if (i != -1 && i <= a.bitsLeft())
            {
                a.skipBits(i);
                i = a.peekExpGolombCodedNumLength();
                if (i != -1 && i <= a.bitsLeft())
                {
                    e = a.readUnsignedExpGolombCodedInt();
                    d = false;
                    return;
                }
            }
        }
    }

    public final boolean b()
    {
        return e != -1;
    }

    public final int c()
    {
        return e;
    }

    public rray()
    {
        b = new byte[128];
        a = new ParsableBitArray(b);
        a();
    }
}
