// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.SparseIntArray;
import java.nio.ByteBuffer;

final class cih
{

    private static final SparseIntArray a;

    public static byte[] a(aoq aoq1, aon aon1)
    {
        int i = a.get(aon1.g, -1);
        byte abyte0[];
        int j;
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        j = aoq1.c + 7;
        abyte0 = new byte[j];
        abyte0[0] = -1;
        abyte0[1] = -15;
        abyte0[2] = (byte)(i << 2 | 0x40 | aon1.f >> 2);
        abyte0[3] = (byte)((aon1.f & 3) << 6 | j >> 11);
        abyte0[4] = (byte)(j >> 3);
        abyte0[5] = (byte)((j & 7) << 5 | 0x1f);
        abyte0[6] = -4;
        System.arraycopy(aoq1.b.array(), 0, abyte0, 7, aoq1.c);
        return abyte0;
    }

    static 
    {
        a = new SparseIntArray(13);
        for (int i = 0; i < 13; i++)
        {
            a.append((new int[] {
                0x17700, 0x15888, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 
                11025, 8000, 7350
            })[i], i);
        }

    }
}
