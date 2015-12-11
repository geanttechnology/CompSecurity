// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import com.google.common.base.Preconditions;
import com.google.common.net.MediaType;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.amazon.blueshift.bluefront.android.audio:
//            AudioSource, AudioSourceListener

public class AudioStream extends AudioSource
{

    private static final int BUF_SIZ = 320;
    private final InputStream mStream;

    public AudioStream(MediaType mediatype, InputStream inputstream)
    {
        super(mediatype);
        Preconditions.checkNotNull(inputstream, "Stream cannot be null");
        mStream = inputstream;
    }

    public int getChunkSize()
    {
        return 320;
    }

    protected void writeBody(OutputStream outputstream)
        throws Exception
    {
        byte abyte0[] = new byte[320];
        int i = mStream.read(abyte0);
        AudioSourceListener audiosourcelistener = getAudioSourceListener();
        for (; !isCancelled() && i != -1; i = mStream.read(abyte0))
        {
            audiosourcelistener.onBufferReceived(abyte0);
            outputstream.write(abyte0, 0, i);
        }

    }
}
