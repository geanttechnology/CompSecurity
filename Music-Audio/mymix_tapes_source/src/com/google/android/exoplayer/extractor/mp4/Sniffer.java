// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.extractor.mp4:
//            Atom

final class Sniffer
{

    private static final int COMPATIBLE_BRANDS[] = {
        Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), 
        Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")
    };

    private Sniffer()
    {
    }

    private static boolean isCompatibleBrand(int i)
    {
        if (i >>> 8 != Util.getIntegerCodeForString("3gp")) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int ai[] = COMPATIBLE_BRANDS;
        int k = ai.length;
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= k)
                {
                    break label1;
                }
                if (ai[j] == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorinput)
        throws IOException, InterruptedException
    {
        return sniffInternal(extractorinput, 4096, true);
    }

    private static boolean sniffInternal(ExtractorInput extractorinput, int i, boolean flag)
        throws IOException, InterruptedException
    {
        ParsableByteArray parsablebytearray;
        boolean flag1;
        int l;
        boolean flag3;
        long l1;
label0:
        {
            long l3 = extractorinput.getLength();
            if (l3 != -1L)
            {
                l1 = l3;
                if (l3 <= (long)i)
                {
                    break label0;
                }
            }
            l1 = i;
        }
        l = (int)l1;
        parsablebytearray = new ParsableByteArray(64);
        i = 0;
        flag1 = false;
        flag3 = false;
_L12:
        boolean flag2 = flag3;
        if (i >= l) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        long l2;
        j = 8;
        extractorinput.peekFully(parsablebytearray.data, 0, 8);
        parsablebytearray.setPosition(0);
        long l4 = parsablebytearray.readUnsignedInt();
        k = parsablebytearray.readInt();
        l2 = l4;
        if (l4 == 1L)
        {
            extractorinput.peekFully(parsablebytearray.data, 8, 8);
            j = 16;
            l2 = parsablebytearray.readLong();
        }
        if (l2 < (long)j || l2 > 0x7fffffffL)
        {
            return false;
        }
        if ((long)i + l2 <= (long)l) goto _L4; else goto _L3
_L3:
        flag2 = flag3;
_L2:
        int i1;
        return flag1 && flag == flag2;
_L4:
        i1 = (int)l2 - j;
        if (k != Atom.TYPE_ftyp) goto _L6; else goto _L5
_L5:
        if (i1 < 8)
        {
            return false;
        }
        i1 = (i1 - 8) / 4;
        extractorinput.peekFully(parsablebytearray.data, 0, (i1 + 2) * 4);
        k = 0;
_L9:
        j = ((flag1) ? 1 : 0);
        if (k >= i1 + 2)
        {
            break; /* Loop/switch isn't completed */
        }
          goto _L7
_L11:
        k++;
        if (true) goto _L9; else goto _L8
_L7:
        if (k == 1 || !isCompatibleBrand(parsablebytearray.readInt())) goto _L11; else goto _L10
_L10:
        j = 1;
_L8:
        i = (int)((long)i + l2);
        flag1 = j;
          goto _L12
_L6:
label1:
        {
            if (k != Atom.TYPE_moof)
            {
                break label1;
            }
            flag2 = true;
        }
          goto _L2
        j = ((flag1) ? 1 : 0);
        if (i1 != 0)
        {
            extractorinput.advancePeekPosition(i1);
            j = ((flag1) ? 1 : 0);
        }
          goto _L8
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorinput)
        throws IOException, InterruptedException
    {
        return sniffInternal(extractorinput, 128, false);
    }

}
