// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

// Referenced classes of package com.lifevibes.mediacoder:
//            LVMediaCoderConfiguration

public interface LVMediaCoder
{
    public static interface LVMediaCoderICSEncoderProgressListener
    {

        public abstract void onComplete();

        public abstract void onError(Exception exception, int i);

        public abstract void onFrameAvailable(ByteBuffer bytebuffer);
    }


    public abstract void cancel()
        throws IllegalStateException;

    public abstract ShortBuffer encodeAudio(byte abyte0[], int i, int j)
        throws IllegalStateException;

    public abstract ByteBuffer encodeVideo(ByteBuffer bytebuffer, int i)
        throws IllegalStateException;

    public abstract void encodeVideoAsync(ByteBuffer bytebuffer, int i, boolean flag)
        throws IllegalStateException;

    public abstract LVMediaCoderConfiguration getConfiguration();

    public abstract String getOutputFilePath();

    public abstract void recordAudio(ShortBuffer shortbuffer)
        throws IllegalStateException;

    public abstract void recordVideo(ByteBuffer bytebuffer, int i)
        throws IllegalStateException;

    public abstract void setEncoderVideoAsyncListener(LVMediaCoderICSEncoderProgressListener lvmediacodericsencoderprogresslistener);

    public abstract void startEncoding()
        throws IllegalStateException;

    public abstract void startRecording(String s)
        throws IllegalArgumentException;

    public abstract void stop()
        throws IllegalStateException;
}
