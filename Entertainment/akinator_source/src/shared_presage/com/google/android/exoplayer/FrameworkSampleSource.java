// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import shared_presage.com.google.android.exoplayer.drm.DrmInitData;
import shared_presage.com.google.android.exoplayer.extractor.mp4.PsshAtomUtil;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            SampleSource, TrackInfo, MediaFormat, MediaFormatHolder, 
//            SampleHolder, CryptoInfo

public final class FrameworkSampleSource
    implements SampleSource, SampleSource.SampleSourceReader
{

    private static final int ALLOWED_FLAGS_MASK = 3;
    private static final int TRACK_STATE_DISABLED = 0;
    private static final int TRACK_STATE_ENABLED = 1;
    private static final int TRACK_STATE_FORMAT_SENT = 2;
    private final Context context;
    private MediaExtractor extractor;
    private final FileDescriptor fileDescriptor;
    private final long fileDescriptorLength;
    private final long fileDescriptorOffset;
    private final Map headers;
    private boolean pendingDiscontinuities[];
    private IOException preparationError;
    private boolean prepared;
    private int remainingReleaseCount;
    private long seekPositionUs;
    private TrackInfo trackInfos[];
    private int trackStates[];
    private final Uri uri;

    public FrameworkSampleSource(Context context1, Uri uri1, Map map)
    {
        boolean flag;
        if (Util.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        context = (Context)Assertions.checkNotNull(context1);
        uri = (Uri)Assertions.checkNotNull(uri1);
        headers = map;
        fileDescriptor = null;
        fileDescriptorOffset = 0L;
        fileDescriptorLength = 0L;
    }

    public FrameworkSampleSource(FileDescriptor filedescriptor, long l, long l1)
    {
        boolean flag;
        if (Util.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        fileDescriptor = (FileDescriptor)Assertions.checkNotNull(filedescriptor);
        fileDescriptorOffset = l;
        fileDescriptorLength = l1;
        context = null;
        uri = null;
        headers = null;
    }

    private DrmInitData getDrmInitDataV18()
    {
        Map map = extractor.getPsshInfo();
        if (map == null || map.isEmpty())
        {
            return null;
        }
        shared_presage.com.google.android.exoplayer.drm.DrmInitData.Mapped mapped = new shared_presage.com.google.android.exoplayer.drm.DrmInitData.Mapped("video/mp4");
        UUID uuid;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); mapped.put(uuid, PsshAtomUtil.buildPsshAtom(uuid, (byte[])map.get(uuid))))
        {
            uuid = (UUID)iterator.next();
        }

        return mapped;
    }

    private void seekToUsInternal(long l, boolean flag)
    {
        int i = 0;
        if (flag || seekPositionUs != l)
        {
            seekPositionUs = l;
            extractor.seekTo(l, 0);
            for (; i < trackStates.length; i++)
            {
                if (trackStates[i] != 0)
                {
                    pendingDiscontinuities[i] = true;
                }
            }

        }
    }

    public final boolean continueBuffering(int i, long l)
    {
        return true;
    }

    public final void disable(int i)
    {
        Assertions.checkState(prepared);
        boolean flag;
        if (trackStates[i] != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        extractor.unselectTrack(i);
        pendingDiscontinuities[i] = false;
        trackStates[i] = 0;
    }

    public final void enable(int i, long l)
    {
        boolean flag1 = true;
        Assertions.checkState(prepared);
        boolean flag;
        if (trackStates[i] == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        trackStates[i] = 1;
        extractor.selectTrack(i);
        if (l != 0L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        seekToUsInternal(l, flag);
    }

    public final long getBufferedPositionUs()
    {
        Assertions.checkState(prepared);
        long l = extractor.getCachedDuration();
        if (l == -1L)
        {
            return -1L;
        }
        long l1 = extractor.getSampleTime();
        if (l1 == -1L)
        {
            return -3L;
        } else
        {
            return l1 + l;
        }
    }

    public final int getTrackCount()
    {
        Assertions.checkState(prepared);
        return trackStates.length;
    }

    public final TrackInfo getTrackInfo(int i)
    {
        Assertions.checkState(prepared);
        return trackInfos[i];
    }

    public final void maybeThrowError()
    {
        if (preparationError != null)
        {
            throw preparationError;
        } else
        {
            return;
        }
    }

    public final boolean prepare(long l)
    {
        if (prepared)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        if (preparationError != null)
        {
            return false;
        }
        extractor = new MediaExtractor();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        extractor.setDataSource(context, uri, headers);
_L1:
        trackStates = new int[extractor.getTrackCount()];
        pendingDiscontinuities = new boolean[trackStates.length];
        trackInfos = new TrackInfo[trackStates.length];
        int i = 0;
        while (i < trackStates.length) 
        {
            Object obj = extractor.getTrackFormat(i);
            IOException ioexception;
            if (((MediaFormat) (obj)).containsKey("durationUs"))
            {
                l = ((MediaFormat) (obj)).getLong("durationUs");
            } else
            {
                l = -1L;
            }
            obj = ((MediaFormat) (obj)).getString("mime");
            trackInfos[i] = new TrackInfo(((String) (obj)), l);
            i++;
        }
        break MISSING_BLOCK_LABEL_197;
        try
        {
            extractor.setDataSource(fileDescriptor, fileDescriptorOffset, fileDescriptorLength);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            preparationError = ioexception;
            return false;
        }
          goto _L1
        prepared = true;
        return true;
    }

    public final int readData(int i, long l, MediaFormatHolder mediaformatholder, SampleHolder sampleholder, boolean flag)
    {
        Assertions.checkState(prepared);
        boolean flag1;
        if (trackStates[i] != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        if (pendingDiscontinuities[i])
        {
            pendingDiscontinuities[i] = false;
            return -5;
        }
        if (flag)
        {
            return -2;
        }
        if (trackStates[i] != 2)
        {
            mediaformatholder.format = MediaFormat.createFromFrameworkMediaFormatV16(extractor.getTrackFormat(i));
            if (Util.SDK_INT >= 18)
            {
                sampleholder = getDrmInitDataV18();
            } else
            {
                sampleholder = null;
            }
            mediaformatholder.drmInitData = sampleholder;
            trackStates[i] = 2;
            return -4;
        }
        int j = extractor.getSampleTrackIndex();
        if (j == i)
        {
            if (sampleholder.data != null)
            {
                i = sampleholder.data.position();
                sampleholder.size = extractor.readSampleData(sampleholder.data, i);
                sampleholder.data.position(i + sampleholder.size);
            } else
            {
                sampleholder.size = 0;
            }
            sampleholder.timeUs = extractor.getSampleTime();
            sampleholder.flags = extractor.getSampleFlags() & 3;
            if (sampleholder.isEncrypted())
            {
                sampleholder.cryptoInfo.setFromExtractorV16(extractor);
            }
            seekPositionUs = -1L;
            extractor.advance();
            return -3;
        }
        return j >= 0 ? -2 : -1;
    }

    public final SampleSource.SampleSourceReader register()
    {
        remainingReleaseCount = remainingReleaseCount + 1;
        return this;
    }

    public final void release()
    {
        int i;
        boolean flag;
        if (remainingReleaseCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        i = remainingReleaseCount - 1;
        remainingReleaseCount = i;
        if (i == 0 && extractor != null)
        {
            extractor.release();
            extractor = null;
        }
    }

    public final void seekToUs(long l)
    {
        Assertions.checkState(prepared);
        seekToUsInternal(l, false);
    }
}
