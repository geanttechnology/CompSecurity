// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamEncoder
    implements Encoder
{

    public StreamEncoder()
    {
    }

    public boolean encode(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = ByteArrayPool.get().getBytes();
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        outputstream.write(abyte0, 0, i);
          goto _L1
        inputstream;
        if (Log.isLoggable("StreamEncoder", 3))
        {
            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", inputstream);
        }
        ByteArrayPool.get().releaseBytes(abyte0);
        return false;
        ByteArrayPool.get().releaseBytes(abyte0);
        return true;
        inputstream;
        ByteArrayPool.get().releaseBytes(abyte0);
        throw inputstream;
    }

    public volatile boolean encode(Object obj, OutputStream outputstream)
    {
        return encode((InputStream)obj, outputstream);
    }

    public String getId()
    {
        return "";
    }
}
