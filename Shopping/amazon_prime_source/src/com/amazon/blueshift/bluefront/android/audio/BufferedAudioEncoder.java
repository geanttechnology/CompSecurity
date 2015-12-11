// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import com.google.common.base.Preconditions;
import com.google.common.net.MediaType;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.blueshift.bluefront.android.audio:
//            AudioEncoder, AudioEncoderException

public class BufferedAudioEncoder
    implements AudioEncoder
{

    private final AudioEncoder mEncoder;
    private final ShortBuffer mSamplesBuffer;

    public BufferedAudioEncoder(AudioEncoder audioencoder)
    {
        Preconditions.checkNotNull(audioencoder, "AudioEncoder cannot be null");
        mEncoder = audioencoder;
        mSamplesBuffer = ShortBuffer.wrap(new short[mEncoder.getFrameSize()]);
    }

    private byte[] concatenateBytes(List list)
    {
        int i = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            i += ((byte[])iterator.next()).length;
        }

        byte abyte0[] = new byte[i];
        i = 0;
        for (list = list.iterator(); list.hasNext();)
        {
            byte abyte1[] = (byte[])list.next();
            System.arraycopy(abyte1, 0, abyte0, i, abyte1.length);
            i += abyte1.length;
        }

        return abyte0;
    }

    public void close()
    {
        mEncoder.close();
    }

    public byte[] encode(short aword0[], int i)
        throws AudioEncoderException
    {
        ArrayList arraylist;
        short aword1[];
        int j;
        boolean flag;
        if (aword0.length >= i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Number of samples cannot exceed buffer size");
        j = 0;
        arraylist = new ArrayList();
        aword1 = new short[mSamplesBuffer.capacity()];
        for (; mSamplesBuffer.remaining() <= i - j; mSamplesBuffer.clear())
        {
            int k = mSamplesBuffer.remaining();
            System.arraycopy(aword0, j, aword1, 0, k);
            mSamplesBuffer.put(aword1, 0, k);
            j += k;
            arraylist.add(mEncoder.encode(mSamplesBuffer.array(), mSamplesBuffer.capacity()));
        }

        mSamplesBuffer.put(aword0, j, i - j);
        return concatenateBytes(arraylist);
    }

    public int getFrameSize()
    {
        return mEncoder.getFrameSize();
    }

    public MediaType getMediaType()
    {
        return mEncoder.getMediaType();
    }

    public int getPacketSize()
    {
        return mEncoder.getPacketSize();
    }
}
