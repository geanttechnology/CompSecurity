// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import java.io.IOException;
import java.io.InputStream;

public final class GifFormatChecker
{

    private static final byte FRAME_HEADER_END_1[] = {
        0, 44
    };
    private static final byte FRAME_HEADER_END_2[] = {
        0, 33
    };
    private static final int FRAME_HEADER_SIZE = 10;
    private static final byte FRAME_HEADER_START[] = {
        0, 33, -7, 4
    };

    private GifFormatChecker()
    {
    }

    static boolean circularBufferMatchesBytePattern(byte abyte0[], int i, byte abyte1[])
    {
        Preconditions.checkNotNull(abyte0);
        Preconditions.checkNotNull(abyte1);
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (abyte1.length <= abyte0.length) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= abyte1.length)
                {
                    break label1;
                }
                if (abyte0[(j + i) % abyte0.length] != abyte1[j])
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static boolean isAnimated(InputStream inputstream)
    {
        int j;
        int k;
        byte abyte0[] = new byte[10];
        int i;
        try
        {
            inputstream.read(abyte0, 0, 10);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new RuntimeException(inputstream);
        }
        i = 0;
        k = 0;
_L9:
        if (inputstream.read(abyte0, i, 1) <= 0) goto _L2; else goto _L1
_L1:
        j = k;
        if (!circularBufferMatchesBytePattern(abyte0, i + 1, FRAME_HEADER_START)) goto _L4; else goto _L3
_L3:
        if (circularBufferMatchesBytePattern(abyte0, i + 9, FRAME_HEADER_END_1)) goto _L6; else goto _L5
_L5:
        j = k;
        if (!circularBufferMatchesBytePattern(abyte0, i + 9, FRAME_HEADER_END_2)) goto _L4; else goto _L6
_L4:
        i = (i + 1) % abyte0.length;
        k = j;
        continue; /* Loop/switch isn't completed */
_L2:
        return false;
_L6:
        k++;
        j = k;
        if (k <= 1) goto _L4; else goto _L7
_L7:
        return true;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
