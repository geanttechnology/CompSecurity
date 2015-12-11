// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.smoothstreaming;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Base64;
import android.util.SparseArray;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import shared_presage.com.google.android.exoplayer.BehindLiveWindowException;
import shared_presage.com.google.android.exoplayer.MediaFormat;
import shared_presage.com.google.android.exoplayer.TrackInfo;
import shared_presage.com.google.android.exoplayer.chunk.Chunk;
import shared_presage.com.google.android.exoplayer.chunk.ChunkExtractorWrapper;
import shared_presage.com.google.android.exoplayer.chunk.ChunkOperationHolder;
import shared_presage.com.google.android.exoplayer.chunk.ChunkSource;
import shared_presage.com.google.android.exoplayer.chunk.ContainerMediaChunk;
import shared_presage.com.google.android.exoplayer.chunk.Format;
import shared_presage.com.google.android.exoplayer.chunk.FormatEvaluator;
import shared_presage.com.google.android.exoplayer.chunk.MediaChunk;
import shared_presage.com.google.android.exoplayer.drm.DrmInitData;
import shared_presage.com.google.android.exoplayer.extractor.mp4.FragmentedMp4Extractor;
import shared_presage.com.google.android.exoplayer.extractor.mp4.Track;
import shared_presage.com.google.android.exoplayer.extractor.mp4.TrackEncryptionBox;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;
import shared_presage.com.google.android.exoplayer.util.CodecSpecificDataUtil;
import shared_presage.com.google.android.exoplayer.util.ManifestFetcher;

// Referenced classes of package shared_presage.com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifest

