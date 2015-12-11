// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash.mpd;


// Referenced classes of package shared_presage.com.google.android.exoplayer.dash.mpd:
//            SegmentBase, RangedUri

public static class indexLength extends SegmentBase
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

    public (String s)
    {
        this(null, 1L, 0L, s, 0L, -1L);
    }

    public <init>(RangedUri rangeduri, long l, long l1, String s, long l2, long l3)
    {
        super(rangeduri, l, l1);
        uri = s;
        indexStart = l2;
        indexLength = l3;
    }
}
