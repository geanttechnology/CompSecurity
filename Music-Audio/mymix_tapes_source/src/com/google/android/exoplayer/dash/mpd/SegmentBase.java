// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.util.Util;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            RangedUri, Representation, UrlTemplate

public abstract class SegmentBase
{
    public static abstract class MultiSegmentBase extends SegmentBase
    {

        final long duration;
        final long periodDurationMs;
        final List segmentTimeline;
        final int startNumber;

        public int getFirstSegmentNum()
        {
            return startNumber;
        }

        public abstract int getLastSegmentNum();

        public final long getSegmentDurationUs(int i)
        {
            if (segmentTimeline != null)
            {
                return (((SegmentTimelineElement)segmentTimeline.get(i - startNumber)).duration * 0xf4240L) / timescale;
            }
            if (i == getLastSegmentNum())
            {
                return periodDurationMs * 1000L - getSegmentTimeUs(i);
            } else
            {
                return (duration * 0xf4240L) / timescale;
            }
        }

        public int getSegmentNum(long l)
        {
            int i;
            int j;
            int k;
            int j1;
            int k1;
            j1 = getFirstSegmentNum();
            k = j1;
            k1 = getLastSegmentNum();
            i = k1;
            j = k;
            if (segmentTimeline != null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            long l1 = (duration * 0xf4240L) / timescale;
            j = startNumber + (int)(l / l1);
            if (j >= k) goto _L2; else goto _L1
_L1:
            i = k;
_L4:
            return i;
_L2:
            i = j;
            if (k1 == -1) goto _L4; else goto _L3
_L3:
            i = j;
            if (j <= k1) goto _L4; else goto _L5
_L5:
            return k1;
            while (j <= i) 
            {
                int i1 = (j + i) / 2;
                long l2 = getSegmentTimeUs(i1);
                if (l2 < l)
                {
                    j = i1 + 1;
                } else
                if (l2 > l)
                {
                    i = i1 - 1;
                } else
                {
                    return i1;
                }
            }
            if (j != j1)
            {
                j = i;
            }
            return j;
        }

        public final long getSegmentTimeUs(int i)
        {
            long l;
            if (segmentTimeline != null)
            {
                l = ((SegmentTimelineElement)segmentTimeline.get(i - startNumber)).startTime - presentationTimeOffset;
            } else
            {
                l = (long)(i - startNumber) * duration;
            }
            return Util.scaleLargeTimestamp(l, 0xf4240L, timescale);
        }

        public abstract RangedUri getSegmentUrl(Representation representation, int i);

        public boolean isExplicit()
        {
            return segmentTimeline != null;
        }

        public MultiSegmentBase(RangedUri rangeduri, long l, long l1, long l2, 
                int i, long l3, List list)
        {
            super(rangeduri, l, l1);
            periodDurationMs = l2;
            startNumber = i;
            duration = l3;
            segmentTimeline = list;
        }
    }

    public static class SegmentList extends MultiSegmentBase
    {

        final List mediaSegments;

        public int getLastSegmentNum()
        {
            return (startNumber + mediaSegments.size()) - 1;
        }

        public RangedUri getSegmentUrl(Representation representation, int i)
        {
            return (RangedUri)mediaSegments.get(i - startNumber);
        }

        public boolean isExplicit()
        {
            return true;
        }

        public SegmentList(RangedUri rangeduri, long l, long l1, long l2, 
                int i, long l3, List list, List list1)
        {
            super(rangeduri, l, l1, l2, i, l3, list);
            mediaSegments = list1;
        }
    }

    public static class SegmentTemplate extends MultiSegmentBase
    {

        private final String baseUrl;
        final UrlTemplate initializationTemplate;
        final UrlTemplate mediaTemplate;

        public RangedUri getInitialization(Representation representation)
        {
            if (initializationTemplate != null)
            {
                representation = initializationTemplate.buildUri(representation.format.id, 0, representation.format.bitrate, 0L);
                return new RangedUri(baseUrl, representation, 0L, -1L);
            } else
            {
                return super.getInitialization(representation);
            }
        }

        public int getLastSegmentNum()
        {
            if (segmentTimeline != null)
            {
                return (segmentTimeline.size() + startNumber) - 1;
            }
            if (periodDurationMs == -1L)
            {
                return -1;
            } else
            {
                long l = (duration * 1000L) / timescale;
                return (startNumber + (int)Util.ceilDivide(periodDurationMs, l)) - 1;
            }
        }

        public RangedUri getSegmentUrl(Representation representation, int i)
        {
            long l;
            if (segmentTimeline != null)
            {
                l = ((SegmentTimelineElement)segmentTimeline.get(i - startNumber)).startTime;
            } else
            {
                l = (long)(i - startNumber) * duration;
            }
            representation = mediaTemplate.buildUri(representation.format.id, i, representation.format.bitrate, l);
            return new RangedUri(baseUrl, representation, 0L, -1L);
        }

        public SegmentTemplate(RangedUri rangeduri, long l, long l1, long l2, 
                int i, long l3, List list, UrlTemplate urltemplate, UrlTemplate urltemplate1, String s)
        {
            super(rangeduri, l, l1, l2, i, l3, list);
            initializationTemplate = urltemplate;
            mediaTemplate = urltemplate1;
            baseUrl = s;
        }
    }

    public static class SegmentTimelineElement
    {

        long duration;
        long startTime;

        public SegmentTimelineElement(long l, long l1)
        {
            startTime = l;
            duration = l1;
        }
    }

    public static class SingleSegmentBase extends SegmentBase
    {

        final long indexLength;
        final long indexStart;
        public final String uri;

        public RangedUri getIndex()
        {
            if (indexLength <= 0L)
            {
                return null;
            } else
            {
                return new RangedUri(uri, null, indexStart, indexLength);
            }
        }

        public SingleSegmentBase(RangedUri rangeduri, long l, long l1, String s, long l2, long l3)
        {
            super(rangeduri, l, l1);
            uri = s;
            indexStart = l2;
            indexLength = l3;
        }

        public SingleSegmentBase(String s)
        {
            this(null, 1L, 0L, s, 0L, -1L);
        }
    }


    final RangedUri initialization;
    final long presentationTimeOffset;
    final long timescale;

    public SegmentBase(RangedUri rangeduri, long l, long l1)
    {
        initialization = rangeduri;
        timescale = l;
        presentationTimeOffset = l1;
    }

    public RangedUri getInitialization(Representation representation)
    {
        return initialization;
    }

    public long getPresentationTimeOffsetUs()
    {
        return Util.scaleLargeTimestamp(presentationTimeOffset, 0xf4240L, timescale);
    }
}
