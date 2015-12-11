// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import shared_presage.com.google.android.exoplayer.drm.DrmInitData;
import shared_presage.com.google.android.exoplayer.extractor.SeekMap;
import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            ChunkExtractorWrapper

public static interface 
    extends TrackOutput
{

    public abstract void drmInitData(DrmInitData drminitdata);

    public abstract void seekMap(SeekMap seekmap);
}
