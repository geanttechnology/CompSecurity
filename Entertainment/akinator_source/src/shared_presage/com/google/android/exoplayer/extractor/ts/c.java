// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.ts;

import shared_presage.com.google.android.exoplayer.extractor.TrackOutput;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;

abstract class c
{

    protected final TrackOutput a;

    protected c(TrackOutput trackoutput)
    {
        a = trackoutput;
    }

    public abstract void a();

    public abstract void a(ParsableByteArray parsablebytearray, long l, boolean flag);

    public abstract void b();
}
