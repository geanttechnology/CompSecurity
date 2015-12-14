// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer.BehindLiveWindowException;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.TimeRange;
import com.google.android.exoplayer.TrackInfo;
import com.google.android.exoplayer.chunk.Chunk;
import com.google.android.exoplayer.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer.chunk.ChunkOperationHolder;
import com.google.android.exoplayer.chunk.ChunkSource;
import com.google.android.exoplayer.chunk.ContainerMediaChunk;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.FormatEvaluator;
import com.google.android.exoplayer.chunk.InitializationChunk;
import com.google.android.exoplayer.chunk.MediaChunk;
import com.google.android.exoplayer.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer.dash.mpd.AdaptationSet;
import com.google.android.exoplayer.dash.mpd.ContentProtection;
import com.google.android.exoplayer.dash.mpd.MediaPresentationDescription;
import com.google.android.exoplayer.dash.mpd.Period;
import com.google.android.exoplayer.dash.mpd.RangedUri;
import com.google.android.exoplayer.dash.mpd.Representation;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.extractor.ChunkIndex;
import com.google.android.exoplayer.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer.extractor.webm.WebmExtractor;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Clock;
import com.google.android.exoplayer.util.ManifestFetcher;
import com.google.android.exoplayer.util.SystemClock;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash:
//            DashSegmentIndex, DashWrappingSegmentIndex

