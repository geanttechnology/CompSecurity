// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.okio.BufferedSink;
import com.squareup.okhttp.internal.okio.BufferedSource;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameReader, FrameWriter

interface Variant
{

    public abstract Protocol getProtocol();

    public abstract int maxFrameSize();

    public abstract FrameReader newReader(BufferedSource bufferedsource, boolean flag);

    public abstract FrameWriter newWriter(BufferedSink bufferedsink, boolean flag);
}
