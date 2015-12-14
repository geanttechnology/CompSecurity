// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.chunk;

import java.io.IOException;

// Referenced classes of package com.google.android.exoplayer.chunk:
//            Format

public interface BaseChunkSampleSourceEventListener
{

    public abstract void onDownstreamFormatChanged(int i, Format format, int j, int k);

    public abstract void onLoadCanceled(int i, long l);

    public abstract void onLoadCompleted(int i, long l, int j, int k, Format format, int i1, 
            int j1, long l1, long l2);

    public abstract void onLoadError(int i, IOException ioexception);

    public abstract void onLoadStarted(int i, long l, int j, int k, Format format, int i1, 
            int j1);

    public abstract void onUpstreamDiscarded(int i, int j, int k);
}
