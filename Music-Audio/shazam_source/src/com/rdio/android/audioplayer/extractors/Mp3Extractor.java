// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.extractors;

import android.util.Log;
import com.rdio.android.audioplayer.io.MediaBuffer;
import com.rdio.android.audioplayer.sources.MediaSource;
import java.io.IOException;

// Referenced classes of package com.rdio.android.audioplayer.extractors:
//            AudioExtractor, MediaFormat

public class Mp3Extractor extends AudioExtractor
{
    public static class Mp3ParseException extends RuntimeException
    {

        public Mp3ParseException(String s)
        {
            super(s);
        }
    }


    static final boolean $assertionsDisabled;
    private static final String TAG = "MP3Extractor";
    private final int DEFAULT_CHANNEL_COUNT = 2;
    private final int DEFAULT_SAMPLING_RATE = 44100;
    private final int HEADER_SIZE = 4;
    private final int MP3_TAG = 65531;
    private int bit_rate;
    private int channels;
    private int curr_frame;
    private byte data_buffer[];
    private int frame_size;
    private byte header_buffer[];
    private int header_offset;
    private int padding;
    private long presentation_time;
    private int sampling_rate;
    private byte tmp_buffer[];
    private int total_bytes_read;

    public Mp3Extractor()
    {
        header_buffer = null;
        data_buffer = null;
        tmp_buffer = null;
        sampling_rate = 44100;
        channels = 2;
    }

