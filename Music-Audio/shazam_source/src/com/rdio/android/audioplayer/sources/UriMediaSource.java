// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.sources;

import com.rdio.android.audioplayer.interfaces.AudioError;
import com.rdio.android.audioplayer.io.AudioStream;
import com.rdio.android.audioplayer.io.AudioStreamCallbacks;
import com.rdio.android.audioplayer.io.PositionPipedInputStream;
import com.rdio.android.audioplayer.io.UriAudioStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.rdio.android.audioplayer.sources:
//            MediaSource, MediaSourceCallbacks

public class UriMediaSource
    implements MediaSource
{

    private final UriAudioStream audioStream;
    private AudioStreamCallbacks audioStreamCallbacks;
    private int bitRate;
    private long bytesRead;
    private long duration;
    private boolean isInUse;
    private final Lock lock = new ReentrantLock();
    private final List mediaSourceCallbacksListeners = Collections.synchronizedList(new ArrayList());
    private com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediaType;
    private final Condition notEnoughBytes;
    private byte reuseBuffer[];
    private volatile boolean waitCancelled;
    private boolean waitForStreamLoad;

    public UriMediaSource(int i)
    {
        notEnoughBytes = lock.newCondition();
        audioStreamCallbacks = new AudioStreamCallbacks() {

            final UriMediaSource this$0;

            public void onError(AudioStream audiostream, AudioError audioerror)
            {
                raiseOnError(audioerror);
            }

            public void onProgress(AudioStream audiostream)
            {
                lock.lock();
                notEnoughBytes.signal();
                lock.unlock();
                raiseOnProgress();
                return;
                audiostream;
                lock.unlock();
                throw audiostream;
            }

            public void onReady(AudioStream audiostream)
            {
                raiseOnReady();
            }

            
            {
                this$0 = UriMediaSource.this;
                super();
            }
        };
        audioStream = new UriAudioStream(i, audioStreamCallbacks);
        waitForStreamLoad = true;
    }

    private void raiseOnError(AudioError audioerror)
    {
        List list = mediaSourceCallbacksListeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mediaSourceCallbacksListeners.iterator(); iterator.hasNext(); ((MediaSourceCallbacks)iterator.next()).onError(this, audioerror)) { }
        break MISSING_BLOCK_LABEL_50;
        audioerror;
        list;
        JVM INSTR monitorexit ;
        throw audioerror;
        list;
        JVM INSTR monitorexit ;
    }

    private void raiseOnProgress()
    {
        List list = mediaSourceCallbacksListeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mediaSourceCallbacksListeners.iterator(); iterator.hasNext(); ((MediaSourceCallbacks)iterator.next()).onProgress(this)) { }
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    private void raiseOnReady()
    {
        List list = mediaSourceCallbacksListeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mediaSourceCallbacksListeners.iterator(); iterator.hasNext(); ((MediaSourceCallbacks)iterator.next()).onReady(this)) { }
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    private long readPrimitive(int i)
    {
        long l1;
        if (reuseBuffer == null || reuseBuffer.length < i)
        {
            reuseBuffer = new byte[i];
        }
        l1 = 0L;
        int j = audioStream.getInputStream().read(reuseBuffer, 0, i);
        long l = l1;
        if (j != i) goto _L2; else goto _L1
_L1:
        l = l1;
        i;
        JVM INSTR tableswitch 1 8: default 104
    //                   1 128
    //                   2 146
    //                   3 180
    //                   4 232
    //                   5 108
    //                   6 108
    //                   7 108
    //                   8 302;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L8 _L8 _L9
_L8:
        break; /* Loop/switch isn't completed */
_L3:
        l = l1;
_L2:
        i = j;
_L10:
        long l2 = bytesRead;
        bytesRead = (long)i + l2;
        return l;
_L4:
        l = reuseBuffer[0] & 0xff;
        i = j;
          goto _L10
_L5:
        i = reuseBuffer[0];
        l = reuseBuffer[1] & 0xff | (i & 0xff) << 8;
        i = j;
          goto _L10
_L6:
        i = reuseBuffer[0];
        byte byte0 = reuseBuffer[1];
        l = reuseBuffer[2] & 0xff | ((i & 0xff) << 16 | (byte0 & 0xff) << 8);
        i = j;
          goto _L10
_L7:
        i = reuseBuffer[0];
        byte byte1 = reuseBuffer[1];
        byte byte3 = reuseBuffer[2];
        l = reuseBuffer[3] & 0xff | ((i & 0xff) << 24 | (byte1 & 0xff) << 16 | (byte3 & 0xff) << 8);
        i = j;
          goto _L10
_L9:
        byte byte2;
        byte byte4;
        byte byte5;
        byte byte6;
        byte byte7;
        byte byte8;
        byte byte9;
        i = reuseBuffer[0];
        byte2 = reuseBuffer[1];
        byte4 = reuseBuffer[2];
        byte5 = reuseBuffer[3];
        byte6 = reuseBuffer[4];
        byte7 = reuseBuffer[5];
        byte8 = reuseBuffer[6];
        byte9 = reuseBuffer[7];
        l = byte9 & 0xff | ((i & 0xff) << 56 | (byte2 & 0xff) << 48 | (byte4 & 0xff) << 40 | (byte5 & 0xff) << 32 | (byte6 & 0xff) << 24 | (byte7 & 0xff) << 16 | (byte8 & 0xff) << 8);
          goto _L2
        IOException ioexception;
        ioexception;
        j = 0;
_L11:
        ioexception.printStackTrace();
        l = 0L;
        i = j;
          goto _L10
        ioexception;
          goto _L11
    }

    public void addCallbacksListener(MediaSourceCallbacks mediasourcecallbacks)
    {
        synchronized (mediaSourceCallbacksListeners)
        {
            mediaSourceCallbacksListeners.add(mediasourcecallbacks);
        }
        return;
        mediasourcecallbacks;
        list;
        JVM INSTR monitorexit ;
        throw mediasourcecallbacks;
    }

    public com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType blockingGetMediaType()
    {
        return getMediaType();
    }

    public void cancelWait()
    {
        this;
        JVM INSTR monitorenter ;
        lock.lock();
        waitCancelled = true;
        notEnoughBytes.signalAll();
        lock.unlock();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void destroy()
    {
        if (isValid())
        {
            audioStream.cancel();
            synchronized (mediaSourceCallbacksListeners)
            {
                mediaSourceCallbacksListeners.clear();
            }
            setIsInUse(false);
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public AudioStream getAudioStream()
    {
        return audioStream;
    }

    public int getBitRate()
    {
        return bitRate;
    }

    public int getBufferedPercent()
    {
        if (getAudioStream() == null)
        {
            return 0;
        } else
        {
            return getAudioStream().getBufferedPercent();
        }
    }

    public long getBytesBuffered()
    {
        if (getAudioStream() == null)
        {
            return 0L;
        } else
        {
            return getAudioStream().getBytesBuffered();
        }
    }

    public long getBytesRead()
    {
        return bytesRead;
    }

    public long getCurrDataSize()
    {
        int i;
        try
        {
            i = audioStream.getInputStream().available();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return 0L;
        }
        return (long)i;
    }

    public double getDuration()
    {
        if (duration == 0L && bitRate > 0)
        {
            duration = (int)(getAudioStream().getTotalLength() / (long)(bitRate * 125));
        }
        return (double)(duration * 1000L);
    }

    public com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType getMediaType()
    {
        return mediaType;
    }

    public long getStreamPosition()
    {
        return ((PositionPipedInputStream)audioStream.getInputStream()).getPosition();
    }

    public boolean getWaitForStreamLoad()
    {
        return waitForStreamLoad;
    }

    public boolean hasStream(AudioStream audiostream)
    {
        return audiostream == getAudioStream();
    }

    public boolean isFullyConsumed()
    {
        return isValid() && audioStream.getContentLength() == bytesRead && bytesRead > 0L;
    }

    public boolean isInUse()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isInUse;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isValid()
    {
        return !audioStream.isCancelled();
    }

    public boolean isWaitingForStreamToLoad()
    {
        return waitForStreamLoad && getCurrDataSize() == 0L;
    }

    public byte readByte()
    {
        return (byte)readByteAsInt();
    }

    public int readByteAsInt()
    {
        int i;
        try
        {
            i = audioStream.getInputStream().read();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return 0;
        }
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        bytesRead = bytesRead + 1L;
        return i;
    }

    public int readBytes(byte abyte0[], int i, int j)
    {
        try
        {
            i = audioStream.getInputStream().read(abyte0, i, j);
            bytesRead = bytesRead + (long)i;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return 0;
        }
        return i;
    }

    public long readLong()
    {
        return readPrimitive(8);
    }

    public String readString(int i)
    {
        byte abyte0[];
        abyte0 = new byte[i];
        i = audioStream.getInputStream().read(abyte0, 0, i);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        String s = new String(abyte0);
_L5:
        long l = bytesRead;
        bytesRead = (long)i + l;
        return s;
        Exception exception;
        exception;
        s = "";
_L3:
        exception.printStackTrace();
        return s;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
        s = "";
        if (true) goto _L5; else goto _L4
_L4:
    }

    public long readUInt()
    {
        return readPrimitive(4);
    }

    public long readUInt(int i)
    {
        return readPrimitive(i);
    }

    public int readUShort()
    {
        return (int)readPrimitive(2);
    }

    public void removeCallbacksListener(MediaSourceCallbacks mediasourcecallbacks)
    {
        synchronized (mediaSourceCallbacksListeners)
        {
            mediaSourceCallbacksListeners.remove(mediasourcecallbacks);
        }
        return;
        mediasourcecallbacks;
        list;
        JVM INSTR monitorexit ;
        throw mediasourcecallbacks;
    }

    public int seek(int i, MediaSource.SeekOrigin seekorigin)
    {
        if (!isValid())
        {
            throw new IOException("HttpMediaSource's AudioStream is null");
        } else
        {
            long l = (long)((double)getAudioStream().getTotalLength() * ((double)i / getDuration()));
            getAudioStream().seek(l, seekorigin);
            return i;
        }
    }

    public long seekBytes(long l, MediaSource.SeekOrigin seekorigin)
    {
        if (!isValid())
        {
            throw new IOException("HttpMediaSource's AudioStream is null");
        } else
        {
            long l1 = getAudioStream().seek(l, seekorigin);
            bytesRead = bytesRead + l;
            return l1;
        }
    }

    public void setIsInUse(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (isValid())
        {
            isInUse = flag;
            waitForStreamLoad = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setWaitForStreamLoad(boolean flag)
    {
        waitForStreamLoad = flag;
    }

    public void start(final String uri, final com.rdio.android.audioplayer.io.UriAudioStream.StreamWrapper streamWrapper, final long startByteOffset)
    {
        uri = new Thread(new Runnable() {

            final UriMediaSource this$0;
            final long val$startByteOffset;
            final com.rdio.android.audioplayer.io.UriAudioStream.StreamWrapper val$streamWrapper;
            final String val$uri;

            public void run()
            {
                audioStream.start(uri, startByteOffset, streamWrapper);
            }

            
            {
                this$0 = UriMediaSource.this;
                uri = s;
                startByteOffset = l;
                streamWrapper = streamwrapper;
                super();
            }
        });
        uri.setName("UriMediaSource Thread");
        uri.start();
    }

    public void updateMediaBitrate(int i)
    {
        bitRate = i;
    }

    public void updateMediaDuration(long l)
    {
        duration = l;
    }

    public void updateMediaInfo(com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype, int i, long l)
    {
        mediaType = mediatype;
        bitRate = i;
        duration = l;
    }

    public void updateMediaType(com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType mediatype)
    {
        mediaType = mediatype;
    }

    public MediaSource.WaitStatus waitForData(long l, int i)
    {
_L2:
        if (!isValid() || getAudioStream().isFullyLoaded() || getCurrDataSize() >= l || waitCancelled)
        {
            break; /* Loop/switch isn't completed */
        }
        lock.lock();
        MediaSource.WaitStatus waitstatus;
        if (notEnoughBytes.await(i, TimeUnit.MILLISECONDS))
        {
            break MISSING_BLOCK_LABEL_76;
        }
        waitstatus = MediaSource.WaitStatus.TimedOut;
        lock.unlock();
        return waitstatus;
        lock.unlock();
        if (true) goto _L2; else goto _L1
        Object obj;
        obj;
        ((InterruptedException) (obj)).printStackTrace();
        obj = MediaSource.WaitStatus.Cancelled;
        lock.unlock();
        return ((MediaSource.WaitStatus) (obj));
        obj;
        lock.unlock();
        throw obj;
_L1:
        if (waitCancelled)
        {
            return MediaSource.WaitStatus.Cancelled;
        } else
        {
            return MediaSource.WaitStatus.Success;
        }
    }

    public MediaSource.WaitStatus waitForData(long l, long l1, int i, int j)
    {
        return waitForData(l1, j);
    }






}