public class SmoothStreamingChunkSource
    implements ChunkSource
{

    private static final int INITIALIZATION_VECTOR_SIZE = 8;
    private static final int MINIMUM_MANIFEST_REFRESH_PERIOD_MS = 5000;
    private SmoothStreamingManifest currentManifest;
    private int currentManifestChunkOffset;
    private final DataSource dataSource;
    private final DrmInitData drmInitData;
    private final shared_presage.com.google.android.exoplayer.chunk.FormatEvaluator.Evaluation evaluation;
    private final SparseArray extractorWrappers;
    private IOException fatalError;
    private boolean finishedCurrentManifest;
    private final FormatEvaluator formatEvaluator;
    private final Format formats[];
    private final long liveEdgeLatencyUs;
    private final ManifestFetcher manifestFetcher;
    private final int maxHeight;
    private final int maxWidth;
    private final SparseArray mediaFormats;
    private final int streamElementIndex;
    private final TrackInfo trackInfo;

    public SmoothStreamingChunkSource(SmoothStreamingManifest smoothstreamingmanifest, int i, int ai[], DataSource datasource, FormatEvaluator formatevaluator)
    {
        this(null, smoothstreamingmanifest, i, ai, datasource, formatevaluator, 0L);
    }

    public SmoothStreamingChunkSource(ManifestFetcher manifestfetcher, int i, int ai[], DataSource datasource, FormatEvaluator formatevaluator, long l)
    {
        this(manifestfetcher, (SmoothStreamingManifest)manifestfetcher.getManifest(), i, ai, datasource, formatevaluator, l);
    }

    private SmoothStreamingChunkSource(ManifestFetcher manifestfetcher, SmoothStreamingManifest smoothstreamingmanifest, int i, int ai[], DataSource datasource, FormatEvaluator formatevaluator, long l)
    {
        manifestFetcher = manifestfetcher;
        streamElementIndex = i;
        currentManifest = smoothstreamingmanifest;
        dataSource = datasource;
        formatEvaluator = formatevaluator;
        liveEdgeLatencyUs = 1000L * l;
        datasource = getElement(smoothstreamingmanifest);
        trackInfo = new TrackInfo(((SmoothStreamingManifest.StreamElement) (datasource)).tracks[0].format.mimeType, smoothstreamingmanifest.durationUs);
        evaluation = new shared_presage.com.google.android.exoplayer.chunk.FormatEvaluator.Evaluation();
        manifestfetcher = null;
        formatevaluator = smoothstreamingmanifest.protectionElement;
        int j;
        int i1;
        int j1;
        if (formatevaluator != null)
        {
            byte abyte0[] = getKeyId(((SmoothStreamingManifest.ProtectionElement) (formatevaluator)).data);
            manifestfetcher = new TrackEncryptionBox[1];
            manifestfetcher[0] = new TrackEncryptionBox(true, 8, abyte0);
            shared_presage.com.google.android.exoplayer.drm.DrmInitData.Mapped mapped = new shared_presage.com.google.android.exoplayer.drm.DrmInitData.Mapped("video/mp4");
            mapped.put(((SmoothStreamingManifest.ProtectionElement) (formatevaluator)).uuid, ((SmoothStreamingManifest.ProtectionElement) (formatevaluator)).data);
            drmInitData = mapped;
        } else
        {
            drmInitData = null;
        }
        if (ai != null)
        {
            j = ai.length;
        } else
        {
            j = ((SmoothStreamingManifest.StreamElement) (datasource)).tracks.length;
        }
        formats = new Format[j];
        extractorWrappers = new SparseArray();
        mediaFormats = new SparseArray();
        j1 = 0;
        i = 0;
        i1 = 0;
        while (i < j) 
        {
            FragmentedMp4Extractor fragmentedmp4extractor;
            int k;
            int k1;
            int l1;
            long l2;
            if (ai != null)
            {
                k = ai[i];
            } else
            {
                k = i;
            }
            formats[i] = ((SmoothStreamingManifest.StreamElement) (datasource)).tracks[k].format;
            k1 = Math.max(j1, formats[i].width);
            l1 = Math.max(i1, formats[i].height);
            formatevaluator = getMediaFormat(datasource, k);
            if (((SmoothStreamingManifest.StreamElement) (datasource)).type == 1)
            {
                i1 = Track.TYPE_VIDEO;
            } else
            {
                i1 = Track.TYPE_AUDIO;
            }
            fragmentedmp4extractor = new FragmentedMp4Extractor(1);
            l = ((SmoothStreamingManifest.StreamElement) (datasource)).timescale;
            l2 = smoothstreamingmanifest.durationUs;
            if (i1 == Track.TYPE_VIDEO)
            {
                j1 = 4;
            } else
            {
                j1 = -1;
            }
            fragmentedmp4extractor.setTrack(new Track(k, i1, l, l2, formatevaluator, manifestfetcher, j1));
            extractorWrappers.put(k, new ChunkExtractorWrapper(fragmentedmp4extractor));
            mediaFormats.put(k, formatevaluator);
            i++;
            j1 = k1;
            i1 = l1;
        }
        maxWidth = j1;
        maxHeight = i1;
        Arrays.sort(formats, new shared_presage.com.google.android.exoplayer.chunk.Format.DecreasingBandwidthComparator());
    }

    private SmoothStreamingManifest.StreamElement getElement(SmoothStreamingManifest smoothstreamingmanifest)
    {
        return smoothstreamingmanifest.streamElements[streamElementIndex];
    }

    private static byte[] getKeyId(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < abyte0.length; i += 2)
        {
            stringbuilder.append((char)abyte0[i]);
        }

        abyte0 = stringbuilder.toString();
        abyte0 = Base64.decode(abyte0.substring(abyte0.indexOf("<KID>") + 5, abyte0.indexOf("</KID>")), 0);
        swap(abyte0, 0, 3);
        swap(abyte0, 1, 2);
        swap(abyte0, 4, 5);
        swap(abyte0, 6, 7);
        return abyte0;
    }

    private long getLiveSeekPosition()
    {
        long l = 0x8000000000000000L;
        for (int i = 0; i < currentManifest.streamElements.length;)
        {
            SmoothStreamingManifest.StreamElement streamelement = currentManifest.streamElements[i];
            long l1 = l;
            if (streamelement.chunkCount > 0)
            {
                l1 = Math.max(l, streamelement.getStartTimeUs(streamelement.chunkCount - 1) + streamelement.getChunkDurationUs(streamelement.chunkCount - 1));
            }
            i++;
            l = l1;
        }

        return l - liveEdgeLatencyUs;
    }

    private static MediaFormat getMediaFormat(SmoothStreamingManifest.StreamElement streamelement, int i)
    {
        SmoothStreamingManifest.TrackElement trackelement = streamelement.tracks[i];
        Object obj = trackelement.format;
        String s = ((Format) (obj)).mimeType;
        if (streamelement.type == 1)
        {
            obj = MediaFormat.createVideoFormat(s, -1, ((Format) (obj)).width, ((Format) (obj)).height, Arrays.asList(trackelement.csd));
            ((MediaFormat) (obj)).setMaxVideoDimensions(streamelement.maxWidth, streamelement.maxHeight);
            return ((MediaFormat) (obj));
        }
        if (streamelement.type == 0)
        {
            if (trackelement.csd != null)
            {
                streamelement = Arrays.asList(trackelement.csd);
            } else
            {
                streamelement = Collections.singletonList(CodecSpecificDataUtil.buildAacAudioSpecificConfig(((Format) (obj)).audioSamplingRate, ((Format) (obj)).numChannels));
            }
            return MediaFormat.createAudioFormat(s, -1, ((Format) (obj)).numChannels, ((Format) (obj)).audioSamplingRate, streamelement);
        }
        if (streamelement.type == 2)
        {
            return MediaFormat.createTextFormat(((Format) (obj)).mimeType);
        } else
        {
            return null;
        }
    }

    private int getTrackIndex(Format format)
    {
        SmoothStreamingManifest.TrackElement atrackelement[] = currentManifest.streamElements[streamElementIndex].tracks;
        for (int i = 0; i < atrackelement.length; i++)
        {
            if (atrackelement[i].format.equals(format))
            {
                return i;
            }
        }

        throw new IllegalStateException((new StringBuilder("Invalid format: ")).append(format).toString());
    }

    private static MediaChunk newMediaChunk(Format format, Uri uri, String s, ChunkExtractorWrapper chunkextractorwrapper, DrmInitData drminitdata, DataSource datasource, int i, boolean flag, 
            long l, long l1, int j, MediaFormat mediaformat)
    {
        return new ContainerMediaChunk(datasource, new DataSpec(uri, 0L, -1L, s), j, format, l, l1, i, flag, l, chunkextractorwrapper, mediaformat, drminitdata, true);
    }

    private static void swap(byte abyte0[], int i, int j)
    {
        byte byte0 = abyte0[i];
        abyte0[i] = abyte0[j];
        abyte0[j] = byte0;
    }

    public void continueBuffering(long l)
    {
        if (manifestFetcher != null && currentManifest.isLive && fatalError == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SmoothStreamingManifest smoothstreamingmanifest = (SmoothStreamingManifest)manifestFetcher.getManifest();
        if (currentManifest == smoothstreamingmanifest || smoothstreamingmanifest == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        SmoothStreamingManifest.StreamElement streamelement = getElement(currentManifest);
        int i = streamelement.chunkCount;
        SmoothStreamingManifest.StreamElement streamelement1 = getElement(smoothstreamingmanifest);
        if (i == 0 || streamelement1.chunkCount == 0)
        {
            currentManifestChunkOffset = currentManifestChunkOffset + i;
        } else
        {
            l = streamelement.getStartTimeUs(i - 1);
            long l1 = streamelement.getChunkDurationUs(i - 1);
            long l2 = streamelement1.getStartTimeUs(0);
            if (l + l1 <= l2)
            {
                currentManifestChunkOffset = currentManifestChunkOffset + i;
            } else
            {
                int j = currentManifestChunkOffset;
                currentManifestChunkOffset = streamelement.getChunkIndex(l2) + j;
            }
        }
        currentManifest = smoothstreamingmanifest;
        finishedCurrentManifest = false;
        if (!finishedCurrentManifest || SystemClock.elapsedRealtime() <= manifestFetcher.getManifestLoadStartTimestamp() + 5000L) goto _L1; else goto _L3
_L3:
        manifestFetcher.requestRefresh();
        return;
    }

    public void disable(List list)
    {
        formatEvaluator.disable();
        if (manifestFetcher != null)
        {
            manifestFetcher.disable();
        }
    }

    public void enable()
    {
        fatalError = null;
        formatEvaluator.enable();
        if (manifestFetcher != null)
        {
            manifestFetcher.enable();
        }
    }

    public final void getChunkOperation(List list, long l, long l1, ChunkOperationHolder chunkoperationholder)
    {
        if (fatalError != null)
        {
            chunkoperationholder.chunk = null;
        } else
        {
            evaluation.queueSize = list.size();
            formatEvaluator.evaluate(list, l1, formats, evaluation);
            Format format = evaluation.format;
            chunkoperationholder.queueSize = evaluation.queueSize;
            if (format == null)
            {
                chunkoperationholder.chunk = null;
                return;
            }
            if (chunkoperationholder.queueSize != list.size() || chunkoperationholder.chunk == null || !chunkoperationholder.chunk.format.equals(format))
            {
                chunkoperationholder.chunk = null;
                SmoothStreamingManifest.StreamElement streamelement = getElement(currentManifest);
                if (streamelement.chunkCount == 0)
                {
                    finishedCurrentManifest = true;
                    return;
                }
                int i;
                if (list.isEmpty())
                {
                    if (currentManifest.isLive)
                    {
                        l = getLiveSeekPosition();
                    }
                    i = streamelement.getChunkIndex(l);
                } else
                {
                    list = (MediaChunk)list.get(chunkoperationholder.queueSize - 1);
                    if (((MediaChunk) (list)).isLastChunk)
                    {
                        i = -1;
                    } else
                    {
                        i = (((MediaChunk) (list)).chunkIndex + 1) - currentManifestChunkOffset;
                    }
                }
                if (currentManifest.isLive)
                {
                    if (i < 0)
                    {
                        fatalError = new BehindLiveWindowException();
                        return;
                    }
                    if (i >= streamelement.chunkCount)
                    {
                        finishedCurrentManifest = true;
                        return;
                    }
                    if (i == streamelement.chunkCount - 1)
                    {
                        finishedCurrentManifest = true;
                    }
                }
                if (i != -1)
                {
                    int j;
                    int k;
                    boolean flag;
                    if (!currentManifest.isLive && i == streamelement.chunkCount - 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    l1 = streamelement.getStartTimeUs(i);
                    if (flag)
                    {
                        l = -1L;
                    } else
                    {
                        l = l1 + streamelement.getChunkDurationUs(i);
                    }
                    j = currentManifestChunkOffset;
                    k = getTrackIndex(format);
                    chunkoperationholder.chunk = newMediaChunk(format, streamelement.buildRequestUri(k, i), null, (ChunkExtractorWrapper)extractorWrappers.get(k), drmInitData, dataSource, i + j, flag, l1, l, evaluation.trigger, (MediaFormat)mediaFormats.get(k));
                    return;
                }
            }
        }
    }

    public final void getMaxVideoDimensions(MediaFormat mediaformat)
    {
        if (trackInfo.mimeType.startsWith("video"))
        {
            mediaformat.setMaxVideoDimensions(maxWidth, maxHeight);
        }
    }

    public final TrackInfo getTrackInfo()
    {
        return trackInfo;
    }

    public void maybeThrowError()
    {
        if (fatalError != null)
        {
            throw fatalError;
        } else
        {
            manifestFetcher.maybeThrowError();
            return;
        }
    }

    public void onChunkLoadCompleted(Chunk chunk)
    {
    }

    public void onChunkLoadError(Chunk chunk, Exception exception)
    {
    }
}