    private int ProcessHeader(byte byte0, byte byte1)
    {
        int i;
        int j;
        int l;
        boolean flag;
        if (!$assertionsDisabled && !getMediaSource().isValid())
        {
            throw new AssertionError();
        }
        j = 0;
        flag = false;
        l = 0;
        i = 0;
_L4:
        int k;
        int i1;
        header_offset = seekToHeader(byte0, byte1);
        i1 = j;
        k = i;
        if (header_offset < 0) goto _L2; else goto _L1
_L1:
        if (tmp_buffer == null)
        {
            tmp_buffer = new byte[2];
        }
        l = j;
        if (header_offset > 2)
        {
            String.format("SeekToHeader skipped %d bytes instead of 2!", new Object[] {
                Integer.valueOf(header_offset)
            });
            l = j;
        }
_L5:
        i1 = getMediaSource().readBytes(tmp_buffer, 0, 2);
        flag = extractHeader(tmp_buffer);
        k = l + 1;
        if (l > 0)
        {
            String.format("Inspecting header tag %d time(s)", new Object[] {
                Integer.valueOf(k)
            });
        }
        if (!flag && i1 == 2 && tmp_buffer[0] == byte0 && tmp_buffer[1] == byte1)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        j = i;
        if (flag)
        {
            j = i + 4;
            if (!$assertionsDisabled && header_offset < 2)
            {
                throw new AssertionError();
            }
            header_offset = header_offset - 2;
        }
        i = k;
        l = i1;
        k = j;
        i1 = i;
_L2:
        if (flag || l != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i1;
        i = k;
        if (header_offset >= 0) goto _L4; else goto _L3
_L3:
        return k;
        l = k;
          goto _L5
    }

    private boolean extractHeader(byte abyte0[])
    {
        int i;
        i = abyte0[0] >> 4 & 0xf;
        if (i == 0 || i == 15)
        {
            try
            {
                bit_rate = 160;
                throw new AudioExtractor.InvalidHeaderException(this, "Invalid MP3 header, invalid bit rate");
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                Log.e("MP3Extractor", String.format("InvalidHeaderException caught, message: %s, stack trace: %s", new Object[] {
                    abyte0.getMessage(), abyte0.getStackTrace()
                }));
            }
            return false;
        }
        if (i != 14) goto _L2; else goto _L1
_L1:
        bit_rate = 320;
          goto _L3
_L10:
        sampling_rate = 44100;
        throw new AudioExtractor.InvalidHeaderException(this, "Invalid MP3 header, invalid sampling rate");
_L2:
        if (i <= 9) goto _L5; else goto _L4
_L4:
        bit_rate = (i - 10) * 32 + 160;
          goto _L3
_L5:
        if (i <= 5) goto _L7; else goto _L6
_L6:
        bit_rate = (i - 6) * 16 + 80;
          goto _L3
_L7:
        bit_rate = (i - 1) * 8 + 32;
          goto _L3
_L11:
        sampling_rate = 44100;
          goto _L8
_L9:
        padding = i;
        if ((abyte0[1] >> 6 & 3) == 3)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        channels = i;
        frame_size = (bit_rate * 1000 * 144) / sampling_rate + padding;
        header_buffer[2] = abyte0[0];
        header_buffer[3] = abyte0[1];
        return true;
_L12:
        sampling_rate = 48000;
          goto _L8
_L13:
        sampling_rate = 32000;
          goto _L8
_L15:
        i = 0;
          goto _L9
_L3:
        (abyte0[0] & 0xf) >> 2;
        JVM INSTR tableswitch 0 2: default 308
    //                   0 164
    //                   1 243
    //                   2 252;
           goto _L10 _L11 _L12 _L13
_L8:
        if ((abyte0[0] & 2) <= 0) goto _L15; else goto _L14
_L14:
        i = 1;
          goto _L9
    }

    private void initializeHeaderBuffer()
    {
        if (header_buffer == null)
        {
            header_buffer = new byte[4];
            header_buffer[0] = -1;
            header_buffer[1] = -5;
        }
    }

    private int seekToHeader(byte byte0, byte byte1)
    {
        int i;
        int j;
        int l;
        int i1;
        i = 0;
        if (!$assertionsDisabled && !getMediaSource().isValid())
        {
            throw new AssertionError();
        }
        l = 0;
        j = 0;
        i1 = 0;
_L2:
        int k;
        k = j;
        if (i1 == byte0 && k == byte1 || l < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        l = getMediaSource().readByteAsInt();
        j = i;
        if (l >= 0)
        {
            j = i + 1;
        }
        i = l;
_L3:
        i1 = (byte)i;
        l = i;
        i = j;
        j = i1;
        i1 = k;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        j = i;
        i = -1;
          goto _L3
_L1:
        if (l == -1)
        {
            return -1;
        } else
        {
            return i;
        }
    }

    public boolean advance()
    {
        return true;
    }

    public void cancelIfWaiting()
    {
        if (getMediaSource() != null)
        {
            getMediaSource().cancelWait();
        }
    }

    public void finalize()
    {
        releaseDataSource();
    }

    public int getFrameSize()
    {
        return frame_size;
    }

    public int getHeaderOffset()
    {
        return header_offset;
    }

    public int getNumChannels()
    {
        return channels;
    }

    public long getSampleTime()
    {
        return presentation_time;
    }

    public int getSamplingRate()
    {
        return sampling_rate;
    }

    public boolean getTrackFormat(int i, MediaFormat mediaformat)
    {
        mediaformat.setMP3(sampling_rate, channels);
        return true;
    }

    protected void onSetDataSource(MediaSource mediasource)
    {
        curr_frame = 0;
        total_bytes_read = 0;
        initializeHeaderBuffer();
    }

    public int readSampleData(MediaBuffer mediabuffer, int i)
    {
        int j;
        j = 0;
        boolean flag;
        try
        {
            flag = waitForData(presentation_time / 1000L, frame_size + 1, bit_rate);
        }
        // Misplaced declaration of an exception variable
        catch (MediaBuffer mediabuffer)
        {
            Log.e("MP3Extractor", "Caught NoProgressOnReadException", mediabuffer);
            return -1;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        i = -1;
_L4:
        return i;
_L2:
        if (ProcessHeader(header_buffer[0], header_buffer[1]) <= 0)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        try
        {
            if (data_buffer == null || data_buffer.length < frame_size)
            {
                data_buffer = new byte[frame_size];
            }
            j = getMediaSource().readBytes(data_buffer, 0, frame_size - 4);
        }
        // Misplaced declaration of an exception variable
        catch (MediaBuffer mediabuffer)
        {
            Log.e("MP3Extractor", "ReadSampleData() - Exception caught!", mediabuffer);
            return -1;
        }
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        Log.e("MP3Extractor", "ReadSampleData() - Cound not read frame!");
        return -1;
        mediabuffer.putMediaData(i, header_buffer, 4, data_buffer, j);
        presentation_time = (total_bytes_read * 8000) / bit_rate;
        curr_frame = curr_frame + 1;
        total_bytes_read = total_bytes_read + (j + 4);
        if (!$assertionsDisabled && j + 4 != frame_size)
        {
            throw new AssertionError();
        } else
        {
            return j + 4;
        }
        i = j;
        if (!getMediaSource().isWaitingForStreamToLoad())
        {
            if (!getMediaSource().isFullyConsumed())
            {
                Log.e("MP3Extractor", "ReadSampleData() - Unexpected error while extracting MP3. Could not find a valid MP3 header but the audio source has not been fully consumed.");
            } else
            {
                Log.e("MP3Extractor", "ReadSampleData() - Extractor has consumed all data in the audio source. Assuming EOS (end of stream)");
            }
            return -1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int seek(int i, com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin)
    {
        int j = -1;
        if (getMediaSource() != null)
        {
            try
            {
                j = getMediaSource().seek(i, seekorigin);
            }
            // Misplaced declaration of an exception variable
            catch (com.rdio.android.audioplayer.sources.MediaSource.SeekOrigin seekorigin)
            {
                throw new Mp3ParseException(seekorigin.getMessage());
            }
        }
        total_bytes_read = 0;
        return j;
    }

    public void selectTrack(int i)
    {
        if (getMediaSource() != null)
        {
            getMediaSource().updateMediaType(MediaTypeUtil.MediaType.MP3);
        }
    }

    static 
    {
        boolean flag;
        if (!com/rdio/android/audioplayer/extractors/Mp3Extractor.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