public class DashChunkSource
    implements ChunkSource
{
    public static interface EventListener
    {

        public abstract void onSeekRangeChanged(TimeRange timerange);
    }

    public static class NoAdaptationSetException extends IOException
    {

        public NoAdaptationSetException(String s)
        {
            super(s);
        }
    }

    private static class RepresentationHolder
    {

        public final ChunkExtractorWrapper extractorWrapper;
        public MediaFormat format;
        public final Representation representation;
        public DashSegmentIndex segmentIndex;
        public int segmentNumShift;
        public byte vttHeader[];
        public long vttHeaderOffsetUs;

        public RepresentationHolder(Representation representation1, ChunkExtractorWrapper chunkextractorwrapper)
        {
            representation = representation1;
            extractorWrapper = chunkextractorwrapper;
            segmentIndex = representation1.getIndex();
        }
    }


    public static final int USE_ALL_TRACKS = -1;
    private final int adaptationSetIndex;
    private MediaPresentationDescription currentManifest;
    private final DataSource dataSource;
    private DrmInitData drmInitData;
    private final long elapsedRealtimeOffsetUs;
    private final com.google.android.exoplayer.chunk.FormatEvaluator.Evaluation evaluation;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private IOException fatalError;
    private boolean finishedCurrentManifest;
    private int firstAvailableSegmentNum;
    private final FormatEvaluator formatEvaluator;
    private final Format formats[];
    private final StringBuilder headerBuilder;
    private int lastAvailableSegmentNum;
    private boolean lastChunkWasInitialization;
    private final long liveEdgeLatencyUs;
    private final ManifestFetcher manifestFetcher;
    private final int maxHeight;
    private final int maxWidth;
    private final HashMap representationHolders;
    private final int representationIndices[];
    private TimeRange seekRange;
    private long seekRangeValues[];
    private boolean startAtLiveEdge;
    private final Clock systemClock;
    private final TrackInfo trackInfo;

    public DashChunkSource(MediaPresentationDescription mediapresentationdescription, int i, int ai[], DataSource datasource, FormatEvaluator formatevaluator)
    {
        this(null, mediapresentationdescription, i, ai, datasource, formatevaluator, ((Clock) (new SystemClock())), 0L, 0L, false, null, null);
    }

    public DashChunkSource(DataSource datasource, FormatEvaluator formatevaluator, List list)
    {
        this(buildManifest(list), 0, null, datasource, formatevaluator);
    }

    public transient DashChunkSource(DataSource datasource, FormatEvaluator formatevaluator, Representation arepresentation[])
    {
        this(buildManifest(Arrays.asList(arepresentation)), 0, null, datasource, formatevaluator);
    }

    public DashChunkSource(ManifestFetcher manifestfetcher, int i, int ai[], DataSource datasource, FormatEvaluator formatevaluator, long l, 
            long l1, Handler handler, EventListener eventlistener)
    {
        this(manifestfetcher, (MediaPresentationDescription)manifestfetcher.getManifest(), i, ai, datasource, formatevaluator, ((Clock) (new SystemClock())), l * 1000L, l1 * 1000L, true, handler, eventlistener);
    }

    public DashChunkSource(ManifestFetcher manifestfetcher, int i, int ai[], DataSource datasource, FormatEvaluator formatevaluator, long l, 
            long l1, boolean flag, Handler handler, EventListener eventlistener)
    {
        this(manifestfetcher, (MediaPresentationDescription)manifestfetcher.getManifest(), i, ai, datasource, formatevaluator, ((Clock) (new SystemClock())), l * 1000L, l1 * 1000L, flag, handler, eventlistener);
    }

    DashChunkSource(ManifestFetcher manifestfetcher, MediaPresentationDescription mediapresentationdescription, int i, int ai[], DataSource datasource, FormatEvaluator formatevaluator, Clock clock, 
            long l, long l1, boolean flag, Handler handler, EventListener eventlistener)
    {
        manifestFetcher = manifestfetcher;
        currentManifest = mediapresentationdescription;
        adaptationSetIndex = i;
        representationIndices = ai;
        dataSource = datasource;
        formatEvaluator = formatevaluator;
        systemClock = clock;
        liveEdgeLatencyUs = l;
        elapsedRealtimeOffsetUs = l1;
        startAtLiveEdge = flag;
        eventHandler = handler;
        eventListener = eventlistener;
        evaluation = new com.google.android.exoplayer.chunk.FormatEvaluator.Evaluation();
        headerBuilder = new StringBuilder();
        seekRangeValues = new long[2];
        drmInitData = getDrmInitData(currentManifest, i);
        mediapresentationdescription = getFilteredRepresentations(currentManifest, i, ai);
        int j;
        int k;
        if (((Representation) (mediapresentationdescription[0])).periodDurationMs == -1L)
        {
            l = -1L;
        } else
        {
            l = ((Representation) (mediapresentationdescription[0])).periodDurationMs * 1000L;
        }
        trackInfo = new TrackInfo(((Representation) (mediapresentationdescription[0])).format.mimeType, l);
        formats = new Format[mediapresentationdescription.length];
        representationHolders = new HashMap();
        k = 0;
        j = 0;
        i = 0;
        while (i < mediapresentationdescription.length) 
        {
            formats[i] = ((Representation) (mediapresentationdescription[i])).format;
            k = Math.max(formats[i].width, k);
            j = Math.max(formats[i].height, j);
            if (mimeTypeIsWebm(formats[i].mimeType))
            {
                manifestfetcher = new WebmExtractor();
            } else
            {
                manifestfetcher = new FragmentedMp4Extractor();
            }
            representationHolders.put(formats[i].id, new RepresentationHolder(mediapresentationdescription[i], new ChunkExtractorWrapper(manifestfetcher)));
            i++;
        }
        maxWidth = k;
        maxHeight = j;
        Arrays.sort(formats, new com.google.android.exoplayer.chunk.Format.DecreasingBandwidthComparator());
    }

    private static MediaPresentationDescription buildManifest(List list)
    {
        Representation representation = (Representation)list.get(0);
        list = new AdaptationSet(0, -1, list);
        list = new Period(null, representation.periodStartMs, representation.periodDurationMs, Collections.singletonList(list));
        return new MediaPresentationDescription(-1L, representation.periodDurationMs - representation.periodStartMs, -1L, false, -1L, -1L, null, null, Collections.singletonList(list));
    }

    private static DrmInitData getDrmInitData(MediaPresentationDescription mediapresentationdescription, int i)
    {
        String s;
        Object obj;
        obj = (AdaptationSet)((Period)mediapresentationdescription.periods.get(0)).adaptationSets.get(i);
        if (mimeTypeIsWebm(((Representation)((AdaptationSet) (obj)).representations.get(0)).format.mimeType))
        {
            s = "video/webm";
        } else
        {
            s = "video/mp4";
        }
        if (!((AdaptationSet) (obj)).contentProtections.isEmpty()) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((DrmInitData) (obj));
_L2:
        mediapresentationdescription = null;
        Iterator iterator = ((AdaptationSet) (obj)).contentProtections.iterator();
        do
        {
            obj = mediapresentationdescription;
            if (!iterator.hasNext())
            {
                continue;
            }
            ContentProtection contentprotection = (ContentProtection)iterator.next();
            if (contentprotection.uuid != null && contentprotection.data != null)
            {
                Object obj1 = mediapresentationdescription;
                if (mediapresentationdescription == null)
                {
                    obj1 = new com.google.android.exoplayer.drm.DrmInitData.Mapped(s);
                }
                ((com.google.android.exoplayer.drm.DrmInitData.Mapped) (obj1)).put(contentprotection.uuid, contentprotection.data);
                mediapresentationdescription = ((MediaPresentationDescription) (obj1));
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static Representation[] getFilteredRepresentations(MediaPresentationDescription mediapresentationdescription, int i, int ai[])
    {
        mediapresentationdescription = ((AdaptationSet)((Period)mediapresentationdescription.periods.get(0)).adaptationSets.get(i)).representations;
        if (ai == null)
        {
            ai = new Representation[mediapresentationdescription.size()];
            mediapresentationdescription.toArray(ai);
            return ai;
        }
        Representation arepresentation[] = new Representation[ai.length];
        for (i = 0; i < ai.length; i++)
        {
            arepresentation[i] = (Representation)mediapresentationdescription.get(ai[i]);
        }

        return arepresentation;
    }

    private long getNowUs()
    {
        if (elapsedRealtimeOffsetUs != 0L)
        {
            return systemClock.elapsedRealtime() * 1000L + elapsedRealtimeOffsetUs;
        } else
        {
            return System.currentTimeMillis() * 1000L;
        }
    }

    private static boolean mimeTypeIsWebm(String s)
    {
        return s.startsWith("video/webm") || s.startsWith("audio/webm");
    }

    private Chunk newInitializationChunk(RangedUri rangeduri, RangedUri rangeduri1, Representation representation, ChunkExtractorWrapper chunkextractorwrapper, DataSource datasource, int i)
    {
        if (rangeduri != null)
        {
            RangedUri rangeduri2 = rangeduri.attemptMerge(rangeduri1);
            rangeduri1 = rangeduri2;
            if (rangeduri2 == null)
            {
                rangeduri1 = rangeduri;
            }
        }
        return new InitializationChunk(datasource, new DataSpec(rangeduri1.getUri(), rangeduri1.start, rangeduri1.length, representation.getCacheKey()), i, representation.format, chunkextractorwrapper);
    }

    private Chunk newMediaChunk(RepresentationHolder representationholder, DataSource datasource, int i, int j)
    {
        Representation representation = representationholder.representation;
        Object obj = representationholder.segmentIndex;
        long l = ((DashSegmentIndex) (obj)).getTimeUs(i);
        long l1 = l + ((DashSegmentIndex) (obj)).getDurationUs(i);
        int k = i + representationholder.segmentNumShift;
        long l2;
        boolean flag;
        if (!currentManifest.dynamic && i == ((DashSegmentIndex) (obj)).getLastSegmentNum())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = ((DashSegmentIndex) (obj)).getSegmentUrl(i);
        obj = new DataSpec(((RangedUri) (obj)).getUri(), ((RangedUri) (obj)).start, ((RangedUri) (obj)).length, representation.getCacheKey());
        l2 = representation.periodStartMs * 1000L - representation.presentationTimeOffsetUs;
        if (representation.format.mimeType.equals("text/vtt"))
        {
            if (representationholder.vttHeaderOffsetUs != l2)
            {
                headerBuilder.setLength(0);
                headerBuilder.append("EXO-HEADER").append("=").append("OFFSET:").append(l2).append("\n");
                representationholder.vttHeader = headerBuilder.toString().getBytes();
                representationholder.vttHeaderOffsetUs = l2;
            }
            return new SingleSampleMediaChunk(datasource, ((DataSpec) (obj)), 1, representation.format, l, l1, k, flag, MediaFormat.createTextFormat("text/vtt"), null, representationholder.vttHeader);
        } else
        {
            return new ContainerMediaChunk(datasource, ((DataSpec) (obj)), j, representation.format, l, l1, k, flag, l2, representationholder.extractorWrapper, representationholder.format, drmInitData, true);
        }
    }

    private void notifySeekRangeChanged(final TimeRange seekRange)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new Runnable() {

                final DashChunkSource this$0;
                final TimeRange val$seekRange;

                public void run()
                {
                    eventListener.onSeekRangeChanged(seekRange);
                }

            
            {
                this$0 = DashChunkSource.this;
                seekRange = timerange;
                super();
            }
            });
        }
    }

    private void updateAvailableSegmentBounds(DashSegmentIndex dashsegmentindex, long l)
    {
        int j = dashsegmentindex.getFirstSegmentNum();
        int i1 = dashsegmentindex.getLastSegmentNum();
        int i = j;
        int k = i1;
        if (i1 == -1)
        {
            l -= currentManifest.availabilityStartTime * 1000L;
            i = j;
            if (currentManifest.timeShiftBufferDepth != -1L)
            {
                i = Math.max(j, dashsegmentindex.getSegmentNum(l - currentManifest.timeShiftBufferDepth * 1000L));
            }
            k = dashsegmentindex.getSegmentNum(l) - 1;
        }
        firstAvailableSegmentNum = i;
        lastAvailableSegmentNum = k;
    }

    private void updateSeekRange(DashSegmentIndex dashsegmentindex, long l)
    {
        long l1;
        long l3;
        l3 = dashsegmentindex.getTimeUs(firstAvailableSegmentNum);
        l1 = dashsegmentindex.getTimeUs(lastAvailableSegmentNum) + dashsegmentindex.getDurationUs(lastAvailableSegmentNum);
        if (!currentManifest.dynamic) goto _L2; else goto _L1
_L1:
        if (dashsegmentindex.getLastSegmentNum() != -1) goto _L4; else goto _L3
_L3:
        l1 = l - currentManifest.availabilityStartTime * 1000L;
_L6:
        l1 = Math.max(l3, l1 - liveEdgeLatencyUs);
_L2:
        dashsegmentindex = new TimeRange(0, l3, l1);
        if (seekRange == null || !seekRange.equals(dashsegmentindex))
        {
            seekRange = dashsegmentindex;
            notifySeekRangeChanged(seekRange);
        }
        return;
_L4:
        long l2 = dashsegmentindex.getTimeUs(dashsegmentindex.getLastSegmentNum()) + dashsegmentindex.getDurationUs(dashsegmentindex.getLastSegmentNum());
        l1 = l2;
        if (!dashsegmentindex.isExplicit())
        {
            l1 = Math.min(l2, l - currentManifest.availabilityStartTime * 1000L);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void continueBuffering(long l)
    {
        if (manifestFetcher != null && currentManifest.dynamic && fatalError == null)
        {
            MediaPresentationDescription mediapresentationdescription = (MediaPresentationDescription)manifestFetcher.getManifest();
            if (currentManifest != mediapresentationdescription && mediapresentationdescription != null)
            {
                Representation arepresentation[] = getFilteredRepresentations(mediapresentationdescription, adaptationSetIndex, representationIndices);
                int k = arepresentation.length;
                int i = 0;
                while (i < k) 
                {
                    Object obj = arepresentation[i];
                    RepresentationHolder representationholder = (RepresentationHolder)representationHolders.get(((Representation) (obj)).format.id);
                    DashSegmentIndex dashsegmentindex = representationholder.segmentIndex;
                    int j = dashsegmentindex.getLastSegmentNum();
                    l = dashsegmentindex.getTimeUs(j) + dashsegmentindex.getDurationUs(j);
                    obj = ((Representation) (obj)).getIndex();
                    j = ((DashSegmentIndex) (obj)).getFirstSegmentNum();
                    long l1 = ((DashSegmentIndex) (obj)).getTimeUs(j);
                    if (l < l1)
                    {
                        fatalError = new BehindLiveWindowException();
                        return;
                    }
                    if (l == l1)
                    {
                        j = (dashsegmentindex.getLastSegmentNum() + 1) - j;
                    } else
                    {
                        j = dashsegmentindex.getSegmentNum(l1) - j;
                    }
                    representationholder.segmentNumShift = representationholder.segmentNumShift + j;
                    representationholder.segmentIndex = ((DashSegmentIndex) (obj));
                    i++;
                }
                currentManifest = mediapresentationdescription;
                finishedCurrentManifest = false;
                l = getNowUs();
                updateAvailableSegmentBounds(arepresentation[0].getIndex(), l);
                updateSeekRange(arepresentation[0].getIndex(), l);
            }
            long l2 = currentManifest.minUpdatePeriod;
            l = l2;
            if (l2 == 0L)
            {
                l = 5000L;
            }
            if (finishedCurrentManifest && android.os.SystemClock.elapsedRealtime() > manifestFetcher.getManifestLoadStartTimestamp() + l)
            {
                manifestFetcher.requestRefresh();
                return;
            }
        }
    }

    public void disable(List list)
    {
        formatEvaluator.disable();
        if (manifestFetcher != null)
        {
            manifestFetcher.disable();
        }
        seekRange = null;
    }

    public void enable()
    {
        fatalError = null;
        formatEvaluator.enable();
        if (manifestFetcher != null)
        {
            manifestFetcher.enable();
        }
        DashSegmentIndex dashsegmentindex = ((RepresentationHolder)representationHolders.get(formats[0].id)).representation.getIndex();
        if (dashsegmentindex == null)
        {
            seekRange = new TimeRange(0, 0L, currentManifest.duration * 1000L);
            notifySeekRangeChanged(seekRange);
            return;
        } else
        {
            long l = getNowUs();
            updateAvailableSegmentBounds(dashsegmentindex, l);
            updateSeekRange(dashsegmentindex, l);
            return;
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
            if (evaluation.format == null || !lastChunkWasInitialization)
            {
                formatEvaluator.evaluate(list, l1, formats, evaluation);
            }
            Object obj = evaluation.format;
            chunkoperationholder.queueSize = evaluation.queueSize;
            if (obj == null)
            {
                chunkoperationholder.chunk = null;
                return;
            }
            if (chunkoperationholder.queueSize != list.size() || chunkoperationholder.chunk == null || !chunkoperationholder.chunk.format.equals(obj))
            {
                chunkoperationholder.chunk = null;
                RepresentationHolder representationholder = (RepresentationHolder)representationHolders.get(((Format) (obj)).id);
                Representation representation = representationholder.representation;
                DashSegmentIndex dashsegmentindex = representationholder.segmentIndex;
                ChunkExtractorWrapper chunkextractorwrapper = representationholder.extractorWrapper;
                obj = null;
                RangedUri rangeduri = null;
                if (representationholder.format == null)
                {
                    obj = representation.getInitializationUri();
                }
                if (dashsegmentindex == null)
                {
                    rangeduri = representation.getIndexUri();
                }
                if (obj != null || rangeduri != null)
                {
                    list = newInitializationChunk(((RangedUri) (obj)), rangeduri, representation, chunkextractorwrapper, dataSource, evaluation.trigger);
                    lastChunkWasInitialization = true;
                    chunkoperationholder.chunk = list;
                    return;
                }
                int j;
                boolean flag;
                if (dashsegmentindex.getLastSegmentNum() == -1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    l1 = getNowUs();
                    int i = firstAvailableSegmentNum;
                    int k = lastAvailableSegmentNum;
                    updateAvailableSegmentBounds(dashsegmentindex, l1);
                    if (i != firstAvailableSegmentNum || k != lastAvailableSegmentNum)
                    {
                        updateSeekRange(dashsegmentindex, l1);
                    }
                }
                if (list.isEmpty())
                {
                    l1 = l;
                    if (currentManifest.dynamic)
                    {
                        seekRangeValues = seekRange.getCurrentBoundsUs(seekRangeValues);
                        int i1;
                        if (startAtLiveEdge)
                        {
                            startAtLiveEdge = false;
                            l1 = seekRangeValues[1];
                        } else
                        {
                            l1 = Math.min(Math.max(l, seekRangeValues[0]), seekRangeValues[1]);
                        }
                    }
                    i1 = dashsegmentindex.getSegmentNum(l1);
                    j = i1;
                    if (flag)
                    {
                        j = Math.min(i1, lastAvailableSegmentNum);
                    }
                } else
                {
                    list = (MediaChunk)list.get(chunkoperationholder.queueSize - 1);
                    if (((MediaChunk) (list)).isLastChunk)
                    {
                        j = -1;
                    } else
                    {
                        j = (((MediaChunk) (list)).chunkIndex + 1) - representationholder.segmentNumShift;
                    }
                }
                if (currentManifest.dynamic)
                {
                    if (j < firstAvailableSegmentNum)
                    {
                        fatalError = new BehindLiveWindowException();
                        return;
                    }
                    if (j > lastAvailableSegmentNum)
                    {
                        boolean flag1;
                        if (!flag)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        finishedCurrentManifest = flag1;
                        return;
                    }
                    if (!flag && j == lastAvailableSegmentNum)
                    {
                        finishedCurrentManifest = true;
                    }
                }
                if (j != -1)
                {
                    list = newMediaChunk(representationholder, dataSource, j, evaluation.trigger);
                    lastChunkWasInitialization = false;
                    chunkoperationholder.chunk = list;
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

    TimeRange getSeekRange()
    {
        return seekRange;
    }

    public final TrackInfo getTrackInfo()
    {
        return trackInfo;
    }

    public void maybeThrowError()
        throws IOException
    {
        if (fatalError != null)
        {
            throw fatalError;
        }
        if (manifestFetcher != null)
        {
            manifestFetcher.maybeThrowError();
        }
    }

    public void onChunkLoadCompleted(Chunk chunk)
    {
        if (chunk instanceof InitializationChunk)
        {
            chunk = (InitializationChunk)chunk;
            Object obj = ((InitializationChunk) (chunk)).format.id;
            obj = (RepresentationHolder)representationHolders.get(obj);
            if (chunk.hasFormat())
            {
                obj.format = chunk.getFormat();
            }
            if (chunk.hasSeekMap())
            {
                obj.segmentIndex = new DashWrappingSegmentIndex((ChunkIndex)chunk.getSeekMap(), ((InitializationChunk) (chunk)).dataSpec.uri.toString(), ((RepresentationHolder) (obj)).representation.periodStartMs * 1000L);
            }
            if (drmInitData == null && chunk.hasDrmInitData())
            {
                drmInitData = chunk.getDrmInitData();
            }
        }
    }

    public void onChunkLoadError(Chunk chunk, Exception exception)
    {
    }

}
