// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import android.net.Uri;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.FormatWrapper;
import com.google.android.exoplayer.dash.DashSegmentIndex;

// Referenced classes of package com.google.android.exoplayer.dash.mpd:
//            SegmentBase, RangedUri, DashSingleSegmentIndex

public abstract class Representation
    implements FormatWrapper
{
    public static class MultiSegmentRepresentation extends Representation
        implements DashSegmentIndex
    {

        private final SegmentBase.MultiSegmentBase segmentBase;

        public long getDurationUs(int i)
        {
            return segmentBase.getSegmentDurationUs(i);
        }

        public int getFirstSegmentNum()
        {
            return segmentBase.getFirstSegmentNum();
        }

        public DashSegmentIndex getIndex()
        {
            return this;
        }

        public RangedUri getIndexUri()
        {
            return null;
        }

        public int getLastSegmentNum()
        {
            return segmentBase.getLastSegmentNum();
        }

        public int getSegmentNum(long l)
        {
            return segmentBase.getSegmentNum(l - periodStartMs * 1000L);
        }

        public RangedUri getSegmentUrl(int i)
        {
            return segmentBase.getSegmentUrl(this, i);
        }

        public long getTimeUs(int i)
        {
            return segmentBase.getSegmentTimeUs(i) + periodStartMs * 1000L;
        }

        public boolean isExplicit()
        {
            return segmentBase.isExplicit();
        }

        public MultiSegmentRepresentation(long l, long l1, String s, long l2, 
                Format format1, SegmentBase.MultiSegmentBase multisegmentbase)
        {
            super(l, l1, s, l2, format1, multisegmentbase, null);
            segmentBase = multisegmentbase;
        }
    }

    public static class SingleSegmentRepresentation extends Representation
    {

        public final long contentLength;
        private final RangedUri indexUri;
        private final DashSingleSegmentIndex segmentIndex;
        public final Uri uri;

        public static SingleSegmentRepresentation newInstance(long l, long l1, String s, long l2, Format format1, 
                String s1, long l3, long l4, long l5, 
                long l6, long l7)
        {
            return new SingleSegmentRepresentation(l, l1, s, l2, format1, new SegmentBase.SingleSegmentBase(new RangedUri(s1, null, l3, 1L + (l4 - l3)), 1L, 0L, s1, l5, (l6 - l5) + 1L), l7);
        }

        public DashSegmentIndex getIndex()
        {
            return segmentIndex;
        }

        public RangedUri getIndexUri()
        {
            return indexUri;
        }

        public SingleSegmentRepresentation(long l, long l1, String s, long l2, 
                Format format1, SegmentBase.SingleSegmentBase singlesegmentbase, long l3)
        {
            super(l, l1, s, l2, format1, singlesegmentbase, null);
            uri = Uri.parse(singlesegmentbase.uri);
            indexUri = singlesegmentbase.getIndex();
            contentLength = l3;
            if (indexUri != null)
            {
                s = null;
            } else
            {
                s = new DashSingleSegmentIndex(l * 1000L, l1 * 1000L, new RangedUri(singlesegmentbase.uri, null, 0L, -1L));
            }
            segmentIndex = s;
        }
    }


    public final String contentId;
    public final Format format;
    private final RangedUri initializationUri;
    public final long periodDurationMs;
    public final long periodStartMs;
    public final long presentationTimeOffsetUs;
    public final long revisionId;

    private Representation(long l, long l1, String s, long l2, 
            Format format1, SegmentBase segmentbase)
    {
        periodStartMs = l;
        periodDurationMs = l1;
        contentId = s;
        revisionId = l2;
        format = format1;
        initializationUri = segmentbase.getInitialization(this);
        presentationTimeOffsetUs = segmentbase.getPresentationTimeOffsetUs();
    }

    Representation(long l, long l1, String s, long l2, 
            Format format1, SegmentBase segmentbase, _cls1 _pcls1)
    {
        this(l, l1, s, l2, format1, segmentbase);
    }

    public static Representation newInstance(long l, long l1, String s, long l2, Format format1, 
            SegmentBase segmentbase)
    {
        if (segmentbase instanceof SegmentBase.SingleSegmentBase)
        {
            return new SingleSegmentRepresentation(l, l1, s, l2, format1, (SegmentBase.SingleSegmentBase)segmentbase, -1L);
        }
        if (segmentbase instanceof SegmentBase.MultiSegmentBase)
        {
            return new MultiSegmentRepresentation(l, l1, s, l2, format1, (SegmentBase.MultiSegmentBase)segmentbase);
        } else
        {
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
    }

    public String getCacheKey()
    {
        return (new StringBuilder()).append(contentId).append(".").append(format.id).append(".").append(revisionId).toString();
    }

    public Format getFormat()
    {
        return format;
    }

    public abstract DashSegmentIndex getIndex();

    public abstract RangedUri getIndexUri();

    public RangedUri getInitializationUri()
    {
        return initializationUri;
    }
}
