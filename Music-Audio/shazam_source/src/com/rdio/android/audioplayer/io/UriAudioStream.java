// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.io;

import android.util.Log;
import com.rdio.android.audioplayer.interfaces.AudioError;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;

// Referenced classes of package com.rdio.android.audioplayer.io:
//            AudioStream, PositionPipedInputStream, AudioStreamCallbacks

public class UriAudioStream extends AudioStream
{
    public static interface StreamWrapper
    {

        public abstract InputStream wrap(InputStream inputstream);
    }

    public static class UriAudioStreamAudioError
        implements AudioError
    {

        private final String description;
        private final long restartByteOffset;
        private final com.rdio.android.audioplayer.interfaces.AudioError.ErrorType type;

        public String getDescription()
        {
            return description;
        }

        public long getRestartByteOffset()
        {
            return restartByteOffset;
        }

        public com.rdio.android.audioplayer.interfaces.AudioError.ErrorType getType()
        {
            return type;
        }

        public boolean shouldStopPlayback()
        {
            return true;
        }

        public UriAudioStreamAudioError(String s, com.rdio.android.audioplayer.interfaces.AudioError.ErrorType errortype)
        {
            description = s;
            type = errortype;
            restartByteOffset = 0L;
        }

        public UriAudioStreamAudioError(String s, com.rdio.android.audioplayer.interfaces.AudioError.ErrorType errortype, long l)
        {
            description = s;
            type = errortype;
            restartByteOffset = l;
        }
    }


    private static final int BUFFERED_INPUT_STREAM_BUFFER_SIZE = 0x1e000;
    private static final int CONNECTION_READ_TIMEOUT = 3000;
    private static final String FILE_PROTOCOL = "file";
    private static final int HTTP_INPUT_STREAM_READ_SIZE = 12288;
    private static final long SEEK_CONSUME_BYTES_THRESHOLD = 0x19000L;
    private static final String TAG = "UriAudioStream";
    private long bytesWritten;
    private long contentLength;
    private final PositionPipedInputStream inputStream;
    private volatile boolean isCancelled;
    private final PipedOutputStream outputStream;

    public UriAudioStream(int i, AudioStreamCallbacks audiostreamcallbacks)
    {
        super(audiostreamcallbacks);
        inputStream = new PositionPipedInputStream(i);
        outputStream = new PipedOutputStream(inputStream);
    }

