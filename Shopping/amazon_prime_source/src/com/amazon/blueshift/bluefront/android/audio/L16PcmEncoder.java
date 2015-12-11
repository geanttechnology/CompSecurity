// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import com.google.common.base.Preconditions;
import com.google.common.net.MediaType;
import java.nio.ByteOrder;

// Referenced classes of package com.amazon.blueshift.bluefront.android.audio:
//            AudioEncoder, AudioEncoderException

public class L16PcmEncoder
    implements AudioEncoder
{

    private static final int FRAME_SIZE = 320;
    private static final MediaType MEDIA_TYPE = MediaType.parse("audio/x-l16");

    public L16PcmEncoder()
    {
    }

    public void close()
    {
    }

    public byte[] encode(short aword0[], int i)
        throws AudioEncoderException
    {
        byte abyte0[];
        int j;
        boolean flag;
        if (aword0.length >= i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Sample buffer length must be at least as long as numSamples");
        abyte0 = new byte[i * 2];
        j = 0;
        while (j < i) 
        {
            if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN)
            {
                abyte0[j * 2] = (byte)(aword0[j] & 0xff);
                abyte0[j * 2 + 1] = (byte)(aword0[j] >> 8 & 0xff);
            } else
            {
                abyte0[j * 2] = (byte)(aword0[j] >> 8 & 0xff);
                abyte0[j * 2 + 1] = (byte)(aword0[j] & 0xff);
            }
            j++;
        }
        return abyte0;
    }

    public int getFrameSize()
    {
        return 320;
    }

    public MediaType getMediaType()
    {
        return MEDIA_TYPE;
    }

    public int getPacketSize()
    {
        return 320;
    }

}
