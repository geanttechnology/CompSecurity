// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.mp4;

import shared_presage.com.google.android.exoplayer.extractor.ExtractorInput;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.extractor.mp4:
//            a

final class d
{

    private static final int a[] = {
        Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), 
        Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")
    };

    public static boolean a(ExtractorInput extractorinput)
    {
        return a(extractorinput, 4096, true);
    }

    private static boolean a(ExtractorInput extractorinput, int i, boolean flag)
    {
        ParsableByteArray parsablebytearray;
        int j;
        int k;
        int i1;
        boolean flag2;
        long l2;
label0:
        {
            long l4 = extractorinput.getLength();
            if (l4 != -1L)
            {
                l2 = l4;
                if (l4 <= (long)i)
                {
                    break label0;
                }
            }
            l2 = i;
        }
        i1 = (int)l2;
        parsablebytearray = new ParsableByteArray(64);
        k = 0;
        flag2 = false;
        j = 0;
_L17:
        boolean flag1 = flag2;
        if (j >= i1) goto _L2; else goto _L1
_L1:
        extractorinput.peekFully(parsablebytearray.data, 0, 8);
        parsablebytearray.setPosition(0);
        long l3 = parsablebytearray.readUnsignedInt();
        int l = parsablebytearray.readInt();
        int ai[];
        int j1;
        int k1;
        int l1;
        if (l3 == 1L)
        {
            extractorinput.peekFully(parsablebytearray.data, 8, 8);
            l3 = parsablebytearray.readLong();
            i = 16;
        } else
        {
            i = 8;
        }
        if (l3 < (long)i || l3 > 0x7fffffffL)
        {
            return false;
        }
        flag1 = flag2;
        if ((long)j + l3 > (long)i1) goto _L2; else goto _L3
_L3:
        j1 = (int)l3 - i;
        if (l != a.a) goto _L5; else goto _L4
_L4:
        if (j1 < 8)
        {
            return false;
        }
        j1 = (j1 - 8) / 4;
        extractorinput.peekFully(parsablebytearray.data, 0, (j1 + 2) * 4);
        l = 0;
_L15:
        i = k;
        if (l >= j1 + 2) goto _L7; else goto _L6
_L6:
        if (l == 1) goto _L9; else goto _L8
_L8:
        k1 = parsablebytearray.readInt();
        if (k1 >>> 8 != Util.getIntegerCodeForString("3gp")) goto _L11; else goto _L10
_L10:
        i = 1;
_L13:
        if (i == 0) goto _L9; else goto _L12
_L12:
        i = 1;
_L7:
        j = (int)((long)j + l3);
        k = i;
        continue; /* Loop/switch isn't completed */
_L11:
        ai = a;
        l1 = ai.length;
        i = 0;
_L14:
label1:
        {
            if (i >= l1)
            {
                break MISSING_BLOCK_LABEL_316;
            }
            if (ai[i] != k1)
            {
                break label1;
            }
            i = 1;
        }
          goto _L13
        i++;
          goto _L14
        i = 0;
          goto _L13
_L9:
        l++;
          goto _L15
_L5:
        if (l != a.B)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        flag1 = true;
_L2:
        if (k != 0 && flag == flag1)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_376;
        i = k;
        if (j1 != 0)
        {
            extractorinput.advancePeekPosition(j1);
            i = k;
        }
          goto _L7
        return false;
        if (true) goto _L17; else goto _L16
_L16:
    }

    public static boolean b(ExtractorInput extractorinput)
    {
        return a(extractorinput, 128, false);
    }

}