    private long computeBytesToConsume(long l, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin)
    {
        long l1 = l;
        static class _cls1
        {

            static final int $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin[];

            static 
            {
                $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin = new int[com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin[com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.Current.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin[com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.Begin.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$rdio$android$audioplayer$sources$MediaSource$SeekOrigin[com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.End.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin[seekorigin.ordinal()])
        {
        default:
            throw new AudioStream.InvalidOperationException((new StringBuilder("Invalid SeekOrigin: ")).append(seekorigin).toString());

        case 2: // '\002'
            l1 = l;
            if (l >= inputStream.getPosition())
            {
                l1 = l - inputStream.getPosition();
            }
            // fall through

        case 1: // '\001'
            return l1;

        case 3: // '\003'
            return getTotalLength() - l;
        }
    }

    private long consumeBytes(long l)
    {
        long l2 = inputStream.skip(l);
        if (l2 < l && inputStream.getPosition() < getTotalLength())
        {
            long l1 = l - l2;
            byte abyte0[] = new byte[0x80000];
            do
            {
                l2 = l;
                if (l1 <= 0L)
                {
                    break;
                }
                PositionPipedInputStream positionpipedinputstream = inputStream;
                int i;
                if (l1 < 0x80000L)
                {
                    i = (int)l1;
                } else
                {
                    i = 0x80000;
                }
                l1 -= positionpipedinputstream.read(abyte0, 0, i);
                try
                {
                    Thread.sleep(5L, 0);
                }
                catch (InterruptedException interruptedexception)
                {
                    Log.e("UriAudioStream", "Interrupted when waiting to skip bytes for seek", interruptedexception);
                }
            } while (true);
        }
        return l2;
    }

    private UriAudioStreamAudioError getError(String s, com.rdio.android.audioplayer.interfaces.AudioError.ErrorType errortype)
    {
        return getError(s, errortype, 0L);
    }

    private UriAudioStreamAudioError getError(String s, com.rdio.android.audioplayer.interfaces.AudioError.ErrorType errortype, long l)
    {
        return new UriAudioStreamAudioError(s, errortype, l);
    }

    public void cancel()
    {
        isCancelled = true;
    }

    public int getBufferedPercent()
    {
        if (contentLength > 0L)
        {
            return (int)((float)(bytesWritten / contentLength) * 100F);
        } else
        {
            return 0;
        }
    }

    public long getBytesBuffered()
    {
        return bytesWritten;
    }

    public long getContentLength()
    {
        return contentLength;
    }

    public InputStream getInputStream()
    {
        return inputStream;
    }

    public long getTotalLength()
    {
        return contentLength;
    }

    public boolean isCancelled()
    {
        return isCancelled;
    }

    public boolean isFullyLoaded()
    {
        return contentLength == getBytesBuffered() && contentLength > 0L;
    }

    public boolean isSeekBeyondBuffer(long l, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin)
    {
        long l1;
        boolean flag;
        flag = true;
        l1 = (long)inputStream.available() + 0x19000L;
        _cls1..SwitchMap.com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin[seekorigin.ordinal()];
        JVM INSTR tableswitch 1 3: default 52
    //                   1 58
    //                   2 75
    //                   3 84;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = false;
_L6:
        return flag;
_L2:
        if (inputStream.getPosition() + l <= l1)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (l <= l1)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (getTotalLength() - l <= l1)
        {
            return false;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean isSeekReverse(long l, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin)
    {
        if (seekorigin != com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.Current)
        {
            if (seekorigin == com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.Begin && l < inputStream.getPosition())
            {
                return true;
            }
            if (seekorigin == com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin.End && getTotalLength() - l < inputStream.getPosition())
            {
                return true;
            }
        }
        return false;
    }

    public boolean reverseSeekingSupported()
    {
        return false;
    }

    public long seek(long l, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin)
    {
        if (!reverseSeekingSupported() && isSeekReverse(l, seekorigin))
        {
            Log.e("UriAudioStream", (new StringBuilder("Seeking to offset: ")).append(l).append(" with origin: ").append(seekorigin).append(" is a reverse seek, not supported").toString());
            return 0L;
        }
        l = computeBytesToConsume(l, seekorigin);
        long l1 = consumeBytes(l);
        if (l1 != l)
        {
            (new StringBuilder("Tried to seek ")).append(l).append(" bytes, but only consumed ").append(l1);
        } else
        {
            (new StringBuilder("Seek consumed ")).append(l1).append(" bytes, new position is ").append(inputStream.getPosition());
        }
        return inputStream.getPosition();
    }

    public void start(String s)
    {
        start(s, 0L, null);
    }

    public void start(String s, long l, StreamWrapper streamwrapper)
    {
        if (!isCancelled) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s1;
        String s2;
        String s3;
        Object obj;
        int i;
        byte abyte0[] = new byte[12288];
        Object obj1;
        long l1;
        long l3;
        boolean flag;
        try
        {
            obj = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (StreamWrapper streamwrapper)
        {
            streamwrapper.printStackTrace();
            callbacks.onError(this, new UriAudioStreamAudioError((new StringBuilder("Failed to parse uri: ")).append(s).append(" ").append(streamwrapper.getMessage()).toString(), com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.InvalidStream));
            return;
        }
        s3 = null;
        s2 = null;
        if (l > 0L)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        s1 = s3;
        obj1 = ((URL) (obj)).getProtocol();
        s1 = s3;
        flag = "file".equals(obj1);
        if (!flag) goto _L4; else goto _L3
_L3:
        s1 = s3;
        s = URI.create(s);
        s1 = s3;
        s = new File(s);
        s1 = s3;
        obj = new FileInputStream(s);
        s1 = s3;
        obj = new BufferedInputStream(((InputStream) (obj)), 0x1e000);
        s1 = s3;
        l1 = s.length();
        s1 = s3;
        contentLength = l1;
        s = null;
_L7:
        obj1 = obj;
        if (streamwrapper == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        obj1 = streamwrapper.wrap(((InputStream) (obj)));
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        l1 = ((InputStream) (obj1)).skip(l);
        if (l1 == l)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = new StringBuilder("Could only skip ");
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = streamwrapper.append(l1);
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = streamwrapper.append(" bytes! Needed to skip: ");
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = streamwrapper.append(l);
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = streamwrapper.append(" bytes.");
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = streamwrapper.toString();
        s1 = s;
        s2 = s;
        s3 = s;
        Log.e("UriAudioStream", streamwrapper);
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = inputStream;
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper.setPosition(l);
_L6:
        s1 = s;
        s2 = s;
        s3 = s;
        i = ((InputStream) (obj1)).read(abyte0);
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        s2 = s;
        s3 = s;
        flag = isCancelled;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = outputStream;
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper.write(abyte0, 0, i);
        s1 = s;
        s2 = s;
        s3 = s;
        l1 = bytesWritten;
        l3 = i;
        s1 = s;
        s2 = s;
        s3 = s;
        bytesWritten = l3 + l1;
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = callbacks;
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper.onProgress(this);
        if (true) goto _L6; else goto _L5
        s;
        s = s1;
_L9:
        s1 = s;
        System.err.println("Stream encountered socket exception.");
        s1 = s;
        System.err.println((new StringBuilder("Wrote: ")).append(bytesWritten).append(" before failure.").toString());
        s1 = s;
        callbacks.onError(this, getError("Stream read timed out.", com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.NetworkStreamReadTimeout, bytesWritten + l));
        outputStream.flush();
        outputStream.close();
        if (s != null)
        {
            try
            {
                s.disconnect();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        }
          goto _L1
_L4:
        s1 = s3;
        s = ((URL) (obj)).openConnection();
        s1 = s3;
        s = (HttpURLConnection)s;
        s1 = s;
        s2 = s;
        s3 = s;
        s.setReadTimeout(3000);
        int j;
        j = i;
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_827;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        obj = new StringBuilder("bytes=");
        s1 = s;
        s2 = s;
        s3 = s;
        obj = ((StringBuilder) (obj)).append(l);
        s1 = s;
        s2 = s;
        s3 = s;
        obj = ((StringBuilder) (obj)).append("-");
        s1 = s;
        s2 = s;
        s3 = s;
        obj = ((StringBuilder) (obj)).toString();
        s1 = s;
        s2 = s;
        s3 = s;
        s.setRequestProperty("Range", ((String) (obj)));
        j = 0;
        s1 = s;
        s2 = s;
        s3 = s;
        obj = s.getHeaderField("Content-Length");
        s1 = s;
        s2 = s;
        s3 = s;
        i = Integer.parseInt(((String) (obj)));
        long l2;
        l2 = i;
        s1 = s;
        s2 = s;
        s3 = s;
        contentLength = l2;
        s1 = s;
        s2 = s;
        s3 = s;
        obj = s.getInputStream();
        s1 = s;
        s2 = s;
        s3 = s;
        obj = new BufferedInputStream(((InputStream) (obj)), 0x1e000);
        i = j;
          goto _L7
        streamwrapper;
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = callbacks;
        s1 = s;
        s2 = s;
        s3 = s;
        Object obj2 = new StringBuilder("Content length was not a number! was: ");
        s1 = s;
        s2 = s;
        s3 = s;
        obj = ((StringBuilder) (obj2)).append(((String) (obj)));
        s1 = s;
        s2 = s;
        s3 = s;
        obj = ((StringBuilder) (obj)).toString();
        s1 = s;
        s2 = s;
        s3 = s;
        obj2 = com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.Network;
        s1 = s;
        s2 = s;
        s3 = s;
        obj = getError(((String) (obj)), ((com.rdio.android.audioplayer.interfaces.AudioError.ErrorType) (obj2)));
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper.onError(this, ((AudioError) (obj)));
        outputStream.flush();
        outputStream.close();
        if (s == null) goto _L1; else goto _L8
_L8:
        try
        {
            s.disconnect();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
_L5:
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper = inputStream;
        s1 = s;
        s2 = s;
        s3 = s;
        l2 = streamwrapper.getPosition();
        s1 = s;
        s2 = s;
        s3 = s;
        long l4 = bytesWritten;
        if (l2 >= l4 + l)
        {
            break MISSING_BLOCK_LABEL_1197;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        boolean flag1 = isCancelled;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_1197;
        }
        s1 = s;
        s2 = s;
        s3 = s;
        Thread.sleep(10L, 0);
          goto _L5
        streamwrapper;
        s1 = s;
        s2 = s;
        s3 = s;
        streamwrapper.printStackTrace();
          goto _L5
        streamwrapper;
          goto _L9
        outputStream.flush();
        outputStream.close();
        if (s != null)
        {
            try
            {
                s.disconnect();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        }
          goto _L1
        streamwrapper;
        s = s2;
_L13:
        s1 = s;
        if (isCancelled)
        {
            break MISSING_BLOCK_LABEL_1360;
        }
        s1 = s;
        System.err.println((new StringBuilder("Output stream wrote: ")).append(bytesWritten).append(" bytes, input read: ").append(inputStream.getPosition()).append(" bytes").toString());
        s1 = s;
        System.err.println((new StringBuilder("Stream total length was: ")).append(contentLength).append(" bytes").toString());
        s1 = s;
        streamwrapper.printStackTrace();
        s1 = s;
        callbacks.onError(this, getError(streamwrapper.getMessage(), com.rdio.android.audioplayer.interfaces.AudioError.ErrorType.Network));
        outputStream.flush();
        outputStream.close();
        if (s == null) goto _L1; else goto _L10
_L10:
        try
        {
            s.disconnect();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
        s;
_L12:
        outputStream.flush();
        outputStream.close();
        if (s1 != null)
        {
            try
            {
                s1.disconnect();
            }
            // Misplaced declaration of an exception variable
            catch (StreamWrapper streamwrapper)
            {
                streamwrapper.printStackTrace();
            }
        }
        throw s;
        s;
        s1 = s2;
        if (true) goto _L12; else goto _L11
_L11:
        streamwrapper;
        s = s3;
          goto _L13
        s;
        s = null;
          goto _L9
        s;
        s = null;
          goto _L9
        s;
        s = null;
          goto _L9
        s;
        s = null;
          goto _L9
        s;
        s = null;
          goto _L9
        s;
        s = null;
          goto _L9
        s;
        s = null;
          goto _L9
        s;
        s = null;
          goto _L9
        s;
        s = null;
          goto _L9
        s;
        s = null;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        streamwrapper;
          goto _L9
        s;
        s = null;
          goto _L9
    }
}
